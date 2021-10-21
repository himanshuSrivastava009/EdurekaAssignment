package com.edureka.assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TestEventHimanshu {



	
	public static void main(String[] args) throws FileNotFoundException {
	

		
	readFile();
		
		
		
		
	}
	public static void readFile() throws FileNotFoundException
	{
	String line;
	String content = "";
	String filePath = "C:\\Users\\HiKumar\\eclipse-workspace\\EdurekaAssignment1\\src\\com\\edureka\\assignment1\\events";
	File file = new File(filePath);
	FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);
	String desc = null;
	String event_description = null;
	String suid = null;
	String fname=null;
	String fileType=null;
	int count =0;
	int num =1;
	String lines[]=null;
	String event_type=null;
	StringBuffer sb = new StringBuffer();
	Set<String>s=new HashSet<String>();
	
	
		try {
			while((line=br.readLine())!=null)
			{
			lines=	line.split("[|]");//spliting on basis of "|" as delimiter
			event_type=lines[4];//event tye
			event_description=lines[5];//fetching event_description
			desc=lines[5];//for adding to test case description
			suid=	getSIEMEventDetails(lines[7], "suid");//suid
			fname=	getSIEMEventDetails(lines[7], "fname");//fname
			fileType= getSIEMEventDetails(lines[7], "fileType");//fileType
			
			//Creating Test Cases
			createTestCase(event_type, desc, event_description, suid, fname, count, fileType);
			
			
			sb.append(lines);//appending after spliting 

			  
			 
			   count = count + 1;
			/**
			 * Always put getUniqueEventType in between count and num
			 */
			 getUniqueEventType(count, num, event_type, s);

			   num = num+1;
				
			}
			System.out.println("Total count ="+count);
			System.out.println(s);
			fr.close(); 
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Set<String> getUniqueEventType(int count,int num,String event_type,Set<String>s)
	{
		 if(count==num)
		   {
			 s.add(event_type);
		   }
		// System.out.println("Unique evenets are ="+s);
		   return s;
	}
	public static void createTestCase(String event_type,String desc,String event_description,String suid,String fname,int count,String fileType)
	{
		String testCase="tc (|api id=TestCase"
				+ count
				+ "::"
				+ "desc=Validate SIEM Events for "
				+ event_type 
				+ " "
				+ fname
				+"::"
				+"fileType= "
				+ fileType
				+ "::"
				+ "name=ValidateSIEMEvents::type=json::verb=get::siem=true|)"
				+ "(|val Company=Micro Focus::version=4.3::product=Filr::"
				+ "event_description= "
				+ event_description
				+ "::zone=0|)"
				+ "(|parm log_path=./data/siemEventlogs.txt::"
				+ "event_type="
				+ event_type
				+ "::suid="
				+ suid
				+"|)";
		System.out.println(testCase);
	}
	public static String getSIEMEventDetails(String eventDetails, String key) {
//		String keys[] = {"suid=", "duid=", "destinationUserPrivileges=", "fileModificationTime=", "start=", "end=", "filePath=", "fname=", "filePermission=", "fileType="
//				, "src=", "deviceFacility=", "sourceUserPrivileges=", "cnt=", "shost=", "dvc="};
		String keys[] = {"suid=", "duid=", "destinationUserPrivileges=", "fileModificationTime=", "start=", "end=",
				"filePath=", "fname=", "filePermission=", "fileType=", "fileCreateTime=", "oldFilePath="
				, "src=", "deviceFacility=", "sourceUserPrivileges=", "cnt=", "shost=", "dvc="
				, "suser=", "duser=", "dst=", "oldFileName=", "sourceUserPrivileges=", "destinationUserPrivileges="
				, "dpid=", "cs1=", "cs1Label=", "msg="};
		String patternval = "\\s";
		String value = "";
		boolean condition = false;
		boolean append = false;
		int count = 0;		
		int arraylen = eventDetails.split(patternval).length;
		String eventElements[] = new String[arraylen];
		//Split them on spaces
		eventElements = eventDetails.split(patternval);		
		for (int ind = 0; ind < eventElements.length; ind++) {	
			condition = false;
			String keyval[] = null;
			//Validate the item has key value. If it is not a key value append to existing output
			for (int i = 0; i < keys.length; i++) {	
				if(eventElements[ind].contains(keys[i])) {
					condition = true;
					break;
				}
				
			}
			if(condition) {
				if (append) {
					break;
				}
				value = "";
				keyval = eventElements[ind].split("=", 2);
				if ((keyval.length) > 1) {
					if (keyval[0].trim().equalsIgnoreCase(key)) {
						value = keyval[1].trim();						
						append = true;
						count++;
					}
			
				}
			} 
			// If the item doesn't have key value then it need to be appended to existing output because Key value has space 
			if (append) {
				if (count ==1) {
					count++;
				} else {
				value = value + " " + eventElements[ind];
				}
			}
		}
		return value;
	}

}
