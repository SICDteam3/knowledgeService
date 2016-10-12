package org.xjtusicd3.partner.view;


import org.xjtusicd3.database.model.PersistenceUser;

public class ViewUser {
	private String username;
	private String password;
	private String email;
	private String phone;
	private int idNumber;
	private String birth;
	private String hobby;
	
	
	
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
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
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ViewUser(PersistenceUser persistenceUser){
		this.idNumber = persistenceUser.getIdNumber();
		this.username = persistenceUser.getUsername();
		this.password = persistenceUser.getPassword();
		this.email = persistenceUser.getEmail();
		this.phone = persistenceUser.getPhone();
		this.birth=persistenceUser.getBirth();
		this.hobby=persistenceUser.getHobby();
	}
	
	public ViewUser(){
		
	}	
}
