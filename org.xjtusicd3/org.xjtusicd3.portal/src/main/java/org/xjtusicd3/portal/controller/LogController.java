package org.xjtusicd3.portal.controller;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.database.model.Page;
import org.xjtusicd3.database.model.PersistenceLog;
import org.xjtusicd3.portal.service.LogService;
@RequestMapping(value="log")
@Controller
public class LogController {
	
	@RequestMapping(value="toUserLog",method=RequestMethod.GET)
	public ModelAndView toUserLog(){
		ModelAndView mv=new ModelAndView("logmanagement/logcheck");
		return mv;
	}
	/*
	 * 按用戶名或者IP地址查詢訪問日誌
	 * */
	@SuppressWarnings("static-access")
	@RequestMapping(value="userLog",method=RequestMethod.GET)
	public ModelAndView userLog(String name,String StartTime,String EndTime) throws ParseException{
		ModelAndView mv=new ModelAndView("logmanagement/logcheck");
		LogService ls=new LogService();
		if(name==null||StartTime==null||EndTime==null){
			return mv;
		}
		 SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
		 if(StartTime!=""&&EndTime!=""){
		 Date date=simpleDateFormat .parse(StartTime);
		 Date date1=simpleDateFormat .parse(EndTime);
		 long timeStemp = date.getTime();
		 long timeStemp1 = date1.getTime();
		mv.addObject("log", ls.userLogByName(name,timeStemp,timeStemp1));
		}
		//mv.addObject("log", ls.userLogByIp(ip,StartTime,EndTime));
		return mv;
	}
	
	  /*
	    * 带分页的日志查找
	    * */
		@RequestMapping(value={"logSearch"},method={org.springframework.web.bind.annotation.RequestMethod.GET})
		 public ModelAndView logSearch(String name,String StartTime,String EndTime) throws ParseException{
			ModelAndView mv=new ModelAndView("logmanagement/logcheck");
			Page<PersistenceLog> page = new Page<PersistenceLog>();
			LogService ls=new LogService();
			if(name==null||StartTime==null||EndTime==null){
				return mv;
			}
			 SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
			 if(StartTime!=""&&EndTime!=""){
			 Date date=simpleDateFormat .parse(StartTime);
			 Date date1=simpleDateFormat .parse(EndTime);
			 long timeStemp = date.getTime();
			 long timeStemp1 = date1.getTime();
			//数据字典搜索
			page = ls.userLog(page,name,timeStemp,timeStemp1);
			mv.addObject("patentPage",page);
			mv.addObject("currentpage",page.getPageNo());
			mv.addObject("StartTime", StartTime);
			mv.addObject("EndTime", EndTime);
			mv.addObject("name", name);
			 }
			//分页处理,每页15行数据		
			return mv;
		 }
		
		/*
		    * 分页日志查找
		    * */
			@RequestMapping(value={"searchpage"},method={org.springframework.web.bind.annotation.RequestMethod.GET})
			 public ModelAndView logSearch2(int currentpage,String name,String StartTime,String EndTime) throws ParseException{
				ModelAndView mv=new ModelAndView("logmanagement/logcheck");
				Page<PersistenceLog> page = new Page<PersistenceLog>();
				page.setPageNo(currentpage);
				LogService ls=new LogService();
				if(name==null||StartTime==null||EndTime==null){
					return mv;
				}
				 SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
				 if(StartTime!=""&&EndTime!=""){
				 Date date=simpleDateFormat .parse(StartTime);
				 Date date1=simpleDateFormat .parse(EndTime);
				 long timeStemp = date.getTime();
				 long timeStemp1 = date1.getTime();
				//数据字典搜索
				page = ls.userLog(page,name,timeStemp,timeStemp1);
				mv.addObject("patentPage",page);
				mv.addObject("currentpage",page.getPageNo());
				mv.addObject("StartTime", StartTime);
				mv.addObject("EndTime", EndTime);
				 }
				//分页处理,每页15行数据		
				return mv;
			 }
		
	/*
	 * 按時間查詢日誌
	 * */
	@SuppressWarnings("static-access")
	@RequestMapping(value="timeLog",method=RequestMethod.GET)
	public ModelAndView timeLog(Integer StartTime,Integer EndTime){
		ModelAndView mv=new ModelAndView("logmanagement/logcheck");
		LogService ls=new LogService();
		if(StartTime==null||EndTime==null){
			return mv;
		}
		mv.addObject("timelog", ls.timeLog(StartTime,EndTime));
		return mv;
	}
}
