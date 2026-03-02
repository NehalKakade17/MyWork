package com.cdac.dao;

import java.sql.SQLException;
import java.util.List;

import com.cdac.pojos.User;

public interface UserDao {
//add a method to fetch user details by role
	List<User>   fetchUserDetailsByRole(String role) throws SQLException;
	//add a method for voter registration
	String registerVoter(User newVoter) throws SQLException;
	//add a method to clean up DB resources;
	String changePassword(String email, String newPassword) throws SQLException;
	String deleteUser(String email) throws SQLException;
	String signIn(String email, String password) throws SQLException;
	void cleanUp() throws SQLException;
	
}
