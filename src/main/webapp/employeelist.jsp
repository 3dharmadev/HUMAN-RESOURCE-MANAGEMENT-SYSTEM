<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style type="text/css">
       #nav{
       background:  #160046;

       }
       #nav>.navbar-brand{
       background: white;
     
       }
      
  

	</style>
</head>
<body>




	<div class="row">
		
		<div class="container">
			<h3 class="text-center">Employee List</h3>
			<hr>
			<div class="container text-left">


			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="background-color: antiquewhite">Email</th>
						<th style="color: blue;width: 19%;">Name</th>
						<th style="color: blue">Password</th>
						<th style="background-color: #06ffe5;width: 22%;">Date Of Birth<br> YY-MM-DD</th>
						<th style="background-color: #24ff00;width: 20%;">Department Id</th>
						<th style="background-color: #ffcf03;width: 20%;">A/C Status</th>
						<th style="background-color: #008cff;width: 20%;" >Activate/Deactivate Account</th>	
						<th style="background-color: #008cff;width: 50%;" >Update/Add Employee Department</th>
					</tr>
				</thead>
				<tbody>


    <c:forEach var="emp" items="${emp_list}">

           <tr>
					 <td>  <c:out value="${emp.email}"/></td>
							<td>   <c:out value="${emp.name}"/></td>
							<td>  <c:out value="${emp.password}"/></td>
			                <td> <c:out value="${emp.dateOfBirth}"/></td>
			                  <td> <c:out value="${emp.deptId == 0 ? 'NOT ADDED YET': emp.deptId}"/></td>
			                     <td > <c:out value="${ emp.accountActivate == true ? 'ACTIVATED': 'NOT ACTIVATED'}"/></td>
							
						 	<td> <a href="verifyEmployee.jsp?username=${emp.email}">ENABLE/DISABLE</a></td>
						 		<td> <a href="addOrUodateEmployeeDepartment.jsp?username=${emp.email}">ADD/UPDATE</a></td>
						 	
						</tr>
    </c:forEach>


    </tbody>

			</table>
		</div>
	</div>
</body>
</html>
 