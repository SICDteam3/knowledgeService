package org.xjtusicd3.database.helper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.PersistencePatentMapper;
import org.xjtusicd3.database.model.PersistencePatent;



public class PatentHelper {
	public static List<PersistencePatent> getRecord(int start,int end) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		List<PersistencePatent> records =  mapper.getpatent(start, end);
		session.close();
		return records;
	}
	/*
	 * 
	 */
	public static List<PersistencePatent> query(String number,String name,String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newNumber = "%" + number + "%";
		String newName = "%" + name + "%";
		String newIPC = "%" + IPC + "%";
		List<PersistencePatent> patents =  mapper.select(newNumber, newName, newIPC);
		session.close();
		return patents;
	}
}
