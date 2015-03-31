/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import model.User;
import model.Picture;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author User
 */
public class PicDBManager
{
    private DBConnection connect;
    private ResultSet rs;
    private PreparedStatement statement;
    private ArrayList<Picture> pictureList;

    private static PicDBManager pDB = null;

    public static synchronized PicDBManager getInstance() 
    {
        if (pDB == null)
        {
            pDB = new PicDBManager();
        }

        return pDB;
    }

    public PicDBManager()
    {
        connect = new DBConnection();
        connect.getConnection();
        pictureList = new ArrayList<Picture>();
    }

    public boolean upload(String username, String picture, String caption)
    {
        try 
        {
            PreparedStatement statement;
            String query = "INSERT INTO pictures(`username`, `picture`, `caption`) values(?, ?, ?)";
            statement = connect.getConnection().prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, picture);
            statement.setString(3, caption);
            statement.execute();
        }
        
        catch(SQLException e)
        {
            System.out.println("Upload FAIL");
            e.printStackTrace(); 
            return false;
        }
        return true;
    }
    
    public boolean edit(String picture, String caption, String username, int pic_id) 
    {
        String query = "UPDATE pictures SET picture = ?, caption = ? WHERE username = ? AND pic_id = ?";
        
        try
        {
            statement = connect.getConnection().prepareStatement(query);
            statement.setString(1, picture);
            statement.setString(2, caption);
            statement.setString(3, username);
            statement.setInt (4, pic_id);
            
            if(statement.execute())
            {
                connect.close();
                return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Edit FAIL");
            e.printStackTrace();
        }
        connect.close();
        return false;
    }
    
    public boolean delete(String username, String picture, String caption, int pic_id) 
    {
        String query = "DELETE from pictures WHERE username = ? and pic_id = ?";
        
        try
        {
            statement = connect.getConnection().prepareStatement(query);
            statement.setString(1, username);
            statement.setInt(2, pic_id);
            
            statement.execute();
            connect.close();
            return true;
        }
        
        catch (SQLException e)
        {
            System.out.println("Delete FAIL");
            e.printStackTrace();
        }
        connect.close();
        return false;
    }
    
    public ArrayList getPictures(String username)
    {
    	 String query = "SELECT * from pictures WHERE username = ?";
    	 ArrayList<Picture> pics = new ArrayList<Picture>();
    	 int x = 0;
         
         try
         {
             statement = connect.getConnection().prepareStatement(query);
             statement.setString(1, username);
             rs = statement.executeQuery();
             
             while(rs.next())
             {
                 pics.add(new Picture(rs.getInt("pic_id"), rs.getString("username"), rs.getString("picture"), rs.getString("caption")));
                 x++;
                 System.out.println(x);
             }
             connect.close();
             return pics;
         }
         
         catch (SQLException e)
         {
             System.out.println("Retrieving Pictures Fail");
             e.printStackTrace();
         }
         connect.close();
         return pics;
    }
}
