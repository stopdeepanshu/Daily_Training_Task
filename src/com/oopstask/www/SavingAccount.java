package com.oopstask.www;

public class SavingAccount extends Account {

	int mininumBalance = 2000;

	@Override
	public void withdraw(int withAmt) {
		
		if (withAmt < balance) {

			int temp = balance - withAmt;
			if (temp < mininumBalance) {
				System.out.println("Insufficient Fund, crossing minimum balance limit.");
			} else {
				balance = balance - withAmt;

				System.out.println("Amount debited succesfully. Your current balance is " + balance);
			}
		} else {
			System.out.println("Insufficient Fund. Please check balance.");
		}
	}

	@Override
	public void deposit(int depoAmt) {
		balance = balance + depoAmt;
		System.out.println("Amount credited succesfully. Your current balance is " + balance);

	}

}
