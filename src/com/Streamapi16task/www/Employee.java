package com.Streamapi16task.www;

public class Employee {

	private String empId;
	private String empName;
	private double salary;
	private int age;
	private String department;

	@Override
	public String toString() {
		return "EmpId=" + empId + ", empName=" + empName + ", Salary=" + salary + ", age=" + age + ", department="
				+ department;
	}

	public Employee(String empId, String empName, double salary, int age, String department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.age = age;
		this.department = department;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
