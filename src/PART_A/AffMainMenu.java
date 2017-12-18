/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_A;

/**
 *
 * @author Mah Hong Wai
 */
import adt.AffiliateInterface;
import adt.LList;
import adt.ListInterface;
import entity.Affiliate;
import fooddeliverysystem.MainForm;
public class AffMainMenu extends javax.swing.JFrame {

    /**
     * Creates new form AffMainMenu
     */
    AffiliateInterface<Affiliate> aff;
    int ID;
    public AffMainMenu(int CurrentID,AffiliateInterface Aff) {
        initComponents();
        
        aff=Aff;
        ID = CurrentID;
        
        for(int i=1;i<aff.getNumberOfEntries()+1;i++){
            if(aff.getEntry(i).getAffiliate_id()==ID){
                lblRestName.setText(aff.getEntry(i).getRest_name());
            }
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRestName = new javax.swing.JLabel();
        btnAddItem2 = new javax.swing.JButton();
        btnDeleteItem = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnArrange = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRestName.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblRestName.setForeground(new java.awt.Color(153, 0, 153));
        lblRestName.setText("jLabel1");

        btnAddItem2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAddItem2.setText("Add New Item");
        btnAddItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItem2ActionPerformed(evt);
            }
        });

        btnDeleteItem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDeleteItem.setText("Delete Item");
        btnDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteItemActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdate.setText("Update Item Detail");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnArrange.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnArrange.setText("Arrange Item Position");
        btnArrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArrangeActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUpdate)
                            .addComponent(btnAddItem2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnArrange)
                            .addComponent(btnDeleteItem)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(lblRestName, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRestName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArrange, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItem2ActionPerformed
        // TODO add your handling code here:
        AddItem AddItem = new AddItem(ID,aff);
        AddItem.setVisible(true);
        AddItem.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddItem2ActionPerformed

    private void btnDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteItemActionPerformed
        // TODO add your handling code here:
        DeleteItem DeleteItem = new DeleteItem(ID,aff);
        DeleteItem.setVisible(true);
        DeleteItem.setLocationRelativeTo(null);
        this.setVisible(false);

    }//GEN-LAST:event_btnDeleteItemActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        UpdateItemDetail UpdateItem = new UpdateItemDetail(ID,aff);
        UpdateItem.setVisible(true);
        UpdateItem.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnArrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArrangeActionPerformed
        // TODO add your handling code here:
        ArrangeItem ArrangeItem = new ArrangeItem(ID,aff);
        ArrangeItem.setVisible(true);
        ArrangeItem.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnArrangeActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        MainForm MainForm = new MainForm();
        MainForm.setVisible(true);
        MainForm.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AffMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AffMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AffMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AffMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem2;
    private javax.swing.JButton btnArrange;
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblRestName;
    // End of variables declaration//GEN-END:variables
}
