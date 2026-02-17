package com.insurancemajortak.www;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PolicyService service = new PolicyService();

		while (true) {

			System.out.println("\n====== Insurance Policy Management ======");
			System.out.println("1. Add Policy");
			System.out.println("2. Find you Policy.");
			System.out.println("3. Locate Policy");
			System.out.println("4. Display Active Policies");
			System.out.println("5. Group Policies by Type");
			System.out.println("6. Find Highest Premium Policy");
			System.out.println("7. Remove Expired Policies");
			System.out.println("8. Exit");
			System.out.print("Choose option: ");

			int choice = sc.nextInt();
			sc.nextLine();

			try {
				switch (choice) {
				case 1:
					System.out.print("Enter Policy Number: ");
					int number = sc.nextInt();
					sc.nextLine();

					System.out.print("Enter Customer Name: ");
					String name = sc.nextLine();

					System.out.print("Enter Policy Type [HEALTH/LIFE/VEHICLE/TRAVEL] ");
					String typeInput = sc.nextLine().toUpperCase();

					String type;
					try {
						type = sc.nextLine().toUpperCase();
					} catch (IllegalArgumentException e) {
						throw new InvalidPolicyTypeException("Invalid Policy Type Entered!");
					}

					System.out.print("Enter Customer Age: ");
					int age = sc.nextInt();

					System.out.print("Enter Base Premium: ");
					double premium = sc.nextDouble();
					sc.nextLine();

					System.out.print("Enter Policy Status (ACTIVE/EXPIRED): ");
					String status = sc.nextLine().toUpperCase();

					InsurancePolicy policy = new InsurancePolicy(number, name, type, age, premium, status);

					service.addPolicy(policy);
					break;

				case 3:
					System.out.print("Enter Policy Number to Locate: ");
					int searchNumber = sc.nextInt();
					sc.nextLine();
					service.locatePolicy(searchNumber);
					break;

				case 4:
					service.displayActivePolicies();
					break;

				case 5:
					service.groupPoliciesByType();
					break;

				case 6:
					service.findHighestPremiumPolicy();
					break;

				case 7:
					service.removeExpiredPolicies();
					break;

				case 8:
					System.out.println("Exiting... Thank You!");
					System.exit(0);

				default:
					System.out.println("Invalid Choice!");
				}

			} catch (InvalidPolicyTypeException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Something went wrong: " + e.getMessage());
			}
		}
	}
}
