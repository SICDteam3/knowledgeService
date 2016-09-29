package org.xjtusicd3.partner.service;

import java.util.ArrayList;
import java.util.List;

import org.xjtusicd3.database.helper.PatentHelper;
import org.xjtusicd3.database.model.PersistencePatent;
import org.xjtusicd3.partner.view.ViewPatent;

public class PatentService {
	public static List<ViewPatent> select(String number,String name,String IPC){
		List<ViewPatent> listPatent = new ArrayList<ViewPatent>();
		List<PersistencePatent> persistencePatent = PatentHelper.query(number, name, IPC);
		if (persistencePatent == null) {
			return null;
		}
		for(PersistencePatent persistencePatent2:persistencePatent){
			ViewPatent viewPatent = new ViewPatent(persistencePatent2);
			listPatent.add(viewPatent);
		}
		return listPatent;
		
	} 
}
