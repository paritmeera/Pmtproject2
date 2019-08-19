package com.pmt.agentreg.domain;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.pmt.agentreg.model.PhotoUpload;

//import com.pmt.agentreg.model.PhotoUpload1;

//@XmlRootElement(name = "employee")
//@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="AGENT_DETAILS")
public class AgentDomain {
	
	private static final long serialVersionUID = 2891045257117832183L;
	
	@Id
	@Column(name="AGENT_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int agent_id;
	
	
	@NotEmpty(message = "first name must not be empty")
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@NotEmpty(message = "last name must not be empty")
	@Column(name="LAST_NAME")
	private String lastName;
	
	@NotEmpty(message = "email must not be empty")
  //@Email(message = "email should be a valid email")
	@Column(name="EMAIL",unique=true)
	private String email;
	
	
	@NotEmpty(message = "Mobile number must not be empty")
	@Size(max=10)
	@Column(name="MOBILE_NO",unique=true)
	private String mobileNo;
	
	@NotNull
	@Column(name="DATE_OF_BIRTH")
	private String dateOfBirth;
	
	
	@NotNull
	@Column(name="GENDER")
	private String gender;
	
	@NotNull
	@Column(name="GST_NO")
	private String gst_no;
	
	@NotEmpty(message =" adhar number is mandatory")
//	@Size(min=12, message="adhar number should have atleast 12 digits")
	@Column(name="ADHAR_NO" ,unique=true)
	private String adhar_no;
	
	@Column(name ="pannumber")
	private String pannumber;
	
	/*@Column(name ="nameonpan")
	private String nameonpan;*/
	
	@Column(name ="ADDRESSLINE1")
	private String addressLine1;
	
	@Column(name ="ADDRESSLINE2")
	private String addressLine2;
	
	@Column(name ="CITY")
	private String city;
	
	@Column(name ="STATE")
	private String state;
	
	@Column(name ="PINCODE")
	private int pincode;
	
	@Column(name ="COUNTRY")
	private String country;
			
	@NotEmpty
	@Column(name="PASSWORD")
	private String password;
	
	@NotEmpty
	@Column(name="CONFIRMPASSWORD")
	private String confirmpassword;
	
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	@Column(name="IS_ACTIVE")
	private boolean isActive;
	
	@Column(name="ACCOUNT_HOLDER_NAME")
	private String accountHolderName;
	
	@NotEmpty(message = "phone number must not be empty")
	@Size(max=10)
	@Column(name="PHONE_NO",unique=true)
	private String PhoneNo;
	
	@Column(name="ACCOUNT_TYPE")
	private String accountType;
	
	@Column(name="BANKACCOUNT_NO")
	private String bankAccountNo;
	
	@Column(name="IFSC_CODE")
	private String ifscCode;
	
	@Column(name="BRANCH")
	private String branch;
	

	/*@Embedded
	private PhotoUploadDomain photoUpload;
	
	public PhotoUploadDomain getPhotoUpload() {
		return photoUpload;
	}
	public void setPhotoUpload(PhotoUploadDomain photoUpload) {
		this.photoUpload = photoUpload;
	}*/
	
	
	public int getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGst_no() {
		return gst_no;
	}
	public void setGst_no(String gst_no) {
		this.gst_no = gst_no;
	}
	
	public String getAdhar_no() {
		return adhar_no;
	}
	public void setAdhar_no(String adhar_no) {
		this.adhar_no = adhar_no;
	}
	
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	
	/*public String getNameonpan() {
		return nameonpan;
	}
	public void setNameonpan(String nameonpan) {
		this.nameonpan = nameonpan;
	}*/
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}

	

}
