package org.xjtusicd3.portal.service;



import org.xjtusicd3.database.helper.UserHelper;
import org.xjtusicd3.database.model.PersistenceUser;
import org.xjtusicd3.portal.view.ViewUser;



public class UserService2 {
	/*
	 * �û���ע��
	 */
	public static void save(ViewUser users) throws Exception{
		PersistenceUser persistenceUser = new PersistenceUser();
		persistenceUser.setUsername(users.getUserName());
		persistenceUser.setPassword(users.getPassWord());
		persistenceUser.setEmail(users.getUserEmail());
		persistenceUser.setPhone(users.getPhone());
		persistenceUser.setType("common");
		UserHelper.save(persistenceUser);
		
	}
	/*
	 * �û��ĸ���
	 */
	public static void update(ViewUser user) throws Exception{
		PersistenceUser persistenceUser = convert(user);
		UserHelper.update(persistenceUser);
	}
	private static PersistenceUser convert(ViewUser user){
		PersistenceUser persistenceUser = new PersistenceUser();
		persistenceUser.setPassword(user.getPassWord());
		persistenceUser.setEmail(user.getUserEmail());
		persistenceUser.setPhone(user.getPhone());
		return persistenceUser;
		
	}	
	/*
	 * �û���¼���
	 */
	public static ViewUser check(ViewUser user) throws Exception{
		PersistenceUser persistenceUser = UserHelper.checkUser(user.getUserName(), user.getPassWord());
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
	 * �û��ĵ�¼
	 */
	public static void apply(ViewUser user,String email) throws Exception{
		PersistenceUser persistenceUser = UserHelper.getUser(email);
		persistenceUser.setEmail(user.getUserEmail());
		persistenceUser.setPassword(user.getPassWord());
		persistenceUser.setPhone(user.getPhone());
		persistenceUser.setUsername(user.getUserName());
		UserHelper.update(persistenceUser);
	}
	

}

