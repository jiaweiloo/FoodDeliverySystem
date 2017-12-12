package fooddeliverysystem;

import PART_B.Update_Delivery_Men;
import PART_C.SelectRestaurant;
import PART_D.*;
import adt.*;
import entity.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author jiaweiloo
 */
public class MainForm extends javax.swing.JFrame {

    ListInterface<employee> empList = new LList<employee>();
    ListInterface<Attendance> attdList = new LList<Attendance>();
    employee emp, emp1, emp2, emp3, emp4, emp5;
    Attendance att, att1, att2, att3, att4, att5;
    SimpleDateFormat timeOnly = new SimpleDateFormat("hh:mm:ss");
    SimpleDateFormat dateOnly = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        updateList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jtfTime = new javax.swing.JTextField();
        lblTime = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jpfPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnFgtPw = new javax.swing.JButton();

        jButton6.setText("jButton6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 300));

        jButton2.setText("PART A");
        jButton2.setActionCommand("");

        jButton3.setText("PART B");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("PART C");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("PART D");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnRegister.setLabel("Register");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jtfTime.setEditable(false);
        jtfTime.setText("Thu Dec 07 00:00:01 SGT 2017");

        lblTime.setText("Current Time:");

        jLabel1.setText("Email:");

        lblPassword.setText("Password:");

        jtfEmail.setText("jason@mail.com");

        jpfPassword.setText("abcd1234");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnFgtPw.setText("Forget Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(144, 144, 144)
                                    .addComponent(lblTime)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfTime, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(160, 160, 160)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(lblPassword))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfEmail)
                                        .addComponent(jpfPassword)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(jButton2)
                                    .addGap(27, 27, 27)
                                    .addComponent(jButton3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(btnLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFgtPw)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
                        .addGap(0, 119, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnFgtPw, btnLogin, btnRegister});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTime)
                    .addComponent(jtfTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFgtPw, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegister, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(95, 95, 95)
                .addComponent(btnExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //Attendance attendance = new Attendance();
        //attendance.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        SelectRestaurant restaurant = new SelectRestaurant();
        restaurant.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // New_Delivery_Man newD;
        //newD = new New_Delivery_Man();
        // newD.setVisible(true);
        // this.dispose();
        Update_Delivery_Men.main(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        //Loop and get everything in mylist and compare the object in the list with the textbox field
        boolean success = false;
        for (int a = 1; a < empList.getNumberOfEntries(); a++) {
            emp = empList.getEntry(a);
            //verified email and password
            if (emp.getEmail().equals(jtfEmail.getText()) && emp.getPassword().equals(jpfPassword.getText())) {
                Attendance att = new Attendance(attdList.getEntry(attdList.getNumberOfEntries()).getAttendance_id() + 1,
                        emp.getEmp_id(), dateOnly.format(new Date()), "07:59:51", "17:01:01", "13:11:25", "14:02:23");
                attdList.add(att);

                success = true;
                break;
            } else {
                success = false;
            }
        }
        
        if (!success) {
            JOptionPane.showMessageDialog(null, "Verified fail! Please try again");
        } else {
            if (emp.getRank().equals("DM")) //open employee interface
            {
                startEmployeeInterface();
                this.setVisible(false);
            }

        }
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        MainForm mainform = new MainForm();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainform.setVisible(true);
            }
        });

        //new MainForm().setVisible(true);
    }

    private void updateList() {
        emp1 = new employee(100001, "jason@mail.com", "abcd1234", "available", "890831-05-4492", "A-4-2 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-4441221", "DM");
        emp2 = new employee(100002, "jack@mail.com", "abcd1234", "offline", "890731-05-4492", "A-7-4 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-4661321", "EXEC");
        emp3 = new employee(100003, "annabelle@mail.com", "abcd1234", "available", "800831-05-4592", "A-3-6 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-8535221", "DM");
        emp4 = new employee(100004, "marie@mail.com", "abcd1234", "delivering", "990731-08-4492", "A-2-2 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-1231221", "DM");
        emp5 = new employee(100005, "lucas@mail.com", "abcd1234", "other", "790821-05-4492", "A-6-5 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-4990621", "AFFT");
        att1 = new Attendance(600001, 100001, "21/07/2017", "08:00:21", "17:03:21", "13:10:52", "13:55:13");
        att2 = new Attendance(600002, 100002, "21/07/2017", "08:01:11", "17:13:31", "13:05:51", "14:02:11");
        att3 = new Attendance(600003, 100001, "22/07/2017", "08:11:31", "17:23:41", "13:12:25", "14:01:12");
        att4 = new Attendance(600004, 100002, "22/07/2017", "08:05:41", "17:02:51", "13:13:15", "14:11:33");
        att5 = new Attendance(600005, 100001, "23/07/2017", "07:59:51", "17:01:01", "13:11:25", "14:02:23");
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        empList.add(emp5);
        attdList.add(att1);
        attdList.add(att2);
        attdList.add(att3);
        attdList.add(att4);
        attdList.add(att5);
    }

    public void startEmployeeInterface() {
        deliveryManInterface DMI = new deliveryManInterface(empList, attdList);
        DMI.setVisible(true);
        DMI.PreviousFrame(this);
        //empInt.updateList(empList, attdList);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFgtPw;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JTextField jtfEmail;
    public static javax.swing.JTextField jtfTime;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}
