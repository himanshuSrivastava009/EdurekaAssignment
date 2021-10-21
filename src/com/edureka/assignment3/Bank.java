package com.edureka.assignment3;

abstract class Bank {
	
	String accountHolderName=null;
	long accountNumber=0;
	double balance=0;
	double amount=0;
	
	
	public void deposit(double amount)
	{
		balance = amount+balance;
		System.out.println("Amount deposited :" +amount);
		System.out.println("Total Balance is" +balance);
	}
	
	public void withdraw(double amount)
	{
		if(amount <= balance)
		{
		balance = balance-amount;
		System.out.println("Amount withdrawn :" +amount);
		System.out.println("Total Balance is" +balance);
		}
		else
		{
			System.out.println("Insufficient Account balance!!!");
			System.exit(0);
		}
		}
	
	public void rateOfIntrest()
	{
		System.out.println("Current ROI is 4% per month for savings account");
	}
	
	
	
	
	
	
	
	
	

}
