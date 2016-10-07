package org.xjtusicd3.portal.service;

import java.util.List;

import org.xjtusicd3.database.helper.DictionaryHelper;
import org.xjtusicd3.database.model.Page;
import org.xjtusicd3.database.model.PersistenceDictionary;

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

	public static Page<PersistenceDictionary> searchDictionary(Page<PersistenceDictionary> page) {
		int count = DictionaryHelper.getCount();
		List<PersistenceDictionary> results = DictionaryHelper.getPageList((page.getPageNo()-1)*page.getPageSize(),page.getPageSize());
		int totalPage = (int) Math.ceil((double)count/page.getPageSize());
		page.setResults(results);
		page.setTotalRecord(count);
		page.setTotalPage(totalPage);
		return page;
	}
}
