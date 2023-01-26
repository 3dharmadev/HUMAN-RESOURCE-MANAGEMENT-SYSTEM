<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ include file="employeenavbar.jsp" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>Leave Request List</title>
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
			<h3 class="text-center">Leave Request List By <%=session.getAttribute("empusername") %></h3>
			<hr>
			<div class="container text-left">


			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
					<th style="color: blue;">Leave ID</th>
						<th style="color: blue;">Email</th>
						<th style="color: blue">Leave Start</th>
						<th style="background-color: #06ffe5;">Leave End</th>
						<th style="background-color: #ffcf03;">Approval Status</th>
						<th style="background-color: #008cff;width: 18%;" >Leave Reason</th>	
						 
					</tr>
				</thead>
				<tbody>


    <c:forEach var="list" items="${listleaves}">

           <tr>
                     <td>  <c:out value="${list.ID}"/></td>
					 <td>  <c:out value="${list.userName}"/></td>
							<td>   <c:out value="${list.leaveFrom}"/></td>
							<td>  <c:out value="${list.leaveTo}"/></td>
			                <td>  <c:out value="${
			               ( list.approved == 1) ? 'APPROVED': ( list.approved == 0) ? 'DENIED':'WAIT FOR APPROVAL'
			                }"/></td>
			                  <td> <c:out value="${list.reason}"/></td>
						</tr>
    </c:forEach>


    </tbody>

			</table>
		</div>
	</div>
</body>