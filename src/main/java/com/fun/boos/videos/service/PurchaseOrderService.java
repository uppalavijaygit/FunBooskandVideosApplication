package com.fun.boos.videos.service;

import com.fun.boos.videos.request.PurchaseOrderRequest;
import com.fun.boos.videos.response.PurchaseOrderResponse;

public interface PurchaseOrderService {
	
	public PurchaseOrderResponse processOrder(PurchaseOrderRequest request);

}
