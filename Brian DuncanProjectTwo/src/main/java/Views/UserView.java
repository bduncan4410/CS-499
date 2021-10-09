package Views;

import Models.TaskModel;
import Models.UserModel;

public class UserView 
{
	public void userView() 
	{
		
	}
	public void printView(UserModel taskModel)
	{
		System.out.println("ID: " + taskModel.getID());
		System.out.println("Name: " + taskModel.getName());
		System.out.println("Permision Level: " + taskModel.getPermisionLevel());
		
		
	}
}
