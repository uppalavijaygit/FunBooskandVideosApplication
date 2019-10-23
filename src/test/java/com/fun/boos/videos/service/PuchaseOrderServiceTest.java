package com.fun.boos.videos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.fun.boos.videos.request.Item;
import com.fun.boos.videos.request.PurchaseOrderRequest;
import com.fun.boos.videos.response.PurchaseOrderResponse;
import com.fun.boos.videos.respoonse.ShippingSlip;
import com.fun.boos.videos.serviceImpl.PuchaseOrderImpl;


@DisplayName("when running PuchaseOrderService")
public class PuchaseOrderServiceTest {
	
	PurchaseOrderService serviceObj;
	
	@BeforeEach
	void init() {
		serviceObj = new PuchaseOrderImpl();
	}
	
	@Nested
	@DisplayName("On MemberShip Scenario")
	class TestProcessOrderMemberShip{
		@Test
		@DisplayName("with null Request Obj")
		void testprocessOrderWithOnlyMemberShip() {
			PurchaseOrderRequest request=null;
			PurchaseOrderResponse response = serviceObj.processOrder(request);
			assertEquals(Boolean.FALSE,response.isValidrequest(), ()->"Should return False");
		}
		
		@Test
		@DisplayName("with Book MemberShip BookClub")
		void testprocessOrderBookPurchase() {
			PurchaseOrderRequest request=new PurchaseOrderRequest();
			request.setCustomerId(101);
			request.setPurchaseOrderId("PO1234");
			request.setTotalAmount(50.00);
			request.setItemLine(new Item("", "","BOOK_CLUB"));
			Boolean response = serviceObj.processOrder(request).isAccountActivated();
			assertEquals(Boolean.TRUE,response, ()->"Should Update Customer Account to Active");
		}
		
		@Test
		@DisplayName("with Book MemberShip and Null Product")
		void testprocessOrderBookPurchaseNullProduct() {
			PurchaseOrderRequest request=new PurchaseOrderRequest();
			request.setCustomerId(101);
			request.setPurchaseOrderId("PO1234");
			request.setTotalAmount(50.00);
			request.setItemLine(new Item(null, null,"BOOK_CLUB"));
			Boolean response = serviceObj.processOrder(request).isAccountActivated();
			assertEquals(Boolean.TRUE,response, ()->"Should Update Customer Account to Active");
		}
		
		@Test
		@DisplayName("with Invalid MemberShip MemberShip and Null Product")
		void testprocessOrderBookPurchaseInValidMemberSHip() {
			PurchaseOrderRequest request=new PurchaseOrderRequest();
			request.setCustomerId(101);
			request.setPurchaseOrderId("PO1234");
			request.setTotalAmount(50.00);
			request.setItemLine(new Item(null, null,"NO_MEMBER"));
			Boolean response = serviceObj.processOrder(request).isAccountActivated();
			assertEquals(Boolean.FALSE,response, ()->"Should Not Update Customer Account to Active");
		}
		
		
		
	}
	
	
	@Nested
	@DisplayName("On Payment Slip Scenario")
	class TestProcessOrderShippingSlip{
		
		@Test
		@DisplayName("with Book Purchase Request Obj")
		void testprocessOrderBookPurchase() {
			PurchaseOrderRequest request=new PurchaseOrderRequest();
			request.setCustomerId(101);
			request.setPurchaseOrderId("PO1234");
			request.setTotalAmount(50.00);
			request.setItemLine(new Item(null, "My Book 1",""));
			PurchaseOrderResponse response = serviceObj.processOrder(request);
			long returnCutomerId = response.getSlip().getCustomerId();
			ShippingSlip expected = new ShippingSlip(request.getCustomerId(), "SKU1234", "", "HOME", "");
			assertEquals(expected.getCustomerId(),returnCutomerId, ()->"Should Generate Shipping Slip");
		}
		
		@Test
		@DisplayName("with Video Purchase Request Obj")
		void testprocessOrderVideoPurchase() {
			PurchaseOrderRequest request=new PurchaseOrderRequest();
			request.setCustomerId(101);
			request.setPurchaseOrderId("PO1234");
			request.setTotalAmount(50.00);
			request.setItemLine(new Item("Video Product","",""));
			PurchaseOrderResponse response = serviceObj.processOrder(request);
			long returnCutomerId = response.getSlip().getCustomerId();
			ShippingSlip expected = new ShippingSlip(request.getCustomerId(), "SKU1234", "", "HOME", "");
			assertEquals(expected.getCustomerId(),returnCutomerId, ()->"Should Generate Shipping Slip");
		}
		
		@Test
		@DisplayName("with Product & Book Club MemberShip Purchase Request Obj")
		void testprocessOrderVideoPurchaseAndMemberShip() {
			PurchaseOrderRequest request=new PurchaseOrderRequest();
			request.setCustomerId(101);
			request.setPurchaseOrderId("PO1234");
			request.setTotalAmount(50.00);
			request.setItemLine(new Item("","Book Title","BOOK_CLUB"));
			PurchaseOrderResponse response = serviceObj.processOrder(request);
			long returnCutomerId = response.getSlip().getCustomerId();
			ShippingSlip expected = new ShippingSlip(request.getCustomerId(), "SKU1234", "", "HOME", "");
			assertEquals(expected.getCustomerId(),returnCutomerId, ()->"Should Generate Shipping Slip");
		}
		
		@Test
		@DisplayName("with Only MemberShip Request Obj")
		void testprocessOrderMemberShipPurchaseAndMemberShip() {
			PurchaseOrderRequest request=new PurchaseOrderRequest();
			request.setCustomerId(101);
			request.setPurchaseOrderId("PO1234");
			request.setTotalAmount(50.00);
			request.setItemLine(new Item("","","BOOK_CLUB"));
			PurchaseOrderResponse response = serviceObj.processOrder(request);
			Boolean returnCutomerId = response.isShippingSlipProcessed();
			assertEquals(Boolean.FALSE,returnCutomerId, ()->"Should Not Generate Shipping Slip");
		}
		
		@Test
		@DisplayName("with Invalid MemberShip MemberShip and Null Product")
		void testprocessOrderBookPurchaseInValidMemberShipNoSlip() {
			PurchaseOrderRequest request=new PurchaseOrderRequest();
			request.setCustomerId(101);
			request.setPurchaseOrderId("PO1234");
			request.setTotalAmount(50.00);
			request.setItemLine(new Item(null, null,"NO_MEMBER"));
			Boolean response = serviceObj.processOrder(request).isAccountActivated();
			assertEquals(Boolean.FALSE,response, ()->"Should Not Generate Shipping Slip");
		}
		
	}

}
