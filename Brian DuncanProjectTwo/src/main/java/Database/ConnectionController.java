/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Models.AppointmentModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Brian
 */
public class ConnectionController 
{
    private Connection conn;
    private Statement statement = conn.createStatement(); 

    public ConnectionController() throws SQLException 
    {
        this.conn = ConnectionManager.getConnection();
        this.statement = conn.createStatement(); 
    }
    
    public boolean executeQuery(String query) throws SQLException
    {
       return this.statement.execute(query);
       
    }

    public ResultSet executeReadQuery(String query)
    {
        try 
        {
            this.statement.execute(query);
            return this.statement.getResultSet();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
        
    }
}
   