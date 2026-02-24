package com.training.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	private String empName;
	private double salary;
	
	
	public Employee(String empName, double salary) {
		this.empName=empName;
		this.salary=salary;
	}
	@OneToOne(cascade= CascadeType.ALL)
	private Department dept;
	
}
