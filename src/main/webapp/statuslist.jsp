<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <%@ include file="adminNavbar.jsp" %>
<html>
<head>
<title>STATUS LIST</title>
 
	<style type="text/css">
		 #statuss {
		  font-family: Arial, Helvetica, sans-serif;
		  border-collapse: collapse;
		  width: 100%;
		}
		
		#statuss td, #statuss th {
		  border: 1px solid #ddd;
		  padding: 8px;
		}
		
		#statuss tr:nth-child(even){background-color: #f2f2f2;}
		
		#statuss tr:hover {background-color: #ddd;}
		
		#statuss th {
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
        #delete:hover{
	  background-color: red;
	  color:white;
  }
  #delete>a:hover{
	  color: #f14646;
  }
  

	</style>
</head>
<body>




	<div class="row">
		
		<div class="container">
			<h3 class="text-center">Project Updation Status</h3>
			<hr>
			<div class="container text-left">


			</div>
			<br>
			<table  id="statuss" class="table table-bordered">
				<thead>
	
					<tr>
					<th style="color: blue;">Status ID</th>
						<th style="color: blue;">Employee Name</th>
						<th style="color: blue">STATUS DETAILS</th>
					 
						<th style="background-color: red;" >DELETE STATUS</th>
					
					</tr>
				</thead>
				<tbody>

    <c:forEach var="st" items="${projectstatuslist}">

           <tr>
                     <td>  <c:out value="${st.id}"/></td>
					 <td>  <c:out value="${st.username}"/></td>
							<td>   <c:out value="${st.status}"/></td>
							<td id="delete"> <a href="deletestatus?sid=<c:out value='${st.id}' />">DELETE</a></td>
			
						 	
						</tr>
    </c:forEach>


    </tbody>

			</table>
		</div>
	</div>
</body>