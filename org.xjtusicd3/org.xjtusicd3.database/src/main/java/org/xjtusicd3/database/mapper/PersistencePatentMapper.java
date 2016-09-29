package org.xjtusicd3.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistencePatent;


public interface PersistencePatentMapper extends IBaseDao<PersistencePatent, String>{
	@Select(" SELECT id as id ,number as patentID, name as name, abstract as patentabstract FROM patent where id limit #{0},#{1}")
	public List<PersistencePatent> getpatent(int start,int end);
	/*
	 * 搜索
	 */
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_invertor as patent_invertor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,prinvipal_claim as prinvipal_claim,province as province,legal_status as legal_status FROM patent WHERE number like #{0} AND name like #{1} AND IPC like #{2}"})
	public abstract List<PersistencePatent> select(String paramString1,String paramString2,String paramString3);
	/*
	 * 发明人排名由大到小前30
	 */
	@Select({"SELECT patent_inventor as patent_inventor,count(*) as counts FROM patent WHERE IPC LIKE #{0} GROUP BY patent_inventor ORDER BY counts DESC LIMIT 30"})
	public abstract List patent_inventor_desc(String paramString);
	/*
	 * 专利权人排名由大到小前30
	 */
	@Select({"SELECT patent_holder as patent_holder,count(*) as counts2 FROM patent WHERE IPC LIKE #{0} GROUP BY patent_holder ORDER BY counts2 DESC LIMIT 30"})
	public abstract List patent_holder_desc(String paramString);
	/*
	 * 申请日期
	 */
	@Select({"SELECT SUBSTRING(date_of_application,1,7),count(*) as counts3 FROM patent WHERE IPC LIKE #{0} GROUP BY date_of_application ORDER BY ASC"})
	public abstract List date_of_application_asc(String paramString);
	/*
	 * 公告日期
	 */
	@Select({"SELECT SUBSTRING(announcement_date,1,7),count(*) as counts4 FROM patent WHERE IPC LIKE #{0} GROUP BY announcement_date ORDER BY ASC"})
	public abstract List announcement_date_asc(String paramString);
	/*
	 * 省市、专权人气泡图
	 */
	@Select({"SELECT patent_holder as patent_holder,count(*) as counts4 FROM patent WHERE IPC LIKE #{0} GROUP BY province "})
	public abstract List popo(String paramString);
	/*
	 * 企业专利数量
	 */
	@Select({"SELECT patent_holder as patent_holder,province as province,count(*) as counts FROM patent WHERE patent_holder LIKE #{0} GROUP BY province"})
	public abstract List number_holderpatent(String paramString);
}

