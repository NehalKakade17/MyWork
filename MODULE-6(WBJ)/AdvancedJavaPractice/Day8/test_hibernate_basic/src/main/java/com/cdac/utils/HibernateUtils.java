package com.cdac.utils;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		System.out.println("in static init block");
		/*
		 * create Configuration object - def ctor
		 * configure() - to load properties 
		 * build SF
		 */
		factory=new Configuration() //empty config
				.configure() //populated config
				.buildSessionFactory(); //SF => DBCP
	}
	//getter
	public static SessionFactory getFactory() {
		return factory;
	}
	

}
