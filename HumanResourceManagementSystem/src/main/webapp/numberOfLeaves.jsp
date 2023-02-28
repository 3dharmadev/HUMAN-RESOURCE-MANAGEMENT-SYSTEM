<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	  <%@ include file="adminNavbar.jsp" %>
<html>
<head>
<title>Leave Report List</title>
 
	<style type="text/css">
       #nav{
       background:  #160046;

       }
       #nav>.navbar-brand{
       background: white;
     
       }
        #leave {
		  font-family: Arial, Helvetica, sans-serif;
		  border-collapse: collapse;
		  width: 100%;
		}
		
		#leave td, #customers th {
		  border: 1px solid #ddd;
		  padding: 8px;
		}
		
		#leave tr:nth-child(even){background-color: #f2f2f2;}
		
		#leave tr:hover {background-color: #ddd;}
		
		#leave th {
		  padding-top: 12px;
		  padding-bottom: 12px;
		  text-align: left;
		  
		}
      #top{
      text-align: center;
      }
  

	</style>
</head>
<body>




	<div class="row">
		
		<div class="container">
			<h3 id="top">Employee Leave Reports</h3>
			<hr>
			<div class="container text-left">


			</div>
			<br>
			<table id="leave" class="table table-bordered">
				<thead>
					<tr>
					<th style="background-color: #f5d997 ;">Leave ID</th>
						<th style="background-color: yellow;">Email</th>
						<th style="background-color: silver;">Leave Start</th>
						<th style="background-color: #06ffe5;">Leave End</th>
						<th style="background-color: #ffcf03;width: 18%;">Approval Status</th>
						<th style="background-color: #008cff;width: 17%;" >Leave Reason</th>	
						<th style="background-color: #008cff;width: 21%;" >Grant/Deny Leave Request</th>
						<th style="background-color: red;color:white;" >DELETE REPORT</th>
					</tr>
				</thead>
				<tbody>


    <c:forEach var="l" items="${numofleaves}">

           <tr>
                     <td>  <c:out value="${l.ID}"/></td>
					 <td>  <c:out value="${l.userName}"/></td>
							<td>   <c:out value="${l.leaveFrom}"/></td>
							<td>  <c:out value="${l.leaveTo}"/></td>
			                <td>  <c:out value="${
			               ( l.approved == 1) ? 'APPROVED': ( l.approved == 0) ? 'DENIED':'NOT APRROVED YET'
			                }"/></td>
			                  <td> <c:out value="${l.reason}"/></td>
					<td> <a href="leaveApplicationReview.jsp?id=${l.ID}">Grant/Deny</a></td>
						<td> <a href="deleteleave?leaveid=<c:out value='${l.ID}' />">DELETE</a></td>
			
						 	
						</tr>
    </c:forEach>


    </tbody>

			</table>
		</div>
	</div>
</body>