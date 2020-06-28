
package com.nike.app.planner.boot.web.mvc.bean.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

	@NotEmpty
	@Size(min=4, max=20)
	private String userName = null;

	@NotEmpty
	@Size(min=6, max=20)
	private String userPassword = null;

	private boolean rememberMe = false;

	public LoginForm() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String toString() {
		return "userName = " + userName + ", userPassword = " + userPassword + ", rememberMe = " + rememberMe;
	}
}