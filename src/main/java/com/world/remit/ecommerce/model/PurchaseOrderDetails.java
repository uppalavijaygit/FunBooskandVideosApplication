package com.world.remit.ecommerce.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Required;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.world.remit.ecommerce.types.Membership_Type;
import com.world.remit.ecommerce.types.RequestType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Fun Books & Videos PurchaseOrderDetails Information")
public class PurchaseOrderDetails{

//	@NotNull(message = "Requested Type should not be null. Shoud Either PRODUCT OR MEMBERSHIP")
//	@ApiModelProperty(notes = "Shoud Either PRODUCT OR MEMBERSHIP",example = "MEMBERSHIP")
//	private RequestType requestType;
	
	@NotNull
	private Product product;
	
	@NotNull
	@ApiModelProperty(notes = "Shoud Either BookClub OR VideoClub",example = "BOOK_CLUB or VIDEO_CLUB or PREMIUM")
	private Membership_Type mebershipType;
	
	@NotNull
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date membershipStartDate;
	
	@NotNull
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date membershipExpiryDate;
	
	
	
	
	public PurchaseOrderDetails() {
	}
	
	
	public PurchaseOrderDetails(
			Product product, Membership_Type mebershipType, Date membershipStartDate,
		    Date membershipExpiryDate) {
		//this.requestType = requestType;
		this.product = product;
		this.mebershipType = mebershipType;
		this.membershipStartDate = membershipStartDate;
		this.membershipExpiryDate = membershipExpiryDate;
	}
//	public RequestType getRequestType() {
//		return requestType;
//	}
//	public void setRequestType(RequestType requestType) {
//		this.requestType = requestType;
//	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Membership_Type getMebershipType() {
		return mebershipType;
	}
	public void setMebershipType(Membership_Type mebershipType) {
		this.mebershipType = mebershipType;
	}
	public Date getMembershipStartDate() {
		return membershipStartDate;
	}
	public void setMembershipStartDate(Date membershipStartDate) {
		this.membershipStartDate = membershipStartDate;
	}
	public Date getMembershipExpiryDate() {
		return membershipExpiryDate;
	}
	public void setMembershipExpiryDate(Date membershipExpiryDate) {
		this.membershipExpiryDate = membershipExpiryDate;
	}

}
