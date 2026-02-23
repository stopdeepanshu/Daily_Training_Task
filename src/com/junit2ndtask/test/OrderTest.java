package com.junit2ndtask.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.junit2ndtask.OrderItem;
import com.junit2ndtask.OrderService;
import com.junit2ndtask.Product;

public class OrderTest {

	private OrderService orderService;
	private Product laptop;
	private Product mouse;

	@BeforeEach 
	void setUp() {
//		System.out.println("Before each runs here");
		orderService = new OrderService();
		laptop = new Product(1L, "Laptop", 50000, 10);
		mouse = new Product(2L, "Mouse", 500, 20);
	}

	@Test
	void testPlaceOrder() {

		OrderItem item1 = new OrderItem(laptop, 1);
		OrderItem item2 = new OrderItem(mouse, 2);

		double total = orderService.placeOrder(List.of(item1, item2));
	
		assertEquals(51000, total);
		assertEquals(9, laptop.getStock());// 10-1=9
		assertEquals(18, mouse.getStock());// 20 -2=18
	}

	@Test
	void testEmptyOrder() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> orderService.placeOrder(List.of()));

		assertEquals("Order cannot be empty", exception.getMessage());
	}
}
