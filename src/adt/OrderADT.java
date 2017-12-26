/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import entity.Order;

/**
 *
 * @author Loi Kah Hou
 */
public class OrderADT<T> implements OrderInterface<T> {

    private Node firstNode; // references node at front of queue
    private Node lastNode;  // references node at back of queue
    private int size;

    public OrderADT() {
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
        /*
        if(lastNode == null){
            //System.out.println("Is Null");
        } */
        
        return (firstNode == null) && (lastNode == null);
    } // end isEmpty

    public void clear() {
        firstNode = null;
        lastNode = null;
    } // end clear

    public void enqueueTotalAmount(T newEntry) {
        boolean found = false;
        Node newNode = new Node(newEntry, null);
        
        Order newOrder = (Order) newEntry;
        Node currentNode = firstNode;
        
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
            found = true;
        }
        
        while(!found&&currentNode!=null){
            Order currentOrder = (Order)currentNode.data;
            
            if(newOrder.getTotal_amount()<currentOrder.getTotal_amount()){
                if(currentNode.next==null){
                    currentNode.next = newNode;
                    lastNode = newNode;
                    found = true;
                }else if(((Order)currentNode.next.data).getTotal_amount()<newOrder.getTotal_amount()){
                    newNode.next = currentNode.next;
                    currentNode.next=newNode;
                    found = true;
                }else{
                    currentNode = currentNode.next;
                }
            }else{
                newNode.next = currentNode;
                lastNode = currentNode;
                firstNode = newNode;
                found = true;
            }
        }
        
        /*Node currentNode = firstNode;
        Node currentOrder = firstNode;
        Node afterCurrent = currentOrder.next;
        for (int a = 0; a <= size; a++) {
            while (afterCurrent != null) {
                Order tempOrder = (Order) currentOrder.data;
                Order tempOrder2 = (Order) afterCurrent.data;
                double currentTotal = tempOrder.getTotal_amount();
                double currentTotal2 = tempOrder2.getTotal_amount();
                if (currentTotal < currentTotal2) {
                    currentOrder.next = afterCurrent.next;
                    afterCurrent.next = currentOrder;
                }

                currentOrder = currentOrder.next;
                afterCurrent = currentOrder.next;
            }
        }
*/
            size++;
    }

    public boolean replaceObject(T oldEntry, T newEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        Node newNode = new Node(newEntry,null);
        
        while (!found && (currentNode != null)) {
            if (oldEntry.equals(currentNode.data)) {
                found = true;
                newNode.next = currentNode.next;
                currentNode = newNode;
                //System.out.println("Replace status : "+found);
            } else {
                currentNode = currentNode.next;
            }
        }
        return found;        
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
} // end Linkedqueue
