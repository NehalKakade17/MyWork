package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;
import com.blogs.entities.UserRole;

public class TestJPQLCtorExpression {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); //class loading --> static init block ->SF
				Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			UserDao userDao = new UserDaoImpl();
			System.out.println("Enter user role");
			
			// invoke dao's method
			userDao.testCtorExpression(
					UserRole.valueOf(sc.next().toUpperCase()))
					.forEach(user-> System.out.println(user.getFirstName()
							+" "+user.getLastName()+" "+user.getDob()) );// u -> sop(u.getfn , getln,getdob);

		} // JVM - sf.close() -> DBCP cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
