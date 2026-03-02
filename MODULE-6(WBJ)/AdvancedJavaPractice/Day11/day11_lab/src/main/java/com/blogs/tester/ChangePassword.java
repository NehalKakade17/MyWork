package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;


import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;


public class ChangePassword {

	public static void main(String[] args) {
		/*
		 * 6. Change password 
		 * i/p - email , password , new password 
		 * o/p - a message
		 * 
		 */
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			UserDao userDao = new UserDaoImpl();
			System.out.println("Enter user email , old pwd n new pwd");
			// invoke dao's method
			System.out.println(userDao.changePassword(sc.next(),sc.next(),sc.next()));
																					
			
		} // JVM - sf.close() => DBCP is cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
