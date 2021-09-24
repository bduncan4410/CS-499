package AppointmentModule;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {


	@SuppressWarnings("deprecation")
	@Test
	void testAddAndViewAppointment() 
	{
		try 
		{
			//Create two new appointments to compare equals method
			Appointment appointment1 = new Appointment(1, new Date(120, 12, 22), "description");
			Appointment appointment2 = new Appointment(2, new Date(120, 12, 25), "description");
			
			AppointmentService apptServ =  new AppointmentService();
			apptServ.addAppointment(1, new Date(120, 12, 22), "description");
			apptServ.addAppointment(2, new Date(120, 12, 25), "description");
			
			
			
			//if the appointment at the 1st index is equal to appointment 1 which holds the same value.
			if (apptServ.viewAppointment(0).equals(appointment1)) 
			{
				//if the appointment at the 2nd index is equal to appointment 2 which holds the same value.
				if (apptServ.viewAppointment(1).equals(appointment2)) 
				{
					assertTrue(true);
				}
				else 
				{
					fail("Second appointment not equal to given appointment.");
				}
			}
			else 
			{
				fail("First appointment not equal to given appointment.");
			}
		} 
		catch (Exception e) 
		{
			fail("Exception thrown");
			e.printStackTrace();
		}
	}
	@Test
	void testDeleteAppointment() 
	{
		try 
		{
			//Create two new appointments to compare equals method
			Appointment appointment1 = new Appointment(1, new Date(120, 12, 22), "description");
			Appointment appointment2 = new Appointment(2, new Date(120, 12, 25), "description");
			
			AppointmentService apptServ =  new AppointmentService();
			apptServ.addAppointment(1, new Date(120, 12, 22), "description");
			apptServ.addAppointment(2, new Date(120, 12, 25), "description");

			//if the appointment at the 2nd index is equal to appointment 2 which holds the same value.
			if (apptServ.removeAppointment(1)) 
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
