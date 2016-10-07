package org.xjtusicd3.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistenceForumList;

public interface PersistenceForumListMapper extends IBaseDao<PersistenceForumList, String>{
	@Select({"SELECT userName as username,tid as tid,title as title,cont as cont,time as time FROM thread ORDER BY time DESC"})
	public  List<PersistenceForumList> selectAllForumList();
	//@Select({"SELECT userName as username,title as title,cont as cont,time as time FROM thread ORDER BY time DESC"})
}
