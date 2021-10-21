package com.edureka.assignment1;

public class FactorialNumber {

	public static void main(String[] args) {
	
		
		int num =4;
		int fact =1;
		while (num!=1)
		{
			fact = fact*num;
			num--;
		}
System.out.println(fact);
	}

}
