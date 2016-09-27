package org.xjtusicd3.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class SystemStateController {
 
	@RequestMapping(value="patentUpdateState",method=RequestMethod.GET)
	public ModelAndView patentUpdateState(int time){
		ModelAndView mv=new ModelAndView("");
		
		return mv;
	}
	
	@RequestMapping(value="onlineCount",method=RequestMethod.GET)
	public ModelAndView onlineCount(){
		ModelAndView mv=new ModelAndView();
		
		return mv;
	}
	
}
