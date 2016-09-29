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
    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    return mv;
	  }
	  /*
	   * ×¨ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
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
	   * ×¨ï¿½ï¿½ï¿½ï¿½ï¿½â»¯
	   */
	  @RequestMapping(value={"/patentVisiual"},method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public ModelAndView patentVisiual(HttpServletRequest request){
		  String IPC = request.getParameter("IPC");
		  ModelAndView mv = new ModelAndView("patentVisiual");
		  List<ViewPatentVisual> listPatent1 = PatentService.InventorVisual(IPC);
		  mv.addObject("inventorVisiual",listPatent1);
		  List<ViewPatentVisual> listPatent2 = PatentService.HolderVisual(IPC);
		  mv.addObject("holderVisiual",listPatent2);
		  List<ViewPatentVisual> listPatent3 = PatentService.ApplicationVisual(IPC);
		  mv.addObject("ApplicationVisiual",listPatent3);
		  List<ViewPatentVisual> listPatent4 = PatentService.AnnouncementVisual(IPC);
		  mv.addObject("AnnouncementVisiual",listPatent4);
		  List<ViewPatentVisual> listPatent5 = PatentService.PopoVisual(IPC);
		  mv.addObject("PopoVisiual",listPatent5);
		
		return mv;
	  }
	  /*
	   * ÆóÒµ×¨ÀûÊýÁ¿ÐéÄâ»¯
	   */
	  @RequestMapping(value={"/holderVisiual"},method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public ModelAndView holderVisiual(HttpServletRequest request){
		  String holder = request.getParameter("holder");
		  ModelAndView mv = new ModelAndView("holderVisiual");
		  List<ViewPatentVisual> listPatent = PatentService.Number_holderpatent(holder);
		  mv.addObject("holderVisiual",listPatent);
		  return mv;
	  }
}
