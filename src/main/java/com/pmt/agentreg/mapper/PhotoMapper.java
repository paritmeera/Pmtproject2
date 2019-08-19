package com.pmt.agentreg.mapper;

import org.springframework.stereotype.Component;

import com.pmt.agentreg.abstractmapper.AbstractModelMapper;
import com.pmt.agentreg.domain.PhotoUploadDomain;
import com.pmt.agentreg.model.PhotoUpload;

@Component
public class PhotoMapper extends AbstractModelMapper<PhotoUpload,PhotoUploadDomain>{
	
	@Override
	public Class<PhotoUpload> entityType()
	{
		return PhotoUpload.class;
	}	
	
	@Override
	public Class<PhotoUploadDomain> modelType() {
		return null;
	}

	

}
