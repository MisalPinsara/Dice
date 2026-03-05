package com.app.screens;

import com.app.controllers.InventoryController;
import com.app.models.ShoeItem;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.DefaultComboBoxModel;

public class StockFrameCashier extends javax.swing.JFrame {

        private final InventoryController inventoryController = new InventoryController();

        public StockFrameCashier() {
                initComponents();
                loadFilterData();
                refreshTable();
                setLocationRelativeTo(null);
        }

        private void refreshTable() {
                List<ShoeItem> items = inventoryController.getAllShoes();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (ShoeItem item : items) {
                        model.addRow(new Object[] {
                                        item.getShoeId(), item.getModel(), item.getBrand(),
                                        item.getSizeRange(), item.getColor(), item.getPrice(),
                                        item.getStockOnHand()
                        });
                }
        }

        private void search() {
                applyFilters();
        }

        private void loadFilterData() {
                loadCombo(jComboBox4, inventoryController.getUniqueModels(), "ALL");
                loadCombo(jComboBox3, inventoryController.getUniqueBrands(), "ALL");
                loadCombo(jComboBox2, inventoryController.getUniqueColors(), "ALL");
                loadCombo(jComboBox1, inventoryController.getUniqueSizes(), "ALL");
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

        private void applyFilters() {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                jTable1.setRowSorter(sorter);

                List<RowFilter<Object, Object>> filters = new ArrayList<>();

                String size = jComboBox1.getSelectedItem() != null ? jComboBox1.getSelectedItem().toString() : "ALL";
                String color = jComboBox2.getSelectedItem() != null ? jComboBox2.getSelectedItem().toString() : "ALL";
                String brand = jComboBox3.getSelectedItem() != null ? jComboBox3.getSelectedItem().toString() : "ALL";
                String modelName = jComboBox4.getSelectedItem() != null ? jComboBox4.getSelectedItem().toString()
                                : "ALL";
                String searchTxt = jTextField1.getText().trim();

                if (!size.equals("ALL"))
                        filters.add(RowFilter.regexFilter("^" + size + "$", 3));
                if (!color.equals("ALL"))
                        filters.add(RowFilter.regexFilter("^" + color + "$", 4));
                if (!brand.equals("ALL"))
                        filters.add(RowFilter.regexFilter("^" + brand + "$", 2));
                if (!modelName.equals("ALL"))
                        filters.add(RowFilter.regexFilter("^" + modelName + "$", 1));
                if (!searchTxt.isEmpty())
                        filters.add(RowFilter.regexFilter("(?i)" + searchTxt));

                if (!filters.isEmpty()) {
                        sorter.setRowFilter(RowFilter.andFilter(filters));
                }
        }

        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();
                jTextField1 = new javax.swing.JTextField();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jComboBox1 = new javax.swing.JComboBox<>();
                jLabel5 = new javax.swing.JLabel();
                jComboBox2 = new javax.swing.JComboBox<>();
                jLabel6 = new javax.swing.JLabel();
                jComboBox3 = new javax.swing.JComboBox<>();
                jLabel7 = new javax.swing.JLabel();
                jComboBox4 = new javax.swing.JComboBox<>();
                jButton1 = new javax.swing.JButton();
                jButton2 = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setResizable(false);

                jPanel1.setBackground(new java.awt.Color(255, 237, 207));

                jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(68, 68, 68));
                jLabel1.setText("Dice");

                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "ID", "Model", "Brand", "Size", "Color", "Price", "Stock"
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

                jLabel4.setText("Filer by Size :");

                jComboBox1.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                jLabel5.setText("Filter by Colour :");

                jComboBox2.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                jLabel6.setText("Filter By Brand :");

                jComboBox3.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                jLabel7.setText("Filter by Model :");

                jComboBox4.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                jButton1.setText("Refresh Table");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jButton2.setText("Filter Table");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jComboBox2,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jComboBox3,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jComboBox1,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jComboBox4,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel4)
                                                                                                                                                .addComponent(jLabel5)
                                                                                                                                                .addComponent(jLabel6)
                                                                                                                                                .addComponent(jLabel7))
                                                                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                                                .addGap(18, 18, 18))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel1)
                                                                                                .addGap(86, 86, 86)))
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                false)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jButton1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                149,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jButton2,
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
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                751,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap()));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
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
                                                                                                jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addContainerGap(
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                .addComponent(jTextField1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jLabel3)
                                                                                                                                .addComponent(jButton1)
                                                                                                                                .addComponent(jButton2))
                                                                                                                .addGap(18, 18, 18)))
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel4)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jComboBox1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jLabel5)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jComboBox2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jLabel6)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jComboBox3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(jLabel7)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jComboBox4,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap()));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
                refreshTable();
        }// GEN-LAST:event_jButton1ActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
                applyFilters();
        }// GEN-LAST:event_jButton2ActionPerformed

        private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
                search();
        }// GEN-LAST:event_jTextField1ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JComboBox<String> jComboBox2;
        private javax.swing.JComboBox<String> jComboBox3;
        private javax.swing.JComboBox<String> jComboBox4;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable jTable1;
        private javax.swing.JTextField jTextField1;
        // End of variables declaration//GEN-END:variables
}
