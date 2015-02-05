/*  Student information for assignment:
 *
 *  On my honor, Wenjing Xie, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Wenjing Xie
 *  email address: wenjing.xie@utexas.edu
 *  UTEID: wx674
 *  Section 5 digit ID: 90130
 *  Grader name: Eric
 *  Number of slip days used on this assignment: 0
 */

import java.util.Iterator;

public class LinkedList<E> implements IList<E> {
    // CS314 student. Add you instance variables here.
    // You decide what instance variables to use. 
    // Must adhere to assignment requirements. No ArrayLists or Java LinkedLists.
	private int size;
	private DoubleListNode<E> dummy;
	
	public LinkedList() {
		size = 0;
		dummy = new DoubleListNode<E> ();
		dummy.setPrev(dummy);
		dummy.setNext(dummy);
	}
	
    
    private class LLIterator implements Iterator<E>{
    	//instance variables
    	private DoubleListNode<E> nodeWithNextData;
    	private boolean removeOk;
    	private int indexToRemove;
    	
    	//constructor
    	private LLIterator () {
    		nodeWithNextData = dummy.getNext();
    		removeOk = false;
    		indexToRemove = -1;
    	}
    	
        //O(1)
    	public boolean hasNext() {
        	return (nodeWithNextData != dummy);
        }
        
    	//O(1)
        public E next() {
        	E result = nodeWithNextData.getData();
        	nodeWithNextData = nodeWithNextData.getNext();
        	indexToRemove++;
        	removeOk = true;
        	return result;
        }
       
        //O(1)
        public void remove() {
        	if (!removeOk)
        		throw new IllegalStateException("The next method has not yet been called, "
        				+ "or the remove method has already been called after the last call to the next method.");
        	
        	DoubleListNode<E> toRemove = nodeWithNextData.getPrev();
        	toRemove.getPrev().setNext(nodeWithNextData);
        	nodeWithNextData.setPrev(toRemove.getPrev());
        	
    		toRemove.setData(null);
    		toRemove.setNext(null);
    		toRemove.setPrev(null);
        	
        	removeOk = false;
        	indexToRemove--;
        	size--;
        }
    }
    
    //O(1)
	public void add(E item){
		//check precondition: item != null
		if (item == null)
			throw new IllegalArgumentException("The item added could not be null!");
		
		DoubleListNode<E> newNode = new DoubleListNode<E> (dummy.getPrev(), item, dummy);
		dummy.getPrev().setNext(newNode);
		dummy.setPrev(newNode);
		size++;
	}

	//O(N)
	private DoubleListNode<E> getNodeAtIndex(int index) {
		//check precondition: 0 <= index <= size()
		if (index < 0 || index > size) 
			throw new IllegalArgumentException("The index is out of bounds of this list!");
		
		DoubleListNode<E> temp;
		
		if (index < size/2) {
			temp = dummy.getNext();
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
		}
		
		else {
			temp = dummy;
			for (int i = size; i > index; i--) {
				temp = temp.getPrev();
			}
		}
				
		return temp;
	}
	
	
	//O(N)
	public void insert(int pos, E item){
		//check precondition: 0 <= pos <= size()
		if (pos < 0 || pos > size) 
			throw new IllegalArgumentException("The index is out of bounds of this list!");
		
		DoubleListNode<E> NodeAtPos = getNodeAtIndex(pos);
		DoubleListNode<E> insertNode = new DoubleListNode<E> (NodeAtPos.getPrev(), item, NodeAtPos);
		NodeAtPos.getPrev().setNext(insertNode);
		NodeAtPos.setPrev(insertNode);
		size++;

	}

	//O(N)
	public E set(int pos, E item){
		//check precondition: 0 <= pos < size(), item != null
		if (pos < 0 || pos >= size || item == null) 
			throw new IllegalArgumentException("The index is out of bounds of this list or the item to be set is null!");
		
		DoubleListNode<E> nodeAtPos = getNodeAtIndex(pos);
		E oldData = nodeAtPos.getData();
		nodeAtPos.setData(item);
		return oldData;
	}

	//O(N)
	public E get(int pos){
		//check precondition: 0 <= pos < size()
		if (pos < 0 || pos >= size) 
			throw new IllegalArgumentException("The index is out of bounds of this list!");
		
		return getNodeAtIndex(pos).getData();
	}

	
	//O(N)
	public E remove(int pos){
		//check precondition: 0 <= pos < size()
		if (pos < 0 || pos >= size) 
			throw new IllegalArgumentException("The index is out of bounds of this list!");
		
		DoubleListNode<E> toRemove = getNodeAtIndex(pos);
		E data = toRemove.getData();
		toRemove.getPrev().setNext(toRemove.getNext());
		toRemove.getNext().setPrev(toRemove.getPrev());
		size--;
		
		toRemove.setData(null);
		toRemove.setNext(null);
		toRemove.setPrev(null);
		return data;
	}

