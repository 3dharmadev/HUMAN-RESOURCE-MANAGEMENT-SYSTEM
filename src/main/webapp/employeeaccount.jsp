
<%@page import="com.HRmanagementsystem.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
<title>Employee Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style type="text/css">
  h1{
   text-align: center;
   margin-top: 20px;
  }
  h{
  text-align: center;
   margin-bottom: 50px;
  }
  body{
  background-color: teal;
  }
	</style>
</head>
<body>
  <h1 id="h">Your Account Details</h1>
  <h1 >==================================</h1>
 <%

Employee employee=(Employee) request.getAttribute("employeedetails");

 out.println("<h1>"+"Your Email :"+employee.getEmail()+"</h1>");
 out.println("<h1>"+"Your Name : "+employee.getName()+"</h1>");
  out.println("<h1>"+"Your Password :"+employee.getPassword()+"</h1>");
  out.println("<h1>"+"Your Date Of Birth :"+employee.getDateOfBirth()+"</h1>");
  out.println("<h1>"+"Your Department Id :"+employee.getDeptId()+"</h1>");
 %>
</body>
</html>