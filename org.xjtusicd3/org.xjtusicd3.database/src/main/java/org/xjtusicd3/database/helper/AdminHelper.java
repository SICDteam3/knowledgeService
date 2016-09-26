package org.xjtusicd3.database.helper;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.PersistenceAdminMapper;
import org.xjtusicd3.database.model.PersistenceAdmin;



public class AdminHelper {
	public static PersistenceAdmin getAdmin(String adminName) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession();
		PersistenceAdminMapper mapper = session.getMapper(PersistenceAdminMapper.class);
		PersistenceAdmin admin = mapper.selectByName(adminName);
		return admin;
	}
	
	public static void main(String[] args) {
		PersistenceAdmin admin = getAdmin("aa");
		System.out.println(admin.getAdminpassword());
	}
}
