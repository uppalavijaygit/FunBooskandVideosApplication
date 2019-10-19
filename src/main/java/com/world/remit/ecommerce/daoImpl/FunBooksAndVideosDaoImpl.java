package com.world.remit.ecommerce.daoImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.world.remit.ecommerce.dao.FunBooksAndVideosDao;
import com.world.remit.ecommerce.entity.UserAddressEntity;
import com.world.remit.ecommerce.entity.UserMembershipEnity;
import com.world.remit.ecommerce.exceptions.InvalidCustomerException;
import com.world.remit.ecommerce.repository.UserAddressRepository;
import com.world.remit.ecommerce.repository.UserMemberShipRepository;

@Component
public class FunBooksAndVideosDaoImpl implements FunBooksAndVideosDao {
	

	@Autowired
	UserMemberShipRepository repository;
	
	@Autowired
	UserAddressRepository addressRepository;

	@Override
	public UserMembershipEnity updateMemberShipDetails(UserMembershipEnity entity) throws Exception {
		Optional<UserMembershipEnity> userMembershipEnityOptional = Optional.of(repository.save(entity));
		userMembershipEnityOptional.orElseThrow(()-> new InvalidCustomerException("Customer Not Found!!!"));
		return userMembershipEnityOptional.get();
	}

	@Override
	public UserAddressEntity getCustomerAddress(long cutomerId) throws Exception {
		Optional<UserAddressEntity> userAddressEntity = addressRepository.findById(cutomerId);
		userAddressEntity.orElseThrow(()->new Exception("Address Not found"));
		return userAddressEntity.get();
	}

}
