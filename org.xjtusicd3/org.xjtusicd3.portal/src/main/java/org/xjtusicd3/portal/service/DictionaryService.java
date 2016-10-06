package org.xjtusicd3.portal.service;

import java.util.List;

import org.xjtusicd3.database.helper.DictionaryHelper;

public class DictionaryService {

	/*
	 * 数据字典增加
	 * */
	public void addDictionary(String name,String value){
		DictionaryHelper dh=new DictionaryHelper();
		dh.addDictionary(name, value);
		
	}

	@SuppressWarnings("rawtypes")
	public List dictionarySearch() {
		DictionaryHelper dh=new DictionaryHelper();
		List ds=dh.dictionarySearch();
		return ds;
	}

	public void deleteDectionary(int id) {
		DictionaryHelper dh=new DictionaryHelper();
		dh.deleteDictionary(id);
		
	}
}
