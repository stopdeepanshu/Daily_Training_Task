package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Person {

	private String firstName;
	private String lastName;
	private int age;
	
	
	private Car car;

	public Person(int age) {
		this.age = age;
	}
	
	public String getPersonDetails() {
        return firstName + " " + age + " " + car.getCarDetails();
	}


}
