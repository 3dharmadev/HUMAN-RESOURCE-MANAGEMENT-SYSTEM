<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>request for leaves</title>
<meta charset="ISO-8859-1">
<style>
    form{
         display: grid;
         justify-content: center;
         row-gap: 20px;
         margin-top: 100px;
}
  form>input{
    height: 27px;
    width: 400px;
  }
  input::placeholder {
    font-size: 22px;
    text-align: center;
  }
  body{
    background-color:rgb(6, 186, 251) ;
  }
  h1{
  margin-top:50px;
  text-align: center;
  color:white;
  
  }

     
</style>
<title>Application</title>
</head>
  <h1> Leave Application</h1>
    <form action="leave" method="post">  
  
   Enter Leave Start Date:  <input type="date" name="leaveFrom"   placeholder="dd-mm-yyyy" value=""  min="2000-01-01" max="2030-12-31">
   
  Enter Leave End Date:  <input type="date" name="leaveTo"   placeholder="dd-mm-yyyy" value=""  min="2000-01-01" max="2030-12-31">
   
  Enter Reason:   <input style="width:400px;height:50px;" type="text" name="reason" placeholder="Type the reason why you want leave" >  
  
   <input type="submit" style="background-color: blue; color:white;" value="Apply">
     </form>
     
</html>