package com.streamapi.www;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Driver {

	static List<Employee> empList = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("\nPress 1 for Add Employee");
			System.out.println("Press 2 for View All Employees");
			System.out.println("Press 3 for Exit");
			System.out.print("Choose option: ");

			int ch;

			try {
				ch = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.err.println("Please enter valid number.");
				sc.nextLine();
				continue;
			}

			switch (ch) {

			case 1:

				String name;
				int age = 0;
				double salary = 0;

				System.err.println("Enter Employee Name:");
				name = sc.nextLine();

				while (true) {
					try {
						System.out.println("Enter Employee Age:");
						age = sc.nextInt();
						if (age > 0)
							break;
						else
							System.err.println("Age must be positive.");
					} catch (InputMismatchException e) {
						System.err.println("Enter valid age (number only).");
						sc.nextLine();
					}
				}

				while (true) {
					try {
						System.out.println("Enter Employee Salary:");
						salary = sc.nextDouble();
						if (salary > 0)
							break;
						else
							System.err.println("Salary must be positive.");
					} catch (InputMismatchException e) {
						System.err.println("Enter valid salary (number only).");
						sc.nextLine();
					}
				}

				sc.nextLine();
				Employee emp = new Employee(name, age, salary);
				empList.add(emp);

				System.out.println("Employee Added Successfully!");
				break;

			case 2:
				if (empList.isEmpty()) {
					System.err.println("No Employees Found.");
				} else {
					System.out.println("\nAll Employees:");
					empList.forEach(System.out::println);
				}
				break;

			case 3:
				System.out.println("Exiting Program!");

				break;

			default:
				System.out.println("Invalid Choice!");
			}

			System.out.println("\n\nEmployess who have more than 5000 Salary:- \n");
			empList.stream().filter((emp) -> emp.getSalary() > 5000).forEach(System.out::println);
		}

	}
}
