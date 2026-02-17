package com.phonebookusingmap.www;

public class MapContact {
	private String Name;
	private long Number;

	public MapContact(String phoneName, long phoneNumber) {
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
