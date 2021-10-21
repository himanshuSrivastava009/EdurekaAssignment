package com.edureka.LearningInterfaces;

public interface College {

	public void collegeName();
	public void collegeAddress();
	public void collegeContactDetails();
	public void collegePrincipalName();
	
	 default void test()  {
		System.out.println("Test");
	}
	
}
