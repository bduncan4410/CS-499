package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static String url = "jdbc:sqlserver://database-1.cx62jlbgmqkl.us-east-2.rds.amazonaws.com:1433";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "admin";   
    private static String password = "admin";
    private static Connection con;
    private static String urlstring;

    public static Connection getConnection() {
        try 
        {
            Class.forName(driverName);
            try 
            {
                con = DriverManager.getConnection(urlstring, username, password);
            } 
            catch (SQLException ex) 
            {
                
                System.out.println("Failed to create the database connection."); 
            }
        } 
        catch (ClassNotFoundException ex) 
        {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
    
}