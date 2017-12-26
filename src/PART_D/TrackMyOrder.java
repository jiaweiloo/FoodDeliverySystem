/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_D;

import entity.*;
import fooddeliverysystem.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.JOptionPane;

/**
 *
 * @author jiaweiloo
 */
public class TrackMyOrder extends javax.swing.JFrame {

    MainForm mainform;
    Order order, temp;
    String purchasetime;
    String remainingTime;
    SimpleDateFormat timeOnly = new SimpleDateFormat("hh:mm:ss");
    SimpleDateFormat timein24hrs = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat dateOnly = new SimpleDateFormat("dd/MM/yyyy");
    static final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs

    /**
     * Creates new form TrackMyOrder
     */
    public TrackMyOrder() {
        initComponents();

        /*---------- Start timer to update with latest time ---------------*/
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //jtfTime.setText(new Date().toString());
                try {
                    String datenow = timein24hrs.format(new Date());
                    Date dtnow = timein24hrs.parse(datenow);
                    jtfTime.setText(timein24hrs.format(dtnow));
                    countRemainingTime();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        timer.start();
        /*----------                 End of Timer                 ---------------*/

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfOrderID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfRemainingTime = new javax.swing.JTextField();
        btnCheck = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jtfPurchaseTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaAddress = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jtfETA = new javax.swing.JTextField();
        jtfTime = new javax.swing.JTextField();
        lblTime = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter order ID: ");

        jtfOrderID.setText("200001");

        jLabel2.setText("Estimate Remaining time: ");

        jtfRemainingTime.setEditable(false);
        jtfRemainingTime.setText("Please enter order ID!");

        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jtfPurchaseTime.setText("00:00:00");

        jLabel3.setText("Purchase Time:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 102, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Track My Order");

        jLabel5.setText("Delivery Address: ");

        jtaAddress.setColumns(20);
        jtaAddress.setRows(5);
        jtaAddress.setText("None");
        jScrollPane1.setViewportView(jtaAddress);

        jLabel6.setText("Estimate To Arrive:");

        jtfETA.setText("00:00:00");

        jtfTime.setEditable(false);
        jtfTime.setText("06:28:40");

        lblTime.setText("Current Time:");

        jLabel7.setText("Status : ");

        jtfStatus.setEditable(false);
        jtfStatus.setText("Loading");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTime)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(207, 207, 207)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfOrderID)
                    .addComponent(jtfPurchaseTime, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfETA)
                    .addComponent(jtfRemainingTime, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(jtfTime, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addComponent(jtfStatus))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTime)
                    .addComponent(jtfTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jtfPurchaseTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfETA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfRemainingTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnCheck))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // TODO add your handling code here:
        if (jtfOrderID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter valid order ID! ");
        } else {

            try {
                int orderID = Integer.valueOf(jtfOrderID.getText());
                //Search by order id entered by user
                order = mainform.custList.searchByID(orderID);
                if (order == null) {
                    JOptionPane.showMessageDialog(null, "Order not found !Please enter valid order ID! ", "Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    //update data field with latest details
                    purchasetime = order.getPurchase_time();
                    countRemainingTime();
                    jtfPurchaseTime.setText(purchasetime);
                    jtaAddress.setText(order.getCust_deliveryAddress());
                    jtfStatus.setText(order.getCurrent_status());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "OrderID not in valid format! ", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        mainform.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    public void timerrun() {
        //timer function every 1000ms
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //jtfTime.setText(new Date().toString());
                try {
                    String datenow = timein24hrs.format(new Date());
                    Date dtnow = timein24hrs.parse(datenow);
                    jtfTime.setText(timein24hrs.format(dtnow));
                    countRemainingTime();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        timer.start();
    }

    public void countRemainingTime() {
        try {
            if (purchasetime != null) {
                Date date = timein24hrs.parse(purchasetime);
                String datenow = timein24hrs.format(new Date());
                Date dtnow = timein24hrs.parse(datenow);

                long millis = date.getTime();
                Date deliveredTime = new Date(millis + (30 * ONE_MINUTE_IN_MILLIS));

                jtfETA.setText(timein24hrs.format(deliveredTime));

                long diff = deliveredTime.getTime() - dtnow.getTime();

                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                long diffHours = diff / (60 * 60 * 1000) % 24;                
                String difference;
                if (diffMinutes < 0) {
                    difference = "00:00:00 Delivery completed!";
                    //difference = Long.toString(diffHours) + ":" + Long.toString(diffMinutes) + ":" + Long.toString(diffSeconds);
                } else {
                    difference = Long.toString(diffHours) + ":" + Long.toString(diffMinutes) + ":" + Long.toString(diffSeconds);
                }
                jtfRemainingTime.setText(difference);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setMainForm(MainForm mainform) {
        this.mainform = mainform;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtaAddress;
    private javax.swing.JTextField jtfETA;
    private javax.swing.JTextField jtfOrderID;
    private javax.swing.JTextField jtfPurchaseTime;
    private javax.swing.JTextField jtfRemainingTime;
    private javax.swing.JTextField jtfStatus;
    public static javax.swing.JTextField jtfTime;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}
