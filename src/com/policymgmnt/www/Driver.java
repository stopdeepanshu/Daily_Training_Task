package com.policymgmnt.www;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("\nWELCOME TO THE POLICY MANAGEMENT SYSTEM\n");
			System.out.println("\nPress 1: Add the new policy.");
			System.out.println("Press 2: To find Policy Details.");
			System.out.println("Press 3: Display all Active policies.");
			System.out.println("Press 4: Display all the policies.");
			System.out.println("Press 5: Remove expired policies.");
			System.out.println("Press 6: Count of policies on the basis of policy type.");
			System.out.println("Press 7: Exit \n");

			System.out.println("Choose your option: ");
			int ch = sc.nextInt();

			switch (ch) {

			// add new policies
			case 1:

				int policyNo = 0;
				while (true) {
					try {
						System.out.println("Enter the policy number: ");
						policyNo = sc.nextInt();
						sc.nextLine();

						if (policyNo <= 0) {
							throw new IllegalArgumentException("Policy number must be greater than 0.");
						}

						break;

					} catch (IllegalArgumentException e) {
						System.err.println("Error: " + e.getMessage());
					} catch (Exception e) {
						System.err.println("Invalid input! Please enter a numeric value.");
						sc.nextLine();
					}
				}

				String policyHolder = null;

				while (true) {
					try {
						System.out.println("Enter the policy holder name: ");
						policyHolder = sc.nextLine().trim();

						if (policyHolder.isEmpty()) {
							throw new IllegalArgumentException("Name cannot be empty.");
						}

						if (!policyHolder.matches("[a-zA-Z ]+")) {
							throw new IllegalArgumentException("Name must contain only alphabets.");
						}

						break;

					} catch (IllegalArgumentException e) {
						System.err.println("Error: " + e.getMessage());
					}
				}

				PolicyType policyType = null;
				try {
					System.out.println("Enter the Policy Type: (HEALTH / LIFE / VEHICLE / TRAVEL)");
					String type = sc.nextLine();
					policyType = PolicyType.valueOf(type.toUpperCase());
				} catch (IllegalArgumentException e) {
					e.getMessage();
				}

				int age = 0;

				while (true) {
					try {
						System.out.println("Enter customer age:");
						age = sc.nextInt();
						sc.nextLine();

						if (age <= 0) {
							throw new IllegalArgumentException("Age must be greater than 0.");
						}

						if (age < 18) {
							throw new IllegalArgumentException("Customer must be at least 18 years old.");
						}

						break;

					} catch (IllegalArgumentException e) {
						System.err.println("Error: " + e.getMessage());
					} catch (Exception e) {
						System.err.println("Invalid input! Please enter a numeric value.");
						sc.nextLine();
					}
				}

				double basePremium = 0;

				while (true) {
					try {
						System.out.println("Enter base premium:");
						basePremium = sc.nextDouble();
						sc.nextLine();

						if (basePremium <= 0) {
							throw new IllegalArgumentException("Base premium must be greater than 0.");
						}

						break;

					} catch (IllegalArgumentException e) {
						System.out.println("Error: " + e.getMessage());
					} catch (Exception e) {
						System.err.println("Invalid input! Please enter a valid numeric amount.");
						sc.nextLine();
					}
				}

				PolicyStatus policyStatus = null;

				try {
					System.out.println("Enter the Policy Status: (ACTIVE / EXPIRED)");
					String status = sc.next();
					policyStatus = PolicyStatus.valueOf(status.toUpperCase());
				} catch (IllegalArgumentException e) {
					e.getMessage();
				}

				InsurancePolicy newPolicy = new InsurancePolicy(policyNo, policyHolder, policyType, age, basePremium,
						policyStatus);
				Service.addPolicy(newPolicy);
				break;

			// find policy details
			case 2:
				System.out.println("Enter the policy number: ");
				int findPolicy = sc.nextInt();
				Service.findByPolicyNumber(findPolicy);
				break;

			// display all active details
			case 3:
				Service.displayActivePolicies();

				break;
			// display all polic0ies
			case 4:
				Service.displayAllPolicies();

				break;
			// remove expired policies
			case 5:
				Service.removeExpiredPolicies();

				break;
			// count of policies on the basis of policy types.
			case 6:
				try {
					Service.countByPolicyType();
				} catch (InvalidPolicyTypeException e) {
					e.printStackTrace();
				}
				break;
			// exit
			case 7:
				System.out.println("Thank you for visiting, have a great day!");
				return;

			default:
				System.err.println("Invalid Option! Please mention valid option.");
			}
		}
	}

}
