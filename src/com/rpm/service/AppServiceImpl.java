package com.rpm.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpm.dao.AppDao;
import com.rpm.model.Attendence;
import com.rpm.model.Holiday;
import com.rpm.model.Leave;
import com.rpm.model.Salary;
import com.rpm.model.User;

@Service
public class AppServiceImpl implements AppService{
@Autowired
AppDao obj;
	@Override
	public boolean adduser(User us) {
		
		return obj.adduser(us);
		
		
	}
	@Override
	public String[] login(String email, String pwd) {
		return obj.login(email, pwd);
		
	}
	@Override
	public void setpass(String email, String password) {
		obj.setpass(email,password);
		
	}
	@Override
	public boolean addprofile(User prof) {
		
		return obj.addprofile(prof);
	}
	@Override
	public ArrayList<User> getentry() {
		
		return obj.getentry();
	}
	@Override
	public void verify(String[] rs) {
		obj.verify(rs);
		
	}
	@Override
	public void leaverequest(Leave us) {
	obj.leaverequest(us);
		
	}
	@Override
	public ArrayList<Leave> leaveobject() {
		// TODO Auto-generated method stub
		return obj.leaveobject();
	}
	@Override
	public void verifyleave(String[] rs) {
	obj.verifyleave(rs);
		
	}
	@Override
	public void assignholiday(Holiday h) {
		obj.assignholiday(h);
		
	}
	@Override
	public boolean attendencedetails(int user) {
		// TODO Auto-generated method stub
		return obj.attendencedetails(user);
	}
	@Override
	public void attendence(int userid) {
		obj.attendence(userid);
		
	}
	@Override
	public void salary() {
		obj.salary();
		
	}
	@Override
	public User getprofile(String email) {
		User prof=obj.getprofile(email);
		return prof;
	}
	@Override
	public ArrayList<Salary> getsalary(int userid) {
		 ArrayList<Salary> salary=new ArrayList<Salary>();
		 salary=obj.getsalary(userid);
		return salary;
	}
	@Override
	public ArrayList<Attendence> getattendence(int userid) {
		return obj.getattendence(userid);
		
	}

}
