package Controllers;

import Database.*;
import Models.TaskModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import sun.jvm.hotspot.utilities.soql.SOQLException;



public class TaskController 
 {
    
    private ConnectionController connCont;
    
    public TaskController() throws SOQLException
    {

         try 
         {
            this.connCont = new ConnectionController() ;
        } 
         catch (SQLException e) 
         {
        }

    }

 

    public TaskModel viewTask(int id) 
    {
        String query =  "Select from Tasks where ID = \"" + id+ "\"";
        try 
        {
            return toModel(connCont.executeReadQuery(query));
        } 
        catch (Exception e) 
        {
         
            return null;
        }
    }

    /*Adds an Task to the list of Tasks 
     * also ensures that the Task id is unique. 
     */
    public boolean addTask (int ID, String name, String desc)
    {
            TaskModel newTask;
            try  
            {
                    newTask = new TaskModel(ID, name, desc);
                    //if the Task id is not unique an exception will be thown.
                        connCont.executeQuery(newTask.createInsertString());
                            return true;
             }
             catch(Exception e)
             {
                   return false;
             }
            
            

    }
    public boolean removeTask  (TaskModel newTask)
    {
           
            try 
            {
                    
                connCont.executeQuery(newTask.createDeleteString());
                return true;

            } 
            catch (SQLException e) 
            {

                    return false;
            }
    }

   
    private TaskModel toModel(ResultSet rawSQL) throws SQLException, Exception 
    {
        int ID = (int)rawSQL.getInt("ID");
        String name = rawSQL.getString("Name");
        String description = rawSQL.getString("Description");
        TaskModel newTask = new TaskModel(ID, name, description);
        return newTask;
    }

}
