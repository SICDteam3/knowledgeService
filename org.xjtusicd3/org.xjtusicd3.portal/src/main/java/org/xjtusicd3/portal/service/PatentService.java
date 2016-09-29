package org.xjtusicd3.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.xjtusicd3.database.helper.PatentHelper;
import org.xjtusicd3.database.model.PersistencePatent;
import org.xjtusicd3.portal.view.ViewPatent;



public class PatentService {

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
	
	/*
	 * 查看专利详情
	 * */
	public PersistencePatent detailCheck(String IPC){
		PatentHelper ph=new PatentHelper();
		return ph.detailCheck(IPC); 
	}
	
	/*
     * 删除专利
     */
	public void pantentDelete(String IPC) {
		PatentHelper ph=new PatentHelper();
		ph.delete(IPC);
		return; 
		
	}
}
