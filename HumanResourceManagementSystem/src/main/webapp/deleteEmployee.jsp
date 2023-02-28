<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
    width: 550px;
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
  margin-top: 50px;
  }
  
  
   
     
</style>
<body>

<h1>Delete employee</h1>

<form id="f2" action="addUpdateEmployeedept" method="post">
    <input type="hidden" value=<%=request.getParameter("username") %> name="email" placeholder="Enter  Employee username" maxlength="30">
   Enter  Department Id: <input type="number" name="deptId" placeholder="Enter the Department Id" maxlength="3">
   
     <input    type="submit" style="background-color: rgb(13, 0, 96); color: azure;" value="Add OR Update Employee Department">
     

</form>
         </body>
</html>


