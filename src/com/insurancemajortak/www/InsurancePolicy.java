package com.insurancemajortak.www;

public class InsurancePolicy {

	private int policyNumber;
	private String customerName;
	private String policyType;
	private int customerAge;
	private double basePremium;
	private double finalPremium;
	private String policyStatus;

	public InsurancePolicy(int policyNumber, String customerName, String policyType,
			int customerAge, double basePremium, String policyStatus) {

		this.policyNumber = policyNumber;
		this.customerName = customerName;
		this.policyType = policyType.toUpperCase();   // to avoid case issues
		this.customerAge = customerAge;
		this.basePremium = basePremium;
		this.policyStatus = policyStatus.toUpperCase();

		calculatePremium();
	}

	// Premium Calculation
	public void calculatePremium() {

		switch (policyType) {

		case "HEALTH":
			finalPremium = basePremium + (basePremium * 0.20);
			break;

		case "LIFE":
			finalPremium = basePremium + (basePremium * 0.35);
			break;

		case "VEHICLE":
			finalPremium = basePremium + (basePremium * 0.15);
			break;

		case "TRAVEL":
			finalPremium = basePremium + (basePremium * 0.10);
			break;

		default:
			System.out.println("Invalid Policy Type!");
			finalPremium = basePremium;
		}
	}

	// Getters & Setters

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType.toUpperCase();
		calculatePremium(); // recalculate when type changes
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public double getBasePremium() {
		return basePremium;
	}

	public void setBasePremium(double basePremium) {
		this.basePremium = basePremium;
		calculatePremium(); // recalculate when base changes
	}

	public double getFinalPremium() {
		return finalPremium;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus.toUpperCase();
	}

	@Override
	public String toString() {
		return "PolicyNumber=" + policyNumber +
				", Name=" + customerName +
				", Type=" + policyType +
				", Age=" + customerAge +
				", BasePremium=" + basePremium +
				", FinalPremium=" + finalPremium +
				", Status=" + policyStatus;
	}
}
