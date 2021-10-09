package Controllers;
import java.util.ArrayList;


import Models.UserModel;

public class UserController 
{
	
	private ArrayList<UserModel> userList = new ArrayList<UserModel>();

	public UserController() 
	{
		
		
	}
	//#TODO Refactor to Binary Search 
	private UserModel search(int id)
	{
		for (int i = 0; i < userList.size(); i++) 
		{
			if (id == userList.get(i).getID()) 
			{
				return userList.get(i);
			}
		}
		//Return 1 not null
		return null;
	}
	
	public void addUser(UserModel userModel) throws Exception 
	{
		if (userList.isEmpty()) 
		{
			userList.add(userModel);
		}
		else if (search(userModel.getID()) == null)
		{
			userList.add(userModel);
		}
		else 
		{
			throw new Exception("ID is not unique to the contact");
		}
		
	}
	public void deleteContact(int ID) throws Exception 
	{
		if (search(ID) != null) 
		{
			userList.remove(search(ID));
		}
		else
		{
			throw new Exception("No Id matches searched ID");
		}
		
	}
	public void updateName(int ID, String newFirstName) throws Exception 
	{
		
		search(ID).setName(newFirstName);
		
	}
	
	public void updatePermission(int ID, int newPermLevel) throws Exception 
	{
		
		search(ID).setPermisionLevel(newPermLevel);
		
		
	}
	
	
}
