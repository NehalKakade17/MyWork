package com.cdac.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cdac.pojos.User;
import static com.cdac.utils.DBUtils.*;

public class UserDaoImpl implements UserDao {
	//state - 
	private Connection connection;
	private PreparedStatement pst1,pst2,pst3;
	//ctor
	public UserDaoImpl() throws SQLException{
		// 1. Invoke DButils' method to get cn
		connection=getConnection();
		//2. Create PST
		pst1=connection.prepareStatement("select * from users where role=?");
		pst2=connection.prepareStatement("select * from users where email=? and password=?");
		pst3=connection.prepareStatement("update users set status=? where id=?");
		System.out.println("user dao created !");
	}

	@Override
	public List<User> fetchUserDetailsByRole(String role) throws SQLException {
		//0. create empty list
		List<User> users=new ArrayList<>();
		//1. set IN param
		pst1.setString(1, role);
		//2 exec query -> process RST
		try (ResultSet rst=pst1.executeQuery()) {
			/*
			 * int userId, String firstName, String lastName, 
			 * String email, String password, Date dob, boolean status,
			String userRole
			 */
			while(rst.next()) {
				users.add(new User(rst.getInt(1),rst.getString(2),
						rst.getString(3),rst.getString(4),rst.getString(5),
						rst.getDate(6),rst.getBoolean(7),rst.getString(8))
						);
			}
		}
		return users;//dao layer rets list of selected users --> Tester
	}
	

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		// 1. set IN params
		pst2.setString(1, email);
		pst2.setString(2, password);
		//exec method - execQuery
		try(ResultSet rst=pst2.executeQuery() )
		{
			if(rst.next())
				return new User(rst.getInt(1),rst.getString(2),
						rst.getString(3),rst.getString(4),rst.getString(5),
						rst.getDate(6),rst.getBoolean(7),rst.getString(8));
				
		}
		//invalid login
		return null;
	}
	

	@Override
	public String updateVotingStatus(int voterId) throws SQLException{
		//set IN param
		pst3.setBoolean(1, true);
		pst3.setInt(2, voterId);
		int rowCount=pst3.executeUpdate();
		if(rowCount == 1)
			return "Updated voting status!";
		
		return "Updation failed !!!!!";
	}

	@Override
	public void cleanUp() throws SQLException {
		//close pst1 n pst2
		if(pst1 != null)
			pst1.close();	
		if(pst2 != null)
			pst2.close();
		if(pst3 != null)
			pst3.close();
		System.out.println("user dao cleaned up !");
		
	}
	

}
