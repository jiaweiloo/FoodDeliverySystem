package adt;

import entity.employee;

/**
 * EmployeeADT.java is a class that implements the ADT list by using a chain of
 * nodes, with the node implemented as an inner class.
 */
public class EmployeeADT<T> implements EmployeeInterface<T> {

    private Node firstNode; // reference to first node
    private int numberOfEntries;  	// number of entries in list
    employee emp;
    private Node lastNode;

    public EmployeeADT() {
        clear();
    }

    @Override
    public final void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);	// create the new node

        if (isEmpty()) // if empty list
        {
            firstNode = newNode;
        } else {                        // add to end of nonempty list
            Node currentNode = firstNode;					// traverse linked list with p pointing to the current node
            while (currentNode.next != null) {		// while have not reached the last node
                currentNode = currentNode.next;
            }
            currentNode.next = newNode; // make last node reference new node
        }
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry) { // OutOfMemoryError possible
        boolean isSuccessful = true;

        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);

            if (isEmpty() || (newPosition == 1)) {     // case 1: add to beginning of list
                newNode.next = firstNode;
                firstNode = newNode;
            } else {								                      // case 2: list is not empty and newPosition > 1
                Node nodeBefore = firstNode;
                for (int i = 1; i < newPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
                }

                newNode.next = nodeBefore.next;	// make new node point to current node at newPosition
                nodeBefore.next = newNode;		// make the node before point to the new node
            }

            numberOfEntries++;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;                 // return value

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            if (givenPosition == 1) {      // case 1: remove first entry
                result = firstNode.data;     // save entry to be removed
                firstNode = firstNode.next;
            } else {                         // case 2: givenPosition > 1
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
                }
                result = nodeBefore.next.data;  // save entry to be removed
                nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the
            } 																// one to be deleted (to disconnect node from chain)

            numberOfEntries--;
        }

        return result;                   // return removed entry, or
        // null if operation fails
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                // System.out.println("Trace| currentNode.data = " + currentNode.data + "\t, i = " + i);
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            currentNode.data = newEntry;	// currentNode is pointing to the node at givenPosition
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
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
    public employee searchID(int ID) {
        boolean found = false;
        employee result = null;
        Node currentNode = firstNode;

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

    public employee searchString(String input) {
        boolean found = false;
        employee result = null;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            emp = (employee) currentNode.data;

            if (input.equals(emp.getEmail())) {
                System.out.println("[System] EmployeeADT.java : Email match!");
                found = true;
                result = emp;
            } 
            else if (input.equals(emp.getIc_number())) {
                System.out.println("[System] EmployeeADT.java : IC match!");
                found = true;
                result = emp;
            } 
            else if (input.equals(emp.getPhone_num())) {
                found = true;
                result = emp;
            } 
            else if (input.equals(emp.getAddress())) {
                found = true;
                result = emp;
            } 
            else {
                currentNode = currentNode.next;
            }            
        }

        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }

        return found;
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

    public boolean replaceObject(T oldEntry, T newEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        Node newNode = new Node(newEntry,null);
        
        while (!found && (currentNode != null)) {
            if (oldEntry.equals(currentNode.data)) {
                found = true;
                newNode.next = currentNode.next;
                currentNode = newNode;
            } else {
                currentNode = currentNode.next;
            }
        }
        return found;        
    }
    
     public void DailyReport(T newEntry) {
        boolean found = false;
        Node newNode = new Node(newEntry, null);
        
        employee newEmp = (employee) newEntry;
        Node currentNode = firstNode;
        
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
            found = true;
        }
        
        while(!found&&currentNode!=null){
            employee currentEmp = (employee)currentNode.data;
            
            if(newEmp.getYear_joined()<currentEmp.getYear_joined()){
                if(currentNode.next==null){
                    currentNode.next = newNode;
                    lastNode = newNode;
                    found = true;
                }else if(((employee)currentNode.next.data).getYear_joined()<newEmp.getYear_joined()){
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
     public boolean addByTaskHandled(T newEntry) {
        firstNode = addEmployee(newEntry, firstNode);
        numberOfEntries++;
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
