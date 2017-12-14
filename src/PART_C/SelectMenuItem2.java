/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_C;

import javax.swing.*;
import adt.*;
import entity.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Loi Kah Hou
 */
public class SelectMenuItem2 extends JFrame {

    JScrollPane jScrollPane;
    JPanel jPanel;
    LList<OrderList> orderList = new LList();
    Order order = new Order();
    OrderList ol;
    LList<Item> itemList;
    JButton cart = new JButton("Go to Cart");
    
    // JLabel jlblItem;
    //JLabel jlblPrice;
    //JButton jbtAdd = new JButton("Add");
    Customer cust = new Customer(001, "Loi Kah Hou", "lkh@mail.com", "abc123", "0123456789", "123, Condo Satu, Jalan Dua, 53300 Setapak, KL", 0);

    public SelectMenuItem2(Affiliate aff) {

        order.setOrder_id(301);
        order.setRestaurant_id(aff.getAffiliate_id());
        //order.setCust(cust);
        order.setOrderDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));

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
                        ol = new OrderList(orderList.getNumberOfEntries() + 401, 301, tempItem.getItem_id(), String.valueOf(jsQuantity.getValue()), Integer.toString((Integer) jsQuantity.getValue() * Integer.parseInt(tempItem.getItem_price())));
                        orderList.add(ol);
                        //Cart ct = new Cart(orderList,itemList,order);
                        JOptionPane.showMessageDialog(null, "Item is added to cart");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Quantity cannot be 0");
                    }
                }
            });
            
            
            
            jPanel.add(loopJPanel);
        }
        cart.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Cart ct = new Cart(orderList,itemList,order);
                }
            });
        jPanel.add(cart);
        jScrollPane = new JScrollPane(jPanel);
        add(jScrollPane);

        setVisible(true);
        setTitle("Menu");
        setSize(1300, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /*private void jbtAdd(ActionEvent e) {
        // TODO add your handling code here:
        this.dispose();
        SelectMenuItem2 menu = new SelectMenuItem2(aff);
    }*/
}
