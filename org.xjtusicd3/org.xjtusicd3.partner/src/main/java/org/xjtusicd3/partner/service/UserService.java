package org.xjtusicd3.partner.service;

import org.xjtusicd3.database.helper.UserHelper;
import org.xjtusicd3.database.model.PersistenceUser;
import org.xjtusicd3.partner.view.ViewUser;


public class UserService {
	/*
	 * 用户的注册
	 */
	public static void save(ViewUser users) throws Exception{
		PersistenceUser persistenceUser = new PersistenceUser();
		persistenceUser.setUsername(users.getUsername());
		persistenceUser.setPassword(users.getPassword());
		persistenceUser.setEmail(users.getEmail());
		persistenceUser.setPhone(users.getPhone());
		persistenceUser.setType("common");
		UserHelper.save(persistenceUser);
		
	}
	/*
	 * 用户的更改
	 */
	public static void update(ViewUser user) throws Exception{
		PersistenceUser persistenceUser = convert(user);
		UserHelper.update(persistenceUser);
	}
	private static PersistenceUser convert(ViewUser user){
		PersistenceUser persistenceUser = new PersistenceUser();
		persistenceUser.setPassword(user.getPassword());
		persistenceUser.setEmail(user.getEmail());
		persistenceUser.setPhone(user.getPhone());
		return persistenceUser;
		
	}	
	/*
	 * 用户登录检查
	 */
	public static ViewUser check(ViewUser user) throws Exception{
		PersistenceUser persistenceUser = UserHelper.checkUser(user.getUsername(), user.getPassword());
		if(persistenceUser==null){
			return null;
		}
		ViewUser viewUser = new ViewUser(persistenceUser);
		return viewUser;
		
	}
	public static ViewUser getByEmail(String email) throws Exception{
		PersistenceUser puser = UserHelper.getUser(email);
		if (puser == null) {
			return null;
		}
		ViewUser vuser = new ViewUser(puser);
		return vuser;
	}
	/*
	 * 用户的登录
	 */
	public static void apply(ViewUser user,String email) throws Exception{
		PersistenceUser persistenceUser = UserHelper.getUser(email);
		persistenceUser.setEmail(user.getEmail());
		persistenceUser.setPassword(user.getPassword());
		persistenceUser.setPhone(user.getPhone());
		persistenceUser.setUsername(user.getUsername());
		UserHelper.update(persistenceUser);
	}
	

}
