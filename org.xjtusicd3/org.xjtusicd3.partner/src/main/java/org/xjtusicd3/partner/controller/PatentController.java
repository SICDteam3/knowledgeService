package org.xjtusicd3.partner.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.database.model.Page;
import org.xjtusicd3.partner.service.PatentService;
import org.xjtusicd3.partner.view.ViewPatent;
import org.xjtusicd3.partner.view.ViewPatentVisual;
@Controller
public class PatentController {
	 
	  @RequestMapping(value={"patentquery"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public ModelAndView query(HttpServletRequest request)
	  {
	    
	    String number = request.getParameter("number");
	    String name = request.getParameter("name");
	    String IPC = request.getParameter("IPC");
	    ModelAndView mv = new ModelAndView("query");
	    try
	    {
	      List<ViewPatent> listPatent = PatentService.select(number, name, IPC);
	      mv.addObject("listPatent", listPatent);
	      Page localPage = new Page();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    return mv;
	  }
	  /*
	   * 专利查找
	   */
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
	  @RequestMapping(value={"/selectByIPC"},method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public ModelAndView selectByIPC(HttpServletRequest request){
		  String IPC = request.getParameter("IPC");
		  ModelAndView mv = new ModelAndView("selectByIPC");
		  List<ViewPatent> listPatent = PatentService.selectByIPC(IPC);
		  mv.addObject("listPatentByIPC",listPatent);
		return mv;
	  }
	  /*
	   * 专利虚拟化
	   */
	  @RequestMapping(value={"/patentVisiual"},method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public ModelAndView patentVisiual(HttpServletRequest request){
		  String IPC = request.getParameter("IPC");
		  ModelAndView mv = new ModelAndView("patentVisiual");
		  List<ViewPatentVisual> listPatent1 = PatentService.InventorVisual(IPC);
		  mv.addObject("inventorVisiual",listPatent1);
		  List<ViewPatentVisual> listPatent2 = PatentService.HolderVisual(IPC);
		  
		  
		  
		return mv;
	  }
}
