/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_A;

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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Mah Hong Wai
 */
public class AutoArrange extends JFrame{
    
    
    
    
    ListInterface<Affiliate> affiliate=new LList<Affiliate>();
    Affiliate restA=new Affiliate(1000,"Rest A","Rest A address","Ali","0111111111","Zone A","123456789");
    Affiliate restB=new Affiliate(1001,"Rest B","Rest B address","Bli","0111111111","Zone B","123456789");
    ListInterface<Item> item=new LList<Item>(); 
    ListInterface<Item> Bitem=new LList<Item>(); 
    ListInterface<Item> tempOrder=new LList<Item>();
    ListInterface<Item> tempOrder2=new LList<Item>();
    Item itemA=new Item(6001,"Curry Chicken",12.30,1000,"Curry Chicken taste good");
    Item itemB=new Item(6002,"Curry Fish",12.30,1000,"Curry Fish taste good");
    Item itemC=new Item(6003,"Curry Duck",12.30,1000,"Curry Duck taste good");
    Item BitemA=new Item(6001,"g",12.30,1001,"Curry Chicken taste good");
    Item BitemB=new Item(6002,"e",12.30,1001,"Curry Fish taste good");
    Item BitemC=new Item(6003,"f",12.30,1001,"Curry Duck taste good");
    Item BitemD=new Item(6003,"e",12.30,1001,"Curry Duck taste good");
    Item BitemE=new Item(6003,"b",12.30,1001,"Curry Duck taste good");
    Item BitemF=new Item(6003,"f",12.30,1001,"Curry Duck taste good");
    JLabel lblTitle=new JLabel("Current Arrange Order");
    Font FontTitle = new Font("SansSerif",Font.BOLD,24);
    Font font = new Font("SansSerif",Font.PLAIN,14);
    JPanel P=new JPanel();
    
    String[] ArrOrder = new String[]{"A to Z(First Alphabet)","Z to A(First Alphabet)","Price"};


    JComboBox ArrOrderList = new JComboBox(ArrOrder);
    
    
    public AutoArrange(int CurrentID){
        
        item.add(itemA);
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
        affiliate.add(restB);
        
        JLabel lblID = new JLabel("ID");
        JLabel lblName = new JLabel("Item Name");
        JLabel lblPrice = new JLabel("Price(RM)");
        JLabel lblDesc = new JLabel("Desc");
        JButton btnRef = new JButton("Refresh");
        JButton btnCon = new JButton("Confirm");
        ArrOrderList.setSelectedIndex(0);
        
        lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitle.setFont(FontTitle);
        add(lblTitle,BorderLayout.NORTH);
        
        for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
            if(affiliate.getEntry(i).getAffiliate_id()==CurrentID){
                tempOrder=affiliate.getEntry(i).getItemList();
                P.setLayout(new GridLayout(affiliate.getEntry(i).getItemList().getNumberOfEntries()+2, 4));
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
        
        for(int i=1;i<affiliate.getNumberOfEntries()+1;i++){
           if(affiliate.getEntry(i).getAffiliate_id()==CurrentID){
                for(int o=1;o<affiliate.getEntry(i).getItemList().getNumberOfEntries()+1;o++){
                    P.add(new JLabel(String.valueOf(tempOrder.getEntry(o).getItem_id()))).setFont(font);
                    P.add(new JLabel(tempOrder.getEntry(o).getItem_name())).setFont(font);
                    P.add(new JLabel(Double.toString(tempOrder.getEntry(o).getItem_price()))).setFont(font);
                    P.add(new JLabel(tempOrder.getEntry(o).getDesc())).setFont(font);
                 } 
            } 
        }
        
        
        btnRef.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent evt) {
                            refresh(evt,ArrOrderList.getSelectedIndex(),CurrentID);
                        }
                    });
        P.add(ArrOrderList);
        P.add(btnRef);
        P.add(btnCon);
        P.add(new JLabel(""));
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
    
    private void refresh(ActionEvent evt,int index,int CurrentID) {
       int count=0;
       char newChar;
       char charB4;
       char charAft;
       int e=3;
       tempOrder2.clear();
       for(int i=1;i<tempOrder.getNumberOfEntries()+1;i++){
           tempOrder2.add(tempOrder.getEntry(i));
       }
       //tempOrder2=tempOrder;
       tempOrder.clear();
       
       
       if(index==0){
           
           ArrangeAZ();
           
        }else if(index==1){
            for(int o=1;o<tempOrder2.getNumberOfEntries()+1;o++){
                        if(count==0){
                            tempOrder.add(tempOrder2.getEntry(o));
                            count++;
                        }else if(count==1){
                            newChar=tempOrder2.getEntry(o).getItem_name().charAt(0);
                            charB4=tempOrder.getEntry(1).getItem_name().charAt(0);
                            if(newChar>charB4||newChar==charB4){
                                       tempOrder.add(1,tempOrder2.getEntry(o) );
                                       count++;
                                }
                            else{
                                tempOrder.add(2,tempOrder2.getEntry(o) );
                                       count++;
                            }
                        }else{
                            
                            newChar=tempOrder2.getEntry(o).getItem_name().charAt(0);
                            
                            for(int q=1;q<tempOrder2.getNumberOfEntries()+1;q++){
                                if(q<6){
                                charB4=tempOrder.getEntry(q).getItem_name().charAt(0);
                                charAft=tempOrder.getEntry(q+1).getItem_name().charAt(0);
                                if((newChar<charB4&&newChar==charB4)||(newChar<charB4&&newChar>charAft)||(newChar<charB4&&newChar==charAft)||(newChar==charB4&&newChar==charAft)||(newChar==charB4&&newChar>charAft)){
                                    tempOrder.add(q+1,tempOrder2.getEntry(o));
                                    break;
                                }else if(newChar>=charB4){
                                    tempOrder.add(q,tempOrder2.getEntry(o));
                                    break;
                                }else{
                                    tempOrder.add(q+2,tempOrder2.getEntry(o));
                                    break;
                                }
                                }else{
                                    tempOrder.add(q,tempOrder2.getEntry(o));
                                }
                                
                            
                            }
                           }
                        }
        
        }
       
       
        }
    public static void main(String[] args){
        
             AutoArrange AA=new AutoArrange(1001);
       
         }
        
    }

