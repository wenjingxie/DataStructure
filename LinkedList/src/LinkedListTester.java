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

// Experiment results. CS314 students, place your experiment
// results here:
/* For ArrayList based: Getting random and Getting all using get method are faster.
 * For LinkedList based: Adding at front and Removing from front are faster.
 * Adding at end, and Getting all using iterator are about the same.
 * 
 * ----------------------Big O--------
 * According to the timing data, when N doubles, we could find the change of time
 * to estimate the big O of each method.
 *                                    ArrayList             LinkedList
 * Adding at end                         O(1)                   O(1)
 * Adding at front                       O(N)                   O(1)
 * Removing from front                   O(N)                   O(1)
 * Getting random                        O(1)                   O(N)
 * Getting all using iterator(getNext)   O(1)                   O(1)
 * Getting all using get method(get)     O(1)                   O(N)
 * 
 * As this is a double linked list,  the big O of adding at front, adding at end and removing from front 
 * are all O(1). The double linked list could get the node at front and end using constant time. 
 * For getting random, the linked list must start from the front or end to reach the node, thus, the big O is O(N).
 * The difference between getting all using iterator and using get method is that using iterator could keep 
 * the position of last node. However, using get method, the program needs to start from the first node every time.
 * 
 * 
 * For ArrayList, adding at front and removing from front need to shift every element after adding or removing. Thus, 
 * these two methods consume more time than LinkedList. But the advantage of ArrayList is that it cost constant time 
 * to get any element of the list. So the big O of getting all using iterator and using get method are both O(N). 
 */



