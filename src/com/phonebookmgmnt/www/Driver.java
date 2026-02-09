package com.phonebookmgmnt.www;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\nChoose any one option:");

			System.out.println("Press 1 for add contact.");
			System.out.println("Press 2 for delete contact.");
			System.out.println("Press 3 to view all contact.");
			System.out.println("Press 4 for exit.\n");

			System.out.print("Enter your option:");
			int ch = sc.nextInt();
			System.out.println();
			sc.nextLine();

			switch (ch) {

			// add user
			case 1:
				String newMemberUser;

				while (true) {
					System.out.print("Please Enter the person Name: ");
					newMemberUser = sc.nextLine().trim();

					if (newMemberUser.isEmpty()) {
						System.out.println("Name cannot be empty.");
					} else if (!newMemberUser.matches("[a-zA-Z ]+")) {
						System.out
								.println("Name should contain letters only. No numbers or special characters allowed.");
					} else {
						break;
					}
				}

				long newMemberNumber = 0;

				while (true) {
					try {
						System.out.print("Please Enter the person contact Number: ");
						newMemberNumber = sc.nextLong();
						sc.nextLine(); // clear buffer

						if (String.valueOf(newMemberNumber).length() == 10) {
							break; // valid number
						} else {
							System.err.println("Invalid number. Enter exactly 10 digits.");
						}

					} catch (InputMismatchException e) {
						System.err.println("Please enter digits only. No alphabets allowed.");
						sc.nextLine(); // consume Enter as well here
					}
				}

				Contact newContact = new Contact(newMemberUser, newMemberNumber);
				PhoneBook.addContact(newContact);
				System.out.println("Contact saved succesfully.");
				break;

			// delete user
			case 2:
				long numToDelete = 0;
				while (true) {
					try {
						System.out.println("Enter the contact Number you want to delete: ");
						long temp = sc.nextLong();
						sc.nextLine();

						if (String.valueOf(temp).length() == 10) {
							numToDelete = temp;
							break;
						} else {
							System.err.println("Invalid number. Enter exactly 10 digits.");
						}
					} catch (InputMismatchException e) {
						System.err.println("Please enter digits only. No alphabets allowed.");
						sc.nextLine();
					}
				}
				break;

			// delete user
			case 3:
				PhoneBook.viewAllContacts();
				break;

			// view all
			case 4:
				System.out.println("Thank you for using Phone book, Good Bye!");
				return;

			// if user gives wrong input
			default:
				System.out.println("Please select valid option.");
				break;

			}
		}
	}
}