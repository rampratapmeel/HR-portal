package com.rpm.service;


import java.util.ArrayList;

import com.rpm.model.Attendence;
import com.rpm.model.Holiday;
import com.rpm.model.Leave;
import com.rpm.model.Salary;
import com.rpm.model.User;

public interface AppService {

	boolean adduser(User us);
	String[] login(String email,String pwd);
	void setpass(String email, String password);
	boolean addprofile(User prof);
	ArrayList<User> getentry();
	void verify(String[] rs);
	void leaverequest(Leave us);
	ArrayList<Leave> leaveobject();
	void verifyleave(String[] rs);
	void assignholiday(Holiday h);
    boolean attendencedetails(int parseInt);
	void attendence(int userid);
	void salary();
	User getprofile(String email);
	ArrayList<Salary> getsalary(int userid);
	ArrayList<Attendence> getattendence(int userid);

}
