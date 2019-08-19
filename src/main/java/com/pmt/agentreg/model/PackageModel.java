package com.pmt.agentreg.model;



public class PackageModel {
	
	private int packageId;
	private String packageName;
	private String numberOfPlaces;
	private String numberOfDays;
	private String packagecost;
	private String transfers;
	private String hotels;
	private String sightseeings;
	private String museums;
	

	public PackageModel() {
		super();
	}
	
	public PackageModel(int packageId, String packageName, String numberOfPlaces, String numberOfDays,
			String packagecost, String transfers, String hotels, String sightseeings, String museums) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.numberOfPlaces = numberOfPlaces;
		this.numberOfDays = numberOfDays;
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
	public String getNumberOfPlaces() {
		return numberOfPlaces;
	}
	public void setNumberOfPlaces(String numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}
	public String getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(String numberOfDays) {
		this.numberOfDays = numberOfDays;
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
