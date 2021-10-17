package Models;

import java.util.ArrayList;

import Controllers.AppointmentController;
import Controllers.TaskController;
import sun.jvm.hotspot.utilities.soql.SOQLException;
public class UserModel 
{
        private int ID;
        private String username;
        private String password;
        private int permisionLevel;
                   
	
	public UserModel(int ID, String username, String password, int permLevel)
	{
                          this.ID = ID;
                          this.username = username;
                          this.password = password;
                          this.permisionLevel = permLevel;
                        
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String name) 
	{
		this.username = name;
	}

	public int getPermisionLevel() 
	{
		return permisionLevel;
	}

	public void setPermisionLevel(int permisionLevel) 
	{
		this.permisionLevel = permisionLevel;
	}

	public int getID() 
	{
		return ID;
	}

    public String createInsertString() 
    {
      return "Insert into User ID, Username, Password, Permission_Level Values (" + this.ID  +  " " + this.username +  " " + this.password +  " " + this.permisionLevel + ")";  
    }    

    public String createDeleteString() {
        return "Delete from Appointments where  ID = " + this.ID;  
    }
	
	
}
