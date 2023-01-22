package com.HRmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.HRmanagementsystem.DB_util.DB_Connect;
import com.HRmanagementsystem.exception.EmployeeException;
import com.HRmanagementsystem.model.Employee;
import com.HRmanagementsystem.model.LeaveDays;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String empLogin(String username, String password) throws EmployeeException {
	String messageString="Something went wrong!..";
		
		try(Connection conn=DB_Connect.getConnection()){
			 
			 PreparedStatement ps= conn.prepareStatement("SELECT * from employee where username=? AND password=?  AND accountActive=1");

			    ps.setString(1,username);
			    ps.setString(2, password);
			    ResultSet rs=ps.executeQuery();
			    
			 if(rs.next()) {
				return messageString="LOGIN SUCCESSFUL!";
				 
			 }
			 
			 PreparedStatement ps2= conn.prepareStatement("SELECT * from employee where username=? AND password=?");
			    
			    ps2.setString(1,username);
			    ps2.setString(2, password);

                ResultSet rs2=ps2.executeQuery();
                
			     if(rs2.next())  throw new EmployeeException("account not verified ");


		} catch (SQLException  e) {
			System.out.println(e.getMessage());
		    throw new EmployeeException(e.getMessage());

		}
		
		return messageString;
	}

	@Override
	public String signupEmployee(Employee employee) {
	     String message ="Something went wrong!";
	     
	     
	     try(Connection conn=DB_Connect.getConnection()){
	    	PreparedStatement ps =conn.prepareStatement("INSERT INTO employee (username,name,password,DOB) VALUES(?,?,?,?)");
	    	
	    	// username       | name | password | DOB        | deptId | accountActive
	    	
	    	ps.setString(1, employee.getEmail());
	    	ps.setString(2, employee.getName());
	    	ps.setString(3, employee.getPassword());
	    	ps.setString(4, employee.getDateOfBirth());
	    	
	    	int res=ps.executeUpdate();
	    	
	    	if(res>0) message="sign up successful wait for verification";
	     } catch (SQLException e) {
			message=e.getMessage();
			e.printStackTrace();
		}
	
	  return message;
	
	}

	@Override
	public String requestForLeave(LeaveDays leave) throws EmployeeException {
		  String message ="Something went wrong!";
		     
		     
		     try(Connection conn=DB_Connect.getConnection()){
		    	PreparedStatement ps =conn.prepareStatement("INSERT INTO applyLeave (username,leaveFrom,leaveTo,reason) VALUES(?,?,?,?)");
		    	
		    	ps.setString(1, leave.getUserName());
		    	ps.setString(2, leave.getLeaveFrom());
		    	ps.setString(3, leave.getLeaveTo());
		    	ps.setString(4, leave.getReason());
		   
		    	int res=ps.executeUpdate();
		    	
		    	if(res>0) message="successfully applied... wait for review";
		     } catch (SQLException e) {
				message="Wrong username...";
				e.printStackTrace();
			}
		
		  return message;
	}

	@Override
	public Employee employeeDetails(String username) throws EmployeeException {
		 Employee employee=new Employee();
		 
		 try(Connection conn=DB_Connect.getConnection()) {

		PreparedStatement	ps= conn.prepareStatement("SELECT * FROM employee WHERE username=?");
		   ps.setString(1, username);
	      ResultSet rs=ps.executeQuery();
		
	      if(rs.next()) {
	    	  
	    	  employee.setEmail(rs.getString("username"));
	    	  employee.setName(rs.getString("name"));
	    	  employee.setDateOfBirth(rs.getString("DOB"));
	    	  employee.setDeptId(rs.getInt("deptId"));
	    	  employee.setAccountActivate(true);
	    	  employee.setPassword(rs.getString("password"));
	    	  
	      }
		
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		 
		 return employee;
	}

	@Override
	public String updateProjectCompletionStatus(String username, String status) throws EmployeeException {
		 String message="Please Enter a proper username";
		 
		 
		   try(Connection conn=DB_Connect.getConnection()){
		    	PreparedStatement ps =conn.prepareStatement(" INSERT INTO updateStatus VALUES(?,?,(SELECT deptId FROM employee where username=?))");
		    	
		    	ps.setString(1, username);
		    	ps.setString(2, status);
		    	ps.setString(3, username);
		   
		    	int res=ps.executeUpdate();
		    	
		    	if(res>0) message="status updated successfully..";
		     } catch (SQLException e) {
				System.out.println(e.getMessage());
				message="Only Worker's who working in any department are allowed....";
				throw new EmployeeException(e.getMessage());
			}
		 
		 
		 return message;
	}

	@Override
	public String updatePassword(String username, String new_password) throws EmployeeException {
		String message="Something went wrong Try After sometime...";
		 
		 
		   try(Connection conn=DB_Connect.getConnection()){
		    	PreparedStatement ps =conn.prepareStatement("UPDATE employee SET password=? WHERE username=?");
		    	
		    	ps.setString(1, new_password);
		    	ps.setString(2, username);
		   
		    	int res=ps.executeUpdate();
		    	
		    	if(res>0) message="password updated successfully..";
		     } catch (SQLException e) {
				 
				message=e.getMessage();
				throw new EmployeeException(e.getMessage());
			}
		 
		 
		 return message;
	}

}
