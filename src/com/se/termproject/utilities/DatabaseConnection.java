package com.se.termproject.utilities;

import java.sql.Connection;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DatabaseConnection {
	public String ICSI518_SERVER = "localhost";
	public int ICSI518_PORT = 3306;
	public String ICSI518_DB = "SE_Project";
	public String ICSI518_USER = "root";
	public String ICSI518_PASSWORD = "Admin123";
	public Connection connection;

	public Connection createConnection() {
		try {
			MysqlDataSource db = new MysqlDataSource();
			db.setServerName(ICSI518_SERVER);
			db.setPortNumber(ICSI518_PORT);
			db.setDatabaseName(ICSI518_DB);
			db.setUser(ICSI518_USER);
			db.setPassword(ICSI518_PASSWORD);

			connection = db.getConnection();
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return connection;
	}

}
