package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;

public class GetAllUsers {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); //class loading --> static init block ->SF
				) {
			// create user dao instance
			UserDao userDao = new UserDaoImpl();	
			System.out.println("All users");
			// invoke dao's method
			userDao.getAllUserDetails().forEach(System.out::println);

		} // JVM - sf.close() -> DBCP cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
