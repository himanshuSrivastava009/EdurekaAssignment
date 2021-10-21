package com.edureka.assignment2;

import java.util.Scanner;

public class Employees {

	public static void main(String[] args) {

		int[] id = new int[5];
		String[] empName = new String[5];
		double[] salary = new double[5];

		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Employee ID , Employee Name and Employee Salary");
		for (int i = 0; i < id.length; i++) {
			id[i] = in.nextInt();
			empName[i] = in.next();
			salary[i] = in.nextDouble();
		}
	}

}
