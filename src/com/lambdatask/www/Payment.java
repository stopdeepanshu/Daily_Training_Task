package com.lambdatask.www;

public class Payment {

	String paymnentID;
	double paymentAmount;
	String paymentStatus;

	public Payment(String paymnentID, double paymentAmount, String paymentStatus) {
		super();
		this.paymnentID = paymnentID;
		this.paymentAmount = paymentAmount;
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "paymnentID : " + paymnentID + "\npaymentAmount : " + paymentAmount + "\npaymentStatus : "+ paymentStatus;
	}

}
