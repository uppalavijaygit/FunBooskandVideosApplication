package com.world.remit.ecommerce.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.world.remit.ecommerce.dao.FunBooksAndVideosDao;
import com.world.remit.ecommerce.daoImpl.FunBooksAndVideosDaoImpl;
import com.world.remit.ecommerce.entity.UserAddressEntity;
import com.world.remit.ecommerce.entity.UserMembershipEnity;
import com.world.remit.ecommerce.mode.response.PurchaseOrderResponse;
import com.world.remit.ecommerce.model.Product;
import com.world.remit.ecommerce.model.PurchaseOrderDetails;
import com.world.remit.ecommerce.model.ShippingSlip;
import com.world.remit.ecommerce.model.request.PurchaseOrderRequest;
import com.world.remit.ecommerce.repository.UserAddressRepository;
import com.world.remit.ecommerce.repository.UserMemberShipRepository;
import com.world.remit.ecommerce.service.OrderProceeingServie;
import com.world.remit.ecommerce.serviceimpl.OrderProcessingServiceImpl;
import com.world.remit.ecommerce.types.Membership_Type;
import com.world.remit.ecommerce.types.RequestType;
import com.world.remit.ecommerce.util.BooksAndVideosUtils;
import com.world.remit.ecommerce.validations.BooksaAndVideosValidationErrorService;

@RunWith(MockitoJUnitRunner.class)
public class OrderServicesApiTest {
	

    private MockMvc mvc;
    
    @InjectMocks
    private OrderServicesApi orderServicesApi;
    
    @InjectMocks
	BooksaAndVideosValidationErrorService validationService;
    
    @InjectMocks
	OrderProceeingServie service = new OrderProcessingServiceImpl();
    
    @InjectMocks
	FunBooksAndVideosDao funBooksAndVideosDao = new FunBooksAndVideosDaoImpl();
    
    @Mock
    UserAddressRepository addressRepository;
    
    @Mock
	UserMemberShipRepository repository;
    
    private JacksonTester<PurchaseOrderRequest> jsonSuperHero;
    
    @Mock
    BooksAndVideosUtils utilsMock = new BooksAndVideosUtils();
    
	@Before
    public void setup() throws Exception {
        JacksonTester.initFields(this, new ObjectMapper());
        
        mvc = MockMvcBuilders.standaloneSetup(orderServicesApi)
                .build();
        
        
        UserAddressEntity userAddressEntity = new UserAddressEntity(101,"HOME","16", "medway road","dartford","kent","DA14PN");
		 UserMembershipEnity entity = new UserMembershipEnity(101,RequestType.MEMBERSHIP.toString(),new Date(), new Date(),Boolean.TRUE);
		 PurchaseOrderRequest request = new PurchaseOrderRequest();
			request.setCustomerId(101);
			request.setPurchaseOrderId("PR1234");
			request.setRequestType(RequestType.MEMBERSHIP);
			request.setTotalAmount(50.00);
			request.setOrderDetails(new PurchaseOrderDetails(new Product(1234,"SKU1234"),Membership_Type.BOOK_CLUB,new Date(), new Date()));
			
			PurchaseOrderResponse orderResponse = new PurchaseOrderResponse();
			orderResponse.setCustomerId(101);
			orderResponse.setPurchaseOrderId("PR1234");
			orderResponse.setTotalAmount(50);
			orderResponse.setRequestType("MEMBERSHIP");
			orderResponse.setMebershipType("BOOK_CLUB");
			orderResponse.setActive(Boolean.TRUE);
			orderResponse.setMembershipStartDate(new Date());
			orderResponse.setMembershipExpiryDate(new Date());
			orderResponse.setShippingSlip(new ShippingSlip((long)101, "SKU1234", "", "", "10-10-10", "HOME", "16medwayroaddartfordkentDA14PN"));
		
			when(repository.save(entity)).thenReturn(entity);
			when(addressRepository.findById(request.getCustomerId())).thenReturn(Optional.of(new UserAddressEntity()));
			
			UserAddressEntity shippingSlipEntity = new UserAddressEntity();
			shippingSlipEntity.setHno("16");
			shippingSlipEntity.setStreetName("Medway Road");
			when(utilsMock.prepareShippingSlip(shippingSlipEntity))
			.thenReturn(new ShippingSlip((long)101, "SKU1234", "", "", "10-10-20", "HOME", "16medwayroaddartfordkentDA14PN"));
			when(service.processOrder(request)).thenReturn(orderResponse);
			when(utilsMock.prepareShippingSlip(shippingSlipEntity))
			.thenReturn(new ShippingSlip((long)101, "SKU1234", "", "", "10-10-20", "HOME", "16medwayroaddartfordkentDA14PN"));
    }
	
	 @Test
	 public void verifyOrderProcessed() throws Exception {

		 PurchaseOrderRequest request = new PurchaseOrderRequest();
			request.setCustomerId(101);
			request.setPurchaseOrderId("PR1234");
			request.setRequestType(RequestType.MEMBERSHIP);
			request.setTotalAmount(50.00);
			request.setOrderDetails(new PurchaseOrderDetails(new Product(1234,"SKU1234"),Membership_Type.BOOK_CLUB,new Date(), new Date()));
		// when
	        MockHttpServletResponse response = mvc.perform(
	                post("/api/processOrder").contentType(MediaType.APPLICATION_JSON).content(
	                        jsonSuperHero.write(request).getJson()
	                )).andReturn().getResponse();

	        // then
	        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
		 
	 }
	 
	 
	 @Test
	 public void verifyOrderProcessedForProduct() throws Exception {

		 PurchaseOrderRequest request = new PurchaseOrderRequest();
			request.setCustomerId(101);
			request.setPurchaseOrderId("PR1234");
			request.setRequestType(RequestType.PRODUCT);
			request.setTotalAmount(50.00);
			request.setOrderDetails(new PurchaseOrderDetails(new Product(1234,"SKU1234"),Membership_Type.BOOK_CLUB,new Date(), new Date()));
		// when
	        MockHttpServletResponse response = mvc.perform(
	                post("/api/processOrder").contentType(MediaType.APPLICATION_JSON).content(
	                        jsonSuperHero.write(request).getJson()
	                )).andReturn().getResponse();

	        // then
	        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
		 
	 }
	 
	 
	 @Test
	 public void verifyOrderProcessedForProductandShippingSlip() throws Exception {

		 PurchaseOrderRequest request = new PurchaseOrderRequest();
			request.setCustomerId(101);
			request.setPurchaseOrderId("PR1234");
			request.setRequestType(RequestType.PRODUCT);
			request.setTotalAmount(50.00);
			request.setOrderDetails(new PurchaseOrderDetails(new Product(1234,"SKU1234"),Membership_Type.BOOK_CLUB,new Date(), new Date()));
		// when
	        MockHttpServletResponse response = mvc.perform(
	                post("/api/processOrder").contentType(MediaType.APPLICATION_JSON).content(
	                        jsonSuperHero.write(request).getJson()
	                )).andReturn().getResponse();

	        // then
	        
	        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
		 
	 }
	
	
}
