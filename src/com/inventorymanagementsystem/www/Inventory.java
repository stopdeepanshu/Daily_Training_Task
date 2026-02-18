package com.inventorymanagementsystem.www;

public class Inventory {

	private int stock;//10

	public Inventory(int stock) {
		this.stock = stock;
	}

	public synchronized void purchase(String customerName, int quantity) {
		System.out.println("Current Thread Name: "+Thread.currentThread().getName()+" "+customerName + " is purchasing " + quantity + ".");
		if (quantity <= stock) {
			stock = stock - quantity;
			System.out.println("Current Stock: " + stock);
		} else {
			System.out.println("Insuffienct Stock. \n ");

		}
	}

	public int getStock() {
		return stock;
	}

}
