package comHRmanagementsystem.web;

import java.awt.List;
import java.io.IOException;
import java.sql.SQLException;

import com.HRmanagementsystem.dao.EmployeeDao;
import com.HRmanagementsystem.dao.EmployeeDaoImpl;
import com.HRmanagementsystem.model.*;
import com.mysql.cj.Session;

import java.util.*;
import java.lang.*;
import java.io.*;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet({})
public class EmployeeServlet extends HttpServlet {
	
	private EmployeeDao dao;
	
	public  void init() throws ServletException {
		dao= new EmployeeDaoImpl();
	}
	
       
     
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action=request.getServletPath();
		   
		  try {
			switch (action) {
			default:
            	   break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action=request.getServletPath();
		 response.setContentType("text/html");
		 
		  try {
			switch (action) {
			default:
						break;
		 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
 
}

