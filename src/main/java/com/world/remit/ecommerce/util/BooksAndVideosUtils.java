package com.world.remit.ecommerce.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.world.remit.ecommerce.dao.FunBooksAndVideosDao;
import com.world.remit.ecommerce.entity.ShippingSlipEntity;
import com.world.remit.ecommerce.entity.UserAddressEntity;
import com.world.remit.ecommerce.exceptions.ProductNotException;
import com.world.remit.ecommerce.model.Product;
import com.world.remit.ecommerce.model.PurchaseOrderDetails;
import com.world.remit.ecommerce.model.ShippingSlip;
import com.world.remit.ecommerce.model.request.PurchaseOrderRequest;


public class BooksAndVideosUtils {
	
	
	
	public static boolean verifyPhysicalProduct(PurchaseOrderDetails orderDetails) throws Exception {
		Optional<Product> employeeOptional = Optional.ofNullable(orderDetails.getProduct());
		return employeeOptional.isPresent() ? Boolean.TRUE : Boolean.FALSE;
	}

	public ShippingSlip prepareShippingSlip(UserAddressEntity userAddressEntity) throws Exception {
		if(userAddressEntity==null) {
			return new ShippingSlip();
		}
		String deliveryDate = generateDeliveryDate(userAddressEntity.getPinCode());
		StringBuffer fullAddress = new StringBuffer(userAddressEntity.getHno()).append(", ").append(userAddressEntity.getStreetName()).append(", ")
				.append(userAddressEntity.getArea()).append(", ").append(userAddressEntity.getCounty()).append(", ").append(userAddressEntity.getPinCode());
		return new ShippingSlip(userAddressEntity.getCustomerId(), null, null, null, deliveryDate, userAddressEntity.getAddressType(), fullAddress.toString());
		
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
