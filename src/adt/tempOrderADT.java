package adt;

import entity.Order;
import entity.tempItem;

/**
 * LList.java A class that implements the ADT list by using a chain of nodes,
 * with the node implemented as an inner class.
 */
public class tempOrderADT<T> implements tempOrderInterface<T> {

    private Node firstNode; // reference to first node
    private Node lastNode;
    private int numberOfEntries;  	// number of entries in list

    public tempOrderADT() {
        clear();
    }

    @Override
    public final void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean add(T newEntry) {
        tempOrderADT.Node newNode = new tempOrderADT.Node(newEntry);	// create the new node

        if (isEmpty()) // if empty list
        {
            firstNode = newNode;
        } else {                        // add to end of nonempty list
            tempOrderADT.Node currentNode = firstNode;					// traverse linked list with p pointing to the current node
            while (currentNode.next != null) {		// while have not reached the last node
                currentNode = currentNode.next;
            }
            currentNode.next = newNode; // make last node reference new node
        }

        numberOfEntries++;
        return true;
    }
    
    
    public void ArrangeAZ(T newEntry){
        boolean found = false;
        tempOrderADT.Node newNode = new tempOrderADT.Node(newEntry, null);
        
        tempItem item = (tempItem) newEntry;
        tempOrderADT.Node currentNode = firstNode;
        
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
            found = true;
        }
        
        while(!found&&currentNode!=null){
            tempItem currentItem = (tempItem)currentNode.data;
            ;
            if(Character.toLowerCase(item.getItem_name().charAt(0))>=Character.toLowerCase(currentItem.getItem_name().charAt(0))){
                if(currentNode.next==null){
                    currentNode.next = newNode;
                    lastNode = newNode;
                    found = true;
                }else if(Character.toLowerCase(((tempItem)currentNode.next.data).getItem_name().charAt(0))>=Character.toLowerCase(item.getItem_name().charAt(0))){
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
        numberOfEntries++;
    }
    
    
    
    public void ArrangeZA(T newEntry){
        boolean found = false;
        tempOrderADT.Node newNode = new tempOrderADT.Node(newEntry, null);
        
        tempItem item = (tempItem) newEntry;
        tempOrderADT.Node currentNode = firstNode;
        
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
            found = true;
        }
        
        while(!found&&currentNode!=null){
            tempItem currentItem = (tempItem)currentNode.data;
            
            if(Character.toLowerCase(item.getItem_name().charAt(0))<=Character.toLowerCase(currentItem.getItem_name().charAt(0))){
                if(currentNode.next==null){
                    currentNode.next = newNode;
                    lastNode = newNode;
                    found = true;
                }else if(Character.toLowerCase(((tempItem)currentNode.next.data).getItem_name().charAt(0))<=Character.toLowerCase(item.getItem_name().charAt(0))){
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
        numberOfEntries++;
    }
    
    public void ArrangePriceZA(T newEntry){
        boolean found = false;
        tempOrderADT.Node newNode = new tempOrderADT.Node(newEntry, null);
        
        tempItem item = (tempItem) newEntry;
        tempOrderADT.Node currentNode = firstNode;
        
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
            found = true;
        }
        
        while(!found&&currentNode!=null){
            tempItem currentItem = (tempItem)currentNode.data;
            
            if(item.getItem_price()<=currentItem.getItem_price()){
                if(currentNode.next==null){
                    currentNode.next = newNode;
                    lastNode = newNode;
                    found = true;
                }else if(((tempItem)currentNode.next.data).getItem_price()<=item.getItem_price()){
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
        numberOfEntries++;
    }
    
    public void ArrangePriceAZ(T newEntry){
        boolean found = false;
        tempOrderADT.Node newNode = new tempOrderADT.Node(newEntry, null);
        
        tempItem item = (tempItem) newEntry;
        tempOrderADT.Node currentNode = firstNode;
        
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
            found = true;
        }
        
        while(!found&&currentNode!=null){
            tempItem currentItem = (tempItem)currentNode.data;
            
            if(item.getItem_price()>=currentItem.getItem_price()){
                if(currentNode.next==null){
                    currentNode.next = newNode;
                    lastNode = newNode;
                    found = true;
                }else if(((tempItem)currentNode.next.data).getItem_price()>=item.getItem_price()){
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
        numberOfEntries++;
    }
    
    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            result = currentNode.data;	// currentNode is pointing to the node at givenPosition
        }

        return result;
    }

    

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        boolean result;

        result = numberOfEntries == 0;

        return result;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    
    
    @Override
    public String toString() {
        String outputStr = "";
        Node currentNode = firstNode;
        while (currentNode != null) {
            outputStr += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        return outputStr;
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    } // end Node

} // end LList
