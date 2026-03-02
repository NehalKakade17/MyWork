package com.cdac.tester;

import java.util.Scanner;

import com.cdac.dao.BankAccountDao;
import com.cdac.dao.BankAccountDaoImpl;

public class TestStoredProcedure {

	public static void main(String[] args) {
		try (// sc
				Scanner sc = new Scanner(System.in);) {
			// create dao instance
			BankAccountDao dao = new BankAccountDaoImpl();
			System.out.println("Enter src a/c dest a/c nos n amount");
			System.out.println(dao.transferFunds(sc.nextInt(),sc.nextInt(),
					sc.nextDouble()));
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
