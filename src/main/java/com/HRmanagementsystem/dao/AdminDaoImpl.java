package com.HRmanagementsystem.dao;

import java.util.List;

import com.HRmanagementsystem.exception.DepartmentException;
import com.HRmanagementsystem.exception.EmployeeException;
import com.HRmanagementsystem.model.Department;
import com.HRmanagementsystem.model.Employee;
import com.HRmanagementsystem.model.LeaveDays;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String addNewDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addProjectToDepartment(String projectName, int deptId) throws DepartmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String assignManagerToDepartment(String username, int deptId) throws EmployeeException, DepartmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String assignEmployeeToDepartment(String username, String deptId)
			throws EmployeeException, DepartmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEmployeeLeaveStatus(int approved, int deptId) throws DepartmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String verifyEmpAccount(String username, int accountActivation) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginAdmin(String username, String password) throws EmployeeException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> employeeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDays> leaveReports() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> deptList() {
		// TODO Auto-generated method stub
		return null;
	}

}
