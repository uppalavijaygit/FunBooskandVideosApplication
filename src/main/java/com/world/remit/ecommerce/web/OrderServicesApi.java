/**
 * 
 */
package com.world.remit.ecommerce.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.world.remit.ecommerce.mode.response.PurchaseOrderResponse;
import com.world.remit.ecommerce.model.request.PurchaseOrderRequest;
import com.world.remit.ecommerce.service.OrderProceeingServie;
import com.world.remit.ecommerce.validations.BooksaAndVideosValidationErrorService;

import org.springframework.http.MediaType;

/**
 * @author vijaykumaruppala
 *
 */


@RestController
@RequestMapping("/api")
public class OrderServicesApi {
	
	@Autowired
	OrderProceeingServie service;

	@Autowired
	BooksaAndVideosValidationErrorService validationService;
	
//	@RequestMapping(value = "/processOrder",
//	        method = RequestMethod.POST,
//	        produces = {"application/json"},
//	        consumes = {"application/json"})
//	public ResponseEntity<?> orderProcesser(@Valid @RequestBody PurchaseOrderRequest request,BindingResult result) throws Exception{
//    	ResponseEntity<?> errorMap = validationService.MapValidationService(result);
//    	if(errorMap!=null) return errorMap;
//		PurchaseOrderResponse response = service.processOrder(request);
//		return new ResponseEntity<PurchaseOrderResponse>(response, HttpStatus.CREATED);
//	}
	
	@RequestMapping(value = "/processOrder",
	        method = RequestMethod.POST,
	        produces = {"application/json"},
	        consumes = {"application/json"})
	public ResponseEntity<?> orderProcesser(@Valid @RequestBody PurchaseOrderRequest request) throws Exception{
//    	ResponseEntity<?> errorMap = validationService.MapValidationService(result);
//    	if(errorMap!=null) return errorMap;
		PurchaseOrderResponse response = service.processOrder(request);
		return new ResponseEntity<PurchaseOrderResponse>(response, HttpStatus.CREATED);
	}
    

}
