package AppointmentModule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class AppointmentService 
{
	private ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	
	
	public Appointment viewAppointment(int index) 
	{
		return appointmentList.get(index);
	}
	
	/*Adds an appointment to the list of appointments 
	 * also ensures that the appointment id is unique. 
	 */
	public void addAppointment (long ID, Date date, String desc)
	{
		Appointment newAppointment;
		try  
		{
			newAppointment = new Appointment(ID, date, desc);
			//if the appointment id is not already in the list then add to list
			if(Collections.binarySearch(appointmentList, newAppointment, new AppointmentComparator()) < 0)
			{
				appointmentList.add(newAppointment);
			}
			else
			{
				throw new Exception("Appointment ID already in list");
			}
		} 
		catch (Exception e) 
		{
		
			e.printStackTrace();
		}
		
	}
	public boolean removeAppointment (long ID)
	{
		Appointment newAppointment;
		try 
		{
			newAppointment = new Appointment(ID, new Date(), "desc");
			//finds the index of the appointment if it exists in the list.
			int deletedIndex = Collections.binarySearch(appointmentList, newAppointment, new AppointmentComparator());
			
			if(deletedIndex >= 0)
			{
				
				return appointmentList.remove(this.appointmentList.get(deletedIndex));
			}
			
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
	
}
