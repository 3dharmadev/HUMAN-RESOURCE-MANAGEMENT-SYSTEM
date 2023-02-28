package com.HRmanagementsystem.model;

public class Status {
   private int id;
   private String username;
   private String status;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Status [id=" + id + ", username=" + username + ", status=" + status + "]";
}
   
   
   
}
//id | username              | status   | workingdDept