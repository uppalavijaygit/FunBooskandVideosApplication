package com.world.remit.ecommerce.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.world.remit.ecommerce.dao.FunBooksAndVideosDao;
import com.world.remit.ecommerce.entity.UserAddressEntity;
import com.world.remit.ecommerce.entity.UserMembershipEnity;
import com.world.remit.ecommerce.exceptions.CustomerAddrNotFoundException;
import com.world.remit.ecommerce.exceptions.InvalidCustomerException;
import com.world.remit.ecommerce.model.Membership_Type;
import com.world.remit.ecommerce.model.PurchaseOrderDetails;
import com.world.remit.ecommerce.model.PurchaseOrderRequest;
import com.world.remit.ecommerce.model.PurchaseOrderResponse;
import com.world.remit.ecommerce.model.RequestType;
import com.world.remit.ecommerce.model.ShippingSlip;
import com.world.remit.ecommerce.repository.UserMemberShipRepository;
import com.world.remit.ecommerce.service.OrderProceeingServie;
import com.world.remit.ecommerce.util.BooksAndVideosUtils;

@Component
@Qualifier("orderProceeingServie")
public class OrderProcessingServiceImpl implements OrderProceeingServie {
	
	
	@Autowired
	UserMemberShipRepository repository;
	
	@Autowired
	FunBooksAndVideosDao funBooksAndVideosDao;

	@Override
	public PurchaseOrderResponse processOrder(PurchaseOrderRequest request) throws Exception {
		
		UserMembershipEnity entity;
		PurchaseOrderResponse response = new PurchaseOrderResponse();
		
		response.setCustomerId(request.getCustomerId());
		response.setRequestType(request.getRequestType().toString());
		
		if(request.getRequestType().equals(RequestType.MEMBERSHIP)) {
			entity = new UserMembershipEnity();
			entity.setCustomerId(request.getCustomerId());
			entity.setActive(Boolean.TRUE);
			entity.setMembershipType(request.getOrderDetails().getMebershipType().toString());
			entity.setMemberShipStartDate(request.getOrderDetails().getMembershipStartDate());
			entity.setMemberShipExpiryDate(request.getOrderDetails().getMembershipExpiryDate());
			funBooksAndVideosDao.updateMemberShipDetails(entity);
			response.setMebershipType(request.getOrderDetails().getMebershipType().toString());
			response.setMembershipExpiryDate(request.getOrderDetails().getMembershipStartDate());
			response.setMembershipExpiryDate(request.getOrderDetails().getMembershipExpiryDate());
		}
		if(BooksAndVideosUtils.verifyPhysicalProduct(request.getOrderDetails())) {
			Optional<UserAddressEntity> userAddressEntity = Optional.of(funBooksAndVideosDao.getCustomerAddress(request.getCustomerId()));
			userAddressEntity.orElseThrow(()-> new CustomerAddrNotFoundException("Address Not Found"));
			Optional<ShippingSlip>  shippingSlip =  Optional.of(BooksAndVideosUtils.prepareShippingSlip(userAddressEntity.get()));
			shippingSlip.orElseThrow(()->new InvalidCustomerException("Unable to get Shipping Details "));
			response.setShippingSlip(shippingSlip.get());
			System.out.println(shippingSlip.toString());
		}
		return response;
	}}
