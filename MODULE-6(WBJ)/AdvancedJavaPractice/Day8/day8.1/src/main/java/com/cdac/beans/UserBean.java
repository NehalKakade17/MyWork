package com.cdac.beans;

import java.sql.SQLException;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.User;

public class UserBean {
	// state
	private String email;
	private String password;
	// dependency
	private UserDao userDao;
	// store validated user details
	private User userDetails;
	// status mesg
	private String message;

	public UserBean() throws SQLException {
		// create dao instance
		userDao = new UserDaoImpl();
		System.out.println("user bean created !");
	}

	// setters n getters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// B.L method for authentication + authorization
	// Rets name of the JSP(view layer) to be navigated
	public String validateUser() throws SQLException {
		System.out.println("in validate user " + email + " " + password);// not null !
		// invoke dao's method for DAL (data access logic)
		userDetails = userDao.authenticateUser(email, password);
		if (userDetails == null) {
			// => invalid login
			message="Invalid Login , Please retry !";
			return "login";
		}
		message="Login successful";
		// => valid login , continue to role based authorization
		if (userDetails.getUserRole().equals("admin")) {
			return "admin_page";
		}
		// => voter login , chk the voting status
		if (userDetails.isStatus())
			return "logout";
		//=> voter - not yet voted
		return "candidate_list";
	}

}
