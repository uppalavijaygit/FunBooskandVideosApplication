package com.world.remit.ecommerce.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Fun Books & Videos PurchaseOrderRequest Information")
public class PurchaseOrderDetails extends PurchaseOrderRequest {

	@NotNull
	@ApiModelProperty(notes = "Shoud Either PRODUCT OR MEMBERSHIP",example = "MEMBERSHIP")
	private RequestType requestType;
	
	@NotNull
	@ApiModelProperty(notes = "Shoud Either Book OR Video",example = "Book")
	private Product  product;
	
	@NotNull
	@ApiModelProperty(notes = "Shoud Either BookClub OR VideoClub",example = "BookClub")
	private Membership_Type mebershipType;
	
	@NotNull
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date membershipStartDate;
	
	@NotNull
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date membershipExpiryDate;
	
	
	public RequestType getRequestType() {
		return requestType;
	}
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
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
