package com.payrollmanagementsystem.www;

public class InvalidAmountException extends RuntimeException{

	public InvalidAmountException(boolean isHRAException) {
		
		if(isHRAException) {
			System.err.println("Invalid HRA!! Should be in digit and always greater than zero.");
		}else {
			System.err.println("Invalid Salary!! Should be in digit and always greater than zero.");
		}
	}
}
