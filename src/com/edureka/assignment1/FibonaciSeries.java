package com.edureka.assignment1;

public class FibonaciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//0 1 1 2 3 5 8 13 21 ....(last) + (last -1)
		
		int num =7;//5,4,3,2,1 --> 0 1 1 2 3 
		int num1 =0;
		int num2 =1;
		System.out.println(num1 +"\n" + num2+"\n" );
		while(num!=0)
		{
			int fib = num1 + num2;//1//2
			num2 = num1;
			num1 = fib;
			num--;
			System.out.println(fib);
			
		}
		
	}

}
