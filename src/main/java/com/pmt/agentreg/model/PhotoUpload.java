package com.pmt.agentreg.model;

import javax.persistence.Embeddable;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
//@Embeddable
public class PhotoUpload {

	private String pid;
	
	private byte[] agentphoto;
	

	public PhotoUpload() {
		super();
	}

	public PhotoUpload(byte[] agentphoto) {
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

}


/*private String photoId;

private String PhotoName;
		
private byte[] photodata;

private String phtype;




public PhotoUpload() {
	super();
}

public PhotoUpload(String photoId, String photoName, byte[] photodata, String phtype) {
	super();
	this.photoId = photoId;
	PhotoName = photoName;
	this.photodata = photodata;
	this.phtype = phtype;
}

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