package org.xjtusicd3.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatentMangmentController {
    @RequestMapping(value="patentSearch",method=RequestMethod.GET)
	public ModelAndView patentSearch(){
		ModelAndView mv=new ModelAndView();
		
		
		return mv;
	}
}
