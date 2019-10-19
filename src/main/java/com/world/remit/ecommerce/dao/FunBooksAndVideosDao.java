package com.world.remit.ecommerce.dao;

import org.springframework.stereotype.Service;

import com.world.remit.ecommerce.entity.UserAddressEntity;
import com.world.remit.ecommerce.entity.UserMembershipEnity;


@Service
public interface FunBooksAndVideosDao {
	
	public UserMembershipEnity updateMemberShipDetails(UserMembershipEnity entity) throws Exception;

	public UserAddressEntity getCustomerAddress(long cutomerId) throws Exception;

}
