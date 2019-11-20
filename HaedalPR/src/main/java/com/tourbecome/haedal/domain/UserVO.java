package com.tourbecome.haedal.domain;

import java.util.Date;

public class UserVO {
	int user_id;
	String user_email;
	String user_pw;
	String user_nick;
	Date user_reg_date;
	String user_profile;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public Date getUser_reg_date() {
		return user_reg_date;
	}
	public void setUser_reg_date(Date user_reg_date) {
		this.user_reg_date = user_reg_date;
	}
	public String getUser_profile() {
		return user_profile;
	}
	public void setUser_profile(String user_profile) {
		this.user_profile = user_profile;
	}
	
	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_email=" + user_email + ", user_pw=" + user_pw + ", user_nick="
				+ user_nick + ", user_reg_date=" + user_reg_date + ", user_profile=" + user_profile + "]";
	}
	
	
	
	
}
