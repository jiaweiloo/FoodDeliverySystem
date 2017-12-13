/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import adt.*;
import entity.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Student
 */
public class deliverymanCtrl {

    SimpleDateFormat timeOnly = new SimpleDateFormat("hh:mm:ss");
    SimpleDateFormat dateOnly = new SimpleDateFormat("dd/MM/yyyy");
    QueueInterface<Integer> employeeID;
    LinkedQueue<Order> orderList;
    ListInterface<emp_handled_list> ehlList;
    emp_handled_list ehl;

    public deliverymanCtrl() {

    }

    public deliverymanCtrl(QueueInterface<Integer> employeeID, LinkedQueue<Order> orderList, ListInterface<emp_handled_list> ehlList) {
        this.employeeID = employeeID;
        this.orderList = orderList;
        this.ehlList = ehlList;
    }

    public ListInterface arrange() {
        int handle_id = 000001;
        if (!employeeID.isEmpty() && !orderList.isEmpty()) {
            if (!ehlList.isEmpty()) {
                handle_id = ehlList.getEntry(ehlList.getNumberOfEntries()).getHandle_id();
            }
            ehl = new emp_handled_list(handle_id, employeeID.getFront(), orderList.getFront().getOrder_id(), dateOnly.format(new Date()), timeOnly.format(new Date()), "HANDLED", "NONE");
            ehlList.add(ehl);
            return ehlList;
        } else {
            return ehlList;
        }
    }

    public void complete(int givenPosition, emp_handled_list ehl) {
        this.ehl = ehl;
        ehl.setHandled_status("DELIVERED");
        ehlList.replace(givenPosition, ehl);
    }
}
