package org.xjtusicd3.database.mapper;

import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistenceAdmin;



public interface PersistenceAdminMapper extends IBaseDao<PersistenceAdmin, String>{
	@Select("select admin_name as adminName, admin_password as adminpassword from admin_table where admin_name=#{adminName};")
	public PersistenceAdmin selectByName(String adminName);
}
