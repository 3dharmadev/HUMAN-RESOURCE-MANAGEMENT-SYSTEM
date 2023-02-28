<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>EMPLOYEE SIGNUP</title>
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
<title>login</title>
</head>
  <h1> EMPLOYEE SIGNUP</h1>
    <form action="signupe" method="post">
   
   Enter Email: <input type="text" name="username" placeholder="Enter your Email" >  
   Enter Name: <input type="text" name="name" placeholder="Enter your FullName" >  
   Enter password: <input type="password" name="password" placeholder="Must be in Number"> 
   Enter Date Of Birth: <input type="date" name="date"   placeholder="dd-mm-yyyy" value=""  min="1945-01-01" max="2030-12-31">
   
   <input type="submit" style="background-color: blue; color:white;" value="SIGN UP">
     </form>
     <h1><a href="loginemployee.jsp">log in</a></h1>
     <h1><a href="home.jsp">Home</a></h1>
</html>