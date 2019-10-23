package com.world.remit.ecommerce.mode.response;

import java.util.Date;

import com.world.remit.ecommerce.model.ShippingSlip;

public class PurchaseOrderResponse {
	
	private String purchaseOrderId;
	private long customerId;
	private double totalAmount;
	private String requestType;
	private String mebershipType;
	private Date membershipStartDate;
	private Date membershipExpiryDate;
	ShippingSlip shippingSlip;
	private boolean isActive;
	
	public PurchaseOrderResponse() {
	}

	public PurchaseOrderResponse(String purchaseOrderId, long customerId, double totalAmount, String requestType,
			String mebershipType, Date membershipStartDate, Date membershipExpiryDate, ShippingSlip shippingSlip,
			boolean isActive) {
		this.purchaseOrderId = purchaseOrderId;
		this.customerId = customerId;
		this.totalAmount = totalAmount;
		this.requestType = requestType;
		this.mebershipType = mebershipType;
		this.membershipStartDate = membershipStartDate;
		this.membershipExpiryDate = membershipExpiryDate;
		this.shippingSlip = shippingSlip;
		this.isActive = isActive;
	}

	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public ShippingSlip getShippingSlip() {
		return shippingSlip;
	}


	public void setShippingSlip(ShippingSlip shippingSlip) {
		this.shippingSlip = shippingSlip;
	}


	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}



	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}



	public long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}



	public double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	public String getRequestType() {
		return requestType;
	}



	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}



	public String getMebershipType() {
		return mebershipType;
	}



	public void setMebershipType(String mebershipType) {
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
