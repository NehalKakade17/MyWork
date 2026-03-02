package com.cdac.tester;

import java.sql.*;
import java.util.Scanner;

import static com.cdac.utils.DBUtils.openConnection;

public class TestPreparedStatement {

	public static void main(String[] args) {
		String sql="select first_name,last_name,dob from users where role=? and dob > ?";
		try(//sc
				Scanner sc=new Scanner(System.in);
				//1. cn
				Connection cn=openConnection();
				//2. pst
				PreparedStatement pst=cn.prepareStatement(sql);
				
				) {
			//3 set IN params
			System.out.println("Enter role n DoB");
			pst.setString(1, sc.next());
			//Parsing API for String -> java.sql.Date conversion
			/*
			 * public static Date valueOf(String s) throws IllegalArgumentException
			 */
			pst.setDate(2,Date.valueOf(sc.next()));
			//4. exec query n process RST
			try (ResultSet rst=pst.executeQuery()) {
				while(rst.next()) {
					System.out.printf("Name %s %s DoB %s %n",
							rst.getString(1),rst.getString(2),rst.getDate(3));
				}
			} //JVM - rst.close()
		} //pst, cn ,sc -closed
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
