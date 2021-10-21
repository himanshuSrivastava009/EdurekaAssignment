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

public class TestCaseGenerator {



	
	public static void main(String[] args) throws FileNotFoundException {
	

		
		readFile();
//		String val="blr8-110-113.apac.novell.com suid=syam dvc=164.99.110.11 fname=a.txt";
//		String test= getSIEMEventDetails(val, "fname");
//		System.out.println(test);
			
		
		
	}
	
	public static void readFile() throws FileNotFoundException
	{
	String line;
	String content = "";
	String filePath1 = "C:\\Users\\HiKumar\\eclipse-workspace\\EdurekaAssignment1\\src\\com\\edureka\\assignment1\\events";
	File file = new File(filePath1);
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
	String duid=null;
	StringBuffer sb = new StringBuffer();
	ArrayList<String>et=new ArrayList<String>();
	ArrayList<String>ed=new ArrayList<String>();
	LinkedHashSet<String>et1=new LinkedHashSet<String>();
	LinkedHashSet<String>ed1=new LinkedHashSet<String>();
	String oldFilePath=null ;
	String filePath=null;
	String Zone=null;
	/**
	 * suid=", "duid=", "destinationUserPrivileges=", "fileModificationTime=", "start=", "end=",
				"filePath=", "fname=", "filePermission=", "fileType=", "fileCreateTime=", "oldFilePath="
				, "src=", "deviceFacility=", "sourceUserPrivileges=", "cnt=", "shost=", "dvc="
				, "suser=", "duser=", "dst=", "oldFileName=", "sourceUserPrivileges=", "destinationUserPrivileges="
				, "dpid=", "cs1=", "cs1Label=", "msg=
	 */
	String msg=null;
	String duser=null;
	String cnt=null;
	String shost=null;
	String sourceUserPrivileges=null;
	String destinationUserPrivileges=null;
	String deviceFacility=null;
	String filePermission=null;
	String oldFileName=null;
	String src=null;
	String suser=null;
	String dvc=null;
	
	
		try {
			while((line=br.readLine())!=null)
			{
			
			lines=	line.split("[|]");//spliting on basis of "|" as delimiter
			event_type=lines[4];//event type
			event_description=lines[5];//fetching event_description
			desc=lines[5];//for adding to test case description
			suid=	getSIEMEventDetails(lines[7], "suid");//suid
			fname=	getSIEMEventDetails(lines[7], "fname");//fname
			fileType= getSIEMEventDetails(lines[7], "fileType");//fileType
			duid =getSIEMEventDetails(lines[7], "duid");//duid
			oldFilePath=getSIEMEventDetails(lines[7], "oldFilePath");//file Path
			filePath=getSIEMEventDetails(lines[7], "filePath");
			Zone=getSIEMEventDetails(lines[7], "Zone");
			
			//Extra validation
			src=getSIEMEventDetails(lines[7], "src");
			filePermission=getSIEMEventDetails(lines[7], "filePermission");
			deviceFacility=getSIEMEventDetails(lines[7], "deviceFacility");
			cnt=getSIEMEventDetails(lines[7], "cnt");
			msg=getSIEMEventDetails(lines[7], "msg");
			shost=getSIEMEventDetails(lines[7], "shost");
			suser=getSIEMEventDetails(lines[7], "suser");
			duser=getSIEMEventDetails(lines[7], "duser");
			dvc=getSIEMEventDetails(lines[7], "dvc");
			destinationUserPrivileges=getSIEMEventDetails(lines[7], "destinationUserPrivileges");
			sourceUserPrivileges=getSIEMEventDetails(lines[7], "sourceUserPrivileges");
			oldFileName=getSIEMEventDetails(lines[7], "oldFileName");
			cnt=getSIEMEventDetails(lines[7], "cnt");
			
			
			
			//Creating Test Cases
			//createTestCase(event_type, desc, event_description, suid, fname, count, fileType);
			//createTestCase(event_type, desc, event_description, suid, duid, fname, count, fileType);
			//createTestCase(event_type, desc, event_description, suid, duid, fname, count, fileType, filePath, oldFilePath,Zone);
			//sequentialEvents("tc (|api id=TestCase 002::desc=Share of the file with another User::name=ShareFileNew::type=json::verb=post|) (|val respcode=200::role=VIEWER::days_to_expire=100|)(|parm role=VIEWER::days_to_expire=100::recipient_id=rceditor::recipient_type=user::path=/Home Workspace/Personal Workspaces/admin (admin)/SIEM_Folder_Trash::title=New.csv::comment=Share comment text::internal=true::external=true::public=true::grant_reshare=true::public_link=true::username=admin::password=novell|)");

			createTestCase(event_type, desc, event_description, suid, duid, fname, count, fileType, filePath,
					oldFilePath, Zone, src, filePermission, deviceFacility, cnt, msg, shost, suser, duser, destinationUserPrivileges, sourceUserPrivileges, oldFileName,dvc);
			//System.out.println(fname);
			
			
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
			System.out.println("Total count ="+count);
			System.out.println(et.size());
			System.out.println(ed.size());
			System.out.println(et1);
			System.out.println(ed1);
			//System.out.println(ed);
			//doIterate(getUniqueEventType(count, num, event_type, et), getUniqueDescription(count, num, ed, event_description));
			//System.out.println(getUniqueEventType(count, num, event_type, et));
			//System.out.println(getUniqueDescription(count, num, ed, event_description));
			
	
			
			//fr.close(); 
		} catch (IOException e) {
			
			e.printStackTrace();
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
				+
				"|)"
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
	
	public static void createTestCase(String event_type,String desc,String event_description,String suid,String duid,String fname,int count,String fileType)
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
				+"::"
				+"duid="
				+duid
				+
				"|)"
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
	
	public static void createTestCase(String event_type,String desc,String event_description,String suid,String duid,String fname,int count,String fileType,String filePath,String oldFilePath,String Zone)
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
				+"::"
				+"duid="
				+duid
				+"::"
				+"oldFilePath="
				+oldFilePath
				+"::"
				+"filePath="
				+filePath
				+
				"|)"
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
	
	public static void createTestCase(String event_type,String desc,String event_description,String suid,String duid,String fname,int count,
			String fileType,String filePath,String oldFilePath,String Zone,String src,String filePermission,String deviceFacility,
			String cnt,String msg,String shost
			,String suser,String duser,String destinationUserPrivileges,String sourceUserPrivileges,String oldFileName,String dvc)
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
				+"::"
				+"duid="
				+duid
				+"::"
				+"oldFilePath="
				+oldFilePath
				+"::"
				+"filePath="
				+filePath
				+"::msg="
				+msg
				+"::src="
				+src
				+"::deviceFacility="
				+deviceFacility
				+"::shost="
				+shost
				+"::suser="
				+suser
				+"::duser="
				+duser
				+"::"
				+"fileType="
				+ fileType
				+"::destinationUserPrivileges="
				+destinationUserPrivileges
				+"::sourceUserPrivileges="
				+sourceUserPrivileges
				+"::oldFileName="
				+oldFileName
				+"::filePermission="
				+filePermission
				+"::dvc="
				+dvc
				+
				"|)"
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
	
	public static void sequentialEvents(String restTestcase)
	{
		
		String testcase="##Start SIEM Events\r\n"
				+ "tc (|api id=TestCase 003::desc=Start SIEM Events::name=StartSIEMEvents::type=json::verb=get::siem=true|)(|val response=true|)(|parm log_path=./data/siemEventlogs.txt|)\r\n"
				+ "\r\n"
				+ "\r\n"
				+"#Rest Test case\n"
				+ restTestcase
				+ "\r\n"
				+ "#STOP SIEM Events\r\n"
				+ "tc (|api id=TestCase 20::desc=Stop SIEM Events::name=StopSIEMEvents::type=json::verb=get::siem=true|)(|val response=true|)(|parm log_path=./data/siemEventlogs.txt|)\r\n"
				+ ""
				+"#Validation";
		
		System.out.println(testcase);
		
		
		
		
		
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
