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
import javax.swing.*;
import adt.*;
import entity.*;
import fooddeliverysystem.MainForm;
import java.awt.*;
import java.awt.event.*;

public class SelectRestaurant2 extends JFrame {

    Item item0 = new Item(201, "Curry Laksa", 5, 101, "asdasd");
    Item item1 = new Item(202, "Curry Ayam", 5, 101, "asdasd");
    Item item2 = new Item(203, "Curry Ikan", 5, 101, "asdasd");
    Item item3 = new Item(204, "Curry Babi", 5, 102, "asdasd");
    Item item4 = new Item(205, "Curry Kosong", 5, 102, "asdasd");
    Item item5 = new Item(206, "Curry Manis", 5, 102, "asdasd");

    /* Affiliate aff0 = new Affiliate(101, "Thai Boy Restaurant", "123, Jalan Genting Klang, 53300 setapak, Kuala Lumpur", "Loo Jia Wei", "0123456789", "Genting Klang");
    Affiliate aff1 = new Affiliate(102, "Curry Chicken", "123, Jalan Genting Klang, 53300 setapak, Kuala Lumpur", "Loo Jia Wei", "0123456789", "Genting Klang");
    Affiliate aff2 = new Affiliate(103, "The Taste", "123, Jalan Genting Klang, 53300 setapak, Kuala Lumpur", "Loo Jia Wei", "0123456789", "Genting Klang");
    Affiliate aff3 = new Affiliate(104, "Nasi Putih", "123, Jalan Genting Klang, 53300 setapak, Kuala Lumpur", "Loo Jia Wei", "0123456789", "Genting Klang");
     */
    MainForm mainform;
    LinkedQueue<Affiliate> restQueue = new LinkedQueue();
    LinkedQueue<Affiliate> backupRestQueue = new LinkedQueue();
    LList<Item> itemList = new LList();
    LList<Item> itemList2 = new LList();
    //LinkedQueue<Item> backupItemQueue = new LinkedQueue();
    Order order;
    OrderInterface<Order> orderList;

    JScrollPane jScrollPane;
    JPanel jPanel;

    JButton jbtRest;

    public SelectRestaurant2(Order order, OrderInterface<Order> orderList) {
        this.order = order;
        this.orderList = orderList;
        itemList.add(item0);
        itemList.add(item1);
        itemList.add(item2);
        itemList2.add(item3);
        itemList2.add(item4);
        itemList2.add(item5);

        /*aff0.setItemList(itemList);
        aff1.setItemList(itemList2);
        
        restQueue.enqueue(aff0);
        restQueue.enqueue(aff1);
        restQueue.enqueue(aff2);
        restQueue.enqueue(aff3);*/
 /*System.out.println(restQueue.size());
        for(int a=0;a<restQueue.size();a++){
        System.out.println(restQueue.dequeue().getAffiliate_id());
        a--;
        }*/
        setTitle("Select Restaurant");
        jPanel = new JPanel(new GridLayout(restQueue.size(), 1));
        //jScrollPane.setPreferredSize(new Dimension(1200,600));
        //jPanel.setPreferredSize(new Dimension(1200,600));
        // setLayout(new GridLayout(restQueue.size(), 1));
        for (int a = 0; a < restQueue.size(); a++) {
            Affiliate b = (Affiliate) restQueue.getFront();
            jbtRest = new JButton(b.getRest_name());
            jbtRest.setPreferredSize(new Dimension(0, 100));

            jbtRest.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbtRest(e, b);
                }
            });

            jPanel.add(jbtRest);
            backupRestQueue.enqueue(restQueue.dequeue());
            a--;
        }
        jScrollPane = new JScrollPane(jPanel);
        add(jScrollPane);
        for (int a = 0; a < backupRestQueue.size(); a++) {
            restQueue.enqueue(backupRestQueue.dequeue());
        }
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void jbtRest(ActionEvent e, Affiliate aff) {
        // TODO add your handling code here:
        this.dispose();
        SelectMenuItem2 menu = new SelectMenuItem2(aff, order, orderList);
    }
    public static void main(String[] args) {
        /*
        SelectRestaurant2 sr2 = new SelectRestaurant2();

        sr2.setSize(1200, 600);
        sr2.setLocationRelativeTo(null);
        sr2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sr2.setVisible(true);*/

        //Affiliate affTest = (Affiliate) restQueue.dequeue();
        //System.out.print(affTest.getAffiliate_id());
    }
}
