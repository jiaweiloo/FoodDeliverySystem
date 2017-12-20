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
import fooddeliverysystem.MainForm;

public class OrderConfirmation extends JFrame {

    MainForm mainform;
    JLabel jlblName = new JLabel("Name :");
    JLabel jlblDate = new JLabel("Date :");
    JLabel jlblOrder = new JLabel("Order Item");
    JButton jbConfirm = new JButton("Confirm");
    JLabel jlblAddressHeader = new JLabel("Delivery Address :");
    JTable table;
    String[] columnNames = {"Item Name", "Quantity", "Amount (RM)"};
    JScrollPane scrollPane;
    JButton jbtBack = new JButton("Back");
    double totalPrice = 0;
    ListInterface<OrderList> cartList;
    ListInterface<Item> itemList;
    OrderInterface<Order> orderList;
    Order order;
    SelectMenuItem2 sm;

    public OrderConfirmation(ListInterface<OrderList> cartList, ListInterface<Item> itemList, Order order, OrderInterface<Order> orderList, MainForm mainform, SelectMenuItem2 sm) {
        this.cartList = cartList;
        this.itemList = itemList;
        this.orderList = orderList;
        this.order = order;
        this.mainform = mainform;
        this.sm=sm;

        String[][] data = new String[cartList.getNumberOfEntries()][3];
        for (int a = 1; a <= cartList.getNumberOfEntries(); a++) {
            for (int b = 1; b <= itemList.getNumberOfEntries(); b++) {
                if (cartList.getEntry(a).getItem_id() == itemList.getEntry(b).getItem_id()) {
                    data[a - 1][0] = itemList.getEntry(b).getItem_name();
                    data[a - 1][1] = Integer.toString(cartList.getEntry(a).getQuantity());
                    data[a - 1][2] = Double.toString(cartList.getEntry(a).getSubTotal());
                    totalPrice += cartList.getEntry(a).getSubTotal();
                    order.setTotal_amount(totalPrice);
                }
            }
        }
        table = new JTable(data, columnNames);

        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        table.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(table);
        setLayout(new GridLayout(6, 2));
        add(jlblName);
        add(new JLabel(order.getCust_name()));
        add(jlblDate);
        add(new JLabel(order.getPurchase_time()));
        add(jlblOrder);
        add(scrollPane);
        add(new JLabel("Total Amount (RM) :"));
        add(new JLabel(String.valueOf(totalPrice)));
        add(jlblAddressHeader);
        add(new JLabel(order.getCust_deliveryAddress()));
        add(jbtBack);
        add(jbConfirm);

        jbConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jbConfirm(e);
            }
        });

        jbtBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jbBack(e);
            }
        });

        setTitle("Order Confirmation");
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    private void jbConfirm(ActionEvent e) {
        // TODO add your handling code here:
        this.setVisible(false);
        Payment payment = new Payment(cartList, order, orderList, this, mainform);
    }

    private void jbBack(ActionEvent e) {
        // TODO add your handling code here:
        this.dispose();
        Cart ct = new Cart(cartList, itemList, order, orderList, mainform);
        ct.setTitle("Cart");
ct.previousFrame(sm);
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
