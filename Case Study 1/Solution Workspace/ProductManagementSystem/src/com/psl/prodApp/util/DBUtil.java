package com.psl.prodApp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.psl.prodApp.exception.ProdAppException;

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
		}catch(SQLException | ClassNotFoundException e)
		{
			try {
				throw new ProdAppException(e.getMessage());
			} catch (ProdAppException e1) {
					System.out.println(e1.getMessage());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static Connection getConnection()
	{
		return con;
	}
	
}
