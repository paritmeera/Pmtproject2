package com.pmt.agentreg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.agentreg.domain.PhotoUploadDomain;
import com.pmt.agentreg.model.PhotoUpload;

public interface PhotoUploadRepository extends JpaRepository<PhotoUploadDomain, String> {
	
	String save(PhotoUpload phupload);

}
