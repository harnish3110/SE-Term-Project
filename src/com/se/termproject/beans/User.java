package com.se.termproject.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.se.termproject.dao.LoginDAO;
import com.se.termproject.dao.RegistrationDAO;

@ManagedBean(name = "user")
@SessionScoped
public class User implements Serializable {
	private static final long serialVersionUID = 8220815346552611557L;

	private String uName = null;
	private String pass = null;
	private String msg = null;
	private Boolean isValid = false;
	private String eMail = null;
	private String userId = null;

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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	// Methods

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String validateLogin() {
		Boolean result = LoginDAO.validateUser(uName, pass);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (result) {
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			facesContext.getExternalContext().getSessionMap().put("message", "Success");
			// session.setAttribute("Message", this.getMsg());
			session.setAttribute("User Id", this.getUserId());
			return "home";
		} else {
			this.setIsValid(true);
			this.setMsg("Invalid Credentials");
			facesContext.getExternalContext().getSessionMap().put("message", "Invalid Credential");
			return "login";
		}
	}

	public String logOut() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("message");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		this.setMsg(null);
		return "login";
	}

	public String register() {
		this.setMsg(null);
		try {
			RegistrationDAO register = new RegistrationDAO();
			if (register.registerUser(this)) {
				this.setMsg("Registration Successful");
				FacesContext facesContext = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
				facesContext.getExternalContext().getSessionMap().put("message", "Registration Successful");
				session.setAttribute("User Id", this.getUserId());
				return "login";
			} else {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("msg",
						"User Id already exist");
				return "registration";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			this.setMsg("Some Error Found \t" + e.toString());
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "registration";
		}
	}

}
