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

/**
 * Students are to complete this class. 
 * Students should implement as many methods
 * as they can using the Iterator from the iterator 
 * method and the other methods. 
 *
 */
public abstract class AbstractSet<E> implements ISet<E> {

    /* NO INSTANCE VARIABLES ALLOWED.
     * NO DIRECT REFERENCE TO UnsortedSet OR SortedSet ALLOWED.
     * (In other words the data types UnsortedSet and SortedSet
     * will not appear any where in this class.)
     * Also no direct references to ArrayList or other Java Collections.
     */
    
	//O(N)
    public boolean contains(E item) {
    	//check precondition
    	if (item == null) {
    		throw new IllegalArgumentException("The item could not be null!");
    	}
    	
    	for (E val : this) {
    		if (val.equals(item)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    //O(N^2)
    public boolean containsAll(ISet<E> otherSet) {
    	//check precondition
    	if (otherSet == null) {
    		throw new IllegalArgumentException("The otherSet could not be null!");
    	}
    	for (E val : otherSet) {
    		if (!contains(val)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    
    public ISet<E> intersection(ISet<E> otherSet) {
		//check precondition
		if (otherSet == null) {
     		throw new IllegalArgumentException("The set compared could not be null!");
		}
	    	
    	ISet<E> result = difference(this);
    	for (E val : this) {
    		if (otherSet.contains(val)) {
    			result.add(val);
    		}
    	}
    	return result;
    }
    
    //O(N^2)
    public boolean equals(Object other) {
    	if (other == null || !(other instanceof ISet<?>)) {
    		return false;
    	}
    	
    	ISet<?> otherSet = (ISet<?>) other;
    	
    	if (this.size() != otherSet.size()) {
    		return false;
    	}
    	
    	for (E val : this) {
    	    Iterator<?> it = otherSet.iterator();
    	    boolean findEqual = false;
    	    while (it.hasNext() && !findEqual) {   	    	
    		    if (it.next() == val) {
    			    findEqual = true;
    		    }
    	    }
    	    if (!findEqual) {
    	    	return false;
    	    }
    	}
    	return true;
    }
    
    //O(N)
    public String toString() {
        StringBuilder result = new StringBuilder();
        String seperator = ", ";
        result.append("(");

        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            result.append(it.next());
            result.append(seperator);
        }
        // get rid of extra separator
        if (this.size() > 0)
            result.setLength(result.length() - seperator.length());

        result.append(")");
        return result.toString();
    }
}
