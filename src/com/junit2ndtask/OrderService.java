package com.junit2ndtask;

import java.util.List;

public class OrderService {

    public double placeOrder(List<OrderItem> items) {

        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order cannot be empty");
        }

        double total = 0;

        for (OrderItem item : items) {
            item.processItem();
            total += item.getItemTotal();
        }

        return total;
    }
}