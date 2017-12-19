/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_C;

import javax.swing.*;
import adt.*;
import entity.*;
import fooddeliverysystem.MainForm;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Loi Kah Hou
 */
public class SelectMenuItem2 extends JFrame {

    MainForm mainform;
    JScrollPane jScrollPane;
    JPanel jPanel;
    LList<OrderList> cartList = new LList();
    OrderInterface<Order> orderList;
    Order order;
    OrderList ol;
    ListInterface<Item> itemList;
    JButton cart = new JButton("Go to Cart");
    SelectMenuItem2 sm2;

    // JLabel jlblItem;
    //JLabel jlblPrice;
    //JButton jbtAdd = new JButton("Add");
    //Customer cust = new Customer(001, "Loi Kah Hou", "lkh@mail.com", "abc123", "0123456789", "123, Condo Satu, Jalan Dua, 53300 Setapak, KL", 0);
    public SelectMenuItem2(Affiliate aff, Order order, OrderInterface<Order> orderList, MainForm mainform) {
        this.order = order;
        this.orderList = orderList;
        this.mainform = mainform;
        sm2 = this;
        //order.setOrder_id(301);
        order.setRestaurant_id(aff.getAffiliate_id());
        //order.setCust(cust);
        order.setOrderDate(new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
        order.setPurchase_time(new SimpleDateFormat("HH:mm:ss").format(new Date()));

        itemList = aff.getItemList();
        setTitle("Select Food");
        jPanel = new JPanel(new GridLayout(itemList.getNumberOfEntries(), 1));

        for (int a = 1; a <= itemList.getNumberOfEntries(); a++) {
            Item tempItem = itemList.getEntry(a);
            SpinnerNumberModel m_numberSpinnerModel;
            m_numberSpinnerModel = new SpinnerNumberModel(0, 0, 10, 1);
            JSpinner jsQuantity;
            JPanel loopJPanel = new JPanel(new GridLayout(4, 1));
            loopJPanel.setPreferredSize(new Dimension(600, 200));
            jsQuantity = new JSpinner(m_numberSpinnerModel);
            loopJPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            JButton jbtAdd = new JButton("Add");

            loopJPanel.add(new JLabel(tempItem.getItem_name()));
            loopJPanel.add(new JLabel("Price : " + tempItem.getItem_price()));
            loopJPanel.add(jsQuantity);
            loopJPanel.add(jbtAdd);
            jbtAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if ((Integer) jsQuantity.getValue() != 0) {
                        int count = 0;
                        ol = new OrderList(cartList.getNumberOfEntries() + 401, order.getOrder_id(), tempItem.getItem_id(), (int) jsQuantity.getValue(), (int) jsQuantity.getValue() * tempItem.getItem_price());

                        if (cartList.getNumberOfEntries() != 0) {
                            for (int a = 1; a <= cartList.getNumberOfEntries(); a++) {
                                if (tempItem.getItem_id() == cartList.getEntry(a).getItem_id()) {
                                    count++;
                                }
                            }

                            if (count > 0) {
                                for (int a = 1; a <= cartList.getNumberOfEntries(); a++) {
                                    if (cartList.getEntry(a).getItem_id() == tempItem.getItem_id()) {
                                        ol.setQuantity((int) jsQuantity.getValue() + cartList.getEntry(a).getQuantity());
                                        ol.setSubTotal(ol.getQuantity() * tempItem.getItem_price());
                                        cartList.replace(a, ol);
                                    }
                                }
                            } else {
                                cartList.add(ol);
                            }

                        } else {
                            cartList.add(ol);
                        }

                        JOptionPane.showMessageDialog(null, "Item is added to cart");
                    } else {
                        JOptionPane.showMessageDialog(null, "Quantity cannot be 0");
                    }
                }
            }
            );

            jPanel.add(loopJPanel);
        }
        cart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Cart ct = new Cart(cartList, itemList, order, orderList, mainform);
                ct.previousFrame(sm2);
            }
        });
        jPanel.add(cart);
        jScrollPane = new JScrollPane(jPanel);
        add(jScrollPane);

        setVisible(true);
        setTitle("Menu");
        setSize(1300, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(sm2,
                        "Return to Main Menu?", "Really Closing?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    sm2.dispose();
                    mainform.setVisible(true);
                }
            }
        });
    }

    /*private void jbtAdd(ActionEvent e) {
        // TODO add your handling code here:
        this.dispose();
        SelectMenuItem2 menu = new SelectMenuItem2(aff);
    }*/
}
