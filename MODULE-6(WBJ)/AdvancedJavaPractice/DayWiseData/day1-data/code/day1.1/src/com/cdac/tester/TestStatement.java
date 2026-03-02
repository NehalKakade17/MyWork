package com.cdac.tester;
import static com.cdac.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestStatement {

	public static void main(String[] args) {
		try(//1. get connection
				Connection connection=openConnection();
				//2. create statement using Connection i/f
				Statement st=connection.createStatement();
				//3. execute the query n get ResultSet
				ResultSet rst=st.executeQuery("select * from users");
				) {
			//4. processing of ResultSet - cursor is before the 1st row
			while(rst.next())
			{
				//5. to read row data.
				/*
				 * id | first_name | last_name | email  password | dob
				 *    | status | role
				 */
				System.out.printf("ID %d Name %s %s Email %s Password %s"
						+ "Dob %s Status %b Role %s %n",rst.getInt(1),
						rst.getString(2),rst.getString(3),rst.getString(4),
						rst.getString(5),rst.getDate(6),rst.getBoolean(7),
						rst.getString(8));
			}
		}//JVM - rst,st,cn .close() => cleaning up of DB resources
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
