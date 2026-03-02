package com.cdac.tester;

import java.util.Scanner;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;

public class TestLayeredApplication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// 1. create DAO instance
			UserDao userDao = new UserDaoImpl();
			boolean exit = false;
			while (!exit) {
				System.out.println("Options - 1. Fetch Users By Role\n" + "0. Exit");
				System.out.println("Choose Option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter role name");
						userDao.fetchUserDetailsByRole(sc.next())
						.forEach(System.out::println);
						break;

					case 0:
						exit = true;
						userDao.cleanUp();
						break;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
