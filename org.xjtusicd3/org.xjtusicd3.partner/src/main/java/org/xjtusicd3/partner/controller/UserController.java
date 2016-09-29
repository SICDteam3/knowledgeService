package org.xjtusicd3.partner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@RequestMapping(value="register",method=RequestMethod.GET)
	public ModelAndView getRegisterPage(){
		ModelAndView modelAndView = new ModelAndView("register");
		return modelAndView;
		
	}
}
