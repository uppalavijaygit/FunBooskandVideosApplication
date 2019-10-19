package com.world.remit.ecommerce.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.world.remit.ecommerce.entity.UserAddressEntity;

@Repository
@Transactional
public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Long> {

}

