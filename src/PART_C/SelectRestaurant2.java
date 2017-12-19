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

    MainForm mainform;
    SelectRestaurant2 sr2;
    LinkedQueue<Affiliate> restQueue = new LinkedQueue();
    LinkedQueue<Affiliate> backupRestQueue = new LinkedQueue();
    AffiliateInterface<Affiliate> aff ;
    //LinkedQueue<Item> backupItemQueue = new LinkedQueue();
    Order order;
    OrderInterface<Order> orderList;

    JScrollPane jScrollPane;
    JPanel jPanel;

    JButton jbtRest;

    public SelectRestaurant2(Order order, OrderInterface<Order> orderList,AffiliateInterface<Affiliate> aff, MainForm mainform) {
        this.order = order;
        this.mainform = mainform;
        this.orderList = orderList;
        this.aff = aff;
        sr2=this;
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
        for (int a = 1; a <= aff.getNumberOfEntries(); a++) {
            Affiliate b = (Affiliate) aff.getEntry(a);
            if(b.getItemList().getEntry(1).getItem_id()!=0){
            jbtRest = new JButton(b.getRest_name());
            jbtRest.setPreferredSize(new Dimension(0, 100));

            jbtRest.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbtRest(e, b);
                }
            });

            jPanel.add(jbtRest);
            }
        }
        jScrollPane = new JScrollPane(jPanel);
        add(jScrollPane);
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(sr2,
                        "Return to Main Menu?", "Really Closing?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    sr2.dispose();
                    mainform.setVisible(true);
                }
            }
        });
    }

    private void jbtRest(ActionEvent e, Affiliate aff) {
        // TODO add your handling code here:
        this.dispose();
        SelectMenuItem2 menu = new SelectMenuItem2(aff, order, orderList,mainform);
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
