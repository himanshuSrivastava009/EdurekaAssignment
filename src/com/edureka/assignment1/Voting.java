package com.edureka.assignment1;

import java.util.Scanner;

public class Voting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("Enter the age");
		int age=in.nextInt();
		
		if(age>=18)
		{
			System.out.println(">>>You can vote<<<");
		}
		else
		{
			System.out.println("!!Age Criteria does not meet!!");
		}
	}

}
