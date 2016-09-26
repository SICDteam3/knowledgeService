package org.xjtusicd3.database.model;

import org.xjtusicd3.database.ann.Table;
import org.xjtusicd3.database.ann.TableField;
import org.xjtusicd3.database.ann.TableKey;
import org.xjtusicd3.database.ann.TableKey.Strategy;

@Table(tablename="admin_table")
public class PersistenceAdmin {
	@TableKey(strategy=Strategy.NORMAL)
	@TableField(columnName="admin_name")
	private String adminName;
	
	@TableField(columnName="admin_password")
	private String adminpassword;
	
	@TableField(columnName="authority_id ")
	private int authorityId;
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	public int getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}
	
}
