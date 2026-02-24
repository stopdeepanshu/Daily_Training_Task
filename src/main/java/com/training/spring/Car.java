package com.training.spring;

import lombok.Data;

@Data
public class Car {
	private String make;
	private String model;
	private int year;


	public String getCarDetails() {
		return make + " : " + model + " : " + year;
	}

}
