package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;


import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;

import com.blogs.pojos.UserRole;

public class GetLastNamesOfUsersByRole {

	public static void main(String[] args) {
		/*
		 * Create main(..) based Tester class to test the creation of SF SF -->
		 * represents DBCP => hibernate frmwork is up n running !
		 */
		try (Scanner sc=new Scanner(System.in);
				SessionFactory sf = getFactory()) {
			// create dao instance
			UserDao userDao = new UserDaoImpl();	
			System.out.println("Enter user role");
			// invoke dao's method
			userDao
			.getLastNamesByRole(UserRole.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);//lastName -> sop(lastName)
		} // JVM - sf.close() => DBCP is cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
