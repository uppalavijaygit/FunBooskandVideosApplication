package com.fun.boos.videos.request;


public class PurchaseOrderRequest {

	
	private String purchaseOrderId;
	private long customerId;
	private double totalAmount;
	private Item itemLine;
	
	
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
	public Item getItemLine() {
		return itemLine;
	}
	public void setItemLine(Item itemLine) {
		this.itemLine = itemLine;
	}
	
	
	
}
