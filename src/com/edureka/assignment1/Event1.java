package com.edureka.assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class Event1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String content = "";
		String filePath = "C:\\\\\\\\Users\\\\\\\\HiKumar\\\\\\\\eclipse-workspace\\\\\\\\EdurekaAssignment1\\\\\\\\src\\\\\\\\com\\\\\\\\edureka\\\\\\\\assignment1\\\\\\\\events";
		File file = new File(filePath);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String event_type = null;
		String desc = null;
		String event_description = null;
		String suid = null;
		String[] contents = null;
		String keys[] = {"suid=", "duid=", "destinationUserPrivileges=", "fileModificationTime=", "start=", "end=",
				"filePath=", "fname=", "filePermission=", "fileType=", "fileCreateTime=", "oldFilePath="
				, "src=", "deviceFacility=", "sourceUserPrivileges=", "cnt=", "shost=", "dvc="
				, "suser=", "duser=", "dst=", "oldFileName=", "sourceUserPrivileges=", "destinationUserPrivileges="
				, "dpid=", "cs1=", "cs1Label=", "msg="};
		String value=null;
		int num=1;
		
		
		
		StringBuffer sb = new StringBuffer();
		String line;
		String fname=null;
		String fileType=null;
		 int count=0;
		 Set<String>s=new HashSet<String>();
		
		
		while((line=br.readLine())!=null)
		{
		String[]lines=	line.split("[|]");//spliting on basis of "|" as delimiter
		event_type = lines[4];//fetching event_type
		event_description=lines[5];//fetching event_description
		desc=lines[5];//for adding to test case description
		
		//createTestCase(event_type, desc, event_description, suid);
		
		//System.out.println(lines[7]);
			String[] event_details= lines[7].split("\\s");//Spliting based on Space and getting values in terms of key value pair with delimiter =
			//System.out.println(lines[7]);
		suid=	getSIEMEventDetails(lines[7], "suid");
		fname=	getSIEMEventDetails(lines[7], "fname");
		fileType= getSIEMEventDetails(lines[7], "fileType");
		//	System.out.println(suid);
			
		createTestCase(event_type, desc, event_description, suid, fname , count, fileType);
			
			
			
		   sb.append(lines);//appending after spliting 
		 
		   count = count + 1;
	//	System.out.println("Unique Events ="+getUniqueEventType(count, num, event_type, s).size());
		 //  getUniqueEventType(count, num, event_type, s);
		  
		   num = num+1;
		  
		  
			
		}
		System.out.println(count); //printing the count of lines i.e. no of Events
//		 Iterator<String> itr = s.iterator();
//			while(itr.hasNext())
//			{
//				String uniqueEve=itr.next();
//				//System.out.println(itr.next());
//				createTestCase(uniqueEve, desc, event_description, suid, fname, count, fileType);
//			}
		fr.close();    //closes the stream and release the resources  
		
	
	}
	
	
	public static Set<String> getUniqueEventType(int count,int num,String event_type,Set<String>s)
	{
		 if(count==num)
		   {
			 s.add(event_type);
		   }
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
