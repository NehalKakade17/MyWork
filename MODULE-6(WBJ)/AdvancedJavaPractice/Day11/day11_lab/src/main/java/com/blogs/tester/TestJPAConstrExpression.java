package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.UserDao;
import com.blogs.dao.UserDaoImpl;

import com.blogs.pojos.UserRole;

public class TestJPAConstrExpression {

    public static void main(String[] args) {
        /*
         * Get first name, last name and dob of all users from specified role
         * i/p - role
         * o/p - list of above details
         */
        try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
            // create dao instance
            UserDao userDao = new UserDaoImpl();
            System.out.println("Enter user role");
            // invoke dao's method
            userDao.getDetailsByRole(UserRole.valueOf(sc.next().toUpperCase()))
                .forEach(user -> 
                    System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getDob())
                );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

