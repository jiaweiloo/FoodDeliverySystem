package adt;

import entity.employee;

/**
 *
 * @author jiaweiloo
 */
public class WaitingQueueADT<T> implements WaitingInterface<T> {

    private Node firstNode; // references node at front of queue
    private Node lastNode;  // references node at back of queue
    private int size;

    public WaitingQueueADT() {
        firstNode = null;
        lastNode = null;
        size = 0;
    } // end default constructor

    public int size() {
        return size;
    }

    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }

        lastNode = newNode;
        size++;
    } // end enqueue

    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = firstNode.data;
        }

        return front;
    } // end getFront

    public T dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = firstNode.data;
            firstNode = firstNode.next;

            if (firstNode == null) {
                lastNode = null;
            }
            size--;
        } // end if

        return front;
    } // end dequeue

    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    } // end isEmpty

    public void clear() {
        firstNode = null;
        lastNode = null;
    } // end clear

    public void enqueueAscTotalHandled(T newEntry) {
        boolean found = false;
        Node newNode = new Node(newEntry, null);
        employee newEmp = (employee) newEntry;
        Node currentNode = firstNode;

        if (isEmpty()) {
            firstNode = newNode;
            found = true;
        } else if (currentNode.next == null) {
            currentNode.next = newNode;
            found = true;
        }
        /*
        else {
            lastNode.next = newNode;
        } */
        while (!found && (currentNode != null)) {
            employee currentNodeEmp = ((employee) currentNode.data);
            if (currentNode.next == null) {
                currentNode.next = newNode;
                found = true;
            } else if (newEmp.getTotal_handled() == currentNodeEmp.getTotal_handled()
                    && newEmp.getTotal_handled() < ((employee) currentNode.next.data).getTotal_handled()) {

                newNode.next = currentNode.next;
                currentNode.next = newNode;
                found = true;

            } else {
                currentNode = currentNode.next;
            }

        }// end of while loop

        lastNode = newNode;
        size++;
    }

    @Override
    public employee searchID(int ID) {
        boolean found = false;
        employee result = null;
        Node currentNode = firstNode;
        employee emp;
        while (!found && (currentNode != null)) {
            emp = (employee) currentNode.data;
            if (emp.getEmp_id() == ID) {
                found = true;
                result = emp;
            } else {
                currentNode = currentNode.next;
            }
        }
        return result;
    }
    
    private class Node {

        private T data; // entry in queue
        private Node next; // link to next node

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        } // end constructor

        private Node(T dataPortion, Node linkPortion) {
            data = dataPortion;
            next = linkPortion;
        } // end constructor
    } // end Node

}
