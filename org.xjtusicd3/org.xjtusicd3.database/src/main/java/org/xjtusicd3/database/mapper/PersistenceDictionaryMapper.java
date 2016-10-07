package org.xjtusicd3.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistenceBlackList;
import org.xjtusicd3.database.model.PersistenceDictionary;

public interface PersistenceDictionaryMapper extends IBaseDao<PersistenceBlackList, String>{
	
	
	@Insert("INSERT INTO data_dictionary VALUES (NULL,#{0}, #{1})")
	public void addDictionary(String name, String value);


	@Select("SELECT dictionaryId as dictionaryId ,dictionaryName as dictionaryName, dictionaryValue as dictionaryValue FROM data_dictionary")
	public List<PersistenceDictionary> dictionarySearch();
	

    @Delete("DELETE FROM data_dictionary WHERE dictionaryId=#{0}")
	public void deleteDictionary(int id);

    @Select("select count(dictionaryId) from data_dictionary ")
	public int count();

    
    @Select("SELECT dictionaryId as dictionaryId ,dictionaryName as dictionaryName, dictionaryValue as dictionaryValue FROM data_dictionary limit #{0},#{1}")
	public List<PersistenceDictionary> selectPageByName(int i, int pageSize);
}
