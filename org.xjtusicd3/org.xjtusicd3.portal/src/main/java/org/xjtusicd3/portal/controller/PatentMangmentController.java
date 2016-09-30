package org.xjtusicd3.portal.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.portal.service.PatentService;
import org.xjtusicd3.portal.view.ViewPatent;

  /*
   * 根据专利关键字和年份查找专利
   */
@RequestMapping(value="patent")
@Controller
public class PatentMangmentController {
    @RequestMapping(value="patentSearch",method=RequestMethod.GET)
	public ModelAndView patentSearch(String patentName,String patentTime){
		  ModelAndView mv=new ModelAndView("resourcemanagement/patentmamagement");
		  PatentService ps=new PatentService();
		  List<ViewPatent> listPatent = ps.getByname(patentName,patentTime);
		  mv.addObject("lp",listPatent);
		  return mv;
	}
    /*
     * 查找专利详情
     * */
    @RequestMapping(value="patentDetail",method=RequestMethod.GET)
    public ModelAndView patentDetail(String IPC){
		ModelAndView mv=new ModelAndView("resourcemanagement/patentmamagement");
	    PatentService ps=new PatentService();
    	mv.addObject("dc",ps.detailCheck(IPC));
    	return mv;
    }
    
    /*
     * 删除专利
     */
    @RequestMapping(value="patentDelete",method=RequestMethod.GET)
    public void patentDelete(String IPC){
	    PatentService ps=new PatentService();
    	ps.pantentDelete(IPC);
    }
    
    
    
}
