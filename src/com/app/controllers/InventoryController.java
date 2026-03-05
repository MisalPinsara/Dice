package com.app.controllers;

import com.app.classes.DatabaseOperator;
import com.app.models.ShoeItem;
import java.util.ArrayList;
import java.util.List;

public class InventoryController {
    private final DatabaseOperator db = new DatabaseOperator();

    public boolean addShoe(ShoeItem item) {
        if (checkIfExists(item.getModel(), item.getBrand(), item.getSizeRange(), item.getColor())) {
            return false;
        }
        String query = "INSERT INTO Shoes (model, brand, size_range, color, price, stock_on_hand, category_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {
                item.getModel(),
                item.getBrand(),
                item.getSizeRange(),
                item.getColor(),
                item.getPrice(),
                item.getStockOnHand(),
                item.getCategoryId() == 0 ? null : item.getCategoryId()
        };
        return db.runUpdate(query, params) > 0;
    }

    public boolean checkIfExists(String model, String brand, String size, String color) {
        String query = "SELECT COUNT(*) FROM Shoes WHERE model = ? AND brand = ? AND size_range = ? AND color = ?";
        List<List<Object>> results = db.runSelect(query, new Object[] { model, brand, size, color });
        if (!results.isEmpty() && !results.get(0).isEmpty()) {
            return ((Number) results.get(0).get(0)).intValue() > 0;
        }
        return false;
    }

    public List<ShoeItem> getAllShoes() {
        String query = "SELECT shoe_id, model, brand, size_range, color, price, stock_on_hand, threshold, category_id FROM Shoes";
        return mapResultsToShoes(db.runSelect(query, null));
    }

    public ShoeItem getShoeById(int shoeId) {
        String query = "SELECT * FROM Shoes WHERE shoe_id = ?";
        List<ShoeItem> items = mapResultsToShoes(db.runSelect(query, new Object[] { shoeId }));
        return items.isEmpty() ? null : items.get(0);
    }

    public List<ShoeItem> searchShoes(String searchTerm) {
        String query = "SELECT shoe_id, model, brand, size_range, color, price, stock_on_hand, threshold, category_id FROM Shoes "
                + "WHERE model LIKE ? OR brand LIKE ? OR color LIKE ?";
        String searchPattern = "%" + searchTerm + "%";
        return mapResultsToShoes(db.runSelect(query, new Object[] { searchPattern, searchPattern, searchPattern }));
    }

    public int bulkPriceUpdate(double percentage, String brand, String model, String color, Integer categoryId,
            String sizeRange) {
        StringBuilder query = new StringBuilder("UPDATE Shoes SET price = price * (1 + ? / 100) WHERE 1=1");
        List<Object> params = new ArrayList<>();
        params.add(percentage);

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

        return db.runUpdate(query.toString(), params.toArray());
    }

    public boolean adjustStock(int shoeId, int quantity) {
        String query = "UPDATE Shoes SET stock_on_hand = stock_on_hand + ? WHERE shoe_id = ?";
        return db.runUpdate(query, new Object[] { quantity, shoeId }) > 0;
    }

    public int setPromotionalPrice(double discountPercent, String brand, String model, String color, Integer categoryId,
            String sizeRange) {
        StringBuilder query = new StringBuilder("UPDATE Shoes SET price = price * (1 - ? / 100) WHERE 1=1");
        List<Object> params = new ArrayList<>();
        params.add(discountPercent);

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

        return db.runUpdate(query.toString(), params.toArray());
    }

    public int updateThresholds(int threshold, String brand, String model, String color, Integer categoryId,
            String sizeRange) {
        StringBuilder query = new StringBuilder("UPDATE Shoes SET threshold = ? WHERE 1=1");
        List<Object> params = new ArrayList<>();
        params.add(threshold);

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

        return db.runUpdate(query.toString(), params.toArray());
    }

    public List<String> getUniqueBrands() {
        return getListFromColumn("SELECT DISTINCT brand FROM Shoes");
    }

    public List<String> getUniqueModels() {
        return getListFromColumn("SELECT DISTINCT model FROM Shoes");
    }

    public List<String> getUniqueColors() {
        return getListFromColumn("SELECT DISTINCT color FROM Shoes");
    }

    public List<String> getUniqueSizes() {
        return getListFromColumn("SELECT DISTINCT size_range FROM Shoes");
    }

    private List<String> getListFromColumn(String query) {
        List<List<Object>> results = db.runSelect(query, null);
        List<String> list = new ArrayList<>();
        for (List<Object> row : results) {
            if (row.get(0) != null) {
                list.add(row.get(0).toString());
            }
        }
        return list;
    }

    private List<ShoeItem> mapResultsToShoes(List<List<Object>> results) {
        List<ShoeItem> items = new ArrayList<>();
        for (List<Object> row : results) {
            ShoeItem item = new ShoeItem();
            item.setShoeId((int) row.get(0));
            item.setModel((String) row.get(1));
            item.setBrand((String) row.get(2));
            item.setSizeRange((String) row.get(3));
            item.setColor((String) row.get(4));
            item.setPrice(((Number) row.get(5)).doubleValue());
            item.setStockOnHand((int) row.get(6));
            item.setThreshold((int) row.get(7));
            item.setCategoryId((row.get(8) != null) ? (int) row.get(8) : 0);
            items.add(item);
        }
        return items;
    }
}
