package com.rpm.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rpm.model.Attendence;
import com.rpm.model.Holiday;
import com.rpm.model.Leave;
import com.rpm.model.Salary;
import com.rpm.model.User;

@Repository
public class AppDaoImpl implements AppDao
{
@Autowired
JdbcTemplate jdbcTemplate; 
	


    @Override
	public boolean adduser(User us) {
System.out.println("Hello adduser Dao1"+us.getEmail()+" "+us.getPassword());
System.out.println("Hello adduser Dao222 "+us.getRole());
final String procall="{Call Proc_User(?,?,?,?,?)}";
	Connection con=null;
	
	boolean b=false;
		
	
	try
	{con=jdbcTemplate.getDataSource().getConnection();
	CallableStatement csd=con.prepareCall(procall);
	csd.setString(1, "Login");
	csd.setString(2, "null");
	csd.setString(3, us.getEmail());
	csd.setString(4, us.getPassword());
	csd.setString(5, us.getRole());
	ResultSet rsd=csd.executeQuery();
	if(rsd.next())
	{System.out.println("Dao true");
		csd.close();
		con.close();
		b=false;
		
	}
	else
		{System.out.println("Hello adduser Dao12");
		csd.close();
		con.close();
		final String procedure_call="{call Proc_User(?,?,?,?,?)}";
		con=jdbcTemplate.getDataSource().getConnection();
		
		CallableStatement cs=con.prepareCall(procedure_call);
		cs.setString(1, "Signup");
		cs.setString(2, us.getName());
		cs.setString(3, us.getEmail());
		cs.setString(4, us.getPassword());
		cs.setString(5, us.getRole());
		cs.execute();
		cs.close();
		System.out.println("Hello adduser Dao13");
		b=true;
		}	
	return b;
	}
	catch(Exception e)
	{
		return b;
		
	}
	finally
		{
		    try
		    {
		    	con.close();
			}
			catch(Exception e)
			{
				return b;
			}
		}
		
}	
		

	
	@Override
	public String[] login(String email, String pwd) {
	
		final String procall="{Call Proc_User(?,?,?,?)}";
	Connection con=null;
	String []a=new String[4];

	
	try
	{System.out.print("ram");
		System.out.print("pwd="+pwd);
		con=jdbcTemplate.getDataSource().getConnection();
		CallableStatement cs=con.prepareCall(procall);
		cs.setString(1, "Login");
		cs.setString(2, "null");
		cs.setString(3, email);
		cs.setString(4, pwd);
		
		ResultSet rs=cs.executeQuery();
		if(rs.next())
			{ a[0]=Integer.toString(rs.getInt("userid"));
			  a[1]=rs.getString("name");
			  a[2]=Integer.toString(rs.getInt("isVerify"));
			  a[3]=rs.getString("role");
			  System.out.print("ram: "+rs.getString("name"));
			cs.close();
			return a;
			}
		else
			{cs.close();
			a[0]="not found";
			return a;
			}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	finally
	{   try
		{
		 con.close();
		}
		catch(Exception e)
		{
		 e.printStackTrace();
        }
	}
		return a;
	}


    @Override
	public void setpass(String email, String password) {
		Connection con=null;
		final String procedure="{Call Proc_User(?,?,?,?)}";
		try
		{
		con=jdbcTemplate.getDataSource().getConnection();
		
	    CallableStatement stm=con.prepareCall(procedure);
	    System.out.println("no");
	    stm.setString(1, "ResetPass");
	    stm.setString(2, "null");
	    stm.setString(3, email);
	    stm.setString(4, password);
	    System.out.println(email+" "+password);
	    stm.executeUpdate();
	    stm.close();
	    System.out.println("Yes");
	   
		}
		catch(Exception e)
		{
			 System.out.println("Yesboss");
		}
		finally
		{try
		{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		
		
	}


    @Override
	public boolean addprofile(User prof) {
		final String query="{Call Proc_User(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		boolean b=false;
		Connection con=null;
		try
		{
			con=jdbcTemplate.getDataSource().getConnection();
		CallableStatement cs=con.prepareCall(query);
		
		cs.setString(1, "addprofile");
		cs.setString(2, "null");
		cs.setString(3, prof.getEmail());
		
		cs.setString(4, "null");
		cs.setString(5, "null");
		cs.setInt(6, 1);
		cs.setString(7, "null");
		cs.setDate(8, prof.getDob());
		
		cs.setString(9, prof.getGender());
		
		cs.setString(10,prof.getDesignation());
		cs.setString(11, prof.getAddress());
		
		cs.setInt(12, prof.getExperienceyear());
		cs.setString(13, prof.getExperiencedetails());
		
		cs.setLong(14, prof.getMobileno());
		
		cs.executeUpdate();
		
		b=true;
		return b;	
		}
		catch(Exception e)
		{
			return b;
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				
			}
		}
		
	}



	@Override
	public ArrayList<User> getentry() {
	    ArrayList<User> l=new ArrayList<User>();
	  
		String query="{Call Proc_User(?)}";
		ResultSet rs=null;
		Connection con=null;
		try
		{con=jdbcTemplate.getDataSource().getConnection();
		CallableStatement cs=con.prepareCall(query);
		cs.setString(1, "getunverified");
		rs=cs.executeQuery();
		System.out.print("helloram:");
		while(rs.next())
		{
			User u=new User();
			u.setUserid(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setRole(rs.getString(6));
			l.add(u);
			System.out.println("dao+"+u);
		}		System.out.print("helloram:");
	    cs.close();	
	    return l;
		}
		catch(Exception e)
		{
			return l;
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
	}



	@Override
	public void verify(String[] rs) {
		String s="{Call Proc_User(?,?,?)}";
		Connection con=null;
		int i=0;
		try
		{
	      con=jdbcTemplate.getDataSource().getConnection();
	      CallableStatement cs=con.prepareCall(s);
	      while(i<rs.length)
	      {
	      
	      cs.setString(1, "verify");
	      cs.setString(2, null);
	      cs.setString(3, rs[i]);
	      cs.executeUpdate();
	      i++;
	      }
	      cs.close();
	      }
		catch(Exception e)
		{
			
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				
			}
		}
		
	}



	@Override
	public void leaverequest(Leave us) {
		
		final String query="{Call Proc_Leave(?,?,?,?,?,?,?)}";
		
		Connection con=null;
		try
		{
			con=jdbcTemplate.getDataSource().getConnection();
		CallableStatement cs=con.prepareCall(query);
		
		cs.setString(1, "Leave");
		cs.setInt(2, 0);
		cs.setInt(3,us.getUserid());
		cs.setString(4, us.getL_type());
		cs.setDate(5, us.getDate_from());
		cs.setDate(6, us.getDate_to());
		cs.setInt(7,us.getDays());
		cs.execute();
		cs.close();
		System.out.print("yes");
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				
			}
		}
	}



	@Override
	public ArrayList<Leave> leaveobject() {
		 ArrayList<Leave> l=new ArrayList<Leave>();
		  
			String query="{Call Proc_Leave(?)}";
			ResultSet rs=null;
			Connection con=null;
			try
			{con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(query);
			cs.setString(1, "LeaveRequest");
			rs=cs.executeQuery();
			System.out.print("helloram:");
			while(rs.next())
			{
				Leave u=new Leave();
				u.setL_id(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setL_type(rs.getString(3));
				u.setDate_from(rs.getDate(4));
				u.setDate_to(rs.getDate(5));
				u.setDays(rs.getInt(6));
				u.setUserid(rs.getInt(7));
				l.add(u);
				System.out.println("dao+"+u);
			}		System.out.print("helloram:");
		    cs.close();	
		    return l;
			}
			catch(Exception e)
			{
				return l;
			}
			finally
			{
				try
				{
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			

		
	}



	@Override
	public void verifyleave(String[] rs) {
		String s="{Call Proc_Leave(?,?)}";
		String s1="{Call Proc_Leave(?,?)}";
		String s2="{Call Proc_Leave(?,?,?,?,?)}";
		String s3="{Call Proc_Attendence(?,?,?,?,?)}";
		Connection con=null,con1=null,con2=null,con3=null;
		int i=0;
		try
		{
	      con=jdbcTemplate.getDataSource().getConnection();
	      con1=jdbcTemplate.getDataSource().getConnection();
	      con2=jdbcTemplate.getDataSource().getConnection();
	      con3=jdbcTemplate.getDataSource().getConnection();
	      CallableStatement cs=con.prepareCall(s);
	      CallableStatement cs1=con1.prepareCall(s1);
	      CallableStatement cs2=con2.prepareCall(s2);
	      CallableStatement cs3=con3.prepareCall(s3);
	      while(i<rs.length)
	      {
	      
	      cs.setString(1, "VerifyLeave");
	      cs.setInt(2, Integer.parseInt(rs[i]));
	      cs.executeUpdate();
	     
	      cs1.setString(1, "GetInf");
	      cs1.setInt(2, Integer.parseInt(rs[i]));
	      cs1.execute();
	      
	      ResultSet rst=cs1.getResultSet();
	      if(rst.next())
	      {
	    	  Date startdate=rst.getDate(2);
	      int days=rst.getInt(1);
	      int user=rst.getInt(3);
	      
	      ResultSet rst2;
	      for(int j=0;j<days;j++)
	      {
	    	cs3.setString(1, "InsertLeaveAttendence");
	    	cs3.setDate(2, startdate);
	    	cs3.setString(3, "null");
	    	cs3.setInt(4, user);
	    	cs3.setInt(5, 0);
	    	cs3.execute();
	    	
	    	  
	    	cs2.setString(1, "getdate");
	    	cs2.setInt(2, 0);
	    	cs2.setInt(3, 0);
	    	cs2.setString(4, "null");
	    	cs2.setDate(5,startdate);
	    	cs2.execute();
	    	rst2=cs2.getResultSet();
	    	if(rst2.next())
	    	{
	    		startdate=rst2.getDate(1);
	    		
	    	}
	    	
	      }
	      }
	      i++;
	      
	      }
	      cs.close();
	      cs1.close();
	      cs2.close();
	      cs3.close();
	      }
		catch(Exception e)
		{
			
		}
		finally
		{
			try
			{
				con.close();
				con1.close();
				con2.close();
				con3.close();
			}
			catch(Exception e)
			{
				
			}
		}

		
	}



	@Override
	public void assignholiday(Holiday h) {
		final String query="{Call Proc_Attendence(?,?,?)}";
		
		Connection con=null;
		try
		{
			con=jdbcTemplate.getDataSource().getConnection();
		CallableStatement cs=con.prepareCall(query);
		
		cs.setString(1, "InsertHoliday");
		cs.setDate(2, h.getHdate());
		cs.setString(3, h.getHdetails());
		
		
		
		cs.execute();
		
			
		}
		catch(Exception e)
		{
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				
			}
		}

	
	}



	@Override
	public boolean attendencedetails(int user) {
		String query="{Call Proc_Attendence(?,?,?,?)}";
		boolean b=true;
		Connection con=null;
		try
		{  con=jdbcTemplate.getDataSource().getConnection();
		 System.out.println("Attendenceuser:"+user);
		   CallableStatement cs=con.prepareCall(query);
		   cs.setString(1, "GetAttendence");
		   cs.setDate(2, null);
		   cs.setString(3, "null");
		   cs.setInt(4, user);
		   cs.executeQuery();
		   ResultSet rs;
		   rs=cs.getResultSet();
		   if(rs.next())
		   {   System.out.println("Attendence:");
			   b=false;
		   }
		   else
		   { System.out.println("AttendenceFalse:");
			   cs.setString(1, "GetHoliday");
			   cs.setDate(2, null);
			   cs.setString(3, "null");
			   cs.setInt(4, 0);
			   cs.executeQuery();
			   rs=cs.getResultSet();
			   if(rs.next())
			   {
				   b=false;
			   }
		   }
		   cs.close();
		   return b;
		}
		catch(Exception e)
		{
			 return b;
		}
		finally
		{   try
		    {
			con.close();
			
			}
		
		    catch(Exception e)
	     	{
		     	e.printStackTrace();
		    }
				
		}
		
	}



	@Override
	public void attendence(int userid) {
		String query="{Call Proc_Attendence(?,?,?,?)}";
		Connection con=null;
		java.util.Date d = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YY-MM-DD");
		String sdate=dateFormat.format(d);
		
		try{
		d=dateFormat.parse(sdate);
		}
		catch(Exception e)
		{
			
		}
		long ms=d.getTime();
		java.sql.Date d1=new java.sql.Date(ms);
		  
		try
		{
			con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(query);
			cs.setString(1, "InsertAttendence");
			cs.setDate(2, d1);
			cs.setString(3, "null");
			cs.setInt(4, userid);
			cs.executeUpdate();
			cs.close();
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				
			}
		}
		
	}



	@Override
	public void salary() {
		
		 ArrayList<Integer> l=new ArrayList<Integer>();
		 ArrayList<String> m=new ArrayList<String>();
			int salary=0;
		    String query="{Call Proc_User(?)}";
			ResultSet rs=null;
			Connection con=null;
			try
			{con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(query);
			cs.setString(1, "getuser");
			rs=cs.executeQuery();
			while(rs.next())
			{  l.add(rs.getInt(1));
			   m.add(rs.getString(2));
				
				
			}	
			cs.close();	
		    
			}
			catch(Exception e)
			{
			
			}
			finally
			{
				try
				{
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			query="{Call Proc_Attendence(?)}";
			rs=null;
			con=null;
		int holiday=0;
			try
			{con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(query);
			cs.setString(1, "holidaydetail");
			rs=cs.executeQuery();
			while(rs.next())
			{  holiday=rs.getInt(1);
			}
			cs.close();	
		    
			}
			catch(Exception e)
			{
			
			}
			finally
			{
				try
				{
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			Calendar c = Calendar.getInstance();
			int Days = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			int i=0;
			while(i<l.size())
			{query="{Call Proc_Attendence(?,?,?,?)}";
			rs=null;
			con=null;
			int attendence=holiday;
			try
			{con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(query);
			cs.setString(1, "attdetail");
			cs.setDate(2, null);
			cs.setString(3, "null");
			cs.setInt(4,l.get(i) );
			rs=cs.executeQuery();
			while(rs.next())
			{  attendence+=rs.getInt(1);
			}
			cs.close();	
		    
			}
			catch(Exception e)
			{
			
			}
			finally
			{
				try
				{
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			if(m.get(i).equals("SoftwareTraniee"))
				salary=35000-(Days-attendence)*1100;
			else if(m.get(i).equals("SeniorDeveloper"))
				salary=50000-(Days-attendence)*1600;
			else if(m.get(i).equals("Tester"))
				salary=40000-(Days-attendence)*1300;
			else
				salary=60000-(Days-attendence)*2000;
			query="{Call Proc_SalaryDetail(?,?,?,?,?)}";
			
			con=null;
			
			try
			{con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(query);
			cs.setString(1, "InsertSalary");
			cs.setInt(2, l.get(i));
			cs.setInt(3, 0);
			cs.setInt(4, 0);
			cs.setInt(5,salary);
			cs.executeUpdate();
			cs.close();	
		    
			}
			catch(Exception e)
			{
			
			}
			finally
			{
				try
				{
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}


		
			i++;}
	}



	@Override
	public User getprofile(String email) {
		User u=new User();
		String query="{Call Proc_User(?,?,?)}";
		ResultSet rs=null;
		Connection con=null;
		try
		{con=jdbcTemplate.getDataSource().getConnection();
		CallableStatement cs=con.prepareCall(query);
		System.out.print("helloram:");
		System.out.print(email);
		cs.setString(1, "getprofile");
		cs.setString(2, "null");
		cs.setString(3, email);
		rs=cs.executeQuery();
		System.out.print("helloramchili:");
		if(rs.next())
		{System.out.print("helloramghghgh:");

			
			u.setUserid(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setRole(rs.getString(6));
			u.setDob(rs.getDate(8));
			u.setGender(rs.getString(9));
			u.setDesignation(rs.getString(10));
			u.setAddress(rs.getString(11));
			u.setExperienceyear(rs.getInt(12));
			u.setExperiencedetails(rs.getString(13));
			u.setMobileno(rs.getLong(14));
			//System.out.println("dao+"+u);
		}else{		System.out.print("helloram:fail");}
	    cs.close();	
	    return u;
		}
		catch(Exception e)
		{System.out.print("helloram:failexe");
			return u;
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}



	@Override
	public ArrayList<Salary> getsalary(int userid) {
		
		 ArrayList<Salary> l=new ArrayList<Salary>();
		  
			String query="{Call Proc_SalaryDetail(?,?)}";
			ResultSet rs=null;
			Connection con=null;
			try
			{con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(query);
			System.out.print("helloram:22");
			System.out.print(userid);
			cs.setString(1, "getSalary");
			cs.setInt(2, userid);
			
			rs=cs.executeQuery();
			System.out.print("helloram:");
			while(rs.next())
			{System.out.print("helloram223:");
				Salary u=new Salary();
				u.setMonth(rs.getInt(3));
				u.setYear(rs.getInt(4));
				u.setSalary(rs.getInt(5));
				System.out.print(u.getSalary());
				l.add(u);
				
			}		
		    cs.close();	
		    return l;
			}
			catch(Exception e)
			{
				return l;
			}
			finally
			{
				try
				{
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			

	}



	@Override
	public ArrayList<Attendence> getattendence(int userid) {
		ArrayList<Attendence> l=new ArrayList<Attendence>();
		  
		String query="{Call Proc_Attendence(?,?,?,?)}";
		ResultSet rs=null;
		Connection con=null;
		try
		{con=jdbcTemplate.getDataSource().getConnection();
		CallableStatement cs=con.prepareCall(query);
		System.out.print("helloram:22");
		System.out.print(userid);
		cs.setString(1, "getatt");
		cs.setDate(2,null );
		cs.setString(3, "null");
		
		cs.setInt(4, userid);
		
		rs=cs.executeQuery();
		System.out.print("helloram56:");
		while(rs.next())
		{System.out.print("helloram223:");
			Attendence u=new Attendence();
			u.setMonth(rs.getInt(1));
			u.setYear(rs.getInt(2));
			u.setAttendence(rs.getInt(3));
			
			l.add(u);
			
		}		
	    cs.close();	
	    return l;
		}
		catch(Exception e)
		{
			return l;
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		

}



}
