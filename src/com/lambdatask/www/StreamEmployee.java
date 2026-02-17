package com.lambdatask.www;

public class StreamEmployee {
	private int eId;
	private String empName;
	private double empSal;

	// constructor
	public StreamEmployee(int eId, String empName, double empSal) {

		this.eId = eId;
		this.empName = empName;
		this.empSal = empSal;
	}

	// StreamEmployee
	@Override
	public String toString() {
		return "Employee Id: " + eId + "\nEmp Name: " + empName + "\nEmpSal: " + empSal;
	}

	// getter and setter
	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

}
