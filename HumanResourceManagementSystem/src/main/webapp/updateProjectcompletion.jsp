<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
   

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="employeenavbar.jsp" %>
<html>
<head>
<title>update project status</title>
<meta charset="ISO-8859-1">
<style>
    #sim{
         display: grid;
         justify-content: center;
         row-gap: 20px;
         margin-top: 100px;
}
  #sim>input{
    height: 27px;
    width: 400px;
  }
  
  body{
    background-color:rgb(6, 186, 251) ;
  }
  #head{
  margin-top:50px;
  text-align: center;
  color:white;
  
  }

     
</style>
</head>
  <h1 id="head"> update project completion status</h1>
    <form id="sim" action="pcstatus" method="post">  

  Enter message:   <input style="width:400px;height:50px;" type="text" name="status" placeholder="Type project completion status" >  
  
   <input type="submit" style="background-color: blue; color:white;" value="Apply">
     </form>
     
</html>