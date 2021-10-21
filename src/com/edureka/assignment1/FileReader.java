package com.edureka.assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
	static FileInputStream fip = null;
	static int data = 0;
	static String testCase = null;
	static String api = null;
	static String[] mapi = null;

	static HashMap<String, String> Parmmap = new HashMap<String, String>();
	static HashMap<String, String> Valuemap = new HashMap<String, String>();
	static HashMap<String, String> Apimap = new HashMap<String, String>();

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String,String>();
		String filePath = "C:\\Users\\HiKumar\\eclipse-workspace\\EdurekaAssignment1\\TestCaseFile";
		File file = new File(filePath);
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				// System.out.println(sc.nextLine());
				testCase = sc.nextLine();
				map=gettestCaseCaseAPI(testCase);
				System.out.println(map.get("id"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static HashMap<String, String> readFile()
	{
		HashMap<String, String> api = new HashMap<String, String>();
		String filePath = "C:\\Users\\HiKumar\\eclipse-workspace\\EdurekaAssignment1\\TestCaseFile";
		File file = new File(filePath);
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				
				testCase = sc.nextLine();
				api=gettestCaseCaseAPI(testCase);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return api;
	}

	public static HashMap<String, String> gettestCaseCaseAPI(String testCase) {
		String[] splitValues = testCase.split("[(|]");
		for (int i = 0; i < splitValues.length; i++) {
			// System.out.println(splitValues[i]);
			
				// System.out.println(splitValues[i]);
				if (splitValues[i].contains("api")) {
					api = splitValues[i].split("api")[1];
					// System.out.println("=======" + api);
					mapi = api.split("::");
					for (int j = 0; j < mapi.length; j++) {
						Apimap.put(mapi[j].split("=")[0].trim(), mapi[j].split("=")[1].trim());
					}

				}
			
		}
		return Apimap;

}
	public static HashMap<String, String> getTestCaseVAL(String testCase) {
		String[] splitValues = testCase.split("[(|]");
		for (int i = 0; i < splitValues.length; i++) {
			// System.out.println(splitValues[i]);
			
				// System.out.println(splitValues[i]);
				if (splitValues[i].contains("val")) {
					api = splitValues[i].split("val")[1];
					// System.out.println("=======" + api);
					mapi = api.split("::");
					for (int j = 0; j < mapi.length; j++) {
						Valuemap.put(mapi[j].split("=",2)[0].trim(), mapi[j].split("=",2)[1].trim());
					}

				}
			
		}
		return Valuemap;
	}
	public static HashMap<String, String> getTestCasePARM(String testCase) {
		String[] splitValues = testCase.split("[(|]");
		for (int i = 0; i < splitValues.length; i++) {
			// System.out.println(splitValues[i]);
			
				// System.out.println(splitValues[i]);
				if (splitValues[i].contains("parm")) {
					api = splitValues[i].split("parm")[1];
					// System.out.println("=======" + api);
					mapi = api.split("::");
					for (int j = 0; j < mapi.length; j++) {
						Parmmap.put(mapi[j].split("=",2)[0].trim(), mapi[j].split("=",2)[1].trim());
					}

				}
			
		}
		return Parmmap;
	}

}
