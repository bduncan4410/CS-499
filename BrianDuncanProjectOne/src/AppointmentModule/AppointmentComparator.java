package AppointmentModule;

import java.util.Comparator;

public class AppointmentComparator implements Comparator<Appointment> 
{
	@Override
	public int compare(Appointment first, Appointment second) 
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
