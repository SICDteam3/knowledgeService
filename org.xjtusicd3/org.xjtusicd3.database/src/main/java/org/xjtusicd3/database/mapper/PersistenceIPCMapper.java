package org.xjtusicd3.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistenceIPC;

public interface PersistenceIPCMapper extends IBaseDao<PersistenceIPC, String>{
	@Select("SELECT * from sys_ipc_classify WHERE CLASS_LAYER=#{level};")
	List<PersistenceIPC> getFisrtLevel(int level);
	
	@Select("SELECT * from sys_ipc_classify WHERE PARENT_CLASS_ID=#{classId};")
	List<PersistenceIPC> getNextLevel(String classId);
	
}
