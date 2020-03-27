package com.psl.busBooking.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.psl.busBooking.exception.BusBookingException;

public class DBUtil {

	static Connection con = null;
	static {	
		
		try{
			Properties properties = new Properties();
			properties.load(new FileInputStream("jdbc.properties"));
			final String URL = properties.getProperty("url");
			final String JDBC_DRIVER = properties.getProperty("driver");
			final String USER = properties.getProperty("username");
			final String PASS = properties.getProperty("password");
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(URL,USER,PASS);
			if(con==null)
			{
				throw new BusBookingException("Connection Not Established !!");
			}
		}catch(SQLException | ClassNotFoundException | IOException | BusBookingException e)
		{
			try {
				throw new BusBookingException(e.getMessage());
			} catch (BusBookingException e1) {
					System.out.println(e1.getMessage());
			}
		} 
	
	}
	public static Connection getConnection()
	{
		return con;
	}
	
}
