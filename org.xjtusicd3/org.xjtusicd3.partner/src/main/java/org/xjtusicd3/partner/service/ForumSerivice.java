package org.xjtusicd3.partner.service;

import java.util.ArrayList;
import java.util.List;

import org.xjtusicd3.database.helper.ForumHelper;
import org.xjtusicd3.database.model.PersistenceForumList;
import org.xjtusicd3.database.model.PersistenceForumReply;
import org.xjtusicd3.partner.view.ViewForumList;
import org.xjtusicd3.partner.view.ViewForumReply;

public class ForumSerivice {
	/*
	 * œ‘ æ¡Ù—‘∞Â
	 */
	public static List<ViewForumList> forumLists(){
		List<ViewForumList> list = new ArrayList<ViewForumList>();
		List<PersistenceForumList> persistenceForumList = ForumHelper.selectAllForumList();
		if (persistenceForumList ==null) {
			return null;
		}
		for(PersistenceForumList persistenceForumList2:persistenceForumList){
			
			List<ViewForumReply> viewForumReplies = new ArrayList<>();

			
			List<PersistenceForumReply> replies= ForumHelper.selectAllForumReply(persistenceForumList2.getTid());
			
			for (PersistenceForumReply persistenceForumReply : replies) {
				ViewForumReply reply = new ViewForumReply(persistenceForumReply);
				viewForumReplies.add(reply);
			}
			
			ViewForumList viewForumList = new ViewForumList(persistenceForumList2);
			viewForumList.setReplylist(viewForumReplies);
			
			list.add(viewForumList);
			
		}
		
		
		return list;
	}
	
	/*
	 * ÃÌº”¡Ù—‘
	 */
	public static void addForumList(ViewForumList viewForumList) throws Exception{
		PersistenceForumList persistenceForumList = new PersistenceForumList();
		persistenceForumList.setUsername(viewForumList.getUsername());
		persistenceForumList.setTitle(viewForumList.getTitle());
		persistenceForumList.setCont(viewForumList.getCont());
		persistenceForumList.setTime(viewForumList.getTime());
		ForumHelper.add(persistenceForumList);
	}
	/*
	 * ÃÌº”ªÿ∏¥
	 */
	public static void addreply(ViewForumReply viewForumReply){
		PersistenceForumReply persistenceForumReply = new PersistenceForumReply();
		persistenceForumReply.setRusername(viewForumReply.getRusername());
		persistenceForumReply.setRep_cont(viewForumReply.getRep_cont());
		persistenceForumReply.setRtime(viewForumReply.getTime());
		persistenceForumReply.setTid(viewForumReply.getTid());
		ForumHelper.addreply(persistenceForumReply);
	}
	 
	
}
