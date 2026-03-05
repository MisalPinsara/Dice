package com.app.controllers;

import com.app.classes.DatabaseOperator;
import com.app.models.Cashier;
import com.app.models.Manager;
import com.app.models.User;
import java.util.List;

public class AuthenticationController {
    private final DatabaseOperator db = new DatabaseOperator();

    public User login(String username, String password) {
        String query = "SELECT user_id, username, password, role FROM Users WHERE username = ? AND password = ?";
        List<List<Object>> results = db.runSelect(query, new Object[] { username, password });

        if (results.isEmpty()) {
            return null;
        }

        List<Object> row = results.get(0);
        int id = (int) row.get(0);
        String name = (String) row.get(1);
        String pass = (String) row.get(2);
        String role = (String) row.get(3);

        if ("Manager".equalsIgnoreCase(role)) {
            return new Manager(id, name, pass);
        } else {
            return new Cashier(id, name, pass);
        }
    }

    public boolean addCashier(String username, String password) {
        String query = "INSERT INTO Users (username, password, role) VALUES (?, ?, 'Cashier')";
        return db.runUpdate(query, new Object[] { username, password }) > 0;
    }
}