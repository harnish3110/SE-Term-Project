package com.se.termproject.dao;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.se.termproject.beans.User;
import com.se.termproject.utilities.DatabaseConnection;

public class RegistrationDAO {
	DatabaseConnection db = null;
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet result = null;

	public RegistrationDAO() {
		// TODO Auto-generated constructor stub
		try {
			db = new DatabaseConnection();
			connection = db.createConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean registerUser(User user) {
		try {
			if (isUserExist(user.getUserId())) {
				/*String sql = "INSERT INTO `users`(`user_id`,`firstName`,`lastName`,`email`,`password`)VALUES('"
						+ user.getUserId() + "','" + user.getfName() + "','" + user.getlName() + "','" + user.geteMail()
						+ "','" + user.getPass() + "')";*/
				
				String sql = "INSERT INTO `users`(`user_id`,`firstName`,`lastName`,`email`,`password`)VALUES(?,?,?,?,?)";
				statement = (PreparedStatement) connection.prepareStatement(sql);
				statement.setString(1, user.getUserId());
				statement.setString(2, user.getfName());
				statement.setString(3, user.getlName());
				statement.setString(4, user.geteMail());
				statement.setString(5, user.getPass());

				statement.executeUpdate();
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
