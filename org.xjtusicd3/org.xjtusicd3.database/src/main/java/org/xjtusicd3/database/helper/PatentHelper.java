package org.xjtusicd3.database.helper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.PersistencePatentMapper;
import org.xjtusicd3.database.model.Page;
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


	public int[] count(long time2) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		int[] i=mapper.count(time2);
		session.close();
		return i;
	}
	

	public static List<PersistencePatent> getByname(String patentName,String patentTime){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		    String patentName1 = "%" + patentName + "%";
		    String patentTime1 = "%" + patentTime + "%";
		    List<PersistencePatent> l=mapper.getByname(patentName1, patentTime1);
		    session.close();
		    return l;
	}

	public  PersistencePatent detailCheck(String patentId) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		PersistencePatent p=mapper.detailCheck(patentId);
		session.close();
		return p;
	}

	public void delete(String patentId) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		mapper.deleteByUnmber(patentId);
		session.close();
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
		String newIPC = IPC + "%";
		List<PersistencePatent> patents =  mapper.select(newNumber, newName, newIPC);
		session.close();
		return patents;
	}
	/*
	 * 专利查询——专利号
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
	 * 专利查询——名称
	 */
	public static List<PersistencePatent> queryByName(String name){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newName = "%" + name + "%";
		List<PersistencePatent> patents =  mapper.selectByName(newName);
		session.close();
		return patents;
	}
	/*
	 * IPC——专利可视化——发明人
	 */
	public static List<PersistencePatentcount> rank_Inventor(String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newIPC = IPC + "%";
		List<PersistencePatentcount> rank_inventor = mapper.patent_inventor_desc(newIPC);
		session.close();
		return rank_inventor;
	}
	/*
	 * IPC——专利可视化——专权人
	 */
	public static List<PersistencePatentcount> rank_Holder(String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newIPC = IPC + "%";
		List<PersistencePatentcount> rank_holder = mapper.patent_holder_desc(newIPC);
		session.close();
		return rank_holder;
	}
	/*
	 * 专利查询——发明人名称
	 */
	public static List<PersistencePatent> queryByInventorName(String name){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newName = "%" + name + "%";
		List<PersistencePatent> patents =  mapper.selectByPatent_inventor(newName);
		session.close();
		return patents;
	}
	/*
	 * 专利查询——企业名称
	 */
	public static List<PersistencePatent> queryByHolderName(String name){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newName = "%" + name + "%";
		List<PersistencePatent> patents =  mapper.selectByPatent_holder(newName);
		session.close();
		return patents;
	}
	/*
	 * 专利查询——IPC
	 */
	public static List<PersistencePatent> queryByIPC(String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newIPC =  IPC + "%";
		List<PersistencePatent> patents =  mapper.selectByIPC(newIPC);
		session.close();
		return patents;
	}
	/*
	 * 专利查询——专家patent_inventor
	 */
	public static List<PersistencePatent> queryByPatent_inventor(String patent_inventor){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String selectAttr = patent_inventor + "%";
		List<PersistencePatent> patents =  mapper.selectByPatent_inventor(selectAttr);
		session.close();
		return patents;
	}
	/*
	 * 专利查询——企业patent_holder
	 */
	public static List<PersistencePatent> queryByPatent_holder(String patent_holder){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String selectAttr = patent_holder + "%";
		List<PersistencePatent> patents =  mapper.selectByPatent_holder(selectAttr);
		session.close();
		return patents;
	}

	/*
	 * IPC——专利可视化——申请时间
	 */
	public static List<PersistencePatentcount> rank_Application(String year,String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newyear = year+"%";
		String newIPC =  IPC + "%";
		List<PersistencePatentcount> rank_application = mapper.date_of_application_asc(newyear,newIPC);
		session.close();
		return rank_application;
	}
	/*
	 * IPC——专利可视化——发布时间
	 */
	public static List<PersistencePatentcount> rank_Announcement(String year,String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newyear =  year + "%";
		String newIPC =  IPC + "%";
		List<PersistencePatentcount> rank_announcement = mapper.announcement_date_asc(newyear,newIPC);
		session.close();
		return rank_announcement;
	}
	/*
	 * 专利数量逐年变化
	 */
	public static List<PersistencePatentcount> rank_Patent_yearnumber(String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newIPC =  IPC + "%";
		List<PersistencePatentcount> rank_patent_yearnumber = mapper.number_year_patent(newIPC);
		session.close();
		return rank_patent_yearnumber;
	}
	/*
	 *专利省份地图数量 
	 */
	public static List<PersistencePatentcount> number_Province(String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newIPC = IPC +"%";
		List<PersistencePatentcount> number_province = mapper.number_province(newIPC);
		session.close();
		return number_province;
	}
	
	/*
	 * IPC——专利可视化——企业专利数量
	 */
	public static List<PersistencePatentcount> rank_HolderPatentNumber(String patent_holder){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newpatent_holder = patent_holder;
		List<PersistencePatentcount> rank_holderpatentnumber = mapper.number_holderpatent(newpatent_holder);
		session.close();
		return rank_holderpatentnumber;
	}
	
	/*
	 * 接下来的代码真的非常恶心
	 */
	public static List<PersistencePatentcount> number_Beijing(String IPC){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newaddress = "%"+"北京"+"%";
		String newIPC = IPC + "%";
		List<PersistencePatentcount> number_beijing = mapper.number_provinces(newIPC,newaddress);
		session.close();
		return number_beijing;
	}
	
	//这块代码没用到，是用来做通用分页模板的。
	public static Page<PersistencePatent> getPage() {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		Page<PersistencePatent> page = new Page<PersistencePatent>();
		page.setSearchCondition("name like '%一种%'");
		List<PersistencePatent>list = mapper.list_page(PersistencePatent.class, page);
		page.setResults(list);
		//TODO 分页模板报错
		session.close();
		return page;
	}
	
	public static void main(String[] args) {
		getPage();
	}


	public static int getCount(String context) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newName = "%" + context + "%";
		int count =  mapper.selectByNameCount(newName);
		session.close();
		
		return count;
	}


	public static int getCount2(String context) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newName = "%" + context + "%";
		int count =  mapper.selectByNumberCount(newName);
		session.close();
		
		return count;
	}
	public static int getCount3(String context) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newName = "%" + context + "%";
		int count =  mapper.selectByInventorCount(newName);
		session.close();
		
		return count;
	}
	public static int getCount4(String context) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newName = "%" + context + "%";
		int count =  mapper.selectByHolderCount(newName);
		session.close();
		
		return count;
	}


	public static List<PersistencePatent> getPageList(int pageNo, int pageSize, String context) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newName = "%" + context + "%";
		List<PersistencePatent> patents =  mapper.selectPageByName(pageNo,pageSize,newName);
		session.close();
		return patents;
	}
	public static List<PersistencePatent> getPageList2(int pageNo, int pageSize, String context) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newName = "%" + context + "%";
		List<PersistencePatent> patents =  mapper.selectPageByName2(pageNo,pageSize,newName);
		session.close();
		return patents;
	}
	public static List<PersistencePatent> getPageList3(int pageNo, int pageSize, String context) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newName = "%" + context + "%";
		List<PersistencePatent> patents =  mapper.selectPageByName3(pageNo,pageSize,newName);
		session.close();
		return patents;
	}
	public static List<PersistencePatent> getPageList4(int pageNo, int pageSize, String context) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		String newName = "%" + context + "%";
		List<PersistencePatent> patents =  mapper.selectPageByName4(pageNo,pageSize,newName);
		session.close();
		return patents;
	}

	public static int getCount1(String patentName, String patentTime) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		 String patentName1 = "%" + patentName + "%";
		 String patentTime1 = "%" + patentTime + "%";
		int count =  mapper.selectByNameCount1(patentName1,patentTime1);
		session.close();
		return count;
	}


	public static List<PersistencePatent> getPageListhh(int i, int pageSize, String patentName, String patentTime) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistencePatentMapper mapper = session.getMapper(PersistencePatentMapper.class);
		    String patentName1 = "%" + patentName + "%";
		    String patentTime1 = "%" + patentTime + "%";
		    List<PersistencePatent> l=mapper.getByname1(patentName1, patentTime1,i,pageSize);
		    session.close();
		    return l;
		
	}


	
}
