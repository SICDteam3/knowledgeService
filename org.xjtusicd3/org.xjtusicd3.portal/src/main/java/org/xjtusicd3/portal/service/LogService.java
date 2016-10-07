package org.xjtusicd3.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.xjtusicd3.database.helper.LogHelper;
import org.xjtusicd3.database.model.Page;
import org.xjtusicd3.database.model.PersistenceLog;


public class LogService {

	
	
	/*
	 * 根據用戶名查找用戶日誌
	 * */
	public static List<PersistenceLog> userLogByName(String name, long startTime, long endTime) {
		LogHelper lh=new LogHelper();
		List<PersistenceLog> al=new ArrayList<PersistenceLog>();
		al=lh.userLogByName(name,startTime,endTime);
		return al;
	}

	/*
	 * 根據用戶登錄IP找用戶日誌
	 * */
	public static ArrayList<PersistenceLog> userLogByIp(String ip, long startTime, long endTime) {
        LogHelper lh=new LogHelper();
		return lh.userLogByIp(ip,startTime,endTime);
	}

	/*
	 * 按時間查詢日誌
	 * */
	public static List<PersistenceLog> timeLog(long startTime, long endTime) {
		 LogHelper lh=new LogHelper();
		 return lh.timeLog(startTime,endTime);
	}

	public Page<PersistenceLog> userLog(Page<PersistenceLog> page, String name, long timeStemp, long timeStemp1) {
		int count = LogHelper.getCount1(name,timeStemp,timeStemp1);
		List<PersistenceLog> results = LogHelper.getPageList((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),timeStemp,timeStemp1,name);
		int totalPage = (int) Math.ceil((double)count/page.getPageSize());
		page.setResults(results);
		page.setTotalRecord(count);
		page.setTotalPage(totalPage);
		return page;
	
	}

	

}
