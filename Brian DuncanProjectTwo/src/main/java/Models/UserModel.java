package Models;

import java.util.ArrayList;
import java.util.LinkedList;

import Controllers.AppointmentController;
import Controllers.TaskController;
import Models.TaskModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.jvm.hotspot.utilities.soql.SOQLException;
public class UserModel 
{
	private int ID;
	private String name;
	private int permisionLevel;
	private AppointmentController apts;
	private TaskController task;
                   private ArrayList<TaskModel> tasks = new ArrayList<TaskModel>();
	
	public UserModel(String name, int permLevel)
	{
                            try 
                            {
                                AppointmentController apts = new AppointmentController();
                                TaskController tasks = new TaskController();
                              
                            } 
                            catch (SOQLException ex) 
                            {
                                Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public ArrayList<TaskModel> gettasks()
	{
		return this.tasks;
	}
	
	
}
