package com.HRmanagementsystem.DB_util;

import java.util.List;

import com.HRmanagementsystem.dao.AdminDao;
import com.HRmanagementsystem.dao.AdminDaoImpl;
import com.HRmanagementsystem.dao.EmployeeDao;
import com.HRmanagementsystem.dao.EmployeeDaoImpl;
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
		//Department department=new Department();
		//department.setDepartmentName("Information Technology");
		EmployeeDao employeeDao=new EmployeeDaoImpl();
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
		
//		List<Department> departments=dao.deptList();
//		for (Department department2 : departments) {
//			System.out.println(department2);
//		}
//		Employee employee=new Employee();
//		employee.setEmail("putin@gmail.com");
//		employee.setDateOfBirth("1968-02-15");
//		employee.setName("Vlamadir putin");
//		employee.setPassword("MEEPUTIN");
//System.out.println(employeeDao.signupEmployee(employee));
		//System.out.println(employeeDao.empLogin("ram@gmail.com", "1234"));
//		LeaveDays leaveDays=new LeaveDays();
//		leaveDays.setUserName("putin@gmail.com");
//		leaveDays.setLeaveFrom("2023-01-23");
//		leaveDays.setLeaveTo("2023-01-28");
//		leaveDays.setReason("Marriage cerimony");
//		System.out.println(employeeDao.requestForLeave(leaveDays));
		
		//System.out.println(employeeDao.employeeDetails("ram@gmail.com"));
		//System.out.println(employeeDao.updateProjectCompletionStatus("deba@gmail.com", "50% completed"));
		//System.out.println(employeeDao.updatePassword("deba@gmail.com", "753014"));
		
		//System.out.println(employeeDao.employeeRequestedLeaves("ankit@gmail.com"));
		
		//System.out.println(employeeDao.statusHistory("ankit@gmail.com"));
		//System.out.println(dao.deleteEmployee("ram@gmail.com"));
		//System.out.println(dao.deleteDepartment(214));
		//System.out.println(dao.deleteLeaveReport(2));
		System.out.println(employeeDao.empLogin("deba@gmail.com", "1234"));
	}
}