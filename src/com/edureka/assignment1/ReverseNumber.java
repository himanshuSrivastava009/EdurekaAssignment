package com.edureka.assignment1;

import java.util.Scanner;



public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		long rev =0;
		byte digit =0;
		long num = in.nextLong();
	int size = Long.toString(num).length();
		System.out.println("Length of the number is "+size);
		
		while(num!=0)
			{
				digit = (byte) (num%10);
				System.out.println(digit);
				rev = rev*10+digit;
				num = num/10;
				
			}
	
		System.out.println(rev);
	}

}
