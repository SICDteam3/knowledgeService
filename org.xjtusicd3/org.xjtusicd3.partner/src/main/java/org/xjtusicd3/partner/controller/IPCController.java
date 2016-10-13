package org.xjtusicd3.partner.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xjtusicd3.common.util.JsonUtil;
import org.xjtusicd3.database.model.PersistenceIPC;
import org.xjtusicd3.partner.service.IPCService;

@Controller
public class IPCController {
	@ResponseBody
	@RequestMapping(value={"/getFirstLevel"},method={org.springframework.web.bind.annotation.RequestMethod.GET},produces = "text/html;charset=UTF-8")
	public String search(HttpServletResponse response) throws Exception{
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		List<PersistenceIPC>firstLevelIpc = IPCService.getFirstLevel();
		if (firstLevelIpc == null || firstLevelIpc.size()==0) {
			return null;
		}			
		String result = JsonUtil.toJsonString(firstLevelIpc);
		String string = new String(result.getBytes("utf-8"),"utf-8");
		System.out.println(string);
		return result;
	 }
	
	@ResponseBody
	@RequestMapping(value={"/getNextLevel"},method={org.springframework.web.bind.annotation.RequestMethod.GET})
	public String getNextLevel(String classId,HttpServletResponse response){
		if (classId==null) {
			return null;
		}
		response.setContentType("application/json");
		List<PersistenceIPC>nextLevelIpc = IPCService.getNextLevel(classId);
		if (nextLevelIpc == null || nextLevelIpc.size()==0) {
			return null;
		}				
		String result = JsonUtil.toJsonString(nextLevelIpc);
		
		System.out.println(result);
		return result;
	 }
	
	@RequestMapping(value={"/ipcpage"},method={org.springframework.web.bind.annotation.RequestMethod.GET})
	public String ipcPage(){		
		return "patent/ipcSelect";
	 }
	
}
