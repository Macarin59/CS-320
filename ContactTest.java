package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
	private String firstName;
	private String lastName;
	private String id;
	private String phoneNumber;
	private String address;
	
	@BeforeEach
	public void init() {
		firstName = "John";
		lastName = "Doe";
		id = "12345";
		phoneNumber = "1234567890";
		address = "Avenue Street";
	}
	
	
	@Test
	void testContact() {
		assertDoesNotThrow(() -> {
			new Contact(firstName, lastName, id, phoneNumber, address);
		});
		Contact contact = new Contact(firstName, lastName, id, phoneNumber, address);
		assertTrue(contact.getFirstName().equals(firstName));
		assertTrue(contact.getLastName().equals(lastName));
		assertTrue(contact.getID().equals(id));
		assertTrue(contact.getPhoneNumber().equals(phoneNumber));
		assertTrue(contact.getAddress().equals(address));
		assertTrue(contact.equals(new Contact(firstName, lastName, id, phoneNumber, address)));
	}
	
	@Test
	void testContactFirstName() {
		assertDoesNotThrow(() -> {
			new Contact(firstName, lastName, id, phoneNumber, address);
		});
		assertDoesNotThrow(() -> {
			new Contact("", lastName, id, phoneNumber, address);
		});
		assertDoesNotThrow(() -> {
			new Contact("Cristopher", lastName, id, phoneNumber, address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John12345678", lastName, id, phoneNumber, address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, lastName, id, phoneNumber, address);
		});
		
		Contact contact = new Contact(firstName, lastName, id, phoneNumber, address);
		assertDoesNotThrow(() -> {
			contact.setFirstName("Chris");
		});
		assertDoesNotThrow(() -> {
			contact.setFirstName("");
		});
		assertDoesNotThrow(() -> {
			contact.setFirstName("Cristopher");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("John12345678");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
	}
	
	@Test
	void testContactLastName() {
		assertDoesNotThrow(() -> {
			new Contact(firstName, lastName, id, phoneNumber, address);
		});
		assertDoesNotThrow(() -> {
			new Contact(firstName, "", id, phoneNumber, address);
		});
		assertDoesNotThrow(() -> {
			new Contact(firstName, "Cristopher", id, phoneNumber, address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(firstName, "John12345678", id, phoneNumber, address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(firstName, null, id, phoneNumber, address);
		});
		
		Contact contact = new Contact(firstName, lastName, id, phoneNumber, address);
		assertDoesNotThrow(() -> {
			contact.setLastName("Chris");
		});
		assertDoesNotThrow(() -> {
			contact.setLastName("");
		});
		assertDoesNotThrow(() -> {
			contact.setLastName("Cristopher");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("John12345678");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
	}
	
	@Test
	void testContactID() {
		assertDoesNotThrow(() -> {
			new Contact(firstName, lastName, id, phoneNumber, address);
		});
		assertDoesNotThrow(() -> {
			new Contact(firstName, lastName, "", phoneNumber, address);
		});
		assertDoesNotThrow(() -> {
			new Contact(firstName, lastName, "1234567890", phoneNumber, address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(firstName, lastName, "12345678901", phoneNumber, address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(firstName, lastName, null, phoneNumber, address);
		});
	}
	
	@Test
	void testContactPhoneNumber() {
		assertDoesNotThrow(() -> {
			new Contact(firstName, lastName, id, phoneNumber, address);
		});
		assertDoesNotThrow(() -> {
			new Contact(firstName, lastName, id, "0987654321", address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(firstName, lastName, id, "123456789", address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(firstName, lastName, id, "12345678901", address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(firstName, lastName, id, "", address);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(firstName, lastName, id, null, address);
		});
		
		Contact contact = new Contact(firstName, lastName, id, phoneNumber, address);
		assertDoesNotThrow(() -> {
			contact.setPhoneNumber("0987654321");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber("123456789");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber("12345678901");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber("");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNumber(null);
		});
	}
	
	@Test
	void testContactAddress() {
		assertDoesNotThrow(() -> {
			new Contact(firstName, lastName, id, phoneNumber, address);
		});
		assertDoesNotThrow(() -> {
			new Contact(firstName, lastName, id, phoneNumber, "");
		});
		assertDoesNotThrow(() -> {
			new Contact(firstName, lastName, id, phoneNumber, "Avenue Street Avenue Street Av");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(firstName, lastName, id, phoneNumber, "Avenue Street Avenue Street Avenue Street");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(firstName, lastName, id, phoneNumber, null);
		});
		
		Contact contact = new Contact(firstName, lastName, id, phoneNumber, address);
		assertDoesNotThrow(() -> {
			contact.setAddress("Boulevard Ave");
		});
		assertDoesNotThrow(() -> {
			contact.setAddress("");
		});
		assertDoesNotThrow(() -> {
			contact.setAddress("Avenue Street Avenue Street Av");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("Avenue Street Avenue Street Avenue Street");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
	}
}
