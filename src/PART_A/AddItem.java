/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_A;
import adt.AffiliateADT;
import adt.*;
import entity.*;
import fooddeliverysystem.MainForm;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;


public class AddItem extends JFrame {
    
    
    
    
    /*Affiliate restA=new Affiliate(0000,"Rest A","Rest A address","Ali","0111111111","Zone A","123456789");
    Affiliate restB=new Affiliate(0001,"Rest B","Rest B address","Bli","0111111111","Zone B","123456789");
    LList<Item> item=new LList<Item>(); 
    LList<Item> Bitem=new LList<Item>(); 
    
    
    Item itemA=new Item(6001,"Curry Chicken",12.30,0000,"Curry Chicken taste good");
    Item itemB=new Item(6002,"Curry Fish",12.30,0000,"Curry Fish taste good");
    Item itemC=new Item(6003,"Curry Duck",12.30,0000,"Curry Duck taste good");
    Item BitemA=new Item(6001,"Curry BChicken",12.30,0001,"Curry Chicken taste good");
    Item BitemB=new Item(6002,"Curry BFish",12.30,0001,"Curry Fish taste good");
    Item BitemC=new Item(6003,"Curry BDuck",12.30,0001,"Curry Duck taste good");*/
    //LList<Item> EmptyItem=new LList<Item>();
    //Item emptyItem = new Item(0,"empty",0,0,"empty");
    Item newItem;
    int ID;
    AddItem AI;
    JTextField jtfName = new JTextField();
    JTextField jtfPrice = new JTextField();
    JTextField jtfDescription = new JTextField();
    MainForm Mainform;
    public AddItem(int CurrentID,MainForm mainform){
        /*item.add(itemA);
        item.add(itemB);
        item.add(itemC);*/
        //EmptyItem.add(emptyItem);
        Mainform=mainform;
        ID=CurrentID;
        AI=this;
        /*restA.setItemList(EmptyItem);
        affiliate.add(restA);
        Bitem.add(BitemA);
        Bitem.add(BitemB);
        Bitem.add(BitemC);
        restB.setItemList(Bitem);
        affiliate.add(restB);*/
        
        JLabel jlblName = new JLabel("Name :");
        JLabel jlblPrice = new JLabel("Price (RM) :");
        JLabel jlblDescription = new JLabel("Description");
        JButton btnBack = new JButton("Back");
        JButton jbtnReset = new JButton("Reset");
        JButton jbtnSave = new JButton("Save Item");
        JButton jbtnBack = new JButton("Back");
        JPanel panel=new JPanel();
        setLayout(new GridLayout(5, 2)); 
        jbtnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SaveItem(evt);
            }
        });
        jbtnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Reset(evt);
            }
        });
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AffMainMenu AFF=new AffMainMenu(ID,Mainform);
                    AFF.setVisible(true);
                    AFF.setLocationRelativeTo(null);
                    AI.setVisible(false);
            }
        });
        
        add(jlblName);
        add(jtfName);
        add(jlblPrice);
        add(jtfPrice);
        add(jlblDescription);
        add(jtfDescription);
        add(btnBack);
        add(jbtnSave);
        add(jbtnReset);
        setTitle("AddItem");
        setSize(500, 250);  
        setLocationRelativeTo(null);   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setVisible(true);
       /* addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(AI,
                        "Return to Main Menu?", "Really Closing?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    
                    AffMainMenu AFF=new AffMainMenu(ID,aff);
                    AFF.setVisible(true);
                    AFF.setLocationRelativeTo(null);
                    AI.setVisible(false);
                }
            }
        });*/
        
        
    }
    
    private void SaveItem(ActionEvent evt) {
        int newID=0;
        if(jtfName.getText().isEmpty()||jtfPrice.getText().isEmpty()||jtfDescription.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
            return;
        }else{
            try{
                 double value = Double.parseDouble(jtfPrice.getText());
                 double answer = value * 9 / 5 + 35;
                     }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Price must be numeric!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
            }
        
            for(int i=1;i<Mainform.aff.getNumberOfEntries()+1;i++){
                     if(Mainform.aff.getEntry(i).getAffiliate_id()==ID){
                         
                         if(Mainform.aff.getEntry(i).getItemList().getNumberOfEntries()!=0){
                            for(int o=1;o<Mainform.aff.getEntry(i).getItemList().getNumberOfEntries()+1;o++){
                                if(Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_id()>newID){
                                    newID=Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_id();
                                }
                                 if(Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_name().equals(jtfName.getText())){
                                    JOptionPane.showMessageDialog(null, "Item Name Used!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }else if(Mainform.aff.getEntry(i).getItemList().getEntry(1).getItem_name().equals("empty")){
                                    newItem = new Item(201,jtfName.getText(),Double.parseDouble(jtfPrice.getText()),ID,jtfDescription.getText());
                                    Mainform.aff.getEntry(i).getItemList().add(1, newItem);
                                    Mainform.aff.getEntry(i).getItemList().remove(2);
                                    JOptionPane.showMessageDialog(null, "Item Added!!", "InfoBox: " + "Successful!!", JOptionPane.INFORMATION_MESSAGE);
                                             
                                    return;
                                }
                                 else{
                                     if(Mainform.aff.getEntry(i).getItemList().getNumberOfEntries()==o){
                                         newID=newID+1; 
                                         newItem = new Item(newID,jtfName.getText(),Double.parseDouble(jtfPrice.getText()),ID,jtfDescription.getText());
                                          Mainform.aff.getEntry(i).getItemList().add(newItem);
                                                 JOptionPane.showMessageDialog(null, "Item Added!!", "InfoBox: " + "Successful!!", JOptionPane.INFORMATION_MESSAGE);
                                                 
                                                 return;
                                             }   
                                         }
                                     }
                                    }
                         else{
                             newItem = new Item(201,jtfName.getText(),Double.parseDouble(jtfPrice.getText()),ID,jtfDescription.getText());
                             Mainform.aff.getEntry(i).getItemList().add(newItem);
                             JOptionPane.showMessageDialog(null, "Item Added!!", "InfoBox: " + "Successful!!", JOptionPane.INFORMATION_MESSAGE);
                             return;
                         
                         }
                                 }
                            } 
            
    }
    private void Reset(ActionEvent evt) {
        jtfName.setText("");
        jtfPrice.setText("");
        jtfDescription.setText("");
    }
    
    
    public static void main(String[] args) {
        
        
        
    }
}
