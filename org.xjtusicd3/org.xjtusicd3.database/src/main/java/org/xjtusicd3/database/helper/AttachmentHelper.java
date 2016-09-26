package org.xjtusicd3.database.helper;

import java.io.OutputStream;
import java.sql.Blob;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.PersistenceAttachmentMapper;
import org.xjtusicd3.database.model.PersistenceAttachment;



//import org.springframework.util.FileCopyUtils;

/**
 * @author zhangxu
 *
 */
public class AttachmentHelper {
	
	public static void newAttach(String ID,byte[] data) throws Exception{
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(false);
		OutputStream out = null;
		try {
			PersistenceAttachmentMapper mapper = session.getMapper(PersistenceAttachmentMapper.class);
			mapper.newAttachment(ID);
			PersistenceAttachment attachment = mapper.getBlob(ID);
			
			Blob blob = (Blob)attachment.getAttachFile();
			if (blob == null) {
				session.rollback(true);
			} else {
				out = blob.setBinaryStream(0);
				out.write(data);
				out.flush();
				out.close();

			}
		} catch (Exception e) {
			throw new Exception("newAttachment to db error");
		}finally{
			session.commit();
			session.close();
		}
		
	}
	
	
	public static byte[] getAttach(String ID) throws Exception {
		byte[] data = null;
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		try {
			PersistenceAttachmentMapper mapper = session.getMapper(PersistenceAttachmentMapper.class);
			PersistenceAttachment pAttachment = mapper.getAttachment(ID);
			if (pAttachment == null) {
				return null;
			} else {
				Blob img = (Blob)pAttachment.getAttachFile();
				int length = (int)img.length();
				data = img.getBytes(1, length);
			}	
		} catch (Exception e) {
			throw new Exception("getAttach from db error");
		}
		
		return data;
	}
	
	public static void deleteAttach(String ID) throws Exception {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		try {
			PersistenceAttachmentMapper mapper = session.getMapper(PersistenceAttachmentMapper.class);
			mapper.deleteAttachment(ID);
		} catch (Exception e) {
			throw new Exception("deleteAttach from db error ID " + ID);
		}finally{
			session.close();
		}
	}
	
	public static void updateAttach(String ID,byte[] data) throws Exception{
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(false);
			OutputStream out = null;
			try {
				PersistenceAttachmentMapper mapper = session.getMapper(PersistenceAttachmentMapper.class);
				mapper.updateAttachment(ID);
				PersistenceAttachment attachment = mapper.getBlob(ID);
				
				Blob blob = (Blob)attachment.getAttachFile();
				if (blob == null) {
					session.rollback(true);
				} else {
					out = blob.setBinaryStream(0);
					out.write(data);
					out.flush();
					out.close();
				}
			} catch (Exception e) {
				throw new Exception("updateAttachment to db error");
			}finally{
				session.commit();
				session.close();
			}
			
		}
	
	public static PersistenceAttachment getAppLogoPath(String appCode) throws Exception {
		PersistenceAttachment attachment = null;
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		try {
			PersistenceAttachmentMapper mapper = session.getMapper(PersistenceAttachmentMapper.class);
			attachment = mapper.getAppLogoPath(appCode);
		} catch (Exception e) {
			throw new Exception("get appLogoPath from db error");
		}finally{
			session.close();
		}
		
		return attachment;
	}
	
	public static void deleteAppLogoPath(String appCode) throws Exception {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		try {
			PersistenceAttachmentMapper mapper = session.getMapper(PersistenceAttachmentMapper.class);
			mapper.deleteAppLogoPath(appCode);
		} catch (Exception e) {
			throw new Exception("delete attachment error");
		}finally{
			session.close();
		}
	}
}
