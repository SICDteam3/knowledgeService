package org.xjtusicd3.database.model;

import org.xjtusicd3.database.ann.Table;
import org.xjtusicd3.database.ann.TableField;
import org.xjtusicd3.database.ann.TableKey;
import org.xjtusicd3.database.ann.TableKey.Strategy;

@Table(tablename="patent")
public class PersistencePatent {
	@TableKey(strategy = Strategy.NORMAL)
	@TableField(columnName="patentId")
	public int patentId;
	@TableField(columnName="number")
	private String number;
	@TableField(columnName="name")
	private String name;
	@TableField(columnName="patent_inventor")
	private String patent_inventor;
	@TableField(columnName="patent_holder")
	private String patent_holder;
	@TableField(columnName="date_of_application")
	private String date_of_application;
	@TableField(columnName="announcement_date")
	private String announcement_date;
	@TableField(columnName="patent_abstract")
	private String patent_abstract;
	@TableField(columnName="IPC")
	private String IPC;
	@TableField(columnName="type")
	private String type;
	@TableField(columnName="address")
	private String address;
	@TableField(columnName="patent_agency")
	private String patent_agency;
	@TableField(columnName="principal_claim")
	private String principal_claim;
	@TableField(columnName="province")
	private String province;
	@TableField(columnName="legal_status")
	private String legal_status;
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
		IPC = iPC;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
