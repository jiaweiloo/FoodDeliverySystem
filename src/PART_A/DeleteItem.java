/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_A;

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
    
    
    String[][] data = {{"Curry Chicken",  "20",   "AAA"},
                       {"Curry Fish Head", "5",   "BBB"}, 
                       {"Thai Fried Rice", "6.3", "CCC"}};
    JTextField input = new JTextField();
    
    public DeleteItem(){
        JLabel name = new JLabel("Item Name");
        JLabel price = new JLabel("Price(RM)");
        JLabel desc = new JLabel("Desc");
        JLabel name1 = new JLabel("Curry Chicken");
        JLabel price1 = new JLabel("20");
        JLabel desc1 = new JLabel("AAA");
        JLabel name2 = new JLabel("Curry Fish Head");
        JLabel price2 = new JLabel("5");
        JLabel desc2 = new JLabel("BBB");
        JLabel name3 = new JLabel("Thai Fried Rice");
        JLabel price3 = new JLabel("6.3");
        JLabel desc3 = new JLabel("CCC");
        JLabel text = new JLabel();
        JButton delete = new JButton("Delete");
        
        JLabel aa = new JLabel("Enter Item Name");
        setLayout(new GridLayout(5, 3));
       /* for(int o=0;o<3;o++){
        for(int i=0;i<3;i++){
            name.setText(data[i][0]);
            price.setText(data[i][1]);
            desc.setText(data[i][2]);
            add(name);
            add(price);
            add(desc);
          text.setText(data[o][i]);
          add(text);
        }
        }*/
       delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteItem(evt);
            }
        });
        add(name);
        add(price);
        add(desc);
        add(name1);
        add(price1);
        add(desc1);
        add(name2);
        add(price2);
        add(desc2);
        add(name3);
        add(price3);
        add(desc3);
        add(aa);
        add(input);
        add(delete);
        
        
        
        setTitle("Delete Item");
        setSize(500, 250);  
        setLocationRelativeTo(null);   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setVisible(true);
    }
    private void deleteItem(ActionEvent evt) {
            if(input.getText()==null){
                JOptionPane.showMessageDialog(null, "Input field is required!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
            }else if(input.getText().equals(data[0][0])||input.getText().equals(data[1][0])||input.getText().equals(data[2][0])){
                JOptionPane.showMessageDialog(null, "Item Deleted!!", "InfoBox: " + "Item Saved!!", JOptionPane.INFORMATION_MESSAGE);
               // String[][] result=new String[data.length-1][];
                for(int i=0;i<data.length-1;i++){
                    if(data[i][0]!=input.getText()){
                        data[i][0]=null;
                        data[i][1]=null;
                        data[i][2]=null;
                    }
                    System.exit(0);
                }
               // data=null;
               //data=result;
                
                
            }else{
                JOptionPane.showMessageDialog(null, "Invalid input!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
                
            }
        

        }
    public static void main(String[] args){
        DeleteItem DI=new DeleteItem();
    }
}
