package contact;

public class Contact {
	private String firstName;
	private String lastName;
	private String id;
	private String phoneNumber;
	private String address;
	
	public Contact(String firstName, String lastName, String id, String phoneNumber, String address) {
		if (firstName == null) {
			throw new IllegalArgumentException("First name value is null");
		}
		if (lastName == null) {
			throw new IllegalArgumentException("Last name value is null");
		}
		if (id == null) {
			throw new IllegalArgumentException("ID value is null");
		}
		if (phoneNumber == null) {
			throw new IllegalArgumentException("Phone number value is null");
		}
		if (address == null) {
			throw new IllegalArgumentException("Address value is null");
		}
		if (firstName.length()>10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName.length()>10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (id.length()>10) {
			throw new IllegalArgumentException("Invalid id");	
		}
		if (phoneNumber.length()>10 || phoneNumber.length()<10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (address.length()>30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}
	
	public String getID() {
		return id;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length()>10 || phoneNumber.length()<10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof Contact)) {
			return false;
		}
		
		Contact c = (Contact) o;
		
		return firstName.equals(c.firstName) && lastName.equals(c.lastName)
				&& id.equals(c.id) && phoneNumber.equals(c.phoneNumber)
				&& address.equals(c.address);
	}
}
