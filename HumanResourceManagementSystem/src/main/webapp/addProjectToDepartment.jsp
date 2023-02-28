
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
		 <meta charset="ISO-8859-1">
		  <%@ include file="adminNavbar.jsp" %>

<html>
<head>
<title>Human Resource Management Application</title>
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
    width: 500px;
    border-radius: 20px;
  }
    #f2>option{
   margin: 0px 50px 0px 50px;
  }
  input::placeholder {
    font-size: 22px;
   
    text-align: center;
  }
  body{
    background-color:#e747e1 ;
  }
   
     
</style>
<body>

<form id="f2" action="addProject" method="post">
   Enter Project name with small description:   <input  type="text" name="projectName" placeholder="Enter Project Name With Small Description" maxlength="35">
   <input type="hidden" value="<%=request.getParameter("id") %>" name="deptId" placeholder="Enter Department Id" maxlength="3">
   
     <input    type="submit" style="background-color: rgb(13, 0, 96); color: azure;" value="Create Department">
     

</form>
         </body>
</html>




