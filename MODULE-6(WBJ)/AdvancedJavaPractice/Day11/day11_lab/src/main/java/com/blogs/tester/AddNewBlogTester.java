package com.blogs.tester;
import org.hibernate.SessionFactory;


import com.blogs.dao.BlogPostDao;
import com.blogs.dao.BlogPostDaoImpl;
import com.blogs.pojos.BlogPost;
import com.blogs.utils.HibernateUtils;

import java.util.Scanner;

public class AddNewBlogTester {

    public static void main(String[] args) {
        // Using try-with-resources for the Scanner and SessionFactory
        try (Scanner scanner = new Scanner(System.in); 
             SessionFactory sessionFactory = HibernateUtils.getFactory()) {

            // Initialize BlogPostDao
            BlogPostDao blogPostDao = new BlogPostDaoImpl();

            // Prompt for necessary inputs
            System.out.println("Enter category ID (for the blog post): ");
            Long categoryId = scanner.nextLong();

            System.out.println("Enter blogger (user) ID: ");
            Long bloggerId = scanner.nextLong();

            // Create a new BlogPost object
            BlogPost blogPost = new BlogPost();
            scanner.nextLine(); // consume newline left over from nextLong()
            System.out.println("Enter blog title: ");
            blogPost.setTitle(scanner.nextLine());

            System.out.println("Enter blog content: ");
            blogPost.setContent(scanner.nextLine());

            // Call the addNewBlog method
            String resultMessage = blogPostDao.addNewBlog(blogPost, categoryId, bloggerId);

            // Print result message
            System.out.println(resultMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



