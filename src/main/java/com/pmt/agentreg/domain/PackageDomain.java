package com.pmt.agentreg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlAccessorType(value=XmlAccessType.FIELD)
@XmlRootElement(name="packages")
@Table(name="PACKAGE_DETAILS")
public class PackageDomain {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int packageId;
	
	@Column(name="package_name")
	private String packageName;
	
	@Column(name="number_of_days")
	private String numberOfDays;
	
	@Column(name="number_of_places")
	private String numberOfPlaces;
	
	@Column(name="package_cost")
	private String packagecost;
	
	@Column(name="transfers")
	private String transfers;
	
	@Column(name="hotels")
	private String hotels;
	
	@Column(name="sightseeings")
	private String sightseeings;
	
	@Column(name="museums")
	private String museums;
	
	
	

	public PackageDomain() {
		super();
	}
	

	public PackageDomain(int packageId, String packageName, String numberOfDays, String numberOfPlaces,
			String packagecost, String transfers, String hotels, String sightseeings, String museums) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.numberOfDays = numberOfDays;
		this.numberOfPlaces = numberOfPlaces;
		this.packagecost = packagecost;
		this.transfers = transfers;
		this.hotels = hotels;
		this.sightseeings = sightseeings;
		this.museums = museums;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(String numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public String getNumberOfPlaces() {
		return numberOfPlaces;
	}

	public void setNumberOfPlaces(String numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}

	public String getPackagecost() {
		return packagecost;
	}

	public void setPackagecost(String packagecost) {
		this.packagecost = packagecost;
	}

	public String getTransfers() {
		return transfers;
	}

	public void setTransfers(String transfers) {
		this.transfers = transfers;
	}

	public String getHotels() {
		return hotels;
	}

	public void setHotels(String hotels) {
		this.hotels = hotels;
	}

	public String getSightseeings() {
		return sightseeings;
	}

	public void setSightseeings(String sightseeings) {
		this.sightseeings = sightseeings;
	}

	public String getMuseums() {
		return museums;
	}

	public void setMuseums(String museums) {
		this.museums = museums;
	}
	
	

}
