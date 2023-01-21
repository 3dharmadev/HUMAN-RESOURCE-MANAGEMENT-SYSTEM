package com.HRmanagementsystem.DB_util;

import java.util.List;

import com.HRmanagementsystem.dao.AdminDao;
import com.HRmanagementsystem.dao.AdminDaoImpl;
import com.HRmanagementsystem.exception.DepartmentException;
import com.HRmanagementsystem.exception.EmployeeException;
import com.HRmanagementsystem.model.Department;
import com.HRmanagementsystem.model.Employee;
import com.HRmanagementsystem.model.LeaveDays;

public class usecases {
	
	public static void main(String[] args) {
		 System.out.println("WORKING ON TREE");
	}

}

class abc{
	public static void main(String[] args) throws EmployeeException, DepartmentException {
		AdminDao dao=new AdminDaoImpl();
		Department department=new Department();
		department.setDepartmentName("Information Technology");
		//System.out.println(dao.addNewDepartment(department));
//		try {
//			System.out.println(dao.addProjectToDepartment("WhatsApp Clone", 416));
//		} catch (DepartmentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//System.out.println(dao.assignManagerToDepartment("deba@gmail.com", 102));
		//System.out.println(dao.assignEmployeeToDepartment("newa@gmail.com", 102));
		//System.out.println(dao.updateEmployeeLeaveStatus(1, 1));
		//System.out.println(dao.verifyEmpAccount("ram@gmail.com", 1));
		//System.out.println(dao.loginAdmin("deba", 1234));
//	List<Employee> employees=dao.employeeList();
//	for (Employee employee : employees) {
//		System.out.println(employee);
//	}
		
//		List<LeaveDays> days=dao.leaveReports();
//		for (LeaveDays leaveDays : days) {
//			System.out.println(leaveDays);
//		}
		
		List<Department> departments=dao.deptList();
		for (Department department2 : departments) {
			System.out.println(department2);
		}
	}
}