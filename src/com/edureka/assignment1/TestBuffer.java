package com.edureka.assignment1;

public class TestBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] names= {"himanshu","Tanmay"};
		StringBuffer sbr = new StringBuffer();
		//sbr.append(names);
		
		for(int i=0;i<names.length;i++)
		{
			sbr.append(names[i]);
			sbr.append("\n");
		}
		
		String sr = new String(sbr);
		System.out.println(sr);
	}

}
