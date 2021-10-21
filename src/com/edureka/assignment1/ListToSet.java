package com.edureka.assignment1;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class ListToSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<String>al = new ArrayList<String>();
		LinkedHashSet<String>lh = new LinkedHashSet<>();
		al.add("Himanshu");
		al.add("Swati");
		al.add("Himanshu");
		al.add("Swati");al.add("Himanshu");
		al.add("Swati");al.add("Himanshu");
		al.add("Swati");
		
		lh.addAll(al);
		System.out.println(lh);
	}

}
