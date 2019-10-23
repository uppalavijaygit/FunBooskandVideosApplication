package com.fun.boos.videos.serviceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import com.fun.boos.videos.dao.FunBooksAndVediosDao;
import com.fun.boos.videos.daoImpl.FunBooksAndVediosDaoImpl;
import com.fun.boos.videos.request.Item;
import com.fun.boos.videos.request.PurchaseOrderRequest;
import com.fun.boos.videos.response.Address;
import com.fun.boos.videos.response.PurchaseOrderResponse;
import com.fun.boos.videos.respoonse.ShippingSlip;
import com.fun.boos.videos.service.PurchaseOrderService;

public class PuchaseOrderImpl implements PurchaseOrderService {
	
	FunBooksAndVediosDao dao = new FunBooksAndVediosDaoImpl();

	public PurchaseOrderResponse processOrder(PurchaseOrderRequest request) {
		PurchaseOrderResponse response = new PurchaseOrderResponse();
		if(request!=null){
			Item item = request.getItemLine();
			if(item.getMemberShipType()!=null && (item.getMemberShipType().equalsIgnoreCase("BOOK_CLUB")|| 
					item.getMemberShipType().equalsIgnoreCase("VIDEO_CLUB") ||item.getMemberShipType().equalsIgnoreCase("PREMIUM"))){
					boolean returnFlag = dao.activateCustiomerAccount(request);
					if(returnFlag) {
						response.setAccountActivated(Boolean.TRUE);
					}else {
						response.setAccountActivated(Boolean.FALSE);
					}
					response.setShippingSlipProcessed(Boolean.FALSE);
			}else {
				response.setAccountActivated(Boolean.FALSE);
				response.setValidrequest(Boolean.FALSE);
				response.setShippingSlipProcessed(Boolean.FALSE);
			}
			if(isProductPurchase(item)){
				ShippingSlip slip = prepareShippingSlip(request);
				response.setSlip(slip);
				response.setShippingSlipProcessed(Boolean.TRUE);
			}else {
				response.setShippingSlipProcessed(Boolean.FALSE);
			}
		}else {
			response.setValidrequest(Boolean.FALSE);
		}
		return response;
	}
	
	private boolean isProductPurchase(Item item) {
		if((item.getBookTitle()!=null && item.getBookTitle().isBlank()) && (item.getVideoTitle()!=null && item.getVideoTitle().isEmpty())){
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	private ShippingSlip prepareShippingSlip(PurchaseOrderRequest request){
		Address customerAddress = dao.getCustomerAddress(request.getCustomerId());
		String deliveryDate = generateDeliveryDate(customerAddress.getPinCode());
		StringBuffer fullAddress = new StringBuffer(customerAddress.getHno()).append(", ").append(customerAddress.getStreetName()).append(", ")
				.append(customerAddress.getCounty()).append(", ").append(customerAddress.getPinCode());
		return new ShippingSlip(request.getCustomerId(), "SKU1234", deliveryDate, "HOME", fullAddress.toString());
		
	}
	
	private String generateDeliveryDate(String pinCode){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 15); // Adds 15 days
		long random = ThreadLocalRandom.current().nextLong(new Date().getTime(), c.getTime().getTime());
		Date date = new Date(random);
		return date.toString();
	}
	
	

}
