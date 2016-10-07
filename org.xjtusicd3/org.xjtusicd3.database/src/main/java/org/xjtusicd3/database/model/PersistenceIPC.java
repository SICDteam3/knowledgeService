package org.xjtusicd3.database.model;

import org.xjtusicd3.database.ann.Table;
import org.xjtusicd3.database.ann.TableField;
import org.xjtusicd3.database.ann.TableKey;
import org.xjtusicd3.database.ann.TableKey.Strategy;

@Table(tablename="sys_ipc_classify")
public class PersistenceIPC {
	
	@TableField(columnName="CLASS_ID")
	@TableKey(strategy=Strategy.NORMAL)
	private String CLASS_ID;
	
	@TableField(columnName="CLASS_NAME")
	private String CLASS_NAME;
	
	@TableField(columnName="CLASS_NUMBER")
	private String CLASS_NUMBER;
	
	@TableField(columnName="PARENT_CLASS_ID")
	private String PARENT_CLASS_ID;
	
	@TableField(columnName="CLASS_LAYER")
	private String CLASS_LAYER;
	
	public String getCLASS_ID() {
		return CLASS_ID;
	}
	public void setCLASS_ID(String cLASS_ID) {
		CLASS_ID = cLASS_ID;
	}
	public String getCLASS_NAME() {
		return CLASS_NAME;
	}
	public void setCLASS_NAME(String cLASS_NAME) {
		CLASS_NAME = cLASS_NAME;
	}
	public String getCLASS_NUMBER() {
		return CLASS_NUMBER;
	}
	public void setCLASS_NUMBER(String cLASS_NUMBER) {
		CLASS_NUMBER = cLASS_NUMBER;
	}
	public String getPARENT_CLASS_ID() {
		return PARENT_CLASS_ID;
	}
	public void setPARENT_CLASS_ID(String pARENT_CLASS_ID) {
		PARENT_CLASS_ID = pARENT_CLASS_ID;
	}
	public String getCLASS_LAYER() {
		return CLASS_LAYER;
	}
	public void setCLASS_LAYER(String cLASS_LAYER) {
		CLASS_LAYER = cLASS_LAYER;
	}
	
	
	
}
