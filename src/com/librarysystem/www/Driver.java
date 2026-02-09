package com.librarysystem.www;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("Press 1 to add the Member.");
			System.out.println("Press 2 to remove the Member.");
			System.out.println("Press 3 to exit.\n");
			System.out.println("Enter your choice: ");
			int ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {

			case 1:

				int mId = 0;
				String mName = "";
				String mAdd = "";

				while (true) {
					try {
						System.out.println("Please enter the ID of the new member: ");
						mId = sc.nextInt();
						sc.nextLine();

						if (mId <= 0) {
							System.err.println("ID must be greater than 0.");
						} else {
							break;
						}
					} catch (InputMismatchException e) {
						System.err.println("Invalid ID, Please enter numbers only");
						sc.nextLine();
					}
				}

				while (true) {

					System.out.println("Enter the Name of the member: ");
					String temp = sc.nextLine();

					if (temp.isEmpty()) {
						System.err.println("Name can't be empty.");
					} else if (!temp.matches("[a-zA-Z ]+")) {
						System.err.println("invalid name,Enter letters only.");
					} else {
						mName = temp;
						break;
					}

				}

				while (true) {
					try {
						System.out.println("Enter the Address of the member: ");
						String addtemp = sc.nextLine().trim();

						if (addtemp.isEmpty()) {
							System.out.println("Address can't be empty.");
						} else if (addtemp.matches("[0-9]+")) {
							System.err.println("Address can't contain numebrs only.");
						} else {
							mAdd = addtemp;
							break;
						}
					} catch (InputMismatchException e) {
					}

				}

				Member member = new Member(mName, mId, mAdd);
				try {
					Library.addMember(member);
					System.out.println("Member Added Successfully.\n");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			case 2:
				System.out.println("Enter the member ID to delete from DB: ");
				int idToDelete = sc.nextInt();

				try {
					boolean deleted = Library.deleteMember(idToDelete);
					if (deleted)
						System.out.println("Member deleted succesfully whose id is" + idToDelete);
					else {
						System.err.println("This " + idToDelete + " is not found.");
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}

				break;
			case 3:
				System.out.println("Thank you for contacting!");
				return;
			default:
				System.out.println("Please enter the valid input.");

			}
		}

	}

}