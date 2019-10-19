package com.world.remit.ecommerce.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.world.remit.ecommerce.entity.UserMembershipEnity;

@Repository
@Transactional
public interface UserMemberShipRepository extends JpaRepository<UserMembershipEnity, Long> {

}
