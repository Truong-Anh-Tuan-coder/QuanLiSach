package com.example.QuanLiSach.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl1";
	private String username = "System";
	private String password = "1";
	private Connection connection = null;

	public Connection openConnect()  throws SQLException {
		this.connection  = DriverManager.getConnection(this.url, this.username, this.password);
		return this.connection;
	}

	public void closeConnection() throws SQLException{
		if( this.connection != null) {
			this.connection.close();
		}
	}

	public Connection getConnection () { return this.connection;}

}
