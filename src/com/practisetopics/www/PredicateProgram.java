package com.practisetopics.www;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateProgram {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Deepanshu", "Leepakshi", "kanak", "Suman ji");
		Predicate<String> pred = name -> name.startsWith("S");

		names.stream().filter(pred).forEach(System.out::println);
	}
}

//Predicate<Integer> pred= sal->sal>50000;
//
//System.out.println(pred.test(400));
//System.out.println(pred.test(400000));
//System.out.println(pred.test(40000));