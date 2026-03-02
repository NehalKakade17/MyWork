package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;



import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;


public class GetAllUserDetails {

	public static void main(String[] args) {
		/*
		 * Create main(..) based Tester class to test the creation of SF SF -->
		 * represents DBCP => hibernate frmwork is up n running !
		 */
		try (SessionFactory sf = getFactory()) {
			// create dao instance
			UserDao userDao = new UserDaoImpl();			
			// invoke dao's method
			userDao
			.getAllUserDetails()
			.forEach(System.out::println);//u -> sop(u)
		} // JVM - sf.close() => DBCP is cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
