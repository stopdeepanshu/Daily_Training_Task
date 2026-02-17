package com.oopstask.www;

public class Customer {
	String custId;
	String custName;
	String email;

	public Customer(String custId, String custName, String email) {
		this.custId = custId;
		this.custName = custName;
		this.email = email;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
