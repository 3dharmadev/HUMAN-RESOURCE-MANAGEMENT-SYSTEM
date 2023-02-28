package com.HRmanagementsystem.web;

import java.io.IOException;
import java.sql.SQLException;

import com.HRmanagementsystem.dao.EmployeeDao;
import com.HRmanagementsystem.dao.EmployeeDaoImpl;
import com.HRmanagementsystem.exception.EmployeeException;
import com.HRmanagementsystem.model.Employee;
import com.HRmanagementsystem.model.LeaveDays;


import java.util.*;
import java.lang.*;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	
	private EmployeeDao dao;
	
	public  void init() throws ServletException {
		dao= new EmployeeDaoImpl();
	}
	
       
     
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action=request.getServletPath();
		   
		  try {
			switch (action) {
			
			case "/logoutemp":
				logout(request,response);
			break;
			case "/empdetails":
				getEmpDetails(request, response);
				break;
			case "/leaverequestlist":
				leaveRequests(request, response);
			default:
            	   break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action=request.getServletPath();
		 
		  try {
			switch (action) {
			case "/signupe":
				signupEmployee(request, response);
				break;
			case "/employeelogin":
			    	 login(request, response);
						break;
			case "/leave":
					applyLeave(request, response);	
					break;
			case "/pcstatus":
				 updateProjectCompletionStatus(request, response);
				 break;
					default:
						break;
		 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
   
	private void applyLeave(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
		
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("empusername");

		
		String leaveFrom=request.getParameter("leaveFrom");
		  String leaveTo=request.getParameter("leaveTo");
		  String reason=request.getParameter("reason");
		  
		 
		  LeaveDays days=new LeaveDays();
		  days.setUserName(username); days.setLeaveFrom(leaveFrom);
		  days.setLeaveTo(leaveTo);  days.setReason(reason);
		 // System.out.println(days);
		      String message="";
			try {
				message = dao.requestForLeave(days);
			} catch (EmployeeException e) {
				message=e.getMessage();
				e.printStackTrace();
			}
		  
		  
		 
		 if(message.equals("successfully applied... wait for review")) {
			
			 response.sendRedirect("message.jsp" +URLEncoder.encode(message,"UTF-8"));
		 }
			
		 else {
			 response.sendRedirect("error.jsp" +URLEncoder.encode(message,"UTF-8"));
		}
		  
	}
	
private void updateProjectCompletionStatus(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
		
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("empusername");

		
		String status=request.getParameter("status");
		 
		 
		      String message="";
			try {
				message = dao.updateProjectCompletionStatus(username, status);
			} catch (EmployeeException e) {
				message=e.getMessage();
				e.printStackTrace();
			}
		  
		  
		 
		 if(message.equals("status updated successfully..")) {
			
			 response.sendRedirect("message.jsp" +URLEncoder.encode(message,"UTF-8"));
		 }
			
		 else {
			 response.sendRedirect("error.jsp" +URLEncoder.encode(message,"UTF-8"));
		}
		  
	}
	

	
	
	private void signupEmployee(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
		  String userNameString=request.getParameter("username");
		  String name=request.getParameter("name");
		  String passwordString=request.getParameter("password");
		  String date=request.getParameter("date");
		  //System.out.println(userNameString+" "+name+" "+passwordString+" "+date);
		 		  String str="WRONG INPUT TRY AGAIN";
		  Employee employee=new Employee();
		  employee.setEmail(userNameString.trim()); employee.setPassword(passwordString.trim());
		 
		  employee.setName(name);  employee.setDateOfBirth(date);
		  
		  
		
		  if(userNameString.contains("@gmail.com")) {
			  str= dao.signupEmployee(employee);
		  }
		 
		 if(str.equals("sign up successful wait for verification")) {
			
			 response.sendRedirect("message.jsp" +URLEncoder.encode(str,"UTF-8"));
		 }
			
		 else {
			 response.sendRedirect("error.jsp" +URLEncoder.encode(str,"UTF-8"));
		}
		  
	}
	
	private void login(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
		  String userNameString=request.getParameter("username");
		  String passwordString=request.getParameter("password");
		  String messasgeString = "";
		  // System.out.println(userNameString);
		try {
				messasgeString= dao.empLogin(userNameString.trim(), passwordString.trim());
		} catch (EmployeeException e) {
			messasgeString=e.getMessage();
			e.printStackTrace();
		}
		 
		 if(messasgeString.equals("LOGIN SUCCESSFUL!")) {

		       HttpSession session=request.getSession();
		       session.setAttribute("empusername",userNameString.trim());
			   response.sendRedirect("employeenavbar.jsp");
		 }
			
		 else {
			 response.sendRedirect("error.jsp" +URLEncoder.encode(messasgeString,"UTF-8"));
		}
	}	
	
private void leaveRequests(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	    
	HttpSession session=request.getSession();
	String username=(String) session.getAttribute("empusername");
	
          java.util.List<LeaveDays> sList=new ArrayList<>();
        
		try {
			//System.out.println(username);
			sList = dao.employeeRequestedLeaves(username);
			 // System.out.println(sList);
			request.setAttribute("listleaves", sList);   	
		   	RequestDispatcher dispatcher=request.getRequestDispatcher("employeeLeaveReqList.jsp");  	
		   	dispatcher.forward(request, response);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            
   	
	 
}
	
	private void logout(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException{
		HttpSession session=request.getSession();
		session.removeAttribute("empusername");
		session.invalidate();
		response.sendRedirect("loginemployee.jsp");
	}

	private void getEmpDetails(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
		HttpSession session=request.getSession();
		   try {
			Employee employee=dao.employeeDetails((String)session.getAttribute("empusername"));
		//	System.out.println(employee);
			request.setAttribute("employeedetails", employee);
			RequestDispatcher dispatcher=request.getRequestDispatcher("employeeaccount.jsp");
			dispatcher.forward(request, response);
			// System.out.println(employee);
		} catch (EmployeeException | ServletException e) {
		     
			e.printStackTrace();
		}
	}
	
 
}


