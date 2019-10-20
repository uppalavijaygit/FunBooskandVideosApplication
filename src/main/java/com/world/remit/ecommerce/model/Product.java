package com.world.remit.ecommerce.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Fun Books & Videos Product Information")
public class Product {
	
	
	@NotNull
	@ApiModelProperty(notes = "Product Id is Must",example = "1234")
	@Digits(integer=10, fraction=0)
	private int id;
	
	
	@NotNull
	@ApiModelProperty(notes = "productSKU Id is Must",example = "SKU1234")
	private String productSKU;
	
	
	public Product() {
	}
	
	
	
	public Product(int id,String productSKU) {
		this.id = id;
		this.productSKU = productSKU;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductSKU() {
		return productSKU;
	}
	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}
	
	
}
