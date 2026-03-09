package com.apps.addressbook.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	private String addressBookName;
	private List<Contact> contactList;

	public AddressBook(String addressBookName) {

		this.addressBookName = addressBookName;
		this.contactList = new ArrayList<>();
	}

	public String getAddressBookName() {
		return addressBookName;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	// UC7 Duplicate Check using Java Streams
	public void addContact(Contact contact) {

		boolean duplicate = contactList.stream().anyMatch(c -> c.getFirstName().equalsIgnoreCase(contact.getFirstName())
				&& c.getLastName().equalsIgnoreCase(contact.getLastName()));

		if (duplicate) {
			System.out.println("Duplicate Contact! Person already exists.");
			return;
		}

		contactList.add(contact);
		System.out.println("Contact added successfully.");
	}

	public void displayContacts() {

		for (Contact contact : contactList) {
			System.out.println(contact);
		}
	}

	public void editContact(String firstName) {

		Scanner sc = new Scanner(System.in);

		for (Contact contact : contactList) {

			if (contact.getFirstName().equalsIgnoreCase(firstName)) {

				System.out.println("Enter new Address:");
				contact.setAddress(sc.nextLine());

				System.out.println("Enter new City:");
				contact.setCity(sc.nextLine());

				System.out.println("Enter new State:");
				contact.setState(sc.nextLine());

				System.out.println("Enter new Zip:");
				contact.setZip(sc.nextLine());

				System.out.println("Enter new Phone:");
				contact.setPhoneNumber(sc.nextLine());

				System.out.println("Enter new Email:");
				contact.setEmail(sc.nextLine());

				System.out.println("Contact updated successfully.");
				return;
			}
		}

		System.out.println("Contact not found.");
	}

	public void deleteContact(String firstName) {

		for (int i = 0; i < contactList.size(); i++) {

			if (contactList.get(i).getFirstName().equalsIgnoreCase(firstName)) {

				contactList.remove(i);
				System.out.println("Contact deleted successfully.");
				return;
			}
		}

		System.out.println("Contact not found.");
	}
}