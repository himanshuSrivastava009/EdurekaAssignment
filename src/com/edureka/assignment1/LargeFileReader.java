package com.edureka.assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LargeFileReader {



	
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
	ArrayList<String>et=new ArrayList<String>();
	ArrayList<String>ed=new ArrayList<String>();
	LinkedHashSet<String>et1=new LinkedHashSet<String>();
	LinkedHashSet<String>ed1=new LinkedHashSet<String>();
	ArrayList<String>tc_event_type = new ArrayList<String>();
	ArrayList<String>tc_event_description = new ArrayList<String>();
	ArrayList<String>tc_desc = new ArrayList<String>();
	ArrayList<String>tc_fname = new ArrayList<String>();
	ArrayList<String>tc_fileType = new ArrayList<String>();
	ArrayList<String>tc_suid = new ArrayList<String>();
	
	
		try {
			while((line=br.readLine())!=null)
			{
			
			lines=	line.split("[|]");//spliting on basis of "|" as delimiter
			event_type=lines[4];//event type
			tc_event_type.add(event_type);
			event_description=lines[5];//fetching event_description
			tc_event_description.add(event_description);
			desc=lines[5];//for adding to test case description
			tc_desc.add(desc);
			suid=	getSIEMEventDetails(lines[7], "suid");//suid
			tc_suid.add(suid);
			fname=	getSIEMEventDetails(lines[7], "fname");//fname
			tc_fname.add(fname);
			fileType= getSIEMEventDetails(lines[7], "fileType");//fileType
			tc_fileType.add(fileType);
			
			
			//Creating Test Cases
			//createTestCase(event_type, desc, event_description, suid, fname, count, fileType);
			
			
			sb.append(lines);//appending after spliting 

			  
			 
			   count = count + 1;
			/**
			 * Always put getUniqueEventType/description in between count and num
			 */
			et1=   getUniqueEventType(count, num, event_type, et);
				//System.out.println("=============================================================");
			 ed1=  getUniqueDescription(count, num, ed, event_description);
			

			   num = num+1;
			  // System.out.println("Total count ="+count);
			 
			}
			fr.close();
//			System.out.println("Total count ="+count);
//			System.out.println(et.size());
//			System.out.println(ed.size());
//			System.out.println(et1);
//			System.out.println(ed1);
			//System.out.println(ed);
			//doIterate(getUniqueEventType(count, num, event_type, et), getUniqueDescription(count, num, ed, event_description));
			//System.out.println(getUniqueEventType(count, num, event_type, et));
			//System.out.println(getUniqueDescription(count, num, ed, event_description));
			
	
			
			//fr.close(); 
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//System.out.println(">>"+tc_event_type);
		//System.out.println(">>>>>>>"+tc_fname);
//		System.out.println(tc_event_description.size());
//		System.out.println(tc_event_type.size());
//		System.out.println(tc_fname.size());
//		System.out.println(tc_fileType.size());
//		System.out.println(tc_desc.size());
		
		
		
	for(int i=0;i<tc_event_type.size();i++)
	{
		//System.out.println(tc_event_type.get(i));
		createTestCase(tc_event_type.get(i), tc_desc.get(i), tc_event_description.get(i), tc_suid.get(i), tc_fname.get(i), i, tc_fileType.get(i));
	}
		
	}
	
	

	
	public static void doIterate(LinkedHashSet<String> linkedHashSet,LinkedHashSet<String> linkedHashSet2)
	{
		Iterator<String> itr = linkedHashSet.iterator();
		Iterator<String> itr1 = linkedHashSet2.iterator();
		while(itr.hasNext() && itr1.hasNext())
		{
			//System.out.println(itr.next() + "=" +itr1.next());
		}
		
	}
	public static LinkedHashSet<String> getUniqueEventType(int count,int num,String event_type,ArrayList<String>et)
	{
		 if(count==num)
		   {
			 et.add(event_type);
			 
		   }
		 LinkedHashSet<String>eventType=new LinkedHashSet<String>();
		 eventType.addAll(et);
		// System.out.println("Size of Event Type="+eventType.size());
		 //System.out.println(eventType);
		 return eventType;
		 
		   
	}
	public static LinkedHashSet<String> getUniqueDescription(int count,int num,ArrayList<String>ed,String event_description)
	{
		 if(count==num)
		   {
			 
			 ed.add(event_description);
			 
		   }
		 LinkedHashSet<String>eventDescription=new LinkedHashSet<String>();
		 
		 eventDescription.addAll(ed);
		 //System.out.println("Size of Event Description="+eventDescription.size());
	//	System.out.println(eventDescription);
		 return eventDescription;
		 
		   
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
				+ "event_description="
				+ event_description
				+ "::zone=0"
				+"::"
				+"fname="
				+fname
				+ "|)"
				+ "(|parm log_path=./data/siemEventlogs.txt::"
				+ "event_type="
				+ event_type
				+ "::suid="
				+ suid
				+"::"
				+"fname="
				+fname
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
