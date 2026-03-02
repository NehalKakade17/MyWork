package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.CommentDao;
import com.blogs.dao.CommentDaoImpl;
import com.blogs.pojos.Comment;

public class GetCommentsByPostTitle {

    public static void main(String[] args) {
        try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
            // Create CommentDao instance
            CommentDao dao = new CommentDaoImpl();

            // Prompt the user to enter the post title
            System.out.println("Enter post title to list its comments:");
            String postTitle = sc.nextLine();  // Allow spaces in the title

            // Fetch and print all comments for the given post title
            System.out.println("All comments for the given post title:");
            List<Comment> comments = dao.getCommentsByPost(postTitle);
            if (comments.isEmpty()) {
                System.out.println("No comments found for the given post title.");
            } else {
                comments.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while fetching comments. Please try again.");
            e.printStackTrace();  // Or log this to a file
        }
    }
}


