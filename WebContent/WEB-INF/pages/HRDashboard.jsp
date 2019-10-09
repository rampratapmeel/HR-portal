<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.text.DateFormat" %>  
  <%@ page import="java.text.SimpleDateFormat" %>
  <%@ page import="com.rpm.model.*" %>   
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
     
 <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>HRDashboard</title>
<style>
.card {
  border: 1px solid black;
  margin: 10px;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  width: 40%;
}

.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

.container {
  padding: 2px 16px;
}
</style>
</head>
<body>
<%Boolean b=(Boolean)request.getAttribute("attendence") ;
  java.util.Date d = new java.util.Date();
  DateFormat dateFormat = new SimpleDateFormat("HHmmss");  
  int strDate = Integer.parseInt(dateFormat.format(d));
  MySession ses=(MySession)request.getSession().getAttribute("session");
  boolean x=b.booleanValue();

%>
<h1 align="center"><i>Welcome HR</i></h1>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
<div class="container">
  <div class="row-height">
    <div class="row">
      <div class="col-height col-middle col-xs-5 pull-left card">
        <div class="col-xs-12 text-center">
          <h3 class="heading-s1">Profile</h3>
        </div>
        <div class="col-xs-12 text-center">
          <a  href="updateprofile" class="btn big-btn no-border red-background unstyle-anchor" style="padding: 13px 50px;">Profile</a>
        </div>
      </div>
      <div class="col-height col-middle col-xs-5 pull-right card">
        <div class="col-xs-12 text-center">
          <h3 class="heading-s1">Leave Request</h3>
        </div>
        <div class="col-xs-12 text-center">
          <a href="leaverequest" class="btn big-btn no-border red-background unstyle-anchor" style="padding: 13px 50px;">Leave Request</a>
        </div>
      </div>
      <div class="col-height col-middle col-xs-5 pull-left card">
        <div class="col-xs-12 text-center">
          <h3 class="heading-s1">Add Employee</h3>
        </div>
        <div class="col-xs-12 text-center">
          <a  href="SignupEmp" class="btn big-btn no-border red-background unstyle-anchor" style="padding: 13px 50px;">Add Employee</a>
        </div>
      </div>
      <div class="col-height col-middle col-xs-5 pull-right card">
        <div class="col-xs-12 text-center">
          <h3 class="heading-s1">Salary</h3>
        </div>
        <div class="col-xs-12 text-center">
          <a href="getSalary" class="btn big-btn no-border red-background unstyle-anchor" style="padding: 13px 50px;">Salary</a>
        </div>
      </div>
     <div class="col-height col-middle col-xs-5 pull-left card">
        <div class="col-xs-12 text-center">
          <h3 class="heading-s1">Attendence Details</h3>
        </div>
        <div class="col-xs-12 text-center">
          <a  href="attendencedetail" class="btn big-btn no-border red-background unstyle-anchor" style="padding: 13px 50px;">Attendence Details</a>
        </div>
      </div>
      <div class="col-height col-middle col-xs-5 pull-right card">
        <div class="col-xs-12 text-center">
          <h3 class="heading-s1">Logout</h3>
        </div>
        <div class="col-xs-12 text-center">
          <a href="logout" class="btn big-btn no-border red-background unstyle-anchor" style="padding: 13px 50px;">Logout</a>
        </div>
      </div>
      <div class="col-height col-middle col-xs-5 pull-left card">
        <div class="col-xs-12 text-center">
          <h3 class="heading-s1">Tick Attendence</h3>
        </div>
        <div class="col-xs-12 text-center">
        <% if(x&&strDate>=100000&&strDate<=220000){%>
 
   <a  href="Attendence" class="btn big-btn no-border red-background unstyle-anchor" style="padding: 13px 50px;">Attendence </a>
     
  
  </div>
  <% } %>
            </div>
      </div>
    </div>
  </div>
</div>
  
</body>
</html>