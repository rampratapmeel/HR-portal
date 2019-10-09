<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.card {
  border: 2px solid black;
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 <!-- Main css -->
   <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Dashboard</title>
 <script>
  $(document).ready(function () {
	    var date = new Date();
	    var currentMonth = date.getMonth();
	    var currentDate = date.getDate();
	    var currentYear = date.getFullYear();

	    $('#datepicker').datepicker({
	       
	        dateFormat: 'yy-mm-dd'
	    });
	});
  </script>
  
</head>
<body>
<%Calendar c = Calendar.getInstance();
int Days = c.getActualMaximum(Calendar.DAY_OF_MONTH);
int today=c.get(Calendar.DAY_OF_MONTH);%>
<h1 align="center"><i>Welcome Admin</i></h1>
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
          <h3 class="heading-s1">Leave Requests</h3>
        </div>
        <div class="col-xs-12 text-center">
          <a href="leaveverify" class="btn big-btn no-border red-background unstyle-anchor" style="padding: 13px 50px;">Leave Request</a>
        </div>
      </div>
      <div class="col-height col-middle col-xs-5 pull-left card">
        <div class="col-xs-12 text-center">
          <h3 class="heading-s1">Verify Employee/HR</h3>
        </div>
        <div class="col-xs-12 text-center">
          <a  href="AccountVerify" class="btn big-btn no-border red-background unstyle-anchor" style="padding: 13px 50px;">Verify Employee/HR</a>
        </div>
      </div>
      <div class="col-height col-middle col-xs-5 pull-right card">
        <div class="col-xs-12 text-center">
          <h3 class="heading-s1">Salary</h3>
        </div>
        <div class="col-xs-12 text-center">
        <%if(today==Days) {%>
  <a href="Salary" class="btn big-btn no-border red-background unstyle-anchor" style="padding: 13px 50px;">Salary</a>
  <%}else{%>
  <a disabled=true href="Salary" class="btn big-btn no-border red-background unstyle-anchor" style="padding: 13px 50px;">Salary</a>
  
  <%} %>
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
          <h3 class="heading-s1">Assign Holidays</h3>
          
        </div>
        <div class="col-xs-12 text-center">
        
     <a  class="btn big-btn no-border red-background unstyle-anchor" style="padding: 13px 50px;" data-toggle="modal" data-target="#myModal">Assign Holiday</a>

            </div>
      </div>
    </div>
  </div>
</div>
  

 
 
  <div class="modal fade" id="myModal" role="dialog">
    
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Assign Holidays</h4>
        </div>
        <form action="AssignHoliday">
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
         <div class="modal-body">
           Date(YY-MM-DD):<input type="text" name="hdate" id="datepicker" />
        </div>
         <div class="modal-body">
           Details:<input type="text"  name="hdetails" id="hdetails" />
         </div>
         <div class="modal-body">
           <input type="submit" name="submit" id="submit"  value="Submit"/>
         </div>
        </form>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
</div>
 


</body>
</html>