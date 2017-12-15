package PART_D;

import adt.*;
import entity.*;
import fooddeliverysystem.MainForm;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jiaweiloo
 */
public class deliveryManInterface extends javax.swing.JFrame {

    MainForm mainform;
    //ListInterface<employee> empList = new LList<employee>();
    //ListInterface<Attendance> attdList = new LList<Attendance>();
    EmployeeInterface<employee> empList;
    ListInterface<Attendance> attdList;
    LinkedQueue<Order> orderQueue;
    ListInterface<Order> orderList = new LList<Order>();
    employee emp, emp1, emp2, emp3, emp4, emp5;
    Attendance att, att1, att2, att3, att4, att5;
    Order ord;
    SimpleDateFormat timeOnly = new SimpleDateFormat("hh:mm:ss");
    boolean cont = true;
    int complete = 0;

    /**
     * Creates new form employeeInt
     */
    public deliveryManInterface() {
        initComponents();
        //porpulateData();
        updateTable();
    }

    public deliveryManInterface(EmployeeInterface<employee> empList, ListInterface<Attendance> attdList, employee emp, LinkedQueue<Order> orderQueue) {
        this.empList = empList;
        this.attdList = attdList;
        this.emp = emp;
        this.orderQueue = orderQueue;
        initComponents();
        //porpulateData();
        updateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        attdTable = new javax.swing.JTable();
        btnLunchOut = new javax.swing.JButton();
        lblZone = new javax.swing.JLabel();
        CBoxZone = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfDelAdd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfRestrt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfFinish = new javax.swing.JTextField();
        btnAccept = new javax.swing.JButton();
        btnBreak = new javax.swing.JButton();
        btnLunchIn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfStatus = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnComplete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        jtfCustName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfContinueStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        attdTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Clockin", "Clockout", "lunch_clockout", "lunch_clockin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(attdTable);
        if (attdTable.getColumnModel().getColumnCount() > 0) {
            attdTable.getColumnModel().getColumn(0).setHeaderValue("ID");
            attdTable.getColumnModel().getColumn(1).setHeaderValue("Date");
            attdTable.getColumnModel().getColumn(2).setHeaderValue("Clockin");
            attdTable.getColumnModel().getColumn(3).setHeaderValue("Clockout");
            attdTable.getColumnModel().getColumn(4).setHeaderValue("lunch_clockout");
            attdTable.getColumnModel().getColumn(5).setHeaderValue("lunch_clockin");
        }

        btnLunchOut.setText("Lunch Out");
        btnLunchOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLunchOutActionPerformed(evt);
            }
        });

        lblZone.setText("Current Zone :");

        CBoxZone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AA1", "AA2", "AA3", "AA4", "AA5" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Next Job");

        jLabel2.setText("Delivery Address :");

        jtfDelAdd.setEditable(false);
        jtfDelAdd.setText("none");

        jLabel3.setText("Pick-up Restaurant :");

        jtfRestrt.setEditable(false);
        jtfRestrt.setText("none");

        jLabel4.setText("Finished Job");

        jtfFinish.setEditable(false);
        jtfFinish.setText("0");

        btnAccept.setText("Open to Accept");
        btnAccept.setActionCommand("");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnBreak.setText("Break");
        btnBreak.setEnabled(false);
        btnBreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBreakActionPerformed(evt);
            }
        });

        btnLunchIn.setText("Lunch In");
        btnLunchIn.setEnabled(false);
        btnLunchIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLunchInActionPerformed(evt);
            }
        });

        jLabel5.setText("Current Status :");

        jtfStatus.setEditable(false);
        jtfStatus.setText("BREAK");

        btnCancel.setText("Cancel");

        btnComplete.setText("Complete Delivery");
        btnComplete.setEnabled(false);
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblName.setText("Customer Name :");

        jtfCustName.setEditable(false);
        jtfCustName.setText("None");

        jLabel6.setText("Continue Status:");

        jtfContinueStatus.setEditable(false);
        jtfContinueStatus.setText("true");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLunchOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLunchIn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jtfDelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBreak, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnComplete)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblZone)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel1))
                                        .addGap(48, 48, 48))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(lblName))
                                        .addGap(28, 28, 28)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(CBoxZone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnRefresh)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                                .addComponent(jLabel6))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jtfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfFinish, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(jtfContinueStatus)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jtfCustName))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfRestrt, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogout)
                    .addComponent(btnLunchOut)
                    .addComponent(btnLunchIn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfContinueStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblZone)
                            .addComponent(CBoxZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(jtfCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfDelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfRestrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBreak)
                    .addComponent(btnAccept)
                    .addComponent(btnCancel)
                    .addComponent(btnComplete))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLunchOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLunchOutActionPerformed
        // TODO add your handling code here:
        cont = false;
        btnAccept.setEnabled(false);
        btnLunchOut.setEnabled(false);
        btnLunchIn.setEnabled(true);
        btnBreak.setEnabled(false);
        jtfStatus.setText("BREAK");
        jtfContinueStatus.setText(Boolean.toString(cont));
        
    }//GEN-LAST:event_btnLunchOutActionPerformed

    private void btnLunchInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLunchInActionPerformed
        // TODO add your handling code here:
        cont = true;
        btnAccept.setEnabled(true);
        btnLunchOut.setEnabled(true);
        btnLunchIn.setEnabled(false);
        btnBreak.setEnabled(false);
        jtfStatus.setText("AVAILABLE");
        jtfContinueStatus.setText(Boolean.toString(cont));
    }//GEN-LAST:event_btnLunchInActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        if (jtfStatus.getText().equals("BREAK")) {
            att.setTime_checkout(timeOnly.format(new Date()));
            mainform.returnAtt(att);
            mainform.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "PLEASE CHANGE STATUS TO BREAK AND"+"\nCOMPLETE DELIVERY BEFORE LOGGING OUT", "LOGOUT FAIL!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        if (CBoxZone.getSelectedItem().toString().equals("AA1")) {
            ord = orderQueue.getFront();
            jtfStatus.setText("ACTIVE");
            jtfCustName.setText(ord.getCust_name());
            jtfDelAdd.setText(ord.getCust_deliveryAddress());
            jtfRestrt.setText(Integer.toString(ord.getRestaurant_id()));
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBreakActionPerformed
        // TODO add your handling code here:

        //btnCancel.setEnabled(true);
        cont = false;
        btnAccept.setEnabled(true);
        jtfContinueStatus.setText(Boolean.toString(cont));
        /*
        orderQueue.enqueue(ord);
        orderQueue.dequeue();
        if (!orderQueue.isEmpty()) {
            ord = orderQueue.getFront();
            jtfStatus.setText("ACTIVE");
            jtfCustName.setText(ord.getCust_name());
            jtfDelAdd.setText(ord.getCust_deliveryAddress());
            jtfRestrt.setText(Integer.toString(ord.getRestaurant_id()));
        } else {
            jtfStatus.setText("ACTIVE");
            jtfCustName.setText("NOT AVAILABLE! ");
            jtfDelAdd.setText("NONE");
            jtfRestrt.setText("NONE");
        }
         */
    }//GEN-LAST:event_btnBreakActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:
        cont = true;
        //orderQueue.dequeue();
        btnCancel.setEnabled(false);
        btnAccept.setEnabled(false);
        btnComplete.setEnabled(true);
        btnBreak.setEnabled(true);
        jtfStatus.setText("DELIVERY");
        mainform.empWaitingList.enqueue(emp.getEmp_id());
        jtfContinueStatus.setText(Boolean.toString(cont));
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        // TODO add your handling code here:
        //btnCancel.setEnabled(true);
        //btnAccept.setEnabled(true);
        if (cont == true) {
            mainform.empWaitingList.enqueue(emp.getEmp_id());
            jtfStatus.setText("ACTIVE");
            jtfCustName.setText("CHANGE STATUS TO AVAILABLE TO ACCEPT CUSTOMER!");
            jtfDelAdd.setText("NOT AVAILABLE");
            jtfRestrt.setText("NOT AVAILABLE");
        } else {
            jtfStatus.setText("BREAK");
            jtfCustName.setText("CHANGE STATUS TO AVAILABLE TO ACCEPT CUSTOMER!");
            jtfDelAdd.setText("NOT AVAILABLE");
            jtfRestrt.setText("NOT AVAILABLE");
        }
        /*
        if (!orderQueue.isEmpty()) {
            ord = orderQueue.dequeue();
            jtfStatus.setText("ACTIVE");
            jtfCustName.setText(ord.getCust_name());
            jtfDelAdd.setText(ord.getCust_deliveryAddress());
            jtfRestrt.setText(Integer.toString(ord.getRestaurant_id()));
        } else {
            jtfStatus.setText("ACTIVE");
            jtfCustName.setText("NOT AVAILABLE! ");
            jtfDelAdd.setText("NONE");
            jtfRestrt.setText("NONE");
        }
         */
        complete++;
        jtfFinish.setText(Integer.toString(complete));
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void updateTable() {
        //for (int count = 1; count <= 10; count++) {
        DefaultTableModel DTM = new DefaultTableModel();
        DTM.addColumn("ID");
        DTM.addColumn("Date");
        DTM.addColumn("ClockIn");
        DTM.addColumn("Clockout");
        DTM.addColumn("lunch_out");
        DTM.addColumn("lunch_in");

        for (int a = 1; a <= attdList.getNumberOfEntries(); a++) {
            if (attdList.getEntry(a).getEmp_id() == emp.getEmp_id()) {
                DTM.addRow(new Object[]{
                    attdList.getEntry(a).getAttendance_id(),
                    attdList.getEntry(a).getDate(),
                    attdList.getEntry(a).getTime_checkin(),
                    attdList.getEntry(a).getTime_checkout(),
                    attdList.getEntry(a).getLunch_checkout(),
                    attdList.getEntry(a).getLunch_checkin()
                });
            }
        }
        //DTM.addRow(row);
        attdTable.setModel(DTM);
        //}

    }

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
            java.util.logging.Logger.getLogger(deliveryManInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(deliveryManInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(deliveryManInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(deliveryManInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new deliveryManInterface().setVisible(true);

            }
        });
    }

    public void PreviousFrame(MainForm mainform) {
        this.mainform = mainform;
    }

    public void updateList(EmployeeInterface<employee> empList, ListInterface<Attendance> attdList) {
        this.empList = empList;
        this.attdList = attdList;
    }

    public void updateAttendance(Attendance att) {
        this.att = att;
    }

    public void updateEmp(employee emp) {
        this.emp = emp;
    }

    public void nextOrder(Order ord) {
        this.ord = ord;
        jtfStatus.setText("ACTIVE");
        jtfCustName.setText(ord.getCust_name());
        jtfDelAdd.setText(ord.getCust_deliveryAddress());
        jtfRestrt.setText(Integer.toString(ord.getRestaurant_id()));
    }

    public void reSorting() {
        ord = orderQueue.dequeue();
        /*
         if(ord.getRestaurant_id() == 000001)){
         orderList.add(ord);
         }
         */
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBoxZone;
    private javax.swing.JTable attdTable;
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnBreak;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLunchIn;
    private javax.swing.JButton btnLunchOut;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtfContinueStatus;
    private javax.swing.JTextField jtfCustName;
    private javax.swing.JTextField jtfDelAdd;
    private javax.swing.JTextField jtfFinish;
    private javax.swing.JTextField jtfRestrt;
    private javax.swing.JTextField jtfStatus;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblZone;
    // End of variables declaration//GEN-END:variables
}
