package com.ExceptionHanadling.learning;

public class VoterAgeVerification {

	public static void main(String[] args) {
		
		int age =17;
		try {
			ageVerification(age);
		} catch (Exception e) {
			
		}
		

	}

	private static void ageVerification(int age) throws InvalidAgeException {
		if(age<18)
		{
			throw new InvalidAgeException("You are not a valid voter!!! Age criteria does not Match");
		}
	}

}
