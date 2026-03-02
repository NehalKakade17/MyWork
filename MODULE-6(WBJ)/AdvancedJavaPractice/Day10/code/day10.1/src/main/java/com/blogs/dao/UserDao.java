package com.blogs.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.blogs.entities.User;
import com.blogs.entities.UserRole;

public interface UserDao {
//add a method to register new user
	String registerUser(User newUser);

	// add a method to get user details by id
	User getUserDeatils(Long userId);

//get all users
	List<User> getAllUserDetails();

	List<User> getUserDeatilsByRoleAndDate(UserRole role, LocalDate date);

	List<String> getUserLastNamesByRole(UserRole role);

	List<User> testCtorExpression(UserRole role);

	String changePassword(String email, String oldPwd, String newPwd);

	String applyDiscount(LocalDate date, double discount);

	String deleteUserDetails(Long userId);

	String saveImage(String fileName, Long userId) throws IOException;
	String restoreImage(String fileName, Long userId) throws IOException;

}
