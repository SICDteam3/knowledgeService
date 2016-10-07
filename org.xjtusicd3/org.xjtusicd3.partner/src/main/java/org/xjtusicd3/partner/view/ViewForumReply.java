package org.xjtusicd3.partner.view;

import org.xjtusicd3.database.model.PersistenceForumReply;

public class ViewForumReply {
	private int rid;
	private String rusername;
	private String rep_cont;
	private int tid;
	private long time;
	public int getRid() {
		return rid;
	}
	
	
	public void setRid(int rid) {
		this.rid = rid;
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
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
	public ViewForumReply(PersistenceForumReply reply){
		if(reply==null){
			return;
		}
		this.tid = reply.getTid();
		this.rusername = reply.getRusername();
		this.time = reply.getRtime();
		this.rep_cont = reply.getRep_cont();
		this.rid = reply.getRid();
	}
	public ViewForumReply(){
		
	}
	
	
}
