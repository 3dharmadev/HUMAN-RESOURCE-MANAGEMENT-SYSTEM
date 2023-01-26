
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
		 <meta charset="ISO-8859-1">
		 
		 <%@ include file="adminNavbar.jsp" %>
		 

<html>
<head>
<title>Create A Department</title>
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
    width: 400px;
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
   h1{
   color:white;
   text-align: center;
   }
     
</style>
<body>
     <h1>Add New Department</h1>
<form id="f2" action="newDepartment" method="post">
    <input type="text" name="name" placeholder="Enter New Department Name">
   
     <input    type="submit" style="background-color: rgb(13, 0, 96); color: azure;" value="Create Department">
     

</form>
         </body>
</html>







