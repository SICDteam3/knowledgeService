package org.xjtusicd3.partner.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.partner.service.UserService;
import org.xjtusicd3.partner.view.ViewUser;
@RequestMapping("user")
@Controller
public class UserController {
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView getRegisterPage(){
		ModelAndView mv = new ModelAndView("user/register");
		return mv;
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session){
		session.invalidate();
		ModelAndView mv = new ModelAndView("user/login");
		return mv;
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(ViewUser viewUser){
		try {
			UserService.save(viewUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/login";
	}
//	@RequestMapping(value="/getupdate",method=RequestMethod.GET)
//	public ModelAndView getupdatePage(){
//		ModelAndView mv = new ModelAndView("update");
//		return mv;
//	}
//	@ResponseBody
//	@RequestMapping(value="/update",method=RequestMethod.POST)
//	public String update(ViewUser viewUser){
//		try {
//			UserService.update(viewUser);;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "success";
//	}
	@RequestMapping(value="index",method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	@RequestMapping(value="login",method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("user/login");
		return mv;
	}
	@RequestMapping(value="login_check",method=RequestMethod.POST)
	public ModelAndView loginCheck(ViewUser user,HttpSession session) {
		ModelAndView mv = null;
		try {
			ViewUser viewUser = UserService.check(user);
			if (viewUser==null) {
				mv = new ModelAndView("error");
			}else {
				mv = new ModelAndView("index"); 
				mv.addObject(viewUser);
				
				session.setAttribute("session_username", viewUser.getUsername());
				session.setAttribute("session_password", viewUser.getPassword());
				session.setAttribute("session_email", viewUser.getEmail());
				session.setAttribute("session_phone", viewUser.getPhone());
				session.setAttribute("user_id", viewUser.getIdNumber());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("user/login");
		}
		return mv;
	}
	@RequestMapping(value="myinfo",method=RequestMethod.GET)
	public ModelAndView myinfo(@RequestParam("email") String email) {
		ModelAndView mv = null;
		try {
			ViewUser viewUser = UserService.getByEmail(email);
			mv = new ModelAndView("user/myinfo");
			mv.addObject(viewUser);
			
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("error");
		}
		return mv;
	}
	/*
	 * �û���Ϣ���޸�
	 */
	@RequestMapping("userDetail")
	 public String getuserDetailPage() {
		return "user/userDetail";
	}
	@RequestMapping("change")
	 public String getchangePage() {
		return "user/change";
	}
	@RequestMapping(value="saveupdate",method=RequestMethod.POST)
	public ModelAndView myinfo(ViewUser user,HttpSession session) throws Exception {
		ModelAndView mv = null;
		
			Object object = session.getAttribute("user_id");
			if (object==null) {
				return new ModelAndView("login");
			}
			Integer idNumber = (Integer)object;
			String password = (String) user.getPassword();
			String phone = (String) user.getPhone();
			
			
			user.setIdNumber(idNumber);
			user.setPassword(password);
			user.setPhone(phone);
			
			UserService.update(user);
			mv = new ModelAndView("user/userDetail");				
		return mv;
	}
	
	@RequestMapping(value="apply",method=RequestMethod.GET)
	public ModelAndView apply(HttpSession session){
		ModelAndView mv = new ModelAndView();
		Object email =  session.getAttribute("session_email");
		try {
			if (email==null) {
				mv = new ModelAndView("login");
				return mv;
			}
			ViewUser viewUser = UserService.getByEmail((String)email);
			mv = new ModelAndView("user/apply");
			mv.addObject(viewUser);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@RequestMapping(value="saveapply",method=RequestMethod.POST)
	public ModelAndView saveapply(ViewUser user,HttpSession session) {
		ModelAndView mv = null;
		Object email =  session.getAttribute("session_email");
		try {
			
			if (email==null) {
				mv = new ModelAndView("login");
				return mv;
			}
			user.setEmail((String) email);
			UserService.apply(user,(String) email);
			mv = new ModelAndView("success");
			
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("error");
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="checkemail",method=RequestMethod.GET)
	public String  checkemail(@RequestParam("email") String email) {
		try {
			ViewUser viewUser = UserService.getByEmail(email);
			if (viewUser == null) {
				return "email_notexists";
			}else {
				return "email_exists";
			}
		} catch (Exception e) {
			return "error";
		}
		
	}
}
