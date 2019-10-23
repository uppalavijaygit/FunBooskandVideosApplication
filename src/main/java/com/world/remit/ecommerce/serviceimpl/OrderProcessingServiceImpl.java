package com.world.remit.ecommerce.serviceimpl;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.world.remit.ecommerce.dao.FunBooksAndVideosDao;
import com.world.remit.ecommerce.entity.UserAddressEntity;
import com.world.remit.ecommerce.entity.UserMembershipEnity;
import com.world.remit.ecommerce.exceptions.CustomerAddrNotFoundException;
import com.world.remit.ecommerce.exceptions.InvalidCustomerException;
import com.world.remit.ecommerce.mode.response.PurchaseOrderResponse;
import com.world.remit.ecommerce.model.PurchaseOrderDetails;
import com.world.remit.ecommerce.model.ShippingSlip;
import com.world.remit.ecommerce.model.request.PurchaseOrderRequest;
import com.world.remit.ecommerce.repository.UserAddressRepository;
import com.world.remit.ecommerce.repository.UserMemberShipRepository;
import com.world.remit.ecommerce.service.OrderProceeingServie;
import com.world.remit.ecommerce.types.Membership_Type;
import com.world.remit.ecommerce.types.RequestType;
import com.world.remit.ecommerce.util.BooksAndVideosUtils;

@Component
@Qualifier("orderProceeingServie")
public class OrderProcessingServiceImpl implements OrderProceeingServie {
	
	
	@Autowired
	UserMemberShipRepository repository;
	
	@Autowired
	FunBooksAndVideosDao funBooksAndVideosDao;
	
	@Autowired
	UserAddressRepository addressRepository;
	

	public OrderProcessingServiceImpl() {
	}

	@Override
	public PurchaseOrderResponse processOrder(PurchaseOrderRequest request) throws Exception {
		
		UserMembershipEnity entity;
		PurchaseOrderResponse response = null;
		if(request.getRequestType().equals(RequestType.MEMBERSHIP)) {
			entity = processUserMembershipEnity(request);
			//funBooksAndVideosDao.updateMemberShipDetails(entity);
			repository.save(entity);
			response = processResponse(request,entity);
		}
		if(BooksAndVideosUtils.verifyPhysicalProduct(request.getOrderDetails())) {
			// Optional<UserAddressEntity> userAddressEntity = Optional.of(funBooksAndVideosDao.getCustomerAddress(request.getCustomerId()));
			BooksAndVideosUtils utils = new BooksAndVideosUtils();
			Optional<UserAddressEntity> userAddressEntity = addressRepository.findById(request.getCustomerId());
			userAddressEntity.orElseThrow(()-> new CustomerAddrNotFoundException("Address Not Found"));
			Optional<ShippingSlip>  shippingSlip =  Optional.of(utils.prepareShippingSlip(userAddressEntity.get()));
			shippingSlip.orElseThrow(()->new InvalidCustomerException("Unable to get Shipping Details "));
			ShippingSlip slip = shippingSlip.get();
			slip.setProductId(request.getOrderDetails().getProduct().getProductSKU());
			response.setShippingSlip(slip);
		}
		return response;
	}
	
	private Date getMembershipExpiryDate() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 15);
		return c.getTime();
	}
	
	private PurchaseOrderResponse processResponse(PurchaseOrderRequest request,UserMembershipEnity entity) {
		PurchaseOrderResponse response = new PurchaseOrderResponse();
		response.setCustomerId(request.getCustomerId());
		response.setRequestType(request.getRequestType().toString());
		response.setPurchaseOrderId(request.getPurchaseOrderId());
		response.setTotalAmount(request.getTotalAmount());
		response.setMebershipType(request.getOrderDetails().getMebershipType().toString());
		response.setMembershipStartDate(entity.getMemberShipStartDate());
		response.setMembershipExpiryDate(entity.getMemberShipExpiryDate());
		response.setActive(entity.isActive());
		return response;
	}
	
	private UserMembershipEnity processUserMembershipEnity(PurchaseOrderRequest request) {
		UserMembershipEnity entity = new UserMembershipEnity();
		entity.setCustomerId(request.getCustomerId());
		entity.setActive(Boolean.TRUE);
		entity.setMembershipType(request.getOrderDetails().getMebershipType().toString());
		entity.setMemberShipStartDate(new Date());
		entity.setMemberShipExpiryDate(getMembershipExpiryDate());
		return entity;
	}
	
	
	



}
