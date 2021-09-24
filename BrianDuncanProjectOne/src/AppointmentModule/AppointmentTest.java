package AppointmentModule;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentTest {

	

	@Test
	void testConstructorGoodValues() 
	{
		try 
		{
			Date date = new Date();
			date.setYear(120);
			Appointment appointment = new Appointment(1, date, "description");
			assertTrue(true);
		} 
		catch (Exception e) 
		{
			fail("Exception thrown for valid date.d");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testConstructorBadValues() 
	{
		try 
		{
			Date date = new Date(0,11,29);
			Appointment appointment = new Appointment(2, date, "description");
			fail("Invalid date has been set and no exception has been thrown.");
		} 
		catch (Exception e) 
		{
			assertTrue(true);
		}
	}

}
