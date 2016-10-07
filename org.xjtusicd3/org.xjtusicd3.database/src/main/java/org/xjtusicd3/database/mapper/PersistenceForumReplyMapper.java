package org.xjtusicd3.database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistenceForumReply;

public interface PersistenceForumReplyMapper extends IBaseDao<PersistenceForumReply, String>{
	@Select({"SELECT rusername as rusername,rep_cont as rep_cont,tid as tid,rtime as rtime FROM reply ORDER BY rtime ASC"})
	public  List<PersistenceForumReply> selectAllForumReply();
	
	@Select({"SELECT rusername as rusername,rep_cont as rep_cont,tid as tid,rtime as rtime FROM reply  where tid=#{i} ORDER BY rtime ASC"})
	public  List<PersistenceForumReply> selectById(int i);
}
