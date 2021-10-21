package com.edureka.assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EventParser {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		 FileReader fr=new FileReader("C:\\\\Users\\\\HiKumar\\\\eclipse-workspace\\\\EdurekaAssignment1\\\\src\\\\com\\\\edureka\\\\assignment1\\\\events");    
         int i;    
         while((i=fr.read())!=-1)   
         {
        	 Thread.sleep(1000);
         System.out.print((char)i);    
       
         }
         fr.close();
         
         
//		File file = new File("C:\\Users\\HiKumar\\eclipse-workspace\\EdurekaAssignment1\\src\\com\\edureka\\assignment1\\events");
//		String pattern = "[|]";
//		String eventfileds[]=null;
//		String siem[]=null;
//		Scanner in = new Scanner(file);
//		while(in.hasNext())
//		{
//			String data = in.nextLine();
//			//System.out.println(data);
//			eventfileds=data.split(pattern,2);
//		siem =	eventfileds[1].split(pattern);
//			
//	
//		}
//		for(String values:siem)
//		{
//			System.out.println(values);
//		}
		
	}

}
