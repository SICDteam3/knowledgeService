package org.xjtusicd3.database.helper;



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
}
