package com.se.termproject.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.mysql.jdbc.ResultSet;
import com.se.termproject.beans.User;
import com.se.termproject.utilities.DatabaseConnection;

public class RegistrationDAO {
	DatabaseConnection db = null;
	Connection connection = null;
	Statement statement = null;
	ResultSet result = null;

	public RegistrationDAO() {
		// TODO Auto-generated constructor stub
		try {
			db = new DatabaseConnection();
			connection = db.createConnection();
			statement = connection.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean registerUser(User user) {
		try {
			if (isUserExist(user.getUserId())) {
				String sql = "INSERT INTO `users`(`user_id`,`Name`,`email`,`password`)VALUES('" + user.getUserId()
						+ "','" + user.getuName() + "','" + user.geteMail() + "','" + user.getPass() + "')";

				statement.executeUpdate(sql);
				return true;

			} else 
				return false;
				

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	private boolean isUserExist(String userId) {
		// TODO Auto-generated method stub
		try {
			result = (ResultSet) statement.executeQuery("select * from users where user_id ='" + userId + "'");
			if (result.next())
				return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}

}
