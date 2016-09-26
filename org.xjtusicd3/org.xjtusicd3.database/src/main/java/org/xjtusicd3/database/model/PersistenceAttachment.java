package org.xjtusicd3.database.model;

import org.xjtusicd3.database.ann.Table;
import org.xjtusicd3.database.ann.TableField;
import org.xjtusicd3.database.ann.TableKey;
import org.xjtusicd3.database.ann.TableKey.Strategy;

/**
 * @author liugc
 *
 */
@Table(tablename = "attachment")
public class PersistenceAttachment {
	@TableKey(strategy = Strategy.SEQ)
	@TableField(columnName = "attach_id")
	private String attachId ;

	@TableField(columnName = "PATHNAME")
	private String pathname;
	
	@TableField(columnName = "attach_file")
	private Object attachFile;

	public String getAttachId() {
		return attachId;
	}

	public void setAttachId(String attachId) {
		this.attachId = attachId;
	}

	public String getPathname() {
		return pathname;
	}

	public void setPathname(String pathname) {
		this.pathname = pathname;
	}

	public Object getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(Object attachFile) {
		this.attachFile = attachFile;
	}

	
	

	
}
