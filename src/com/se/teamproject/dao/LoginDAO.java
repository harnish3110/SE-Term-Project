package com.se.teamproject.dao;

public class LoginDAO {

	public static Boolean validateUser(String uName, String pass) {
		// TODO Auto-generated method stub
		if(uName.equals("Admin")&& pass.equals("Admin"))
			return true;
		return false;
	}

}
