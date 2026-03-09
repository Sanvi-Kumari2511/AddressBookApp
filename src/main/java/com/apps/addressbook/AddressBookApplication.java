package com.apps.addressbook;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apps.addressbook.model.AddressBook;
import com.apps.addressbook.model.Contact;

@SpringBootApplication
public class AddressBookApplication {
	public static void main(String[] args) {

		SpringApplication.run(AddressBookApplication.class, args);

		AddressBook addressBook = new AddressBook();
		Scanner sc = new Scanner(System.in);

		String choice;

		do {

			System.out.println("\nEnter Contact Details");

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
			System.out.println("\nDo you want to add another contact? (yes/no)");
			choice = sc.nextLine();

		} while (choice.equalsIgnoreCase("yes"));

		System.out.println("\nAll Contacts:");
		addressBook.displayContacts();

		sc.close();
	}
}