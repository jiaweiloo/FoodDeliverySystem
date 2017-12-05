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

/**
 *
 * @author Loi Kah Hou
 */
public class Cart extends JFrame {

    Order order = new Order();
    String[][] orderItem = order.getOrderItem();
    JTable table = new JTable();
    String[] columns = {"Item Name", "Quantity", "Amount (RM)"};
    JLabel jlblItemName = new JLabel();
    JLabel jlblQuantity = new JLabel();
    JLabel jlblAmount = new JLabel();
    JButton jbDelete = new JButton("Remove");
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane pane;
    JPanel jpane1 = new JPanel();
    JPanel jpane2 = new JPanel();
    JButton jbCheckOut = new JButton("Check Out");

    public Cart() {
        setLayout(new GridLayout(2, 1));
        table = new JTable();
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.pink);
        table.setForeground(Color.WHITE);
        Font font = new Font("Arial", Font.PLAIN, 25);
        Font btnfont = new Font("Helvetica", Font.ITALIC, 30);
        table.setFont(font);
        table.setRowHeight(30);

        pane = new JScrollPane(table);
        
     //   jpane1.setSize(new Dimension(1200,500));
      //  jpane2.setPreferredSize(new Dimension(1200,100));
        pane.setPreferredSize(new Dimension(1100,200));

        Object[] row = new Object[3];
        for (int i = 0; i < orderItem.length; i++) {
            row[0] = orderItem[i][0];
            row[1] = orderItem[i][1];
            row[2] = orderItem[i][2];
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

        jpane1.add(pane);
        jpane2.add(jbDelete);
        jpane2.add(jbCheckOut);
        add(jpane1);
        add(jpane2);

    }

    private void jbtDelete(ActionEvent evt) {
        int a = table.getSelectedRow();

        if (a >= 0) {
            model.removeRow(a);
            String[][] newOrderItem = order.getTableData(table);
        } else {
            JOptionPane.showMessageDialog(null, "No more record!!!");
            //System.out.println(a);

        }
    }

    private void jbtCheckOut(ActionEvent evt) {
        this.setVisible(false);
        OrderConfirmation oc = new OrderConfirmation();
        oc.setTitle("Cart");
        oc.setSize(800, 500);
        oc.setLocationRelativeTo(null);
        oc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oc.setVisible(true);
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.setTitle("Cart");
        cart.setSize(1200, 600);
        cart.setLocationRelativeTo(null);
        cart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cart.setVisible(true);
    }
}
