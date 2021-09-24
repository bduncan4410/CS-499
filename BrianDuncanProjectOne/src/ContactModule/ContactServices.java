package ContactModule;
import java.util.ArrayList;

public class ContactServices 
{
	private ArrayList<Contact> contacts = new ArrayList<Contact>();

	public ContactServices() 
	{
		
		
	}
	private Contact search(String id)
	{
		for (int i = 0; i < contacts.size(); i++) 
		{
			if (id == contacts.get(i).getId()) 
			{
				return contacts.get(i);
			}
		}
	
		return null;
	}
	
	public void addContact(Contact contact) throws Exception 
	{
		if (contacts.isEmpty()) 
		{
			contacts.add(contact);
		}
		else if (search(contact.getId()) == null)
		{
			contacts.add(contact);
		}
		else 
		{
			throw new Exception("ID is not unique to the contact");
		}
		
	}
	public void deleteContact(String ID) throws Exception 
	{
		if (search(ID) != null) 
		{
			contacts.remove(search(ID));
		}
		else
		{
			throw new Exception("No Id matches searched ID");
		}
		
	}
	public void updateFirstName(String ID, String newFirstName) throws Exception 
	{
		
		search(ID).setFirstName(newFirstName);
		
	}
	public void updateLastName(String ID, String newLastName) throws Exception 
	{
		
		search(ID).setFirstName(newLastName);
	}
	public void updateAddress(String ID, String newAddress) throws Exception 
	{
		
		search(ID).setFirstName(newAddress);
		
		
	}
	public void updatePhoneNum(String ID, String newPhoneNum) throws Exception 
	{
		
		search(ID).setPhoneNum(newPhoneNum);
		
		
	}
	
	
}
