package com.insurancetask.www;

public class HealthInsurance implements Insurance {
	private String policyHolder;
	private int age;
	private double basePremium=2000;
	private double sumAssured;

	public HealthInsurance(String policyHolder, int age, double sumAssured) {
		super();
		this.policyHolder = policyHolder;
		this.age = age;
		this.sumAssured = sumAssured;
	}

	@Override
	public void calculateAnnualPremium() {
		double calculate;
		if (age > 45) {
			calculate = basePremium + (basePremium * 0.20) ;

		} else {
			calculate = basePremium;
		}
		System.out.println("Your monthly Premium is " + calculate);
	}
}
