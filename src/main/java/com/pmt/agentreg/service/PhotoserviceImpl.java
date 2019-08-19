package com.pmt.agentreg.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.agentreg.dao.PhotoUploadDao;
import com.pmt.agentreg.domain.PhotoUploadDomain;
import com.pmt.agentreg.mapper.PhotoMapper;
import com.pmt.agentreg.model.PhotoUpload;


@Service
public class PhotoserviceImpl implements PhotoService {

	@Autowired
	PhotoUploadDao photoDao;
	
	@Autowired
	PhotoMapper mapper;
	
	
	@Override
	public void savePhoto(PhotoUpload photo) {
		
		PhotoUploadDomain photoDomain = new PhotoUploadDomain();
		BeanUtils.copyProperties(photo, photoDomain);
		photoDao.savePhoto(photoDomain);	
	}
	
}
