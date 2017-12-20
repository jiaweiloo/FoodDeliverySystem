/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_A;

import adt.LList;
import adt.*;
import entity.*;
import entity.Item;
import fooddeliverysystem.MainForm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Mah Hong Wai
 */
public class AutoArrange extends JFrame{
    
    
    
    
    /*ListInterface<Affiliate> affiliate=new LList<Affiliate>();
    Affiliate restA=new Affiliate(1000,"Rest A","Rest A address","Ali","0111111111","Zone A","123456789");
    Affiliate restB=new Affiliate(1001,"Rest B","Rest B address","Bli","0111111111","Zone B","123456789");
    ListInterface<Item> item=new LList<Item>(); 
    ListInterface<Item> Bitem=new LList<Item>();*/
    
    
    public tempOrderInterface<tempItem> tempOrder=new tempOrderADT<tempItem>();
    public tempOrderInterface<tempItem> tempOrder1=new tempOrderADT<tempItem>();
    /*Item itemA=new Item(6001,"Curry Chicken",12.30,1000,"Curry Chicken taste good");
    Item itemB=new Item(6002,"Curry Fish",12.30,1000,"Curry Fish taste good");
    Item itemC=new Item(6003,"Curry Duck",12.30,1000,"Curry Duck taste good");
    Item BitemA=new Item(6001,"g",10.30,1001,"Curry Chicken taste good");
    Item BitemB=new Item(6002,"e",12.30,1001,"Curry Fish taste good");
    Item BitemC=new Item(6003,"f",25.30,1001,"Curry Duck taste good");
    Item BitemD=new Item(6003,"e",58.30,1001,"Curry Duck taste good");
    Item BitemE=new Item(6003,"b",7.30,1001,"Curry Duck taste good");
    Item BitemF=new Item(6003,"f",11.30,1001,"Curry Duck taste good");*/
    JLabel lblTitle=new JLabel("Current Arrange Order");
    Font FontTitle = new Font("SansSerif",Font.BOLD,24);
    Font font = new Font("SansSerif",Font.PLAIN,14);
    JPanel P=new JPanel();
    JLabel lblID = new JLabel("ID");
        JLabel lblName = new JLabel("Item Name");
        JLabel lblPrice = new JLabel("Price(RM)");
        JLabel lblDesc = new JLabel("Desc");
        JLabel lblSeason = new JLabel("Season");
        JButton btnRef = new JButton("Refresh");
        JButton btnCon = new JButton("Confirm");
        JButton btnBack = new JButton("Back");
    MainForm Mainform;
    String[] ArrOrder = new String[]{"A to Z(First Alphabet)","Z to A(First Alphabet)","Price(Highest to Lowest)","Price(Lowest to Highest)","Spring","Summer","Autumn","Winter"};
    AutoArrange AA;
    int currentID;
    JComboBox ArrOrderList = new JComboBox(ArrOrder);
    
    
    public AutoArrange(int CurrentID,MainForm mainform){
    currentID=CurrentID;    
    Mainform=mainform;
    AA=this;
        /*item.add(itemA);
        item.add(itemB);
        item.add(itemC);
        restA.setItemList(item);
        affiliate.add(restA);
        Bitem.add(BitemA);
        Bitem.add(BitemB);
        Bitem.add(BitemC);
        Bitem.add(BitemD);
        Bitem.add(BitemE);
        Bitem.add(BitemF);
        restB.setItemList(Bitem);
        affiliate.add(restB);*/
        
        
        ArrOrderList.setSelectedIndex(0);
        
        lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitle.setFont(FontTitle);
        add(lblTitle,BorderLayout.NORTH);
        
        
        for(int i=1;i<Mainform.aff.getNumberOfEntries()+1;i++){
            if(Mainform.aff.getEntry(i).getAffiliate_id()==CurrentID){
                for(int o=1;o<Mainform.aff.getEntry(i).getItemList().getNumberOfEntries()+1;o++){
                    tempItem tempItem=new tempItem(Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_id(),Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_name(),Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_price(),Mainform.aff.getEntry(i).getItemList().getEntry(o).getRest_id(),Mainform.aff.getEntry(i).getItemList().getEntry(o).getDesc(),Mainform.aff.getEntry(i).getItemList().getEntry(o).getItem_season());
                    tempOrder1.add(tempItem);
                    tempOrder.add(tempItem);
                }
            }  
        }
        
                
                
        
        lblID.setForeground(Color.MAGENTA);
        lblName.setForeground(Color.MAGENTA);
        lblPrice.setForeground(Color.MAGENTA);
        lblDesc.setForeground(Color.MAGENTA);
        lblSeason.setForeground(Color.MAGENTA);
        
        DisplayLayout();
        
        
        btnCon.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent evt) {
                            Confirm(evt);
                        }
                    });
        btnRef.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent evt) {
                            refresh(evt,ArrOrderList.getSelectedIndex());
                        }
                    });
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AffMainMenu AFF=new AffMainMenu(currentID,Mainform);
                    AFF.setVisible(true);
                    AFF.setLocationRelativeTo(null);
                    AA.setVisible(false);
            }
        });
        
       
        
        
       /* btnAuto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SelAuto(evt);
            }
        });*/
        
        
        
        
        setTitle("Arrange Item");
        setSize(1000, 500);  
        setLocationRelativeTo(null);   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setVisible(true);
    }    
    
    private void DisplayLayout(){
        
        P.removeAll();
        
        for(int i=1;i<Mainform.aff.getNumberOfEntries()+1;i++){
            if(Mainform.aff.getEntry(i).getAffiliate_id()==currentID){
                
                P.setLayout(new GridLayout(Mainform.aff.getEntry(i).getItemList().getNumberOfEntries()+2, 5));
            }  
        }
        P.add(lblID).setFont(font);
        P.add(lblName).setFont(font);
        P.add(lblPrice).setFont(font);
        P.add(lblDesc).setFont(font);
        P.add(lblSeason).setFont(font);
        
        
                for(int o=1;o<tempOrder.getNumberOfEntries()+1;o++){
                    P.add(new JLabel(String.valueOf(tempOrder.getEntry(o).getItem_id()))).setFont(font);
                    P.add(new JLabel(tempOrder.getEntry(o).getItem_name())).setFont(font);
                    P.add(new JLabel(Double.toString(tempOrder.getEntry(o).getItem_price()))).setFont(font);
                    P.add(new JLabel(tempOrder.getEntry(o).getDesc())).setFont(font);
                    P.add(new JLabel(tempOrder.getEntry(o).getItem_season()));
                 } 
        P.add(ArrOrderList);
        P.add(btnRef);
        P.add(btnCon);
        P.add(btnBack);
        add(P);
        
    }
    
    private void Confirm(ActionEvent evt){
        for(int i=1;i<Mainform.aff.getNumberOfEntries()+1;i++){
            if(Mainform.aff.getEntry(i).getAffiliate_id()==currentID){
                
                for(int o=1;o<tempOrder.getNumberOfEntries()+1;o++){
                    Item AddItem=new Item(tempOrder.getEntry(o).getItem_id(),tempOrder.getEntry(o).getItem_name(),tempOrder.getEntry(o).getItem_price(),tempOrder.getEntry(o).getRest_id(),tempOrder.getEntry(o).getDesc(),tempOrder.getEntry(o).getItem_season());
                    Mainform.aff.getEntry(i).getItemList().replace(o,AddItem);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Arrange Successful!!", "InfoBox: " + "Successful!!", JOptionPane.INFORMATION_MESSAGE);
    }
        
    
    
    private void refresh(ActionEvent evt,int index) {
       
       if(index==0){
           
           tempOrder.clear();
           
           for(int o=1;o<tempOrder1.getNumberOfEntries()+1;o++){
               tempOrder.ArrangeAZ(tempOrder1.getEntry(o));
               
           }
           DisplayLayout();
           
           
           
        }else if(index==1){
           tempOrder.clear();
           
           for(int o=1;o<tempOrder1.getNumberOfEntries()+1;o++){
               tempOrder.ArrangeZA(tempOrder1.getEntry(o));
               
           }
           DisplayLayout();
        }else if(index==2){
            tempOrder.clear();
           
           for(int o=1;o<tempOrder1.getNumberOfEntries()+1;o++){
               tempOrder.ArrangePriceZA(tempOrder1.getEntry(o));
               
           }
           DisplayLayout();
        
        }else if(index==3){
            tempOrder.clear();
           
           for(int o=1;o<tempOrder1.getNumberOfEntries()+1;o++){
               tempOrder.ArrangePriceAZ(tempOrder1.getEntry(o));
               
           }
           DisplayLayout();
        }else if(index==4){
            tempOrder.clear();
           for(int o=1;o<tempOrder1.getNumberOfEntries()+1;o++){
               tempOrder.ArrangeSpring(tempOrder1.getEntry(o));
           }
           DisplayLayout();
        }else if(index==5){
            tempOrder.clear();
           
           for(int o=1;o<tempOrder1.getNumberOfEntries()+1;o++){
               tempOrder.ArrangeSummer(tempOrder1.getEntry(o)); 
               System.out.println("Finish summer loop");
           }
           
           DisplayLayout();
        }else if(index==6){
            tempOrder.clear();
           System.out.println("autumn");
           for(int o=1;o<tempOrder1.getNumberOfEntries()+1;o++){
               tempOrder.ArrangeAutumn(tempOrder1.getEntry(o));
               
           }
           DisplayLayout();
        }else{
            tempOrder.clear();
           System.out.println("winter");
           for(int o=1;o<tempOrder1.getNumberOfEntries()+1;o++){
               tempOrder.ArrangeWinter(tempOrder1.getEntry(o));   
           }
           DisplayLayout();
        }
    }
    public static void main(String[] args){
        
       
         }
        
    }


        
    



            
    
    
    
    
    

