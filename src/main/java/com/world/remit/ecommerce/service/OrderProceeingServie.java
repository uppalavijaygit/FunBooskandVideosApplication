package com.world.remit.ecommerce.service;

import org.springframework.stereotype.Service;

import com.world.remit.ecommerce.model.PurchaseOrderRequest;
import com.world.remit.ecommerce.model.PurchaseOrderResponse;

@Service
public interface OrderProceeingServie {
	
	public PurchaseOrderResponse processOrder(PurchaseOrderRequest request) throws Exception;

}
