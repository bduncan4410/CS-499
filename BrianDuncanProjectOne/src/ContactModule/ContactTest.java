package ContactModule;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/*
                                 Contact Class Requirements
The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. 
The contact ID shall not be null and shall not be updatable.

The contact object shall have a required firstName String field that cannot be longer than 10 characters. 
The firstName field shall not be null.

The contact object shall have a required lastName String field that cannot be longer than 10 characters. 
The lastName field shall not be null.

The contact object shall have a required phone String field that must be exactly 10 digits. 
The phone field shall not be null.

The contact object shall have a required address field that must be no longer than 30 characters. 
The address field shall not be null.
 */
class ContactTest {

	@Test
	void testID() 
	{
		try {
			Contact contact1 = new Contact("Test", "John", "Doe", "1234567890","123 Pike Street");
			assertTrue(contact1.getId().length() < 11);
			assertNotNull(contact1);
		} catch (Exception e) {
			fail("Exception Thrown in FirstName");
		}
		
		
		try 
		{
			Contact contact2 = new Contact("TestTestTest", "John", "Doe", "1234567890","123 Pike Street");
			fail("No Exception Thrown in Contructor");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testFirstName() 
	{
		try 
		{
			Contact contact1 = new Contact("Test", "John", "Doe", "1234567890","123 Pike Street");
			assertTrue(contact1.getFirstName().length() < 11);
			assertNotNull(contact1);
		}
		catch (Exception e) {
			fail("Exception Thrown in FirstName");
		}
		
		try 
		{
			Contact contact2 = new Contact("Test", "JohnJohnJohn", "Doe", "1234567890","123 Pike Street");			
			fail("No Exception Thrown in Contructor");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testLastName() 
	{
		try {
			Contact contact1 = new Contact("Test", "John", "Doe", "1234567890","123 Pike Street");
			assertTrue(contact1.getLastName().length() < 11);
			assertNotNull(contact1);
		} catch (Exception e) {
			fail("Exception Thrown in LastName");
		}
		
		try 
		{
			Contact contact2 = new Contact("Test", "John", "DoeDoeDoeDoe", "1234567890","123 Pike Street");			
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testPhoneNum() 
	{
		try 
		{
			Contact contact1 = new Contact("Test", "John", "Doe", "1234567890","123 Pike Street");
			assertEquals(contact1.getPhoneNum().length(), 10);
			assertNotNull(contact1);
		} 
		catch (Exception e) {
			fail("Exception Thrown in Address");
		} 
		
		try 
		{
			Contact contact2 = new Contact("Test", "JohnJohnJohn", "Doe", "12345678910","123 Pike Street");			
			fail("No Exception Thrown in Contructor");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	@Test
	void testAddress() 
	{
		
		try {
			Contact contact1 = new Contact("Test", "John", "Doe", "1234567890","123 Pike Street");
			assertTrue(contact1.getAddress().length() < 31);
			assertNotNull(contact1);
		} catch (Exception e1) {
			fail("Exception Thrown in Address");
		}
		
		try 
		{
			Contact contact2 = new Contact("Test", "JohnJohnJohn", "Doe", "1234567890","123456789012345678901234567890");			
			fail("No Exception Thrown in Contructor");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

}
