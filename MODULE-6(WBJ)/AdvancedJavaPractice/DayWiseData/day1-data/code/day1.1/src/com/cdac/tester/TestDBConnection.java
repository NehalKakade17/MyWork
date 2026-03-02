package com.cdac.tester;

import java.sql.*;
//to access static members directly
import static com.cdac.utils.DBUtils.openConnection;

import com.cdac.utils.DBUtils;

public class TestDBConnection {

	public static void main(String[] args) {
		try (Connection connection = openConnection()){
			// test DB connectivity			
			System.out.println("connected to DB "+connection);
			
		} //JVM - connection.close() : implicitly
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
