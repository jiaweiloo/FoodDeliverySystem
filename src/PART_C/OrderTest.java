/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PART_C;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Loi Kah Hou
 */
public class OrderTest {
    String[][] data = {{"Curry Chicken", "2", "10"}, {"Curry Fish Head", "1", "20"}, {"Thai Fried Rice", "1", "10"}};
    
    public String[][] getOrderItem(){
        return data;
    }
    
    public void setOrderItem(String[][] orderItem){
        data = orderItem;
    }
    
    public String[][] getTableData (JTable table) {
    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
    String[][] tableData = new String[nRow][nCol];
    for (int i = 0 ; i < nRow ; i++)
        for (int j = 0 ; j < nCol ; j++)
            tableData[i][j] = dtm.getValueAt(i,j).toString();
    return tableData;
}
}
