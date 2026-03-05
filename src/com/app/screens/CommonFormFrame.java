package com.app.screens;

import com.app.controllers.CategoryController;
import com.app.controllers.InventoryController;
import com.app.controllers.ReturnController;
import com.app.models.Category;
import com.app.models.Manager;
import com.app.classes.Constants;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class CommonFormFrame extends javax.swing.JFrame {

        private final String operationType;
        private final Manager manager;
        private final Integer selectedReturnId;
        private final InventoryController inventoryController = new InventoryController();
        private final CategoryController categoryController = new CategoryController();
        private final ReturnController returnController = new ReturnController();

        public CommonFormFrame(String operationType, Manager manager, Integer returnId) {
                this.operationType = operationType;
                this.manager = manager;
                this.selectedReturnId = returnId;
                initComponents();
                loadFilterData();
                setupDynamicUI();
                setLocationRelativeTo(null);
        }

        public CommonFormFrame(String operationType, Manager manager) {
                this(operationType, manager, null);
        }

        public CommonFormFrame(String operationType) {
                this(operationType, null, null);
        }

        private void loadFilterData() {
                // jComboBox3 is Model
                loadCombo(jComboBox3, inventoryController.getUniqueModels(), "All");
                // jComboBox4 is Brand
                loadCombo(jComboBox4, inventoryController.getUniqueBrands(), "All");

                // jComboBox5 is Category
                DefaultComboBoxModel<Object> catModel = new DefaultComboBoxModel<>();
                catModel.addElement("All");
                List<Category> categories = categoryController.getAllCategories();
                for (Category cat : categories) {
                        catModel.addElement(cat);
                }
                jComboBox5.setModel((DefaultComboBoxModel) catModel);

                // jComboBox1 is Size Range
                DefaultComboBoxModel<String> sizeModel = new DefaultComboBoxModel<>();
                sizeModel.addElement("All");
                for (String size : Constants.SIZES) {
                        sizeModel.addElement(size);
                }
                jComboBox1.setModel(sizeModel);

                // jComboBox2 is Color
                loadCombo(jComboBox2, inventoryController.getUniqueColors(), "All colours");
        }

        private void loadCombo(javax.swing.JComboBox<String> combo, List<String> items, String defaultItem) {
                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                model.addElement(defaultItem);
                for (String item : items) {
                        if (item != null && !item.isEmpty()) {
                                model.addElement(item);
                        }
                }
                combo.setModel(model);
        }

        private void setupDynamicUI() {
                switch (operationType) {
                        case "offers":
                                jLabel5.setText("Offer (percentage) :");
                                jButton1.setText("Set Offer");
                                break;
                        case "bulkPrice":
                                jLabel5.setText("Price (percentage) :");
                                jButton1.setText("Update Price");
                                break;
                        case "thresholds":
                                jLabel5.setText("Threshold Limit :");
                                jButton1.setText("Set Threshold");
                                break;
                        case "return_discount":
                                jLabel5.setText("Discount (percentage) :");
                                jButton1.setText("Approve");
                                break;
                }
        }

        private void handleAction() {
                try {
                        String valueStr = jTextField5.getText().trim();
                        if (valueStr.isEmpty()) {
                                JOptionPane.showMessageDialog(this, "Please enter a value.");
                                return;
                        }
                        double value = Double.parseDouble(valueStr);

                        String model = (String) jComboBox3.getSelectedItem();
                        String brand = (String) jComboBox4.getSelectedItem();
                        Object catObj = jComboBox5.getSelectedItem();
                        Integer categoryId = null;
                        if (catObj instanceof Category) {
                                categoryId = ((Category) catObj).getCategoryId();
                        }
                        String sizeRange = (String) jComboBox1.getSelectedItem();
                        String color = (String) jComboBox2.getSelectedItem();

                        int count = 0;
                        switch (operationType) {
                                case "offers":
                                        count = inventoryController.setPromotionalPrice(value, brand, model, color,
                                                        categoryId, sizeRange);
                                        break;
                                case "bulkPrice":
                                        count = inventoryController.bulkPriceUpdate(value, brand, model, color,
                                                        categoryId, sizeRange);
                                        break;
                                case "thresholds":
                                        count = inventoryController.updateThresholds((int) value, brand, model,
                                                        color, categoryId, sizeRange);
                                        break;
                                case "return_discount":
                                        if (manager == null) {
                                                JOptionPane.showMessageDialog(this,
                                                                "Session expired. Please log in again.");
                                                return;
                                        }

                                        if (selectedReturnId != null) {
                                                if (returnController.approveReturnWithDiscount(selectedReturnId,
                                                                manager.getUserId(), value)) {
                                                        count = 1;
                                                }
                                        } else {
                                                count = returnController.approveReturnsInBulk(manager.getUserId(),
                                                                brand,
                                                                model, color, categoryId, sizeRange);
                                        }
                                        break;
                        }
                        if (count > 0) {
                                JOptionPane.showMessageDialog(this, "Changes were applied successfully");
                                this.dispose();
                        } else {
                                JOptionPane.showMessageDialog(this, "Invalid selection, Check your selections",
                                                "Update Failed", JOptionPane.WARNING_MESSAGE);
                        }
                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Please enter a valid numeric value.");
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Operation failed: " + e.getMessage());
                }
        }

        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jTextField5 = new javax.swing.JTextField();
                jComboBox1 = new javax.swing.JComboBox<>();
                jComboBox2 = new javax.swing.JComboBox<>();
                jButton1 = new javax.swing.JButton();
                jComboBox3 = new javax.swing.JComboBox<>();
                jComboBox4 = new javax.swing.JComboBox<>();
                jLabel6 = new javax.swing.JLabel();
                jComboBox5 = new javax.swing.JComboBox<>();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jPanel1.setBackground(new java.awt.Color(255, 237, 207));

                jLabel1.setText("Model :");

                jLabel2.setText("Brand :");

                jLabel3.setText("Size Range :");

                jLabel4.setText("Color :");

                jLabel5.setText("Offer (percentage) :");

                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "30", "32", "34", "36", "38", "40" }));

                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "White", "Black", "Blue", "Red", "Brown" }));

                jButton1.setText("Set Offer");
                jButton1.addActionListener(this::jButton1ActionPerformed);

                jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "All", "Model 1", "Model 2", "Model 3", "Model 4" }));

                jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "All", "Brand 1", "Brand 2", "Brand 3", "Brand 4" }));

                jLabel6.setText("Category :");

                jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "All", "Category 1", "Category 2", "Category 3", "Category 4" }));

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jButton1)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel1)
                                                                                                                .addComponent(jLabel2)
                                                                                                                .addComponent(jLabel3)
                                                                                                                .addComponent(jLabel4)
                                                                                                                .addComponent(jLabel5,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                107,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel6))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(jTextField5,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                200,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jComboBox1,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jComboBox2,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jComboBox3,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jComboBox4,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jComboBox5,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))))
                                                                .addContainerGap(26, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jComboBox3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jComboBox4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel6)
                                                                                .addComponent(jComboBox5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                26, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jComboBox1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel4)
                                                                                .addComponent(jComboBox2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(jTextField5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButton1)
                                                                .addGap(26, 26, 26)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
                handleAction();
        }// GEN-LAST:event_jButton1ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JComboBox<String> jComboBox2;
        private javax.swing.JComboBox<String> jComboBox3;
        private javax.swing.JComboBox<String> jComboBox4;
        private javax.swing.JComboBox<String> jComboBox5;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField jTextField5;
        // End of variables declaration//GEN-END:variables
}
