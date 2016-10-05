package org.xjtusicd3.database.mapper;

import org.apache.ibatis.annotations.Insert;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistenceBlackList;

public interface PersistenceDictionaryMapper extends IBaseDao<PersistenceBlackList, String>{
	
	
	@Insert("INSERT INTO data_dictionary VALUES (NULL,#{0}, #{1})")
	public void addDictionary(String name, String value);
}
