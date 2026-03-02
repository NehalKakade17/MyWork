package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;


import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;


public class SaveImage {

	public static void main(String[] args) {
		/*
		 * Save user image in DB
i/p - user id , image file name(path)
o/p - message

		 */
		try (Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()) {
			// create dao instance
			UserDao userDao = new UserDaoImpl();
			System.out.println("Enter image file path");
			String filePath=sc.nextLine();
			System.out.println("Enter user id");
			Long userId=sc.nextLong();
			// invoke dao's method
			System.out.println(userDao.saveUserImage(filePath,userId));
																					
			
		} // JVM - sf.close() => DBCP is cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
