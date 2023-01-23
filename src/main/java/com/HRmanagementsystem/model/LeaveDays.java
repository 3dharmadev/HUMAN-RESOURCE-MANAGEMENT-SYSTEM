package com.HRmanagementsystem.model;

public class LeaveDays {
	
	private int ID;
	private String userName;
	private String leaveFrom;
	private String leaveTo;
	
	private String reason;
	private String approved;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLeaveFrom() {
		return leaveFrom;
	}
	public void setLeaveFrom(String leaveFrom) {
		this.leaveFrom = leaveFrom;
	}
	public String getLeaveTo() {
		return leaveTo;
	}
	public void setLeaveTo(String leaveTo) {
		this.leaveTo = leaveTo;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	@Override
	public String toString() {
		return "LeaveDays [ID=" + ID + ", userName=" + userName + ", leaveFrom=" + leaveFrom + ", leaveTo=" + leaveTo
				+ ", reason=" + reason + ", approved=" + approved + "]";
	}
	
	
	 
	
	

}
