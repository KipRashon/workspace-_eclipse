package com.databaseAccess;

import java.sql.*;

public class ConnectionProvider {
	
	public static Connection getConnected() {
		String username="root";
		String password="kiptoo";
		String url="jdbc:mysql://localhost:3306/NjiiriSchool";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
