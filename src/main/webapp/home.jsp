<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
#div1{
 display: grid;
 justify-content: center;
 background-color: purple;
}
body{
background-color: rgb(0, 102, 255);
}
</style>
<body>

<header>
		<nav id="nav" class="navbar navbar-expand-md navbar-dark">
			<div>
				<a class="navbar-brand"> <h1 > HUMAN RESOURCE MANAGEMENT APPLICATION</h1> </a>

			</div>
			
			</nav>
			
			<div id="div1">
 <h1>Head of department login : <a href="loginadmin.jsp">admin login</a></h1>
 
  <h1>Engineer login :<a href="loginemployee.jsp">employee login</a></h1>
  
   <h1>Employee login :<a href="signup.jsp">signup employee</a></h1>
</div>
			</header>



</body>
</html>