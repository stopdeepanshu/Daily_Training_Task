package com.multithreadingmajortask.www;

public class Customer {
	private int customerId;
	private String customerName;
	private String phoneNumber;
	private double balance;

	private static final double callCharge = 2.0;

	public Customer(int customerId, String customerName, String phoneNumber, double balance) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
	}

	public void makeCall(int minutes) throws InsufficientBalanceException {
		double cost = minutes * callCharge;

		if (balance < cost) {
			throw new InsufficientBalanceException("Insufficient balance");
		}
	}

	public synchronized void makeRecharge(double amt) {
		balance = balance + amt;
		System.out.println("Recharge success of ₹" + amt);
	}

	public synchronized double getBalance() {
		return balance;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}
