package com.se.termproject.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.se.termproject.dao.LoginDAO;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = -7097312340301890328L;
	private String uName = null;
	private String pass = null;
	private String msg = null;
	private Boolean isValid=false;

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
	
	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public String validateLogin() {
		Boolean result = LoginDAO.validateUser(uName, pass);
		if (result) {
			this.setMsg(null);
			this.isValid=false;
			return "home";
		} else {
			this.setIsValid(true);
			this.setMsg("Invalid Credentials");
			return "login";
		}
	}
	
	public String logOut() {
		this.setuName(null);
		this.setPass(null);
		return "login";
	}

}
