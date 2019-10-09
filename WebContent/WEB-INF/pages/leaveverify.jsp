<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.lang.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.rpm.model.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>table {
  width:100%;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
table#t01 tr:nth-child(even) {
  background-color: #eee;
}
table#t01 tr:nth-child(odd) {
 background-color: #fff;
}
table#t01 th {
  background-color: LightBlue;
  color: white;
}
</style>

<title>Grant Leave</title>
</head>
<body>
<center><h1>Verify Leave</h1></center>
<form action="leaveverifyfinally">
<table id="t01" style="width:100%">
  <tr>
    <th>UserID</th>
    <th>Name</th> 
    <th>Leave_Type</th>
    <th>Date_From</th>
    <th>Date_To</th>
    <th>Days</th>
    <th>Grant</th>
  </tr>

<% int i=0; 
ArrayList<Leave> a=(ArrayList<Leave>)request.getAttribute("result");

%>


<%
    if(a!=null)
	{while(i<a.size())
{ Leave u=a.get(i);%>
<tr>
 <td><%=u.getUserid()%></td>
 <td><%=u.getName()%></td>
    <td><%=u.getL_type()%></td> 
    <td><%=u.getDate_from()%></td>
    <td><%=u.getDate_to()%></td>
    <td><%=u.getDays()%></td>
    <td>
<input type="checkbox" name="l_id" value="<%=u.getL_id()%>"> <BR>
</td>
</tr>

<% i++;}}%>

</table>
<center><input type="submit"  name="submit" value="submit" align="middle"></center>

</form> 
</body>
</html>