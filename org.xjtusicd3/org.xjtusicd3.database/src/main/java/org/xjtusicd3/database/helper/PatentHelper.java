package org.xjtusicd3.database.helper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.PersistencePatentMapper;
import org.xjtusicd3.database.model.PersistencePatent;
import org.xjtusicd3.database.model.PersistencePatentcount;



public class PatentHelper {
	public static List<PersistencePatent> getRecord(int start,int end) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		List<PersistencePatent> records =  mapper.getpatent(start, end);
		session.close();
		return records;
	}


	public int count(long time2) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		return mapper.count(time2);
	}
	

	public static List<PersistencePatent> getByname(String patentName,String patentTime){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		    String patentName1 = "%" + patentName + "%";
		    String patentTime1 = "%" + patentTime + "%";
		    session.close();
		 return mapper.getByname(patentName1, patentTime1);
	}

	public  PersistencePatent detailCheck(String IPC) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		return mapper.detailCheck(IPC);
	}

	public void delete(String iPC) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		mapper.deleteByIPC(iPC);
		return;
	}

	/*
	 * 专利查询
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
	/*
	 * 专利查询-专利号
	 */
	public static List<PersistencePatent> queryByNumber(String number){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newNumber = "%" + number + "%";
		List<PersistencePatent> patents =  mapper.selectByNumber(newNumber);
		session.close();
		return patents;
	}
	/*
	 * 专利查询-名称
	 */
	public static List<PersistencePatent> queryByName(String name){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newName = "%" + name + "%";
		List<PersistencePatent> patents =  mapper.selectByName(name);
		session.close();
		return patents;
	}
	/*
	 * 专利查询-IPC
	 */
	public static List<PersistencePatent> queryByIPC(String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newIPC = "%" + IPC + "%";
		List<PersistencePatent> patents =  mapper.selectByIPC(IPC);
		session.close();
		return patents;
	}
	/*
	 * IPC-专利可视化-发明人
	 */
	public static List<PersistencePatentcount> rank_Inventor(String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		List<PersistencePatentcount> rank_inventor = mapper.patent_inventor_desc(IPC);
		session.close();
		return rank_inventor;
	}
	/*
	 * IPC-专利可视化-专权人
	 */
	public static List<PersistencePatentcount> rank_Holder(String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		List<PersistencePatentcount> rank_holder = mapper.patent_holder_desc(IPC);
		session.close();
		return rank_holder;
	}
	/*
	 * IPC-专利可视化-申请时间
	 */
	public static List<PersistencePatentcount> rank_Application(String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		List<PersistencePatentcount> rank_application = mapper.date_of_application_asc(IPC);
		session.close();
		return rank_application;
	}
	/*
	 * IPC-专利可视化-申请时间
	 */
	public static List<PersistencePatentcount> rank_Announcement(String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		List<PersistencePatentcount> rank_announcement = mapper.announcement_date_asc(IPC);
		session.close();
		return rank_announcement;
	}
	/*
	 * IPC-专利可视化-省市和专权人气泡图
	 */
	public static List<PersistencePatentcount> popo_ProvinceHolder(String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		List<PersistencePatentcount> popo_provinceholder = mapper.popo(IPC);
		session.close();
		return popo_provinceholder;
	}
	/*
	 * IPC-专利可视化-企业专利数量
	 */
	public static List<PersistencePatentcount> rank_HolderPatentNumber(String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		List<PersistencePatentcount> rank_holderpatentnumber = mapper.number_holderpatent(IPC);
		session.close();
		return rank_holderpatentnumber;
	}
	

}
