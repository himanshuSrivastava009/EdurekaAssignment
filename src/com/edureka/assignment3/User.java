package com.edureka.assignment3;

import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		
		
	Bank bk;	
	int option;
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the Account type 1. SavingsAccount "
			+ "2.Current Account"
			);
	option = in.nextInt();
		switch (option) {
		case 1:
			bk= new SavingAccount();//Run Time polymorphism
			bk.deposit(10000);
			bk.withdraw(5000);
			bk.rateOfIntrest();
			break;
		case 2: 
			bk = new CurrentAccount();//Run Time polymorphism
			bk.deposit(2000);
			bk.withdraw(10000);
			break;
		default:
			System.out.println("Enter a Valid Account Type!!!");
			break;
		}
		

	}

}
