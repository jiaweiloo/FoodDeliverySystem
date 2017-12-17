package fooddeliverysystem;

import PART_B.Update_Delivery_Men;
import PART_C.*;
import PART_D.*;
import adt.*;
import entity.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * @author jiaweiloo
 */
public class MainForm extends javax.swing.JFrame {

    public EmployeeInterface<employee> empList = new EmployeeADT<employee>();
    public ListInterface<Attendance> attdList = new LList<Attendance>();
    public OrderInterface<Order> orderList = new OrderADT<Order>();
    public WaitingInterface<employee> empWaitingList = new WaitingQueueADT<employee>();
    ListInterface<emp_handled_list> ehlList = new LList<emp_handled_list>();
    public ListInterface<Order> finishedOrder = new LList<Order>();
    employee emp, emp1, emp2, emp3, emp4, emp5, tempEmp;
    Attendance att, att1, att2, att3, att4, att5;
    Order ord, ord1, ord2, ord3, ord4, ord5, tempOrd;
    emp_handled_list ehl;
    SimpleDateFormat timeOnly = new SimpleDateFormat("hh:mm:ss");
    SimpleDateFormat dateOnly = new SimpleDateFormat("dd/MM/yyyy");
    deliveryManInterface DMI;
    public Order order = new Order();
    public LList<Order> custList = new LList<Order>();
    public String phoneNo;

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnBrowse = new javax.swing.JButton();
        btnTrack = new javax.swing.JButton();
        jbtGetCustomer = new javax.swing.JButton();
        jbClearCust = new javax.swing.JButton();
        btnAfftLogin = new javax.swing.JButton();

