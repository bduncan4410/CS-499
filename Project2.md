## Additions to the Project

In this part of the project, the application from the previous module was used as a template to demonstrate the functionality of JDBC in connecting a database to the application.
This project entails a number of different controllers and models, so only one will be shown in depth in this page, more can be see in the main repository. 

### Project Two

The main addition to the application was the connection to the database which is a very simple task to complete. Below is the code that allows a user to connect to SQL Server DB:


```markdown
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
```

In this code snippit, the application is create a new connection to the database from the connectionManager object which will be discussed next. The connection has a large amount of
commands that can also be used to execute commands and get results from queries. The constructor here is just getting our connection and setting it to the private varable
called conn. In addition, a statement is created so that queries can be send to the database via the Connection object.  Bellow is the method for executing a given query
a generic query can be passed into here and can contain anything. With that being said. in Project Three, security will be enforced which means a filter will need to be 
used to prevent unwanted access to the database. 
```markdown
public boolean executeQuery(String query) throws SQLException
    {
       return this.statement.execute(query);
       
    }
```
This method returns a boolean of true if the queries executes and false otherwise. This is a good way to ensure the the query ran without issues and got data back from the database. 
To reiterate, this is a bad practice currently, but will be updated in the next project. This was done intentally to show an example of secure coding. 

The last method in the class is a simple read query which just returns  a result set which contains all of the information from the query:

```markdown
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
```

#Connection Manager

In this object, a connection to the database in established and stored into a varable. The connection information is stored as a private static string which allows for
its state to always remain the same. When working with jdbc the driver must always be the same as the database or it will not function properly. After settng up the variables
the application tests the connection with the username and password to ensure it is well met. If an exception is thrown, or the connection cannot be made this is printed to the console


```markdown

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
```

#The code was modified to clean it up and optimize some of the code to meet the MVC design pattern. The code was modified into three different branches, the model which controls the attributes of the object as well as the business logic of it. The Controller handles the view and the model, this started as a place to store models and had the ability to communicate them to the view. The view consisted of a vey basic console output which will be handled with more grace with future updates. 

#Below are the modifications of the application with the new MVC design pattern.


This controller handles the bulk of the application workload by storing the models in a list and using different methods to minipulate each one without ever having to know the business logic behind it. This design patten works best with teams because it has the ability to be independent of each part of the application. Meaning that one developer can work on the view and another can work on the controller at the same time. In the next module, a database is added into the mix which creates a better understanding of the true potential of the design pattern. 

//Note that the rest of the models, view and controllers for user, task, and contact are in the source code provided at [https://github.com/bduncan4410/CS-499]
