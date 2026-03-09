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

	public void addContact(Contact contact) {

		contactList.add(contact);
		System.out.println("Contact added successfully.");
	}

	public void displayContacts() {

		for (Contact contact : contactList) {
			System.out.println(contact);
		}
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void editContact(String firstName) {

		Scanner scanner = new Scanner(System.in);

		for (Contact contact : contactList) {

			if (contact.getFirstName().equalsIgnoreCase(firstName)) {

				System.out.println("Enter new Address:");
				contact.setAddress(scanner.nextLine());

				System.out.println("Enter new City:");
				contact.setCity(scanner.nextLine());

				System.out.println("Enter new State:");
				contact.setState(scanner.nextLine());

				System.out.println("Enter new Zip:");
				contact.setZip(scanner.nextLine());

				System.out.println("Enter new Phone:");
				contact.setPhoneNumber(scanner.nextLine());

				System.out.println("Enter new Email:");
				contact.setEmail(scanner.nextLine());

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