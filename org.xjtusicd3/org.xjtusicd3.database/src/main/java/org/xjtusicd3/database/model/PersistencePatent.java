package org.xjtusicd3.database.model;

import org.xjtusicd3.database.ann.Table;
import org.xjtusicd3.database.ann.TableField;
import org.xjtusicd3.database.ann.TableKey;
import org.xjtusicd3.database.ann.TableKey.Strategy;

@Table(tablename="patent")
public class PersistencePatent {
	@TableKey(strategy = Strategy.NORMAL)
	@TableField(columnName="id")
	private Integer id;
	
	@TableField(columnName="number")
	private String patentID;
	
	@TableField(columnName="name")
	private String name;
	
	@TableField(columnName="abstract")
	private String patentabstract;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPatentID() {
		return patentID;
	}

	public void setPatentID(String patentID) {
		this.patentID = patentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatentabstract() {
		return patentabstract;
	}

	public void setPatentabstract(String patentabstract) {
		this.patentabstract = patentabstract;
	}
	
	
	
}
