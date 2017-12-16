/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_A;
import adt.LList;
import entity.*;
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
    
    int a=3;
    int currentID = 0000;
    int newID;
    LList<Affiliate> affiliate=new LList<Affiliate>();
    Affiliate restA=new Affiliate(0000,"Rest A","Rest A address","Ali","0111111111","Zone A","123456789");
    Affiliate restB=new Affiliate(0001,"Rest B","Rest B address","Bli","0111111111","Zone B","123456789");
    LList<Item> item=new LList<Item>(); 
    LList<Item> Bitem=new LList<Item>(); 
    Item itemA=new Item(6001,"Curry Chicken","12.30",0000,"Curry Chicken taste good");
    Item itemB=new Item(6002,"Curry Fish","12.30",0000,"Curry Fish taste good");
    Item itemC=new Item(6003,"Curry Duck","12.30",0000,"Curry Duck taste good");
    Item BitemA=new Item(6001,"Curry BChicken","12.30",0001,"Curry Chicken taste good");
    Item BitemB=new Item(6002,"Curry BFish","12.30",0001,"Curry Fish taste good");
    Item BitemC=new Item(6003,"Curry BDuck","12.30",0001,"Curry Duck taste good");
    Item newItem;
    
    JTextField jtfName = new JTextField();
    JTextField jtfPrice = new JTextField();
    JTextField jtfDescription = new JTextField();
    public AddItem(){
        item.add(itemA);
        item.add(itemB);
        item.add(itemC);
        restA.setItemList(item);
        affiliate.add(restA);
        Bitem.add(BitemA);
        Bitem.add(BitemB);
        Bitem.add(BitemC);
        restB.setItemList(Bitem);
        affiliate.add(restB);
        
        JLabel jlblName = new JLabel("Name :");
        JLabel jlblPrice = new JLabel("Price (RM) :");
        JLabel jlblDescription = new JLabel("Description");
        
        JButton jbtnReset = new JButton("Reset");
        JButton jbtnSave = new JButton("Save Item");
        JButton jbtnBack = new JButton("Back");
        JPanel panel=new JPanel();
        setLayout(new GridLayout(4, 2)); 
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
        for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
            for(int o=1;o<affiliate.getEntry(i).getItemList().getNumberOfEntries()+1;o++){
                
            }  
        }
        add(jlblName);
        add(jtfName);
        add(jlblPrice);
        add(jtfPrice);
        add(jlblDescription);
        add(jtfDescription);
        add(jbtnSave);
        add(jbtnReset);
        setTitle("AddItem");
        setSize(500, 250);  
        setLocationRelativeTo(null);   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setVisible(true);
        
        
    }
    
    private void SaveItem(ActionEvent evt) {
        if(jtfName.getText().isEmpty()||jtfPrice.getText().isEmpty()||jtfDescription.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
        }else{
            try{
                 double value = Double.parseDouble(jtfPrice.getText());
                 double answer = value * 9 / 5 + 35;
                 for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
                       for(int o=1;o<affiliate.getEntry(i).getItemList().getNumberOfEntries()+1;o++){
                           if(affiliate.getEntry(i).getItemList().getEntry(o).getItem_name().equals(jtfName.getText())&&
                                                 affiliate.getEntry(i).getItemList().getEntry(o).getRest_id()==currentID){
                           
                               JOptionPane.showMessageDialog(null, "Item Name Used!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
                               return;
                           }
                       }
                 }
                 for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
                     if(affiliate.getEntry(i).getAffiliate_id()==currentID){
                         newID=affiliate.getEntry(i).getItemList().getEntry(affiliate.getEntry(i).getItemList().getNumberOfEntries()).getItem_id()+1;
                     }
                 }
                 newItem = new Item(newID,jtfName.getText(),jtfPrice.getText(),currentID,jtfDescription.getText());
                 for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
                     if(affiliate.getEntry(i).getAffiliate_id()==currentID){
                         affiliate.getEntry(i).getItemList().add(newItem);
                     } 
                 }
                
                 JOptionPane.showMessageDialog(null, "Item Added!!", "InfoBox: " + "Successful!!", JOptionPane.INFORMATION_MESSAGE);
                 
            }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Price must be numeric!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        

    }
    private void Reset(ActionEvent evt) {
        jtfName.setText("");
        jtfPrice.setText("");
        jtfDescription.setText("");
    }
    
    public static void main(String[] args) {
        
        AddItem AddItem = new AddItem();
        
    }
}
