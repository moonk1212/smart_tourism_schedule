package com.tourbecome.haedal.domain;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ScheduleVO {
	private Integer scd_id;
	private Integer user_id;
	private String scd_title;
	private Date scd_start_date;
	private Date scd_end_date;
	private String scd_destination;
	private Integer  scd_total_expense;
	
	private ScheduleContentVO scheduleContentVO;
	private UserVO userVO;
	
	
	
	public ScheduleContentVO getScheduleContentVO() {
		return scheduleContentVO;
	}
	public void setScheduleContentVO(ScheduleContentVO scheduleContentVO) {
		this.scheduleContentVO = scheduleContentVO;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public Integer getScd_id() {
		return scd_id;
	}
	public void setScd_id(Integer scd_id) {
		this.scd_id = scd_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getScd_title() {
		return scd_title;
	}
	public void setScd_title(String scd_title) {
		this.scd_title = scd_title;
	}
	public Date getScd_start_date() {
		return scd_start_date;
	}
	public void setScd_start_date(Date scd_start_date) {
		this.scd_start_date = scd_start_date;
	}
	public Date getScd_end_date() {
		return scd_end_date;
	}
	public void setScd_end_date(Date scd_end_date) {
		this.scd_end_date = scd_end_date;
	}
	public String getScd_destination() {
		return scd_destination;
	}
	public void setScd_destination(String scd_destination) {
		this.scd_destination = scd_destination;
	}
	public Integer getScd_total_expense() {
		return scd_total_expense;
	}
	public void setScd_total_expense(Integer scd_total_expense) {
		this.scd_total_expense = scd_total_expense;
	}
	
	
} //ScheduleVO
