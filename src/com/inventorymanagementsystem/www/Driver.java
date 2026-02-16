package com.inventorymanagementsystem.www;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {
	public static void main(String[] args) {
		Inventory inventory = new Inventory(10);

//		Thread c1 = new Thread(new Customer(inventory, "Customer 1"));
//		Thread c2 = new Thread(new Customer(inventory, "Customer 2"));
//		Thread c3 = new Thread(new Customer(inventory, "Customer 3"));
//		Thread c4 = new Thread(new Customer(inventory, "Customer 4"));
//		Thread c5 = new Thread(new Customer(inventory, "Customer 5"));

		ExecutorService executor = Executors.newFixedThreadPool(5);

		for (int i = 1; i <= 5; i++) {
			executor.submit(new Customer(inventory, "Customer-" + i));
		}

//		c1.start();
//		c2.start();
//		c3.start();
//		c4.start();
//		c5.start();

//		// Wait for all threads to finish
//		try {
//			c1.join();
//			c2.join();
//			c3.join();
//			c4.join();
//			c5.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		// Final stock
		System.out.println("Final Stock Remaining: " + inventory.getStock());
	}
}
