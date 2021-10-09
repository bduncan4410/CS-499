package Models;

public class TaskModel  
{
	private long ID;
	private String name;
	private String description;
	
	
	public TaskModel(int id, String name, String description) throws Exception 
	{
		if(name.length() < 21 && description.length() < 51 && name!= null &&  description != null)
		{
			ID = id;
			this.name = name;
			this.description = description;
		}
		else 
		{
			throw new Exception("");
		}
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
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
		if(this.getID() == ((TaskModel) obj).getID())
		{
			if(this.getName().equals(((TaskModel) obj).getName()))
			{
				if(this.getDescription()== ((TaskModel) obj).getDescription())
				{
					return true;
				}
			}
		}
		
		return false;
		
	}	

    public String createInsertString() 
    {
      return "Insert into Tasks ID, Name, Description Values (" + this.ID  + this.name + this.description + ")";  
    }    

    public String createDeleteString() {
        return "Delete from Appointments where  ID = " + this.ID;  
    }

    
	
	
}
