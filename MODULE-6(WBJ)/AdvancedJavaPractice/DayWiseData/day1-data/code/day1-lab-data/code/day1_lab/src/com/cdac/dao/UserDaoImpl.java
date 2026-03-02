package com.cdac.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cdac.pojos.User;
import static com.cdac.utils.DBUtils.*;

public class UserDaoImpl implements UserDao {
	// state -
	private Connection connection;
	private PreparedStatement pst1, pst2;

	// ctor
	public UserDaoImpl() throws SQLException {
		// 1. Invoke DButils' method to open cn
		connection = openConnection();
		// 2. Create PST : it represents pre-parsed n pre-compiled statment,
		// efficient in case of repeatative queries
		pst1 = connection.prepareStatement("select * from users where role=?");
		// insert query
		pst2 = connection.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		System.out.println("user dao created !");
	}

	@Override
	public List<User> fetchUserDetailsByRole(String role) throws SQLException {
		// 0. create empty list
		List<User> users = new ArrayList<>();// size=0 , init capa=10
		// 1. set IN param
		pst1.setString(1, role);
		// 2 exec query -> process RST
		try (ResultSet rst = pst1.executeQuery()) {
			/*
			 * int userId, String firstName, String lastName, String email, String password,
			 * Date dob, boolean status, String userRole
			 */
			// RST cursor -: before the 1st row
			while (rst.next()) {
				users.add(new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getDate(6), rst.getBoolean(7), rst.getString(8)));
			}
		}
		return users;// dao layer rets list of selected users --> Tester
	}

	@Override
	public String registerVoter(User newVoter) throws SQLException {
		// 1. Read from newVoter n set IN params
		pst2.setString(1,newVoter.getFirstName());//fn
		pst2.setString(2,newVoter.getLastName());//ln
		pst2.setString(3,newVoter.getEmail());//em
		pst2.setString(4,newVoter.getPassword());//pass
		pst2.setDate(5, newVoter.getDob());//dob
		pst2.setBoolean(6, newVoter.isStatus());//voting status , false=> not yet voted !
		pst2.setString(7, newVoter.getUserRole());//role
	    //exec query - exec update - DDL | DML
		/*
		 * public int executeUpdate() throws SQLException
		 */
		int updateCount=pst2.executeUpdate();
		if(updateCount ==1)
			return "User registered !";
		return "User registration failed!!!!!!";
	}

	@Override
	public void cleanUp() throws SQLException {
		// close pst1
		if (pst1 != null)
			pst1.close();
		// close pst2
		if (pst2 != null)
			pst2.close();
		// close connection
		closeConnection();
		System.out.println("user dao cleaned up !");

	}

}
