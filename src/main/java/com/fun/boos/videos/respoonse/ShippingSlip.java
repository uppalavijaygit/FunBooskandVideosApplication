package com.fun.boos.videos.respoonse;


public class ShippingSlip {
	
	private long customerId;
	private String productId;
	private String deliveryDate;
	private String deliveryAddressType;
	private String deliveryAddress;
	
	
	
	
	
	
	public ShippingSlip() {
	}

	public ShippingSlip(long customerId, String productId, String deliveryDate,
			String deliveryAddressType, String deliveryAddress) {
		this.customerId = customerId;
		this.productId = productId;
		this.deliveryDate = deliveryDate;
		this.deliveryAddressType = deliveryAddressType;
		this.deliveryAddress = deliveryAddress;
	}
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDeliveryAddressType() {
		return deliveryAddressType;
	}
	public void setDeliveryAddressType(String deliveryAddressType) {
		this.deliveryAddressType = deliveryAddressType;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	
	

}
