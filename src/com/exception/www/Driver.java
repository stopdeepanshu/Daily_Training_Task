package com.exception.www;

import java.util.Scanner;

//Write a java code to register a candidate for Marathon
//the program should take name, age, gender and contact as input
//name should contain only string value with minimum 4 characters
//age should be between 18 to 60
//gender should have values like , Male/Female/Others
//contact should be numeric having exactly 10 digits
//All the exceptions should be handled properly and once user enters 
//all correct data, code should allow the user to register successfully.

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name;
		int age;
		String gender;
		String contact;

		// Name validation
		while (true) {
			try {
				System.out.println("Please enter the name of the Candidate: ");
				 name = sc.nextLine();

				validName(name);
				break;
			} catch (Exception e) {

			}
		}
		// Age Validation
		while (true) {
			try {
				System.out.println("Please enter your age: ");
				 age = sc.nextInt();
				validAge(age);
				break;
			} catch (Exception e) {

			}
		}
		// Gender Validation
		while (true) {
			try {
				System.out.println("Please enter your Gender(Male/Female): ");
				gender = sc.next();
				validGender(gender);
				break;
			} catch (Exception e) {

			}

		}
		// Contact Number Validation
		while (true) {
			try {
				System.out.println("Please enter your Contact Number: ");
				contact = sc.next();
				validContact(contact);
				break;
			} catch (Exception e) {

			}
		}

		Candidate c1=new Candidate(name, age, gender, contact);
		System.out.println(c1.toString());
		System.out.println("Candidate details saved succesfully.");
	}

	private static void validContact(String phone) throws Exception {
		if (phone.length() != 10) {
			System.err.println("Invalid Phone Number, Please try again.");
			throw new Exception();
		}
	}

	private static void validGender(String canGender) throws Exception {
		if (!(canGender.equalsIgnoreCase("Male") || canGender.equalsIgnoreCase("Female"))) {
			System.err.println("\"Invalid Gender! \"");
			throw new Exception();
		}

	}

	private static void validAge(int age) throws Exception {
		if (!(age >= 18 && age <= 60)) {
			System.err.println("Invalid Age! User age should be between 18 to 60.");
			throw new Exception();
		}
	}

	private static void validName(String name) throws Exception {

		if (!name.matches("[a-zA-Z ]+") || name.length() < 4) {
			System.err.println("\"Invalid Name! Name must contain only letters and minimum 4 characters.\"");
			throw new Exception();
		}
	}

}
