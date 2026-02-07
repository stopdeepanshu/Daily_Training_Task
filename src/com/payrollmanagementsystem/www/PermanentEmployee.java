package com.payrollmanagementsystem.www;







public class PermanentEmployee implements Employee {
	
	String empId;
	String name;
	String department;
	String type;
	double baseSalary;
	double hra;

	public PermanentEmployee(String empId, String name, String department, String type, double baseSalary, double hra) {
	
		this.empId = empId;
		this.name = name;
		this.department = department;
		this.type = type;
		this.baseSalary = baseSalary;
		this.hra = hra;
	}

  //Permanent Employee: Salary = Base Salary + HRA

	double inHandSalary;

	@Override
	public double calculatedSalary() {
		inHandSalary = baseSalary + hra;
		return inHandSalary;
	}

	@Override
	public String toString() {
		return "========== Employee Details ==========\n"
				+" Employee Id: " + empId
				+ "\n Employee Name: " + name
				+ "\n Department: " + department
				+ "\n Employment Type: " + type
				+ "\n Base Salary: ₹" + baseSalary
				+ "\n HRA: ₹" + hra
				+ "\n Your In-Hand Salary: ₹" + calculatedSalary()+"\n"
				+ "======================================";
	}


}
