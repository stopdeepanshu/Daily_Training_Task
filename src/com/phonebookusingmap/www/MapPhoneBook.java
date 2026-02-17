package com.phonebookusingmap.www;

import java.util.HashMap;
import java.util.Map;

public class MapPhoneBook {

	private static Map<Long, String> contacts = new HashMap<Long, String>();

	public static void addContact(String name, long number) {
		contacts.put(number, name);
	}

	public static void deleteContact(long numToDelete) {
		for (Map.Entry<Long, String> targetNum : contacts.entrySet()) {
			if (targetNum.getKey() == numToDelete) {
				contacts.remove(numToDelete);
				System.out.println(numToDelete + " is deleted successfully.");
			}
		}
	}

	public static void viewAllContacts() {
		for (Map.Entry<Long, String> val : contacts.entrySet()) {
			System.out.println(val.getKey() + ":" + val.getValue());
		}
	}
}
