package com.login.dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import com.login.bean.LoginBean;
import com.login.util.Dbconnection;
 
public class LoginDao {
 
public String authenticateUser(LoginBean loginBean)
{
    String userName = loginBean.getUserName();
    String password = loginBean.getPassword();
 
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;
 
    String userNameDB = "";
    String passwordDB = "";
    String roleDB = "";
 
    try
    {
        con = Dbconnection.openConnection();
        statement = con.createStatement();
        
        resultSet = statement.executeQuery("select username,password,role from users");
 
        while(resultSet.next())
        {
            userNameDB = resultSet.getString("username");
            passwordDB = resultSet.getString("password");
            roleDB = resultSet.getString("role");
 
            if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
            return "Admin_Role";

            else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
            return "User_Role";
            
            else {
            	System.out.println("hi");
            }
        }
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }
    return "Invalid user credentials";
}
}