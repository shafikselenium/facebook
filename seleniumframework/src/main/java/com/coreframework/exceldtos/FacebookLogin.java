package com.coreframework.exceldtos;

public class FacebookLogin {
	private String userLogin;
	private String userPassword;
	private Boolean isValidUser;

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(final String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(final String userPassword) {
		this.userPassword = userPassword;
	}

	public Boolean getIsValidUser() {
		return isValidUser;
	}

	public void setIsValidUser(final String isValidUser) {
		if (isValidUser.equalsIgnoreCase("YES"))
			this.isValidUser = true;
		else
			this.isValidUser = false;
	}

	@Override
	public String toString() {
		return "logged in facebook user name " + userLogin;
	}

}
