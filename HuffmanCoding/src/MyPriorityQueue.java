
/*  Student information for assignment:
*
*  On MY honor, Wenjing Xie, this programming assignment is MY own work
*  and I have not provided this code to any other student.
*
*  Number of slip days used: 0
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
import java.util.LinkedList;


public class MyPriorityQueue<E extends Comparable<? super E>> {
	private LinkedList<E> storage;
	
	public MyPriorityQueue () {
		storage = new LinkedList<E>();
		
	}
	
	public void enqueue (E item) {
		Iterator<E> it = storage.descendingIterator();
		int index = storage.size(); 
		boolean isHere = false;
		while (it.hasNext() && !isHere) {
			if (item.compareTo(it.next()) >= 0) {
				isHere = true;
			}
			else {
				index--;
			}
		}
		storage.add(index, item);
	}
	
	public E front() {
		return storage.peek();
	}
	
	public E dequeue() {
		return storage.poll();
	}
	
	public boolean isEmpty() {
		return storage.isEmpty();
	}
	
	public int size() {
		return storage.size();
	}
}
