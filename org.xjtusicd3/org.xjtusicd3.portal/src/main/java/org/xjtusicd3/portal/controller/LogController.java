package org.xjtusicd3.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class LogController {
     
	
	@RequestMapping(value="userLog",method=RequestMethod.GET)
	public ModelAndView userLog(String name,String StartTime,String EndTeme){
		ModelAndView mv=new ModelAndView();
		
		
		return mv;
	}
	
	@RequestMapping(value="timeLog",method=RequestMethod.GET)
	public ModelAndView timeLog(String StartTeme,String EndTime){
		ModelAndView mv=new ModelAndView();
		
		
		return mv;
	}
}
