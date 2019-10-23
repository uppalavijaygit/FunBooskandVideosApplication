package com.fun.boos.videos.response;

import com.fun.boos.videos.respoonse.ShippingSlip;

public class PurchaseOrderResponse {
	
	private boolean isValidrequest;
	private ShippingSlip slip;
	private boolean isShippingSlipProcessed;
	private boolean isAccountActivated;
	
	
	
	public boolean isShippingSlipProcessed() {
		return isShippingSlipProcessed;
	}
	public void setShippingSlipProcessed(boolean isShippingSlipProcessed) {
		this.isShippingSlipProcessed = isShippingSlipProcessed;
	}
	public boolean isValidrequest() {
		return isValidrequest;
	}
	public void setValidrequest(boolean isValidrequest) {
		this.isValidrequest = isValidrequest;
	}
	public ShippingSlip getSlip() {
		return slip;
	}
	public void setSlip(ShippingSlip slip) {
		this.slip = slip;
	}
	public boolean isAccountActivated() {
		return isAccountActivated;
	}
	public void setAccountActivated(boolean isAccountActivated) {
		this.isAccountActivated = isAccountActivated;
	}
	
}
