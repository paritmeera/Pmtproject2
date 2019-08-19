package com.pmt.agentreg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pmt.agentreg.domain.PhotoUploadDomain;
import com.pmt.agentreg.response.Response;
import com.pmt.agentreg.status.StatusCode;
import com.pmt.agentreg.utils.CommonUtils;

@Transactional
@Repository
public class PhotoUploadDaoImpl implements PhotoUploadDao {

	private static final Logger logger = LoggerFactory.getLogger(PhotoUploadDaoImpl.class);

	@PersistenceContext
	private EntityManager entitymanager;
	
	/*@Autowired
	private PhotoUploadRepository photorepo;*/
	
	
	
	@Override
	public void savePhoto(PhotoUploadDomain photo) {
		Response response = CommonUtils.getResponseObject("Photo Added");
		
		try {
			
			entitymanager.persist(photo);
			response.setStatus(StatusCode.SUCCESS.name());
		}
		catch(Exception ex)
		{
			logger.error("Exception in savePhoto", ex.getMessage());
			response.setStatus(StatusCode.ERROR.name());
			response.setErrors(ex.getMessage());
		}
	}
}
