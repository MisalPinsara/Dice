package com.app.controllers;

import com.app.classes.DatabaseOperator;
import java.util.ArrayList;
import java.util.List;

public class ReturnController {
    private final DatabaseOperator db = new DatabaseOperator();

    public List<List<Object>> getPendingReturns() {
        String query = "SELECT r.return_id, s.model, s.brand, r.qty, r.reason, u.username " +
                "FROM Returns r " +
                "JOIN Shoes s ON r.shoe_id = s.shoe_id " +
                "LEFT JOIN Users u ON r.manager_id = u.user_id " +
                "WHERE r.status = 'Pending'";
        return db.runSelect(query, null);
    }

    public boolean updateReturnStatus(int returnId, String status, int managerId) {
        String query = "UPDATE Returns SET status = ?, manager_id = ? WHERE return_id = ?";
        return db.runUpdate(query, new Object[] { status, managerId, returnId }) > 0;
    }

    public int approveReturnsInBulk(int managerId, String brand, String model, String color, Integer categoryId,
            String sizeRange) {
        StringBuilder query = new StringBuilder("UPDATE Returns SET status = 'Approved', manager_id = ? "
                + "WHERE status = 'Pending' AND shoe_id IN (SELECT shoe_id FROM Shoes WHERE 1=1");
        List<Object> params = new ArrayList<>();
        params.add(managerId);

        if (brand != null && !brand.equalsIgnoreCase("All")) {
            query.append(" AND brand = ?");
            params.add(brand);
        }
        if (model != null && !model.equalsIgnoreCase("All")) {
            query.append(" AND model = ?");
            params.add(model);
        }
        if (color != null && !color.equalsIgnoreCase("All") && !color.equalsIgnoreCase("All colours")) {
            query.append(" AND color = ?");
            params.add(color);
        }
        if (categoryId != null && categoryId != 0) {
            query.append(" AND category_id = ?");
            params.add(categoryId);
        }
        if (sizeRange != null && !sizeRange.equalsIgnoreCase("All")) {
            query.append(" AND size_range = ?");
            params.add(sizeRange);
        }
        query.append(")");

        return db.runUpdate(query.toString(), params.toArray());
    }

    public boolean approveReturnWithDiscount(int returnId, int managerId, double discountPercent) {
        String queryUpdateStatus = "UPDATE Returns SET status = 'Approved', manager_id = ? WHERE return_id = ?";
        String queryUpdateShoe = "UPDATE Shoes SET stock_on_hand = stock_on_hand + 1, price = price * (1 - ? / 100) "
                + "WHERE shoe_id = (SELECT shoe_id FROM Returns WHERE return_id = ?)";

        db.runUpdate(queryUpdateStatus, new Object[] { managerId, returnId });
        return db.runUpdate(queryUpdateShoe, new Object[] { discountPercent, returnId }) > 0;
    }

    public boolean approveReturn(int returnId, int managerId) {
        String updateReturn = "UPDATE Returns SET status = 'Approved', manager_id = ? WHERE return_id = ?";
        String updateStock = "UPDATE Shoes SET stock_on_hand = stock_on_hand + 1 WHERE shoe_id = (SELECT shoe_id FROM Returns WHERE return_id = ?)";

        db.runUpdate(updateReturn, new Object[] { managerId, returnId });
        return db.runUpdate(updateStock, new Object[] { returnId }) > 0;
    }

    public boolean declineReturn(int returnId) {
        return db.runUpdate("UPDATE Returns SET status = 'Rejected' WHERE return_id = ?",
                new Object[] { returnId }) > 0;
    }
}