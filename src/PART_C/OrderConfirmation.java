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
import adt.*;
import entity.*;

public class OrderConfirmation extends JFrame {

    JLabel jlblName = new JLabel("Name :");
    JLabel jlblDate = new JLabel("Date :");
    JLabel jlblOrder = new JLabel("Order Item");
    JButton jbConfirm = new JButton("Confirm");
    JLabel jlblAddressHeader = new JLabel("Delivery Address :");
    JLabel jlblAddress = new JLabel("123, Taman Sri Rampai, 53300 Setapak, Kuala Lumpur");
    JTable table;
    String[] columnNames = {"Item Name", "Quantity", "Amount (RM)"};
    JScrollPane scrollPane;
    JButton jbtBack = new JButton("Back");
    int totalPrice = 0;
    LList<OrderList> orderList;
    LList<Item> itemList;

    public OrderConfirmation(LList<OrderList> orderList, LList<Item> itemList) {
        this.orderList = orderList;
        this.itemList = itemList;
        String[][] data = new String[orderList.getNumberOfEntries()][3];
        for(int a=1;a<=orderList.getNumberOfEntries();a++){
            System.out.println(orderList.getEntry(a).getSubTotal());
        }
        for (int a = 1; a <= orderList.getNumberOfEntries(); a++) {
            for (int b = 1; b <= itemList.getNumberOfEntries(); b++) {
                if (orderList.getEntry(a).getItem_id()==itemList.getEntry(b).getItem_id()) {
                    data[a - 1][0] = itemList.getEntry(b).getItem_name();
                    data[a - 1][1] = orderList.getEntry(a).getQuantity();
                    data[a - 1][2] = orderList.getEntry(a).getSubTotal();
                    totalPrice += Integer.parseInt(orderList.getEntry(a).getSubTotal());
                }
            }
        }
        table = new JTable(data, columnNames);

        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        table.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(table);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println();
        setLayout(new GridLayout(6, 2));
        add(jlblName);
        add(new JLabel("James Bond"));
        add(jlblDate);
        add(new JLabel(dateFormat.format(date)));
        add(jlblOrder);
        add(scrollPane);
        add(new JLabel("Total Amount (RM) :"));
        add(new JLabel(String.valueOf(totalPrice)));
        add(jlblAddressHeader);
        add(jlblAddress);
        add(jbtBack);
        add(jbConfirm);

        jbConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jbConfirm(e);
            }
        });

        jbtBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jbBack(e,orderList,itemList);
            }
        });

    }

    private void jbConfirm(ActionEvent e) {
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Make Delivery?", "Warning", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Your order is on its way!");
        }
    }

    private void jbBack(ActionEvent e,LList<OrderList>orderList,LList<Item>itemList) {
        // TODO add your handling code here:
        this.setVisible(false);
        Cart ct = new Cart();
        ct.setTitle("Cart");

        ct.setSize(1200, 600);
        ct.setLocationRelativeTo(null);
        ct.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ct.setVisible(true);
    }

    /*public static void main(String[] args) {
        OrderConfirmation frm = new OrderConfirmation();
        frm.setTitle("Order Details");
        frm.setSize(800, 500);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.setVisible(true);
    }*/
}
