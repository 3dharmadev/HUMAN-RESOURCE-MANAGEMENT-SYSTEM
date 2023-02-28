<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <%@ include file="adminNavbar.jsp" %>
<html>
<head>
<title>Employee List</title>
 
	<style type="text/css">
			 #employee {
		  font-family: Arial, Helvetica, sans-serif;
		  border-collapse: collapse;
		  width: 100%;
		}
		
		#employee td, #employee th {
		  border: 1px solid #ddd;
		  padding: 8px;
		}
		
		#employee tr:nth-child(even){background-color: #f2f2f2;}
		
		#employee tr:hover {background-color: #ddd;}
		
		#employee th {
		  padding-top: 12px;
		  padding-bottom: 12px;
		  text-align: left;
		  
		}

       #nav{
       background:  #160046;

       }
       #nav>.navbar-brand{
       background: white;
     
       }
       #delete>a{
	  color: red;
  }
  #delete:hover{
	  background-color: white;
  }
  #delete>a:hover{
	  color: #f14646;
  }
  

	</style>
</head>
<body>




	<div class="row">
		
		<div class="container">
			<h2 style="text-align: center;">Employee List</h2>
			<hr>
			<div class="container text-left">


			</div>
			<br>
			<table  id="employee" class="table table-bordered">
				<thead>
					<tr>
						<th style="background-color: antiquewhite">Email</th>
						<th style="background-color: yellow;width: 19%;">Name</th>
						<th style="background-color: silver">Password</th>
						<th style="background-color: #06ffe5;width: 17%;">Date Of Birth<br> YY-MM-DD</th>
						<th style="background-color: #24ff00;width: 15%;">Department Id</th>
						<th style="background-color: #ffcf03;">A/C Status</th>
						<th style="background-color: Tomato;width: 20%;" >Update Activation Account</th>	
						<th style="background-color: #008cff;width: 30%;" >Update/Add Employee Department</th>
						<th style="background-color: red;" >DELETE EMPLOYEE</th>
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
						 		<td id="delete"> <a href="deleteemp?username=<c:out value='${emp.email}' />">DELETE</a></td>
			
						</tr>
    </c:forEach>


    </tbody>

			</table>
		</div>
	</div>
</body>
</html>
 