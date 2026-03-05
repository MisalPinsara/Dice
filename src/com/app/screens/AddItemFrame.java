package com.app.screens;

import com.app.classes.Constants;
import com.app.controllers.CategoryController;
import com.app.controllers.InventoryController;
import com.app.models.Category;
import com.app.models.ShoeItem;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class AddItemFrame extends javax.swing.JFrame {

        private final InventoryController inventoryController = new InventoryController();
        private final CategoryController categoryController = new CategoryController();

        public AddItemFrame() {
                initComponents();
                loadCategories();
                setLocationRelativeTo(null);
        }

        private void loadCategories() {
                List<Category> categories = categoryController.getAllCategories();
                DefaultComboBoxModel<Category> model = new DefaultComboBoxModel<>();
                for (Category c : categories) {
                        model.addElement(c);
                }
                jComboBox3.setModel(model);
        }

        private void addItem() {
                try {
                        String model = jTextField1.getText();
                        String brand = jTextField2.getText();
                        Category category = (Category) jComboBox3.getSelectedItem();
                        String sizeRange = (String) jComboBox1.getSelectedItem();
                        String color = (String) jComboBox2.getSelectedItem();
                        double price = Double.parseDouble(jTextField5.getText());
                        int stock = Integer.parseInt(jTextField6.getText());

                        ShoeItem item = new ShoeItem();
                        item.setModel(model);
                        item.setBrand(brand);
                        item.setCategoryId(category != null ? category.getCategoryId() : 0);
                        item.setSizeRange(sizeRange);
                        item.setColor(color);
                        item.setPrice(price);
                        item.setStockOnHand(stock);

                        if (inventoryController.addShoe(item)) {
                                JOptionPane.showMessageDialog(this, "Item added successfully!");
                                this.dispose();
                        } else {
                                if (inventoryController.checkIfExists(model, brand, sizeRange, color)) {
                                        JOptionPane.showMessageDialog(this,
                                                        "Item already exists with this Color and Size!");
                                } else {
                                        JOptionPane.showMessageDialog(this, "Failed to add item.");
                                }
                        }
                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Please enter valid number for price and stock.");
                }
        }

        // <editor-fold defaultstate=\"collapsed\" desc=\"Generated
        // Code\">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jTextField1 = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                jTextField2 = new javax.swing.JTextField();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jTextField5 = new javax.swing.JTextField();
                jTextField6 = new javax.swing.JTextField();
                jLabel6 = new javax.swing.JLabel();
                jComboBox1 = new javax.swing.JComboBox<>();
                jComboBox2 = new javax.swing.JComboBox<>();
                jComboBox3 = new javax.swing.JComboBox<>();
                jButton1 = new javax.swing.JButton();
                jLabel7 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setResizable(false);

                jPanel1.setBackground(new java.awt.Color(255, 237, 207));

                jLabel1.setText("Model :");

                jLabel2.setText("Brand :");

                jLabel3.setText("Size Range :");

                jLabel4.setText("Color :");

                jLabel5.setText("Price :");

                jLabel6.setText("Stock :");

                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(Constants.SIZES));

                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(Constants.COLORS));

                jButton1.setText("Add Item");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jLabel7.setText("Category :");

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
                                                                                                                .addComponent(jLabel7)
                                                                                                                .addComponent(jLabel3)
                                                                                                                .addComponent(jLabel4)
                                                                                                                .addComponent(jLabel5)
                                                                                                                .addComponent(jLabel6))
                                                                                                .addGap(51, 51, 51)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jTextField6,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                200,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jTextField5,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                200,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jTextField2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                200,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jTextField1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                200,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jComboBox3,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                200,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jComboBox1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                200,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jComboBox2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                200,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addContainerGap(26, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jTextField1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(20, 20, 20)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jTextField2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(20, 20, 20)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel7)
                                                                                .addComponent(jComboBox3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(20, 20, 20)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jComboBox1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(20, 20, 20)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel4)
                                                                                .addComponent(jComboBox2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(20, 20, 20)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(jTextField5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(20, 20, 20)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel6)
                                                                                .addComponent(jTextField6,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(20, 20, 20)
                                                                .addComponent(jButton1)
                                                                .addContainerGap(26, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));
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
                addItem();
        }// GEN-LAST:event_jButton1ActionPerformed
         // Variables declaration - do not modify//GEN-BEGIN:variables

        private javax.swing.JButton jButton1;
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JComboBox<String> jComboBox2;
        private javax.swing.JComboBox<Category> jComboBox3;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField jTextField1;
        private javax.swing.JTextField jTextField2;
        private javax.swing.JTextField jTextField5;
        private javax.swing.JTextField jTextField6;
        // End of variables declaration//GEN-END:variables
}
