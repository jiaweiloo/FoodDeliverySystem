/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_A;

import adt.AffiliateADT;
import adt.AffiliateInterface;
import adt.LList;
import entity.Affiliate;
import entity.*;
import fooddeliverysystem.MainForm;
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
    
   
    int currentID ;
    ArrangeItem AI;
    MainForm Mainform;
   // Affiliate restA=new Affiliate(1000,"Rest A","Rest A address","Ali","0111111111","Zone A","123456789");
    JButton btnMnly = new JButton("Manually");
    JButton btnAuto = new JButton("Automatically");
    JLabel lblTitle = new JLabel("Select the way to arrange");
    JPanel P = new JPanel();
    JButton btnBack=new JButton("Back");
    JLabel lblEmpty = new JLabel("");
    JLabel lblEmpty1 = new JLabel("");
    Font FontTitle = new Font("SansSerif",Font.BOLD,30);
    public ArrangeItem(int CurrentID,MainForm mainform){
        currentID=CurrentID;
        Mainform=mainform;
        AI=this;
        //affiliate.add(restA);
        
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AffMainMenu AFF=new AffMainMenu(currentID,Mainform);
                    AFF.setVisible(true);
                    AFF.setLocationRelativeTo(null);
                    AI.setVisible(false);
            }
        });
        
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
        add(lblTitle,BorderLayout.NORTH);
        
        P.setLayout(new GridLayout(2,3));
        P.add(btnAuto);
        P.add(lblEmpty);
        P.add(btnMnly);
        P.add(lblEmpty1);
        P.add(btnBack);
        add(P);
        setTitle("Arrange Item");
        setSize(1000, 250);  
        setLocationRelativeTo(null);   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setVisible(true);
    }    
    
    private void SelAuto(ActionEvent evt) {
            
            this.dispose();
            AutoArrange AutoArrange=new AutoArrange(currentID,Mainform);
        AutoArrange.setVisible(true);
        AutoArrange.setLocationRelativeTo(null);
        this.setVisible(false);
        
        }
    
    private void SelMnly(ActionEvent evt) {
            
            this.dispose();
            MnlyArrange MnlyArrange=new MnlyArrange(currentID,Mainform);
        MnlyArrange.setVisible(true);
        MnlyArrange.setLocationRelativeTo(null);
        this.setVisible(false);
        
        }
    
    public static void main(String[] args){
        
       
    }
}
