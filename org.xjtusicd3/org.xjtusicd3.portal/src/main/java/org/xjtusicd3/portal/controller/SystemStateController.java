package org.xjtusicd3.portal.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.portal.service.SystemStateService;
@RequestMapping(value="state")
@Controller
public class SystemStateController {
	/*
	 * 专利变化柱状图参数
	 * @time 是前台传的时间段参数需要是1,2，或者3
	 * @return 一个包含变化数量的整数数组
	 * */
	@RequestMapping(value="patentUpdateState",method=RequestMethod.GET)
	public ModelAndView patentUpdateState(int time){
		ModelAndView mv=new ModelAndView("systemstate/patentupdate");
		SystemStateService ss=new SystemStateService();
		mv.addObject("puc",ss.patentUpdateCount(time));
		return mv;
	}
	/*
	 * 在线人数变化
	 * */
	@RequestMapping(value="loginCount",method=RequestMethod.GET)
	public ModelAndView loginCount(){
		ModelAndView mv=new ModelAndView("systemstate/onlineusers");
		SystemStateService ss=new SystemStateService();
		//mv.addObject("lc",ss.loginCount());
		return mv;
	}
	
	
}
