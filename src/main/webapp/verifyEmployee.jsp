
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
		 <meta charset="ISO-8859-1">
	  <%@ include file="adminNavbar.jsp" %>
<html>
<head>
<title>Update Employee Account</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<style>
     #f2{
         display: grid;
         justify-content: center;
         row-gap: 20px;
         margin-top: 100px;
}
  #f2>input{
    height: 27px;
    width: 550px;
    border-radius: 20px;
  }
    #f2>option{
   margin: 0px 50px 0px 50px;
  }
  
  body{
    background-color:#e747e1 ;
  }
  h3{
  color:white;
  text-align: center;
  margin-top: 50px;
  }
  
  
   
     
</style>
<body>

<h3>Activate/Deactivate Employee Account</h3>

<form id="f2" action="activateDeactivateAccount" method="post">
    <input type="hidden" value=<%=request.getParameter("username") %> name="username" placeholder="Enter  Employee username" maxlength="30">
 <select name="ActDeactAcc" >
   <option  style="color:dimgrey"> Activation Or Deactivate Account</option>
  <option value="1" style=" font-weight: 1000; font-size: 30px;">Activate</option>
  <option value="0"style=" font-weight: 1000; font-size: 30px; ">Deactivate</option>
</select>
   
     <input    type="submit" style="background-color: rgb(13, 0, 96); color: azure;" value="UPDATE">
     

</form>
         </body>
</html>
