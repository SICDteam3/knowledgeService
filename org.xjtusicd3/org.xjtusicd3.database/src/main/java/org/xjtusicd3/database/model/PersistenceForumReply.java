package org.xjtusicd3.database.model;

import org.xjtusicd3.database.ann.Table;
import org.xjtusicd3.database.ann.TableField;
import org.xjtusicd3.database.ann.TableKey;
import org.xjtusicd3.database.ann.TableKey.Strategy;

@Table(tablename="reply")
public class PersistenceForumReply {
	@TableKey(strategy = Strategy.NORMAL)
	@TableField(columnName = "rid")
	private int rid;
	@TableField(columnName = "tid")
	private int tid;
	@TableField(columnName = "rusername")
	private String rusername;
	@TableField(columnName = "rep_cont")
	private String rep_cont;
	@TableField(columnName = "rtime")
	private long rtime;
	
	
	
	public long getRtime() {
		return rtime;
	}
	public void setRtime(long rtime) {
		this.rtime = rtime;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public String getRusername() {
		return rusername;
	}
	public void setRusername(String rusername) {
		this.rusername = rusername;
	}
	public String getRep_cont() {
		return rep_cont;
	}
	public void setRep_cont(String rep_cont) {
		this.rep_cont = rep_cont;
	}
	
	
}
