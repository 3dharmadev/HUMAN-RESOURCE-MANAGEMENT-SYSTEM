package com.HRmanagementsystem.dao;

import java.awt.List;

import com.HRmanagementsystem.exception.EmployeeException;
import com.HRmanagementsystem.model.Employee;
import com.HRmanagementsystem.model.LeaveDays;

public interface EmployeeDao {

	String empLogin(String username,String password) throws EmployeeException;
	
	String signupEmployee(Employee employee);
	
	String requestForLeave(LeaveDays leave) throws EmployeeException;
	
	Employee employeeDetails(String username) throws EmployeeException;
	
	String updateProjectCompletionStatus(String username,String status) throws EmployeeException;
	
	java.util.List<LeaveDays> employeeRequestedLeaves(String username) throws EmployeeException;
	

	
	String updatePassword(String username,String new_password) throws EmployeeException;
	
	
	
}
