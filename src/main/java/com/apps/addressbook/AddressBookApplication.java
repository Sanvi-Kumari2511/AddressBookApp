package com.apps.addressbook;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apps.addressbook.model.AddressBook;
import com.apps.addressbook.model.Contact;

@SpringBootApplication
public class AddressBookApplication implements CommandLineRunner {

	private AddressBook addressBook = new AddressBook();

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
		System.out.println("Welcome to Address Book Application!!!");
	}

	@Override
	public void run(String... args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter First Name:");
		String firstName = sc.nextLine();

		System.out.println("Enter Last Name:");
		String lastName = sc.nextLine();

		System.out.println("Enter Address:");
		String address = sc.nextLine();

		System.out.println("Enter City:");
		String city = sc.nextLine();

		System.out.println("Enter State:");
		String state = sc.nextLine();

		System.out.println("Enter Zip:");
		String zip = sc.nextLine();

		System.out.println("Enter Phone:");
		String phone = sc.nextLine();

		System.out.println("Enter Email:");
		String email = sc.nextLine();

		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);

		addressBook.addContact(contact);

		addressBook.displayContacts();

		System.out.println("\nEnter First Name of contact to edit:");
		String editName = sc.nextLine();

		addressBook.editContact(editName);

		System.out.println("\nUpdated Contacts:");
		addressBook.displayContacts();
	}
}