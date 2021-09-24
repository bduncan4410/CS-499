package ContactModule;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/*
Contact Service Requirements
The contact service shall be able to add contacts with a unique ID.
The contact service shall be able to delete contacts per contact ID.
The contact service shall be able to update contact fields per contact ID. 
The following fields are updatable:
firstName
lastName
Number
Address
 */
class ContactServicesTest {
	public ContactServices contactServices = new ContactServices();
	@Test
	void testAddContact() 
	{
		
		try 
		{
			contactServices.addContact(new Contact("1", "John", "Doe", "1234567890","123 Pike Street"));
			contactServices.addContact(new Contact("2", "John", "Doe", "1234567890","123 Pike Street"));
			assertTrue(true);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			fail("Exception Thrown");
		}
		
		try 
		{
			contactServices.addContact(new Contact("1", "John", "Doe", "1234567890","123 Pike Street"));
			contactServices.addContact(new Contact("1", "John", "Doe", "1234567890","123 Pike Street"));
			fail("Exception Not Thrown");
		} 
		catch (Exception e) {
			assertTrue(true);
		}
	}
	@Test
	void testDeleteContact() 
	{
		try 
		{
			contactServices.addContact(new Contact("1", "John", "Doe", "1234567890","123 Pike Street"));
			contactServices.deleteContact("1");
			assertTrue(true);
		} 
		catch (Exception e) {
			fail("Exception Thrown");
		}
		
		try 
		{
			
			contactServices.deleteContact("1");
			fail("Exception Not Thrown");
		} 
		catch (Exception e) {
			assertTrue(true);
		}
	}
	@Test
	void testUpdateContactFirstName() 
	{
		try 
		{
			contactServices.addContact(new Contact("1", "John", "Doe", "1234567890","123 Pike Street"));
			contactServices.updateFirstName("1", "Jane");
			assertTrue(true);
		} 
		catch (Exception e) {
			fail("Exception Thrown");
		}
		
		try 
		{
			
			contactServices.updateFirstName("1", "LongFirstName");
			fail("Exception Not Thrown");
		} 
		catch (Exception e) {
			assertTrue(true);
		}
	}
	@Test
	void testUpdateContactLastName() 
	{
		try 
		{
			contactServices.addContact(new Contact("1", "John", "Doe", "1234567890","123 Pike Street"));
			contactServices.updateLastName("1", "Smith");
			assertTrue(true);
		} 
		catch (Exception e) {
			fail("Exception Thrown");
		}
		
		try 
		{
			
			contactServices.updateLastName("1", "LongLastName");
			fail("Exception Not Thrown");
		} 
		catch (Exception e) {
			assertTrue(true);
		}
	}
	@Test
	void testUpdateContactAddress() 
	{
		try 
		{
			contactServices.addContact(new Contact("1", "John", "Doe", "1234567890","123 Pike Street"));
			contactServices.updateAddress("1", "123 RT 50");
			assertTrue(true);
		} 
		catch (Exception e) {
			fail("Exception Thrown");
		}
		
		try 
		{
			
			contactServices.updateAddress("1", "12345E Broadway Street, New York City NY");
			fail("Exception Not Thrown");
		} 
		catch (Exception e) {
			assertTrue(true);
		}
	}
	@Test
	void testUpdateContactPhoneNumber() 
	{
		try 
		{
			contactServices.addContact(new Contact("1", "John", "Doe", "1234567890","123 Pike Street"));
			contactServices.updatePhoneNum("1", "9876543210");
			assertTrue(true);
		} 
		catch (Exception e) {
			fail("Exception Thrown");
		}
		
		try 
		{
			
			contactServices.updatePhoneNum("1", "4561230");
			fail("Exception Not Thrown");
		} 
		catch (Exception e) {
			assertTrue(true);
		}
	}

}
