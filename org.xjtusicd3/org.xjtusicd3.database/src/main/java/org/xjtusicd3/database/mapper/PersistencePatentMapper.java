package org.xjtusicd3.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistencePatent;


public interface PersistencePatentMapper extends IBaseDao<PersistencePatent, String>{
	@Select(" SELECT id as id ,number as patentID, name as name, abstract as patentabstract FROM patent where id limit #{0},#{1}")
	public List<PersistencePatent> getpatent(int start,int end);
	
	@Select({"SELECT patentId as patentId,number as number,name as name,patent_invertor as patent_invertor,patent_holder as patent_holder,date_of_application as date_of_application,announcement_date as announcement_date,patent_abstract as patent_abstract,IPC as IPC,type as type,address as address,patent_agency as patent_agency,prinvipal_claim as prinvipal_claim,province as province,legal_status as legal_status FROM patent WHERE number like #{0} AND name like #{1} AND IPC like #{2}"})
	public abstract List<PersistencePatent> select(String paramString1,String paramString2,String paramString3);
}
