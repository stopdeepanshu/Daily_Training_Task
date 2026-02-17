package com.orderapplication.www;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {

		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose any one option");

			System.out.println("1. Restaurent");
			System.out.println("2. Cloud Kitchen");
			System.out.println("3. Grocery");
			System.out.println("4. Exit");
			System.out.println();
			System.out.println("Enter your choice: ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("============Restraunt =============");
				System.out.println("Enter customer name: ");
				String name = sc.next();
				
				System.out.println("Enter order amount: ");
				double amount = sc.nextDouble();

				System.out.println("Enter GST percentage: ");
				double gst = sc.nextDouble();

				RestaurantOrders order = new RestaurantOrders(name, amount, gst);
				order.calculateFinalAmount();
				break;
			case 2:
				System.out.println("============Cloud Kitchen =============");
				System.out.println("Enter customer name: ");
				String ckName = sc.next();
				
				System.out.println("Enter order amount: ");
				double orderAmount = sc.nextDouble();

				System.out.println("Enter delivery distance (in km): ");
				double distance = sc.nextDouble();

				System.out.println("Enter bill amount: ");
				double billAmt = sc.nextDouble();

				CloudKitchenOrders ckorder = new CloudKitchenOrders(ckName, orderAmount, distance, billAmt);

				ckorder.calculateFinalAmount();

				break;
			case 3:
				System.out.println("============Grocery =============");
				System.out.print("Enter customer name: ");
				String grocCustName = sc.next();

				System.out.print("Enter order amount: ");
				double grocCustAmount = sc.nextDouble();

				System.out.print("Are you a membership holder? (true/false): ");
				boolean isMember = sc.nextBoolean();

				GroceryOrders groicOrder = new GroceryOrders(grocCustName, grocCustAmount, isMember);

				groicOrder.calculateFinalAmount();
				
				break;
			case 4:
				System.out.println("Thanks You! Bye!");
				return;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}
