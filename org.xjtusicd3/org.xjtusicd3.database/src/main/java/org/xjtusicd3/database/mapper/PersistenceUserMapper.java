package org.xjtusicd3.database.mapper;


import org.apache.ibatis.annotations.Select;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistenceUser;



public interface PersistenceUserMapper extends IBaseDao<PersistenceUser, String>{
	@Select("select email as email,password as password,username as username,contact as contact,user_status as status,truename as truename,phone_number as phoneNumber,bank_number as bankNumber,id_number as idNumber from user_table where email=#{email};")
	PersistenceUser findByEmail(String email);
	
	@Select("id_number as idNumber from user_table where email=#{email};")
	int findIdByEmail(String email);
}
