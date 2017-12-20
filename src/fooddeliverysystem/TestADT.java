/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fooddeliverysystem;

import adt.*;
import entity.*;

/**
 *
 * @author jiawe
 */
public class TestADT {

    public WaitingInterface<employee> empWaitingList = new WaitingQueueADT<employee>();
    employee emp1 = new employee(100001, "jason@mail.com", "abcd1234", "offline", "890831-05-4492", "A-4-2 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-4441221", "DM", 2009, 6);
    employee emp2 = new employee(100002, "manager@mail.com", "abcd1234", "other", "890731-05-4492", "A-7-4 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-4661321", "EXEC", 2010, 0);
    employee emp3 = new employee(100003, "annabelle@mail.com", "abcd1234", "offline", "800831-05-4592", "A-3-6 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-8535221", "DM", 2016, 3);
    employee emp4 = new employee(100004, "marie@mail.com", "abcd1234", "offline", "990731-08-4492", "A-2-2 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-1231221", "DM", 2012, 2);
    employee emp5 = new employee(100005, "lucas@mail.com", "abcd1234", "other", "790821-05-4492", "A-6-5 Sri Pelangi, Jln Genting Klang, 53300 KL", "012-4990621", "AFFT", 2014, 5);
    employee emp;

    public static void main(String[] args) {
        TestADT test = new TestADT();
        test.update();
        while (test.empWaitingList.getFront() != null) {
            test.emp = test.empWaitingList.dequeue();
            System.out.println(test.emp.getTotal_handled());
        }
    }

    public void update() {
        empWaitingList.add(emp1);
        empWaitingList.add(emp2);        
        empWaitingList.add(emp3);
        empWaitingList.add(emp4);
        empWaitingList.add(emp5);
    }
}
