package org.xjtusicd3.database.helper;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.PersistenceLogMapper;
import org.xjtusicd3.database.model.PersistenceLog;


public class LogHelper {
	
	@SuppressWarnings("rawtypes")
	public ArrayList loginCount(long time) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceLogMapper mapper = session.getMapper(PersistenceLogMapper.class);
		return mapper.loginCount(time);
	}

	public ArrayList<PersistenceLog> userLogByName(String name, String startTime, String endTime) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceLogMapper mapper = session.getMapper(PersistenceLogMapper.class);
		return mapper.userLogByName(name,startTime,endTime);
	}

	public ArrayList<PersistenceLog> userLogByIp(String ip, String startTime, String endTime) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceLogMapper mapper = session.getMapper(PersistenceLogMapper.class);
		return mapper.userLogByIp(ip,startTime,endTime);
	}

	public ArrayList<PersistenceLog> timeLog(String startTime, String endTime) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceLogMapper mapper = session.getMapper(PersistenceLogMapper.class);
		return mapper.timeLog(startTime,endTime);
	}
	
}
