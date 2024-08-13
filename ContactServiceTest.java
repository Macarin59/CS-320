package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	private ContactService contactService;
	private String firstName;
	private String lastName;
	private String id;
	private String phoneNumber;
	private String address;
	
	@BeforeEach
	public void init() {
		contactService = new ContactService();
		firstName = "John";
		lastName = "Doe";
		id = "12345";
		phoneNumber = "1234567890";
		address = "Avenue Street";
	}
	
	@Test
	void testContactService() {
		assertDoesNotThrow(() -> {
			new Contact(firstName, lastName, id, phoneNumber, address);
		});
		Contact contact = new Contact(firstName, lastName, id, phoneNumber, address);
		
		assertDoesNotThrow(() -> {
			contactService.addContact(firstName, lastName, id, phoneNumber, address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(firstName, lastName, id, phoneNumber, address);
		});
		
		contactService.addContact("Chris", "Avery", "1", "0987654321", "Boulevard Ave");
		assertTrue(contact.equals(contactService.getContact(id)));
		assertFalse(contact.equals(contactService.getContact("1")));
		assertFalse(contactService.getContact(id).equals(contactService.getContact("1")));
		
		assertDoesNotThrow(() -> {
			contactService.updateContact("Chris", lastName, id, phoneNumber, address);
		});
		assertEquals("Chris", contactService.getContact(id).getFirstName());
		
		assertNotNull(contactService.getContact("1"));
		assertDoesNotThrow(() -> {
			contactService.deleteContact("1");
		});
		assertNull(contactService.getContact("1"));
	}
	
	@Test
	void testAddContact() {
		contactService.addContact(firstName, lastName, id, phoneNumber, address);
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(firstName, lastName, id, phoneNumber, address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact("Chris", "Avery", id, "0987654321", "Boulevard Ave");
		});
		
		assertDoesNotThrow(() -> {
			contactService.addContact(firstName, lastName, id+"1", phoneNumber, address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact("Chris", "Avery", id+"1", "0987654321", "Boulevard Ave");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(firstName, lastName, null, phoneNumber, address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(null, null, null, null, null);
		});
	}
	
	@Test
	void testDeleteContact() {
		contactService.addContact(firstName, lastName, id, phoneNumber, address);
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact(null);
		});
		assertDoesNotThrow(() -> {
			contactService.deleteContact(id);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact(id);
		});
		
		contactService.addContact(firstName, lastName, id, phoneNumber, address);
		assertDoesNotThrow(() -> {
			contactService.deleteContact(id);
		});
	}
	
	@Test
	void testUpdateContact() {
		contactService.addContact(firstName, lastName, id, phoneNumber, address);
		assertTrue(contactService.getContact(id).equals(new Contact(firstName, lastName, id, phoneNumber, address)));
		
		assertDoesNotThrow(() -> {
			contactService.updateContact("Chris", "Avery", id, "0987654321", "Boulevard Ave");
		});
		assertFalse(contactService.getContact(id).equals(new Contact(firstName, lastName, id, phoneNumber, address)));
		assertTrue(contactService.getContact(id).equals(new Contact("Chris", "Avery", id, "0987654321", "Boulevard Ave")));
		
		assertDoesNotThrow(() -> {
			contactService.updateContact(firstName, lastName, id, phoneNumber, address);
		});
		assertFalse(contactService.getContact(id).equals(new Contact("Chris", "Avery", id, "0987654321", "Boulevard Ave")));
		assertTrue(contactService.getContact(id).equals(new Contact(firstName, lastName, id, phoneNumber, address)));
		
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact(null, null, id, null, null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact(firstName, lastName, null, phoneNumber, address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact(null, null, null, null, null);
		});
	}
}
