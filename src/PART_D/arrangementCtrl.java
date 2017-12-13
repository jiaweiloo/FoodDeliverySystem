package PART_D;

import adt.*;
import entity.*;

/**
 *
 * @author jiaweiloo
 */
public class arrangementCtrl {

    ListInterface<employee> empList;
    ListInterface<Attendance> attdList;
    QueueInterface<Order> orderQueue = new LinkedQueue<Order>();
    QueueInterface<Order> orderQueue2 = new LinkedQueue<Order>();

    public void reQueue() {
        Order ord;
        while (!orderQueue.isEmpty()) {
            ord = orderQueue.getFront();

            for (int count = 1; count < orderQueue.size(); count++) {
                if (ord.getRestaurant_id() == orderQueue.getFront().getRestaurant_id()) {
                    orderQueue2.enqueue(orderQueue.dequeue());
                } else {
                    orderQueue.enqueue(orderQueue.dequeue());
                }

            } //end of for loop
        }//end of while loop
        //put everything in orderQueue
        orderQueue = orderQueue2;
    }//end of requeue
}
