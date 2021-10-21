package com.edureka.assignment1;

public class LearningReturn {

	public boolean checkNumber(String name)
	{
		boolean value=false;
	
		if(name.equalsIgnoreCase("himanshux"))
		{
		value = true;
			if(name.contains("x"))
			{
				value=false;
			}
		}
		else
		{
			value=false;
			return value;
		}
		return value;
	}
	
	public static void main(String[] args)
	{
		LearningReturn lr = new LearningReturn();
	boolean val=	lr.checkNumber("Himanshux");
	System.out.println(val);
	}

}

