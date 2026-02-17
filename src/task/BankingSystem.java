package task;

import java.util.Scanner;

public class BankingSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		 
		while(true) {
		    System.out.print("Enter your name: ");
		    name = sc.nextLine();

		    if (name.matches("[a-zA-Z ]+")) {
		        break;
		    } else {
		        System.out.println("Please enter only alphabets (no numbers or symbols).");
		    }
		}
		
		
		int currentBalance = 80000;
		int withDrawAmt=0;
		System.out.println("Your current balance is " + currentBalance+".");
	
		System.out.print("Please enter the amount you want to withdraw: ");
		
		if (sc.hasNextInt()) {
		    withDrawAmt = sc.nextInt();
		    System.out.println("You entered: " + withDrawAmt);
		} else {
		    System.out.println("Invalid input enter digits only.");
		}   
		
		

		if (withDrawAmt < 0) {
			System.out.print("Please type a valid amount to withdraw.");
		} else if (withDrawAmt > currentBalance) {
			System.out.println("Transaction Rejected because of insufficient amount.");
		} else if (withDrawAmt < currentBalance) {
			System.out.println( "₹ "+withDrawAmt + name+" amount is debited from your account & your current Balance is "+(currentBalance-withDrawAmt));
		}
		sc.close();
	}
}
