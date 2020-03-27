package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Override and implement all the methods of DBConnectionUtil here to create and close db connection 
public class DatabaseConnectionManager implements DBConnectionUtil {

	final String URL = "com.mysql.jdbc.Driver";
    final String JDBC_DRIVER = "jdbc:mysql://localhost:3306/questiondb";
	final String USERNAME = "root";
	final String Password = "root";
	
	Connection con;
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName(JDBC_DRIVER);
		con = DriverManager.getConnection(URL);
		
		return con;
		
	}

	@Override
	public void closeConnection() throws SQLException {
		
		con.close();
		
	}


}
