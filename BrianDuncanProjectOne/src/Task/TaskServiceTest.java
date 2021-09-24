package Task;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {


	@SuppressWarnings("deprecation")
	@Test
	void testAddAndViewTask() 
	{
		try 
		{
			//Create two new tasks to compare equals method
			Task task1 = new Task(1, "Task 1", "description");
			Task task2 = new Task(2, "Task 2", "description");
			
			TaskService taskServ =  new TaskService();
			taskServ.addTask(task1);
			taskServ.addTask(task2);
		}
		catch(Exception e)
		{
			fail("Exception Thrown");
		}
	

	}
	@Test
	void testDeleteTask() 
	{
		try 
		{
			//Create two new tasks to compare equals method
			Task task1 = new Task(1, "Task 1", "description");
			Task task2 = new Task(2, "Task 2", "description");
			
			TaskService taskServ =  new TaskService();
			taskServ.addTask(task1);
			taskServ.addTask(task2);

			//if the appointment at the 2nd index is equal to appointment 2 which holds the same value.
			if (taskServ.removeTask(1)) 
			{
				assertTrue(true);
			}
			else 
			{
				fail("Element not deleted");
			}
			
		} 
		catch (Exception e) 
		{
			fail("Exception thrown");
			e.printStackTrace();
		}
	}

}
