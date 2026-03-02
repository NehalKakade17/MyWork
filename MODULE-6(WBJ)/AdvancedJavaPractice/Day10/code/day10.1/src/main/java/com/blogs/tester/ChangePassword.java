package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;


public class ChangePassword {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); //class loading --> static init block ->SF
				Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			UserDao userDao = new UserDaoImpl();
			System.out.println("Enter email password n new password");
			
			// invoke dao's method
			System.out.println(userDao.changePassword(sc.next(),sc.next(),sc.next()));
					

		} // JVM - sf.close() -> DBCP cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
