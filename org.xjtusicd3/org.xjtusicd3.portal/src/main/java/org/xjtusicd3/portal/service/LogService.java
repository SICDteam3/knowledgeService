package org.xjtusicd3.portal.service;

import java.util.ArrayList;

import org.xjtusicd3.database.helper.LogHelper;
import org.xjtusicd3.database.model.PersistenceLog;

public class LogService {

	
	/*
	 * 根據用戶名查找用戶日誌
	 * */
	public ArrayList<PersistenceLog> userLogByName(String name, String startTime, String endTime) {
		LogHelper lh=new LogHelper();
		return lh.userLogByName(name,startTime,endTime);
	}

	/*
	 * 根據用戶登錄IP找用戶日誌
	 * */
	public ArrayList<PersistenceLog> userLogByIp(String ip, String startTime, String endTime) {
        LogHelper lh=new LogHelper();
		return lh.userLogByIp(ip,startTime,endTime);
	}

	/*
	 * 按時間查詢日誌
	 * */
	public ArrayList<PersistenceLog> timeLog(String startTime, String endTime) {
		 LogHelper lh=new LogHelper();
		 return lh.timeLog(startTime,endTime);
	}

}
