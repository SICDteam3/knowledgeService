package org.xjtusicd3.partner.view;

import java.util.List;

import org.xjtusicd3.database.model.PersistenceForumList;

public class ViewForumList {
	private int tid;
	private String username;
	private String title;
	private String cont;
	private long time;
	private List<ViewForumReply> replylist;
	
	
	public List<ViewForumReply> getReplylist() {
		return replylist;
	}
	public void setReplylist(List<ViewForumReply> replylist) {
		this.replylist = replylist;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	
	
	
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public ViewForumList(PersistenceForumList list){
		if(list==null){
			return;
		}
		this.tid = list.getTid();
		this.username = list.getUsername();
		this.title = list.getTitle();
		this.cont = list.getCont();
		this.time = list.getTime();
	}
	public ViewForumList(){
		
	}
		
}
