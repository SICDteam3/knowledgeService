package org.xjtusicd3.portal.service;

import java.util.ArrayList;
import java.util.List;
import org.xjtusicd3.database.helper.UserHelper;
import org.xjtusicd3.database.model.Page;
import org.xjtusicd3.database.model.PersistenceUser;
import org.xjtusicd3.portal.view.ViewUser;

public class UserService {

	public static void main(String[] args) {
		UserService ps=new UserService();
		
	    System.out.println(ps.blackSearch());
	}
	
	/*
	 * 查找所有用戶
	 * */
	@SuppressWarnings({ "rawtypes",  "unchecked" })
	public List<ViewUser> userSearch() {
		List vu=new ArrayList();
	    UserHelper uh=new UserHelper();
		vu=uh.searchUser();
		return vu;
	}

	/*
	 * 按用戶名查找用戶
	 * */
	public List<PersistenceUser> userSearch1(String name) {
	    UserHelper uh=new UserHelper();
		return uh.searchUser1(name);
	}
	
	
	
  /*
   *查找黑名單用戶 
   * */
	public List<PersistenceUser> blackSearch() {
	       UserHelper uh=new UserHelper();
	       List<PersistenceUser> ls;
	       ls=uh.blackSearch();
		   return ls;
	}
  /*
   *用戶拉黑  
   **/
	public void defriend(String userId) {
	       UserHelper uh=new UserHelper();
	       uh.defriend(userId);
	}
  /*
   *黑名單用戶移出黑名單
   **/
	public void userRecover(String userId) {
		 UserHelper uh=new UserHelper();
	       uh.userRecover(userId);
	}

	/*
	 * 按用戶id查找用戶
	 * */
	public PersistenceUser userSearchById(String userId) {
		  UserHelper uh=new UserHelper();
			return uh.searchUserById(userId);
	}
   /*
    *修改密碼 
    **/
	public void pswAlter(String userId, String psw) {
		UserHelper uh=new UserHelper();
		uh.pswAlter(userId,psw);
	}

	
	public Page<PersistenceUser> userSearch3(Page<PersistenceUser> page, String name) {
		int count = UserHelper.getCount(name);
		List<PersistenceUser> results = UserHelper.getPageList((page.getPageNo()-1)*page.getPageSize(),page.getPageSize(),name);
		int totalPage = (int) Math.ceil((double)count/page.getPageSize());
		page.setResults(results);
		page.setTotalRecord(count);
		page.setTotalPage(totalPage);
		return page;
	}

	

}
