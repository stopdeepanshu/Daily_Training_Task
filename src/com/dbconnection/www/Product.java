package com.dbconnection.www;

public class Product {

	private String prodName;
	private int orderCount;
	private int totalRevenue;

	//constructor
	public Product(String prodName, int orderCount, int totalRevenue) {
		super();
		this.prodName = prodName;
		this.orderCount = orderCount;
		this.totalRevenue = totalRevenue;
	}
	
	//toString( )
	@Override
	public String toString() {
		return "Product Name: " + prodName + "\nOrderCount: " + orderCount + "\nTotal Revenue: " + totalRevenue+"\n";
	}
	
	
	
	//getter
	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(int totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

}
