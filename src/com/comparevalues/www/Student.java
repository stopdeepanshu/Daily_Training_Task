package com.comparevalues.www;

import java.util.Comparator;

public class Student  {

	private int age;
	private String sName;
	private String sCourse;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//Constructor
	public Student(int age, String sName, String sSubject) {
		super();
		this.age = age;
		this.sName = sName;
		this.sCourse = sSubject;
	}
	
	//Getter and Setter
	public int getAge() {
		return age;
	}
	public String getsName() {
		return sName;
	}
	public String getsSubject() {
		return sCourse;
	}

	@Override
	public String toString() {
		return "Student Age: "+age
				+"\nStudent Name: "+sName
				+"\nStudent Course: "+sCourse +"\n";
	}

	
}
