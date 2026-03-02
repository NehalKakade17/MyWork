package com.cdac.pojos;

//id | name | type | bal
public class BankAccount {
	private int acctId;
	private String customerName;
	private String acType;
	private double balance;
	//getters n setters n toString
	public int getAcctId() {
		return acctId;
	}
	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAcType() {
		return acType;
	}
	public void setAcType(String acType) {
		this.acType = acType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [acctId=" + acctId + ", customerName=" + customerName + ", acType=" + acType + ", balance="
				+ balance + "]";
	}
	
}
