package org.xjtusicd3.database.model;
import org.xjtusicd3.database.ann.Table;
import org.xjtusicd3.database.ann.TableField;
import org.xjtusicd3.database.ann.TableKey;
import org.xjtusicd3.database.ann.TableKey.Strategy;

@Table(tablename="user_table")
public class PersistenceUser {
	@TableKey(strategy=Strategy.NORMAL)
	@TableField(columnName="email")
	private String email ;
	
	@TableField(columnName = "username")
	private String username;
	
	@TableField(columnName="password")
	private String password;
	
	@TableField(columnName="contact")
	private String contact;
	
	
	
	
	@TableField(columnName="truename")
	private String truename;
	
	@TableField(columnName="phone_number")
	private String phoneNumber ;
	
	@TableField(columnName="bank_number")
	private String bankNumber  ;
	
	@TableField(columnName="id_number")
	private String idNumber;

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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	
	
}
