package com.streamapi.www;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Driver2 {
	public static void main(String[] args) {

		List<Employee2> empList = new ArrayList<>();

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

				System.out.println("Enter Employee Name:");
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
				Employee2 emp = new Employee2(name, age, salary);
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

			//sort by Age 
			System.out.println("\n\nSort List using Stream API.");
			empList.stream().sorted(Comparator.comparing(Employee2::getAge)).forEach(System.out::println);

			//calculate Bonus
			System.out.println("\n\nCalculating bonus for each employee: ");
			empList.stream().map(s -> s.getSalary() + s.getSalary() * 0.10).forEach(System.out::println);
		}

	}
}
