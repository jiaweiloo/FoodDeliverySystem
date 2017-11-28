/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_A;
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
    String[][] data = {{"Curry Chicken", "20", "AAA"},
        {"Curry Fish Head", "5", "BBB"}, 
        {"Thai Fried Rice", "6.3", "CCC"}};
    JTextField jtfName = new JTextField();
        JTextField jtfPrice = new JTextField();
        JTextField jtfDescription = new JTextField();
    public AddItem(){
    
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
        if(jtfName.getText().equals("")||jtfPrice.getText().equals("")||jtfDescription.getText().equals("")){
            JOptionPane.showMessageDialog(null, "All fields are required!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
        }else{
            try{
                 double value = Double.parseDouble(jtfPrice.getText());
                 double answer = value * 9 / 5 + 35;
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Price must be number!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                if(data[0][0].equals(jtfName.getText())||data[1][0].equals(jtfName.getText())||data[2][0].equals(jtfName.getText())){
                      JOptionPane.showMessageDialog(null, "Item Name Used!!", "InfoBox: " + "Error!!", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Item Saved!!", "InfoBox: " + "Item Saved!!", JOptionPane.INFORMATION_MESSAGE);
                    data[a][0]=jtfName.getText();
                    data[a][1]=jtfPrice.getText();
                    data[a][2]=jtfDescription.getText();
                    a++;
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
