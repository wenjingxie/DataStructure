/*  Student information for assignment:
 *
 *  On MY honor, Wenjing Xie, this programming assignment is MY own work
 *  and I have not provided this code to any other student.
 *
 *  Number of slip days used: 2
 *
 *  Student 1 (Student whose turnin account is being used)
 *  UTEID: wx674
 *  email address: wenjing.xie@utexas.edu
 *  Grader name: Eric
 *  Section number: 90130
 *  
 *  Student 2 
 *  UTEID:
 *  email address:
 *  Grader name:
 *  Section number:
 *  
 */

import java.util.Iterator;
import java.util.ArrayList;

/**
 * A simple implementation of an ISet. 
 * Elements are not in any particular order.
 * Students are to implement methods that 
 * were not implemented in AbstractSet and override
 * methods that can be done more efficiently. 
 * An ArrayList must be used as the internal storage container.
 *
 */
public class UnsortedSet<E> extends AbstractSet<E> {
	private ArrayList<E> myCon;
    
	//constructor O(1)
	public UnsortedSet() {
		myCon = new ArrayList<E>();
	}
	
	//add O(N)
	public boolean add(E item) {
		//check precondition
		if (item == null) {
			throw new IllegalArgumentException("The item added could not be null!");
		}
		for (E val : myCon) {
			if (val.equals(item)) {
				return false;
			}
		}
		myCon.add(item);
		return true;
	}
	
	//addAll O(N^2)
	public boolean addAll(ISet<E> otherSet) {
		//check precondition
		if (otherSet == null) {
     		throw new IllegalArgumentException("The set added could not be null!");
		}
		boolean result = false;
		for (E val : otherSet) {
			if (add(val)) {
				result = true;
			}
		}
		return result;
	}
	
	//clear O(N)
	public void clear() {
		myCon.clear();
	}

	//difference O(N^2)
	public ISet<E> difference(ISet<E> otherSet) {
		//check precondition
		if (otherSet == null) {
     		throw new IllegalArgumentException("The set compared could not be null!");
		}
		
		UnsortedSet<E> diff = new UnsortedSet<E> ();
		for (E val : this) {
			if (!otherSet.contains(val)) {
				diff.myCon.add(val);
			}
		}
			
		return diff;
	}
	
	//intersection O(N^2)
	public ISet<E> intersection(ISet<E> otherSet) {
		//check precondition
		if (otherSet == null) {
     		throw new IllegalArgumentException("The set compared could not be null!");
		}
		
		UnsortedSet<E> inter = new UnsortedSet<E> ();
		for (E val : this) {
			if (otherSet.contains(val)) {
				inter.myCon.add(val);
			}
		}
			
		return inter;
	}		
	

	//iterator O(1)
	public Iterator<E> iterator() {
		return myCon.iterator();
	}

	//remove O(N)
	public boolean remove(E item) {
		//check precondition
		if (item == null) {
			throw new IllegalArgumentException("The item to be removed could not be null!");
		}	
		return myCon.remove(item);
	}

	//size O(1)
	public int size() {
		return myCon.size();
	}

	//union O(N^2)
	public ISet<E> union(ISet<E> otherSet) {
		//check precondition
		if (otherSet == null) {
     		throw new IllegalArgumentException("The set compared could not be null!");
		}
		
		UnsortedSet<E> uni = new UnsortedSet<E> ();
		for (E val : this) {
			uni.myCon.add(val);
		}
		
		for(E item : otherSet) {
			if (!uni.contains(item)) {
				uni.myCon.add(item);
			}
		}
		return uni;
	}
}
