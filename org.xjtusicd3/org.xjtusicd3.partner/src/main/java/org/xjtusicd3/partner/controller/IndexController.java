package org.xjtusicd3.partner.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.partner.service.PatentService;
import org.xjtusicd3.partner.view.ViewPatent;

@Controller
public class IndexController {
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value={"/search"},method={org.springframework.web.bind.annotation.RequestMethod.POST})
	 public ModelAndView search(String context,String searchType){
		ModelAndView mv = new ModelAndView("searchResult");
		List<ViewPatent> listPatent = null;
		//专利名搜索
		if (searchType.equals("1")) {
			listPatent = PatentService.selectByName(context);
		//专利号搜索
		}else if (searchType.equals("2")) {
			listPatent = PatentService.selectByNumber(context);
		}		  
		mv.addObject("listPatent",listPatent);
		return mv;
	 }
	
	@RequestMapping(value={"/selectByNumber"},method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public ModelAndView selectByNumber(HttpServletRequest request){
		  String number = request.getParameter("number");
		  ModelAndView mv = new ModelAndView("selectByNumber");
		  List<ViewPatent> listPatent = PatentService.selectByNumber(number);
		  mv.addObject("listPatentByNumber",listPatent);
		return mv;
	 }
	  @RequestMapping(value={"/selectByName"},method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public ModelAndView selectByName(HttpServletRequest request){
		  String name = request.getParameter("name");
		  ModelAndView mv = new ModelAndView("selectByName");
		  List<ViewPatent> listPatent = PatentService.selectByName(name);
		  mv.addObject("listPatentByName",listPatent);
		return mv;
	  }
}
