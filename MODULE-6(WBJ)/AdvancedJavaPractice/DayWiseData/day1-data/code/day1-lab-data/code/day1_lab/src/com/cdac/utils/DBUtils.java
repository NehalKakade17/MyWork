package com.cdac.utils;

import java.sql.*;//JDBC API

public class DBUtils {
	private static Connection connection;

	// add a method to return fixed DB connection to the called
	public static Connection openConnection() throws SQLException {
		// syntax - jdbc:subprotocol:subname
		String dbUrl = "jdbc:mysql://localhost:3306/advjava";
		//DBURL for Type IV JDBC Driver - DB vendor specific
		connection = DriverManager.getConnection(dbUrl, "root", "root");
		return connection;
	}
	//add a method to close DB connection
	public static void closeConnection() throws SQLException
	{
		if(connection != null)
			connection.close();
		System.out.println("closed cn");
	}
}
