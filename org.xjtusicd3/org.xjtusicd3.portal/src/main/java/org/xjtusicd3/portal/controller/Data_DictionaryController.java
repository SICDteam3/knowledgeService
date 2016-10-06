package org.xjtusicd3.portal.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
	 * 数据字典增加
	 * */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="data_dictionary",method=RequestMethod.GET)
	public ModelAndView addDictionary(String dictionaryName,String dictrionaryValue){
		ModelAndView mv=new ModelAndView("systemstate/data_dictionary");
		DictionaryService ds=new DictionaryService();
		ds.addDictionary(dictionaryName, dictrionaryValue);
		
		List lt=ds.dictionarySearch();
		mv.addObject("ds", lt);
		return mv;
	}
	
	/*
	 * 删除数据字典
	 * */
	@RequestMapping(value="deleteDictionary",method=RequestMethod.GET)
	public ModelAndView deleteDictionary(int dictionaryId){
		ModelAndView mv=new ModelAndView("systemstate/data_dictionary");
		DictionaryService ds=new DictionaryService();
		ds.deleteDectionary(dictionaryId);
		List lt=ds.dictionarySearch();
		mv.addObject("ds", lt);
		return mv;
	}
	
	
}
