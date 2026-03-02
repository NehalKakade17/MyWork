package com.cdac.dao;

import java.sql.SQLException;
import java.util.List;

import com.cdac.pojos.User;

public interface UserDao {
//add a method to fetch user details by role
	List<User>   fetchUserDetailsByRole(String role) throws SQLException;
	//add a method for user authentication
	User authenticateUser(String email,String password) throws SQLException;
	//add a method to update voting status
	String updateVotingStatus(int voterId) throws SQLException;
	//add a method to clean up DB resources;
	void cleanUp() throws SQLException;
}
