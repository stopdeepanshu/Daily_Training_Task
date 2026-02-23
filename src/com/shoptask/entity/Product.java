package com.shoptask.entity;

public class Product {

	private String id;
	private String name;
	private int stock;

	// constructor
	public Product(String id, String name, int stock) {
		this.id = id;
		this.name = name;
		this.stock = stock;
	}

	// to reduce stock
	public void reduceStock(int qty) {
		if (qty > stock) {
			throw new IllegalArgumentException("Not enough stock available");
		}
		stock = stock - qty;
	}

	// getter and setter

	public int getStock() {
		return stock;
	}
}