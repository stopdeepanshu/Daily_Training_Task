package com.insurancetask.www;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {

		while (true) {
			System.out.println("Enter your choice:");

			System.out.println("Enter 1 for Health Insurance.");
			System.out.println("Enter 2 for Life Insurance.");
			System.out.println("Enter 3 for Vehicle Insurance.");
			System.out.println("Enter 4 for exit.");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				// Health Insurance

				System.out.print("Enter policy holder name: ");
				String policyHolder = sc.nextLine();
				sc.next();
				System.out.print("Enter age: ");
				int age = sc.nextInt();

				System.out.print("Enter sum assured: ");
				double sumAssured = sc.nextDouble();

				Insurance health = new HealthInsurance(policyHolder, age, sumAssured);
				health.calculateAnnualPremium();
				break;
			case 2:
				// Life Insurance

				System.out.print("Enter policy holder name: ");
				String LifeCustName = sc.nextLine();
				sc.next();
				System.out.print("Enter sum assured: ");
				double lifeSumAssured = sc.nextDouble();

				System.out.print("Enter policy term (in years): ");
				int policyTerm = sc.nextInt();

				Insurance life = new LifeInsurance(LifeCustName, lifeSumAssured, policyTerm);
				life.calculateAnnualPremium();

				break;
			case 3:
				// Vehicle Insurance

				System.out.print("Enter policy holder name: ");
				String vehiCustname = sc.nextLine();

				System.out.print("Enter vehicle type (2 for TwoWheeler, 4 for FourWheeler): ");
				int vehicleType = sc.nextInt();

				System.out.print("Enter vehicle value: ");
				double vehicleValue = sc.nextDouble();

				Insurance vehicle = new VehicleInsurance(vehiCustname, vehicleType, vehicleValue);
				vehicle.calculateAnnualPremium();

				break;
			case 4:

				return;

			default:
				System.out.println("Invalid Input");
			}

		}
	}
}
