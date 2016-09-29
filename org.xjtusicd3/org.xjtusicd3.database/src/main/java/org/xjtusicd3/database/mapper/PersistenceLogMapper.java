package org.xjtusicd3.database.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistenceLog;
import org.xjtusicd3.database.model.PersistencePatent;



public interface PersistenceLogMapper extends IBaseDao<PersistencePatent, String> {
	
	@SuppressWarnings("rawtypes")
	@Select("select count(time) from log where time>=#{0} group by time ")
	public  ArrayList loginCount(long time3);

	@Select(" SELECT logId as logId ,ip as ip, userName as userName, operation as operation,argument as argument,time as time FROM log where userName=#{0} AND time>=#{1} AND time<=#{2}")
	public ArrayList<PersistenceLog> userLogByName(String name, String startTime, String endTime);
	@Select(" SELECT logId as logId ,ip as ip, userName as userName, operation as operation,argument as argument,time as time FROM log where ip=#{0} AND time>=#{1} AND time<=#{2}")
	public ArrayList<PersistenceLog> userLogByIp(String ip, String startTime, String endTime);

	@Select(" SELECT logId as logId ,ip as ip, userName as userName, operation as operation,argument as argument,time as time FROM log where  AND time>=#{0} AND time<=#{1}")
	public ArrayList<PersistenceLog> timeLog(String startTime, String endTime);

	
}
