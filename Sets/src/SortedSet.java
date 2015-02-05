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
 * In this implementation of the ISet interface the elements in the Set are 
 * maintained in ascending order.
 * 
 * The data type for E must be a type that implements Comparable.
 * 
 * Students are to implement methods that were not implemented in AbstractSet 
 * and override methods that can be done more efficiently. An ArrayList must 
 * be used as the internal storage container. For methods involving two set, 
 * if that method can be done more efficiently if the other set is also a 
 * SortedSet do so.
 */
public class SortedSet<E extends Comparable<? super E>> extends AbstractSet<E> {

    private ArrayList<E> myCon;

    /**
     * create an empty SortedSet
     */
    public SortedSet() {
    	myCon = new ArrayList<E>();
    }

    /**
     * create a SortedSet out of an unsorted set. <br>
     * @param other != null
     */
    //O(NlogN)
    public SortedSet(ISet<E> other) {
    	//check precondition
    	if (other ==null) {
    		throw new IllegalArgumentException("The other set could not be null!");
    	}
    	myCon = new ArrayList<E>();
    	Iterator<E> it = other.iterator();
    	while (it.hasNext()) {
    		myCon.add(it.next());
    	}
    	if (!(other instanceof SortedSet<?>)){
            mergeSort(myCon);
    	}

    }
    
    
    //add O(N)
    public boolean add(E item) {
		//check precondition
		if (item == null) {
			throw new IllegalArgumentException("The item added could not be null!");
		}
    	if (myCon.size() == 0 || myCon.get(myCon.size() - 1).compareTo(item) < 0) {
    		myCon.add(item);
    		return true;
    	}
    	int index = -1;
    	int compare = -1;
    	Iterator<E> it = myCon.iterator();    	
    	while (it.hasNext() && compare < 0) {
    		compare = it.next().compareTo(item);
    		index++;
    	
    	}
    	if (compare == 0) {
    		return false;
    	}
    	else {
    		//insert the item, shift the elements larger than the item
    		myCon.add(myCon.get(myCon.size() - 1));
    		for(int i = myCon.size() - 1; i > index; i--) {
    			myCon.set(i, myCon.get(i - 1));
    		}
    		myCon.set(index, item);
    		return true;
    	}
    	
    }
    
    //addAll O(N)/O(NlogN)
    public boolean addAll(ISet<E> other) {
		//check precondition
		if (other == null) {
     		throw new IllegalArgumentException("The set added could not be null!");
		}
		SortedSet<E> otherSet;
		//if the other set is sorted
    	if (other instanceof SortedSet<?> ) {
    		otherSet = (SortedSet<E>) other;
    	}
    	//if it is unsorted, create a sorted set
    	else {
    		otherSet = new SortedSet<E>(other);//O(NlogN)

    	}
    	int iniSize = myCon.size();
    	myCon = unionSorted(otherSet);//using helper method for union
		return !(iniSize == myCon.size());
    }
    
    
    
    //clear O(N)
    public void clear() {
    	myCon.clear();
    }
    
    //contains O(logN)
    public boolean contains(E item) {
    	//check precondition
    	if (item == null) {
    		throw new IllegalArgumentException("The item could not be null!");
    	}
    	if (size() == 0) {
    		return false;
    	}
    	int low = 0;
    	int high = myCon.size() - 1;
    	int compare = myCon.get(low).compareTo(item) * myCon.get(high).compareTo(item);
    	//the item is not in the value range between the first and last element of this Set
    	if (compare > 0) {
    		return false;
    	}
    	//item equals first or last element
    	else if (compare == 0){
    		return true;
    	}
    	//item are in this range, using binary search
    	else {
    		return recursiveContains(item, low, high);
    	}
    }
     
    //helper method for contains, binary search, O(logN)
    private boolean recursiveContains(E item, int low, int high) {
    	//there are only two elements, and both of them do not equal item
    	if (high - low == 1) {
    		return false;
    	}
    	//find the center point
    	int center = (low + high)/2;
    	if (myCon.get(center).equals(item)) {
    		return true;
    	}
    	else {
    		//decide the new range to search
    		if (myCon.get(low).compareTo(item) * myCon.get(center).compareTo(item) > 0) {
        		return recursiveContains(item, center, high);
        	}
        	else {
        		return recursiveContains(item, low, center);
        	}
    	}   	
    }
    
