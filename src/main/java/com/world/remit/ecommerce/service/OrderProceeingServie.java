package com.world.remit.ecommerce.service;

import org.springframework.stereotype.Service;

import com.world.remit.ecommerce.entity.UserAddressEntity;
import com.world.remit.ecommerce.mode.response.PurchaseOrderResponse;
import com.world.remit.ecommerce.model.ShippingSlip;
import com.world.remit.ecommerce.model.request.PurchaseOrderRequest;

@Service
public interface OrderProceeingServie {
	
	public PurchaseOrderResponse processOrder(PurchaseOrderRequest request) throws Exception;

}
