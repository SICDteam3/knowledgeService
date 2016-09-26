package org.xjtusicd3.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistencePatent;


public interface PersistencePatentMapper extends IBaseDao<PersistencePatent, String>{
	@Select(" SELECT id as id ,number as patentID, name as name, abstract as patentabstract FROM patent where id limit #{0},#{1}")
	public List<PersistencePatent> getpatent(int start,int end);
	
}
