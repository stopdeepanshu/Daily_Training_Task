package com.junit2ndtask;


public class Product {

    private Long id;
    private String name;
    private double price;
    private int stock;

    // All-args constructor
    public Product(Long id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Business method
    public void reduceStock(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        this.stock -= quantity;
    }

    // Optional but included in @Data
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name +
                ", price=" + price + ", stock=" + stock + "]";
    }
}