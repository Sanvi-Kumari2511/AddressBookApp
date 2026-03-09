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
	void givenContactExists_whenDeleted_shouldRemoveContact() {
		Contact contact = new Contact("Sanvi", "Kumari", "Rajiv Nagar", "Patna", "Bihar", "800024", "4567899134",
				"sanvi123@gmail.com");
		
		addressBook.addContact(contact);
		addressBook.deleteContact("Sanvi");
		Assertions.assertTrue(addressBook.getContactList().isEmpty());
	}

	@Test
	void givenContactNotExists_whenDeleteAttempted_shouldNotChangeList() {
		Contact contact = new Contact("Sanvi", "Kumari", "Rajiv Nagar", "Patna", "Bihar", "800024", "4567899134",
				"sanvi123@gmail.com");
		
		addressBook.addContact(contact);
		int sizeBefore = addressBook.getContactList().size();
		addressBook.deleteContact("Rishabh");
		Assertions.assertEquals(sizeBefore, addressBook.getContactList().size());
	}

	@Test
	void givenMultipleContacts_whenOneDeleted_shouldRemoveOnlyThatContact() {
		Contact contact1 = new Contact("Sanvi", "Kumari", "Rajiv Nagar", "Patna", "Bihar", "800024", "4567899134",
				"sanvi123@gmail.com");
		
		Contact contact2 = new Contact("Rishabh", "Anand", "Danapur", "Patna", "Bihar", "800024", "9999999999",
				"rishabh@gmail.com");
		
		addressBook.addContact(contact1);
		addressBook.addContact(contact2);
		addressBook.deleteContact("Sanvi");
		Assertions.assertEquals(1, addressBook.getContactList().size());
	}
}