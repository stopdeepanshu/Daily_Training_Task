package com.shoptask.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shoptask.entity.Product;

public class ProductTest {

	Product p1;

	@BeforeEach
	void insertStock() {
		p1 = new Product("D101", "Deepanshu", 100);
	}
	
	@Test
	void testAndThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> {
//			System.out.println("Test 1: "+p1.getStock());
		p1.reduceStock(123);
		});
	}
	
	@Test
	void testOrder() {
		p1.reduceStock(10);
//		System.out.println("Test 2: "+p1.getStock());
		assertEquals(90, p1.getStock());
	}
	
	@Test
	void testInitialStock() {
		p1.reduceStock(30);
//		System.out.println("Test 3: "+p1.getStock());
		assertEquals(70, p1.getStock());
	}

}