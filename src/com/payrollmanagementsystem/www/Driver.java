package com.payrollmanagementsystem.www;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Driver {
	public static void main(String[] args) {

		List<Employee> emp = new ArrayList<Employee>();
		boolean running = true;
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.err.println("\n===== Employment Type Selection =====\n");

			System.out.println("Press 1 for Permanent Employement");
			System.out.println("Press 2 for Contractual Employement");
			System.out.println("Press 3 for Exit");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:

				System.out.println("Enter your Employee Id: ");
				String eId = sc.next();

				System.out.println("Enter the Employee Name: ");
				String name = sc.next();

				System.out.println("Please Enter you department: ");
				String department = sc.next();

				String type = "Permanent";

				double salary = 0;
				double hra;

				// taking baseSalary
				while (running) {
					try {
						System.out.println("Enter your base Salary: ");
						double temp = sc.nextDouble();
						validSalary(temp);
						salary = temp;
						break;
					} catch (InvalidAmountException e) {
					}
				}

				// taking HRASalary
				while (true) {
					try {
						System.out.println("Please enter your HRA: ");
						double temp = sc.nextDouble();
						validHRA(temp);
						hra = temp;
						break;
					} catch (InvalidAmountException e) {

					}
				}

				PermanentEmployee pe = new PermanentEmployee(eId, name, department, type, salary, hra);

				System.out.println(pe.toString());
				emp.add(pe);

				break;
			case 2:
				
				String cName;
				int totalHours;
				double hourlyRate;
				double CHRA;
				
				System.out.println("Enter your Employee Id: ");
				String cEmpId = sc.next();
				sc.nextLine();
//				================================================

				while(true) {
					try {
						System.out.println("Enter the Employee Name: ");
						String temp = sc.nextLine().trim();
						
						validName(temp);
						cName=temp;
						break;
					} catch (IllegalArgumentException e) {
						System.err.println(e.getMessage());
						
					}

//					===============================================
				}

				System.out.println("Please Enter you department: ");
				String cDepartment = sc.next();

				String cType = "Contractual";
				

				// taking totalHours
				while (true) {
					try {
						System.out.println("Enter your Hours : ");
						int temp = sc.nextInt();
						validHours(temp);
						totalHours = temp;
						break;
					} catch (InputMismatchException e) {
						System.out.println("Only numbers are allowed!");
						sc.nextLine();
					} catch (InvalidAmountException e) {
					}
				}

				// taking hourlyRate
				while (true) {
					try {
						System.out.println("Enter your HourlyRate : ");
						int temp = sc.nextInt();

						validHours(temp);
						hourlyRate = temp;
						break;
					} catch (InputMismatchException e) {
						System.err.println("Only numbers are allowed!");
						sc.nextLine();
					} catch (InvalidHoursException e) {
					}
				}

				// taking HRA_Salary
				while (true) {
					try {
						System.out.println("Please enter your HRA: ");
						double temp = sc.nextDouble();
						validHRA(temp);
						CHRA = temp;
						break;
					} catch (InputMismatchException e) {
						System.err.println("Only numbers are allowed!");
						sc.nextLine();
					} catch (InvalidHoursException e) {
					}
				}

				ContractualEmployee ce = new ContractualEmployee(cEmpId, cName, cDepartment, cType, totalHours,
						hourlyRate, CHRA);
				System.out.println(ce.toString());
				emp.add(ce);
				break;
			case 3:
				System.out.println("Thank you, Have a nice Day!");
				running = false;
				break;
			default:
				System.out.println("Please select the valid option.");
				running=true;
				break;
			}
			if(!running)System.out.println(emp);
		}

	}

	private static void validName(String cName) {

	    if (!cName.matches("^[a-zA-Z]+( [a-zA-Z]+)*$") || cName.length() < 3) {
	        throw new IllegalArgumentException(
	                "Invalid Name! Only alphabets and single spaces allowed. Minimum 3 characters.");
	    }
	}


	private static void validHours(int sal) {
		if (sal <= 0) {
			throw new InvalidHoursException(" Invalid Hours!! Please try again.");
		}
	}

	private static void validHRA(double sal) {
		if (sal <= 0) {
			throw new InvalidAmountException(true);
		}

	}

	private static void validSalary(Double sal) throws RuntimeException {
		if (sal <= 0) {
			throw new InvalidAmountException(false);
		}
	}
}
