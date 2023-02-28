package com.HRmanagementsystem.web;

 
import java.sql.SQLException;

import com.HRmanagementsystem.dao.AdminDao;
import com.HRmanagementsystem.dao.AdminDaoImpl;
import com.HRmanagementsystem.exception.DepartmentException;
import com.HRmanagementsystem.exception.EmployeeException;
import com.HRmanagementsystem.model.*;
 
import java.net.URLEncoder;
 
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet({"/newDepartment","/addProject","/addManager","/addUpdateEmployeedept","/reviewleaveapplication"
	,"/activateDeactivateAccount","/emplist","/deleteemp","/leavereq","/deptlist",
	"/adminlogin","/logout","/deletedept","/deleteleave","/statuslist","/deletestatus"})
 
public class AdminServlet extends HttpServlet {
	
	private AdminDao dao;
	
	public  void init() throws ServletException {
	 dao= new AdminDaoImpl();
	}
	
       
     
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action=request.getServletPath();
		 response.setContentType("text/html");   
		 
		  try {
			switch (action) {
			case "/emplist":
				getEmployees(request, response);
				break;
			case "/leavereq":
				leaveReports(request, response);
				break;
			case "/deleteemp":
				deleteEmployee(request, response);
				break;
			case "/deletedept":
				deleteDepartment(request, response);
				break;
			case "/deleteleave":
				deleteLeaveRequest(request, response);
				break;
			case "/deptlist":
				departmentList(request, response);
				
			 break;
			 
			case "/deletestatus":
				deletestatus(request, response);
				break;
				
			case "/logout":
				logout(request, response);
			case "/statuslist":
				statusList(request, response);
				
			default:
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action=request.getServletPath();
		 
		 response.setContentType("text/html");   
		  try {
			switch (action) {
			
			case "/adminlogin":
				adminlogin(request, response);
				break;
			case "/newDepartment":
				 createDepartment(request, response);
			  break;
			case "/addProject":
				addOrUpdateDepartmentProject(request, response);
				break;
			case "/addManager":
				addOrUpdateDepartmentManager(request, response);
				break;
				
			case "/addUpdateEmployeedept":
				addOrUpdateEmployeeDepartment(request, response);
				break;
				case "/reviewleaveapplication":
					approveEmployeeLeave(request, response);
					break;
					
				case "/activateDeactivateAccount":
					activateOrDeactivateEmployeeAccount(request, response);
					break;
				
			default:
					break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void createDepartment(HttpServletRequest request, HttpServletResponse response) throws SQLException , ServletException, UnsupportedEncodingException, IOException {
	     String departmentName=request.getParameter("name");
	         Department department=new Department();
	         department.setDepartmentName(departmentName);
	      String message= dao.addNewDepartment(department);
	      
	      response.sendRedirect("message.jsp" +URLEncoder.encode(message, "UTF-8"));
}
	
	
	private void addOrUpdateDepartmentProject(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException, UnsupportedEncodingException, IOException{
		
		String projectNameString=request.getParameter("projectName").trim();
		int deptId=Integer.parseInt(request.getParameter("deptId").trim());
		
		try {
		String message=dao.addProjectToDepartment(projectNameString, deptId);
			response.sendRedirect("message.jsp" +URLEncoder.encode(message,"UTF-8"));
		} catch (DepartmentException | IOException e) {
			 response.sendRedirect("error.jsp" +URLEncoder.encode(e.getMessage(),"UTF-8"));
			e.printStackTrace();
		}
	}
	
private void addOrUpdateDepartmentManager(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException, UnsupportedEncodingException, IOException{
		
		String projectNameString=request.getParameter("projectManager");
		int deptId=Integer.parseInt(request.getParameter("deptId").trim());
		
		try {
		String message=dao.assignManagerToDepartment(projectNameString.trim(), deptId);
			response.sendRedirect("message.jsp" +URLEncoder.encode(message,"UTF-8"));
		} catch (IOException | EmployeeException e) {
			 response.sendRedirect("error.jsp" +URLEncoder.encode(e.getMessage(),"UTF-8"));
			e.printStackTrace();
		}
	}


private void addOrUpdateEmployeeDepartment(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException, UnsupportedEncodingException, IOException{
	
	String projectNameString=request.getParameter("email");
	int deptId=Integer.parseInt(request.getParameter("deptId").trim());
	
	
	try {
	String message=dao.assignEmployeeToDepartment(projectNameString.trim(), deptId);
		response.sendRedirect("message.jsp" +URLEncoder.encode(message,"UTF-8"));
	} catch (IOException | EmployeeException | DepartmentException e) {
		 response.sendRedirect("error.jsp" +URLEncoder.encode(e.getMessage(),"UTF-8"));
		e.printStackTrace();
	}
}

private void approveEmployeeLeave(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException, UnsupportedEncodingException, IOException{
	
	int Id=Integer.parseInt(request.getParameter("id").trim());
	String approval=request.getParameter("approval");
	 // System.out.println(approval);
	try {
	String message=dao.updateEmployeeLeaveStatus(approval, Id);
	//System.out.println(message);
		response.sendRedirect("message.jsp" +URLEncoder.encode(message,"UTF-8"));
	} catch ( IllegalStateException | IOException  | DepartmentException e) {
		 response.sendRedirect("error.jsp" +URLEncoder.encode(e.getMessage(),"UTF-8"));
		e.printStackTrace();
	}
}
	
	
private void getEmployees(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	               
	
	 
 java.util.List<Employee> employees=dao.employeeList();
 
   	request.setAttribute("emp_list", employees);
   	RequestDispatcher dispatcher=request.getRequestDispatcher("employeelist.jsp");
   	dispatcher.forward(request, response);
	 
	                
}

private void leaveReports(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    

            java.util.List<LeaveDays> leaves=dao.leaveReports();
	            
	   	request.setAttribute("numofleaves", leaves);
	   	
	   	RequestDispatcher dispatcher=request.getRequestDispatcher("numberOfLeaves.jsp");
	   	
	   	dispatcher.forward(request, response);
		 
	}

private void activateOrDeactivateEmployeeAccount(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException, UnsupportedEncodingException, IOException{
	
	
	String username=request.getParameter("username");
	int Id=Integer.parseInt(request.getParameter("ActDeactAcc").trim());
	 System.out.println(username+" "+Id);
	if(Id==0) {
		HttpSession session2=request.getSession();
		session2.removeAttribute("empusername");
		//session2.invalidate();
	}
	
	try {
	String message=dao.verifyEmpAccount(username.trim(), Id);
		response.sendRedirect("message.jsp" +URLEncoder.encode(message,"UTF-8"));
	} catch ( IllegalStateException | IOException   | EmployeeException e) {
		
		 response.sendRedirect("error.jsp" +URLEncoder.encode(e.getMessage(),"UTF-8"));
		e.printStackTrace();
	}
}

private void departmentList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	
	        java.util.List<Department> deptList=dao.deptList();
	        request.setAttribute("deptList", deptList);
	        RequestDispatcher dispatcher=request.getRequestDispatcher("departmentlist.jsp");
	        
	       dispatcher.forward(request, response);
}
private void statusList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	java.util.List<Status> status=dao.statusList();
	 System.out.println(status);
	request.setAttribute("projectstatuslist", status);
	RequestDispatcher dispatcher=request.getRequestDispatcher("statuslist.jsp");
	dispatcher.forward(request, response);
}



private void deleteLeaveRequest(HttpServletRequest request,HttpServletResponse response) throws SQLException, UnsupportedEncodingException, IOException {
	
	  int leaveid=Integer.parseInt(request.getParameter("leaveid").trim());
	    System.out.println(leaveid);
	   String message=dao.deleteLeaveReport(leaveid);
	   response.sendRedirect("message.jsp" +URLEncoder.encode(message,"UTF-8"));
}

private void deleteEmployee(HttpServletRequest request,HttpServletResponse response)  {
	     String username= request.getParameter("username");
	      System.out.println(username);
	     try {
	    	 
			String message=dao.deleteEmployee(username);
			HttpSession session=request.getSession();
			
			session.removeAttribute("empusername");
			
			
			response.sendRedirect("message.jsp" +URLEncoder.encode(message,"UTF-8"));
		} catch (EmployeeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

private void deleteDepartment(HttpServletRequest request,HttpServletResponse response)  {
    String did= request.getParameter("did");
    System.out.println(did);
    try {
		String message=dao.deleteDepartment(Integer.parseInt(did.trim()));
		 response.sendRedirect("message.jsp" +URLEncoder.encode(message,"UTF-8"));
	} catch (  NumberFormatException | DepartmentException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


private void deletestatus(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException, IOException  {
    
	int id=Integer.parseInt(request.getParameter("sid").trim());
	 System.out.println(id);
	String message=dao.deleteOldStatus(id);
	
	 response.sendRedirect("message.jsp" +URLEncoder.encode(message,"UTF-8"));
	
}



private void adminlogin(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException {
	  String userNameString=request.getParameter("username");
	  String passwordString=request.getParameter("password");
	  String messasgeString = "";
	  System.out.println(userNameString);
		try {
			messasgeString = dao.loginAdmin(userNameString.trim(), Integer.parseInt(passwordString.trim()));
		} catch (NumberFormatException | EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	if( messasgeString.equals("LOGIN SUCCESSFUL!")) {
		
	    System.out.print(messasgeString);
	       HttpSession session=request.getSession();
	       session.setAttribute("username", userNameString);
	       session.setAttribute("password",passwordString);
		response.sendRedirect("adminNavbar.jsp");
	}
	else {
		response.sendRedirect("loginadmin.jsp");
	}
}

private void logout(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException{
	HttpSession session=request.getSession();
	session.removeAttribute("username");
	session.invalidate();
	response.sendRedirect("loginadmin.jsp");
}

}
