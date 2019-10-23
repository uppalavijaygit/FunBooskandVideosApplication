package com.world.remit.ecommerce.daoImpl;

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
import com.world.remit.ecommerce.exceptions.InvalidCustomerException;
import com.world.remit.ecommerce.model.ShippingSlip;
import com.world.remit.ecommerce.repository.UserAddressRepository;
import com.world.remit.ecommerce.repository.UserMemberShipRepository;

@Component
public class FunBooksAndVideosDaoImpl implements FunBooksAndVideosDao {
	

	@Autowired
	UserMemberShipRepository repository;
	
	@Autowired
	UserAddressRepository addressRepository;

	@Override
	public UserMembershipEnity updateMemberShipDetails(UserMembershipEnity entity) throws InvalidCustomerException {
		Optional<UserMembershipEnity> userMembershipEnityOptional = Optional.of(repository.save(entity));
		userMembershipEnityOptional.orElseThrow(()-> new InvalidCustomerException("Customer Not Found!!!"));
		return userMembershipEnityOptional.get();
	}

	@Override
	public UserAddressEntity getCustomerAddress(long cutomerId) throws InvalidCustomerException {
		Optional<UserAddressEntity> userAddressEntity = addressRepository.findById(cutomerId);
		userAddressEntity.orElseThrow(()->new InvalidCustomerException("Address Not found"));
		return userAddressEntity.get();
	}
	
	@Override
	public ShippingSlip prepareShippingSlip(UserAddressEntity userAddressEntity) throws Exception {
		String deliveryDate = generateDeliveryDate(userAddressEntity.getPinCode());
		StringBuffer fullAddress = new StringBuffer(userAddressEntity.getHno()).append(", ").append(userAddressEntity.getStreetName()).append(", ")
				.append(userAddressEntity.getArea()).append(", ").append(userAddressEntity.getCounty()).append(", ").append(userAddressEntity.getPinCode());
		return new ShippingSlip(userAddressEntity.getCustomerId(), null, null, null, deliveryDate, userAddressEntity.getAddressType(), fullAddress.toString());
		
	}
	
	public static String generateDeliveryDate(String pinCode){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 15); // Adds 15 days
		long random = ThreadLocalRandom.current().nextLong(new Date().getTime(), c.getTime().getTime());
		Date date = new Date(random);
		return date.toString();
	}

}
