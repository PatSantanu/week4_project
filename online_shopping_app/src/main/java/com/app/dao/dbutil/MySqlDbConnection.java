package com.app.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlDbConnection {
	private MySqlDbConnection() {
		
	}
	private static Connection connection;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/onlineshopping";
		String username="root";
		String password="Santanu@1997";
		connection=DriverManager.getConnection(url, username, password);
		return connection;
		
	}
    
}
