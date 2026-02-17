package com.lambdatask.www;

import java.util.function.BiFunction;

public class MaxDemo {
	public static void main(String[] args) {

		BiFunction<Integer, Integer, Integer> maxNum = (a, b) -> a > b ? a : b;
		System.out.println(maxNum.apply(5, 2));

	}
}
