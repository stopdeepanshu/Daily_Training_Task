package com.insurancetask.www;

public class LifeInsurance implements Insurance {

	private String policyHolder;
	private double sumAssured;
	private int policyTerm;

	public LifeInsurance(String policyHolder, double sumAssured, int policyTerm) {
		super();
		this.policyHolder = policyHolder;
		this.sumAssured = sumAssured;
		this.policyTerm = policyTerm;

	}

	double rate = 5 / 100;

	@Override
	public void calculateAnnualPremium() {
		double monthlyPremium = (sumAssured * rate) / (policyTerm * 12);
		System.out.println("Your monthly premium is " + monthlyPremium);
		System.out.println("Your annual premium is " + monthlyPremium * 12);

	}
}
