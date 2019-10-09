package com.rpm.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rpm.model.Attendence;
import com.rpm.model.Holiday;
import com.rpm.model.Leave;
import com.rpm.model.MySession;
import com.rpm.model.Salary;
import com.rpm.model.User;
import com.rpm.service.AppService;

@Controller
public class AppController {
	@Autowired
	AppService obj;
	
	@RequestMapping(value="/")
	public String m()
	{  
		return "index";
	}
	
	@RequestMapping(value="signupHR")
	public String HRsignup(HttpServletRequest req)
	{    String role="HR";
	req.setAttribute("role",role);
		return "signup";
	}
	
	@RequestMapping(value="SignupEmp")
	public String EMPsignup(HttpServletRequest req)
	{    String role="EMP";
	req.setAttribute("role",role);
		return "signup";
	}

	@RequestMapping(value="adduser",method=RequestMethod.POST)
	public String adduser(User us,HttpServletRequest req)
	{System.out.print("Hello Adduser");
	String s=new String(us.getRole());
	String s1=new String("EMP");
	if(s.equals(s1))
	{MySession mysession4=(MySession)req.getSession().getAttribute("session");
	req.setAttribute("session", mysession4);
	 boolean u=obj.attendencedetails(mysession4.getUserid());
	 req.setAttribute("attendence", u);
	}if(obj.adduser(us))
	 {   if(us.getRole().equals("EMP"))
		 return "HRDashboard";
	 else if(us.getRole().equals("ADM"))
		 return "AdminDashboard";
	 else
		 return "index";
	 }
	 else{System.out.print("Hello Adduser ram");
		 return "index";}
	}
	
	@RequestMapping(value="AccountVerify")
	public String AccountVerify(HttpServletRequest req)
	{  
	ArrayList<User> a=obj.getentry();
	int i=0;
	if(a!=null)
	{while(i<a.size())
	{
		System.out.println(a.get(i).getUserid());
		i++;
	}}
	
	     req.setAttribute("result", a);
	return "verify";
	}
	
	@RequestMapping(value="finallyverify")
	public String finallyverify(HttpServletRequest req)
	{    String[] rs=req.getParameterValues("names");
	     obj.verify(rs);
	return "redirect:AccountVerify";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(HttpServletRequest req,HttpSession session)
	{//String name=req.getParameter("name");
	 String pwd=req.getParameter("password");
	 String email=req.getParameter("email");
     
	 String[] b= obj.login(email,pwd);
	 
	
	 System.out.print("length "+b.length);
	
	 if(b[0]!="not found")
	 {  if(Integer.parseInt(b[2])==1)
		 {MySession mysession=new MySession();
		 int user=Integer.parseInt(b[0]);
		 boolean u=obj.attendencedetails(user);
	     System.out.print("value="+u);
	     req.setAttribute("attendence", u);
	     System.out.print("name"+b[1]);
	     System.out.print("email"+email);
		 
		 mysession.setUserid(Integer.parseInt(b[0]));
		 mysession.setName( b[1]);
		 System.out.print("email "+mysession.getName());
	     mysession.setEmail(email);
	     mysession.setRole(b[3]);
	     session.setAttribute("session", mysession);
	 if(b[3].equals("ADM"))
	 return "AdminDashboard";
	 else if(b[3].equals("HR"))
		 return "HRDashboard";
	 else 
		 return "EmpDashboard";
		 }
	 else{
		 req.setAttribute("msg", "Invalid Email or Password");
		 return "index";
		 }
	 }else
	 {req.setAttribute("msg", "Invalid Email or Password");
		 return "index";
	 }
	 }
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session ) {
	    session.invalidate();
	    return "index";
	} 
	
	
	

	@RequestMapping(value="updateprofile")
	public String updateprofile(HttpServletRequest req,User prof)
	{
		MySession mysession2=(MySession)req.getSession().getAttribute("session");
		System.out.print("helloboy");
		System.out.print(mysession2.getEmail());
		User prof2=obj.getprofile(mysession2.getEmail());
		

		System.out.print(prof2.getEmail());

		req.setAttribute("mysession", prof2);
		
			
			

		return "login";
	}
	
