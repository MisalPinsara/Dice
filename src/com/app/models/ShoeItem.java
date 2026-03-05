package com.app.models;

/**
 * Represents a shoe item in the inventory.
 */
public class ShoeItem {
    private int shoeId;
    private String model;
    private String brand;
    private String sizeRange;
    private String color;
    private double price;
    private int stockOnHand;
    private int threshold;
    private int categoryId;
    private int supplierId;

    public ShoeItem() {
    }

    public ShoeItem(int shoeId, String model, String brand, String sizeRange, String color, double price,
            int stockOnHand, int threshold, int categoryId, int supplierId) {
        this.shoeId = shoeId;
        this.model = model;
        this.brand = brand;
        this.sizeRange = sizeRange;
        this.color = color;
        this.price = price;
        this.stockOnHand = stockOnHand;
        this.threshold = threshold;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
    }

    // Getters and Setters
    public int getShoeId() {
        return shoeId;
    }

    public void setShoeId(int shoeId) {
        this.shoeId = shoeId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSizeRange() {
        return sizeRange;
    }

    public void setSizeRange(String sizeRange) {
        this.sizeRange = sizeRange;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockOnHand() {
        return stockOnHand;
    }

    public void setStockOnHand(int stockOnHand) {
        this.stockOnHand = stockOnHand;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
