package com.seocndlambdatask.www;

public class Employee {
	String name;
	int age;
	double salary;

	// constructor
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
	    return "Name: " + name +
	           ", Age: " + age +
	           ", Salary: " + salary;
	}


	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
