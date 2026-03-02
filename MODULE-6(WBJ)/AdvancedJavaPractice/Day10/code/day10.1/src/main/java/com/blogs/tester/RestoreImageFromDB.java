package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;


import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;


public class RestoreImageFromDB {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); //class loading --> static init block ->SF
				Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			UserDao userDao = new UserDaoImpl();
			System.out.println("Enter bin file name , to store the image");
			String fileName=sc.nextLine();
			System.out.println("Enter user id");		
			
			// invoke dao's method
			System.out.println(userDao.restoreImage(fileName,sc.nextLong()));
					

		} // JVM - sf.close() -> DBCP cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
