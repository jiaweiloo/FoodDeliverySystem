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

    public deliverymanCtrl(QueueInterface<Integer> employeeID) {
        this.employeeID = employeeID;
    }

    public boolean arrange() {

        if (!employeeID.isEmpty() && !orderList.isEmpty()) {
            ehl = new emp_handled_list(000001, employeeID.getFront(), orderList.getFront().getOrder_id(), dateOnly.format(new Date()), timeOnly.format(new Date()), "HANDLED", "NONE");
            ehlList.add(ehl);
            return true;
        } else {
            return false;
        }
    }

    public void complete(int givenPosition, emp_handled_list ehl) {
        this.ehl = ehl;
        ehl.setHandled_status("DELIVERED");
        ehlList.replace(givenPosition, ehl);
    }
}
