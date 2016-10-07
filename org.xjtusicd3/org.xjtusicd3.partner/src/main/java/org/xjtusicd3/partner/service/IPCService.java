package org.xjtusicd3.partner.service;

import java.util.List;

import org.xjtusicd3.database.helper.IPCHelper;
import org.xjtusicd3.database.model.PersistenceIPC;


public class IPCService {

	public static List<PersistenceIPC> getFirstLevel() {
		List<PersistenceIPC> list = IPCHelper.getFirtLevel(1);
		return list;
	}

	public static List<PersistenceIPC> getNextLevel(String classId) {
		List<PersistenceIPC> list = IPCHelper.getNextLevel(classId);
		return list;
	}

}
