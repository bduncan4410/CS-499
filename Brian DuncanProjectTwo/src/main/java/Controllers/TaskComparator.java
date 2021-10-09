package Controllers;

import java.util.Comparator;

import Models.TaskModel;

public class TaskComparator implements Comparator<TaskModel> 
{
	@Override
	public int compare(TaskModel first, TaskModel second) 
	{
		long one = first.getID();
		long two = second.getID();
		
		if (one == two)
		{
			return 0;
		}
		else if  (one < two)
		{
			return -1;
		}
		else {
			return 1;
		}
	}
}
