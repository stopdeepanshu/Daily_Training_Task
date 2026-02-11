package com.policymgmnt.www;

public class InvalidPolicyTypeException extends Exception {

	InvalidPolicyTypeException(String mssg) {
		super("Please enter valid Input.");
		
	}
}
