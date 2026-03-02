package com.blogs.tester;
import static com.blogs.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;
import com.blogs.pojos.User;
import com.blogs.pojos.UserRole;

public class UserRegistration {

	public static void main(String[] args) {
		/*
		 * Create main(..) based Tester class to test the creation of SF
		 * SF --> represents DBCP
		 * => hibernate frmwork is up n running !
		 */
		try (SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in)) {
			//create dao instance
			UserDao userDao=new UserDaoImpl();
			System.out.println("Enter user details -  firstName, lastName,  email,  password, "
					+ " dob,  regAmount,role ");
			//create transient user instance
			User user1=new User(sc.next(), sc.next(), sc.next(), sc.next(),
					LocalDate.parse(sc.next()), sc.nextDouble(), 
					UserRole.valueOf(sc.next().toUpperCase()));
		//	System.out.println(user1.getId());//null
		//	user1.setUserId(5l);
			//invoke dao's method
			System.out.println(userDao.registerUser(user1));
		}//JVM - sf.close() => DBCP is cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
