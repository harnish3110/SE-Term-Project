package com.se.termproject.utilities;

import java.sql.Connection;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DatabaseConnection {
	public Connection connection;

	public Connection createConnection() {
		try {
			MysqlDataSource db = new MysqlDataSource();
			
			db.setServerName(System.getenv("ICSI518_SERVER").toString());
			db.setPortNumber(Integer.parseInt(System.getenv("ICSI518_PORT")));
			db.setDatabaseName(System.getenv("ICSI518_DB"));
			db.setUser(System.getenv("ICSI518_USER"));
			db.setPassword(System.getenv("ICSI518_PASSWORD"));

			connection = db.getConnection();
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return connection;
	}

}
