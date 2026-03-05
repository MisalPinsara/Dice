package com.app.controllers;

import com.app.classes.DatabaseOperator;
import com.app.models.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryController {
    private final DatabaseOperator db = new DatabaseOperator();

    public boolean addCategory(String name) {
        return db.runUpdate("INSERT INTO Categories (name) VALUES (?)", new Object[] { name }) > 0;
    }

    public List<Category> getAllCategories() {
        List<List<Object>> results = db.runSelect("SELECT * FROM Categories", null);
        List<Category> list = new ArrayList<>();
        for (List<Object> row : results) {
            list.add(new Category((int) row.get(0), (String) row.get(1)));
        }
        return list;
    }

    public Category getCategoryByName(String name) {
        List<List<Object>> results = db.runSelect("SELECT category_id, name FROM Categories WHERE name = ?",
                new Object[] { name });
        if (!results.isEmpty()) {
            List<Object> row = results.get(0);
            return new Category((int) row.get(0), (String) row.get(1));
        }
        return null;
    }

    public boolean updateCategory(int id, String newName) {
        return db.runUpdate("UPDATE Categories SET name = ? WHERE category_id = ?", new Object[] { newName, id }) > 0;
    }
}
