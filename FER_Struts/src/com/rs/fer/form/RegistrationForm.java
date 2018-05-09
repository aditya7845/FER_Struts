package com.rs.fer.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegistrationForm extends ActionForm {
	private static final long seriolVersionUID=1L;

	private String firstname;
	private String middlename;
	private String lastname;
	private String emailid;
	private String username;
	private String password;
	private String mobile;

	

	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getMiddlename() {
		return middlename;
	}



	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getEmailid() {
		return emailid;
	}



	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public static long getSeriolversionuid() {
		return seriolVersionUID;
	}



	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		System.out.println("into validate");
		if (firstname == null || firstname.length() < 1) {
			errors.add("firstname", new ActionMessage("error.firstname.required"));
		}
		if (middlename == null || middlename.length() < 1) {
			errors.add("middlename", new ActionMessage("error.middlename.required"));
		}
		if (lastname == null || lastname.length() < 1) {
			errors.add("lastname", new ActionMessage("error.lastname.required"));
		}

		if (emailid == null || emailid.length() < 1) {
			errors.add("emailid", new ActionMessage("error.emailid.required"));
		}

		if (username == null || username.length() < 1) {
			errors.add("username", new ActionMessage("error.username.required"));
		}

		if (password == null || password.length() < 1) {
			errors.add("password", new ActionMessage("error.password.required"));
		}

		if (mobile == null || mobile.length() < 1) {
			errors.add("mobile", new ActionMessage("error.mobile.required"));
		}

		return errors;

	}
}