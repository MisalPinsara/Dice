package com.app.screens;

import com.app.classes.Constants;
import com.app.controllers.InventoryController;
import com.app.models.ShoeItem;
import java.util.List;
import javax.swing.JOptionPane;

public class UpdateStockFrame extends javax.swing.JFrame {

        private final InventoryController inventoryController = new InventoryController();
        private int shoeId;

        public UpdateStockFrame() {
                initComponents();
                setLocationRelativeTo(null);
        }

        public UpdateStockFrame(int shoeId) {
                this.shoeId = shoeId;
                initComponents();
                loadShoeDetails();
                setLocationRelativeTo(null);
        }

        private void loadShoeDetails() {
                // Populate combo boxes first
                List<String> models = inventoryController.getUniqueModels();
                List<String> brands = inventoryController.getUniqueBrands();

                jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(models.toArray(new String[0])));
                jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(brands.toArray(new String[0])));

                ShoeItem item = inventoryController.getShoeById(shoeId);
                if (item != null) {
                        jComboBox3.setSelectedItem(item.getModel());
                        jComboBox4.setSelectedItem(item.getBrand());
                        jComboBox1.setSelectedItem(item.getSizeRange());
                        jComboBox2.setSelectedItem(item.getColor());
                }
        }

        private void updateStock() {
                try {
                        int additionalStock = Integer.parseInt(jTextField5.getText());
                        if (inventoryController.adjustStock(shoeId, additionalStock)) {
                                JOptionPane.showMessageDialog(this, "Stock updated successfully!");
                                this.dispose();
                        } else {
                                JOptionPane.showMessageDialog(this, "Failed to update stock.");
                        }
                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Enter valid stock number.");
                }
        }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    //<editor-fold defaultstate=\"collapsed\" desc=\"Generated Code\">//GEN-BEGIN:initComponents
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
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 237, 207));

        jLabel1.setText("Model :");

        jLabel2.setText("Brand :");

        jLabel3.setText("Size Range :");

        jLabel4.setText("Color :");

        jLabel5.setText("Add Stock :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(Constants.SIZES));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(Constants.COLORS));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Model" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Brand" }));

        jButton1.setText("Update Stock");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(26, 26, 26)
        .addGroup(jPanel1Layout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout
        .createSequentialGroup()
        .addGroup(jPanel1Layout
        .createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jLabel1)
        .addComponent(jLabel2)
        .addComponent(jLabel3)
        .addComponent(jLabel4)
        .addComponent(jLabel5))
        .addGap(50, 50, 50)
        .addGroup(jPanel1Layout
        .createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jTextField5,
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
        javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jComboBox3,
        javax.swing.GroupLayout.PREFERRED_SIZE,
        200,
        javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jComboBox4,
        javax.swing.GroupLayout.PREFERRED_SIZE,
        200,
        javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addComponent(jButton1,
        javax.swing.GroupLayout.Alignment.TRAILING))
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
        .addGap(20, 20, 20)
        .addGroup(jPanel1Layout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel2)
        .addComponent(jComboBox4,
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
        .addGap(26, 26, 26)
        .addComponent(jButton1)
        .addContainerGap(26, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
        javax.swing.GroupLayout.DEFAULT_SIZE,
        javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
        javax.swing.GroupLayout.DEFAULT_SIZE,
        javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }//</editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                updateStock();
    }//GEN-LAST:event_jButton1ActionPerformed
    //Variables declaration - do not modify//GEN-BEGIN:variables

        private javax.swing.JButton jButton1;
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JComboBox<String> jComboBox2;
        private javax.swing.JComboBox<String> jComboBox3;
        private javax.swing.JComboBox<String> jComboBox4;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField jTextField5;
    //End of variables declaration//GEN-END:variables
}
