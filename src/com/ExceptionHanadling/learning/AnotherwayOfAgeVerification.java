package com.ExceptionHanadling.learning;

public class AnotherwayOfAgeVerification {

	public static void main(String[] args) {

		int age = 17;
		
		if(age<18)
		{
			try
			{
				throw new InvalidAgeException("you are not 18 years old!!!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				System.out.println(" Good !!");
			}
			
		}
		else
		{
			System.out.println("Proceed for voting!!!");
		}
		
	}

}
