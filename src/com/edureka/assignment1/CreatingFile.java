package com.edureka.assignment1;

import java.io.File;
import java.io.IOException;

public class CreatingFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		String pattern="[|]";
		String patternval="\\s";
		
		String keys[] = {"suid=", "duid=", "destinationUserPrivileges=", "fileModificationTime=", "start=", "end=",
				"filePath=", "fname=", "filePermission=", "fileType=", "fileCreateTime=", "oldFilePath="
				, "src=", "deviceFacility=", "sourceUserPrivileges=", "cnt=", "shost=", "dvc="
				, "suser=", "duser=", "dst=", "oldFileName=", "sourceUserPrivileges=", "destinationUserPrivileges="
				, "dpid=", "cs1=", "cs1Label=", "msg="};
		
		//String[] keys = {"Title=","Destination="};
		//String val="ABC|XYZ|Bangalore|India|Maldives Title=Johanson  Destination=Europe";
		String val= "CEF:1|Micro Focus|Filr|4.3|Add Entry|Add Entry|0|shost=blr8-98-131.apac.novell.com dvc=164.99.116.37 suid=himanshu kumar (himanshu) fileType=Entry fileCreateTime=Jun 10 2021 11:39:04.142 GMT filePath=/Home Workspace/Personal Workspaces/himanshu kumar (himanshu)/Home fname=12345678901.txt ";
		String[] us = val.split(pattern);
		
		String eventDetails= us[7];
		int len = eventDetails.split(patternval).length;
		System.out.println(len);
		String[] eventElements = new String[len];
		String[]keyval = null;
		eventElements = eventDetails.split(patternval);
	
		for(int i=0;i<eventElements.length;i++)
		{
			System.out.println(eventElements[i]);
			
		}
		System.out.println("###################################");
		System.out.println(eventElements[1]);
		
	/**
	 * spliting value
	 */
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for(int i=0;i<eventElements.length;i++)
		{
		keyval=	eventElements[i].split("=", 2);
			
		}
		
		/**
		 * Keyval value
		 */
		
		for(int i=0;i<keyval.length;i++)
		{
			System.out.println(keyval[i]);
		}
		
		
		
		
		
		
		

	}

}
