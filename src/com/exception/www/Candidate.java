package com.exception.www;

public class Candidate {
	String name;
	int age;
	String gender;
	String contact;

	public Candidate(String name, int age, String gender, String contact) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.contact = contact;
	}
	
	public String toString() {
		return "\n Candidate Name: "+ name+"\n Candidate Age: "+ age+"\n Candidate Gender: "+gender+"\n Contact: "+contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
