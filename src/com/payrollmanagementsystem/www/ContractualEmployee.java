package com.payrollmanagementsystem.www;

public class ContractualEmployee implements Employee {

	String empId;
	String name;
	String department;
	String type;
	int totalHours;
	double hourlyRate;
	double hra;

	public ContractualEmployee(String empId, String name, String department, String type, int totalHours, double hourlyRate,
			double hra) {
		super();
		this.empId = empId;
		this.name = name;
		this.department = department;
		this.type = type;
		this.totalHours = totalHours;
		this.hourlyRate = hourlyRate;
		this.hra = hra;
	}

//	Contractual Employee: Salary = Hours Worked × Hourly Rate
//	Tax: 10% of Calculated Salary

	double inHandSalary;

	@Override
	public double calculatedSalary() {
		inHandSalary = totalHours * hourlyRate;
		inHandSalary = inHandSalary - (inHandSalary * 0.10);
		return inHandSalary;
	}
	
	public String toString() {
		return "========== Employee Details ==========\n"
				+ "Employee ID      : " + empId + "\n"
				+ "Employee Name    : " + name + "\n"
				+ "Department       : " + department + "\n"
				+ "Employment Type  : " + type + "\n"
				+ "Total Hours      : " + totalHours + "\n"
				+ "Hourly Rate      : ₹" + hourlyRate + "\n"
				+ "HRA              : ₹" + hra + "\n"
				+ "In-Hand Salary   : ₹" + calculatedSalary() + "\n"
				+ "======================================" ;
	}
}
