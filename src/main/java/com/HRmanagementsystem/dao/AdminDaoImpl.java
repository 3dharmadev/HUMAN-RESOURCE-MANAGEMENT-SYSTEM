package com.HRmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.HRmanagementsystem.DB_util.DB_Connect;
import com.HRmanagementsystem.exception.DepartmentException;
import com.HRmanagementsystem.exception.EmployeeException;
import com.HRmanagementsystem.model.Department;
import com.HRmanagementsystem.model.Employee;
import com.HRmanagementsystem.model.LeaveDays;
import com.HRmanagementsystem.model.Status;



public class AdminDaoImpl implements AdminDao{

	@Override
	public String addNewDepartment(Department department) {
		String messageString="Unable to register! Try again...";
		
		try(Connection conn=DB_Connect.getConnection()){
		 
		 
		   
			 PreparedStatement ps= conn.prepareStatement("INSERT INTO department (deptName) VALUES(?)");
			    ps.setString(1, department.getDepartmentName());
//			    System.out.println(department);
			    int res=ps.executeUpdate();
			    if(res>0) messageString="Department added successfully.....";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			messageString=e.getMessage();
			e.printStackTrace();
		}
		
		return messageString;
	}

	@Override
	public String addProjectToDepartment(String projectName, int deptId) throws DepartmentException {
     String messageString="Wrong Department ID!";
		
		try(Connection conn=DB_Connect.getConnection()){
			 
			 PreparedStatement ps= conn.prepareStatement("update department set assignProject=? where deptId=?");
			    ps.setString(1, projectName);
			    ps.setInt(2,deptId);
			    int res=ps.executeUpdate();
			    System.out.println(res);
			    if(res>0) messageString="project added successfully...";
			     
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}
		
		return messageString;
	}

	@Override
	public String assignManagerToDepartment(String username, int deptId) throws EmployeeException {
       String messageString="Wrong Input! Try again...";
		
		try(Connection conn=DB_Connect.getConnection()){
			 
			 PreparedStatement ps= conn.prepareStatement(" UPDATE department SET deptManager=? where deptId=?");
			    ps.setString(1, username);
			    ps.setInt(2,deptId);
			    int res=ps.executeUpdate();
			   
			    if(res>0) messageString="Department manager added successfully...";


		} catch (SQLException  e) {
			System.out.println(e.getMessage());
			messageString=e.getMessage();
		    throw new EmployeeException("This username already assigned to another department as a manager"
		    		+ "<br> Or Problem with The Entered Details Please Enter Details Carefully");

		}
		
		return messageString;
	}

	@Override
	public String assignEmployeeToDepartment(String username, int deptId)	throws EmployeeException, DepartmentException {
		 String messageString="Wrong Input! Try again...";
			
			try(Connection conn=DB_Connect.getConnection()){
				 
				 PreparedStatement ps= conn.prepareStatement("update employee set deptID=? where username=?");
				
				    ps.setInt(1,deptId);
				    ps.setString(2, username);
				    int res=ps.executeUpdate();
				   
				    if(res>0) messageString=username+" will going to work under department number: "+deptId;


			} catch (SQLException  e) {
				
				System.out.println(e.getMessage());
			    throw new DepartmentException("Wrong Department Id!");

			}
			
			return messageString;
	}

	@Override
	public String updateEmployeeLeaveStatus(String approved, int id) throws DepartmentException {
		 String messageString="Ohh Ohh Something went wrong...";
			
			try(Connection conn=DB_Connect.getConnection()){
				 
				 PreparedStatement ps= conn.prepareStatement("UPDATE applyLeave SET approved =? where id=?");
				  int approved2=Integer.parseInt(approved.trim());
				    ps.setInt(1,approved2);
				    ps.setInt(2, id);
				    int res=ps.executeUpdate();
				   
				    if(res>0 && approved2==0) messageString="Employee denied for leave...";
				    if(res>0 && approved2==1) messageString="Employee granted for leave...";


			} catch (SQLException  e) {
				System.out.println(e.getMessage());
			    throw new DepartmentException(e.getMessage());

			}
			
			return messageString;
	}

	@Override
	public String verifyEmpAccount(String username, int accountActivation) throws EmployeeException {
		 String messageString="Wrong UserName!";
			
			try(Connection conn=DB_Connect.getConnection()){
				 
				 PreparedStatement ps= conn.prepareStatement("UPDATE employee SET  accountActive=? where  username=?");
				
				    ps.setInt(1,accountActivation);
				    ps.setString(2, username);
				    int res=ps.executeUpdate();
				   
				    if(res>0 && accountActivation==0) messageString=username+" Employee Account Deactivated &#10003";
				    else if(res>0 && accountActivation==1) messageString=username+" Employee Account Successfully Activated &#10003";
				     else   throw new EmployeeException("username not found!");


			} catch (SQLException  e) {
				System.out.println(e.getMessage());
			    throw new EmployeeException(e.getMessage());

			}
			
			return messageString;
	}

	@Override
	public String loginAdmin(String username, int password) throws EmployeeException {
		String messageString="Something went wrong!..";
		
		try(Connection conn=DB_Connect.getConnection()){
			 
			 PreparedStatement ps= conn.prepareStatement("SELECT * from admin where username=? AND password=?");
			
			    ps.setString(1,username);
			    ps.setInt(2, password);

                ResultSet rs=ps.executeQuery();
                
			    
			    if(rs.next()) messageString="LOGIN SUCCESSFUL!";
			     else   throw new EmployeeException("PLEASE ENTER DETAILS CAREFULLY");


		} catch (SQLException  e) {
			System.out.println(e.getMessage());
		    throw new EmployeeException(e.getMessage());

		}
		
		return messageString;
	}

