package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.CategoryDao;
import com.blogs.dao.CategoryDaoImpl;
import com.blogs.pojos.Category;

public class GetCategoryAndPostDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create category dao instance
			CategoryDao dao = new CategoryDaoImpl();			
			System.out.println("Enter category name to search");			
			Category category=dao.getCategoryAndPostDetails(sc.next());
			System.out.println(category);
			System.out.println("All posts - ");
			category.getBlogPosts().
			forEach(System.out::println);
			/*
			 * We are trying access - not yet fetched details from the DB(represented by 
			 * a proxy) , outside
			 * the session scope ---> Hibernate throws LazyInitializationException
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
