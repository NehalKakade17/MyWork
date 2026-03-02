package com.blogs.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import com.blogs.pojos.BlogPost;
import com.blogs.pojos.Comment;

public class HibernateUtils {
	private static SessionFactory factory;
	/*
	 * to ensure singleton instance of the SF(SessionFactory)
	 * , create it from static init block
	 */
	static {
		System.out.println("in static init block");
		/*
		 * Create empty Configuration object .
		 * Populate it with hibernate properties using : configure()
		 * Build SF from it.		 * 
		 */
		factory=new Configuration() //empty config
				.configure() // config populated with props
				.addAnnotatedClass(BlogPost.class)  // Add BlogPost class for scanning
                .addAnnotatedClass(Comment.class)  // Add Comment class for scanning
				.buildSessionFactory();
		
	}
	//getter
	public static SessionFactory getFactory() {
		return factory;
	}
}
