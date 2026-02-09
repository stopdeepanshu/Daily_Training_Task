package com.comparevalues.www;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Driver {
	public static void main(String[] args) {

		Set<Student> set = new TreeSet<Student>(new SortByNameUSingComparator());

		set.add(new Student(10, "Deepanshu", "Java"));
		set.add(new Student(20, "Bottle", "Struts"));
		set.add(new Student(30, "Bisleri", "AWS"));
		set.add(new Student(40, "Projector", "Machine Learning"));

		for (Student s : set) {
			System.out.println(s);
		}
	}
}
