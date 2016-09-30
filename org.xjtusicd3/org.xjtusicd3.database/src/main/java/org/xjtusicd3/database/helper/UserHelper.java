package org.xjtusicd3.database.helper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.PersistenceUserMapper;
import org.xjtusicd3.database.model.PersistenceUser;



public class UserHelper {

	public static void save(PersistenceUser puser) throws Exception{
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceUserMapper mapper = session.getMapper(PersistenceUserMapper.class);
		mapper.save(puser);
		session.close();
	}

	public static void update(PersistenceUser puser) throws Exception{
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceUserMapper mapper = session.getMapper(PersistenceUserMapper.class);
		mapper.update(puser);
		session.close();
		
	}

	public static PersistenceUser checkUser(String email, String password) throws Exception{
		
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceUserMapper mapper = session.getMapper(PersistenceUserMapper.class);
		PersistenceUser user = (PersistenceUser)mapper.findByEmail(email);
		session.close();
		if (user == null) {
			return null;
		}else if(user.getPassword().equals(password)){
			return user;
		}else {
			return null;
		}
	}

	public static PersistenceUser getUser(String email) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceUserMapper mapper = session.getMapper(PersistenceUserMapper.class);
		PersistenceUser user = (PersistenceUser)mapper.findByEmail(email);
		session.close();
		return user;
	}


	@SuppressWarnings("rawtypes")
	public List searchUser() {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceUserMapper mapper = session.getMapper(PersistenceUserMapper.class);
		return mapper.searchUser();
	}


	public PersistenceUser searchUser1(String name) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceUserMapper mapper = session.getMapper(PersistenceUserMapper.class);
		return mapper.searchUser1(name);
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public List<PersistenceUser> blackSearch() {
		List ls;
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceUserMapper mapper = session.getMapper(PersistenceUserMapper.class);
		ls=mapper.blackSearch();
		return ls;
	}

	public void defriend(String userId) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceUserMapper mapper = session.getMapper(PersistenceUserMapper.class);
		mapper.defriend(userId);
	}

	public void userRecover(String userId) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceUserMapper mapper = session.getMapper(PersistenceUserMapper.class);
		mapper.userRecover(userId);
	}

	public PersistenceUser searchUserById(String userId) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceUserMapper mapper = session.getMapper(PersistenceUserMapper.class);
		return mapper.searchUserById(userId);
	}

	public void pswAlter(String userId, String psw) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceUserMapper mapper = session.getMapper(PersistenceUserMapper.class);
		mapper.pswAlter(userId,psw);
	}




	
	

}
