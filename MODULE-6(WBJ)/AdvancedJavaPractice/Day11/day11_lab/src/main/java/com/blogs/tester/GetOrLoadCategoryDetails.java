package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.CategoryDao;
import com.blogs.dao.CategoryDaoImpl;
import com.blogs.pojos.Category;

public class GetOrLoadCategoryDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// create category dao instance
			CategoryDao dao = new CategoryDaoImpl();

			System.out.println("Enter category name to search");
			Category category = dao.getCategoryDetails(sc.next());
			System.out.println(category);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
