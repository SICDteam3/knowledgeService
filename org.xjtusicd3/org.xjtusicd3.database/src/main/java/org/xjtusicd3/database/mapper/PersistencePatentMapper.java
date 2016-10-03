package org.xjtusicd3.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistencePatent;
import org.xjtusicd3.database.model.PersistencePatentcount;


public interface PersistencePatentMapper extends IBaseDao<PersistencePatent, String>{
	@Select(" SELECT id as id ,number as patentID, name as name, abstract as patentabstract FROM patent where id limit #{0},#{1}")
	public List<PersistencePatent> getpatent(int start,int end);


	
	@Select("select count(time) from scrapy where time>=#{0} group by time ")
	public int count(long time2);

	@Select({"SELECT patent_id as patent_id,number as number,name as name,IPC as IPC,address as address,patent_inventor as patent_inventor,patent_holder as patent_holder "
			+ "date_of_application as date_of_application，announcement_date as announcement_date，patent_abstract as patent_abstract，type as type，patent_agency as patent_agency，patent_agency as patent_agency "
			+ "principal_claim as principal_claim， province as province， legal_status as legal_status FROM patent WHERE patentName  like #{0} AND patentTime like #{1}"})
	public List<PersistencePatent> getByname(String patentName,String patentTime);

	@Select({"SELECT patent_id as patent_id,number as number,name as name,IPC as IPC,address as address,patent_inventor as patent_inventor,patent_holder as patent_holder "
			+ "date_of_application as date_of_application，announcement_date as announcement_date，patent_abstract as patent_abstract，type as type，patent_agency as patent_agency，patent_agency as patent_agency "
			+ "principal_claim as principal_claim， province as province， legal_status as legal_status FROM patent WHERE patentName  IPC=#{0}"})
	public PersistencePatent detailCheck(String IPC);

	@Delete("DELETE FROM patent WHERE IPC = #{iPC}")
	public void deleteByIPC(String iPC);
	
	

	/*
	 * 搜索
	 */
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_invertor as patent_invertor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,prinvipal_claim as prinvipal_claim,province as province,legal_status as legal_status FROM patent WHERE number like #{0} AND name like #{1} AND IPC like #{2}"})
	public  List<PersistencePatent> select(String paramString1,String paramString2,String paramString3);
	/*
	 * 搜索-名称
	 */
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_invertor as patent_invertor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,prinvipal_claim as prinvipal_claim,province as province,legal_status as legal_status FROM patent WHERE name like #{0}"})
	public abstract List<PersistencePatent> selectByName(String paramString);
	/*
	 * 搜索-专利号
	 */
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_invertor as patent_invertor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,prinvipal_claim as prinvipal_claim,province as province,legal_status as legal_status FROM patent WHERE number like #{0}"})
	public abstract List<PersistencePatent> selectByNumber(String paramString);
	/*
	 * 搜索-IPC
	 */
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_invertor as patent_invertor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,prinvipal_claim as prinvipal_claim,province as province,legal_status as legal_status FROM patent WHERE IPC like #{0}"})
	public abstract List<PersistencePatent> selectByIPC(String paramString);
	/*
	 * 发明人排名由大到小前10
	 */
	@Select({"SELECT patent_inventor as patent_inventor,count(*) as counts FROM patent WHERE IPC LIKE #{0} GROUP BY patent_inventor ORDER BY counts DESC LIMIT 10"})
	public List<PersistencePatentcount> patent_inventor_desc(String paramString);
	/*
	 * 专利权人排名由大到小前30
	 */
	@Select({"SELECT patent_holder as patent_holder,count(*) as counts2 FROM patent WHERE IPC LIKE #{0} GROUP BY patent_holder ORDER BY counts2 DESC LIMIT 30"})
	public List<PersistencePatentcount> patent_holder_desc(String paramString);
	/*
	 * 申请日期
	 */
	@Select({"SELECT SUBSTRING(date_of_application,1,7),count(*) as counts3 FROM patent WHERE IPC LIKE #{0} GROUP BY date_of_application ORDER BY ASC"})
	public List<PersistencePatentcount> date_of_application_asc(String paramString);
	/*
	 * 公告日期
	 */
	
	@Select({"SELECT SUBSTRING(announcement_date,1,7),count(*) as counts4 FROM patent WHERE IPC LIKE #{0} GROUP BY announcement_date ORDER BY ASC"})
	public List<PersistencePatentcount> announcement_date_asc(String paramString);
	/*
	 * 省市、专权人气泡图
	 */
	@Select({"SELECT patent_holder as patent_holder,count(*) as counts4 FROM patent WHERE IPC LIKE #{0} GROUP BY province "})
	public List<PersistencePatentcount> popo(String paramString);
	/*
	 * 企业专利数量
	 */
	@Select({"SELECT patent_holder as patent_holder,province as province,count(*) as counts FROM patent WHERE patent_holder LIKE #{0} GROUP BY province"})
	public List<PersistencePatentcount> number_holderpatent(String paramString);




}

