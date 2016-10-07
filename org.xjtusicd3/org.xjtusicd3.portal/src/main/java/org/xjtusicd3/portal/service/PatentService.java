package org.xjtusicd3.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.xjtusicd3.database.helper.PatentHelper;
import org.xjtusicd3.database.model.Page;
import org.xjtusicd3.database.model.PersistencePatent;
import org.xjtusicd3.portal.view.ViewPatent;



public class PatentService {

	public static void main(String[] args) {
		PatentService ps=new PatentService();
		
	    System.out.println(ps.getByname("手", ""));
	}
	
	
	public  List<ViewPatent> getByname(String patentName,String patentTime){
		    List<ViewPatent> listgoods = new ArrayList<ViewPatent>();
		    List<PersistencePatent> patent = PatentHelper.getByname(patentName, patentTime);
		    if (patent == null) {
		      return null;
		    }
		    for (PersistencePatent persistencePatent : patent)
		    {
		      ViewPatent viewGoods = new ViewPatent(persistencePatent);
		      listgoods.add(viewGoods);
		    }
		    return listgoods;
	
	}
	
	public static Page<PersistencePatent> selectByName(String context, Page<PersistencePatent> page) {
		int count = PatentHelper.getCount(context);
		List<PersistencePatent> results = PatentHelper.getPageList((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),context);
		int totalPage = (int) Math.ceil((double)count/page.getPageSize());
		page.setResults(results);
		page.setTotalRecord(count);
		page.setTotalPage(totalPage);
		return page;
	}
	public Page<PersistencePatent> searchPatnet(Page<PersistencePatent> page, String patentName, String patentTime) {
		int count = PatentHelper.getCount1(patentName,patentTime);
		List<PersistencePatent> results = PatentHelper.getPageListhh((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),patentName,patentTime);
		int totalPage = (int) Math.ceil((double)count/page.getPageSize());
		page.setResults(results);
		page.setTotalRecord(count);
		page.setTotalPage(totalPage);
		return page;
	}
	
	/*
	 * 查看专利详情
	 * */
	public PersistencePatent detailCheck(String patentId){
		PatentHelper ph=new PatentHelper();
		return ph.detailCheck(patentId); 
	}
	
	/*
     * 删除专利
     */
	public void pantentDelete(String patentId) {
		PatentHelper ph=new PatentHelper();
		ph.delete(patentId);
		return; 
		
	}



}
