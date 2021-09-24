package AppointmentModule;
 
import java.util.Date;

public class Appointment  
{
	private long ID;
	Date date;
	String description;
	
	
	public Appointment(long id, Date date, String description) throws Exception 
	{
		if(date.after( new Date(120,1,1)))
		{
			ID = id;
			this.date = date;
			this.description = description;
	
		}
		else
		{
			throw new Exception("Invalid Input for Appointment");
		}
	}


	public Date getDate() 
	{
		return date;
	}


	public void setDate(Date date) 
	{
		if(date.after(new Date()))
		{
			this.date = date;
		}
	}


	public String getDescription() 
	{
		return description;
	}


	public void setDescription(String description) 
	{
		this.description = description;
	}


	public long getID() 
	{
		return ID;
	}


	@Override
	public boolean equals(Object obj) {
		if(this.getID() == ((Appointment) obj).getID())
		{
			if(this.getDate().equals(((Appointment) obj).getDate()))
			{
				if(this.getDescription()== ((Appointment) obj).getDescription())
				{
					return true;
				}
			}
		}
		
		return false;
		
	}	
	
	
}
