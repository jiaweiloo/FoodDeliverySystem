/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_A;

import javax.swing.JFrame;
import entity.*;
import adt.*;
import fooddeliverysystem.MainForm;
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

    int currentID ;
    MainForm Mainform;
    UpdateItemDetail UI;
    /*Affiliate restA = new Affiliate(0000, "Rest A", "Rest A address", "Ali", "0111111111", "Zone A", "123456789");
    Affiliate restB = new Affiliate(0001, "Rest B", "Rest B address", "Bli", "0111111111", "Zone B", "123456789");
    LList<Item> item = new LList<Item>();
    LList<Item> Bitem = new LList<Item>();
    Item itemA = new Item(6001, "Curry Chicken", 12.30, 0000, "Curry Chicken taste good");
    Item itemB = new Item(6002, "Curry Fish", 12.30, 0000, "Curry Fish taste good");
    Item itemC = new Item(6003, "Curry Duck", 12.30, 0000, "Curry Duck taste good");
    Item BitemA = new Item(6001, "Curry BChicken", 12.30, 0001, "Curry Chicken taste good");
    Item BitemB = new Item(6002, "Curry BFish", 12.30, 0001, "Curry Fish taste good");
    Item BitemC = new Item(6003, "Curry BDuck", 12.30, 0001, "Curry Duck taste good");*/
    Font font = new Font("SansSerif",Font.PLAIN,14);
    Item newItem;
    JLabel lblEmpty = new JLabel("");
    JLabel lblEmpty1 = new JLabel("");
    JLabel lblID = new JLabel("ID");
    JLabel lblName = new JLabel("Name");
    JLabel lblPrice = new JLabel("Price(RM)");
    JLabel lblDesc = new JLabel("Description");
    JLabel lblSeason = new JLabel("Season");
    JPanel jpInfo = new JPanel();
    JLabel lblSelectedID = new JLabel();
    JTextField jtfNewName = new JTextField();
    JTextField jtfNewPrice = new JTextField();
    JTextField jtfNewDesc = new JTextField();
    JLabel lblSID = new JLabel("Selected ID");
        JLabel lblSName = new JLabel("Selected Name");
        JLabel lblSPrice = new JLabel("Selected Price");
        JLabel lblSDesc = new JLabel("Selected Desc");
        JLabel lblSSeason = new JLabel("Season");
        JButton btnUpdate = new JButton("Update");
        JButton btnBack = new JButton("Back");
        String[] seasonStr = new String[]{"Spring","Summer","Autumn","Winter"};
    JComboBox season_ddl = new JComboBox(seasonStr);
    String name;
    String Sea;
    double price;
    String desc;
    int id;

    public UpdateItemDetail(int CurrentID,MainForm mainform) {
        currentID=CurrentID;
        Mainform=mainform;
        UI=this;
        /*item.add(itemA);
        item.add(itemB);
        item.add(itemC);
        restA.setItemList(item);
        affiliate.add(restA);
        Bitem.add(BitemA);
        Bitem.add(BitemB);
        Bitem.add(BitemC);
        restB.setItemList(Bitem);
        affiliate.add(restB);*/

        lblID.setForeground(Color.MAGENTA);
        lblName.setForeground(Color.MAGENTA);
        lblPrice.setForeground(Color.MAGENTA);
        lblDesc.setForeground(Color.MAGENTA);
        lblSeason.setForeground(Color.MAGENTA);


        btnUpdate.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent evt) {
                            UpdateItem(evt,id,name,price,desc);
                        }
                    });
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AffMainMenu AFF=new AffMainMenu(currentID,Mainform);
                    AFF.setVisible(true);
                    AFF.setLocationRelativeTo(null);
                    UI.setVisible(false);
            }
        });
        
        season_ddl.setSelectedIndex(0);
        lblSID.setForeground(Color.BLUE);
        lblSName.setForeground(Color.BLUE);
        lblSPrice.setForeground(Color.BLUE);
        lblSDesc.setForeground(Color.BLUE);
        lblSSeason.setForeground(Color.BLUE);
        DisplayLayout();


        setTitle("Update Item");
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void DisplayLayout() {

        jpInfo.removeAll();

        for (int i = 1; i < Mainform.aff.getNumberOfEntries() + 1; i++) {
            if (Mainform.aff.getEntry(i).getAffiliate_id() == currentID) {
                jpInfo.setLayout(new GridLayout(Mainform.aff.getEntry(i).getItemList().getNumberOfEntries() + 4, 6));
            }
        }

        jpInfo.add(lblID).setFont(font);
        jpInfo.add(lblName).setFont(font);
        jpInfo.add(lblPrice).setFont(font);
        jpInfo.add(lblDesc).setFont(font);
        jpInfo.add(lblSeason).setFont(font);
        jpInfo.add(lblEmpty).setFont(font);

        for (int i = 1; i < Mainform.aff.getNumberOfEntries() + 1; i++) {
            if (Mainform.aff.getEntry(i).getAffiliate_id() == currentID) {
                for (int o = 1; o < Mainform.aff.getEntry(i).getItemList().getNumberOfEntries() + 1; o++) {
                    JButton btnSelect = new JButton("Select");
                    jpInfo.add(new JLabel(String.valueOf(Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_id()))).setFont(font);
                    jpInfo.add(new JLabel(Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_name())).setFont(font);
                    jpInfo.add(new JLabel(Double.toString(Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_price()))).setFont(font);
                    jpInfo.add(new JLabel(Mainform.aff.getEntry(i).getItemList().getEntry(o).getDesc())).setFont(font);
                    jpInfo.add(new JLabel(Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_season()));
                    jpInfo.add(btnSelect);

                    String SID =String.valueOf(Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_id());
                    String SName=Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_name();
                    String SPrice=Double.toString(Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_price());
                    String SDesc=Mainform.aff.getEntry(i).getItemList().getEntry(o).getDesc();
                    String SSea=Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_season();
                    btnSelect.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent evt) {
                            SelectItem(evt,SID,SName,SPrice,SDesc,SSea);
                        }
                    });


                }
            }
        }
        jpInfo.add(lblSID);
        jpInfo.add(lblSName);
        jpInfo.add(lblSPrice);
        jpInfo.add(lblSDesc);
        jpInfo.add(lblSSeason);
        jpInfo.add(lblEmpty1);
        jpInfo.add(lblSelectedID);
        jpInfo.add(jtfNewName);
        jpInfo.add(jtfNewPrice);
        jpInfo.add(jtfNewDesc);
        jpInfo.add(season_ddl);
        jpInfo.add(btnUpdate);
        jpInfo.add(btnBack);
        jpInfo.revalidate();
        jpInfo.repaint();
        add(jpInfo);
    }


    private void SelectItem(ActionEvent evt,String ID,String Name,String Price,String Desc,String SSea) {
        lblSelectedID.setText(ID);
        jtfNewName.setText(Name);
        jtfNewPrice.setText(Price);
        jtfNewDesc.setText(Desc);
        name=Name;
        Sea=SSea;
        price=Double.parseDouble(Price);
        id=Integer.parseInt(ID);
        desc=Desc;
        
        if(SSea=="Spring")
            season_ddl.setSelectedIndex(0);
        else if(SSea=="Summer")
            season_ddl.setSelectedIndex(1);
        else if(SSea=="Autumn")
            season_ddl.setSelectedIndex(2);
        else
            season_ddl.setSelectedIndex(3);
    }

    private void UpdateItem(ActionEvent evt,int ID,String Name,double Price,String Desc){
        String season;
        if(season_ddl.getSelectedIndex()==0)
            season="Spring";
        else if(season_ddl.getSelectedIndex()==1)
            season="Summer";
        else if(season_ddl.getSelectedIndex()==2)
            season="Autumn";
        else
            season="Winter";
        if(lblSelectedID.getText().isEmpty()||jtfNewName.getText().isEmpty()||jtfNewPrice.getText().isEmpty()||jtfNewDesc.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please select an item and enter new detail", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(lblSelectedID.getText().equals(String.valueOf(id))&&jtfNewName.getText().equals(name)&&jtfNewPrice.getText().equals(String.valueOf(price))&&jtfNewDesc.getText().equals(desc)&&season.equals(Sea)){
            JOptionPane.showMessageDialog(null, "Please key in at least one different detail", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
            return;
        }else{

            try {
                  Double.parseDouble(jtfNewPrice.getText());

                 } 

                    catch (NumberFormatException e) {
                           JOptionPane.showMessageDialog(null, "Price must be numeric!", "Error!!", JOptionPane.ERROR_MESSAGE);
                           return;
                 }

        }


            for (int i = 1; i < Mainform.aff.getNumberOfEntries() + 1; i++) {
                 if (Mainform.aff.getEntry(i).getAffiliate_id() == currentID) {
                      for (int o = 1; o < Mainform.aff.getEntry(i).getItemList().getNumberOfEntries() + 1; o++) {
                          if(id==Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_id()){
                              Mainform.aff.getEntry(i).getItemList().getEntry(o).setItem_name(jtfNewName.getText());
                              Mainform.aff.getEntry(i).getItemList().getEntry(o).setItem_price(Double.parseDouble(jtfNewPrice.getText()));
                              Mainform.aff.getEntry(i).getItemList().getEntry(o).setDesc(jtfNewDesc.getText());
                              Mainform.aff.getEntry(i).getItemList().getEntry(o).setItem_season(season);
                              JOptionPane.showMessageDialog(null, "Item Modified!!", "InfoBox: " + "Successful!!", JOptionPane.INFORMATION_MESSAGE);
                          }
                      }
                  }
            }
            lblSelectedID.setText("");
            jtfNewName.setText("");
            jtfNewPrice.setText("");
            jtfNewDesc.setText("");
            DisplayLayout();

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


    }

    }
