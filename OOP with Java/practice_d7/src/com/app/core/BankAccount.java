package com.app.core;

public class BankAccount {
	private int accNo;
	private String customerName;
	private AccountType type;
	private double balance;
	public BankAccount(int accNo, String customerName, AccountType type, double balance) {
		super();
		this.accNo = accNo;
		this.customerName = customerName;
		this.type = type;
		this.balance = balance;	
		}
	//PK : accNo
	@Override
	public boolean equals(Object o)
	{
		System.out.println("in account equals");
		if(o instanceof BankAccount)
			return this.accNo == ((BankAccount)o).accNo;
		return false;
	}
	@Override
	public int hashCode()
	{
		System.out.println("in acc hashcode");
		return 10;
	}
	
}
