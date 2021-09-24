package Task;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> 
{
	@Override
	public int compare(Task first, Task second) 
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
