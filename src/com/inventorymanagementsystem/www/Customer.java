package com.inventorymanagementsystem.www;

import java.util.Random;

public class Customer implements Runnable {

    private Inventory inventory;
    private String customerName;

    public Customer(Inventory inventory, String customerName) {
        this.inventory = inventory;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        Random random = new Random();
        int quantity = random.nextInt(4) + 1;  

        inventory.purchase(customerName, quantity);
    }
}
