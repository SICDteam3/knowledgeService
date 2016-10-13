package org.xjtusicd3.partner.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.partner.service.PatentService;
import org.xjtusicd3.partner.view.ViewPatent;
import org.xjtusicd3.partner.view.ViewPatentVisual;

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
		@RequestMapping("holdermap")
		public  String getPatentYearnumber(){
			return "patent/holderMap";
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
	   *专家 
	   */
	  @RequestMapping(value={"holderVisiual"},method={org.springframework.web.bind.annotation.RequestMethod.GET})
	  public ModelAndView holderVisiual(HttpServletRequest request){
	  String IPC = request.getParameter("IPC");
	  ModelAndView mv = new ModelAndView("patent/holderMap");
	//专利可视化——发明人、专权人  
	  List<ViewPatentVisual> listPatent1 = PatentService.InventorVisual(IPC);
	  List<ViewPatentVisual> listPatent2 = PatentService.HolderVisual(IPC);
	  int length1 = listPatent1.size();
	  int length2 = listPatent2.size();
	  String date1 = null;
	  String date2;
	  String date3 = null;
	  String date4;
	  String date_inventor = "'";
	  String date_holder = "'";
	  String date_inventor_number = "";
	  String date_holder_number = "";
	for (ViewPatentVisual viewPatentVisual : listPatent1) {
		  	length1--;
		  	date1 = viewPatentVisual.getPatent_inventor();
		  	date2 = viewPatentVisual.getCounts_inventor();
		  	date_inventor  += date1;
		  	date_inventor_number += date2;

		  	if(length1>=1)
		   {
			   date_inventor += "','";
			   date_inventor_number += ",";
		   }
		   else{
			   date_inventor += "'";
		   }
		  
	}
	for (ViewPatentVisual viewPatentVisual : listPatent2) {
	  	length2--;
	  	date3 = viewPatentVisual.getPatent_holder();
	  	date4 = viewPatentVisual.getCounts_holder();
	  	date_holder += date3;
	  	date_holder_number += date4;
	  	
		if(length2>=1)
		   {
			   date_holder += "','";
			   date_holder_number += ",";
		   }
		   else{
			   date_holder += "'";
		   }
	}
	  mv.addObject("date_inventor",date_inventor);
	  mv.addObject("date_inventor_number", date_inventor_number);
	  mv.addObject("date_holder",date_holder);
	  mv.addObject("date_holder_number", date_holder_number);
	  return mv;
	  }
	
	 
	  /*
	   * 专利可视化
	   */
	  @RequestMapping(value={"inventorVisiual"},method={org.springframework.web.bind.annotation.RequestMethod.GET})	 
	  public ModelAndView inventorVisiual(HttpServletRequest request){
		String IPC = request.getParameter("IPC");
		ModelAndView mv = new ModelAndView("patent/analyse");
		//专利的逐年数量
		List<ViewPatentVisual> list = PatentService.PatentYearNumber(IPC);
		int length = list.size();
		String date = null;
		String date1;
		String date_year = "'";
		String date_year_number = "";
		
		String date5;
		String date6;
		for(ViewPatentVisual viewPatentVisual:list){
			length--;
			date = viewPatentVisual.getDate_year();
			date1  = viewPatentVisual.getCounts_year();
			date_year += date;
			date_year_number +=date1;
			 if (length>=1) {
					date_year += "','";
					date_year_number += ",";
				}
				  else {
					  date_year += "'";
				}
		}
		
		
		//专利可视化——专利申请、发布时间——年份数量统计
		String date_application_number = "";
		String date_announcement_number = "";
		for(int month = 1;month <= 12;month ++){
			  String year = "2008/"+ month;
			  List<ViewPatentVisual> listPatent3 = PatentService.ApplicationVisual(year, IPC);
			  List<ViewPatentVisual> listPatent4 = PatentService.AnnouncementVisual(year, IPC);
			  int length3 = listPatent3.size();
			  int length4 = listPatent4.size();
			  for (ViewPatentVisual viewPatentVisua : listPatent3) {
				  length3--;
				  date5 = viewPatentVisua.getCounts_application();
				  date_application_number += date5;

				  if(length3>=0)
				   {
					    date_application_number += ",";
				   }
				  
			  	}
			  for (ViewPatentVisual viewPatentVisua : listPatent4) {
				  length4--;
				  date6 = viewPatentVisua.getCounts_announcement();
				  date_announcement_number += date6;

				  if(length4>=0)
				   {
					  date_announcement_number += ",";
				   }
				  
			  	}
			  
		}
		
		  
//		//专利可视化——省市
//		  List<ViewPatentVisual> listPatent5 = PatentService.PopoVisual(IPC);
//		  int length5 = listPatent5.size();
//		  String date8;
//		  String date_province_number = "";
//		  //String date_inventor_number = "";
//		  //String date_holder_number = "";
//		for (ViewPatentVisual viewPatentVisual : listPatent5) {
//			  	length5--;
//			  	date8 = viewPatentVisual.getCounts_province();
//			  	date_province_number += date8;
//
//			  	if(length5>=1)
//			   {
//			  		date_province_number += ",";
//			   }
//			   else{
//			   }
//			  
//		}	
		  mv.addObject("date_year",date_year);
		  mv.addObject("date_year_number", date_year_number);
		  mv.addObject("date_application_number", date_application_number);
		  mv.addObject("date_announcement_number", date_announcement_number);
		  //mv.addObject("date_province_number",date_province_number);
		  return mv;
	  }
	  
	  
	  /*
	   * 专利可视化，进行了优化。
	   */
	  @RequestMapping(value={"inventorVisiual2"},method={org.springframework.web.bind.annotation.RequestMethod.GET})	 
	  public ModelAndView inventorVisiual2(HttpServletRequest request){
		  String IPC = request.getParameter("IPC");
		  ModelAndView mv = new ModelAndView("patent/analyse");
		//专利可视化——发明人、专权人  
		  List<ViewPatentVisual> listPatent1 = PatentService.InventorVisual(IPC);
		  List<ViewPatentVisual> listPatent2 = PatentService.HolderVisual(IPC);
		  int length1 = listPatent1.size();
		  int length2 = listPatent2.size();
		  String date1 = null;
		  String date2;
		  String date3 = null;
		  String date4;
		  String date_inventor = "'";
		  String date_holder = "'";
		  String date_inventor_number = "";
		  String date_holder_number = "";
		for (ViewPatentVisual viewPatentVisual : listPatent1) {
			  	length1--;
			  	date1 = viewPatentVisual.getPatent_inventor();
			  	date2 = viewPatentVisual.getCounts_inventor();
			  	date_inventor  += date1;
			  	date_inventor_number += date2;

			  	if(length1>=1)
			   {
				   date_inventor += "','";
				   date_inventor_number += ",";
			   }
			   else{
				   date_inventor += "'";
			   }
			  
		}
		for (ViewPatentVisual viewPatentVisual : listPatent2) {
		  	length2--;
		  	date3 = viewPatentVisual.getPatent_holder();
		  	date4 = viewPatentVisual.getCounts_holder();
		  	date_holder += date3;
		  	date_holder_number += date4;
		  	
			if(length2>=1)
			   {
				   date_holder += "','";
				   date_holder_number += ",";
			   }
			   else{
				   date_holder += "'";
			   }
		}
		
		//专利可视化——专利申请、发布时间——年份数量统计
		String date_application_number = "";
		String date_announcement_number = "";
		String date5;
		String date6;
		
		 String year = "2008/";
		 List<ViewPatentVisual> listPatent3 = PatentService.ApplicationVisual(year, IPC);
		 List<ViewPatentVisual> listPatent4 = PatentService.AnnouncementVisual(year, IPC);
		  
		for(int month = 1;month <= 12;month ++){
			  
			  int length3 = listPatent3.size();
			  int length4 = listPatent4.size();
			  //申请时间统计
			  for (ViewPatentVisual viewPatentVisua : listPatent3) {
				if (viewPatentVisua.getDate_of_application().contains("2008/")) {
					
				}
				  length3--;
				  date5 = viewPatentVisua.getCounts_application();
				  date_application_number += date5;

				  if(length3>=0)
				   {
					    date_application_number += ",";
				   }
				  
			  	}
			//发布时间统计
			  for (ViewPatentVisual viewPatentVisua : listPatent4) {
				  length4--;
				  date6 = viewPatentVisua.getCounts_announcement();
				  date_announcement_number += date6;

				  if(length4>=0)
				   {
					  date_announcement_number += ",";
				   }
				  
			  	}
			  
		}
		
		  
	
		  mv.addObject("date_inventor",date_inventor);
		  mv.addObject("date_inventor_number", date_inventor_number);
		  mv.addObject("date_holder",date_holder);
		  mv.addObject("date_holder_number", date_holder_number);
		  mv.addObject("date_application_number", date_application_number);
		  mv.addObject("date_announcement_number", date_announcement_number);
//		  List<ViewPatentVisual> listPatent2 = PatentService.HolderVisual(IPC);
//		  mv.addObject("holderVisiual",listPatent2);
//		  List<ViewPatentVisual> listPatent3 = PatentService.ApplicationVisual(IPC);
//		  mv.addObject("ApplicationVisiual",listPatent3);
//		  List<ViewPatentVisual> listPatent4 = PatentService.AnnouncementVisual(IPC);
//		  mv.addObject("AnnouncementVisiual",listPatent4);
//		  List<ViewPatentVisual> listPatent5 = PatentService.PopoVisual(IPC);
//		  mv.addObject("PopoVisiual",listPatent5);
//		  mv.addObject("result",result);
		return mv;
	  }

		
	  /*
	   * 企业专利数量——可视化
	   */
	  @RequestMapping(value={"companyVisiual"},method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public ModelAndView companyVisiual(HttpServletRequest request){
		  String patent_holder = request.getParameter("patent_holder");
		  ModelAndView mv = new ModelAndView("patent/companyMap");
		  List<ViewPatentVisual> list = PatentService.Number_holderpatent(patent_holder);
		  int length = list.size();
		  String date = null;
		  String date1;
		  String date_year = "'";
		  String date_year_number = "";
		  for(ViewPatentVisual viewPatentVisual:list){
			  length--;
			  date = viewPatentVisual.getDate_year();
			  date1 = viewPatentVisual.getCounts_year();
			  date_year += date;
			  date_year_number +=date1;
			  if (length>=1) {
				date_year += "','";
				date_year_number += ",";
			}
			  else {
				  date_year += "'";
			}
		  }
		  mv.addObject("patent_holder", patent_holder);
		  mv.addObject("date_year",date_year);
		  mv.addObject("date_year_number", date_year_number);
		  return mv;
	  }
	  
	  
	 
	 
	  }
	 

