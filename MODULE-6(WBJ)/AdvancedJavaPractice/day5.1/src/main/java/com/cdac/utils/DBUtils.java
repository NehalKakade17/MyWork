package com.cdac.utils;

import java.sql.*;//JDBC API

public class DBUtils {
	private static Connection connection;

	// add a method to return fixed DB connection to the called
	public static void openConnection(String dbUrl,String userName,String pwd) throws SQLException {
		// syntax - jdbc:subprotocol:subname
	//	String dbUrl = "jdbc:mysql://localhost:3306/advjava";
		connection = DriverManager.getConnection(dbUrl, userName,pwd);
	}

	// add a method to close DB connection
	public static void closeConnection() throws SQLException {
		if (connection != null)
			connection.close();
		System.out.println("closed cn");
	}
	// add a method to get existing DB connection
	public static Connection getConnection() {
		return connection;
	}
	
}
