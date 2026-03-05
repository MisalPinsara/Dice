package com.app.screens;

import com.app.controllers.InventoryController;
import com.app.models.Manager;
import com.app.models.ShoeItem;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import javax.swing.table.DefaultTableModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class MainframeManager extends javax.swing.JFrame {

        private final Manager manager;
        private final InventoryController inventoryController = new InventoryController();

        public MainframeManager(Manager manager) {
                this.manager = manager;
                initComponents();
                refreshTable();
        }

        private void refreshTable() {
                new Thread(() -> {
                        List<ShoeItem> variants = inventoryController.getAllShoes();
                        List<ShoeItem> itemWiseList = groupItemsWise(variants);
                        java.awt.EventQueue.invokeLater(() -> {
                                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                                model.setRowCount(0);
                                for (ShoeItem item : itemWiseList) {
                                        model.addRow(new Object[] {
                                                        item.getShoeId(), item.getModel(), item.getBrand(),
                                                        item.getSizeRange(), item.getColor(), item.getPrice(),
                                                        item.getStockOnHand()
                                        });
                                }
                        });
                }).start();
        }

        private List<ShoeItem> groupItemsWise(List<ShoeItem> variants) {
                Map<String, ShoeItem> groupedMap = new LinkedHashMap<>();

                for (ShoeItem variant : variants) {
                        String key = variant.getBrand() + "|" + variant.getModel();

                        if (groupedMap.containsKey(key)) {
                                ShoeItem existing = groupedMap.get(key);

                                // Append color if not present
                                if (variant.getColor() != null
                                                && !existing.getColor().toLowerCase()
                                                                .contains(variant.getColor().toLowerCase())) {
                                        existing.setColor(existing.getColor() + ", " + variant.getColor());
                                }

                                // Append size if not present
                                if (variant.getSizeRange() != null
                                                && !existing.getSizeRange().toLowerCase()
                                                                .contains(variant.getSizeRange().toLowerCase())) {
                                        existing.setSizeRange(existing.getSizeRange() + ", " + variant.getSizeRange());
                                }

                                // sum total stock
                                existing.setStockOnHand(existing.getStockOnHand() + variant.getStockOnHand());

                        } else {
                                // Important: Create a copy or modify carefully to not affect original objects
                                // if reused
                                ShoeItem newItem = new ShoeItem();
                                newItem.setShoeId(variant.getShoeId());
                                newItem.setModel(variant.getModel());
                                newItem.setBrand(variant.getBrand());
                                newItem.setColor(variant.getColor());
                                newItem.setSizeRange(variant.getSizeRange());
                                newItem.setPrice(variant.getPrice());
                                newItem.setStockOnHand(variant.getStockOnHand());
                                groupedMap.put(key, newItem);
                        }
                }
                return new ArrayList<>(groupedMap.values());
        }

        private void search() {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                jTable1.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter(jTextField1.getText()));
        }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();
                jTextField1 = new javax.swing.JTextField();
                jLabel3 = new javax.swing.JLabel();
                jButton1 = new javax.swing.JButton();
                jButton2 = new javax.swing.JButton();
                jButton3 = new javax.swing.JButton();
                jButton4 = new javax.swing.JButton();
                jButton5 = new javax.swing.JButton();
                jButton6 = new javax.swing.JButton();
                jButton7 = new javax.swing.JButton();
                jButton8 = new javax.swing.JButton();
                jButton9 = new javax.swing.JButton();
                jButton10 = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setResizable(false);

                jPanel1.setBackground(new java.awt.Color(255, 237, 207));

                jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(68, 68, 68));
                jLabel1.setText("Dice");

                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "ID", "Model", "Brand", "Size range", "Color", "Price", "Stock"
                                }) {
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jTable1.getTableHeader().setReorderingAllowed(false);
                jScrollPane1.setViewportView(jTable1);
                if (jTable1.getColumnModel().getColumnCount() > 0) {
                        jTable1.getColumnModel().getColumn(0).setResizable(false);
                        jTable1.getColumnModel().getColumn(1).setResizable(false);
                        jTable1.getColumnModel().getColumn(2).setResizable(false);
                        jTable1.getColumnModel().getColumn(3).setResizable(false);
                        jTable1.getColumnModel().getColumn(4).setResizable(false);
                        jTable1.getColumnModel().getColumn(5).setResizable(false);
                        jTable1.getColumnModel().getColumn(6).setResizable(false);
                }

                jTextField1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField1ActionPerformed(evt);
                        }
                });

                jLabel3.setText("Search:");

                jButton1.setText("Add Shoe");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jButton2.setText("Add Category");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                jButton3.setText("Add Cashier");
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });

                jButton4.setText("Inventory Controls");
                jButton4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton4ActionPerformed(evt);
                        }
                });

                jButton5.setText("Edit Category");
                jButton5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton5ActionPerformed(evt);
                        }
                });

                jButton6.setText("Set Offers");
                jButton6.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton6ActionPerformed(evt);
                        }
                });

                jButton7.setText("Bulk Price Updates");
                jButton7.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton7ActionPerformed(evt);
                        }
                });

                jButton8.setText("Approvals and Returns");
                jButton8.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton8ActionPerformed(evt);
                        }
                });

                jButton9.setText("Log Out");
                jButton9.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton9ActionPerformed(evt);
                        }
                });

                jButton10.setText("Refresh Table");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(jButton1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jButton2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jButton3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jButton4,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jButton5,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jButton6,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jButton7,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jButton8,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jButton9,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jButton10,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                149,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jLabel3)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextField1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                207,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                751, Short.MAX_VALUE))
                                                                .addContainerGap()));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(16, 16, 16)
                                                                                                .addComponent(jLabel1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                33,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                25,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                .addContainerGap(
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                jPanel1Layout.createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                                                .addComponent(jTextField1,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addComponent(jLabel3))
                                                                                                                                .addComponent(jButton10,
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING))
                                                                                                                .addGap(18, 18, 18)))
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jButton1)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jButton2)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jButton5)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jButton6)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jButton7)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jButton3)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jButton4)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jButton8)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jButton9))
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap()));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
                new AddItemFrame().setVisible(true);
        }// GEN-LAST:event_jButton1ActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
                new AddCategoryFrame().setVisible(true);
        }// GEN-LAST:event_jButton2ActionPerformed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
                new AddCashierFrame().setVisible(true);
        }// GEN-LAST:event_jButton3ActionPerformed

        private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
                new StockFrameManager().setVisible(true);
        }// GEN-LAST:event_jButton4ActionPerformed

        private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
                new UpdateCategoryFrame().setVisible(true);
        }// GEN-LAST:event_jButton5ActionPerformed

        private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton6ActionPerformed
                new CommonFormFrame("offers", manager).setVisible(true);
        }// GEN-LAST:event_jButton6ActionPerformed

        private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton7ActionPerformed
                new CommonFormFrame("bulkPrice", manager).setVisible(true);
        }// GEN-LAST:event_jButton7ActionPerformed

        private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton8ActionPerformed
                new ApprovalsFrame(manager).setVisible(true);
        }// GEN-LAST:event_jButton8ActionPerformed

        private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton9ActionPerformed
                new LoginFrame().setVisible(true);
                this.dispose();
        }// GEN-LAST:event_jButton9ActionPerformed

        private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
                search();
        }// GEN-LAST:event_jTextField1ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton10;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JButton jButton4;
        private javax.swing.JButton jButton5;
        private javax.swing.JButton jButton6;
        private javax.swing.JButton jButton7;
        private javax.swing.JButton jButton8;
        private javax.swing.JButton jButton9;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable jTable1;
        private javax.swing.JTextField jTextField1;
        // End of variables declaration//GEN-END:variables
}
