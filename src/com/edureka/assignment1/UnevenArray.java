package com.edureka.assignment1;

import java.util.Map;
import java.util.Spliterators;


public class UnevenArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String keys[] = {"suid=", "duid=", "destinationUserPrivileges=", "fileModificationTime=", "start=", "end=",
				"filePath=", "fname=", "filePermission=", "fileType=", "fileCreateTime=", "oldFilePath="
				, "src=", "deviceFacility=", "sourceUserPrivileges=", "cnt=", "shost=", "dvc="
				, "suser=", "duser=", "dst=", "oldFileName=", "sourceUserPrivileges=", "destinationUserPrivileges="
				, "dpid=", "cs1=", "cs1Label=", "msg="};
		String data[]=null;
		int keyslen = keys.length;
	//	System.out.println(keyslen);
		String details = "shost=blr8-110-11.apac.novell.com dvc=164.99.116.37 suid=blue novell (blue) fileType=Folder fileCreateTime=Jun 11 2021 07:38:38.337 GMT filePath=/Home Workspace/Net Folders/Automation_ABE_NF/automation/ABE_TEST1 fname=ABE_TEST1";
//		String[] values= details.split("=");
//		int valueslen = values.length;
		String[] test=null;
		String newVal[]=null;
		//System.out.println(values[1]);
		
	for(int i=0;i<keys.length;i++)
	{
		if(details.contains(keys[i]))
		{
			System.out.println(keys[i]);
			//test=details.split(keys[i]);
//			for(int j=0;j<test.length;j++)
//			{
//				//System.out.println(">>"+ test[j]);
//			}
		}
	}
		
		
		
//		for(int i=0;i<keys.length;i++)
//		{
//			for(int j=0;j<values.length;j++)
//			{
//			if(values[j].contains(keys[i]))
//			{
//				//System.out.println(keys[i]+"");
//				String[] val =values[j].split(keys[i]);
//				System.out.print(keys[i] + val[1]+"::");
//				
//			}
//		}
//		}
		

 
	
		
		
		
	}

}
