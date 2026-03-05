package com.app.screens;

import com.app.controllers.SupplierController;
import com.app.models.Supplier;
import javax.swing.JOptionPane;

public class UpdateSupplierFrame extends javax.swing.JFrame {

        private final SupplierController supplierController = new SupplierController();
        private int selectedSupplierId = -1;

        public UpdateSupplierFrame() {
                initComponents();
                setLocationRelativeTo(null);
        }

        public UpdateSupplierFrame(int supplierId) {
                this();
                this.selectedSupplierId = supplierId;
                loadSupplierData(supplierId);
        }

        private void loadSupplierData(int supplierId) {
                Supplier s = supplierController.getSupplierById(supplierId);
                if (s != null) {
                        jTextField2.setText(s.getName());
                        jTextField3.setText(s.getBrand());
                        jTextField4.setText(s.getContactInfo());
                } else {
                        JOptionPane.showMessageDialog(this, "Supplier not found.");
                        this.dispose();
                }
        }

        private void updateSupplier() {
                if (selectedSupplierId == -1) {
                        JOptionPane.showMessageDialog(this, "Please select a supplier.");
                        return;
                }

                String name = jTextField2.getText().trim();
                String brand = jTextField3.getText().trim();
                String contact = jTextField4.getText().trim();

                if (name.isEmpty() || brand.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Name and Brand are required.");
                        return;
                }

                Supplier supplier = new Supplier(selectedSupplierId, name, brand, contact);
                if (supplierController.updateSupplier(supplier)) {
                        JOptionPane.showMessageDialog(this, "Supplier updated successfully!");
                        this.dispose();
                } else {
                        JOptionPane.showMessageDialog(this, "Failed to update supplier.");
                }
        }

        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jButton1 = new javax.swing.JButton();
                jTextField2 = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jTextField3 = new javax.swing.JTextField();
                jTextField4 = new javax.swing.JTextField();
                jLabel4 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setResizable(false);

                jPanel1.setBackground(new java.awt.Color(255, 237, 207));

                jButton1.setText("Update");
                jButton1.addActionListener(this::jButton1ActionPerformed);

                jLabel2.setText("New name :");

                jLabel3.setText("New brand :");

                jLabel4.setText("New contact info :");

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
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jLabel3,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                95,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(jTextField3,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                200,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jLabel4,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                107,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jTextField4,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                200,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                                .addComponent(jLabel2,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                95,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(jTextField2,
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
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jTextField2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jTextField3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel4)
                                                                                .addComponent(jTextField4,
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
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
                updateSupplier();
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField jTextField2;
        private javax.swing.JTextField jTextField3;
        private javax.swing.JTextField jTextField4;
        // End of variables declaration//GEN-END:variables
}
