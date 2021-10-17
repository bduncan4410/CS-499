package Views;

import Models.AppointmentModel;

public class AppointmentView 
{
	public void appointmentView() 
	{
		
	}
	public void printView(AppointmentModel aptModel)
	{
		System.out.println("Appointment Date: " + aptModel.getDate());
		System.out.println("Description: " + aptModel.getDescription());
		System.out.println("ID: " + aptModel.getID());
		
		
	}
}
