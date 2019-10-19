package com.world.remit.ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "USER_MEMBERSHIP")
public class UserMembershipEnity {
	
	@Id
	private long customerId;
	
	@Column
	private String membershipType; 
	
	@Column
	private Date memberShipStartDate; 
	
	@Column
	private Date memberShipExpiryDate; 
	
	@Column
	private boolean isActive;
	
	public UserMembershipEnity() {
		
	}

	
	public UserMembershipEnity(long customerId, String membershipType, Date memberShipStartDate,
			Date memberShipExpiryDate, boolean isActive) {
		this.customerId = customerId;
		this.membershipType = membershipType;
		this.memberShipStartDate = memberShipStartDate;
		this.memberShipExpiryDate = memberShipExpiryDate;
		this.isActive = isActive;
	}


	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public Date getMemberShipStartDate() {
		return memberShipStartDate;
	}

	public void setMemberShipStartDate(Date memberShipStartDate) {
		this.memberShipStartDate = memberShipStartDate;
	}

	public Date getMemberShipExpiryDate() {
		return memberShipExpiryDate;
	}

	public void setMemberShipExpiryDate(Date memberShipExpiryDate) {
		this.memberShipExpiryDate = memberShipExpiryDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	} 
	
	
	

}
