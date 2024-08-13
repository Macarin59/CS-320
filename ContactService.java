package contact;

import java.util.Map;
import java.util.HashMap;

public class ContactService {
	private Map<String, Contact> contactList;
	
	public ContactService() {
		contactList = new HashMap<>();
	}
	
	public void addContact(String firstName, String lastName, String id, String phoneNumber, String address) {
		if (contactList.get(id) == null) {
			Contact contact = new Contact(firstName, lastName, id, phoneNumber, address);
			contactList.put(id, contact);
		}
		else {
			throw new IllegalArgumentException("Contact ID is invalid");
		}
	}
	
	public void deleteContact(String id) {
		if (contactList.get(id) != null) {
			contactList.remove(id);
		}
		else {
			throw new IllegalArgumentException("Contact with given ID does not exist");
		}
	}
	
	public void updateContact(String firstName, String lastName, String id, String phoneNumber, String address) {
		if (id == null || contactList.get(id) == null) {
			throw new IllegalArgumentException("Invalid contact id");
		}
		if (firstName == null && lastName == null && phoneNumber == null && address == null) {
			throw new IllegalArgumentException("No value was given to update");
		}
		
		Contact contact = contactList.get(id);
		if (firstName != null) {
			contact.setFirstName(firstName);
		}
		if (lastName != null) {
			contact.setLastName(lastName);
		}
		if (phoneNumber != null) {
			contact.setPhoneNumber(phoneNumber);
		}
		if (address != null) {
			contact.setAddress(address);
		}
	}
	
	public Contact getContact(String id) {
		return contactList.get(id);
	}
}
