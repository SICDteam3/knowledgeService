package org.xjtusicd3.database.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.PersistenceLogMapper;
import org.xjtusicd3.database.model.PersistenceLog;


public class LogHelper {
	
	
	
	
	
	@SuppressWarnings("rawtypes")
	public ArrayList loginCount(long time) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceLogMapper mapper = session.getMapper(PersistenceLogMapper.class);
		session.close();
		return mapper.loginCount(time);
		
	}

	public List<PersistenceLog> userLogByName(String name, long startTime, long endTime) {
		List<PersistenceLog> al = null;
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceLogMapper mapper = session.getMapper(PersistenceLogMapper.class);
		al=mapper.userLogByName(name,startTime,endTime);
		session.close();
		return al;
	}

	public ArrayList<PersistenceLog> userLogByIp(String ip, long startTime, long endTime) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceLogMapper mapper = session.getMapper(PersistenceLogMapper.class);
		return mapper.userLogByIp(ip,startTime,endTime);
	}

	public List<PersistenceLog> timeLog(long startTime, long endTime) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceLogMapper mapper = session.getMapper(PersistenceLogMapper.class);
		return mapper.timeLog(startTime,endTime);
	}
	
}
