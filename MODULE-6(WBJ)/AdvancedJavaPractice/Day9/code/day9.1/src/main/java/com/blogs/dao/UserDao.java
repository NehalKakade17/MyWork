package com.blogs.dao;

import java.util.List;

import com.blogs.entities.User;

public interface UserDao {
//add a method to register new user
	String registerUser(User newUser);

	// add a method to get user details by id
	User getUserDeatils(Long userId);

//get all users
	List<User> getAllUserDetails();
}
