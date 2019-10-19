package com.world.remit.ecommerce.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Fun Books & Videos PurchaseOrderRequest Information")
public class PurchaseOrderRequest {
	
	@NotBlank(message ="PurchaseOrderId is required")
	@Size(min=5, max=10, message = "Please use 4 to 5 characters")
	@ApiModelProperty(notes = "Shoud be minimum of 4",example = "PR1234")
	private String purchaseOrderId;
	
	@NotNull
	@ApiModelProperty(notes = "Shoud be minimum of 3 and Max 5",example = "101")
	@Min(101)
	@Digits(integer=10, fraction=0)
	private long customerId;
	
	@NotNull
	@ApiModelProperty(notes = "Shoud not empty" ,example = "50.00 ")
	@Digits(integer=6, fraction=2)
	@Min(value = 0L, message = "The value must be positive")
	private double totalAmount;
	
	@NotNull
	@ApiModelProperty(notes = "Shoud Either PRODUCT OR MEMBERSHIP",example = "MEMBERSHIP")
	private RequestType requestType;
	
	@NotNull
	private PurchaseOrderDetails orderDetails;
	

	public RequestType getRequestType() {
		return requestType;
	}
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
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
	public PurchaseOrderDetails getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(PurchaseOrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	
	
}
