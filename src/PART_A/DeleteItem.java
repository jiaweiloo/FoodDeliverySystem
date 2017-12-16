/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_A;

import adt.LList;
import entity.Affiliate;
import entity.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
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
public class DeleteItem extends JFrame{
    
    
    JTextField jtfInput = new JTextField();
    int currentID = 1001;
    LList<Affiliate> affiliate=new LList<Affiliate>();
    Affiliate restA=new Affiliate(1000,"Rest A","Rest A address","Ali","0111111111","Zone A","123456789");
    Affiliate restB=new Affiliate(1001,"Rest B","Rest B address","Bli","0111111111","Zone B","123456789");
    LList<Item> item=new LList<Item>(); 
    LList<Item> Bitem=new LList<Item>(); 
    Item itemA=new Item(6001,"Curry Chicken","12.30",0000,"Curry Chicken taste good");
    Item itemB=new Item(6002,"Curry Fish","12.30",0000,"Curry Fish taste good");
    Item itemC=new Item(6003,"Curry Duck","12.30",0000,"Curry Duck taste good");
    Item BitemA=new Item(6001,"Curry BChicken","12.30",0001,"Curry Chicken taste good");
    Item BitemB=new Item(6002,"Curry BFish","12.30",0001,"Curry Fish taste good");
    Item BitemC=new Item(6003,"Curry BDuck","12.30",0001,"Curry Duck taste good");
    
    
    
    public DeleteItem(){
        
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
        
        
        JLabel lblID = new JLabel("ID");
        JLabel lblName = new JLabel("Item Name");
        JLabel lblPrice = new JLabel("Price(RM)");
        JLabel lblDesc = new JLabel("Desc");
        JButton jtbDel = new JButton("Delete");
        JLabel lblInput = new JLabel("Enter Item ID");
        
        //Calculate number of row
        for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
            if(affiliate.getEntry(i).getAffiliate_id()==currentID){
                setLayout(new GridLayout(affiliate.getEntry(i).getItemList().getNumberOfEntries()+2, 4));
            }  
        }
        
       
       jtbDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteItem(evt);
            }
        });
       
       add(lblID);
       add(lblName);
       add(lblPrice);
       add(lblDesc);
       
       //Add all Item of Rest
       for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
           if(affiliate.getEntry(i).getAffiliate_id()==currentID){
                for(int o=1;o<affiliate.getEntry(i).getItemList().getNumberOfEntries()+1;o++){
                    add(new JLabel(String.valueOf(affiliate.getEntry(i).getItemList().getEntry(o).getItem_id())));
                    add(new JLabel(affiliate.getEntry(i).getItemList().getEntry(o).getItem_name()));
                    add(new JLabel(affiliate.getEntry(i).getItemList().getEntry(o).getItem_price()));
                    add(new JLabel(affiliate.getEntry(i).getItemList().getEntry(o).getDesc()));
                 } 
            } 
        }
        add(lblInput);
        add(jtfInput);
        add(jtbDel);
        
        
        
        setTitle("Delete Item");
        setSize(500, 250);  
        setLocationRelativeTo(null);   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setVisible(true);
    }
    private void deleteItem(ActionEvent evt) {
            
            //Compare isEmpty
            if(jtfInput.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Input field cannot be empty!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //Compare invalid input
            try{
                 double value = Double.parseDouble(jtfInput.getText());
                 double answer = value * 9 / 5 + 35;
                 
                 int position=1;
                 int counter=0;
                 int input_ID=Integer.parseInt(jtfInput.getText().toString());
                 for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
                     if(currentID==affiliate.getEntry(i).getAffiliate_id()){
                         for(int o=1;o<affiliate.getEntry(i).getItemList().getNumberOfEntries()+1;o++){
                             if(affiliate.getEntry(i).getItemList().getEntry(o).getItem_id()!=input_ID){
                                 counter++; 
                                 if(counter==affiliate.getEntry(i).getItemList().getNumberOfEntries()){
                                     JOptionPane.showMessageDialog(null, "Item ID incorrect!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
                                     return;
                                 }
                             }
                         }
                     }
                 }
                 
                 //Delete item
                 for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
                     if(currentID==affiliate.getEntry(i).getAffiliate_id()){
                         for(int o=1;o<affiliate.getEntry(i).getItemList().getNumberOfEntries()+1;o++){
                             if(affiliate.getEntry(i).getItemList().getEntry(o).getItem_id()!=input_ID){
                                 position++; 
                             }else{
                                 break;
                             } 
                         }
                         affiliate.getEntry(i).getItemList().remove(position);
                     }
                 }
                 
                 JOptionPane.showMessageDialog(null, "Item Deleted!!", "InfoBox: " + "Successful!!", JOptionPane.INFORMATION_MESSAGE);
                 
               }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Invalid Input!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
                    return;
                }   
        }
    public static void main(String[] args){
        
        DeleteItem DI=new DeleteItem();
       
    }
}
