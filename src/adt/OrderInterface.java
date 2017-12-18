/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Loi Kah Hou
 */
public interface OrderInterface<T> {

  /**
   * Task: Adds a new entry to the back of the queue.
   *
   * @param newEntry an object to be added
   */
  public void enqueue(T newEntry);
  public int size();

  /**
   * Task: Removes and returns the entry at the front of the queue.
   *
   * @return either the object at the front of the queue or, if the queue is
   * empty before the operation, null
   */
  public T dequeue();

  /**
   * Task: Retrieves the entry at the front of the queue.
   *
   * @return either the object at the front of the queue or, if the queue is
   * empty, null
   */
  public T getFront();

  /**
   * Task: Detects whether the queue is empty.
   *
   * @return true if the queue is empty, or false otherwise
   */
  public boolean isEmpty();

  /**
   * Task: Removes all entries from the queue.
   */
  public void clear();
  
  //and order and put highest total total amount order in front
  public void enqueueAscendingQueue(T newEntry);

  /**
   * Task: Replaces the entry at a given position in the list.
   *
   * @param oldEntry an entry that indicates the position of the entry to
   * be replaced
   * @param newEntry the object that will replace the entry at the position
   * givenPosition
   * @return true if the replacement occurs, or false if either the list is
   * empty or not found
   */
  public boolean replaceObject(T oldEntry, T newEntry);
  
} // end QueueInterface
