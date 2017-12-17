/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_C;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import entity.*;
import adt.*;
import fooddeliverysystem.MainForm;

/**
 *
 * @author Loi Kah Hou
 */
public class Cart extends JFrame {

    /*OrderList ol = new OrderList(401, 301, 201, "10", "50");
    OrderList ol1 = new OrderList(402, 301, 202, "12", "60");
    OrderList ol2 = new OrderList(403, 301, 203, "14", "70");
    OrderList ol3 = new OrderList(404, 301, 204, "16", "80");

    Item item = new Item(201, "Curry Laksa", "5", 101);
    Item item1 = new Item(202, "Curry Ayam", "5", 101);
    Item item2 = new Item(203, "Curry Ikan", "5", 101);
    Item item3 = new Item(204, "Curry Manis", "5", 101);
     */
    MainForm mainform;
    JTable table = new JTable();
    String[] columns = {"Item Name", "Quantity", "Unit Price (RM)", "Total (RM)"};
    JLabel jlblItemName = new JLabel();
    JLabel jlblQuantity = new JLabel();
    JLabel jlblAmount = new JLabel();
    JButton jbDelete = new JButton("Remove");
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane pane;
    JPanel jpane1 = new JPanel();
    JPanel jpane2 = new JPanel();
    JButton jbCheckOut = new JButton("Check Out");
    JButton jbBack = new JButton("Back to Menu");

    LList<OrderList> cartList = new LList();
    // LinkedQueue<OrderList> backupOrderListQueue = new LinkedQueue();
    // LinkedQueue<Item> backupItemQueue = new LinkedQueue();
    LList<Item> itemList = new LList();
    OrderInterface<Order> orderList;
    Order order;
    SelectMenuItem2 sm;

    public Cart(LList<OrderList> cartList, LList<Item> itemList, Order order, OrderInterface<Order> orderList,MainForm mainform) {
        this.cartList = cartList;
        this.itemList = itemList;
        this.orderList=orderList;
        this.order=order;
        this.mainform = mainform;
        /*for (int a = 1; a <= cartList.getNumberOfEntries(); a++) {
            System.out.println(cartList.getEntry(a).getItem_id());
        }*/
        setLayout(new GridLayout(2, 1));
        table = new JTable();
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        Font font = new Font("Arial", Font.PLAIN, 25);
        Font btnfont = new Font("Helvetica", Font.ITALIC, 30);
        table.setFont(font);
        table.setRowHeight(30);

        pane = new JScrollPane(table);

        //   jpane1.setSize(new Dimension(1200,500));
        //  jpane2.setPreferredSize(new Dimension(1200,100));
        pane.setPreferredSize(new Dimension(1100, 200));

        /*cartList.add(ol);
        cartList.add(ol1);
        cartList.add(ol2);
        cartList.add(ol3);
        itemList.add(item);
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);*/
        Object[] row = new Object[4];

        /* for(int a=0;a<orderListQueue.size();a++){
            orderListQueue.dequeue();
            orderListQueue.dequeue();
            System.out.println(orderListQueue.dequeue().getSubTotal());
        }*/
       
        /*for (int a = 1; a <= cartList.getNumberOfEntries(); a++) {
            for (int b = a + 1; b <= cartList.getNumberOfEntries(); b++) {
                if (cartList.getEntry(a).getItem_id() == cartList.getEntry(b).getItem_id()) {
                    cartList.getEntry(a).setQuantity(cartList.getEntry(a).getQuantity()+cartList.getEntry(b).getQuantity());
                    cartList.getEntry(a).setSubTotal(cartList.getEntry(a).getSubTotal()+cartList.getEntry(b).getQuantity());
                    cartList.remove(b);
                }
            }
        }*/  
        
        //merge order Item
        for (int a = 1; a <= cartList.getNumberOfEntries(); a++) {
            for (int b = 1; b <= itemList.getNumberOfEntries(); b++) {
                if (cartList.getEntry(a).getItem_id() == itemList.getEntry(b).getItem_id()) {
                    row[0] = itemList.getEntry(b).getItem_name();
                    row[1] = cartList.getEntry(a).getQuantity();
                    row[2] = itemList.getEntry(b).getItem_price();
                    row[3] = cartList.getEntry(a).getSubTotal();
                }
            }
            model.addRow(row);
        }

        jbDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtDelete(evt);
            }
        });

        jbCheckOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtCheckOut(evt);
            }
        });
        jbBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtBack(evt);
            }
        });
        

        jpane1.add(pane);
        jpane2.add(jbBack);
        jpane2.add(jbDelete);
        jpane2.add(jbCheckOut);
        add(jpane1);
        add(jpane2);

        setTitle("Cart");
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void jbtDelete(ActionEvent evt) {
        int a = table.getSelectedRow();

        if (a >= 0) {
            model.removeRow(a);
            cartList.remove(a + 1);
        } else {
            JOptionPane.showMessageDialog(null, "No more record!!!");
            //System.out.println(a);

        }
    }

    private void jbtCheckOut(ActionEvent evt) {
        this.dispose();
        OrderConfirmation oc = new OrderConfirmation(cartList,itemList,order,orderList,mainform,sm);
        oc.setTitle("Cart");
        oc.setSize(1200, 600);
        oc.setLocationRelativeTo(null);
        oc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oc.setVisible(true);
    }
    private void jbtBack(ActionEvent evt) {
        this.dispose();
        sm.setVisible(true);
    }

    
    public void previousFrame(SelectMenuItem2 sm){
        this.sm=sm;
    }
    /*  public static void main(String[] args) {
        Cart cart = new Cart();
        cart.setTitle("Cart");
        cart.setSize(1200, 600);
        cart.setLocationRelativeTo(null);
        cart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cart.setVisible(true);
    }*/
}
