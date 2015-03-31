package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/";
	private String database = "mc5";
	private String username = "root";
	private String password = "p@ssword";

	Connection con;
	public Connection getConnection()
	{
		try
		{
			Class.forName(driverName);
			con = DriverManager.getConnection(url + database, username, password);
			System.out.println("DBConnection::Connection SUCCESS");
			return con;
		}
		catch (Exception ex)
		{
			System.out.println("Exception Caught::Unable to connect to " + getUrl() + getDatabase());
		}
		return null;
	}

	public String getDriverName()
	{
		return driverName;
	}

	public void setDriverName(String driverName)
	{
		this.driverName = driverName;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getDatabase() 
	{
		return database;
	}

	public void setDatabase(String database)
	{
		this.database = database;
	}
	
	public void close()
	{
		try
		{
			con.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}