package com.rpm.model;

import java.sql.Date;

public class Holiday {
	private int h_id;
	public int getH_id() {
		return h_id;
	}
	public void setH_id(int h_id) {
		this.h_id = h_id;
	}
	public Date getHdate() {
		return hdate;
	}
	public void setHdate(Date hdate) {
		this.hdate = hdate;
	}
	public String getHdetails() {
		return hdetails;
	}
	public void setHdetails(String hdetails) {
		this.hdetails = hdetails;
	}
	private Date hdate;
	private String hdetails;

}
