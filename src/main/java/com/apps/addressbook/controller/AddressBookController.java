package com.apps.addressbook.controller;

import java.util.Scanner;
import com.apps.addressbook.model.AddressBook;
import com.apps.addressbook.model.Contact;
import com.apps.addressbook.service.AddressBookManager;

public class AddressBookController {

	private AddressBookManager manager = new AddressBookManager();
	private Scanner sc = new Scanner(System.in);

	public void start() {

		System.out.println("Enter AddressBook Name:");
		String bookName = sc.nextLine();

		manager.createAddressBook(bookName);
		AddressBook addressBook = manager.getAddressBook(bookName);

		int choice;

		do {

			System.out.println("\n1.Add Contact");
			System.out.println("2.Edit Contact");
			System.out.println("3.Delete Contact");
			System.out.println("4.Display Contacts");
			System.out.println("0.Exit");

			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				addContact(addressBook);
				break;

			case 2:
				System.out.println("Enter First Name to Edit:");
				addressBook.editContact(sc.nextLine());
				break;

			case 3:
				System.out.println("Enter First Name to Delete:");
				addressBook.deleteContact(sc.nextLine());
				break;

			case 4:
				addressBook.displayContacts();
				break;
			}

		} while (choice != 0);
	}

	private void addContact(AddressBook addressBook) {

		System.out.println("First Name:");
		String firstName = sc.nextLine();

		System.out.println("Last Name:");
		String lastName = sc.nextLine();

		System.out.println("Address:");
		String address = sc.nextLine();

		System.out.println("City:");
		String city = sc.nextLine();

		System.out.println("State:");
		String state = sc.nextLine();

		System.out.println("Zip:");
		String zip = sc.nextLine();

		System.out.println("Phone:");
		String phone = sc.nextLine();

		System.out.println("Email:");
		String email = sc.nextLine();

		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);

		addressBook.addContact(contact);
	}
}