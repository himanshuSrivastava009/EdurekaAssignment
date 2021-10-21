package com.edureka.assignment1;

import java.util.Iterator;
import java.util.Stack;

public class ReverseOfString {

	public static void main(String[] args) {

		String str= "Hello i am Himanshu";
		Stack<String> string = new Stack<String>();
		String[] values=str.split(" ");
		for(int i=0;i<values.length;i++)
		{
			string.add(values[i]);
			
		}
		System.out.println(string.size());
		System.out.println(string);
		String myval="";
		Iterator<String>itr = string.iterator();
		while(itr.hasNext())
		{
			String val=itr.next();
			int size=val.length();
			
			myval = myval+" "+reverseChar(size, val);;
			
		}
		System.out.println(myval.stripLeading());
		

//		String finalvalue="";
//		for(int j=0;j<4;j++)
//		{
//			finalvalue=finalvalue+" "+string.pop();
//		}
//		System.out.println(finalvalue.stripLeading());
		
		
		
	/*	int size=values[0].length();
		char[] revCh=new char[size];
		System.out.println(size);
		
		for(int k=0;k<size;k++)
		{
		revCh[size-k-1]=values[0].charAt(k);
		}
		System.out.println(revCh);
		*/
		
		
	}
	public static String reverseChar(int lengthOfString,String values)
	{
		char[] revCh = new char[lengthOfString];
		for(int k=0;k<lengthOfString;k++)
		{
			revCh[lengthOfString-k-1]=values.charAt(k);
		}
		String str = new String(revCh);
		return str;
	}

}
