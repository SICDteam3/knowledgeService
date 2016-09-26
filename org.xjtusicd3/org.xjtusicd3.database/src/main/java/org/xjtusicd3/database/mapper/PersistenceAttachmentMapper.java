package org.xjtusicd3.database.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.xjtusicd3.database.logic.IBaseDao;
import org.xjtusicd3.database.model.PersistenceAttachment;



public interface PersistenceAttachmentMapper extends IBaseDao<PersistenceAttachment, Integer> {

	@Select("SELECT * FROM POP_ATTACHMENT_INFO WHERE ID = #{ID} FOR UPDATE")
	public PersistenceAttachment getBlob(String ID);
	
	@Select("SELECT * FROM POP_ATTACHMENT_INFO WHERE ID = #{ID}")
	public PersistenceAttachment getAttachment(String ID);
	
	@Select("SELECT ID, PATHNAME pathname FROM POP_ATTACHMENT_INFO WHERE ID IN (SELECT IDCARD_ATTACH_ID AS ID FROM POP_PERSON_PARTNER WHERE PARTNER_CODE = #{partnerCode})")
	public PersistenceAttachment getAttachmentByPerson(String partnerCode);
	
	@Select("SELECT ID, PATHNAME pathname FROM POP_ATTACHMENT_INFO WHERE ID IN (SELECT LICENSE_ATTACH_ID AS ID FROM POP_COMPANY_PARTNER WHERE PARTNER_CODE = #{partnerCode})")
	public PersistenceAttachment getAttachmentByCompany(String partnerCode);
	
	@Select("SELECT ID, PATHNAME pathname FROM POP_ATTACHMENT_INFO WHERE ID IN (SELECT LOGO_ATTACH_ID FROM POP_APP_INFO WHERE APP_CODE = #{appCode})")
	public PersistenceAttachment getAppLogoPath(String appCode);
	
	@Delete("DELETE FROM POP_ATTACHMENT_INFO WHERE ID IN (SELECT ID FROM POP_APP_INFO WHERE APP_CODE = #{appCode})")
	public void deleteAppLogoPath(String appCode);
	
	@Delete("DELETE FROM POP_ATTACHMENT_INFO WHERE ID = #{ID}")
	public void deleteAttachment(String ID);
	
	@Insert("INSERT INTO POP_ATTACHMENT_INFO VALUES (#{0},NULL, empty_blob())")
	public void newAttachment(String ID);
	
	@Insert("INSERT INTO POP_ATTACHMENT_INFO VALUES (#{0},NULL,to_blob(#{1}))")
	public void insertAttach(String ID,byte[] data);
	
	@Select("SELECT ATTACHMENT from POP_ATTACH_INFO WHERE ID = #{ID}")
	public Object getAttach(String ID);
	
	@Update("UPDATE POP_ATTACHMENT_INFO SET IMAGE = empty_blob() WHERE ID = #{ID}")
	public void updateAttachment(String ID);
}