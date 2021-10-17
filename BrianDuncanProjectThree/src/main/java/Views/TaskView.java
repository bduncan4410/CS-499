package Views;


import Models.TaskModel;

public class TaskView 
{
	public void taskView() 
	{
		
	}
	public void printView(TaskModel taskModel)
	{
		System.out.println("Name: " + taskModel.getName());
		System.out.println("Description: " + taskModel.getDescription());
		System.out.println("ID: " + taskModel.getID());
		
		
	}
}
