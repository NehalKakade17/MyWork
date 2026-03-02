package com.blogs.tester;

import static com.blogs.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.blogs.dao.AddressDao;
import com.blogs.dao.AddressDaoImpl;
import com.blogs.pojos.Address;

public class AssignUserAddress {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			AddressDao dao=new AddressDaoImpl();
			System.out.println("Enter user id");
			Long userId = sc.nextLong();
			System.out.println(
					"Enter adr details - adrLine1, String adrLine2, String city, String state, String country, String zipCode");
			Address adr = new Address(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
			System.out.println(dao.assignUserAddress(userId,adr));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
