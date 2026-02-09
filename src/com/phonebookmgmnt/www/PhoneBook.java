package com.phonebookmgmnt.www;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

	private static List<Contact> contacts = new ArrayList<Contact>();

	public static void addContact(Contact newContact) {
		contacts.add(newContact);
	}

	public static void deleteContact(long numToDelete) {
		boolean deleted = false;
		for (Contact targetNum : contacts) {
			if (targetNum.getNumber() == numToDelete) {
				contacts.remove(targetNum);
				deleted = true;
				break;
			}

		}
		if (deleted)
			System.out.println("Conatct " + numToDelete + " deleted succesfully.");
		else {
			System.out.println(numToDelete + " is not present is the list.");
		}

	}

	public static void viewAllContacts() {
		if (contacts.size() == 0) {
			System.out.println("\nNothing is present in phone book.");
		} else {
			System.out.println("\nThese are the list of all contact List.\n");

			for (Contact contact : contacts) {
				System.out.println("Name: " + contact.getName() + " | Number: " + contact.getNumber());
			}

		}

	}

}