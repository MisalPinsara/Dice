package com.app.models;

/**
 * Manager class inherits from User.
 * Demonstrates Inheritance and Polymorphism.
 */
public class Manager extends User {

    public Manager(int userId, String username, String password) {
        super(userId, username, password, "Manager");
    }

    public Manager(String username, String password) {
        super(username, password, "Manager");
    }

    @Override
    public String getAccessLevelDetails() {
        return "Full Administrative Access: Management of Inventory, Staff, and Suppliers.";
    }
}
