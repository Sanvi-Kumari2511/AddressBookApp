package com.apps.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.apps.addressbook.model.Contact;

public class ContactTest {

	@Test
	void givenContactDetails_whenContactObjectCreated_shouldReturnCorrectValues() {

		Contact contact = new Contact("Sanvi", "Kumari", "Rajiv Nagar", "Patna", "Bihar", "800024", "4567899134",
				"sanvi123@gmail.com");

		Assertions.assertEquals("Sanvi", contact.getFirstName());
		Assertions.assertEquals("Kumari", contact.getLastName());
		Assertions.assertEquals("Patna", contact.getCity());
		Assertions.assertEquals("4567899134", contact.getPhoneNumber());
	}

	@Test
	void givenEmptyConstructor_whenValuesSetUsingSetters_shouldReturnCorrectValues() {

		Contact contact = new Contact();

		contact.setFirstName("Sanvi");
		contact.setLastName("Kumari");
		contact.setCity("Patna");

		Assertions.assertEquals("Sanvi", contact.getFirstName());
		Assertions.assertEquals("Kumari", contact.getLastName());
		Assertions.assertEquals("Patna", contact.getCity());
	}

	@Test
	void givenTwoContactsWithSameDetails_whenCompared_shouldBeEqual() {

		Contact contact1 = new Contact("Sanvi", "Kumari", "Rajiv Nagar", "Patna", "Bihar", "800024", "4567899134",
				"sanvi123@gmail.com");

		Contact contact2 = new Contact("Sanvi", "Kumari", "Rajiv Nagar", "Patna", "Bihar", "800024", "4567899134",
				"sanvi123@gmail.com");

		Assertions.assertEquals(contact1, contact2);
	}

	@Test
	void givenTwoContactsWithDifferentDetails_whenCompared_shouldNotBeEqual() {

		Contact contact1 = new Contact("Sanvi", "Kumari", "Rajiv Nagar", "Patna", "Bihar", "800024", "4567899134",
				"sanvi123@gmail.com");

		Contact contact2 = new Contact("Rishabh", "Anand", "Danapur", "Patna", "Bihar", "800024", "9999999999",
				"rishabh@gmail.com");

		Assertions.assertNotEquals(contact1, contact2);
	}

	@Test
	void givenContactObject_whenToStringCalled_shouldContainContactDetails() {

		Contact contact = new Contact("Sanvi", "Kumari", "Rajiv Nagar", "Patna", "Bihar", "800024", "4567899134",
				"sanvi123@gmail.com");

		String contactString = contact.toString();

		Assertions.assertTrue(contactString.contains("Sanvi"));
		Assertions.assertTrue(contactString.contains("Kumari"));
		Assertions.assertTrue(contactString.contains("Patna"));
	}

	@Test
	void givenContactWithNullValues_whenCreated_shouldHandleNullValues() {

		Contact contact = new Contact();

		Assertions.assertNull(contact.getFirstName());
		Assertions.assertNull(contact.getLastName());
	}

	@Test
	void givenContactObject_whenFieldsUpdated_shouldReflectUpdatedValues() {

		Contact contact = new Contact("Rishabh", "Anand", "Danapur", "Patna", "Bihar", "800024", "9999999999",
				"rahul@email.com");

		contact.setCity("Patna");

		Assertions.assertEquals("Patna", contact.getCity());
	}
}