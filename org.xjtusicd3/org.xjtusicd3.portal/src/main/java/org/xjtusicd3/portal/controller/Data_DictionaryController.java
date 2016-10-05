package org.xjtusicd3.portal.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xjtusicd3.portal.service.DictionaryService;

@RequestMapping(value="data_Dictionary")
@Controller
public class Data_DictionaryController {
	
	/*
	 * 数据字典增加
	 * */
	@RequestMapping(value="data_dictionary",method=RequestMethod.GET)
	public ModelAndView addDictionary(String dictionaryName,String dictrionaryValue){
		ModelAndView mv=new ModelAndView("logmanagement/dictionary");
		DictionaryService ds=new DictionaryService();
		ds.addDictionary(dictionaryName, dictrionaryValue);
		return mv;
	}
}
