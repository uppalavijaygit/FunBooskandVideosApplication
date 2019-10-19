/**
 * 
 */
package com.world.remit.ecommerce.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.world.remit.ecommerce.model.PurchaseOrderRequest;
import com.world.remit.ecommerce.model.PurchaseOrderResponse;
import com.world.remit.ecommerce.service.BooksaAndVideosValidationErrorService;
import com.world.remit.ecommerce.service.OrderProceeingServie;


/**
 * @author vijaykumaruppala
 *
 */

@RestController
public class OrderServicesApi {
	
	@Autowired
	OrderProceeingServie service;

	@Autowired
	BooksaAndVideosValidationErrorService validationService;
	
    @PostMapping(path = "/processOrder")
	public ResponseEntity<?> orderProcesser(@Valid @RequestBody PurchaseOrderRequest request,BindingResult result) throws Exception{
    	ResponseEntity<?> errorMap = validationService.MapValidationService(result);
    	if(errorMap!=null) return errorMap;
		PurchaseOrderResponse response = service.processOrder(request);
		return new ResponseEntity<PurchaseOrderResponse>(response, HttpStatus.CREATED);
	}
    

}
