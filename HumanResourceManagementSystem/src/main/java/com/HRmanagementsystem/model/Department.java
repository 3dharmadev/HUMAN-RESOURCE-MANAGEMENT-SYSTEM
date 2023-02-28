package com.HRmanagementsystem.model;

public class Department {
   private int deptId;
   private String departmentName;
   private String assignProject ;
   private String deptManager  ;
public int getDeptId() {
	return deptId;
}
public void setDeptId(int deptId) {
	this.deptId = deptId;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public String getAssignProject() {
	return assignProject;
}
public void setAssignProject(String assignProject) {
	this.assignProject = assignProject;
}
public String getDeptManager() {
	return deptManager;
}
public void setDeptManager(String deptManager) {
	this.deptManager = deptManager;
}
@Override
public String toString() {
	return "Department [deptId=" + deptId + ", departmentName=" + departmentName + ", assignProject=" + assignProject
			+ ", deptManager=" + deptManager + "]";
}
   
   
   
   
}