	//O(N)
	public boolean remove(E obj){
		if (obj == null)
			throw new IllegalArgumentException("The item to be removed could not be null!");
		
		Iterator<E> it = iterator();
		while (it.hasNext()) {
			if (it.next() == obj) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	
	//O(N)
	public IList<E> getSubList(int start, int stop){
		//check precondition: 0 <= start < size(), start <= stop <= size()
		if (start < 0 || start >= size || stop < start || stop > size) 
			throw new IllegalArgumentException("The index range of this sublist is illegal!");	
		
		LinkedList<E> subList = new LinkedList<E> ();
		DoubleListNode<E> temp = dummy;
		if (start < size/2) {
			for (int i = 0; i < start; i++) {
				temp = temp.getNext();
			}
			for (int i = start; i < stop; i++) {
				temp = temp.getNext();
				subList.addLast(temp.getData());
			}
		}
		else {
			for (int i = size -1; i > stop - 1; i--) {
				temp = temp.getPrev();
			}
			for (int i = stop - 1; i > start - 1; i--) {
				temp = temp.getPrev();
				subList.addFirst(temp.getData());
			}
		}
		return subList;
	}

	//O(1)
	public int size(){
		return size;
	}

	//O(N)
	public int indexOf(E item){
		if (item == null) 
			throw new IllegalArgumentException("The item could not be null!");
		
		if(size == 0) {
			return -1;
		}
		
		return indexOf(item, 0);
	}

	
	//O(N)
	public int indexOf(E item, int pos){
		if (item == null || pos < 0 || pos >= size) 
			throw new IllegalArgumentException("The item is null or the pos is out of bounds for the list!");
		
		DoubleListNode<E> temp = getNodeAtIndex(pos);
		for (int i = pos; i < size; i++) {
			if (temp.getData() == item) {
				return i;
			}
			temp = temp.getNext();
		}
		return -1;		
	}

	
	//O(N)
	public void makeEmpty(){
		DoubleListNode<E> temp = dummy.getNext();
		while (temp.getNext() != dummy) {
			DoubleListNode<E> trailer = temp;
			temp = temp.getNext();
			trailer.setData(null);
			trailer.setNext(null);
			trailer.setPrev(null);
		}
		size = 0;
		dummy.setNext(dummy);
        dummy.setPrev(dummy);
	}

	
	public Iterator<E> iterator(){
		return new LLIterator();
	}
	
	//O(N)
    public void removeRange(int start, int stop){
    	if (start < 0 || start >= size || stop < start || stop > size) 
			throw new IllegalArgumentException("The index range of this sublist is illegal!");
    	
    	if (stop > start) {
    		DoubleListNode<E> startNode = getNodeAtIndex(start);
        	DoubleListNode<E> stopNode = getNodeAtIndex(stop - 1);
        	startNode.getPrev().setNext(stopNode.getNext());
        	stopNode.getNext().setPrev(startNode.getPrev());
        	size = size - stop + start;   
        	
        	//set nodes removed to be null
        	DoubleListNode<E> temp;
        	for (int i = start; i < stop; i++) {
        		temp = startNode;
        		startNode = startNode.getNext();
        		temp.setData(null);
        		temp.setNext(null);
        		temp.setPrev(null);
        	}
    	}
    	
    }
	
	/**
	 * add item to the front of the list.
	 * <br>pre: item != null
	 * <br>post: size() = old size() + 1, get(0) = item
	 * @param item the data to add to the front of this list
	 */
    //O(1)
	public void addFirst(E item){
		if (item == null)
			throw new IllegalArgumentException("The item added could not be null!");
		
		DoubleListNode<E> newNode = new DoubleListNode<E> (dummy, item, dummy.getNext());
		dummy.getNext().setPrev(newNode);
		dummy.setNext(newNode);
		size++;
	}


	/**
	 * add item to the end of the list.
	 * <br>pre: item != null
	 * <br>post: size() = old size() + 1, get(size() -1) = item
	 * @param item the data to add to the end of this list
	 */
	//O(1)
	public void addLast(E item){
		if (item == null)
			throw new IllegalArgumentException("The item added could not be null!");
		add(item);
	}


	/**
	 * remove and return the first element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old first element of this list
	 */
	//O(1)
	public E removeFirst(){	
		if (size == 0)
			throw new UnsupportedOperationException("The LinkedList could not be empty!");
		
	    return remove(0);
	}


	/**
	 * remove and return the last element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old last element of this list
	 */
	//O(1)
	public E removeLast(){	
		if (size == 0)
			throw new UnsupportedOperationException("The LinkedList could not be empty!");
			
		return remove(size - 1);
	}

    //O(N)
	public String toString(){	
		StringBuilder sb = new StringBuilder("[");
		Iterator<E> it = this.iterator();
		if (it.hasNext()) {
			sb.append(it.next());
		}
		while (it.hasNext()) {
			sb.append(", ");
			sb.append(it.next());			
		}
		sb.append("]");
	    return sb.toString();
	}


	/**
	 * Check if this list is equal to another Object.
	 * Follow the contract of IList
	 * <br>pre: none
	 * @return true if other is a non null IList object
	 * with the same elements as this LinkedList in the same
	 * order.
	 */
	
	//O(N)
	public boolean equals(Object other){
		boolean result = other != null;
		if (result) {
			if (this.getClass() != other.getClass()) {
				result = false;
			}
			else {
				LinkedList<?> otherList = (LinkedList<?>) other;
				if (this.size() != otherList.size()) {
					result = false;
				}
				else {
					Iterator<?> itThis = this.iterator();
					Iterator<?> itOther = otherList.iterator();
					while (itThis.hasNext() && result) {
						if (!itThis.next().equals(itOther.next())) {
							result = false;
						}
					}
				}
			}
		}
		
	    return result;
	}


}