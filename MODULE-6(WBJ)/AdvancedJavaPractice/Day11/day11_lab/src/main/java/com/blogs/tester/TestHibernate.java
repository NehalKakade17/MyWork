package com.blogs.tester;
import static com.blogs.utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		/*
		 * Create main(..) based Tester class to test the creation of SF
		 * SF --> represents DBCP
		 * => hibernate frmwork is up n running !
		 */
		try (SessionFactory sf=getFactory()) {
			System.out.println("SF created "+sf);
		}//JVM - sf.close() => DBCP is cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
