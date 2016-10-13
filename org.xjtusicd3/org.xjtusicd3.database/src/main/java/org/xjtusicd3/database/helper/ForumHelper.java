package org.xjtusicd3.database.helper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.PersistenceForumListMapper;
import org.xjtusicd3.database.mapper.PersistenceForumReplyMapper;
import org.xjtusicd3.database.model.PersistenceForumList;
import org.xjtusicd3.database.model.PersistenceForumReply;

public class ForumHelper {
	
	/*
	 * 留言版列表
	 */
	public static List<PersistenceForumList> selectAllForumList(){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceForumListMapper mapper = session.getMapper(PersistenceForumListMapper.class);
		List<PersistenceForumList> list =  mapper.selectAllForumList();
		
		session.close();
		return list;
	}
	/*
	 * 回复列表
	 */
	public static List<PersistenceForumReply> selectAllForumReply(int i){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceForumReplyMapper mapper = session.getMapper(PersistenceForumReplyMapper.class);
		List<PersistenceForumReply> list = mapper.selectById(i);
		session.close();
		return list;
	}
	/*
	 * 增加留言
	 */
	public static void add(PersistenceForumList persistenceForumList) throws Exception{
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceForumListMapper mapper = session.getMapper(PersistenceForumListMapper.class);
		mapper.save(persistenceForumList);
		session.close();
	
	}
	
	/*
	 * 增加回复
	 */
	public static void addreply(PersistenceForumReply persistenceForumReply){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceForumReplyMapper mapper = session.getMapper(PersistenceForumReplyMapper.class);
		mapper.save(persistenceForumReply);
		session.close();
	}
}