    //containsAll O(N)/O(NlogN)
    public boolean containsAll(ISet<E> other) {
    	//check precondition
    	if (other == null) {
    		throw new IllegalArgumentException("The other set could not be null!");
    	}
    	if (size() < other.size()) {
    		return false;
    	}
    	SortedSet<E> otherSet;
    	if (other instanceof SortedSet<?>) {
    		otherSet = (SortedSet<E>) other;
    	}
    	else {
    		otherSet = new SortedSet<E>(other);//O(NlogN)
    	}
		return containsAllSorted(otherSet);
    }
    
    //helper method for containsAll, if other set is a SortedSet O(N)
    private boolean containsAllSorted(SortedSet<E> other) {
 	    int thisStart = 0;
 	    int thisEnd = myCon.size() - 1;
 	    int otherStart = 0;
 	    int otherEnd = other.size() - 1;
 	    //go through two sets
 	    while (thisStart <= thisEnd && otherStart <= otherEnd) {
 	    	int compare = myCon.get(thisStart).compareTo(other.myCon.get(otherStart));
 	    	if (compare < 0) {
 	    		thisStart++;
 	    	}
 	    	else if (compare > 0) {
 	    		return false;
 	    	}
 	    	else {
 	    		thisStart++;
 	    		otherStart++;
 	    	}
 	    }
 	    //if there are left elements in otherSet, return false
 	    if (otherStart <= otherEnd) {
 	    	return false;
 	    }
 	    return true;
    	
    }
    
    //difference O(N)/O(NlogN)
    public ISet<E> difference(ISet<E> other) {
    	//check precondition
    	if (other == null) {
    		throw new IllegalArgumentException("The other set could not be null!");
    	}
    	SortedSet<E> otherSet;
    	
    	if (other.getClass().equals(this.getClass())) {
    		otherSet = (SortedSet<E>) other;
    	}
    	else {
    		otherSet = new SortedSet<E>(other);//O(NlogN)   		
    	}
    	return differenceSorted(otherSet);
    }
    
    //helper method for difference, if other set is a SortedSet O(N)
    private ISet<E> differenceSorted(SortedSet<E> other) {	   
	    SortedSet<E> result = new SortedSet<E>();
	    int thisStart = 0;
	    int thisEnd = myCon.size() - 1;
	    int otherStart = 0;
	    int otherEnd = other.size() - 1;
	    //go through two sets
	    while (thisStart <= thisEnd && otherStart <= otherEnd) {
	    	int compare = myCon.get(thisStart).compareTo(other.myCon.get(otherStart));
	    	if (compare < 0) {
	    		result.myCon.add(myCon.get(thisStart));//find difference
	    		thisStart++;
	    	}
	    	else if (compare > 0) {
	    		otherStart++;
	    	}
	    	else {
	    		thisStart++;
	    		otherStart++;
	    	}
	    }
	    //add the left elements from this set
	    while (thisStart <= thisEnd) {
	    	result.myCon.add(myCon.get(thisStart));
	    	thisStart++;
	    }

	    return result;
    }
    
    
    //equals O(N)
    public boolean equals(Object other) {
    	if (other == null) {
    		return false;
    	}
    	else if (!(other instanceof ISet<?>)) {
    		return false;
    	}
    	else {
    		ISet<?> otherSet = (ISet<?>) other; //cast other to ISet
    		if (size() != otherSet.size()) {
    			return false;
    		}
    		else {
    			Iterator<E> it = iterator();
    			Iterator<?> itOther = otherSet.iterator();
    			while (it.hasNext()) {
    				if (!it.next().equals(itOther.next())) {
    					return false;
    				}
    			}
    			return true;
    		}
    	}
    }
    
    
    //intersection O(N)/O(NlogN)
    public ISet<E> intersection(ISet<E> other) {
    	//check precondition
    	if (other == null) {
    		throw new IllegalArgumentException("The other set could not be null!");
    	}
    	SortedSet<E> otherSet;
    	if (other.getClass() == this.getClass()) {
    		otherSet = (SortedSet<E>) other;
    	}
    	else {
    		otherSet = new SortedSet<E>(other);//O(NlogN)
    	}
		return intersectionSorted(otherSet);
    	
    }
    
