package com.world.remit.ecommerce.model;

import java.util.Date;

public class PurchaseOrderResponse {
	
	private String purchaseOrderId;
	private long customerId;
	private double totalAmount;
	private String requestType;
	private Product  product;
	private String mebershipType;
	private Date membershipStartDate;
	private Date membershipExpiryDate;
	private ShippingSlip shippingSlip;
	
	
	public PurchaseOrderResponse() {
	}


	public PurchaseOrderResponse(String purchaseOrderId, long customerId, double totalAmount, String requestType,
			Product product, String mebershipType, Date membershipStartDate, Date membershipExpiryDate,
			ShippingSlip shippingSlip) {
		this.purchaseOrderId = purchaseOrderId;
		this.customerId = customerId;
		this.totalAmount = totalAmount;
		this.requestType = requestType;
		this.product = product;
		this.mebershipType = mebershipType;
		this.membershipStartDate = membershipStartDate;
		this.membershipExpiryDate = membershipExpiryDate;
		this.shippingSlip = shippingSlip;
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



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
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
