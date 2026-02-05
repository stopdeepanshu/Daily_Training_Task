package AccountTaskOOPs;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Taking customer details
		System.out.print("Enter Customer ID: ");
		String customerId = sc.nextLine();

		System.out.print("Enter Customer Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Customer Email: ");
		String email = sc.nextLine();

		Customer cust1 = new Customer(customerId, name, email);

		SavingAccount sa = new SavingAccount();

		while (true) {

			System.out.println("Press 1 : for WithDraw.");
			System.out.println("Press 2 : for Deposit.");
			System.out.println("Press 3 : for check balance.");
			System.out.println("Press 4 : for Exit.");

			System.out.println("\nEnter your choice:");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				// Taking withdraw amount
				System.out.print("Enter amount to withdraw: ");
				int withdrawAmount = sc.nextInt();
				sa.withdraw(withdrawAmount);

				break;

			case 2:
				// Taking deposit amount
				System.out.print("Enter amount to deposit: ");
				int depositAmount = sc.nextInt();
				sa.deposit(depositAmount);

				break;
			case 3:
				// checking current balance
				sa.currentBalance();
				break;

			case 4:
				System.out.println("Thank you for contacting us.\n");
				return;
			
		    default: // Take the exit
			  System.out.println("Please enter valid choice.");  
			}
		}
	}
}
