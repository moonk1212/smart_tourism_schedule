package com.tourbecome.haedal.domain;

import java.sql.*;

public class ScheduleContentVO {
	private Integer sco_id;//pk
	private Integer scd_id;//schedule pk
	private String sco_start_spot;
	private String sco_end_spot;
	private Time sco_time;
	private String sco_content;
	private Integer sco_expenses;
	private Integer sco_day;
	
	public Integer getSco_id() {
		return sco_id;
	}
	public void setSco_id(Integer sco_id) {
		this.sco_id = sco_id;
	}
	public Integer getScd_id() {
		return scd_id;
	}
	public void setScd_id(Integer scd_id) {
		this.scd_id = scd_id;
	}
	public String getSco_start_spot() {
		return sco_start_spot;
	}
	public void setSco_start_spot(String sco_start_spot) {
		this.sco_start_spot = sco_start_spot;
	}
	public String getSco_end_spot() {
		return sco_end_spot;
	}
	public void setSco_end_spot(String sco_end_spot) {
		this.sco_end_spot = sco_end_spot;
	}
	public Time getSco_time() {
		return sco_time;
	}
	public void setSco_time(Time scd_time) {
		this.sco_time = scd_time;
	}
	public String getSco_content() {
		return sco_content;
	}
	public void setSco_content(String sco_content) {
		this.sco_content = sco_content;
	}
	public Integer getSco_expenses() {
		return sco_expenses;
	}
	public void setSco_expenses(Integer sco_expenses) {
		this.sco_expenses = sco_expenses;
	}
	public Integer getSco_day() {
		return sco_day;
	}
	public void setSco_day(Integer sco_day) {
		this.sco_day = sco_day;
	}
	
	
} //ScheduleContentVO
