package com.healthcare.utils;
import java.sql.*;

public class DBUtils {
	private static String dbURL="jdbc:mysql://localhost:3306/healthcare";
	private static String userName="root";
	private static String password="Shubham@1800";
	private static Connection connection;
	//open connection
	public static Connection getConnection() throws SQLException
	{
		connection=DriverManager.getConnection(dbURL, userName, password);
		return connection;
	}
	

}