        jButton6.setText("jButton6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 300));

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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 102, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("User Login");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 102, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Customer");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        btnTrack.setText("Track My Order");
        btnTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackActionPerformed(evt);
            }
        });

        jbtGetCustomer.setText("Get Customer Info");
        jbtGetCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGetCustomerActionPerformed(evt);
            }
        });

        jbClearCust.setText("Clear Customer Info");
        jbClearCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClearCustActionPerformed(evt);
            }
        });

        btnAfftLogin.setText("Affiliate Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTrack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtGetCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbClearCust, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTime))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpfPassword)
                            .addComponent(jtfEmail)
                            .addComponent(jtfTime, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(btnFgtPw, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnAfftLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addGap(40, 40, 40)
                        .addComponent(btnBrowse)
                        .addGap(18, 18, 18)
                        .addComponent(btnTrack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtGetCustomer)
                        .addGap(18, 18, 18)
                        .addComponent(jbClearCust)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTime)
                                    .addComponent(jtfTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPassword))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnLogin)
                                    .addComponent(btnFgtPw))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRegister)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnExit)
                                    .addComponent(btnAfftLogin))))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        boolean success = false;
        if (empList.searchString(jtfEmail.getText()) != null) {
            emp = empList.searchString(jtfEmail.getText());
            if (emp.getPassword().equals(jpfPassword.getText())) {
                Attendance atd = attdList.getEntry(attdList.getNumberOfEntries());
                if (!atd.getDate().equals(dateOnly.format(new Date()))) {
                    att = new Attendance(
                            attdList.getEntry(attdList.getNumberOfEntries()).getAttendance_id() + 1,
                            emp.getEmp_id(),
                            dateOnly.format(new Date()),
                            timeOnly.format(new Date()),
                            "00:00:00",
                            "00:00:00",
                            "00:00:00");
                    attdList.add(att);
                }
                success = true;
            } else {
                success = false;

            }
        }

        if (!success) {
            JOptionPane.showMessageDialog(null, "Verified fail! Please try again");
        } else {
            //see login rank is deliveryman ,executive manager, or affiliates
            switch (emp.getRank()) {
                case "DM":
                    DMI = new deliveryManInterface(empList, attdList, emp, orderList, this);
                    DMI.updateAttendance(att);
                    DMI.setVisible(true);
                    DMI.PreviousFrame(this);
                    this.setVisible(false);
                    break;
                case "EXEC":
                    JOptionPane.showMessageDialog(null, "Login success, application under construction! ");
                    break;
                case "AFFT":
                    JOptionPane.showMessageDialog(null, "Login success, application under construction! ");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Login success, USER DO NOT BELONG TO ANY GROUP! ");
                    break;
            } //switch case for login interface
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackActionPerformed
        // TODO add your handling code here:
        TrackMyOrder TMO = new TrackMyOrder();
        TMO.setMainForm(this);
        TMO.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTrackActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        // TODO add your handling code here:
        if (phoneNo != null) {
            SelectRestaurant2 sr2 = new SelectRestaurant2(order, orderList, this);
        } else {
            CustFillInForm custForm = new CustFillInForm(order, orderList, this);
            custForm.PreviousFrame(this);
            custForm.setVisible(true);
            custForm.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void jbtGetCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGetCustomerActionPerformed
        // TODO add your handling code here:
        GetCustInfo getCust = new GetCustInfo(order, custList, this);
    }//GEN-LAST:event_jbtGetCustomerActionPerformed

    private void jbClearCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClearCustActionPerformed
        // TODO add your handling code here:
        phoneNo = null;
    }//GEN-LAST:event_jbClearCustActionPerformed

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
        //timer function every 1000ms
        //Timer timer = new Timer();
        int delay = 200;
        Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jtfTime.setText(new Date().toString());
                mainform.refreshWaitingList();
            }
        });
        timer.start();
    }



    private void refreshWaitingList() {
        //loadAvailableEmployee();
        int handle_id = 900001;
        if (!empWaitingList.isEmpty() && !orderList.isEmpty()) {
            tempEmp = empWaitingList.dequeue();
            tempOrd = orderList.dequeue();
            finishedOrder.add(tempOrd);

            if (!ehlList.isEmpty()) {
                handle_id = ehlList.getEntry(ehlList.getNumberOfEntries()).getHandle_id() + 1;
            }
            ehl = new emp_handled_list(handle_id, tempEmp.getEmp_id(), tempOrd.getOrder_id(), dateOnly.format(new Date()), timeOnly.format(new Date()), "HANDLED", "NONE");
            ehlList.add(ehl);
            System.out.println(handle_id + ";Order id : " + Integer.toString(ehl.getOrder_id()) + ",handled by employee : " + Integer.toString(ehl.getEmp_id()));
            if (emp != null) {
                if (tempEmp.getEmp_id() == emp.getEmp_id()) {
                    DMI.nextOrder(tempOrd);
                }
            }
        }
    }

    private void updateList() {
        emp1 = new employee(100001, "jason@mail.com", "abcd1234", "offline", "890831-05-4492", "A-4-2 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-4441221", "DM", 2009, 1);
        emp2 = new employee(100002, "jack@mail.com", "abcd1234", "other", "890731-05-4492", "A-7-4 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-4661321", "EXEC", 2010, 5);
        emp3 = new employee(100003, "annabelle@mail.com", "abcd1234", "offline", "800831-05-4592", "A-3-6 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-8535221", "DM", 2016, 3);
        emp4 = new employee(100004, "marie@mail.com", "abcd1234", "offline", "990731-08-4492", "A-2-2 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-1231221", "DM", 2012, 2);
        emp5 = new employee(100005, "lucas@mail.com", "abcd1234", "other", "790821-05-4492", "A-6-5 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-4990621", "AFFT", 2014, 2);
        att1 = new Attendance(600001, 100001, "21/07/2017", "08:00:21", "17:03:21", "13:10:52", "13:55:13");
        att2 = new Attendance(600002, 100002, "21/07/2017", "08:01:11", "17:13:31", "13:05:51", "14:02:11");
        att3 = new Attendance(600003, 100001, "22/07/2017", "08:11:31", "17:23:41", "13:12:25", "14:01:12");
        att4 = new Attendance(600004, 100002, "22/07/2017", "08:05:41", "17:02:51", "13:13:15", "14:11:33");
        att5 = new Attendance(600005, 100001, "23/07/2017", "07:59:51", "17:01:01", "13:11:25", "14:02:23");
        ord1 = new Order(200001, "LOI KAH HOU", "014-2233445", "loikh-wa15@student.tarc.edu.my", "A-6-5 Sri Pelangi, Jln Genting Klang, " + "\n 53300 KL", 300001, 25.50, 2, "PENDING", "14/12/2017", "19:16:51");
        ord2 = new Order(200002, "LIM JUN KIT ", "012-3311221", "limjk-wa15@student.tarc.edu.my", "A-9-5 Teratai Residency, Jln Genting Klang, 53300 KL", 300002, 35.50, 4, "PENDING", "10/12/2017", "18:59:51");
        ord3 = new Order(200003, "MAH HONG WAI", "014-3311311", "mahhw-wa15@student.tarc.edu.my", "A-6-5 Sri Pelangi, Jln Genting Klang, 53300 KL", 300001, 30.50, 2, "PENDING", "11/12/2017", "17:59:51");
        ord4 = new Order(200004, " LIM NAN FUNG", "014-1235437", "limnf-wa15@student.tarc.edu.my", "B-6-5 Teratai Residency, Jln Genting Klang, 53300 KL", 300002, 17.50, 1, "PENDING", "12/12/2017", "16:35:51");
        ord5 = new Order(200005, "LIM PENG LEN", "013-22211122", "limpl-wa15@student.tarc.edu.my", "C-6-5 Sri Pelangi, Jln Genting Klang, 53300 KL", 300002, 22.50, 3, "PENDING", "13/12/2017", "15:37:51");
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
        orderList.enqueue(ord1);
        orderList.enqueue(ord2);
        orderList.enqueue(ord3);
        orderList.enqueue(ord4);
        orderList.enqueue(ord5);
        //empWaitingList.enqueueAscTotalHandled(emp1);
        //empWaitingList.enqueueAscTotalHandled(emp2);        
        empWaitingList.enqueueAscTotalHandled(emp3);
        empWaitingList.enqueueAscTotalHandled(emp4);
        empWaitingList.enqueueAscTotalHandled(emp5);
    }

    public void returnAtt(Attendance att) {
        this.att = att;
        attdList.replace(attdList.getNumberOfEntries(), att);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfftLogin;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFgtPw;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnTrack;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbClearCust;
    private javax.swing.JButton jbtGetCustomer;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JTextField jtfEmail;
    public static javax.swing.JTextField jtfTime;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}
