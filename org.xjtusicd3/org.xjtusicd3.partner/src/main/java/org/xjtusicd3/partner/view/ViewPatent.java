package org.xjtusicd3.partner.view;

import org.xjtusicd3.database.model.PersistencePatent;

public class ViewPatent {
	private int patentId;
	private String number;
	private String name;
	private String patent_inventor;
	private String patent_holder;
	private String date_of_application;
	private String announcement_date;
	private String patent_abstract;
	private String IPC;
	private String address;
	private String patent_agency;
	private String principal_claim;
	private String province;
	private String legal_status;
	private String type;
	
	
	


	public ViewPatent(PersistencePatent patent){
		if(patent==null){
			return;
		}
		this.patentId = patent.getPatentId();
		this.name = patent.getName();
		this.patent_inventor = patent.getPatent_inventor();
		this.patent_holder = patent.getPatent_holder();
		this.date_of_application = patent.getDate_of_application();
		this.announcement_date = patent.getAnnouncement_date();
		this.patent_abstract = patent.getPatent_abstract();
		this.IPC = patent.getIPC();
		this.address = patent.getAddress();
		this.patent_agency = patent.getPatent_agency();
		this.principal_claim = patent.getPrincipal_claim();
		this.province = patent.getProvince();
		this.legal_status = patent.getLegal_status();
		this.number=patent.getNumber();
		this.type=patent.getType();
		
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPatentId() {
		return patentId;
	}
	public void setPatentId(int patentId) {
		this.patentId = patentId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDate_of_application() {
		return date_of_application;
	}
	public void setDate_of_application(String date_of_application) {
		this.date_of_application = date_of_application;
	}
	public String getAnnouncement_date() {
		return announcement_date;
	}
	public void setAnnouncement_date(String announcement_date) {
		this.announcement_date = announcement_date;
	}
	public String getPatent_abstract() {
		return patent_abstract;
	}
	public void setPatent_abstract(String patent_abstract) {
		this.patent_abstract = patent_abstract;
	}
	public String getIPC() {
		return IPC;
	}
	public void setIPC(String iPC) {
		this.IPC = iPC;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPatent_agency() {
		return patent_agency;
	}
	public void setPatent_agency(String patent_agency) {
		this.patent_agency = patent_agency;
	}
	public String getPrincipal_claim() {
		return principal_claim;
	}
	public void setPrincipal_claim(String principal_claim) {
		this.principal_claim = principal_claim;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getLegal_status() {
		return legal_status;
	}
	public void setLegal_status(String legal_status) {
		this.legal_status = legal_status;
	}
	
}
