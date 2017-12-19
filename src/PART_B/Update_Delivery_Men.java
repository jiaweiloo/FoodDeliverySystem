/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_B;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class Update_Delivery_Men {
      public static void main(String[] args) {
        JFrame frame = new JFrame();
        JTable table = new JTable();
        Object[] columns = {"ID", "Name", "IC", "Address", "PhoneNo", "Email", "Status"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.pink);
        table.setForeground(Color.WHITE);
        Font font = new Font("Arial", Font.PLAIN, 25);
        Font btnfont = new Font("Helvetica",Font.ITALIC,30);
        table.setFont(font);
        table.setRowHeight(30);
        frame.setTitle("Add/Delete/Update");

        JTextField txtID = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtIC = new JTextField();
        JTextField txtAddress = new JTextField();
        JTextField txtPhoneNo = new JTextField();
        JTextField txtEmail = new JTextField();
     
        JTextField txtStatus = new JTextField();

        JLabel Address = new JLabel("Address: ");
        JLabel Phone = new JLabel("Phone No: ");
        JLabel Email = new JLabel("Email: ");
        JLabel Status = new JLabel("Status: ");

        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");
        JButton btnExit = new JButton("Exit");

        Address.setBounds(20, 200, 100, 30);
        txtAddress.setBounds(20, 220, 250, 30);

        Phone.setBounds(20, 240, 100, 30);
        txtPhoneNo.setBounds(20, 260, 250, 30);

        Email.setBounds(20, 280, 100, 30);
        txtEmail.setBounds(20, 300, 250, 30);

        Status.setBounds(20, 320, 100, 30);
        txtStatus.setBounds(20, 340, 250, 30);

        btnUpdate.setBounds(300, 220, 150, 30);
        btnDelete.setBounds(300, 280, 150, 30);
        btnExit.setBounds(300,340,150,30);
        btnUpdate.setFont(btnfont);
        btnDelete.setFont(btnfont);
        btnExit.setFont(btnfont);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 1000, 200);

        frame.setLayout(null);
        frame.add(pane);

        frame.add(txtID);
        frame.add(txtName);
        frame.add(txtIC);
        frame.add(txtAddress);
        frame.add(txtPhoneNo);
        frame.add(txtEmail);
        frame.add(txtStatus);
        frame.add(btnUpdate);
        frame.add(Address);
        frame.add(Phone);
        frame.add(Email);
        frame.add(Status);
        frame.add(btnDelete);
        frame.add(btnExit);

        Object[] row = new Object[8];
        for (int i = 0; i < 10; i++) {
            row[0] = txtID.getText();
            row[1] = txtName.getText();
            row[2] = txtIC.getText();
            row[3] = txtAddress.getText();
            row[4] = txtPhoneNo.getText();
            row[5] = txtEmail.getText();
          
            row[6] = txtStatus.getText();
        
            model.addRow(row);
        }
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int i = table.getSelectedRow();
                    int b=1;
                    txtID.setText(model.getValueAt(i, 0).toString());
                    txtName.setText(model.getValueAt(i, 1).toString());
                    txtIC.setText(model.getValueAt(i, 2).toString());
                    txtAddress.setText(model.getValueAt(i, 3).toString());
                    txtPhoneNo.setText(model.getValueAt(i, 4).toString());
                    txtEmail.setText(model.getValueAt(i, 5).toString());
                    txtStatus.setText(model.getValueAt(i, 6).toString());
                }
            });

            btnDelete.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    int a = table.getSelectedRow();
                    
                    if (a >= 0) {
                        model.removeRow(a);
                    } else {
                        JOptionPane.showMessageDialog(null, "No more record!!!");
                        //System.out.println(a);
                        
                    }
                }
            });
            
            btnExit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.exit(0);
                    }
});
            
                  btnUpdate.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e) {
                    int i = table.getSelectedRow();
                    
                     if(i >= 0) 
                {
                   model.setValueAt(txtID.getText(), i, 0);
                   model.setValueAt(txtName.getText(), i, 1);
                   model.setValueAt(txtIC.getText(), i, 2);
                   model.setValueAt(txtAddress.getText(), i, 3);
                   model.setValueAt(txtPhoneNo.getText(), i, 4);
                   model.setValueAt(txtEmail.getText(), i, 5);
                   model.setValueAt(txtStatus.getText(), i, 6);
                }
                else{
                     JOptionPane.showMessageDialog(null, "Update Error!!");
                    //System.out.println("Update Error");
                }
            }
        });

            frame.setSize(1010, 450);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        

    }
    
}
