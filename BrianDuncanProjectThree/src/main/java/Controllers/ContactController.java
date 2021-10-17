package Controllers;
import Database.*;
import Models.ContactModel;
import java.sql.PreparedStatement;
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

 

    public ContactModel viewContact(int id) 
    {
        
        try 
        {
            PreparedStatement query = connCont.getConnection().prepareStatement("Select from Contacts where ID = ?;");
            query.setInt(1, id);
            return toModel(connCont.executeReadQuery(query));
        } 
        catch (Exception e) 
        {
         
            return null;
        }
    }

    /*Adds a contact to the list of Contacts 
     * also ensures that the contact id is unique. 
     */
    public boolean addContact (int ID, String firstName, String lastName, String address , String phoneNumber)
    {
            ContactModel newContact;
            try  
            {
                    newContact = new ContactModel(ID, firstName, lastName, address, phoneNumber);
                        connCont.executeQuery(createInsertString(newContact));
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
                    
                connCont.executeQuery(createDeleteString(newContact));
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
            PreparedStatement query = connCont.getConnection().prepareStatement("Update  Customers Set First_Name =  ? WHERE CustomerID = ? ;");
            query.setString(1, newFirstName);
            query.setString(2, ID);
            connCont.executeQuery(query);
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
            PreparedStatement query = connCont.getConnection().prepareStatement("Update  Customers Set First_Name = ? WHERE CustomerID = ? ; ");
            query.setString(1, newLastName);
            query.setString(2, ID);
            connCont.executeQuery(query);
            return true;
        } 
          catch (SQLException e) 
        {
            
            return false;
        }
    }
    public PreparedStatement createInsertString(ContactModel contact) 
    {
        try 
        {
            PreparedStatement query = connCont.getConnection().prepareStatement("Insert into Contacts ID, First_Name, Last_Name, Phone_Number, Address  Values (?, ?, ?, ?);");
            query.setString(1, contact.getFirstName());
            query.setString(2, contact.getLastName());
            query.setString(3, contact.getPhoneNum());
            query.setString(4, contact.getAddress());
            return query;
            
        } 
        catch (SQLException ex) 
        {
            return null;
        }
        
      
    }    

    public PreparedStatement createDeleteString(ContactModel contact) 
    {
        try 
        {
            PreparedStatement query = connCont.getConnection().prepareStatement("Delete from Contacts where  ID = ? ;");
            query.setInt(1, contact.getId());
            return query;
            
        } 
        catch (SQLException ex) 
        {
            return null;
        }
    }
}

    