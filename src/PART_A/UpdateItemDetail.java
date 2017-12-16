/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_A;

import javax.swing.JFrame;
import entity.*;
import adt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Mah Hong Wai
 */
public class UpdateItemDetail extends JFrame {

    int currentID = 0000;
    int newID;
    LList<Affiliate> affiliate = new LList<Affiliate>();
    Affiliate restA = new Affiliate(0000, "Rest A", "Rest A address", "Ali", "0111111111", "Zone A", "123456789");
    Affiliate restB = new Affiliate(0001, "Rest B", "Rest B address", "Bli", "0111111111", "Zone B", "123456789");
    LList<Item> item = new LList<Item>();
    LList<Item> Bitem = new LList<Item>();
    Item itemA = new Item(6001, "Curry Chicken", 12.30, 0000, "Curry Chicken taste good");
    Item itemB = new Item(6002, "Curry Fish", 12.30, 0000, "Curry Fish taste good");
    Item itemC = new Item(6003, "Curry Duck", 12.30, 0000, "Curry Duck taste good");
    Item BitemA = new Item(6001, "Curry BChicken", 12.30, 0001, "Curry Chicken taste good");
    Item BitemB = new Item(6002, "Curry BFish", 12.30, 0001, "Curry Fish taste good");
    Item BitemC = new Item(6003, "Curry BDuck", 12.30, 0001, "Curry Duck taste good");
    Item newItem;
    JLabel lblSelectedID = new JLabel();
    JTextField jtfNewName = new JTextField();
    JTextField jtfNewPrice = new JTextField();
    JTextField jtfNewDesc = new JTextField();
    String name;
    double price;
    String desc;
    int id;

