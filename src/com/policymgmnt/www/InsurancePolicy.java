package com.policymgmnt.www;
public class InsurancePolicy {
	private int policyNumber;
	private String customerName;
	private PolicyType policyType; //
	private int customerAge;
	private double basePremium;
	private PolicyStatus policyStatus; //

	// constructor
	public InsurancePolicy(int policyNumber, String customerName, PolicyType policyType, int customerAge,
			double basePremium, PolicyStatus policyStatus) {
		super();
		this.policyNumber = policyNumber;
		this.customerName = customerName;
		this.policyType = policyType;
		this.customerAge = customerAge;
		this.basePremium = basePremium;
		this.policyStatus = policyStatus;

		calculatepremium();
	}

	@Override
	public String toString() {
		return " Policy Number: " + policyNumber + "\n Policy Holder Name: " + customerName + "\n Age: " + customerAge
				+ "\n Base Premium: " + basePremium + "\n Policy Status: " + policyStatus+"\n\n";
	}

	// calculate premium
	private void calculatepremium() {
		if (policyType == PolicyType.HEALTH) {
			basePremium = basePremium + (basePremium * 0.20);
		} else if (policyType == PolicyType.LIFE) {
			basePremium = basePremium + (basePremium * 0.35);
		} else if (policyType == PolicyType.VEHICLE) {
			basePremium = basePremium + (basePremium * 0.15);
		} else if (policyType == PolicyType.TRAVEL) {
			basePremium = basePremium + (basePremium * 0.10);
		}
	}

	// getter and setter
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

	public PolicyType getPolicyType() {
		return policyType;
	}

	public void setPolicyType(PolicyType policyType) {
		this.policyType = policyType;
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
	}

	public PolicyStatus getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(PolicyStatus policyStatus) {
		this.policyStatus = policyStatus;
	}

}