/*
for(int o=1;o<tempOrder2.getNumberOfEntries()+1;o++){
                        if(count==0){
                            tempOrder.add(tempOrder2.getEntry(o));
                            System.out.println(tempOrder.getEntry(1).getItem_name());
                            System.out.println("1======");
                            count++;
                        }else if(count==1){
                            newChar=tempOrder2.getEntry(o).getItem_name().charAt(0);
                            charB4=tempOrder.getEntry(1).getItem_name().charAt(0);
                            System.out.println(newChar);
                            System.out.println(charB4);
                            System.out.println("2======");
                            if(newChar>charB4||newChar==charB4){
                                       tempOrder.add(2,tempOrder2.getEntry(o) );
                                       count++;
                                       System.out.println(tempOrder.getEntry(1).getItem_name());
                                       System.out.println(tempOrder.getEntry(2).getItem_name());
                                       System.out.println("After add in 2======");
                                }
                            else{
                                tempOrder.add(1,tempOrder2.getEntry(o) );
                                       count++;
                                       System.out.println(tempOrder.getEntry(1).getItem_name());
                                       System.out.println(tempOrder.getEntry(2).getItem_name());
                                       System.out.println("After add in 2======");
                            }
                        }else{
                            
                            newChar=tempOrder2.getEntry(o).getItem_name().charAt(0);
                            
                            
                        }
                        }for(int q=1;q<tempOrder2.getNumberOfEntries()+1;q++){
                                if(q<6){
                                charB4=tempOrder.getEntry(q).getItem_name().charAt(0);
                                charAft=tempOrder.getEntry(q+1).getItem_name().charAt(0);
                                if((newChar>charB4&&newChar<charAft)||(newChar==charB4&&newChar<charAft)||(newChar==charB4&&newChar==charAft)||(newChar<charB4&&newChar==charAft)){
                                    tempOrder.add(q+1,tempOrder2.getEntry(o));
                                    for(int i=1;i<tempOrder.getNumberOfEntries()+1;i++){
                                        System.out.println(tempOrder.getEntry(i).getItem_name());
                                    }
                                    System.out.println("After add in "+e+"======");
                                    e++;
                                    break;
                                }else if(newChar<=charB4){
                                    tempOrder.add(q,tempOrder2.getEntry(o));
                                    for(int i=1;i<tempOrder.getNumberOfEntries()+1;i++){
                                        System.out.println(tempOrder.getEntry(i).getItem_name());
                                    }
                                    System.out.println("After add in "+e+"======");
                                    e++;
                                    break;
                                }else{
                                    tempOrder.add(q+2,tempOrder2.getEntry(o));
                                    for(int i=1;i<tempOrder.getNumberOfEntries()+1;i++){
                                        System.out.println(tempOrder.getEntry(i).getItem_name());
                                    }
                                    System.out.println("After add in "+e+"======");
                                    e++;
                                    break;
                                }
                                }else{
                                    tempOrder.add(q,tempOrder2.getEntry(o));
                                    for(int i=1;i<tempOrder.getNumberOfEntries()+1;i++){
                                        System.out.println(tempOrder.getEntry(i).getItem_name());
                                    }
                                    System.out.println("After add in "+e+"======");
                                    e++;
                                }
                                
                                
                            
                            }*/
        
    



            
    
    
    
    
    