    public UpdateItemDetail() {

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

        JLabel lblEmpty = new JLabel("");
        JLabel lblEmpty1 = new JLabel("");
        JLabel lblID = new JLabel("ID");
        JLabel lblName = new JLabel("Name");
        JLabel lblPrice = new JLabel("Price(RM)");
        JLabel lblDesc = new JLabel("Description");
        JLabel lblSID = new JLabel("Selected ID");
        JLabel lblSName = new JLabel("Selected Name");
        JLabel lblSPrice = new JLabel("Selected Price");
        JLabel lblSDesc = new JLabel("Selected Desc");
        
        JButton btnUpdate = new JButton("Update");
        
        try{
                 for (int i = 1; i < affiliate.getNumberOfEntries() + 1; i++) {
            if (affiliate.getEntry(i).getAffiliate_id() == currentID) {
                if(affiliate.getEntry(i).getItemList().isEmpty()){
                    
                    
                }
            }
        }
                 
            }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "No Item", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                
            
        
        

        //Calculate number of row
        for (int i = 1; i < affiliate.getNumberOfEntries() + 1; i++) {
            if (affiliate.getEntry(i).getAffiliate_id() == currentID) {
                setLayout(new GridLayout(affiliate.getEntry(i).getItemList().getNumberOfEntries() + 3, 5));
            }
        }
        lblID.setForeground(Color.MAGENTA);
        lblName.setForeground(Color.MAGENTA);
        lblPrice.setForeground(Color.MAGENTA);
        lblDesc.setForeground(Color.MAGENTA);
        add(lblID);
        add(lblName);
        add(lblPrice);
        add(lblDesc);
        add(lblEmpty);

        for (int i = 1; i < affiliate.getNumberOfEntries() + 1; i++) {
            if (affiliate.getEntry(i).getAffiliate_id() == currentID) {
                for (int o = 1; o < affiliate.getEntry(i).getItemList().getNumberOfEntries() + 1; o++) {
                    JButton btnSelect = new JButton("Select");
                    add(new JLabel(String.valueOf(affiliate.getEntry(i).getItemList().getEntry(o).getItem_id())));
                    add(new JLabel(affiliate.getEntry(i).getItemList().getEntry(o).getItem_name()));
                    add(new JLabel(Double.toString(affiliate.getEntry(i).getItemList().getEntry(o).getItem_price())));
                    add(new JLabel(affiliate.getEntry(i).getItemList().getEntry(o).getDesc()));
                    
                    add(btnSelect);
                    
                    String SID =String.valueOf(affiliate.getEntry(i).getItemList().getEntry(o).getItem_id());
                    String SName=affiliate.getEntry(i).getItemList().getEntry(o).getItem_name();
                    String SPrice=Double.toString(affiliate.getEntry(i).getItemList().getEntry(o).getItem_price());
                    String SDesc=affiliate.getEntry(i).getItemList().getEntry(o).getDesc();
                    btnSelect.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent evt) {
                            SelectItem(evt,SID,SName,SPrice,SDesc);
                        }
                    });
                    
                    
                }
            }
        }
        
        
        btnUpdate.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent evt) {
                            UpdateItem(evt,id,name,price,desc);
                        }
                    });
        lblSID.setForeground(Color.BLUE);
        lblSName.setForeground(Color.BLUE);
        lblSPrice.setForeground(Color.BLUE);
        lblSDesc.setForeground(Color.BLUE);
        add(lblSID);
        add(lblSName);
        add(lblSPrice);
        add(lblSDesc);
        add(lblEmpty1);
        add(lblSelectedID);
        add(jtfNewName);
        add(jtfNewPrice);
        add(jtfNewDesc);
        add(btnUpdate);

        setTitle("Update Item");
        setSize(800, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void SelectItem(ActionEvent evt,String ID,String Name,String Price,String Desc) {
        lblSelectedID.setText(ID);
        jtfNewName.setText(Name);
        jtfNewPrice.setText(Price);
        jtfNewDesc.setText(Desc);
        name=Name;
        price=Double.parseDouble(Price);
        id=Integer.parseInt(ID);
        desc=Desc;
        
    }
    
    private void UpdateItem(ActionEvent evt,int ID,String Name,double Price,String Desc){
        if(lblSelectedID.getText().isEmpty()||jtfNewName.getText().isEmpty()||jtfNewPrice.getText().isEmpty()||jtfNewDesc.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please select an item and enter new detail", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(lblSelectedID.getText().equals(String.valueOf(id))&&jtfNewName.getText().equals(name)&&jtfNewPrice.getText().equals(String.valueOf(price))&&jtfNewDesc.getText().equals(desc)){
            JOptionPane.showMessageDialog(null, "Please key in at least one different detail", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
            for (int i = 1; i < affiliate.getNumberOfEntries() + 1; i++) {
                 if (affiliate.getEntry(i).getAffiliate_id() == currentID) {
                      for (int o = 1; o < affiliate.getEntry(i).getItemList().getNumberOfEntries() + 1; o++) {
                          if(id==affiliate.getEntry(i).getItemList().getEntry(o).getItem_id()){
                              affiliate.getEntry(i).getItemList().getEntry(o).setItem_name(jtfNewName.getText());
                              affiliate.getEntry(i).getItemList().getEntry(o).setItem_price(Double.parseDouble(jtfNewPrice.getText()));
                              affiliate.getEntry(i).getItemList().getEntry(o).setDesc(jtfNewDesc.getText());
                              JOptionPane.showMessageDialog(null, "Item Modified!!", "InfoBox: " + "Successful!!", JOptionPane.INFORMATION_MESSAGE);
                          }
                      }
                  }
            }
            
            
            /*for (int i = 1; i < affiliate.getNumberOfEntries() + 1; i++) {
                 if (affiliate.getEntry(i).getAffiliate_id() == currentID) {
                      for (int o = 1; o < affiliate.getEntry(i).getItemList().getNumberOfEntries() + 1; o++) {
                          System.out.print(affiliate.getEntry(i).getItemList().getEntry(o).getItem_id()+" ");
                          System.out.print(affiliate.getEntry(i).getItemList().getEntry(o).getItem_name()+" ");
                          System.out.print(affiliate.getEntry(i).getItemList().getEntry(o).getItem_price()+" ");
                          System.out.println(affiliate.getEntry(i).getItemList().getEntry(o).getDesc());
                          }
                      }
                  }*/
            }
            
        public static void main(String[] args) {

        UpdateItemDetail Update = new UpdateItemDetail();

    }
        
    }

    
    

