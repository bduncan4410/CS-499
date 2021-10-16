layout: page
title: "Project 2"
permalink: /Project3

## Additions to the Project

In this part of the project, the application from the previous module was used as a template to demonstrate patching various security flaws. In doing such SQL injection attacks were prevented in this addition to the project.
This project entails a number of different controllers and models, so only one will be shown in depth in this page, more can be see in the main repository. 

### Project Three

The first addition/correction in this part of the project was the addition of Prepared Statements. These statements create a query with a sppecific type of syntax such as:

``` 
"Select from Contacts where ID = ?;");

```
 In this example, the ? can be replaced with anything whether it is a string or an int. By calling the setString on this stament the "?" can be changed to be
 a string or an int. The following code and parameters set the first "?" to the string for ID.
 
```
query.setInt(1, id);

```
 With that being said, some of the code had to be refactor into other classes to better suit this change. The following two methods were moved from
 the model to the controller since they had more use there:
 
```
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
```
