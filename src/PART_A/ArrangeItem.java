/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_A;

import adt.LList;
import entity.Affiliate;
import entity.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mah Hong Wai
 */
public class ArrangeItem extends JFrame{
    
   
    int currentID = 1000;
    
    JButton btnMnly = new JButton("Manually");
    JButton btnAuto = new JButton("Automatically");
    JLabel lblTitle = new JLabel("Select the way to arrange");
    JPanel P = new JPanel();
    JLabel lblEmpty = new JLabel("       ");
    Font FontTitle = new Font("SansSerif",Font.BOLD,30);
    public ArrangeItem(){
        
        
        
        
        btnAuto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SelAuto(evt);
            }
        });
        
        btnMnly.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SelMnly(evt);
            }
        });
        
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(FontTitle);
        btnAuto.setFont(FontTitle);
        btnMnly.setFont(FontTitle);
        add(lblTitle);
        
        setLayout(new FlowLayout(FlowLayout.CENTER,100,20));
        add(btnAuto);
        add(btnMnly);
        setTitle("Arrange Item");
        setSize(500, 250);  
        setLocationRelativeTo(null);   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setVisible(true);
    }    
    
    private void SelAuto(ActionEvent evt) {
            
            this.dispose();
            AutoArrange AA=new AutoArrange(currentID);
        
        }
    
    private void SelMnly(ActionEvent evt) {
            
            this.dispose();
        
        }
    
    public static void main(String[] args){
        
        ArrangeItem AI=new ArrangeItem();
       
    }
}
