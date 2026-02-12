package com.practisetopics.www;

import java.util.function.Supplier;

public class SupplierProgram {
	public static void main(String[] args) {
		
		
		Supplier<String> mssg=()->"Hi Supplierrrrrrrrrrrrrrr";
		
		System.out.println(mssg.get());
		
		Supplier<Integer> otpGenerator=()->(int)(Math.random()*900000)+100000;
		System.out.println(otpGenerator.get());
		
		
		
	}
}
