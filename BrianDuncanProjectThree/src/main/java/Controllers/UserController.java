package Controllers;

import Database.*;
import Models.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import sun.jvm.hotspot.utilities.soql.SOQLException;



public class UserController 
 {
    
    private ConnectionController connCont;
    
    public UserController() throws SOQLException
    {

         try 
         {
            this.connCont = new ConnectionController() ;
        } 
         catch (SQLException e) 
         {
        }

    }

 

    public UserModel viewUser(int id) 
    {
        String query =  "Select from Users where ID = \"" + id+ "\"";
        try 
        {
            return toModel(connCont.executeReadQuery(query));
        } 
        catch (Exception e) 
        {
         
            return null;
        }
    }

    /*Adds an User to the databse in the users table 
     *  @return True if the user was added, else an erro was caught and false was returned. 
     */
    public boolean addUser (int ID, String userName, String password, int permLevel)
    {
            UserModel newUser;
            try  
            {
                    newUser = new UserModel(ID, userName, password, permLevel);
                    //if the User id is not unique an exception will be thown.
                        connCont.executeQuery(newUser.createInsertString());
                            return true;
             }
             catch(Exception e)
             {
                   return false;
             }
            
            

    }
    public boolean removeUser  (UserModel newUser)
    {
           
            try 
            {
                    
                connCont.executeQuery(newUser.createDeleteString());
                return true;

            } 
            catch (SQLException e) 
            {

                    return false;
            }
    }

   
    private UserModel toModel(ResultSet rawSQL) throws SQLException, Exception 
    {
        int ID = (int)rawSQL.getInt("ID");
        String name = rawSQL.getString("Name");
        String description = rawSQL.getString("Description");
        UserModel newUser = new UserModel(ID, name, description);
        return newUser;
    }

}
