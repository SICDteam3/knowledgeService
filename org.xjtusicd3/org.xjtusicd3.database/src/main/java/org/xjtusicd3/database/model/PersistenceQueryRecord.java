package org.xjtusicd3.database.model;

import org.xjtusicd3.database.ann.Table;
import org.xjtusicd3.database.ann.TableField;
import org.xjtusicd3.database.ann.TableKey;
import org.xjtusicd3.database.ann.TableKey.Strategy;

@Table(tablename="query_record_table")
public class PersistenceQueryRecord {
	@TableKey(strategy=Strategy.NORMAL)
	@TableField(columnName="query_id")
	private String queryId;
	
	@TableField(columnName="user_email")
	private String userEmail;
	
	@TableField(columnName="query_word")
	private String queryWord;
	
	@TableField(columnName="time_stamp")
	private long timeStamp;
	

	public PersistenceQueryRecord(String queryID, String username, String query, long timestamp) {
		this.queryId = queryID;
		this.userEmail = username;
		this.queryWord = query;
		this.timeStamp = timestamp;
	}
	
	public PersistenceQueryRecord() {
		
	}

	public String getQueryId() {
		return queryId;
	}

	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getQueryWord() {
		return queryWord;
	}

	public void setQueryWord(String queryWord) {
		this.queryWord = queryWord;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
