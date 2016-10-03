package org.xjtusicd3.partner.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.partner.service.PatentService;
import org.xjtusicd3.partner.view.ViewPatent;
import org.xjtusicd3.partner.view.ViewPatentVisual;

import com.alibaba.fastjson.JSONArray;
@Controller
@RequestMapping("patent")
public class PatentController {
		@RequestMapping("analyse")
		 public String getAnalysePage() {
			return "patent/analyse";
		}
		
		@RequestMapping("companymap")
		 public String getCompanyMap() {
			return "patent/companyMap";
		}
		
		
		
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
	   * 专利查询
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
	   * 专利可视化——发明人
	   */
	  @RequestMapping(value={"inventorVisiual"},method={org.springframework.web.bind.annotation.RequestMethod.POST})
	 
	  public ModelAndView inventorVisiual(HttpServletRequest request){
		  String IPC = request.getParameter("IPC");
		  ModelAndView mv = new ModelAndView("patent/analyse");
		  List<ViewPatentVisual> listPatent1 = PatentService.InventorVisual(IPC);
		  int length = listPatent1.size();
		  int date_inventor_number = (Integer) null;
		  String date1 = null;
		  String date_inventor = "'";
		  for (ViewPatentVisual viewPatentVisual : listPatent1) {
			  	length--;
			  	date_inventor_number = viewPatentVisual.getCounts_inventor();
			  	date1 = viewPatentVisual.getPatent_inventor();
			  	date_inventor  += date1;
			  	if(length>=1)
			   {
				   date_inventor += "','";
			   }
			   else{
				   date_inventor += "'";
			   }
			  
		}
		  //mv.addObject("date_inventor_number", date_inventor_number);
		  mv.addObject("date_inventor",date_inventor);
		  System.out.println(date_inventor_number);
//		  JSONArray jsonArray1 = new JSONArray();
//		  jsonArray1.add(listPatent1);
		 
		//String str ="'1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��'";
//		  mv.addObject("date",str);
		 // mv.addObject("date1", date1);
//		  mv.addObject("inventorVisiual",listPatent1);
//		  String result = "[";
//		  for (ViewPatentVisual viewPatentVisual : listPatent1) {
//			result =result+ viewPatentVisual.getPatent_inventor()+",";
//		  }
//		  result.subSequence(0, result.length()-1);
//		  result = result + "]";
		  
		  
//		  List<ViewPatentVisual> listPatent2 = PatentService.HolderVisual(IPC);
//		  mv.addObject("holderVisiual",listPatent2);
//		  List<ViewPatentVisual> listPatent3 = PatentService.ApplicationVisual(IPC);
//		  mv.addObject("ApplicationVisiual",listPatent3);
//		  List<ViewPatentVisual> listPatent4 = PatentService.AnnouncementVisual(IPC);
//		  mv.addObject("AnnouncementVisiual",listPatent4);
//		  List<ViewPatentVisual> listPatent5 = PatentService.PopoVisual(IPC);
//		  mv.addObject("PopoVisiual",listPatent5);
		  
//		  
//		  mv.addObject("result",result);
		
		return mv;
	  }
	 
	  /*
	   * 专利可视化——专权人
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