	@Override
	public List<Employee> employeeList() {

       List<Employee>  employees=new ArrayList<>();
	
		  try(Connection conn=DB_Connect.getConnection()){
	            PreparedStatement ps=conn.prepareStatement("select * from employee");

	            ResultSet rs=ps.executeQuery();
//| username       | name | password | DOB        | deptId | accountActive |
	            while (rs.next()){
	                Employee employee=new Employee();
	                employee.setEmail((rs.getString("username")));
	               employee.setName(rs.getString("name"));
	               employee.setPassword(rs.getString("password"));
	               employee.setDateOfBirth(rs.getString("DOB"));
	               employee.setDeptId(rs.getInt("deptId"));
	               employee.setAccountActivate(rs.getBoolean("accountActive"));
	               employees.add(employee);
	            }
	        }
	        catch (SQLException e){
	            System.out.println(e.getMessage());
	        }
	        return employees;
	}

	@Override
	public List<LeaveDays> leaveReports() {
	    List<LeaveDays>  leaveDays=new ArrayList<>();
	    
			  try(Connection conn=DB_Connect.getConnection()){
		            PreparedStatement ps=conn.prepareStatement("select * from applyLeave");

		            ResultSet rs=ps.executeQuery();
		//            | id | username       | leaveFrom  | leaveTo    | approved | reason   |
		            while (rs.next()){
		               LeaveDays days=new LeaveDays();
		                    days.setID(rs.getInt("id"));
		                   days.setUserName(rs.getString("username"));
		                   days.setLeaveFrom(rs.getString("leaveFrom"));
		                   days.setLeaveTo(rs.getString("leaveTo"));
		                   days.setApproved(rs.getString("approved"));
		                   days.setReason(rs.getString("reason"));
		                   leaveDays.add(days);
		            }
		        }
		        catch (SQLException e){
		            System.out.println(e.getMessage());
		        }
		        return leaveDays;
	}

	@Override
	public List<Department> deptList() {
		 List<Department>  departments=new ArrayList<>();
		    
		  try(Connection conn=DB_Connect.getConnection()){
	            PreparedStatement ps=conn.prepareStatement("select * from department");

	            ResultSet rs=ps.executeQuery();
	//     deptId | deptName               | assignProject             | deptManager
	            while (rs.next()){
	              Department department=new Department();
	                   department.setDeptId(rs.getInt("deptId"));
	                   department.setDepartmentName(rs.getString("deptName"));
	                   department.setAssignProject(rs.getString("assignProject"));
	                   department.setDeptManager(rs.getString("deptManager"));
	                   departments.add(department);
	            }
	        }
	        catch (SQLException e){
	            System.out.println(e.getMessage());
	        }
	        return departments;
	}

	@Override
	public String deleteEmployee(String username) throws EmployeeException {
	
		String messageString="Wrong Username..";
		
		try(Connection conn=DB_Connect.getConnection()){

			
			Statement statement=conn.createStatement();
			statement.addBatch("delete from updateStatus where username='"+username+"'");
			statement.addBatch("delete from  applyLeave where username='"+username+"'");
			statement.addBatch("UPDATE department set deptManager=NULL WHERE deptManager ='"+username+"'");
			statement.addBatch("delete from  employee where username='"+username+"'");
		 
	 
           int[] arr =statement.executeBatch();
//           System.out.println(Arrays.toString(arr));
		if(arr[arr.length-1]>0) messageString=username+" Deleted Successfully...";
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return messageString;

	
	}

	@Override
	public String deleteDepartment(int deptId) throws DepartmentException {
		String messageString="Something went wrong...";
		try(Connection connection=DB_Connect.getConnection()){
		PreparedStatement	ps=connection.prepareStatement("delete from department where deptId=?");
		ps.setInt(1, deptId);
		
	     int res =	ps.executeUpdate();
	     if(res>0) messageString="Department "+deptId+" Deleted successfully";
	     
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DepartmentException(e.getMessage());
		}
		return messageString;
	}

	
	 

	@Override
	public String deleteLeaveReport(int Id) {
      String message="Something went wrong..";
try(Connection connection=DB_Connect.getConnection()){
	PreparedStatement	ps=connection.prepareStatement("DELETE FROM applyLeave WHERE id=?");
	ps.setInt(1, Id);
      int res=	ps.executeUpdate();
      if(res>0) message="One Leave Application Deleted successfully..";
} catch (SQLException e) {
	System.out.println(e.getMessage());
	e.printStackTrace();
}
		return message;
	}

	@Override
	public List<Status> statusList() {
		
		List<Status > statusList=new ArrayList<>();	
		  try(Connection conn=DB_Connect.getConnection()){
	            PreparedStatement ps=conn.prepareStatement("select * from updateStatus");

	            ResultSet rs=ps.executeQuery();
	          //id | username              | status   | workingdDept
	            while (rs.next()){
	            	Status status=new Status();
	            	status.setId(rs.getInt("id"));
	             	status.setUsername(rs.getString("username"));
	             	status.setStatus(rs.getString("status"));
	             	statusList.add(status);

	            }
	        }
	        catch (SQLException e){
	            System.out.println(e.getMessage());
	        }
	        return statusList;
		
	}

	@Override
	public String deleteOldStatus(int id) {
		   String message="Something went wrong..";
		   try(Connection connection=DB_Connect.getConnection()){
		   	PreparedStatement	ps=connection.prepareStatement("DELETE FROM updateStatus WHERE id=?");
		   	ps.setInt(1, id);
		         int res=	ps.executeUpdate();
		         if(res>0) message="Status Deleted successfully..";
		   } catch (SQLException e) {
		   	System.out.println(e.getMessage());
		   	e.printStackTrace();
		   }
		   		return message;
	}

}
