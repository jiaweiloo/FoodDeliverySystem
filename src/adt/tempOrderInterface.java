package adt;

import entity.tempItem;

/**
 * ListInterface.java An interface for the ADT list. Entries in the list have
 * positions that begin with 1.
 *
 * @author Frank M. Carrano
 * @version 2.0
 */
public interface tempOrderInterface<T> {

  /**
   * Task: Adds a new entry to the end of the list. Entries currently in the
   * list are unaffected. The list's size is increased by 1.
   *
   * @param newEntry the object to be added as a new entry
   * @return true if the addition is successful, or false if the list is full
   */

  
  public void clear();

  /**
   * Task: Replaces the entry at a given position in the list.
   *
   * @param givenPosition an integer that indicates the position of the entry to
   * be replaced
   * @param newEntry the object that will replace the entry at the position
   * givenPosition
   * @return true if the replacement occurs, or false if either the list is
   * empty, givenPosition < 1, or givenPosition > getLength()
   */
  public boolean add(T newEntry);
  
  public void ArrangeAZ(T newEntry);
  public void ArrangeZA(T newEntry);
  public void ArrangePriceAZ(T newEntey);
  public void ArrangePriceZA(T newEntey);
  public void ArrangeSummer(T newEntry);
  public void ArrangeSpring(T newEntry);
  public void ArrangeWinter(T newEntey);
  public void ArrangeAutumn(T newEntey);
  /**
   * Task: Adds a new entry at a specified position within the list. Entries
   * originally at and above the specified position are at the next higher
   * position within the list. The list's size is increased by 1.
   *
   * @param newPosition an integer that specifies the desired position of the
   * new entry
   * @param newEntry the object to be added as a new entry
   * @return true if the addition is successful, or false if either the list is
   * full, newPosition < 1, or
   *          newPosition > getLength()+1
   */
  public T getEntry(int givenPosition);

  /**
   * Task: Sees whether the list contains a given entry.
   *
   * @param anEntry the object that is the desired entry
   * @return true if the list contains anEntry, or false if not
   */
 
  public int getNumberOfEntries();

  /**
   * Task: Sees whether the list is empty.
   *
   * @return true if the list is empty, or false if not
   */
  public boolean isEmpty();

  /**
   * Task: Sees whether the list is full.
   *
   * @return true if the list is full, or false if not
   */
  public boolean isFull();
  
  /**
   * Task: Search employee handled list with employee id
   *
   * @return emp_handled_list object
   */
 
}
