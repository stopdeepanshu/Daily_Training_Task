package com.lambdatask.www;

import java.util.function.Supplier;

public class OTPDriver {
	public static void main(String[] args) {
		
		Supplier<Integer> otpGenerate=()->(int)(Math.random()*900000)+100000;
		
		for (int i = 0; i <10; i++) {
			System.out.println(otpGenerate.get());
		}
	}
}
