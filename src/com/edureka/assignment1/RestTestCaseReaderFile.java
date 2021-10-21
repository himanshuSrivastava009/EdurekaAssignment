package com.edureka.assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RestTestCaseReaderFile {

	public static void main(String[] args) throws IOException, InterruptedException {

		String restFilePath="C:\\Users\\HiKumar\\eclipse-workspace\\EdurekaAssignment1\\src\\com\\edureka\\assignment1\\RestTestCaseFile";
		File file = new File(restFilePath);
		FileInputStream in = new FileInputStream(file);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line=null;
		while((line=br.readLine())!=null)
		{
			Thread.sleep(2000);
			System.out.println(line);
			
		}
	}

}
