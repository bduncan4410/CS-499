package Models;
 
import java.util.Date;

public class AppointmentModel
{
	private long ID;
	Date date;
	String description;
	//set to Private
	
	@SuppressWarnings("deprecation")
	public AppointmentModel(long id, Date date, String description) throws Exception 
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
		if(this.getID() == ((AppointmentModel) obj).getID())
		{
			if(this.getDate().equals(((AppointmentModel) obj).getDate()))
			{
				if(this.getDescription()== ((AppointmentModel) obj).getDescription())
				{
					return true;
				}
			}
		}
		
		return false;
		
	}	

    public String createInsertString() 
    {
      return "Insert into Appointments ID, Date, Description Values (" + this.ID  + this.date + this.description + ")";  
    }    

    public String createDeleteString() {
        return "Delete from Appointments where  ID = " + this.ID;  
    }
}
