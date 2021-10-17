package Controllers;

import Database.*;
import java.util.Date;
import Models.AppointmentModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import sun.jvm.hotspot.utilities.soql.SOQLException;


/** Appointment Controller that uses an appointment model to use CRUD operations for a SQL Server Database. 
 * 
 * @author Brian Duncan
 */
public class AppointmentController 
 {
    //Private attribute that controls the connection to the database and can execute sql
    private ConnectionController connCont;
    
    /** Constructor to build the controller and setup a connection via Connection Controller
     * 
     * @throws SOQLException This exception is thrown if the database cannot be reached.BFQW
     */
    public AppointmentController() throws SOQLException
    {

         try 
         {
            this.connCont = new ConnectionController() ;
        } 
         catch (SQLException e) 
         {
        }

    }

 

    public AppointmentModel viewAppointment(int id) 
    {
        String query =  "Select from Appointments where ID = \"" + id+ "\"";
        try 
        {
            return toModel(connCont.executeReadQuery(query));
        } 
        catch (Exception e) 
        {
         
            return null;
        }
    }

    /*Adds an appointment to the list of appointments 
     * also ensures that the appointment id is unique. 
     */
    public boolean addAppointment (long ID, Date date, String desc)
    {
            AppointmentModel newAppointment;
            try  
            {
                    newAppointment = new AppointmentModel(ID, date, desc);
                    //if the appointment id is not unique an exception will be thown.
                        connCont.executeQuery(newAppointment.createInsertString());
                            return true;
             }
             catch(Exception e)
             {
                   return false;
             }
            
            

    }
    public boolean removeAppointment (AppointmentModel newAppointment)
    {
           
            try 
            {
                    
                connCont.executeQuery(newAppointment.createDeleteString());
                return true;

            } 
            catch (SQLException e) 
            {

                    return false;
            }
    }
    public boolean updateAppointment (AppointmentModel newAppointment)
    {
           
            try 
            {
                    
                connCont.executeQuery(newAppointment.createDeleteString());
                return true;

            } 
            catch (SQLException e) 
            {

                    return false;
            }
    }

   
    private AppointmentModel toModel(ResultSet rawSQL) throws SQLException, Exception 
    {
        int ID = (int)rawSQL.getInt("ID");
        Date date = rawSQL.getDate("Date");
        String description = rawSQL.getString("Description");
        AppointmentModel newAppt = new Models.AppointmentModel(ID, date, description);
        return newAppt;
    }

}
