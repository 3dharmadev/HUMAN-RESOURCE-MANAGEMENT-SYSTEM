<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="employeenavbar.jsp" %>
<html>
<head>
<title>leave request</title>
<meta charset="ISO-8859-1">
<style>
    #fom{
         display: grid;
         justify-content: center;
         row-gap: 20px;
         margin-top: 100px;
}
   #fom>input{
    height: 27px;
    width: 400px;
  }
   
  body{
    background-color:rgb(6, 186, 251) ;
  }
  #leaveapp{
  margin-top:50px;
  text-align: center;
  color:white;
  
  }

     
</style>
<title>Application</title>
</head>
  <h1 id="leaveapp"> Leave Application</h1>
    <form id="fom" action="leave" method="post">  
  
   Enter Leave Start Date:  <input type="date" name="leaveFrom"   placeholder="dd-mm-yyyy" value=""  min="2000-01-01" max="2030-12-31">
   
  Enter Leave End Date:  <input type="date" name="leaveTo"   placeholder="dd-mm-yyyy" value=""  min="2000-01-01" max="2030-12-31">
   
  Enter Reason:   <input style="width:400px;height:50px;" type="text" name="reason" placeholder="Type the reason why you want leave" >  
  
   <input type="submit" style="background-color: blue; color:white;" value="Apply">
     </form>
     
</html>