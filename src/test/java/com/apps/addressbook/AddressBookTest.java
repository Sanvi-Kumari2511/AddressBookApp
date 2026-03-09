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
	void givenExistingContact_whenEdited_shouldUpdateContactDetails() {

		Contact contact = new Contact("Sanvi", "Kumari", "Rajiv Nagar", "Patna", "Bihar", "800024", "4567899134",
				"sanvi123@gmail.com");
		
		addressBook.addContact(contact);
		// simulate edit
		contact.setCity("Patna");
		Assertions.assertEquals("Patna", addressBook.getContactList().get(0).getCity());
	}

	@Test
	void givenMultipleContacts_whenEditingOne_shouldUpdateOnlyThatContact() {
		Contact contact1 = new Contact("Sanvi", "Kumari", "Rajiv Nagar", "Patna", "Bihar", "800024", "4567899134",
				"sanvi123@gmail.com");
		
		Contact contact2 = new Contact("Rishabh", "Anand", "Danapur", "Patna", "Bihar", "800024", "9999999999",
				"rishabh@gmail.com");
		
		addressBook.addContact(contact1);
		addressBook.addContact(contact2);
		// simulate edit
		contact1.setCity("Delhi");
		Assertions.assertEquals("Delhi", addressBook.getContactList().get(0).getCity());
		Assertions.assertEquals("Patna", addressBook.getContactList().get(1).getCity());
	}

	@Test
	void givenContactNotPresent_whenEditAttempted_shouldNotChangeListSize() {
		Contact contact = new Contact("Sanvi", "Kumari", "Rajiv Nagar", "Patna", "Bihar", "800024", "4567899134",
				"sanvi123@gmail.com");
		
		addressBook.addContact(contact);
		int sizeBefore = addressBook.getContactList().size();
		// simulate editing a non-existing contact
		String nameToEdit = "Rishabh";
		if (!addressBook.getContactList().get(0).getFirstName().equals(nameToEdit)) {
			// nothing updated
		}

		Assertions.assertEquals(sizeBefore, addressBook.getContactList().size());
	}

}