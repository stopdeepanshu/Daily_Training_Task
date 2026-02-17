package com.payrollmanagementsystem.www;

public class InvalidAmountException extends RuntimeException{

	public InvalidAmountException(boolean isHRAException) {
		
		super(isHRAException
				?"Invalid HRA! It must be a number greater than zero."
				: "Invalid Salary! It must be a number greater than zero.");
	}
}
