package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.BlogPostDao;
import com.blogs.dao.BlogPostDaoImpl;

public class RemoveBlogFromCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in)) {
			BlogPostDao dao=new BlogPostDaoImpl();
			System.out.println("Enter category name ");			
			String catName=sc.nextLine();
			System.out.println("Enter post title ");			
			String postTitle=sc.nextLine();
			System.out.println(dao.removeBlog(catName,postTitle));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
