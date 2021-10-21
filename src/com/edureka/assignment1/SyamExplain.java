package com.edureka.assignment1;

public class SyamExplain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "syam=prasad";
		String[] fields= name.split("=",2);
	for(String values:fields)
	{
	//	System.out.println(values);
	}
	
	System.out.println("******************************************");
	String key[]= {"syam="};
	
	String val1[]=name.split(key[0]);
	
	for(int i=0;i<val1.length;i++)
	{
		System.out.println(val1[i]);
	}
	}

}
