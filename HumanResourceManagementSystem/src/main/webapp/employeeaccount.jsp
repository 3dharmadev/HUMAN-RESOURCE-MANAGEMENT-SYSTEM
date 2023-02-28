
<%@page import="com.HRmanagementsystem.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="employeenavbar.jsp" %>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
<title>Employee Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style type="text/css">
  h2{
   text-align: center;
    
   margin-top: 20px;
  }
  #h{
  text-align: center;
   margin-bottom: 50px;
  }
   
	</style>
</head>
<body>
  <h1 id="h">Your Account Details</h1>
  <h2 >==================================</h2>
 <%

Employee employee=(Employee) request.getAttribute("employeedetails");

 out.println("<h2>"+"Your Email :"+employee.getEmail()+"</h2>");
 out.println("<h2>"+"Your Name : "+employee.getName()+"</h2>");
  out.println("<h2>"+"Your Password :"+employee.getPassword()+"</h2>");
  out.println("<h2>"+"Your Date Of Birth :"+employee.getDateOfBirth()+"</h2>");
  if(employee.getDeptId()==0)
  out.println("<h2>"+"Your Department Id :"+"You didn't assigned to any department yet"+"</h2>");
  else 
	  out.println("<h2>"+"Your Department Id :"+employee.getDeptId()+"</h2>");
 %>
</body>
</html>