import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class LinkedListTester {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<String>();
        LinkedList<Integer> intList = new LinkedList<Integer>();
        LinkedList<ArrayList<Integer>> arrayLinkedList = new LinkedList<ArrayList<Integer>>();
        //CS314 students. Add your tests here:

        //add method, test 0.0
        System.out.println("\nTest 0.0: add method");
        list.add("asd");
        if( list.toString().equals("[asd]") && list.size() == 1)
            System.out.println("Passed test 0");
        else
            System.out.println("Failed test 0");

        //add method, test 0.1
        System.out.println("\nTest 0.1: add method");
        list.add("A");
        if( list.toString().equals("[asd, A]") && list.size() == 2)
            System.out.println("Passed test 0.1");
        else
            System.out.println("Failed test 0.1");  

        //add method, test 0.2
        System.out.println("\nTest 0.2: add method");
        intList.add(1);
        intList.add(-5);
        if( intList.toString().equals("[1, -5]") && intList.size() == 2 )
            System.out.println("Passed test 0.2");
        else
            System.out.println("Failed test 0.2"); 
        
      //add method, test 0.3
        System.out.println("\nTest 0.3: add method");
        ArrayList<Integer> arraylist1 = new ArrayList<Integer>();
        ArrayList<Integer> arraylist2 = new ArrayList<Integer>();
        arraylist1.add(1);
        arraylist1.add(90);
        arraylist1.add(243);
        arrayLinkedList.add(arraylist1);
        arrayLinkedList.add(arraylist2);
        if( arrayLinkedList.toString().equals("[[1, 90, 243], []]") && intList.size() == 2 )
            System.out.println("Passed test 0.3");
        else
            System.out.println("Failed test 0.3"); 

        //insert method, test 1.0
        System.out.println("\nTest 1.0: insert method");
        list.insert(0, "first");
        if(list.toString().equals("[first, asd, A]") && list.size() == 3)
            System.out.println("Passed test 1.0");
        else
            System.out.println("Failed test 1.0");            

        //insert method, test 1.1
        System.out.println("\nTest 1.1: insert method");
        list.insert(3, "last");
        if(list.toString().equals("[first, asd, A, last]") && list.size() == 4)
            System.out.println("Passed test 1.1");
        else
            System.out.println("Failed test 1.1");  

        //insert method, test 1.2
        System.out.println("\nTest 1.2: insert method");
        list.insert(3, "last");
        if(list.toString().equals("[first, asd, A, last, last]") && list.size() == 5)
            System.out.println("Passed test 1.2");
        else
            System.out.println("Failed test 1.2"); 

        //set method, test 2.0
        System.out.println("\nTest 2.0: set method");
        String old0 = list.set(0, "cs");
        String old3 = list.set(3, "mse");
        if( list.toString().equals("[cs, asd, A, mse, last]") && list.size() == 5
        		&& old0.equals("first") && old3.equals("last"))
            System.out.println("Passed test 2.0");
        else
            System.out.println("Failed test 2.0");  

        //set method, test 2.1
        System.out.println("\nTest 2.1: set method");
        list = new LinkedList<String>();
        list.add("Month");
        old0 = list.set(0, "Date");
        if( list.toString().equals("[Date]") && list.size() == 1
        		&& old0.equals("Month"))
            System.out.println("Passed test 2.1");
        else
            System.out.println("Failed test 2.1");
        
        //set method, test 2.2
        System.out.println("\nTest 2.2: set method");
        list.insert(1, "joke");
        String old1 = list.set(1, "Joke");
        if( list.toString().equals("[Date, Joke]") && list.size() == 2
        		&& old1.equals("joke") )
            System.out.println("Passed test 2.2");
        else
            System.out.println("Failed test 2.2");
        
      //get method, test 3.0
        System.out.println("\nTest 3.0: get method");
        String get = list.get(0);
        if( list.toString().equals("[Date, Joke]") && list.size() == 2
        		&& get.equals("Date") )
            System.out.println("Passed test 3.0");
        else
            System.out.println("Failed test 3.0");

      //get method, test 3.1
        System.out.println("\nTest 3.1: get method");
        list.add("Lake");
        get = list.get(2);
        if( list.toString().equals("[Date, Joke, Lake]") && list.size() == 3
        		&& get.equals("Lake") )
            System.out.println("Passed test 3.1");
        else
            System.out.println("Failed test 3.1");
        
        //get method, test 3.2
        System.out.println("\nTest 3.1: get method");
        list.insert(1, "Austin");
        get = list.get(2);
        if( list.toString().equals("[Date, Austin, Joke, Lake]") && list.size() == 4
        		&& get.equals("Joke") )
            System.out.println("Passed test 3.2");
        else
            System.out.println("Failed test 3.2");       
        
        //remove method, test 4.0
        System.out.println("\nTest 4.0: remove method");
        String remove = list.remove(0);
        if( list.toString().equals("[Austin, Joke, Lake]") && list.size() == 3
        		&& remove.equals("Date") )
            System.out.println("Passed test 4.0");
        else
            System.out.println("Failed test 4.0");
        
        //remove method, test 4.1
        System.out.println("\nTest 4.1: remove method");
        remove = list.remove(2);
        if( list.toString().equals("[Austin, Joke]") && list.size() == 2
        		&& remove.equals("Lake") )
            System.out.println("Passed test 4.1");
        else
            System.out.println("Failed test 4.1");
        
        //remove method, test 4.2
        System.out.println("\nTest 4.2: remove method");
        remove = list.remove(0);
        if( list.toString().equals("[Joke]") && list.size() == 1
        		&& remove.equals("Austin") )
            System.out.println("Passed test 4.2");
        else
            System.out.println("Failed test 4.2");   
        
        
        //remove method, test 4.3
        System.out.println("\nTest 4.3: remove method");
        list.add("Kate");
        list.add("Pork");
        boolean isRemove = list.remove("Joke");
        if( list.toString().equals("[Kate, Pork]") && list.size() == 2
        		&& isRemove == true )
            System.out.println("Passed test 4.3");
        else
            System.out.println("Failed test 4.3");
        
        
        
        //remove method, test 4.4
        System.out.println("\nTest 4.4: remove method");
        isRemove = list.remove("Joke");
        if( list.toString().equals("[Kate, Pork]") && list.size() == 2
        		&& isRemove == false )
            System.out.println("Passed test 4.4");
        else
            System.out.println("Failed test 4.4");
        
        //remove method, test 4.5
        System.out.println("\nTest 4.5: remove method");
        isRemove = list.remove("Kate");
        isRemove = list.remove("Pork");
        if( list.toString().equals("[]") && list.size() == 0
        		&& isRemove == true )
            System.out.println("Passed test 4.5");
        else
            System.out.println("Failed test 4.5");
        
        
        
        //getSubList method, test 5.0
        System.out.println("\nTest 5.0: getSubList method");
        list.add("Kate");
        list.add("Pork");
        list.insert(0, "Opps");
        list.insert(3, "UT");
        LinkedList<String> subList = (LinkedList<String>) list.getSubList(0,3);
        if(subList.toString().equals("[Opps, Kate, Pork]") && subList.size() == 3)
            System.out.println("Passed test 5.0");
        else
            System.out.println("Failed test 5.0");
        
     
        
        //getSubList method, test 5.1
        System.out.println("\nTest 5.1: getSubList method");
        subList = (LinkedList<String>) list.getSubList(0,4);
        if(subList.toString().equals("[Opps, Kate, Pork, UT]") && subList.size() == 4)
            System.out.println("Passed test 5.1");
        else
            System.out.println("Failed test 5.1");
        
      
        //getSubList method, test 5.2
        System.out.println("\nTest 5.2: getSubList method");
        subList = (LinkedList<String>) list.getSubList(0,0);
        if(subList.toString().equals("[]") && subList.size() == 0)
            System.out.println("Passed test 5.2");
        else
            System.out.println("Failed test 5.2");
        
        //getSubList method, test 5.3
        System.out.println("\nTest 5.3: getSubList method");
        subList = (LinkedList<String>) list.getSubList(0,1);
        if(subList.toString().equals("[Opps]") && subList.size() == 1)
            System.out.println("Passed test 5.3");
        else
            System.out.println("Failed test 5.3");
        
        
        //size method, test 6.0
        System.out.println("\nTest 6.0: size method");
        if(list.toString().equals("[Opps, Kate, Pork, UT]") && list.size() == 4)
            System.out.println("Passed test 6.0");
        else
            System.out.println("Failed test 6.0");
        
        
        //size method, test 6.1
        System.out.println("\nTest 6.1: size method");
        list.add("ok");
        if(list.toString().equals("[Opps, Kate, Pork, UT, ok]") && list.size() == 5)
            System.out.println("Passed test 6.1");
        else
            System.out.println("Failed test 6.1");
        
        
        //size method, test 6.2
        System.out.println("\nTest 6.2: size method");
        list = new LinkedList<String> ();
        if(list.toString().equals("[]") && list.size() == 0)
            System.out.println("Passed test 6.2");
        else
            System.out.println("Failed test 6.2");
        
        
        //indexOf method, test 7.0
        System.out.println("\nTest 7.0: indexOf method");
        int index = list.indexOf("ok");
        if(list.toString().equals("[]") && list.size() == 0 && index == -1)
            System.out.println("Passed test 7.0");
        else
            System.out.println("Failed test 7.0");
        
        //indexOf method, test 7.1
        System.out.println("\nTest 7.1: indexOf method");
        list.add("ok");
        list.add("ok");
        list.add("ok");
        index = list.indexOf("ok");
        if(list.toString().equals("[ok, ok, ok]") && list.size() == 3 && index == 0)
            System.out.println("Passed test 7.1");
        else
            System.out.println("Failed test 7.1"); 
        
      //indexOf method, test 7.2
        System.out.println("\nTest 7.2: indexOf method");
        list.insert(0, "lol");
        index = list.indexOf("ok");
        if(list.toString().equals("[lol, ok, ok, ok]") && list.size() == 4 && index == 1)
            System.out.println("Passed test 7.2");
        else
            System.out.println("Failed test 7.2"); 
        
        //indexOf method, test 7.3
        System.out.println("\nTest 7.3: indexOf method");
        index = list.indexOf("ok", 1);
        if(list.toString().equals("[lol, ok, ok, ok]") && list.size() == 4 && index == 1)
            System.out.println("Passed test 7.3");
        else
            System.out.println("Failed test 7.3"); 
        
        //indexOf method, test 7.4
        System.out.println("\nTest 7.4: indexOf method");
        index = list.indexOf("ok", 3);
        if(list.toString().equals("[lol, ok, ok, ok]") && list.size() == 4 && index == 3)
            System.out.println("Passed test 7.4");
        else
            System.out.println("Failed test 7.4"); 
        
        //indexOf method, test 7.5
        System.out.println("\nTest 7.5: indexOf method");
        list.add("last");
        index = list.indexOf("ok", 4);
        if(list.toString().equals("[lol, ok, ok, ok, last]") && list.size() == 5 && index == -1)
            System.out.println("Passed test 7.5");
        else
            System.out.println("Failed test 7.5"); 
        
        
        //makeEmpty method, test 8.0
        System.out.println("\nTest 8.0: makeEmpty method");
        list.makeEmpty();
        if(list.toString().equals("[]") && list.size() == 0)
            System.out.println("Passed test 8.0");
        else
            System.out.println("Failed test 8.0"); 
        
        //makeEmpty method, test 8.1
        System.out.println("\nTest 8.1: makeEmpty method");
        list.makeEmpty();
        if(list.toString().equals("[]") && list.size() == 0)
            System.out.println("Passed test 8.1");
        else
            System.out.println("Failed test 8.1"); 
        
        
        //makeEmpty method, test 8.2
        System.out.println("\nTest 8.2: makeEmpty method");
        for (int i = 0; i < 100000; i++) {
        	list.add("LOL");
        }
        list.makeEmpty();
        if(list.toString().equals("[]") && list.size() == 0)
            System.out.println("Passed test 8.2");
        else
            System.out.println("Failed test 8.2"); 
        
        
        
        //iterator method, test 9.0
        System.out.println("\nTest 9.0: iterator method");
        Iterator<String> it = list.iterator();
        boolean hasNext = it.hasNext();
        if(!hasNext)
            System.out.println("Passed test 9.0");
        else
            System.out.println("Failed test 9.0"); 
        
       //iterator method, test 9.1
        System.out.println("\nTest 9.1: iterator method");
        list.add("Kick");
        it = list.iterator();
        hasNext = it.hasNext();
        String next = (String)it.next();
        if(hasNext && next == "Kick" )
            System.out.println("Passed test 9.1");
        else
            System.out.println("Failed test 9.1"); 
        
        
      //iterator method, test 9.2
        System.out.println("\nTest 9.2: iterator method");
        it.remove();
        if(list.toString().equals("[]") && list.size() == 0 )
            System.out.println("Passed test 9.2");
        else
            System.out.println("Failed test 9.2");
        
      //removeRange method, test 10.0
        System.out.println("\nTest 10.0: removeRange method");
        list.add("sjtu");
        list.removeRange(0, 0);
        if(list.toString().equals("[sjtu]") && list.size() == 1)
            System.out.println("Passed test 10.0");
        else
            System.out.println("Failed test 10.0"); 
        
        
      //removeRange method, test 10.1
        System.out.println("\nTest 10.1: removeRange method");
        list.removeRange(0, 1);
        if(list.toString().equals("[]") && list.size() == 0)
            System.out.println("Passed test 10.1");
        else
            System.out.println("Failed test 10.1");  
        
        
      //removeRange method, test 10.2
        System.out.println("\nTest 10.2: removeRange method");
        for (int i = 0; i < 100; i++) {
        	list.add("sjtu");
        }
        list.removeRange(1, 99);;
        if(list.toString().equals("[sjtu, sjtu]") && list.size() == 2)
            System.out.println("Passed test 10.2");
        else
            System.out.println("Failed test 10.2"); 
        
      //addFirst method, test 11.0
        System.out.println("\nTest 11.0: addFirst method");
        list.addFirst("Shanghai");
        if(list.toString().equals("[Shanghai, sjtu, sjtu]") && list.size() == 3)
            System.out.println("Passed test 11.0");
        else
            System.out.println("Failed test 11.0"); 
        
        
        //addFirst method, test 11.1
        System.out.println("\nTest 11.1: addFirst method");
        list.makeEmpty();
        list.addFirst("University");
        list.addFirst("Tong");
        list.addFirst("Jiao");
        list.addFirst("Shanghai");
        if(list.toString().equals("[Shanghai, Jiao, Tong, University]") && list.size() == 4)
            System.out.println("Passed test 11.1");
        else
            System.out.println("Failed test 11.1"); 
        
      //addFirst method, test 11.2
        System.out.println("\nTest 11.2: addFirst method");
        list.makeEmpty();
        list.remove("University");
        list.addFirst("University");
        list.addFirst("Tong");
        list.remove("Tong");


        if(list.toString().equals("[University]") && list.size() == 1)
            System.out.println("Passed test 11.2");
        else
            System.out.println("Failed test 11.2"); 
        
        
        //addLast method, test 12.0
        System.out.println("\nTest 12.0: addLast method");
        list.addLast("SJTU");
        if(list.toString().equals("[University, SJTU]") && list.size() == 2)
            System.out.println("Passed test 12.0");
        else
            System.out.println("Failed test 12.0"); 
        
        
      //addLast method, test 12.1
        System.out.println("\nTest 12.1: addLast method");
        list.makeEmpty();
        list.addLast("SJTU");
        list.addLast("Computer Science");
        if(list.toString().equals("[SJTU, Computer Science]") && list.size() == 2)
            System.out.println("Passed test 12.1");
        else
            System.out.println("Failed test 12.1"); 
        
        //addLast method, test 12.2
        System.out.println("\nTest 12.2: addLast method");
        list.makeEmpty();
        for (int i = 0; i < 100; i++) {
        	list.addLast(Integer.toString(i));
        }
        list.removeRange(2, 98);
        if(list.toString().equals("[0, 1, 98, 99]") && list.size() == 4)
            System.out.println("Passed test 12.2");
        else
            System.out.println("Failed test 12.2"); 
 
    
        //removeFirst method, test 13.0
        System.out.println("\nTest 13.0: removeFirst method");
        remove = list.removeFirst();
        if(list.toString().equals("[1, 98, 99]") && list.size() == 3 && remove.equals("0"))
            System.out.println("Passed test 13.0");
        else
            System.out.println("Failed test 13.0"); 
        
        //removeFirst method, test 13.1
        System.out.println("\nTest 13.1: removeFirst method");
        remove = list.removeFirst();
        remove = list.removeFirst();
        remove = list.removeFirst();
        if(list.toString().equals("[]") && list.size() == 0 && remove.equals("99"))
            System.out.println("Passed test 13.1");
        else
            System.out.println("Failed test 13.1");
        
      //removeFirst method, test 13.2
        System.out.println("\nTest 13.2: removeFirst method");
        list.add("LALALA");
        remove = list.removeFirst();
        if(list.toString().equals("[]") && list.size() == 0 && remove == "LALALA")
            System.out.println("Passed test 13.2");
        else
            System.out.println("Failed test 13.2");
        
        
        //removeLast method, test 14.0
        System.out.println("\nTest 14.0: removeLast method");
        list.add("Shanghai");
        list.add("JiaoTong");
        list.add("University");
        remove = list.removeLast();
        if(list.toString().equals("[Shanghai, JiaoTong]") && list.size() == 2 && remove == "University")
            System.out.println("Passed test 14.0");
        else
            System.out.println("Failed test 14.0");        
        
        
      //removeLast method, test 14.1
        System.out.println("\nTest 14.1: removeLast method");
        list.addFirst("Beijing");
        remove = list.removeLast();
        if(list.toString().equals("[Beijing, Shanghai]") && list.size() == 2 && remove == "JiaoTong")
            System.out.println("Passed test 14.1");
        else
            System.out.println("Failed test 14.1"); 
        
        
      //removeLast method, test 14.2
        System.out.println("\nTest 14.2: removeLast method");
        remove = list.removeLast();
        remove = list.removeLast();
        if(list.toString().equals("[]") && list.size() == 0 && remove == "Beijing")
            System.out.println("Passed test 14.2");
        else
            System.out.println("Failed test 14.2"); 
        
        //toString method, test 15.0
        System.out.println("\nTest 15.0: toString method");
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 100; i++) {
        	list.add(Integer.toString(i));
        	if (i < 99) {
            	sb.append(i);
            	sb.append(", ");
        	}
        	else {
        		sb.append(i);
        	}

        }
        sb.append("]");
        if(list.toString().equals(sb.toString()) && list.size() == 100)
            System.out.println("Passed test 15.0");
        else
            System.out.println("Failed test 15.0");
        
      //toString method, test 15.1
        System.out.println("\nTest 15.1: toString method");
        list.makeEmpty();
        list.add("USA");
        if(list.toString().equals("[USA]") && list.size() == 1)
            System.out.println("Passed test 15.1");
        else
            System.out.println("Failed test 15.1");
        
        
        //toString method, test 15.2
        System.out.println("\nTest 15.2: toString method");
        list.addFirst("Mechanical");
        list.insert(2, "Science");
        if(list.toString().equals("[Mechanical, USA, Science]") && list.size() == 3)
            System.out.println("Passed test 15.2");
        else
            System.out.println("Failed test 15.2");
         
        

        //equals method, test 16.0
        System.out.println("\nTest 16.0: equals method");
        list.makeEmpty();
        LinkedList<String> newList = new LinkedList<String> ();        
        if(list.equals(newList) )
            System.out.println("Passed test 16.0");
        else
            System.out.println("Failed test 16.0");
        
      //equals method, test 16.1
        System.out.println("\nTest 16.1: equals method");
        newList.add("not empty");       
        if(!list.equals(newList) )
            System.out.println("Passed test 16.1");
        else
            System.out.println("Failed test 16.1");
        
      //equals method, test 16.2
        System.out.println("\nTest 16.2: equals method");
        list.add("Love");
        if(!list.equals(newList) )
            System.out.println("Passed test 16.2");
        else
            System.out.println("Failed test 16.2");


      //equals method, test 16.3
        System.out.println("\nTest 16.3: equals method");
        ArrayList<String> listArray = new ArrayList<String> ();
        listArray.add("Love");
        if(!list.equals(listArray) )
            System.out.println("Passed test 16.3");
        else
            System.out.println("Failed test 16.3");
    
      }
   }
    