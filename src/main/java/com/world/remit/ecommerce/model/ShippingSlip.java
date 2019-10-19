package com.world.remit.ecommerce.model;

public class ShippingSlip {
	
	private long customerId;
	private String productId;
	private String productType;
	private String productName;
	private String deliveryDate;
	private String deliveryAddressType;
	private String deliveryAddress;
	
	
	
	public ShippingSlip() {
	}

	public ShippingSlip(long customerId, String productId, String productType, String productName, String deliveryDate,
			String deliveryAddressType, String deliveryAddress) {
		this.customerId = customerId;
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
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

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	@Override
	public String toString() {
		return "ShippingSlip [customerId=" + customerId + ", productId=" + productId + ", productType=" + productType
				+ ", productName=" + productName + ", deliveryDate=" + deliveryDate + ", deliveryAddressType="
				+ deliveryAddressType + ", deliveryAddress=" + deliveryAddress + "]";
	}
	
	
	
	

}
