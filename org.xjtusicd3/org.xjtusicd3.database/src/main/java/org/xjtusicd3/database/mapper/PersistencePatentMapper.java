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
	public int[] count(long time2);

	@Select({"SELECT patentId as patentId,number as number,name as name,IPC as IPC,address as address,patent_inventor as patent_inventor,patent_holder as patent_holder,"
			+"date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,type as type,patent_agency as patent_agency,patent_agency as patent_agency,"
			+"principal_claim as principal_claim, province as province,legal_status as legal_status FROM patent WHERE name like #{0} AND date_of_application like #{1} "})
	public List<PersistencePatent> getByname(String patentName,String patentTime);
	
	@Select({"SELECT patentId as patentId,number as number,name as name,IPC as IPC,address as address,patent_inventor as patent_inventor,patent_holder as patent_holder,"
			+"date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,type as type,patent_agency as patent_agency,patent_agency as patent_agency,"
			+"principal_claim as principal_claim, province as province,legal_status as legal_status FROM patent WHERE name like #{0} AND date_of_application like #{1} limit #{2},#{3}"})
	public List<PersistencePatent> getByname1(String patentName1, String patentTime1, int i, int pageSize);

	@Select({"SELECT patentId as patentId,number as number,name as name,IPC as IPC,address as address,patent_inventor as patent_inventor,patent_holder as patent_holder,"
			+"date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,type as type,patent_agency as patent_agency,patent_agency as patent_agency,"
			+"principal_claim as principal_claim, province as province,legal_status as legal_status FROM patent WHERE  patentId=#{0}"})
	public PersistencePatent detailCheck(String patentId);

	@Delete("DELETE FROM patent WHERE patentId = #{patentId}")
	public void deleteByUnmber(String patentId);
	
	

	/*
	 * 搜索
	 */
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_inventor as patent_inventor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,principal_claim as principal_claim,province as province,legal_status as legal_status FROM patent WHERE number like #{0} AND name like #{1} AND IPC like #{2}"})
	public  List<PersistencePatent> select(String paramString1,String paramString2,String paramString3);
	/*
	 * 搜索-名称
	 */
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_inventor as patent_inventor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,principal_claim as principal_claim,province as province,legal_status as legal_status FROM patent WHERE name like #{0}"})
	public abstract List<PersistencePatent> selectByName(String paramString);
	/*
	 * 搜索-专利号
	 */
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_inventor as patent_inventor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,principal_claim as principal_claim,province as province,legal_status as legal_status FROM patent WHERE number like #{0}"})
	public abstract List<PersistencePatent> selectByNumber(String paramString);
	/*
	 * 搜索-IPC
	 */
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_inventor as patent_inventor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,principal_claim as principal_claim,province as province,legal_status as legal_status FROM patent WHERE IPC like #{0}"})
	public abstract List<PersistencePatent> selectByIPC(String paramString);
	/*
	 * 搜索—专家patent_inventor
	 */
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_inventor as patent_inventor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,principal_claim as principal_claim,province as province,legal_status as legal_status FROM patent WHERE patent_inventor like #{0}"})
	public abstract List<PersistencePatent> selectByPatent_inventor(String paramString);
	/*
	 * 搜索—企业patent_holder
	 */
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_inventor as patent_inventor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,principal_claim as principal_claim,province as province,legal_status as legal_status FROM patent WHERE patent_holder like #{0}"})
	public abstract List<PersistencePatent> selectByPatent_holder(String paramString);
	
	/*
	 * 发明人排名由大到小前10
	 */
	@Select({"SELECT patent_inventor as patent_inventor,count(*) as counts_inventor FROM patent WHERE IPC LIKE #{0} GROUP BY patent_inventor ORDER BY counts_inventor DESC LIMIT 10"})
	public List<PersistencePatentcount> patent_inventor_desc(String paramString);
	/*
	 * 专利权人排名由大到小前10
	 */
	@Select({"SELECT patent_holder as patent_holder,count(*) as counts_holder FROM patent WHERE IPC LIKE #{0} GROUP BY patent_holder ORDER BY counts_holder DESC LIMIT 10"})
	public List<PersistencePatentcount> patent_holder_desc(String paramString);
	/*
	 * 逐年专利数量
	 */
	@Select({"SELECT SUBSTRING(announcement_date FROM 1 FOR 5) as date_year,count(*) as counts_year FROM patent WHERE IPC LIKE #{0} GROUP BY date_year"})
	public List<PersistencePatentcount> number_year_patent(String paramString);
	/*
	 * 省份专利查询-IPC
	 */
	@Select({"SELECT SUBSTRING(address FROM 1 FOR 3) as address1,COUNT(*) as counts_province FROM patent  WHERE IPC LIKE #{0} GROUP BY address1"})
	public List<PersistencePatentcount> number_province(String paramString);
	/*
	 * 申请日期
	 */
	@Select({"SELECT count(*) as counts_application FROM patent WHERE date_of_application LIKE #{0} AND IPC LIKE #{1}"})
	public List<PersistencePatentcount> date_of_application_asc(String paramString1,String paramString2);
	/*
	 * 公告日期
	 */
	@Select({"SELECT count(*) as counts_announcement FROM patent WHERE announcement_date LIKE #{0} AND IPC LIKE #{1}"})
	public List<PersistencePatentcount> announcement_date_asc(String paramString1,String paramString2);
	/*
	 * 省市、专权人气泡图
	 */
	@Select({"SELECT patent_holder as patent_holder,province as province,count(*) as counts_holder FROM patent WHERE IPC LIKE #{0} GROUP BY province ORDER BY patent_holder DESC "})
	public List<PersistencePatentcount> popo(String paramString);
	/*
	 * 企业专利数量
	 */
	@Select({"SELECT SUBSTRING(announcement_date FROM 1 FOR 5) AS date_year,count(*) as counts_year FROM patent WHERE patent_holder=#{0} GROUP BY date_year"})
	public List<PersistencePatentcount> number_holderpatent(String paramString);
	/*
	 * 接下来的部分非常的恶心
	 */
	@Select({"SELECT count(*) FROM patent WHERE IPC LIKE #{0} AND address LIKE #{1}"})
	public List<PersistencePatentcount> number_provinces(String pramString1,String paramString2);
	
	@Select({"SELECT count(*) FROM patent WHERE name like #{0}"})
	public int selectByNameCount(String newName);


	@Select({"SELECT count(*) FROM patent WHERE number like #{0}"})
	public int selectByNumberCount(String newName);
	
	@Select({"SELECT count(*) FROM patent WHERE patent_inventor like #{0}"})
	public int selectByInventorCount(String newName);
	
	@Select({"SELECT count(*) FROM patent WHERE patent_holder like #{0}"})
	public int selectByHolderCount(String newName);


	@Select({"SELECT patentId as patentId,number as number,name as name,patent_inventor as patent_inventor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,principal_claim as principal_claim,province as province,legal_status as legal_status FROM patent WHERE name like #{2} limit #{0},#{1}"})
	public List<PersistencePatent> selectPageByName(int pageNo, int pageSize, String context);
	
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_inventor as patent_inventor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,principal_claim as principal_claim,province as province,legal_status as legal_status FROM patent WHERE number like #{2} limit #{0},#{1}"})
	public List<PersistencePatent> selectPageByName2(int pageNo, int pageSize, String context);

	@Select({"SELECT patentId as patentId,number as number,name as name,patent_inventor as patent_inventor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,principal_claim as principal_claim,province as province,legal_status as legal_status FROM patent WHERE patent_inventor like #{2} limit #{0},#{1}"})
	public List<PersistencePatent> selectPageByName3(int pageNo, int pageSize, String context);
	
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_inventor as patent_inventor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,principal_claim as principal_claim,province as province,legal_status as legal_status FROM patent WHERE patent_holder like #{2} limit #{0},#{1}"})
	public List<PersistencePatent> selectPageByName4(int pageNo, int pageSize, String context);
	
	@Select({"SELECT count(*) FROM patent WHERE name like #{0} AND date_of_application like #{1}"})
	public int selectByNameCount1(String patentName, String patentTime);



}

