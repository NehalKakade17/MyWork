package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;
import com.blogs.entities.User;
import com.blogs.entities.UserRole;

public class RegisterNewUser {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); //class loading --> static init block ->SF
				Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			UserDao userDao = new UserDaoImpl();
			System.out.println(
					"Enter user details - firstName,  lastName,  email,  " 
			+ "password,  dob,  regAmount," + " role");
			// create user instance - TRANSIENT
			User user = new User(sc.next(), sc.next(), sc.next(), sc.next(),
					LocalDate.parse(sc.next()),
					sc.nextDouble(), UserRole.valueOf(sc.next().toUpperCase()));
			//user -TRANSIENT (not yet in L1 cache, not in db , exists  ONLY in java heap)
			// invoke dao's method
			System.out.println(userDao.registerUser(user));

		} // JVM - sf.close() -> DBCP cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
