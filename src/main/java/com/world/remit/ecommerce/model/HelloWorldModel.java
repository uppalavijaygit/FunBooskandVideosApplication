package com.world.remit.ecommerce.model;

public class HelloWorldModel {
	
	private String name;
	
	

	public HelloWorldModel(String name) {
		this.name = name;
	}
	
	 public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    @Override
	    public String toString() {
	        return "HelloWorldModel{" +
	                "name='" + name + '\'' +
	                '}';
	    }
	

}
