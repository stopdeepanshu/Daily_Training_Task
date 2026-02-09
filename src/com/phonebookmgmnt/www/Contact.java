package com.phonebookmgmnt.www;

public class Contact {
	private String Name;
	private long Number;

	public Contact(String phoneName, long phoneNumber) {
		this.Name = phoneName;
		this.Number = phoneNumber;
	}

	@Override
	public String toString() {
	    return "Name: " + Name + ", Number: " + Number;
	}

	
	public String getName() {
		return Name;
	}

	public long getNumber() {
		return Number;
	}

}