package Task;


import java.util.LinkedList;



public class TaskService 
{
	private LinkedList<Task> taskList = new LinkedList<Task>();
	
	
	public Task viewNextTask() 
	{
		return taskList.peek();
	}
	
	public Task viewTask(long index) 
	{
		return search(index);
	}
	
	/*Adds a task to the list of tasks 
	 * also ensures that the appointment id is unique. 
	 */
	public void addTask (Task task)
	{
		taskList.add(task);
	}
	
	public boolean removeTask (long ID)
	{
		Task searchedTask = search(ID);
		if(searchedTask != null)
			{
				return taskList.remove(searchedTask);
			}
		else
		{
			return false;
		}
	}
	private Task search(long ID)
	{
		
		for (int i = 0; i < taskList.size(); i++) 
		{
			if (taskList.get(i).getID() == ID)
			{
				Task task = taskList.get(i);
				return task;
				
			}
		}
		return null;
		
		
			
	}
	
}
