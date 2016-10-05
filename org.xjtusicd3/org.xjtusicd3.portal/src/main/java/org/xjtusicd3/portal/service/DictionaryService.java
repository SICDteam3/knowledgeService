package org.xjtusicd3.portal.service;

import org.xjtusicd3.database.helper.DictionaryHelper;

public class DictionaryService {

	/*
	 * 数据字典增加
	 * */
	public void addDictionary(String name,String value){
		DictionaryHelper dh=new DictionaryHelper();
		dh.addDictionary(name, value);
		
	}
}
