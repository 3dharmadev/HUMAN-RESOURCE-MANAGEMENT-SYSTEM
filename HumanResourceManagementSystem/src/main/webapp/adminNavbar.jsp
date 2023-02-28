 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 

<html>
<head>
<title>Admin Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style type="text/css">
       #nav{
       background: #160046;
       }
       h1{
       color: #e7e7e7;
       }
       
		body {
		  background-image: url('https://png.pngtree.com/thumb_back/fh260/background/20201101/pngtree-3d-rendering-for-display-product-banner-on-website-image_453005.jpg');
	 	  background-repeat: no-repeat;
		  background-attachment: fixed;
		  background-size: cover;
		}
       
     #form1>input{
        background-color: rgb(239, 0, 0);
        color: rgb(255, 255, 255);
         
        font-size: 20px;
     }
     h1{
     text-align: center;
     }
	</style>
</head>
<body>

     <%

   response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
   
   response.setHeader("Pragma", "no-cache"); 
   
   response.setHeader("Expires", "0"); 

   if(session.getAttribute("username")==null) response.sendRedirect("loginadmin.jsp");
   
%>
	<header>
		<nav id="nav" class="navbar navbar-expand-md navbar-dark">
			<div>
				<a class="navbar-brand"> <h1 id="h1" > Human Resource Management System</h1> </a>

			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/emplist"	class="nav-link">Employee List</a></li>
				<li> <a href="<%=request.getContextPath()%>/leavereq" class="nav-link">Leave Reports</a> </li>
				<li> <a href="<%=request.getContextPath()%>/deptlist" class="nav-link">Department List</a> </li>
				<li> <a href="<%=request.getContextPath()%>/statuslist" class="nav-link">Project Status List</a> </li>
				
				<li> <a href="createANewDepartment.jsp" class="nav-link">Add Department</a> </li>
			  <form id="form1" action="logout"><input type="submit"  class="nav-link" value="logout"></form>
			</ul>
		</nav>
		 
	</header>
	
	<br>
</body>
</html>
</html>