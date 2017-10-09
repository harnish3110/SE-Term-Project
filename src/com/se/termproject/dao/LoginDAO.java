package com.se.termproject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.se.termproject.utilities.DatabaseConnection;

public class LoginDAO {

	public static Boolean validateUser(String uName, String pass) {
		// TODO Auto-generated method stub
		try {
			DatabaseConnection db = new DatabaseConnection();
			Connection con = db.createConnection();
			Statement statement = con.createStatement();
			ResultSet rest = statement
					.executeQuery("select * from users where (user_id ='" + uName + "'&& password='" + pass + "')");
			if (rest.next())
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public static Object getNameById(String userId) {
		// TODO Auto-generated method stub
		
		try {
			DatabaseConnection db = new DatabaseConnection();
			Connection con = db.createConnection();
			Statement statement = con.createStatement();
			ResultSet rest = statement
					.executeQuery("select firstName from users where (user_id ='" + userId + "')");
			rest.next();
			return rest.getString("firstName");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "User";
	}

}
