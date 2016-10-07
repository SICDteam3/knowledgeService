package org.xjtusicd3.database.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistenceLog;
import org.xjtusicd3.database.model.PersistencePatent;



public interface PersistenceLogMapper extends IBaseDao<PersistencePatent, String> {
	
	@SuppressWarnings("rawtypes")
	@Select("select count(time) from log where time>=#{0} group by time ")
	public  ArrayList loginCount(long time3);

	@Select(" SELECT logId as logId ,ip as ip, userName as userName, operation as operation,argument as argument,time as time FROM log where userName=#{0} AND time>=#{1} AND time<=#{2}")
	public List<PersistenceLog> userLogByName(String name, long startTime, long endTime);
	

	
	@Select(" SELECT logId as logId ,ip as ip, userName as userName, operation as operation,argument as argument,time as time FROM log where ip=#{0} AND time>=#{1} AND time<=#{2}")
	public ArrayList<PersistenceLog> userLogByIp(String ip, long startTime, long endTime);

	@Select(" SELECT logId as logId ,ip as ip, userName as userName, operation as operation,argument as argument,time as time FROM log where   time>=#{0} AND time<=#{1}")
	public ArrayList<PersistenceLog> timeLog(long startTime, long endTime);

	@Select({"SELECT count(*) FROM log WHERE userName=#{0} AND time>=#{1} AND time<=#{2}"})
	public int getCount(String name, long timeStemp, long timeStemp1);

	@Select("SELECT logId as logId ,ip as ip, userName as userName, operation as operation,argument as argument,time as time FROM log WHERE userName=#{0} AND time>=#{1} AND time<=#{2} limit #{3},#{4}")
	public List<PersistenceLog> getLogByName(String name, long timeStemp, long timeStemp2, int i, int pageSize);


}
