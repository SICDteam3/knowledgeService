package org.xjtusicd3.database.model;

import org.xjtusicd3.database.ann.Table;
import org.xjtusicd3.database.ann.TableField;
import org.xjtusicd3.database.ann.TableKey;
import org.xjtusicd3.database.ann.TableKey.Strategy;

@Table(tablename="user")
public class PersistenceUser {
	@TableKey(strategy=Strategy.NORMAL)
	@TableField(columnName="userEmail")
	private String email ;
	@TableField(columnName = "userName")
	private String username;
	@TableField(columnName="passWord")
	private String password;
	@TableField(columnName="user_type")
	private String type;
	@TableField(columnName="flag")
	private int flag;
	@TableField(columnName="userId")
	private int idNumber;
	@TableField(columnName="phone")
	private String phone;
	@TableField(columnName="birth")
	private String birth;
	@TableField(columnName="hobby")
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int i) {
		this.idNumber = i;
	}

	
	
}
