package com.rpm.model;

import java.sql.Date;

public class User {
	private int userid;
	private  String name;
	private String email;
	private String password;
	private  String gender;
	private Date dob;
	private String designation;
	private String address;
	private String role;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private Long mobileno;
	private int experienceyear;
	private String experiencedetails;
	private int isverify;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getMobileno() {
		return mobileno;
	}
	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}
	public int getExperienceyear() {
		return experienceyear;
	}
	public void setExperienceyear(int experienceyear) {
		this.experienceyear = experienceyear;
	}
	public String getExperiencedetails() {
		return experiencedetails;
	}
	public void setExperiencedetails(String experiencedetails) {
		this.experiencedetails = experiencedetails;
	}
	public int getIsverify() {
		return isverify;
	}
	public void setIsverify(int isverify) {
		this.isverify = isverify;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
 