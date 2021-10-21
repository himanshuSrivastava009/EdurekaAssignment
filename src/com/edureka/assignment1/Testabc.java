package com.edureka.assignment1;

public class Testabc {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String details = "shost=blr8-110-11.apac.novell.com dvc=164.99.116.37 suid=blue novell (blue) fileType=Folder fileCreateTime=Jun 11 2021 07:38:38.337 GMT filePath=/Home Workspace/Net Folders/Automation_ABE_NF/automation/ABE_TEST1 fname=ABE_TEST1";
		String value=getSIEMEventDetails(details, "suid");
		System.out.println(value);
	}

}
