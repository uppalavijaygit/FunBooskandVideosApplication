package com.fun.boos.videos.response;

public class Address {
	
	private String cutomerId;
	private String hno;
	private String streetName;
	private String county;
	private String pinCode;
	
	
	
	public Address(String cutomerId, String hno, String streetName, String county, String pinCode) {
		this.cutomerId = cutomerId;
		this.hno = hno;
		this.streetName = streetName;
		this.county = county;
		this.pinCode = pinCode;
	}
	public String getCutomerId() {
		return cutomerId;
	}
	public void setCutomerId(String cutomerId) {
		this.cutomerId = cutomerId;
	}
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	
	
	
	

}
