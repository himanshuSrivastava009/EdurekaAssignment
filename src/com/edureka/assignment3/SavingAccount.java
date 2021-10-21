package com.edureka.assignment3;

import java.util.Scanner;

final class SavingAccount extends Bank{

	
	//SavingAccount sb = new SavingAccount();
	double roi = 0.04;
	double intrestEarned=0;
	 int month;
	Scanner in = new Scanner(System.in);
	
	public void rateOfIntrest()
	{
		System.out.println("Enter the month for which you want to get intrest Accumulated");
		month = in.nextInt();
		if(month<=12)
		{
			for(int i=1;i<=month;i++)
			{
				intrestEarned = (super.balance)*roi;
				super.balance=super.balance + intrestEarned;
				
			}
		}
		else
		{
			System.out.println("Please enter value from 1 to 12");
		}
		
		
		System.out.println("Intrest earned for till " + month +"month is :" +intrestEarned);
		System.out.println("Total amount is :" +super.balance);
	}
	
	public void deposit(double amount)
	{
		super.deposit(amount);
	}
	
	public void withdraw(double amount)
	{
		super.withdraw(amount);
	}
	
	
	
}
