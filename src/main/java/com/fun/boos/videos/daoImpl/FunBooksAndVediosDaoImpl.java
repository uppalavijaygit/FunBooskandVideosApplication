package com.fun.boos.videos.daoImpl;

import com.fun.boos.videos.dao.FunBooksAndVediosDao;
import com.fun.boos.videos.request.PurchaseOrderRequest;
import com.fun.boos.videos.response.Address;

public class FunBooksAndVediosDaoImpl implements FunBooksAndVediosDao {

	public boolean activateCustiomerAccount(PurchaseOrderRequest request) {
		System.out.println("Customer Account is Activated");
		return Boolean.TRUE;
	}

	public Address getCustomerAddress(long customerId) {
		return new Address("101","16","Medway Road","Kent","DA14PN");
	}

}
