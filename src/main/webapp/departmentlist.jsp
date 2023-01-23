<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>Leave Reports</title>
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
			<h3 class="text-center">Employee Leave Reports</h3>
			<hr>
			<div class="container text-left">


			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
					<th style="color: blue;">Department ID</th>
						<th style="color: blue;">Department Name</th>
						<th style="color: blue">Current Project</th>
						<th style="background-color: #06ffe5;">Manager UserName</th>
						<th style="background-color: #ffcf03;">Add New Project</th>
						<th style="background-color: #008cff;width: 18%;" >Add New Manager</th>	
					
					</tr>
				</thead>
				<tbody>

    <c:forEach var="dept" items="${deptList}">

           <tr>
                     <td>  <c:out value="${dept.deptId}"/></td>
					 <td>  <c:out value="${dept.departmentName}"/></td>
							<td>   <c:out value="${dept.assignProject}"/></td>
			                <td>  <c:out value="${dept.deptManager}"/></td>
			                <td> <a href="addProjectToDepartment.jsp?id=${dept.deptId}">ADD</a></td>
					<td> <a href="addManagerToDepartment.jsp?did=${dept.deptId}">ADD</a></td>
							
						 	
						</tr>
    </c:forEach>


    </tbody>

			</table>
		</div>
	</div>
</body>