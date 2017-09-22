package com.se.teamproject.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.se.teamproject.dao.LoginDAO;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = -7097312340301890328L;
	private String uName = null;
	private String pass = null;
	private String msg = null;

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String validateLogin() {
		Boolean result = LoginDAO.validateUser(uName, pass);
		if (result) {
			this.setMsg(null);
			return "home";
		} else {
			this.setMsg("Invalid Credentials");
			return "login";
		}
	}

}
