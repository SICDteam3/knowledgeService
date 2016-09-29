package org.xjtusicd3.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.portal.service.LogService;
@RequestMapping(value="log")
@Controller
public class LogController {
     
	/*
	 * 按用戶名或者IP地址查詢訪問日誌
	 * */
	@RequestMapping(value="userLog",method=RequestMethod.GET)
	public ModelAndView userLog(String name,String ip,String StartTime,String EndTime){
		ModelAndView mv=new ModelAndView();
		LogService ls=new LogService();
		mv.addObject("log", ls.userLogByName(name,StartTime,EndTime));
		mv.addObject("log", ls.userLogByIp(ip,StartTime,EndTime));
		return mv;
	}
	
	/*
	 * 按時間查詢日誌
	 * */
	@RequestMapping(value="timeLog",method=RequestMethod.GET)
	public ModelAndView timeLog(String StartTime,String EndTime){
		ModelAndView mv=new ModelAndView();
		LogService ls=new LogService();
		mv.addObject("timelog", ls.timeLog(StartTime,EndTime));
		return mv;
	}
}
