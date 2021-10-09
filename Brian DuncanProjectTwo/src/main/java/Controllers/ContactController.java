package Controllers;
import Database.*;
import Models.ContactModel;
import Models.TaskModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import sun.jvm.hotspot.utilities.soql.SOQLException;

public class ContactController 
{
    
    private ConnectionController connCont;
    
    public ContactController() throws SOQLException
    {

         try 
         {
            this.connCont = new ConnectionController() ;
        } 
         catch (SQLException e) 
         {
        }

    }

 

    public ContactModel viewTask(int id) 
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
    public boolean addContact (int ID, String name, String desc)
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
    public boolean removeContact  (ContactModel newContact)
    {
           
            try 
            {
                    
                connCont.executeQuery(newContact.createDeleteString());
                return true;

            } 
            catch (SQLException e) 
            {

                    return false;
            }
    }

   
    private ContactModel toModel(ResultSet rawSQL) throws SQLException, Exception 
    {
        
        int ID = (int)rawSQL.getInt("ID");
        String firstName = rawSQL.getString("First Name");
        String lastName = rawSQL.getString("Last Name");
        String phoneNum= rawSQL.getString("Phone Number");
        String address = rawSQL.getString("Address");
        ContactModel newContact = new ContactModel(ID, firstName, lastName, phoneNum, address);
        return newContact;
    }



    public boolean updateFirstName(String ID, String newFirstName) throws Exception 
    {
          try 
        {
            connCont.executeQuery("Update  Customers Set First_Name = '" + newFirstName + "' WHERE CustomerID = " + ID +";" );
            return true;
        } 
          catch (SQLException e) 
        {
            
            return false;
        }
    }
    public boolean updateLastName(String ID, String newLastName) throws Exception 
    {
          try 
        {
            connCont.executeQuery("Update  Customers Set First_Name = '" + newLastName + "' WHERE CustomerID = " + ID +";" );
            return true;
        } 
          catch (SQLException e) 
        {
            
            return false;
        }
    }
}
    