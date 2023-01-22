package comHRmanagementsystem.web;

import java.awt.List;
import java.sql.SQLException;

import com.HRmanagementsystem.dao.AdminDao;
import com.HRmanagementsystem.dao.AdminDaoImpl;
import com.HRmanagementsystem.exception.DepartmentException;
import com.HRmanagementsystem.exception.EmployeeException;
import com.HRmanagementsystem.model.*;
import com.mysql.cj.Session;



import java.util.*;
import java.lang.*;
import java.net.URLEncoder;
import java.net.http.WebSocketHandshakeException;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet({"/newDepartment","/addProject","/addManager","/addUpdateEmployeedept","/reviewleaveapplication"
	,"/activateDeactivateAccount","/emplist","/leaveReq"})
public class AdminServlet extends HttpServlet {
	
	private AdminDao dao;
	
	public  void init() throws ServletException {
	 dao= new AdminDaoImpl();
	}
	
       
     
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action=request.getServletPath();
		  
		 
		  try {
			switch (action) {
			case "/emplist":
				getEmployees(request, response);
				break;
			case "/leaveReq":
				leaveReports(request, response);
				break;
				
			 
				
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
		 
		 
		  try {
			switch (action) {
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
	      
	      response.sendRedirect("message.jsp?message="+URLEncoder.encode(message, "UTF-8"));
}
	
	
	private void addOrUpdateDepartmentProject(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException, UnsupportedEncodingException, IOException{
		
		String projectNameString=request.getParameter("projectName").trim();
		int deptId=Integer.parseInt(request.getParameter("deptId").trim());
		
		try {
		String message=dao.addProjectToDepartment(projectNameString, deptId);
			response.sendRedirect("message.jsp?message="+URLEncoder.encode(message,"UTF-8"));
		} catch (DepartmentException | IOException e) {
			 response.sendRedirect("error.jsp?message="+URLEncoder.encode(e.getMessage(),"UTF-8"));
			e.printStackTrace();
		}
	}
	
private void addOrUpdateDepartmentManager(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException, UnsupportedEncodingException, IOException{
		
		String projectNameString=request.getParameter("projectManager");
		int deptId=Integer.parseInt(request.getParameter("deptId").trim());
		
		try {
		String message=dao.assignManagerToDepartment(projectNameString.trim(), deptId);
			response.sendRedirect("message.jsp?message="+URLEncoder.encode(message,"UTF-8"));
		} catch (IOException | EmployeeException e) {
			 response.sendRedirect("error.jsp?message="+URLEncoder.encode(e.getMessage(),"UTF-8"));
			e.printStackTrace();
		}
	}


private void addOrUpdateEmployeeDepartment(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException, UnsupportedEncodingException, IOException{
	
	String projectNameString=request.getParameter("email");
	int deptId=Integer.parseInt(request.getParameter("deptId").trim());
	
	
	try {
	String message=dao.assignEmployeeToDepartment(projectNameString.trim(), deptId);
		response.sendRedirect("message.jsp?message="+URLEncoder.encode(message,"UTF-8"));
	} catch (IOException | EmployeeException | DepartmentException e) {
		 response.sendRedirect("error.jsp?message="+URLEncoder.encode(e.getMessage(),"UTF-8"));
		e.printStackTrace();
	}
}

private void approveEmployeeLeave(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException, UnsupportedEncodingException, IOException{
	
	int Id=Integer.parseInt(request.getParameter("id").trim());
	int approval=Integer.parseInt(request.getParameter("approval").trim());
	
	try {
	String message=dao.updateEmployeeLeaveStatus(approval, Id);
		response.sendRedirect("message.jsp?message="+URLEncoder.encode(message,"UTF-8"));
	} catch ( IllegalStateException | IOException  | DepartmentException e) {
		
		 response.sendRedirect("error.jsp?message="+URLEncoder.encode(e.getMessage(),"UTF-8"));
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
    
	              java.util.List<LeaveDays>  leaves  = dao.leaveReports();
	            
	   	request.setAttribute("leaves", leaves);
	   	
	   	RequestDispatcher dispatcher=request.getRequestDispatcher("numberOfLeaves.jsp");
	   	System.out.println(dispatcher);
	   	dispatcher.forward(request, response);
		 
		                
	}

private void activateOrDeactivateEmployeeAccount(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException, UnsupportedEncodingException, IOException{
	
	
	String username=request.getParameter("username");
	int Id=Integer.parseInt(request.getParameter("ActDeactAcc").trim());
	System.out.println(username+" "+Id);
	
	try {
	String message=dao.verifyEmpAccount(username.trim(), Id);
		response.sendRedirect("message.jsp?message="+URLEncoder.encode(message,"UTF-8"));
	} catch ( IllegalStateException | IOException   | EmployeeException e) {
		
		 response.sendRedirect("error.jsp?message="+URLEncoder.encode(e.getMessage(),"UTF-8"));
		e.printStackTrace();
	}
}

}
