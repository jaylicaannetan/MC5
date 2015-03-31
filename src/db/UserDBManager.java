/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import model.User;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
/**
 *
 * @author User
 */
public class UserDBManager
{
    private DBConnection connect;
    private ResultSet rs;
    private PreparedStatement statement;
    private ArrayList<User> userList;

    private static UserDBManager uDB = null;

    public static synchronized UserDBManager getInstance() 
    {
        if (uDB == null)
        {
            uDB = new UserDBManager();
        }

        return uDB;
    }

    public UserDBManager()
    {
        connect = new DBConnection();
        connect.getConnection();
        userList = new ArrayList<User>();
    }

    public User getUser(String username)
    {
        try
        {
        	User u;
            ResultSet rs;
            PreparedStatement statement;
            String query = "SELECT * " +
                           "FROM user WHERE username = ?";

            statement = connect.getConnection().prepareStatement(query);
            statement.setString(1, username);
            rs = statement.executeQuery();
            
            if (rs.next())
            {
                u = new User(rs.getString("username"), rs.getString("password"));
                return u;
            }

            else return null;
        }

        catch (SQLException e)
        {
            System.out.println("Unable to SELECT user");
            e.printStackTrace();
        }

        return null;
    }

    public Iterator getAllUsers()
    {
        try
        {
        	User u;
            String query = "SELECT username" +
                           "FROM user";

            statement = connect.getConnection().prepareStatement(query);
            rs = statement.executeQuery();
            userList.clear();
            
            while (rs.next())
            {
                u = new User(rs.getString("username"), rs.getString("password"));
                userList.add(u);
            }

            connect.close();
            return userList.iterator();
        }

        catch (SQLException e)
        {
            System.out.println("Unable to SELECT users");
            e.printStackTrace();
        }

        return null;
    }
    
    public int getNumOfUsers()
    {
        return userList.size();
    }
    
    public void createUser(User u)
    {
        try 
        {
            PreparedStatement statement;
            String query = "INSERT INTO user(`username`, `password`) values(?, ?)";
            
            statement = connect.getConnection().prepareStatement(query);
            statement.setString(1, u.getUsername());
            statement.setString(2, u.getPassword());
            
            statement.execute();
        }
        
        catch(SQLException e)
        {
            System.out.println("Unable to INSERT new user");
            e.printStackTrace();
        }
    }
    
    public boolean login(String username, String password)
    {
        try
        {
            String query = "SELECT password " +
                           "FROM user " +
                           "WHERE username = ?";
            
            statement = connect.getConnection().prepareStatement(query);
            statement.setString(1, username);
            
            rs = statement.executeQuery();
   
            if(rs.next())
            {
	            if (password.equals(rs.getString("password")))
	            {
	                return true;
	            }
            }
            return false;
        }

        catch (SQLException e)
        {
            System.out.println("Login FAIL");
            e.printStackTrace();
        }

        return false;
    }

    public boolean validateUser(String username, String password)
    {
        getAllUsers();
        for(User u: userList)
        {
            if(u.getUsername().equals(username))
            {
                if(u.getPassword().equals(password))
                {
                    return true;
                }
            }
        }

        return false;
    }
    
    public boolean checkUsername(String u)
    {
    	try
        {
            String query = "SELECT * " +
                           "FROM user " +
                           "WHERE username = ?";
            
            statement = connect.getConnection().prepareStatement(query);
            statement.setString(1, u);
            rs = statement.executeQuery();
   
            if(rs.next())
            {
	            return true;
            }
        }
    	
    	catch (SQLException e)
        {
            System.out.println("Check Username FAIL");
            e.printStackTrace();
        }
    	
    	return false;
    }
}
