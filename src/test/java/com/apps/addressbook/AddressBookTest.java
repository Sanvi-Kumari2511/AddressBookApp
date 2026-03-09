package com.apps.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.apps.addressbook.model.AddressBook;
import com.apps.addressbook.model.Contact;

public class AddressBookTest {

	AddressBook addressBook;

	@BeforeEach
	void setUp() {
		addressBook = new AddressBook();
	}

	@Test
	void givenMultipleContacts_whenAdded_shouldStoreAllContacts() {

		Contact contact1 = new Contact("Sanvi", "Kumari", "Rajiv Nagar", "Patna", "Bihar", "800024", "4567899134",
				"sanvi123@gmail.com");

		Contact contact2 = new Contact("Rishabh", "Anand", "Danapur", "Patna", "Bihar", "800024", "9999999999",
				"rishabh@gmail.com");
		
		addressBook.addContact(contact1);
		addressBook.addContact(contact2);
		Assertions.assertEquals(2, addressBook.getContactList().size());
	}

	@Test
	void givenMultipleContacts_whenStored_shouldMaintainCorrectOrder() {
		Contact contact1 = new Contact("Sanvi", "Kumari", "Rajiv Nagar", "Patna", "Bihar", "800024", "4567899134",
				"sanvi123@gmail.com");

		Contact contact2 = new Contact("Rishabh", "Anand", "Danapur", "Patna", "Bihar", "800024", "9999999999",
				"rishabh@gmail.com");
		
		addressBook.addContact(contact1);
		addressBook.addContact(contact2);
		Assertions.assertEquals("Sanvi", addressBook.getContactList().get(0).getFirstName());
		Assertions.assertEquals("Rishabh", addressBook.getContactList().get(1).getFirstName());
	}
}