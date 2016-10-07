package org.xjtusicd3.database.helper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.PersistenceIPCMapper;
import org.xjtusicd3.database.model.PersistenceIPC;

public class IPCHelper {

	public static List<PersistenceIPC> getFirtLevel(int level) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceIPCMapper mapper = session.getMapper(PersistenceIPCMapper.class);
	
		List<PersistenceIPC> list = mapper.getFisrtLevel(level);
		session.close();
		return list;
	}

	public static List<PersistenceIPC> getNextLevel(String classId) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceIPCMapper mapper = session.getMapper(PersistenceIPCMapper.class);
	
		List<PersistenceIPC> list = mapper.getNextLevel(classId);
		session.close();
		return list;
	}

}
