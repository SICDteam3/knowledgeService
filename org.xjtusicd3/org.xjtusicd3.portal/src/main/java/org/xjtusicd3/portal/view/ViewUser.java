package org.xjtusicd3.portal.view;

import org.xjtusicd3.database.model.PersistenceUser;

public class ViewUser {
	
	private int userId;
	private String userName;
	private String userEmail;
	private String passWord;
	private String userType;
	private int flag;
	private int phone;
	
	 public ViewUser(){
	    	
	    }
	 public ViewUser(PersistenceUser pure){
	    	this.setFlag(pure.getFlag());
	    	this.setPassWord(pure.getPassword());
	    	this.setPhone(pure.getPhone());
	    	this.setUserEmail(pure.getEmail());
	    	this.setUserId(pure.getIdNumber());
	    	this.setUserName(pure.getUsername());
	    	this.setUserType(pure.getType());
	    } 

	public int getUserId() {
		return userId;
	}

	public void setUserId(int i) {
		this.userId = i;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int i) {
		this.flag = i;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int i) {
		this.phone = i;
	}
	 
}
