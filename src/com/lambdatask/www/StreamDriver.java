package com.lambdatask.www;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StreamDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<StreamEmployee> empList = new ArrayList<StreamEmployee>();

		System.out.println("Enter the  number of employees:");
		int empCount = sc.nextInt();

		for (int i = 0; i < empCount; i++) {
			System.out.print("Enter the Employee ID:");
			int eId = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter the Employee Name:");
			String eName = sc.nextLine();

			System.out.print("Enter the Employee Salary:");
			double eSal = sc.nextDouble();

			StreamEmployee e = new StreamEmployee(eId, eName, eSal);
			empList.add(e);
		}

		for (StreamEmployee se : empList) {
			System.out.println(se + "\n");
		}


		System.out.println("==============================================================");
		empList.stream().filter(a -> !a.getEmpName().startsWith("S")).forEach(System.out::println);
		System.out.println("======================================================================");

	}
}
