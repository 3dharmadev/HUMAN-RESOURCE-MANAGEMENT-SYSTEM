
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
		 <meta charset="ISO-8859-1">
		 		 <%@ include file="adminNavbar.jsp" %>
		 

<html>
<head>
<title>Update Leave Status</title>
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
  
  
   
     
</style>
<body>

<h1  style="text-align: center;">Approve/Deny Employee Leave Application</h1>

<form id="f2" action="reviewleaveapplication" method="post">
    <input type="hidden" value=<%=request.getParameter("id") %> name="id" placeholder="Enter  Leave Application Id" maxlength="11">
 <select name="approval" >
   <option  style="color:dimgrey">update Leave Status</option>
  <option value="1" style=" font-weight: 1000; font-size: 30px;">Approve</option>
  <option value="0"style=" font-weight: 1000; font-size: 30px; ">Deny</option>
</select>
   
     <input    type="submit" style="background-color: rgb(13, 0, 96); color: azure;" value="Update">
     

</form>
         </body>
</html>
