package org.xjtusicd3.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.portal.service.LogService;
@RequestMapping(value="log")
@Controller
public class LogController {
	
	@RequestMapping(value="toUserLog",method=RequestMethod.GET)
	public ModelAndView toUserLog(){
		ModelAndView mv=new ModelAndView("logmanagement/logcheck");
		return mv;
	}
	/*
	 * 按用戶名或者IP地址查詢訪問日誌
	 * */
	@SuppressWarnings("static-access")
	@RequestMapping(value="userLog",method=RequestMethod.POST)
	public ModelAndView userLog(String name,Integer StartTime,Integer EndTime){
		ModelAndView mv=new ModelAndView("logmanagement/logcheck");
		LogService ls=new LogService();
		if(name==null||StartTime==null||EndTime==null){
			return mv;
		}
		mv.addObject("log", ls.userLogByName(name,StartTime,EndTime));
		//mv.addObject("log", ls.userLogByIp(ip,StartTime,EndTime));
		return mv;
	}
	
	/*
	 * 按時間查詢日誌
	 * */
	@SuppressWarnings("static-access")
	@RequestMapping(value="timeLog",method=RequestMethod.GET)
	public ModelAndView timeLog(Integer StartTime,Integer EndTime){
		ModelAndView mv=new ModelAndView("logmanagement/logcheck");
		LogService ls=new LogService();
		if(StartTime==null||EndTime==null){
			return mv;
		}
		mv.addObject("timelog", ls.timeLog(StartTime,EndTime));
		return mv;
	}
}