	@RequestMapping(value="profile",method=RequestMethod.POST)
	public String profile(User prof,HttpServletRequest req)
	{
		boolean b=obj.addprofile(prof);
		System.out.print(b);
		MySession mysession3=(MySession)req.getSession().getAttribute("session");
		req.setAttribute("session", mysession3);
		 boolean u=obj.attendencedetails(mysession3.getUserid());
		 req.setAttribute("attendence", u);
		 if(mysession3.getRole().equals("EMP"))
		return "EmpDashboard";
		 else if(mysession3.getRole().equals("HR"))
			 return "HRDashboard";
			 else if(mysession3.getRole().equals("ADM"))
				 return "AdminDashboard";
			 else
			return "index";
	}
	
	
	@RequestMapping(value="resetpassword")
	public String reset()
	{
		return "resetpassword";
	}
	@RequestMapping(value="newpass",method=RequestMethod.POST)
	public String newpass(HttpServletRequest req)
	{req.setAttribute("email", req.getParameter("email"));
		return "newpassword";
	}

	@RequestMapping(value="setpass",method=RequestMethod.POST)
	public String setpass(HttpServletRequest req)
	{obj.setpass(req.getParameter("email"),req.getParameter("password"));
		return "index";
	}
	@RequestMapping(value="leaverequest")
	public String leaveRequest(HttpServletRequest req)
	{   MySession mysession=(MySession)req.getSession().getAttribute("session");
    	req.setAttribute("mysession", mysession);
        return "leaverequest";
	}
	@RequestMapping(value="leave",method=RequestMethod.POST)
	public String leave(Leave us,HttpSession session,HttpServletRequest req)
	{  obj.leaverequest(us);
	MySession session1=(MySession)session.getAttribute("session");
	 boolean u=obj.attendencedetails(session1.getUserid());
	 req.setAttribute("attendence", u);
	    if(session1.getRole().equals("EMP"))
        return "EmpDashboard";
	    else
	    	return "HRDashboard";
	}
	@RequestMapping(value="leaveverify")
	public String leaveverify(HttpServletRequest req)
	{  ArrayList<Leave> a=obj.leaveobject();
	   req.setAttribute("result", a);
        return "leaveverify";
	}
	@RequestMapping(value="leaveverifyfinally")
	public String leaveverifyfinally(HttpServletRequest req)
	{  String[] rs=req.getParameterValues("l_id");
	int i=0;
	System.out.println("veryfy");
	while(i<rs.length)
	{
		System.out.println("veryfy "+rs[i]);
		i++;
	}
		obj.verifyleave(rs);
        return "AdminDashboard";
	}
	
	@RequestMapping(value="AssignHoliday")
	public String AssignHoliday(Holiday h)
	{ 
		obj.assignholiday(h);
        return "AdminDashboard";
	}
	
	@RequestMapping(value="Attendence")
	public String Attendence(HttpServletRequest req)
	{ MySession mysess=(MySession)req.getSession().getAttribute("session");
		obj.attendence(mysess.getUserid());
		
		 boolean u=obj.attendencedetails(mysess.getUserid());
		 req.setAttribute("attendence", u);
		    if(mysess.getRole().equals("EMP"))
	        return "EmpDashboard";
		    else
		    	return "HRDashboard";
	}
	@RequestMapping(value="Salary")
	public String Salary(HttpServletRequest req)
	{   obj.salary();
		return "AdminDashboard";
	}
	@RequestMapping(value="getSalary")
	public String Getsalary(HttpServletRequest req)
	{   MySession mysess=(MySession)req.getSession().getAttribute("session");
		ArrayList<Salary> salary=obj.getsalary(mysess.getUserid());
	 
	   req.setAttribute("result", salary);
		
		
		return "salary";
	}
	@RequestMapping(value="attendencedetail")
	public String attendencedetail(HttpServletRequest req)
	{   MySession mysess=(MySession)req.getSession().getAttribute("session");
		ArrayList<Attendence> attendence=obj.getattendence(mysess.getUserid());
	 
	   req.setAttribute("result", attendence);
		
		
		return "Attendence";
	}
	
	
	
}
