layout: page
title: "Project 1"
permalink: /Project1
## Welcome to CS 499 Capstone

My Name is Brian Duncan, and this is my capstone page that showcase a few of my projects.

### Project One

Below is the one of the original files that was modified to show

```markdown
public class Contact 
{
	private String id, firstName, lastName, phoneNum, address;

	

	public Contact(String id, String firstName, String lastName, String phoneNum, String address) throws Exception {
		if (id.length() < 11) 
		{
			if (firstName.length() < 11) 
			{
				if (lastName.length() < 11)
				{
					if (phoneNum.length() == 10) 
					{
						if (address.length() < 31) 
						{
							this.id = id;
							this.firstName = firstName;
							this.lastName = lastName;
							this.phoneNum = phoneNum;
							this.address = address;
						}
						else 
						{
							throw new Exception("Invalid Address Length");
						}
					}
					else 
					{
						throw new Exception("Invalid Phone Number Size");
					}
				}
				else 
				{
					throw new Exception("Invalid Last Name Length");
				}
			}
			else 
			{
				throw new Exception("FirstName Length");
			}
		}
		else 
		{
			throw new Exception("Invalid ID Length");
		}
		
		
	}
	
	public String getId() 
	{
		return id;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public String getPhoneNum() 
	{
		return phoneNum;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setId(String id) throws Exception 
	{
		if (id.length() < 11) 
		{
			this.id = id;
		}
		else
		{
			throw new Exception("ID Too long");
		}
	}

	public void setFirstName(String firstName) throws Exception 
	{
		if (firstName.length() < 11) 
		{
			this.firstName = firstName;
		}
		else
		{
			throw new Exception("First Name Too Long");
		}
	}

	public void setLastName(String lastName) throws Exception 
	{
		if (lastName.length() < 11)
		{
			this.lastName = lastName;
		}
		else
		{
			throw new Exception("Last Name Too Long");
		}
	}

	public void setPhoneNum(String phoneNum) throws Exception 
	{
		if (phoneNum.length() == 10) 
		{
			this.phoneNum = phoneNum;
		}
		else
		{
			throw new Exception("Phone Number Too Long");
		}
	}

	public void setAddress(String address) throws Exception 
	{
		if (address.length() < 31) 
		{
			this.address = address;
		}
		else
		{
			throw new Exception("Address Too Long");
		}
	}
	
}` 
```

#The code was modified to clean it up and optimize some of the code to meet the MVC design pattern. The code was modified into three different branches, the model which controls the attributes of the object as well as the business logic of it. The Controller handles the view and the model, this started as a place to store models and had the ability to communicate them to the view. The view consisted of a vey basic console output which will be handled with more grace with future updates. 

#Below are the modifications of the application with the new MVC design pattern.

```markdown

package Controller;
import java.util.ArrayList;

import Models.ContactModel;

public class ContactController 
{
	
	private ArrayList<ContactModel> ContactList = new ArrayList<ContactModel>();

	public ContactController() 
	{
		
		
	}
	
	private ContactModel search(String id)
	{
		for (int i = 0; i < ContactList.size(); i++) 
		{
			if (id == ContactList.get(i).getId()) 
			{
				return ContactList.get(i);
			}
		}
		
		return null;
	}
	
	public void addContact(ContactModel contactModel) throws Exception 
	{
		if (ContactList.isEmpty()) 
		{
			ContactList.add(contactModel);
		}
		else if (search(contactModel.getId()) == null)
		{
			ContactList.add(contactModel);
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
			ContactList.remove(search(ID));
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


```
This controller handles the bulk of the application workload by storing the models in a list and using different methods to minipulate each one without ever having to know the business logic behind it. This design patten works best with teams because it has the ability to be independent of each part of the application. Meaning that one developer can work on the view and another can work on the controller at the same time. In the next module, a database is added into the mix which creates a better understanding of the true potential of the design pattern. 

//Note that the rest of the models, view and controllers for user, task, and contact are in the source code provided at [https://github.com/bduncan4410/CS-499]
