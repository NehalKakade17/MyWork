package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;


import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;


public class GetUserDetails {

	public static void main(String[] args) {
		/*
		 * Create main(..) based Tester class to test the creation of SF SF -->
		 * represents DBCP => hibernate frmwork is up n running !
		 */
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao userDao = new UserDaoImpl();
			System.out.println("Enter user id , to get details");
			// invoke dao's method
			System.out.println(userDao.getUserDetails(sc.nextLong()));
		} // JVM - sf.close() => DBCP is cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
