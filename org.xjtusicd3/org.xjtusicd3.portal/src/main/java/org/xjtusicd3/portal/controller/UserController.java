package org.xjtusicd3.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class UserController {
	
	   @RequestMapping(value="userSearch",method=RequestMethod.GET)
       public ModelAndView  userSearch(String name){
    	   ModelAndView mv=new ModelAndView();
    	   
    	   return mv;
       }
	   
	   @RequestMapping(value="userBlack",method=RequestMethod.GET)
       public ModelAndView  userBlack(String name){
    	   ModelAndView mv=new ModelAndView();
    	   
    	   return mv;
       }
	   
	   @RequestMapping(value="userRecover",method=RequestMethod.GET)
       public ModelAndView  userRecover(String name){
    	   ModelAndView mv=new ModelAndView();
    	   
    	   return mv;
       }
	   
	   
	   @RequestMapping(value="userPswAlter",method=RequestMethod.GET)
       public ModelAndView  userPswAlter(String name){
    	   ModelAndView mv=new ModelAndView();
    	   
    	   return mv;
       }
	   
	   
}
