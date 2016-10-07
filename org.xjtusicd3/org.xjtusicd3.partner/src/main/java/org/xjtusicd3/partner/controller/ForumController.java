package org.xjtusicd3.partner.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.partner.service.ForumSerivice;
import org.xjtusicd3.partner.view.ViewForumList;
import org.xjtusicd3.partner.view.ViewForumReply;
/*
 * 显示留言板列表
 */
@Controller
@RequestMapping("forum")
public class ForumController {
	@RequestMapping(value="forumlist",method=RequestMethod.GET)
	public ModelAndView getForumPage() {
		ModelAndView mv = new ModelAndView("forum/thread");
		List<ViewForumList> list = ForumSerivice.forumLists();
		mv.addObject("list", list);
		return mv;
	}
//	@RequestMapping(value="newCard",method=RequestMethod.GET)
//	public ModelAndView getCardPage(){
//		ModelAndView mv = new ModelAndView("forum/newCard");
//		return mv;
//	}
	
	/*
	 * 添加留言
	 */
	@RequestMapping(value="addforumlist",method=RequestMethod.GET)
	public ModelAndView addforumlist(ViewForumList viewForumList,HttpSession session) throws Exception{
		ModelAndView mv = null;
		String username = (String) session.getAttribute("session_username");
		viewForumList.setUsername(username);
		java.util.Date date = new java.util.Date();
		long time  = date.getTime();
		viewForumList.setTime(time);
		ForumSerivice.addForumList(viewForumList);
		mv = new ModelAndView("forum/thread");
		return mv;
	}
	/*
	 * 添加回复
	 */
	@RequestMapping(value="addreply",method=RequestMethod.GET)
	public ModelAndView addreply(ViewForumReply viewForumReply,HttpSession session){
		ModelAndView mv = null;
//		String username = (String) session.getAttribute("session_username");
//		viewForumReply.setUsername(username);
		java.util.Date date = new java.util.Date();
		long time = date.getTime();
		String username = (String) session.getAttribute("session_username");
		viewForumReply.setRusername(username);
		viewForumReply.setTime(time);
		ForumSerivice.addreply(viewForumReply);
		mv = new ModelAndView("forum/thread");
		return mv;
		
	}
	
}
