/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_D;

import PART_B.HR_Menu;
import adt.EmployeeADT;
import adt.EmployeeInterface;
import entity.employee;
import fooddeliverysystem.MainForm;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jiawe
 */
public class DailyEmpTasksHdlRprt extends javax.swing.JFrame {

    MainForm mainform;
    HR_Menu hrmenu;
    EmployeeInterface<employee> List = new EmployeeADT<employee>();

    /**
     * Creates new form DailyEmpTasksHdlRprt
     */
    public DailyEmpTasksHdlRprt() {
        initComponents();
    }

    public DailyEmpTasksHdlRprt(MainForm mainform, HR_Menu hrmenu) {
        initComponents();
        this.mainform = mainform;
        this.hrmenu = hrmenu;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        btnExitReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Emp ID", "Emp Email", "Phone", "Emp Status", "Total Handled"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(employeeTable);
        if (employeeTable.getColumnModel().getColumnCount() > 0) {
            employeeTable.getColumnModel().getColumn(0).setResizable(false);
            employeeTable.getColumnModel().getColumn(1).setResizable(false);
            employeeTable.getColumnModel().getColumn(2).setResizable(false);
        }

        btnExitReport.setText("Exit");
        btnExitReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(555, Short.MAX_VALUE)
                .addComponent(btnRefresh))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExitReport)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExitReport)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dm = (DefaultTableModel) employeeTable.getModel();
        dm.setRowCount(0);
        List.clear();
        employee newEmp;
        for (int b = 1; b < mainform.empList.getNumberOfEntries() + 1; b++) {
            //System.out.println("haha");
            newEmp = mainform.empList.getEntry(b);
            List.addByTaskHandled(newEmp);
            //System.out.println("HR_MENU : "+newEmp.getEmp_id());
        }
        Object[] rowdata = new Object[5];
        // System.out.println(List.getNumberOfEntries());
        for (int a = 1; a <= List.getNumberOfEntries(); a++) {
            System.out.println(a + " , HR_MENU : " + List.getEntry(a).getEmp_id() + " handled total : " + List.getEntry(a).getTotal_handled());
            rowdata[0] = List.getEntry(a).getEmp_id();
            rowdata[1] = List.getEntry(a).getEmail();
            rowdata[2] = List.getEntry(a).getPhone_num();
            rowdata[3] = List.getEntry(a).getStatus();
            rowdata[4] = List.getEntry(a).getTotal_handled();
            dm.addRow(rowdata);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnExitReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitReportActionPerformed
        // TODO add your handling code here:
        this.dispose();
        hrmenu.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitReportActionPerformed

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
            java.util.logging.Logger.getLogger(DailyEmpTasksHdlRprt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DailyEmpTasksHdlRprt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DailyEmpTasksHdlRprt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DailyEmpTasksHdlRprt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailyEmpTasksHdlRprt().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExitReport;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JTable employeeTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
