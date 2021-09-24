package ContactModule;

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
	
}
