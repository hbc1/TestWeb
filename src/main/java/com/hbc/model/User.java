package com.hbc.model;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 136234994993281936L;

	private Integer userId;

    private String userLogin;

    private String userPassword;

    private String userSex;

    private String userPhone;

    private String userEmail;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userLogin=" + userLogin
				+ ", userPassword=" + userPassword + ", userSex=" + userSex
				+ ", userPhone=" + userPhone + ", userEmail=" + userEmail + "]";
	}
	
}