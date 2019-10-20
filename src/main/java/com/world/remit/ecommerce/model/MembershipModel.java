package com.world.remit.ecommerce.model;

import java.util.Date;

import com.world.remit.ecommerce.types.Membership_Type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class MembershipModel {
	
	private int membershipId;
	private String memberShipNumber;
	private Date memberShipStartDate;
	private Date memberShipEndDate;
	private Membership_Type membershipType;
	private boolean isActive;
	
	
}
