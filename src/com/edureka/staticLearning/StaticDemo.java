package com.edureka.staticLearning;

public class StaticDemo {

	static int x = 10;
	static
	{
		System.out.println("this is static block");
		x++;
		System.out.println(x);
	}
	
	static void display()
	{
		int x = 10;
		System.out.println(x);
	}
	
	public static void main(String[] args) {
	
		display();
		System.out.println("This is main method");
		//display();
	}

}
