package org.xjtusicd3.database.model;

import org.xjtusicd3.database.ann.Table;
import org.xjtusicd3.database.ann.TableField;
import org.xjtusicd3.database.ann.TableKey;
import org.xjtusicd3.database.ann.TableKey.Strategy;

@Table(tablename="authority_table")
public class PersistenceAuthority {
	@TableKey(strategy=Strategy.NORMAL)
	@TableField(columnName="authority_id")
	private Integer authorityId;
	
	@TableField(columnName="authority_name")
	private String authorityName;
	
	@TableField(columnName="authority_path")
	private String authorityPath;

	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityPath() {
		return authorityPath;
	}

	public void setAuthorityPath(String authorityPath) {
		this.authorityPath = authorityPath;
	}
	
	
}
