package com.ExceptionHanadling.learning;

public class AithematicExceptionLearning {

	public static void main(String[] args) {

		
		int x = 0;
		int y = 0;
		try
		{
			System.out.println(x/y);
		}
		
		catch(Exception e)
		{
		e.printStackTrace();
		}
		finally
		{
			System.out.println("Try and finally exists togather");
		}
		
		System.out.println("hehehe");
	}

}
