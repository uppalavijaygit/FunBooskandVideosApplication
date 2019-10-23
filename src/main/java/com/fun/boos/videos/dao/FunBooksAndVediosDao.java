package com.fun.boos.videos.dao;

import com.fun.boos.videos.request.PurchaseOrderRequest;
import com.fun.boos.videos.response.Address;

public interface FunBooksAndVediosDao {
	public boolean activateCustiomerAccount(PurchaseOrderRequest request);
	
	public Address getCustomerAddress(long customerId);
}
