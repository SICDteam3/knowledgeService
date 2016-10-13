package org.xjtusicd3.partner.view;

import org.xjtusicd3.database.model.PersistencePatentcount;

public class ViewPatentVisual {
	private String patent_inventor;
	private String patent_holder;
	private String date_year;
	private String counts_year;
	private String counts_inventor;
	private String counts_holder;
	private String counts_application;
	private String counts_announcement;
	private String counts_province;
	private String date_of_application;
	private String annoucement_date;
	private String IPC;
	private String province;
	private String principal_claim;
	
	
	
	
	
	
	
		
	public String getCounts_province() {
		return counts_province;
	}
	public void setCounts_province(String counts_province) {
		this.counts_province = counts_province;
	}
	public String getPrincipal_claim() {
		return principal_claim;
	}
	public void setPrincipal_claim(String principal_claim) {
		this.principal_claim = principal_claim;
	}
	public String getDate_year() {
		return date_year;
	}
	public void setDate_year(String date_year) {
		this.date_year = date_year;
	}
	public String getCounts_year() {
		return counts_year;
	}
	public void setCounts_year(String counts_year) {
		this.counts_year = counts_year;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCounts_inventor() {
		return counts_inventor;
	}
	public void setCounts_inventor(String counts_inventor) {
		this.counts_inventor = counts_inventor;
	}
	public String getCounts_holder() {
		return counts_holder;
	}
	public void setCounts_holder(String counts_holder) {
		this.counts_holder = counts_holder;
	}
	public String getCounts_application() {
		return counts_application;
	}
	public void setCounts_application(String counts_application) {
		this.counts_application = counts_application;
	}
	public String getCounts_announcement() {
		return counts_announcement;
	}
	public void setCounts_announcement(String counts_announcement) {
		this.counts_announcement = counts_announcement;
	}
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
	
	
	
	public ViewPatentVisual(PersistencePatentcount patentcount) {
		if(patentcount==null){
			return;
		}
		this.patent_inventor = patentcount.getPatent_inventor();
		this.patent_holder = patentcount.getPatent_holder();
		this.counts_inventor = patentcount.getCounts_inventor();
		this.counts_holder = patentcount.getCounts_holder();
		this.counts_application = patentcount.getCounts_application();
		this.counts_announcement = patentcount.getCounts_announcement();
		this.date_of_application = patentcount.getDate_of_application();
		this.annoucement_date = patentcount.getAnnouncement_date();
		this.province = patentcount.getProvince();
		this.date_year = patentcount.getDate_year();
		this.counts_year = patentcount.getCounts_year();
		this.counts_province = patentcount.getCounts_province();
	}
	@Override
	public String toString() {
		return "ViewPatentVisual [patent_inventor=" + patent_inventor + ", patent_holder=" + patent_holder
				+ ", date_year=" + date_year + ", counts_year=" + counts_year + ", counts_inventor=" + counts_inventor
				+ ", counts_holder=" + counts_holder + ", counts_application=" + counts_application
				+ ", counts_announcement=" + counts_announcement + ", counts_province=" + counts_province
				+ ", date_of_application=" + date_of_application + ", annoucement_date=" + annoucement_date + ", IPC="
				+ IPC + ", province=" + province + "]";
	}
	
	
	
	
		
}
