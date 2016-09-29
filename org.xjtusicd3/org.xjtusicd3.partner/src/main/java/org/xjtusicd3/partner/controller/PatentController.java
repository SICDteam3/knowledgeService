package org.xjtusicd3.partner.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.database.model.Page;
import org.xjtusicd3.partner.service.PatentService;
import org.xjtusicd3.partner.view.ViewPatent;

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
}
