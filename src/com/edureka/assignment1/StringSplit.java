package com.edureka.assignment1;

public class StringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name ="Himanshu=Srivastava";
		int len =name.split("=", 2).length;
		System.out.println(len);
		String[] val =name.split("=", 2);
		String keys[] = {"Himanshu="};
		for(String Values: val)
		{
			System.out.println(Values);
		}
		
		String[] val1= name.split(keys[0]);
		for(String values:val1)
		{
			System.out.println(values);
		}
	}

}
