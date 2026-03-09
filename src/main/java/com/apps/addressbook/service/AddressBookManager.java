package com.apps.addressbook.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.apps.addressbook.model.AddressBook;
import com.apps.addressbook.model.Contact;

public class AddressBookManager {

	private Map<String, AddressBook> addressBookMap = new HashMap<>();

	public void createAddressBook(String name) {

		if (addressBookMap.containsKey(name)) {
			System.out.println("AddressBook already exists.");
			return;
		}

		addressBookMap.put(name, new AddressBook(name));
		System.out.println("AddressBook '" + name + "' created.");
	}

	public AddressBook getAddressBook(String name) {
		return addressBookMap.get(name);
	}

	public Map<String, AddressBook> getAddressBookMap() {
		return addressBookMap;
	}

	// UC8 - Search Person by City
	public List<Contact> searchPersonByCity(String city) {

		return addressBookMap.values().stream().flatMap(book -> book.getContactList().stream())
				.filter(contact -> contact.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
	}

	// UC8 - Search Person by State
	public List<Contact> searchPersonByState(String state) {

		return addressBookMap.values().stream().flatMap(book -> book.getContactList().stream())
				.filter(contact -> contact.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
	}

	// UC9 - View Persons grouped by City (Dictionary)
	public Map<String, List<Contact>> viewPersonsByCity() {

		return addressBookMap.values().stream().flatMap(book -> book.getContactList().stream())
				.collect(Collectors.groupingBy(Contact::getCity));
	}

	// UC9 - View Persons grouped by State (Dictionary)
	public Map<String, List<Contact>> viewPersonsByState() {

		return addressBookMap.values().stream().flatMap(book -> book.getContactList().stream())
				.collect(Collectors.groupingBy(Contact::getState));
	}
}