package org.xjtusicd3.partner.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.database.model.Page;
import org.xjtusicd3.database.model.PersistencePatent;
import org.xjtusicd3.partner.service.PatentService;
import org.xjtusicd3.partner.view.ViewPatent;

@Controller
public class IndexController {
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("ipcselect")
	public String ipcSelect() {
		return "patent/ipcSelect";
	}
	
	@RequestMapping(value={"/search"},method={org.springframework.web.bind.annotation.RequestMethod.POST})
	 public ModelAndView search(String context,String searchType){
		ModelAndView mv = new ModelAndView("patent/searchResult");
		Page<PersistencePatent> page = new Page<PersistencePatent>();
		//专利名搜索
		if (searchType.equals("1")) {
			try {
				page = PatentService.selectByName(context,page);
			} catch (Exception e) {
				mv = new ModelAndView("error");
				e.printStackTrace();
			}
		//专利号搜索
		}else if (searchType.equals("2")) {
			page = PatentService.selectByNumber(context,page);
		}
		//专家名称搜索
		else if (searchType.equals("3")) {
			page = PatentService.selectByInventorName(context,page);
		}
		//企业名称搜索
		else if (searchType.equals("4")) {
			page = PatentService.selectByHolderName(context,page);
		}
		mv.addObject("patentPage",page);
		mv.addObject("content",context);
		mv.addObject("currentpage",page.getPageNo());
		mv.addObject("searchtype",searchType);
		//分页处理,每页15行数据		
		return mv;
	 }
	
	@RequestMapping(value={"/searchpage"},method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public ModelAndView searchpage(String content,String searchtype,int currentpage){
		ModelAndView mv = new ModelAndView("patent/searchResult");
		Page<PersistencePatent> page = new Page<PersistencePatent>();
		page.setPageNo(currentpage);
		//专利名搜索
		if (searchtype.equals("1")) {
			try {
				page = PatentService.selectByName(content,page);
			} catch (Exception e) {
				mv = new ModelAndView("error");
				e.printStackTrace();
			}
		//专利号搜索
		}else if (searchtype.equals("2")) {
			page = PatentService.selectByNumber(content,page);
		}
						
		mv.addObject("patentPage",page);		
		//分页处理,每页15行数据		
		mv.addObject("content",content);
		mv.addObject("currentpage",currentpage);
		mv.addObject("searchtype",searchtype);
		return mv;
	 }
	
	
	@RequestMapping(value={"/selectByNumber"},method={org.springframework.web.bind.annotation.RequestMethod.GET})
	  public ModelAndView selectByNumber2(HttpServletRequest request){
		  String number = request.getParameter("number");
		  ModelAndView mv = new ModelAndView("selectByNumber");
		  List<ViewPatent> listPatent = PatentService.selectByNumber(number);
		  mv.addObject("listPatentByNumber",listPatent);
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
	  /*
	   * 专利详情
	   */  
	  @RequestMapping(value={"/patentDetail"},method={org.springframework.web.bind.annotation.RequestMethod.GET})
	  public ModelAndView patentDetail(String number){  
		  ModelAndView mv = new ModelAndView("patent/patentDetail");
		  List<ViewPatent> listPatent = PatentService.selectByNumber(number);
		  mv.addObject("lp",listPatent);
		  return mv;
	  }
	  /*
	   * 专家的专利
	   */
	  @RequestMapping(value={"/expertPatent"},method={org.springframework.web.bind.annotation.RequestMethod.GET})
	  public ModelAndView expertPatent(HttpServletRequest request){
		  String patent_inventor = request.getParameter("patent_inventor");
		  ModelAndView mv = new ModelAndView("patent/expertPatent");
		  List<ViewPatent> listPatent = PatentService.selectByPatent_inventor(patent_inventor);
		  mv.addObject("ep",listPatent);
		  return mv;
	  }
	  /*
	   * 企业的专利
	   */
	  @RequestMapping(value={"/companyPatent"},method={org.springframework.web.bind.annotation.RequestMethod.GET})
	  public ModelAndView companyPatent(HttpServletRequest request){
		  String patent_holder = request.getParameter("patent_holder");
		  ModelAndView mv = new ModelAndView("patent/companyPatent");
		  List<ViewPatent> listPatent = PatentService.selectByPatent_holder(patent_holder);
		  mv.addObject("cp",listPatent);
		  return mv;
	  }
	  
}
