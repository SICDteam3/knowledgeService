package org.xjtusicd3.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class CrawerController {
    
	@RequestMapping(value="crawerStart",method=RequestMethod.GET)
	public ModelAndView crawerStart(int i){
		ModelAndView mv=new ModelAndView();
		
		
		return mv;
	}
	
	@RequestMapping(value="crawerStop",method=RequestMethod.GET)
	public ModelAndView crawerStop(int i){
		ModelAndView mv=new ModelAndView();
		
		
		return mv;
	}
	
	
	
}
