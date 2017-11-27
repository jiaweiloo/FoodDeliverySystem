/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_C;

/**
 *
 * @author Loi Kah Hou
 */
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class OrderConfirmation extends JFrame {

    JLabel jlblName = new JLabel("Name :");
    JLabel jlblDate = new JLabel("Date :");
    JLabel jlblOrder = new JLabel("Order Item");
    JButton jbConfirm = new JButton("Confirm");
    JTable table;
    String[] columnNames = {"Item Name", "Quantity", "Amount (RM)"};
    Object[][] data = {{"Curry Chicken", "2", "10"}, {"Curry Fish Head", "1", "20"}, {"Thai Fried Rice", "1", "10"}};
    JScrollPane scrollPane;

    public OrderConfirmation() {
        table = new JTable(data, columnNames);

        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        table.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(table);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println();
        setLayout(new GridLayout(5, 2));
        add(jlblName);
        add(new JLabel("James Bond"));
        add(jlblDate);
        add(new JLabel(dateFormat.format(date)));
        add(jlblOrder);
        add(new JLabel());
        add(scrollPane);
        add(new JLabel());
        add(new JLabel());
        add(jbConfirm);
        
        jbConfirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jbConfirm(e);
            }
        });

    }
    
    private void jbConfirm(ActionEvent e) {                                         
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog (null, "Make Delivery?","Warning",JOptionPane.YES_NO_OPTION);
        if(result==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Your order is on its way!"); 
        }
    }

    public static void main(String[] args) {
        OrderConfirmation frm = new OrderConfirmation();
        frm.setTitle("Order Details");
        frm.setSize(800, 500);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }

}
