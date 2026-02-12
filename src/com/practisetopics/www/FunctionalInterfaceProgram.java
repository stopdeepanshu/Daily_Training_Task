package com.practisetopics.www;

interface Perform {
	int mult(int a, int b);
}


public class FunctionalInterfaceProgram {

	public static void main(String[] args) {
		Perform per=(a,b)->a*b;
		
		System.out.println(per.mult(7,4));
	}
}
