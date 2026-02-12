package com.practisetopics.www;

import java.util.function.BiFunction;

public class BiFunctionProgram {
	public static void main(String[] args) {

		BiFunction<Integer, Integer, Integer> p=(a,b)->a*b;
		
		System.out.println(p.apply(4, 5));
	}
}
