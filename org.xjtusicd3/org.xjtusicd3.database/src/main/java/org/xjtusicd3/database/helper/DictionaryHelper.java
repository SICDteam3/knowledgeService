package org.xjtusicd3.database.helper;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.PersistenceDictionaryMapper;


public class DictionaryHelper {

	public void addDictionary(String name,String value) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceDictionaryMapper mapper = session.getMapper(PersistenceDictionaryMapper.class);
		mapper.addDictionary(name,value);
		session.close();
		
		
	}

	@SuppressWarnings("rawtypes")
	public List dictionarySearch() {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceDictionaryMapper mapper = session.getMapper(PersistenceDictionaryMapper.class);
		List ds=mapper.dictionarySearch();
		return ds;
	}

	public void deleteDictionary(int id) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceDictionaryMapper mapper = session.getMapper(PersistenceDictionaryMapper.class);
		mapper.deleteDictionary(id);
	}
}
