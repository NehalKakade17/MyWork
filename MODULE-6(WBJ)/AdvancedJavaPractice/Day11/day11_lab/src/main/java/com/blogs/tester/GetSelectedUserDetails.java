package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;

import com.blogs.pojos.UserRole;

public class GetSelectedUserDetails {

	public static void main(String[] args) {
		/*
		 * Create main(..) based Tester class to test the creation of SF SF -->
		 * represents DBCP => hibernate frmwork is up n running !
		 */
		try (Scanner sc=new Scanner(System.in);
				SessionFactory sf = getFactory()) {
			// create dao instance
			UserDao userDao = new UserDaoImpl();	
			System.out.println("Enter user role n date");
			// invoke dao's method
			userDao
			.getUserDetailsByRoleAndDate(UserRole.valueOf(sc.next().toUpperCase()),
					LocalDate.parse(sc.next()))
			.forEach(System.out::println);//u -> sop(u)
		} // JVM - sf.close() => DBCP is cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
