package com.blogs.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.blogs.pojos.User;
import com.blogs.pojos.UserRole;

public interface UserDao {
//add a method to save new user details
	String registerUser(User newUser);

	// add a method to get user details by id
	User getUserDetails(Long userId);

	// add a method to get all users' details
	List<User> getAllUserDetails();

	// add a method to get users' details selected by role n date
	List<User> getUserDetailsByRoleAndDate(UserRole role, LocalDate date);

	// add a method to get users' last names selected by role
	List<String> getLastNamesByRole(UserRole role);

//add a method to get projection (=selected columns from DB)
	List<User> getDetailsByRole(UserRole role);

	// add a method to change password
	String changePassword(String email, String oldPassword, String newPass);

	// add a method for bulk updation
	String applyDiscount(LocalDate date, double discount);

//delete user details
	String deleteUserDetails(Long userId);

	String saveUserImage(String filePath, Long userId) throws IOException;

	String restoreUserImage(String filePath, Long userId) throws IOException;
	List<User> getUserNamesByCity(String city);
}
