package Controllers;

import java.util.Comparator;

import Models.AppointmentModel;

public class AppointmentComparator implements Comparator<AppointmentModel> 
{
	@Override
	public int compare(AppointmentModel first, AppointmentModel second) 
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
