/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

   
    private Statement statement;

    public ConnectionController() throws SQLException 
    {
        this.conn = ConnectionManager.getConnection();
        this.statement = conn.createStatement(); 
    }
    
     public Connection getConnection() 
     {
        return conn;
    }
    public boolean executeQuery(PreparedStatement query) throws SQLException
    {
       return query.execute();
       
    }

    public ResultSet executeReadQuery(PreparedStatement query)
    {
        try 
        {
            query.execute();
            return query.getResultSet();
        } 
        catch (SQLException e) 
        {
            return null;
        }
        
    }
}
   