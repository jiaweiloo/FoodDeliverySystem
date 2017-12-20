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

    public boolean add(T newEntry) {
        firstNode = addEmployee(newEntry, firstNode);
        size++;
        return true;
    }

    private Node addEmployee(T newEntry, Node currNode) {
        employee newEmp = (employee) newEntry;
        employee currentNodeEmp = null;
        if (currNode != null) {
            currentNodeEmp = ((employee) currNode.data);
        }

        if ((currNode == null)) {
            currNode = new Node(newEntry, currNode);
        } else if (newEmp.getTotal_handled() < currentNodeEmp.getTotal_handled()) {
            currNode = new Node(newEntry, currNode);
        } else {
            Node nodeAfter = addEmployee(newEntry, currNode.next);
            currNode.next = nodeAfter;
        }
        return currNode;
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

    public boolean remove(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        Node nodeBefore = firstNode;
        int currentPosition = 1;
        while (!found && (currentNode != null)) {

            if (anEntry.equals(currentNode.data)) {
                if (currentPosition == 1) {      // case 1: remove first entry               
                    firstNode = firstNode.next;
                } else {                         // case : givenPosition > 1
                    nodeBefore.next = currentNode.next.next;	// make node before point to node after the
                }

                found = true;
                System.out.println("remove result: " + found);
                size--;
            } else {
                currentNode = currentNode.next;
                if (currentPosition > 1) {
                    nodeBefore = nodeBefore.next;
                }
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

}
