package com.HRmanagementsystem.dao;

import java.util.List;

import com.HRmanagementsystem.exception.DepartmentException;
import com.HRmanagementsystem.exception.EmployeeException;
import com.HRmanagementsystem.model.Department;
import com.HRmanagementsystem.model.Employee;
import com.HRmanagementsystem.model.LeaveDays;
import com.HRmanagementsystem.model.Status;

public interface AdminDao {
	
	String addNewDepartment(Department department);
	
	String addProjectToDepartment(String projectName,int deptId) throws DepartmentException;
	
	String assignManagerToDepartment(String username,int deptId) throws EmployeeException ;
	
	String assignEmployeeToDepartment(String username,int deptId)  throws EmployeeException , DepartmentException;
	
	String updateEmployeeLeaveStatus(String approved , int deptId ) throws DepartmentException;
	
	   List<Employee> employeeList();
	   
	   List<Status> statusList();
	   
    	List<LeaveDays> leaveReports();
	
	     List<Department> deptList();
	     
	String deleteEmployee(String username) throws EmployeeException;
	
	String deleteDepartment(int Id) throws DepartmentException;
	
	String deleteLeaveReport(int Id);
	
	String deleteOldStatus(int id);
	     
	String verifyEmpAccount(String username,int accountActivation) throws EmployeeException;
	
	String loginAdmin (String username,int password) throws EmployeeException;
	  

}
