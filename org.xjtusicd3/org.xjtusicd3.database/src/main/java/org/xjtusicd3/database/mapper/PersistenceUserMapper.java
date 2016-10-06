package org.xjtusicd3.database.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistenceUser;



public interface PersistenceUserMapper extends IBaseDao<PersistenceUser, String>{
	@Select("select userEmail as email,userName as username,passWord as password,user_type as type,flag as flag,userId as idNumber,phone as phone from user where username=#{email};")
	PersistenceUser findByName(String name);
	
	@Select("select userEmail as email,userName as username,passWord as password,user_type as type,flag as flag,userId as idNumber,phone as phone from user where email=#{email};")
	PersistenceUser findByEmail(String email);
	
	@Select("select id_number as idNumber from user_table where email=#{email};")
	int findIdByEmail(String email);

	
	@Select("select userId as userId ,userName as userName,userEmail as userEmail,passWord as passWord,user_type as user_type,flag as flag,phone as phone from user;")
	List<PersistenceUser> searchUser();

	@Select("select userId as idNumber ,userName as userName,userEmail as email,passWord as passWord,user_type as type,flag as flag,phone as phone from user where userName like #{name} AND flag=0;")
	List<PersistenceUser> searchUser1(String name);

	@Select("select userId as idNumber ,userName as userName,userEmail as email,passWord as passWord,user_type as type,flag as flag,phone as phone from user where flag=1;")
	List<PersistenceUser> blackSearch();

	@Update("UPDATE user SET flag = 1 WHERE userId = #{0}")
	void defriend(String userId);
	
	@Update("UPDATE user SET flag = 0 WHERE userId = #{0}")
	void userRecover(String userId);

	@Select("select userId as idNumber ,userName as userName,userEmail as email,passWord as passWord,user_type as type,flag as flag,phone as phone from user where userId=#{userId};")
	PersistenceUser searchUserById(String userId);

	@Update("UPDATE user SET passWord = #{1} WHERE userId = #{0}")
	void pswAlter(String userId, String psw);
}


