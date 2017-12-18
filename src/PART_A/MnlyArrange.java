/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_A;

import adt.AffiliateADT;
import adt.LList;
import adt.ListInterface;
import entity.Affiliate;
import entity.Item;
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
public class MnlyArrange extends JFrame{
    
    
    
    
    AffiliateADT<Affiliate> affiliate=new AffiliateADT<Affiliate>();
    Affiliate restA=new Affiliate(1000,"Rest A","Rest A address","Ali","0111111111","Zone A","123456789");
    Affiliate restB=new Affiliate(1001,"Rest B","Rest B address","Bli","0111111111","Zone B","123456789");
    ListInterface<Item> item=new LList<Item>(); 
    ListInterface<Item> Bitem=new LList<Item>(); 
    ListInterface<Item> tempOrder=new LList<Item>();
    ListInterface<Item> tempOrder2=new LList<Item>();
    Item itemA=new Item(6001,"Curry Chicken",12.30,1000,"Curry Chicken taste good");
    Item itemB=new Item(6002,"Curry Fish",12.30,1000,"Curry Fish taste good");
    Item itemC=new Item(6003,"Curry Duck",12.30,1000,"Curry Duck taste good");
    Item BitemA=new Item(6001,"BCurry Chicken",12.30,1001,"Curry Chicken taste good");
    Item BitemB=new Item(6002,"BCurry Fish",12.30,1001,"Curry Fish taste good");
    Item BitemC=new Item(6003,"BCurry Duck",12.30,1001,"Curry Duck taste good");
    JLabel lblTitle=new JLabel("Current Arrange Order");
    Font FontTitle = new Font("SansSerif",Font.BOLD,24);
    Font font = new Font("SansSerif",Font.PLAIN,14);
    JPanel P=new JPanel();
    JLabel lblSID=new JLabel();
    JTextField jtfPosition = new JTextField();
    JTextField jtfSName = new JTextField();
    JTextField jtfSPrice = new JTextField();
    JTextField jtfSDesc = new JTextField();
    JTextField input = new JTextField();
    
    
    
    
    public MnlyArrange(int CurrentID){
        
        item.add(itemA);
        item.add(itemB);
        item.add(itemC);
        //restA.setItemList(item);
        affiliate.add(restA);
        Bitem.add(BitemA);
        Bitem.add(BitemB);
        Bitem.add(BitemC);
        //restB.setItemList(Bitem);
        affiliate.add(restB);
        
        
        JLabel lblSelectedID = new JLabel("Selected ID");
        JLabel lblSelectedName = new JLabel("Selected Name");
        JLabel lblSelectedPrice = new JLabel("Selected Price");
        JLabel lblSelectedDesc = new JLabel("Selected Desc");
        JLabel lblCurrentPosition = new JLabel("Current Position");
        JLabel lblID = new JLabel("ID");
        JLabel lblInfo = new JLabel("Enter new Position =>");
        JLabel lblName = new JLabel("Item Name");
        JLabel lblPrice = new JLabel("Price(RM)");
        JLabel lblDesc = new JLabel("Desc");
        JLabel lblEmpty = new JLabel();
        JLabel lblEmpty2 = new JLabel();
        JLabel lblEmpty3 = new JLabel();
        JLabel lblEmpty4 = new JLabel();
        JLabel lblEmpty5 = new JLabel();
        JButton btnCon = new JButton("Confirm");
        JButton btnBack=new JButton("Back");
        int countP=1;
        
        try{
                 for (int i = 1; i < affiliate.getNumberOfEntries() + 1; i++) {
            if (affiliate.getEntry(i).getAffiliate_id() == CurrentID) {
                if(affiliate.getEntry(i).getItemList().isEmpty()){
                    
                    
                }
            }
        }
                 
            }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "No Item", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
        
        jtfPosition.setEditable(false);
        jtfSName.setEditable(false);
        jtfSPrice.setEditable(false);
        jtfSDesc.setEditable(false);
        
        lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitle.setFont(FontTitle);
        add(lblTitle,BorderLayout.NORTH);
        
        for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
            if(affiliate.getEntry(i).getAffiliate_id()==CurrentID){
                tempOrder=affiliate.getEntry(i).getItemList();
               P.setLayout(new GridLayout(affiliate.getEntry(i).getItemList().getNumberOfEntries() + 4, 5));
            }  
        }
        
        lblID.setForeground(Color.MAGENTA);
        lblName.setForeground(Color.MAGENTA);
        lblPrice.setForeground(Color.MAGENTA);
        lblDesc.setForeground(Color.MAGENTA);
        
        P.add(lblID).setFont(font);
        P.add(lblName).setFont(font);
        P.add(lblPrice).setFont(font);
        P.add(lblDesc).setFont(font);
        P.add(lblEmpty2);
        
