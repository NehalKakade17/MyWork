package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;



public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			System.out.println("Hibernate up n running !"+sf);//F.Q cls name of the imple class
		
		}  //JVM - sf.close() -> DBCP cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
