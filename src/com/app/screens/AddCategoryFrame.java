package com.app.screens;

import com.app.controllers.CategoryController;
import javax.swing.JOptionPane;

public class AddCategoryFrame extends javax.swing.JFrame {

        private final CategoryController categoryController = new CategoryController();

        public AddCategoryFrame() {
                initComponents();
                setLocationRelativeTo(null);
        }

        private void addCategory() {
                String name = jTextField1.getText();
                if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please enter category name.");
                        return;
                }
                if (categoryController.addCategory(name)) {
                        JOptionPane.showMessageDialog(this, "Category added successfully!");
                        this.dispose();
                } else {
                        JOptionPane.showMessageDialog(this, "Failed to add category.");
                }
        }

    //<editor-fold defaultstate=\"collapsed\" desc=\"Generated Code\">//GEN-BEGIN:initComponents
        private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 237, 207));

        jLabel1.setText("Category Name :");

        jButton1.setText("Add");
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
        javax.swing.GroupLayout.Alignment.TRAILING)
        .addComponent(jButton1)
        .addGroup(jPanel1Layout
        .createSequentialGroup()
        .addComponent(jLabel1,
        javax.swing.GroupLayout.PREFERRED_SIZE,
        110,
        javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(
        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextField1,
        javax.swing.GroupLayout.PREFERRED_SIZE,
        200,
        javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(26, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addGroup(jPanel1Layout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel1)
        .addComponent(jTextField1,
        javax.swing.GroupLayout.PREFERRED_SIZE,
        javax.swing.GroupLayout.DEFAULT_SIZE,
        javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(20, 20, 20)
        .addComponent(jButton1)
        .addContainerGap(30, Short.MAX_VALUE)));

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
    }//</editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                addCategory();
    }//GEN-LAST:event_jButton1ActionPerformed
    //Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField jTextField1;
    //End of variables declaration//GEN-END:variables
}