        for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
           if(affiliate.getEntry(i).getAffiliate_id()==CurrentID){
                for(int o=1;o<affiliate.getEntry(i).getItemList().getNumberOfEntries()+1;o++){
                    JButton btnSelect = new JButton("Select");
                    
                    P.add(new JLabel(String.valueOf(tempOrder.getEntry(o).getItem_id()))).setFont(font);
                    P.add(new JLabel(tempOrder.getEntry(o).getItem_name())).setFont(font);
                    P.add(new JLabel(Double.toString(tempOrder.getEntry(o).getItem_price()))).setFont(font);
                    P.add(new JLabel(tempOrder.getEntry(o).getDesc())).setFont(font);
                    P.add(btnSelect);
                    
                    String SID =String.valueOf(affiliate.getEntry(i).getItemList().getEntry(o).getItem_id());
                    String SName=affiliate.getEntry(i).getItemList().getEntry(o).getItem_name();
                    String SPrice=Double.toString(affiliate.getEntry(i).getItemList().getEntry(o).getItem_price());
                    String SDesc=affiliate.getEntry(i).getItemList().getEntry(o).getDesc();
                    String P=String.valueOf(countP);
                    
                    btnSelect.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent evt) {
                            SelectItem(evt,SID,SName,SPrice,SDesc,P);
                        }
                    });
                    countP++;
                 } 
            } 
        }
        
        btnCon.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent evt) {
                            Arrange(evt,lblSID.getText(),jtfPosition.getText(),CurrentID);
                        }
                    });
        
        
        P.add(lblSelectedID);
        P.add(lblSelectedName);
        P.add(lblSelectedPrice);
        P.add(lblSelectedDesc);
        P.add(lblCurrentPosition);
        P.add(lblSID);
        P.add(jtfSName);
        P.add(jtfSPrice);
        P.add(jtfSDesc);
        P.add(jtfPosition);
        P.add(btnBack);
        P.add(lblInfo);
        P.add(input);
        
        P.add(btnCon);
        add(P);
        
       
        
        
       /* btnAuto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SelAuto(evt);
            }
        });*/
        
        
        
        
        setTitle("Arrange Item");
        setSize(800, 250);  
        setLocationRelativeTo(null);   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setVisible(true);
    }    
    
    private void SelectItem(ActionEvent evt,String ID,String Name,String Price,String Desc,String CountP) {
        lblSID.setText(ID);
        jtfSName.setText(Name);
        jtfSPrice.setText(Price);
        jtfSDesc.setText(Desc);
        jtfPosition.setText(CountP);
        
    }
    
    private void Arrange(ActionEvent evt,String ItemId,String CP,int CurrentID) {
        int maxP=0;
        int itemId=Integer.parseInt(ItemId);
        int currentPosition=Integer.parseInt(CP);
        
        if(input.getText().isEmpty()||CP.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Select Item and Enter Position", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
            return;
        }else{
             try {
                  Integer.parseInt(input.getText());
                         
                 } 
            
                    catch (NumberFormatException e) {
                           JOptionPane.showMessageDialog(null, "New Position must be numeric!", "Error!!", JOptionPane.ERROR_MESSAGE);
                           return;
                 }
        }
        int inputP =Integer.parseInt(input.getText());
        if(input.getText().equals(CP)){
            JOptionPane.showMessageDialog(null, "Please Enter Different Position!", "Error!!", JOptionPane.ERROR_MESSAGE);
                           return;
        }
        for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
            if(affiliate.getEntry(i).getAffiliate_id()==CurrentID){
                maxP=affiliate.getEntry(i).getItemList().getNumberOfEntries();
                }
            }
        if( inputP > maxP ){
            JOptionPane.showMessageDialog(null, "Invalid Position!", "Error!!", JOptionPane.ERROR_MESSAGE);
                           return;
        }
        
        for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
            if(affiliate.getEntry(i).getAffiliate_id()==CurrentID){
                        Item item;
                        item=affiliate.getEntry(i).getItemList().remove(currentPosition);
                        affiliate.getEntry(i).getItemList().add(inputP, item);
                        return;
                    }
                
                }
        /*for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
            if(affiliate.getEntry(i).getAffiliate_id()==CurrentID){
        for(int o=1;o<affiliate.getEntry(i).getItemList().getNumberOfEntries()+1;o++){
           System.out.println(affiliate.getEntry(i).getItemList().getEntry(o).getItem_name());
       }
            }
        
        }*/
        }
        
        /*for(int i=1;1<affiliate.getNumberOfEntries()+1;i++){
            if(affiliate.getEntry(i).getAffiliate_id()==CurrentID){
                for(int o =1;o<affiliate.getEntry(i).getItemList().getNumberOfEntries()+1;o++){
                    if()
                }
            }
        }*/
    
    public static void main(String[] args){
        
             MnlyArrange AA=new MnlyArrange(1001);
       
         }
        
        
    }
    
    
    
        
    
        
    



            
    
    
    
    
    

