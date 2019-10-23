package com.world.remit.ecommerce.model;


public class BookModel extends Product {
	
	private int id;
	private String title;
	private String author;
	private double price;
	
	public BookModel(int id, String title, String author, double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	
	
	
}
