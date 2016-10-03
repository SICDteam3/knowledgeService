package org.xjtusicd3.partner.view;

import org.xjtusicd3.database.model.PersistencePatentcount;

public class ViewPatentVisual {
	private String patent_inventor;
	private String patent_holder;
	private int counts;
	private String date_of_application;
	private String annoucement_date;
	private String IPC;
	
	
	
	public String getIPC() {
		return IPC;
	}
	public void setIPC(String iPC) {
		IPC = iPC;
	}
	public String getDate_of_application() {
		return date_of_application;
	}
	public void setDate_of_application(String date_of_application) {
		this.date_of_application = date_of_application;
	}
	public String getAnnoucement_date() {
		return annoucement_date;
	}
	public void setAnnoucement_date(String annoucement_date) {
		this.annoucement_date = annoucement_date;
	}
	public String getPatent_inventor() {
		return patent_inventor;
	}
	public void setPatent_inventor(String patent_inventor) {
		this.patent_inventor = patent_inventor;
	}
	public String getPatent_holder() {
		return patent_holder;
	}
	public void setPatent_holder(String patent_holder) {
		this.patent_holder = patent_holder;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	
	
	
	public ViewPatentVisual(PersistencePatentcount patentcount) {
		if(patentcount==null){
			return;
		}
		this.patent_inventor = patentcount.getPatent_inventor();
		this.patent_holder = patentcount.getPatent_holder();
		this.counts = patentcount.getCounts();
		this.date_of_application = patentcount.getDate_of_application();
		this.annoucement_date = patentcount.getAnnouncement_date();
	}
	@Override
	public String toString() {
		return "ViewPatentVisual [patent_inventor=" + patent_inventor + ", patent_holder=" + patent_holder + ", counts="
				+ counts + ", date_of_application=" + date_of_application + ", annoucement_date=" + annoucement_date
				+ ", IPC=" + IPC + "]";
	}
		
}
