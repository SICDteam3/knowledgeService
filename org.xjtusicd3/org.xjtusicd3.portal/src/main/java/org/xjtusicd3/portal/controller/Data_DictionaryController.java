package org.xjtusicd3.portal.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.database.model.Page;
import org.xjtusicd3.database.model.PersistenceDictionary;
import org.xjtusicd3.portal.service.DictionaryService;

@RequestMapping(value="data_Dictionary")
@Controller
public class Data_DictionaryController {
	
	@RequestMapping(value="toDictionary",method=RequestMethod.GET)
	public ModelAndView toDictionary(){
		ModelAndView mv=new ModelAndView("systemstate/addDateDictionary");
		return mv;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="toDictionaryList",method=RequestMethod.GET)
	public ModelAndView toDictionaryList(){
		ModelAndView mv=new ModelAndView("systemstate/data_dictionary");
		DictionaryService ds=new DictionaryService();
		List lt=ds.dictionarySearch();
		mv.addObject("ds", lt);
		return mv;
	}
	/*
	 * 带分页的数据字典搜索第一次搜索
	 * */
	@SuppressWarnings("static-access")
	@RequestMapping(value={"search"},method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public ModelAndView searchDictionary(){
		ModelAndView mv = new ModelAndView("systemstate/data_dictionary");
		Page<PersistenceDictionary> page = new Page<PersistenceDictionary>();
		DictionaryService ds=new DictionaryService();
		//数据字典搜索
		page = ds.searchDictionary(page);
		mv.addObject("patentPage",page);
		mv.addObject("currentpage",page.getPageNo());
		//分页处理,每页15行数据		
		return mv;
	 }
	
	/*
	 * 分页第二次查看
	 * */
	@RequestMapping(value={"/searchpage"},method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public ModelAndView searchpage(int currentpage){
		ModelAndView mv = new ModelAndView("systemstate/data_dictionary");
		Page<PersistenceDictionary> page = new Page<PersistenceDictionary>();
		page.setPageNo(currentpage);
		//专利名搜索
		page = DictionaryService.searchDictionary(page);
		mv.addObject("patentPage",page);		
		//分页处理,每页15行数据		
		mv.addObject("currentpage",currentpage);
		return mv;
	 }
	
	/*
	 * 数据字典增加
	 * */
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="data_dictionary",method=RequestMethod.GET)
	public ModelAndView addDictionary(String dictionaryName,String dictrionaryValue){
		ModelAndView mv=new ModelAndView("systemstate/data_dictionary");
		DictionaryService ds=new DictionaryService();
		ds.addDictionary(dictionaryName, dictrionaryValue);
		Page<PersistenceDictionary> page = new Page<PersistenceDictionary>();
	
		//数据字典搜索
		page = ds.searchDictionary(page);
		
		mv.addObject("patentPage",page);
		mv.addObject("currentpage",page.getPageNo());
	
		
		return mv;
	}
	
	/*
	 * 删除数据字典
	 * */
	@RequestMapping(value="deleteDictionary",method=RequestMethod.GET)
	public ModelAndView deleteDictionary(int dictionaryId,int currentpage){
		ModelAndView mv=new ModelAndView("systemstate/data_dictionary");
		Page<PersistenceDictionary> page = new Page<PersistenceDictionary>();
		DictionaryService ds=new DictionaryService();
		ds.deleteDectionary(dictionaryId);
		page.setPageNo(currentpage);
		//专利名搜索
		page = DictionaryService.searchDictionary(page);
		mv.addObject("patentPage",page);		
		//分页处理,每页15行数据		
		mv.addObject("currentpage",currentpage);
		return mv;
	}
	
	
}
