package com.app.screens;

import com.app.controllers.CategoryController;
import com.app.models.Category;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class UpdateCategoryFrame extends javax.swing.JFrame {

        private final CategoryController categoryController = new CategoryController();

        public UpdateCategoryFrame() {
                initComponents();
                loadCategories();
                setLocationRelativeTo(null);
                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        }

        private void loadCategories() {
                List<Category> categories = categoryController.getAllCategories();
                DefaultComboBoxModel<Category> model = new DefaultComboBoxModel<>();
                for (Category category : categories) {
                        model.addElement(category);
                }
                jComboBox1.setModel(model);
        }

        private void updateCategory() {
                Category selectedCategory = (Category) jComboBox1.getSelectedItem();
                String newName = jTextField2.getText();

                if (selectedCategory == null) {
                        JOptionPane.showMessageDialog(this, "Please select a category to update.");
                        return;
                }
                if (newName.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please enter new category name.");
                        return;
                }
                if (categoryController.updateCategory(selectedCategory.getCategoryId(), newName)) {
                        JOptionPane.showMessageDialog(this, "Category updated successfully!");
                        this.dispose();
                } else {
                        JOptionPane.showMessageDialog(this, "Failed to update category.");
                }
        }

    //<editor-fold defaultstate=\"collapsed\" desc=\"Generated Code\">//GEN-BEGIN:initComponents
        private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 237, 207));

        jLabel1.setText("Current Category :");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("New Category :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<Category>());

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
        .addComponent(jLabel2,
        javax.swing.GroupLayout.PREFERRED_SIZE,
        95,
        javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jLabel1,
        javax.swing.GroupLayout.PREFERRED_SIZE,
        107,
        javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(
        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout
        .createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING,
        false)
        .addComponent(jComboBox1,
        0,
        javax.swing.GroupLayout.DEFAULT_SIZE,
        Short.MAX_VALUE)
        .addComponent(jTextField2,
        javax.swing.GroupLayout.DEFAULT_SIZE,
        200,
        Short.MAX_VALUE))))
        .addContainerGap(26, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(26, 26, 26)
        .addGroup(jPanel1Layout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel1)
        .addComponent(jComboBox1,
        javax.swing.GroupLayout.PREFERRED_SIZE,
        javax.swing.GroupLayout.DEFAULT_SIZE,
        javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(26, 26, 26)
        .addGroup(jPanel1Layout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.BASELINE)
        .addComponent(jLabel2)
        .addComponent(jTextField2,
        javax.swing.GroupLayout.PREFERRED_SIZE,
        javax.swing.GroupLayout.DEFAULT_SIZE,
        javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, Short.MAX_VALUE)
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
    }//</editor-fold>//GEN-END:initComponents
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                updateCategory();
    }//GEN-LAST:event_jButton1ActionPerformed
    //Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JComboBox<Category> jComboBox1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField jTextField2;
    //End of variables declaration//GEN-END:variables
}
