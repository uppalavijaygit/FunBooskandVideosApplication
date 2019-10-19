package com.world.remit.ecommerce.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;

import com.world.remit.ecommerce.dao.FunBooksAndVideosDao;
import com.world.remit.ecommerce.entity.ShippingSlipEntity;
import com.world.remit.ecommerce.entity.UserAddressEntity;
import com.world.remit.ecommerce.exceptions.ProductNotException;
import com.world.remit.ecommerce.model.Product;
import com.world.remit.ecommerce.model.PurchaseOrderDetails;
import com.world.remit.ecommerce.model.PurchaseOrderRequest;
import com.world.remit.ecommerce.model.ShippingSlip;

public class BooksAndVideosUtils {
	
	
	
	public static boolean verifyPhysicalProduct(PurchaseOrderDetails orderDetails) throws Exception {
		Optional<Product> employeeOptional = Optional.ofNullable(orderDetails.getProduct());
		return employeeOptional.isPresent() ? Boolean.TRUE : Boolean.FALSE;
	}

	public static ShippingSlip prepareShippingSlip(UserAddressEntity userAddressEntity) throws Exception {
		String deliveryDate = generateDeliveryDate(userAddressEntity.getPinCode());
		StringBuffer fullAddress = new StringBuffer(userAddressEntity.getHno()).append(userAddressEntity.getStreetName())
				.append(userAddressEntity.getArea()).append(userAddressEntity.getCounty()).append(userAddressEntity.getPinCode());
		return new ShippingSlip(userAddressEntity.getCustomerId(), null, userAddressEntity.getAddressType(), null, deliveryDate, userAddressEntity.getAddressType(), fullAddress.toString());
		
	}
	
	private static String generateDeliveryDate(String pinCode){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 15); // Adds 15 days
		long random = ThreadLocalRandom.current().nextLong(new Date().getTime(), c.getTime().getTime());
		Date date = new Date(random);
		return date.toString();
	}
	

}
