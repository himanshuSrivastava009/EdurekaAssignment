package com.Hasmap.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapLearnig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> l = new ArrayList<String>();
		l.add("Himanshu");
		l.add("Himanshu1");
		l.add("Himanshu2");
		l.add("Himanshu3");
		l.add("Himanshu4");
		l.add("Himanshu5");
		
		List<String> l1 = new ArrayList<String>();
		l1.add("Test1");
		l1.add("Test2");
		l1.add("Test3");
		l1.add("Test4");
		l1.add("Test5");
		l1.add("Test6");
		
		HashMap<String, String> hm = new HashMap<>();
		
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i));
			System.out.println(l1.get(i));
			hm.put(l.get(i), l1.get(i));
		}
		














	}

}
