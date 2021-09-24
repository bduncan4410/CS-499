package Task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskTest {

	

	@Test
	void testConstructorGoodValues() 
	{
		try 
		{
		
			Task task1 = new Task(1, "Task1", "description");
			assertTrue(true);
		} 
		catch (Exception e) 
		{
			fail("Exception thrown for valid date");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testConstructorBadValues() 
	{
		try 
		{
			
			Task task2 = new Task(2, "abcdefghijklmnopqrstuvwxyz", "description");
			fail("Invalid name length has been set and no exception has been thrown.");
		} 
		catch (Exception e) 
		{
			assertTrue(true);
		}
	}

}
