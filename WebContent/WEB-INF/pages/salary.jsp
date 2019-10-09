<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.lang.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.rpm.model.*" %>
<%@ page import="java.text.DateFormatSymbols" %>
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
<center><h1>Salary</h1></center>

<table id="t01" style="width:100%">
  <tr>
    <th>Month</th>
    <th>Year</th> 
    <th>Salary</th>
   
  </tr>

<% int i=0; 
ArrayList<Salary> a=(ArrayList<Salary>)request.getAttribute("result");

%>


<%
    if(a!=null)
	{while(i<a.size())
{ Salary u=a.get(i);
String s=new DateFormatSymbols().getMonths()[u.getMonth()-1];%>
<tr>
 <td><%=s%></td>
 <td><%=u.getYear()%></td>
    <td><%=u.getSalary()%></td> 
    
</tr>

<% i++;}}%>

</table>

 
</body>
</html>