    //helper method for intersection, when the other set is SortedSet O(N)
    private ISet<E> intersectionSorted(SortedSet<E> other) {
    	SortedSet<E> result = new SortedSet<E>();
	    int thisStart = 0;
	    int thisEnd = myCon.size() - 1;
	    int otherStart = 0;
	    int otherEnd = other.size() - 1;
	    //go through two sets
	    while (thisStart <= thisEnd && otherStart <= otherEnd) {
	    	int compare = myCon.get(thisStart).compareTo(other.myCon.get(otherStart));
	    	if (compare < 0) {
	    		thisStart++;
	    	}
	    	else if (compare > 0) {
	    		otherStart++;
	    	}
	    	else {
	    		result.myCon.add(myCon.get(thisStart));//add the intersected element
	    		thisStart++;
	    		otherStart++;
	    	}
	    }
	    return result;
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
    
    //union O(N)/O(NlogN)
    public ISet<E> union(ISet<E> other) {
       	//check precondition
    	if (other == null) {
    		throw new IllegalArgumentException("The other set could not be null!");
    	}
    	SortedSet<E> otherSet;
    	if (other.getClass() == this.getClass()) {
    		otherSet = (SortedSet<E>) other;

    	}
    	else {
    		otherSet = new SortedSet<E>(other);//O(NlogN)
    	}
    	SortedSet<E> result = new SortedSet<E>();
    	result.myCon = unionSorted(otherSet); 
		return result; 
    }
    
    //helper method for union, when the other set is SortedSet; using modified merge algorithm, O(N)
    private ArrayList<E> unionSorted(SortedSet<E> other) {
    	ArrayList<E> result = new ArrayList<E>();
	    int thisStart = 0;
	    int thisEnd = myCon.size() - 1;
	    int otherStart = 0;
	    int otherEnd = other.size() - 1;
	    //go through two sets
	    while (thisStart <= thisEnd && otherStart <= otherEnd) {
	    	int compare = myCon.get(thisStart).compareTo(other.myCon.get(otherStart));
	    	if (compare < 0) {
	    		result.add(myCon.get(thisStart));
	    		thisStart++;
	    	}
	    	else if (compare > 0) {
	    		result.add(other.myCon.get(otherStart));
	    		otherStart++;
	    	}
	    	else {
	    		result.add(myCon.get(thisStart));
	    		thisStart++;
	    		otherStart++;
	    	}
	    }
	    //add all the left elements from this set
	    while (thisStart <= thisEnd) {
	    	result.add(myCon.get(thisStart));
	    	thisStart++;
	    }
	    //add all the left elements from the other set
	    while (otherStart <= otherEnd) {
	    	result.add(other.myCon.get(otherStart));
	    	otherStart++;
	    }
	    return result;
    }
    
    
    /**
     * Return the smallest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the smallest element in this SortedSet.
     */
    //O(1)
    public E min() {
    	//check precondition
    	if (size() == 0) {
    		throw new IllegalArgumentException ("The size could not be zero!");
    	}

    	return myCon.get(0);
    }

    /**
     * Return the largest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the largest element in this SortedSet.
     */
    //O(1)
    public E max() {
    	//check precondition
    	if (size() == 0) {
    		throw new IllegalArgumentException ("The size could not be zero!");
    	}

    	return myCon.get(myCon.size() - 1);
    }

    // merge sort O(NlogN), from class slides
    private void mergeSort(ArrayList<E> unsorted) {
    	ArrayList<E> temp = new ArrayList<E>();
    	sort(unsorted, temp, 0, unsorted.size() - 1);
    }
    
    
    //recursive merge sort O(NlogN), from class slides
    private void sort(ArrayList<E> unsorted, ArrayList<E> temp, int low, int high) {
    	if (low < high) {
    		int center = (low + high)/2;
    		sort(unsorted, temp, low, center);
    		sort(unsorted, temp, center + 1, high);
    		merge(unsorted, temp, low, center + 1, high);
    	}
    }
    
    //helper method for merge two sorted sets O(N), from class slides
    private void merge(ArrayList<E> unsorted, ArrayList<E> temp, int low, int highStart, int high) {
    	temp.clear();
    	int lowEnd = highStart - 1;
    	int dataLength = high - low + 1;
    	int index = low;
    	while (low <= lowEnd && highStart <= high) {
    		if (unsorted.get(low).compareTo(unsorted.get(highStart)) <= 0) {
    			temp.add(unsorted.get(low));
    			low++;
    			
    		}
    		else {
    			temp.add(unsorted.get(highStart));
    			highStart++;
    		}
    		  		
    	}
    	while (low <= lowEnd) {
    		temp.add(unsorted.get(low));
			low++;
			
    	}
    	while (highStart <= high) {
    		temp.add(unsorted.get(highStart));
			highStart++;
			
    	}
    	for (int i = index; i < dataLength + index; i++) {
    		unsorted.set(i, temp.get(i - index));
    	}
    }
}
