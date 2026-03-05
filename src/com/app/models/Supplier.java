package com.app.models;

public class Supplier {
    private int supplierId;
    private String name;
    private String brand;
    private String contactInfo;

    public Supplier(int supplierId, String name, String brand, String contactInfo) {
        this.supplierId = supplierId;
        this.name = name;
        this.brand = brand;
        this.contactInfo = contactInfo;
    }

    public Supplier(String name, String brand, String contactInfo) {
        this.name = name;
        this.brand = brand;
        this.contactInfo = contactInfo;
    }

    public int getSupplierId() { return supplierId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    
    @Override
    public String toString() {
        return name + " (" + brand + ")";
    }
}
