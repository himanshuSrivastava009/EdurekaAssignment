package com.ExceptionHanadling.learning;

public class InvalidAgeException extends Exception{
	
	public InvalidAgeException(String message) {

		System.out.println(message);
	}

}
