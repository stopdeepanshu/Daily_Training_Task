package com.lambdatask.www;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PaymentDriver {
	public static void main(String[] args) throws InvalidSalaryException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Payemnt ID: ");
		String pId = sc.next();

		double pAmt = 0;

		while (true) {
			try {
				System.out.println("Enter your Payment Amount: ");
				double temp = sc.nextDouble();

				Predicate<Double> positiveSal = (a) -> a > 0;
				if (positiveSal.test(temp)) {
					pAmt = temp;
					break;
				} else
					System.err.println("Please Enter the positive salary");
			} catch (InputMismatchException e) {
				System.err.println("Enter the valid amount.");
				sc.nextLine();
			}
		}

		String paymentStatus;
		System.out.println("Enter the Status of the Payment(Success(S)/Fail(F)): ");
		String temp = sc.next().trim();
		paymentStatus = temp.equalsIgnoreCase("S") ? "Success" : "Failed";

		Payment p1 = new Payment(pId, pAmt, paymentStatus);
		Consumer<Double> sal = (a) -> System.out.println("\nThis is the Payment Amount ₹" + a);
		sal.accept(pAmt);

		Supplier<String> finalOutput = () -> "Reference Number of payment is: PYMT" + pId + ".";
		System.out.println(finalOutput.get());

		System.out.println("\n============Payment Receipt==============");
		System.out.println(p1 + "\nReference Number: " + finalOutput.get());
	}

}
