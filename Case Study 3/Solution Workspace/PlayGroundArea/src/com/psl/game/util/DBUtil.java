package com.psl.game.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.psl.game.exception.GameException;

public class DBUtil {
	
	static Connection con;
	
	static
	{
		try{
			Properties prop = new Properties();
			prop.load(new FileInputStream("jdbc.properties"));
			
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			String url = prop.getProperty("url");
			String driver = prop.getProperty("driver");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			
		}catch(SQLException | ClassNotFoundException | IOException e)
		{
			try{
				throw new GameException(e.getMessage());
			}catch(GameException el)
			{
				System.out.println(el.getMessage());
			}
		}
	}
	public static Connection getConnection()
	{
		if(con==null)
		{
			try {
			throw new GameException("Connection Not Established");}catch(GameException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return con;
	}
	

}
