package org.xjtusicd3.partner.view;


import org.xjtusicd3.database.model.PersistenceUser;

public class ViewUser {
	private String username;
	private String password;
	private String email;
	private int phone;
	 public ViewUser(){
	    	
	    }
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public ViewUser(PersistenceUser persistenceUser){
		this.username = persistenceUser.getUsername();
		this.password = persistenceUser.getPassword();
		this.email = persistenceUser.getEmail();
		this.phone = persistenceUser.getPhone();
	}
	
	

}
