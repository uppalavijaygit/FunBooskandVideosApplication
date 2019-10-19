package com.world.remit.ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ADDRESS")
public class UserAddressEntity {
	
	@Id
	private long customerId;
	
	@Column
	private String addressType; 
	
	@Column
	private String hno; 
	
	@Column
	private String streetName; 
	
	@Column
	private String area;
	
	@Column
	private String county;
	
	@Column
	private String pinCode;
	
	
	

	public UserAddressEntity() {
	}



	public UserAddressEntity(long customerId, String addressType, String hno, String streetName, String area, String county,
			String pinCode) {
		this.customerId = customerId;
		this.addressType = addressType;
		this.hno = hno;
		this.streetName = streetName;
		this.area = area;
		this.county = county;
		this.pinCode = pinCode;
	}



	public long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}



	public String getAddressType() {
		return addressType;
	}



	public void setAddressType(String addressType) {
		this.addressType = addressType;
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



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
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
