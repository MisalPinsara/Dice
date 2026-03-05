package com.app.controllers;

import com.app.classes.DatabaseOperator;
import com.app.models.Supplier;
import java.util.ArrayList;
import java.util.List;

public class SupplierController {
    private final DatabaseOperator db = new DatabaseOperator();

    public boolean addSupplier(Supplier supplier) {
        String query = "INSERT INTO Suppliers (name, brand, contact_info) VALUES (?, ?, ?)";
        Object[] params = { supplier.getName(), supplier.getBrand(), supplier.getContactInfo() };
        return db.runUpdate(query, params) > 0;
    }

    public boolean updateSupplier(Supplier supplier) {
        String query = "UPDATE Suppliers SET name = ?, brand = ?, contact_info = ? WHERE supplier_id = ?";
        Object[] params = { supplier.getName(), supplier.getBrand(), supplier.getContactInfo(),
                supplier.getSupplierId() };
        return db.runUpdate(query, params) > 0;
    }

    public boolean deleteSupplier(int supplierId) {
        String query = "DELETE FROM Suppliers WHERE supplier_id = ?";
        return db.runUpdate(query, new Object[] { supplierId }) > 0;
    }

    public List<Supplier> getAllSuppliers() {
        String query = "SELECT supplier_id, name, brand, contact_info FROM Suppliers";
        List<List<Object>> results = db.runSelect(query, null);
        List<Supplier> suppliers = new ArrayList<>();
        for (List<Object> row : results) {
            suppliers.add(new Supplier(
                    (int) row.get(0),
                    (String) row.get(1),
                    (String) row.get(2),
                    (String) row.get(3)));
        }
        return suppliers;
    }

    public Supplier getSupplierById(int supplierId) {
        String query = "SELECT supplier_id, name, brand, contact_info FROM Suppliers WHERE supplier_id = ?";
        List<List<Object>> results = db.runSelect(query, new Object[] { supplierId });
        if (!results.isEmpty()) {
            List<Object> row = results.get(0);
            return new Supplier(
                    (int) row.get(0),
                    (String) row.get(1),
                    (String) row.get(2),
                    (String) row.get(3));
        }
        return null;
    }
}
