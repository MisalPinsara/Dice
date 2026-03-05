package com.app.models;

/**
 * Cashier class inherits from User.
 * Demonstrates Inheritance and Polymorphism.
 */
public class Cashier extends User {

    public Cashier(int userId, String username, String password) {
        super(userId, username, password, "Cashier");
    }

    public Cashier(String username, String password) {
        super(username, password, "Cashier");
    }

    @Override
    public String getAccessLevelDetails() {
        return "Standard Operational Access: Inventory Search, Category Creation, and Stock Checks.";
    }
}
