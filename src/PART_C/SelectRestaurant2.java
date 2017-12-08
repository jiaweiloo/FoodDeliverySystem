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
import java.awt.*;

public class SelectRestaurant2 extends JFrame {

    Affiliate aff0 = new Affiliate("R1", "Thai Boy Restaurant", "123, Jalan Genting Klang, 53300 setapak, Kuala Lumpur", "Loo Jia Wei", "0123456789", "Genting Klang");
    Affiliate aff1 = new Affiliate("R2", "Curry Chicken", "123, Jalan Genting Klang, 53300 setapak, Kuala Lumpur", "Loo Jia Wei", "0123456789", "Genting Klang");
    Affiliate aff2 = new Affiliate("R3", "The Taste", "123, Jalan Genting Klang, 53300 setapak, Kuala Lumpur", "Loo Jia Wei", "0123456789", "Genting Klang");
    Affiliate aff3 = new Affiliate("R4", "Nasi Putih", "123, Jalan Genting Klang, 53300 setapak, Kuala Lumpur", "Loo Jia Wei", "0123456789", "Genting Klang");

    LinkedQueue<Affiliate> restQueue = new LinkedQueue();
    LinkedQueue<Affiliate> backupQueue = new LinkedQueue();

    JScrollPane jScrollPane;
    JPanel jPanel;

    JButton jbtRest;

    public SelectRestaurant2() {
        restQueue.enqueue(aff0);
        restQueue.enqueue(aff1);
        restQueue.enqueue(aff2);
        restQueue.enqueue(aff3);
        
        
        setTitle("Select Restaurant");
        jPanel = new JPanel(new GridLayout(restQueue.size(), 1));
        //jScrollPane.setPreferredSize(new Dimension(1200,600));
        //jPanel.setPreferredSize(new Dimension(1200,600));
        // setLayout(new GridLayout(restQueue.size(), 1));
        for (int a = 0; a < restQueue.size(); a++) {
            Affiliate b = (Affiliate) restQueue.getFront();
            backupQueue.enqueue(restQueue.dequeue());
            jbtRest = new JButton(b.getRest_name());
            jbtRest.setPreferredSize(new Dimension(0, 100));
            jPanel.add(jbtRest);
        }
        jScrollPane = new JScrollPane(jPanel);
        add(jScrollPane);
        for(int a=0;a<backupQueue.size();a++){
            restQueue.enqueue(backupQueue.dequeue());
        }
    }

    public static void main(String[] args) {

        SelectRestaurant2 sr2 = new SelectRestaurant2();

        sr2.setSize(1200, 600);
        sr2.setLocationRelativeTo(null);
        sr2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sr2.setVisible(true);

        //Affiliate affTest = (Affiliate) restQueue.dequeue();
        //System.out.print(affTest.getAffiliate_id());
    }
}
