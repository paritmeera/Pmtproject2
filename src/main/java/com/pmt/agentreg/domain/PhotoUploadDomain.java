package com.pmt.agentreg.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties(prefix = "file")
//@Embeddable
@Entity
@Table(name="photo")
public class PhotoUploadDomain {

	
	@Id
	@Column(name="pid",nullable=false)
	private String pid;
	
	@Lob
	@Column(name="agentphoto")
	private byte[] agentphoto;
	
	
	public PhotoUploadDomain() {
		super();
	}

	public PhotoUploadDomain(String pid, byte[] agentphoto) {
		super();
		this.pid = pid;
		this.agentphoto = agentphoto;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public byte[] getAgentphoto() {
		return agentphoto;
	}

	public void setAgentphoto(byte[] agentphoto) {
		this.agentphoto = agentphoto;
	}
	
	
	
	/*@Id
	@Column(name="photo_id",nullable=false)
	private String photoId;
	
	@Column(name="photo_Name")
	private String PhotoName;
			
	@Column(name="photo_data")
	private byte[] photodata;

	@Column(name="photo_type")
	private String phtype;
	
	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getPhotoName() {
		return PhotoName;
	}

	public void setPhotoName(String photoName) {
		PhotoName = photoName;
	}

	public byte[] getPhotodata() {
		return photodata;
	}

	public void setPhotodata(byte[] photodata) {
		this.photodata = photodata;
	}

	public String getPhtype() {
		return phtype;
	}

	public void setPhtype(String phtype) {
		this.phtype = phtype;
	}*/
	

}
