package com.HRmanagementsystem.model;

public class Employee {
    
	private String email;
	private String name;
	private String password;
	private String dateOfBirth;
	private int deptId;
	private boolean accountActivate;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public boolean isAccountActivate() {
		return accountActivate;
	}
	public void setAccountActivate(boolean accountActivate) {
		this.accountActivate = accountActivate;
	}
	@Override
	public String toString() {
		return "Employee [email=" + email + ", name=" + name + ", password=" + password + ", dateOfBirth=" + dateOfBirth
				+ ", deptId=" + deptId + ", accountActivate=" + accountActivate + "]";
	}
	
	
	
	
	
	
}
