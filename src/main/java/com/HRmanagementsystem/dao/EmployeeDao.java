package com.HRmanagementsystem.dao;

import com.HRmanagementsystem.exception.EmployeeException;
import com.HRmanagementsystem.model.Employee;
import com.HRmanagementsystem.model.LeaveDays;

public interface EmployeeDao {

	String empLogin(String username,String password) throws EmployeeException;
	
	String signupEmployee(Employee employee);
	
	String requestForLeave(LeaveDays leave) throws EmployeeException;
	
	Employee employeeDetails(String username) throws EmployeeException;
	
	String updateProjectCompletionStatus(String username,String status) throws EmployeeException; 
	
	
	
}
