package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;


public class ApplyDiscount {

	public static void main(String[] args) {
		/*
		 * 7. Apply discount to all users born before specified date
			i/p - date n discount
			o/p - message

		 */
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao userDao = new UserDaoImpl();
			System.out.println("Enter date n discount");
			// invoke dao's method
			System.out.println(userDao.
					applyDiscount(LocalDate.parse(sc.next()),sc.nextDouble()));
		} // JVM - sf.close() => DBCP is cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
