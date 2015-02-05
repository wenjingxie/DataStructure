/*  Student information for assignment:
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


/*
CS 314 Students, put your results to the experiments and answers to
questions here:
=======SortedSet=======
Title        size/KB        Total Words        Distinct Words        Time/s
Alice        168kB           29461              6071                  0.462338
Pride        4.3X            4.2X               2.2X                   7.7X
Ulysses      9.7X            9.1X               8.3X                  83.0X
Les          20.0X           19.3X              8.8X                  273.4X
=======UnsortedSet=======
Title        size/KB        Total Words        Distinct Words        Time/s
Alice        168kB           29461              6071                  0.277735
Pride        4.3X            4.2X               2.2X                  4.8X
Ulysses      9.7X            9.1X               8.3X                  63.7X
Les          20.0X           19.3X              8.8X                  98.3X
=======HashSet=======
Title        size/KB        Total Words        Distinct Words        Time/s
Alice        168kB           29461              6071                  0.037102
Pride        4.3X            4.2X               2.2X                  2.9X
Ulysses      9.7X            9.1X               8.3X                  6.4X
Les          20.0X           19.3X              8.8X                  10.8X
=======TreeSet=======
Title        size/KB        Total Words        Distinct Words        Time/s
Alice        168kB           29461              6071                  0.046492
Pride        4.3X            4.2X               2.2X                  3.2X
Ulysses      9.7X            9.1X               8.3X                  7.3X
Les          20.0X           19.3X              8.8X                  11.9X

Questions:
1.What do you think the order (Big O) of the two processText methods are for each kind of Set? 
Assume N = total number of words in a file and M = number of distinct words in the file. M = the size of the set when finished.
A: SortedSet, O(M*N); UnsortedSet, O(M*N); HashSet, O(log(M*N)); TreeSet, O(log(M*N))

2.What are the orders (Big O) of your add methods? What do you think the Big O of the HashSet and TreeSet add methods are?
A: SortedSet and UnsortedSet, O(N). The HashSet and TreeSet, O(logN).

3.What are the differences between HashSet and TreeSet when printing out the contents of the Set?
A: The TreeSet is sorted as ascending order. The HashSet has no trend.


CS314 Students, why is it unwise to implement all three of the
intersection, union, and difference methods in the AbstractSet class:
 
In the AbstractSet class, we do not have instance variable and constructor. All these three methods need to return
an ISet type object. Thus, we need to use one of these methods as the basic step to get an ISet object. So the one we choose as
the basic method could not be implemented. Therefore, we could not implement all three of them at the same time.

*/


public class SetTester {

    public static void main(String[] args){
        //test 1.1
        ISet<String> s1 = new UnsortedSet<String>();
        s1.add("A");
        s1.add("C");
        s1.add("A");
        s1.add("B");
        s1.add("P");
        s1.add("G");
        s1.add("G");
        if( s1.contains("A") && s1.size() == 3 )
            System.out.println("Passed test 1.1: add method UnsortedSet");
        else
            System.out.println("Failed test 1.1: add method UnsortedSet");

        //test 1.2
        SortedSet<String> s2 = new SortedSet<String>(s1);
        System.out.println(s2);
        System.out.println(s1);
        SortedSet<String> s8 = new SortedSet<String>();
        System.out.println(s2.equals(s8));
        s2.add("D");
        s2.add("d");
        s2.add("A");
        s2.add("C");
        s2.add("D");
        Object Expected = "(A, C, D, d)";
        Object Actual = s2.toString();   
        if( Expected.equals(Actual) && s2.size() == 4)
            System.out.println("Passed test 1.2: add method SortedSet");
        else
            System.out.println("Failed test 1.2: add method SortedSet");
        
        
        //test 2.1
        Actual = s1.addAll(s2);   
        Expected = true;
        if( s1.contains("D") && s1.size() == 5 && Expected.equals(Actual) )
            System.out.println("Passed test 2.1: addAll method UnsortedSet");
        else
            System.out.println("Failed test 2.1: addAll method UnsortedSet");
        
        //test 2.2
        boolean isAdd = s2.addAll(s1);
        Expected = "(A, B, C, D, d)";
        Actual = s2.toString();
        if( Expected.equals(Actual) && isAdd == true)
            System.out.println("Passed test 2.2: addAll method SortedSet");
        else
            System.out.println("Failed test 2.2: addAll method SortedSet");
        
        //test 2.3
        ISet<String> s3 = new UnsortedSet<String>();
        isAdd = s2.addAll(s3);
        Expected = "(A, B, C, D, d)";
        Actual = s2.toString();
        if( Expected.equals(Actual) && isAdd == false )
            System.out.println("Passed test 2.3: addAll method SortedSet");
        else
            System.out.println("Failed test 2.3: addAll method SortedSet");
        
        //test 2.4
        isAdd = s2.addAll(s2);
        Expected = "(A, B, C, D, d)";
        Actual = s2.toString();
        if( Expected.equals(Actual) && isAdd == false )
            System.out.println("Passed test 2.4: addAll method SortedSet");
        else
            System.out.println("Failed test 2.4: addAll method SortedSet");
        
        //test 3.1
        s1.clear();      
        if( s1.size() == 0 )
            System.out.println("Passed test 3.1: clear method UnsortedSet");
        else
            System.out.println("Failed test 3.1: clear method UnsortedSet");
        
        //test 3.2
        s2.clear();      
        if( s2.size() == 0 )
            System.out.println("Passed test 3.2: clear method SortedSet");
        else
            System.out.println("Failed test 3.2: clear method SortedSet");
        
        
        //test 4.1
        if( !s1.contains("A") )
            System.out.println("Passed test 4.1: contains method UnsortedSet");
        else
            System.out.println("Failed test 4.1: contains method UnsortedSet");
        
        //test 4.2
        if( !s2.contains("A") )
            System.out.println("Passed test 4.2: contains method SortedSet");
        else
            System.out.println("Failed test 4.2: contains method SortedSet");
        
        
        //test 4.3
        s2.add("D");
        s2.add("A");
        if( s2.contains("A") && !s2.contains("X") )
            System.out.println("Passed test 4.3: contains method SortedSet");
        else
            System.out.println("Failed test 4.3: contains method SortedSet");
        
        //test 5.1
        if( !s1.containsAll(s2) && s1.containsAll(s1))
            System.out.println("Passed test 5.1: containsAll method UnsortedSet");
        else
            System.out.println("Failed test 5.1: containsAll method UnsortedSet");
        
        
        //test 5.2
        if( s2.containsAll(s1) && s2.containsAll(s2))
            System.out.println("Passed test 5.2: containsAll method SortedSet");
        else
            System.out.println("Failed test 5.2: containsAll method SortedSet");
        
        //test 5.3
        s1.add("A");
        s2.add("F");
        if( s2.containsAll(s1) )
            System.out.println("Passed test 5.3: containsAll method SortedSet");
        else
            System.out.println("Failed test 5.3: containsAll method SortedSet");
        
        
        //test 5.4
        s1.add("D");
        s1.add("G");
        if( !s2.containsAll(s1) )
            System.out.println("Passed test 5.4: containsAll method SortedSet");
        else
            System.out.println("Failed test 5.4: containsAll method SortedSet");
        
        
        //test 6.1
        s3 = s1.difference(s2);
        ISet<String> s4 = new UnsortedSet<String>();
        s4.add("G");
        if( s3.equals(s4))
            System.out.println("Passed test 6.1: difference method UnsortedSet");
        else
            System.out.println("Failed test 6.1: difference method UnsortedSet");
        
        //test 6.2
        s2.clear();
        s3 = s1.difference(s2);
        s4.add("A");
        s4.add("D");
        if( s3.equals(s4))
            System.out.println("Passed test 6.2: difference method UnsortedSet");
        else
            System.out.println("Failed test 6.2: difference method UnsortedSet");
        
        //test 6.3
        s2.clear();
        s3 = s2.difference(s1);
        s4 = new SortedSet<String>();
        if( s3.equals(s4))
            System.out.println("Passed test 6.3: difference method SortedSet");
        else
            System.out.println("Failed test 6.3: difference method SortedSet");
        
        //test 6.4
        s2.add("X");
        s3 = s2.difference(s1);
        s4.add("X");
        if( s3.equals(s4))
            System.out.println("Passed test 6.4: difference method SortedSet");
        else
            System.out.println("Failed test 6.4: difference method SortedSet");
        
         
        //test 6.5
        s2.add("X");
        s1.clear();
        s3 = s2.difference(s1);
        if( s3.equals(s4))
            System.out.println("Passed test 6.5: difference method SortedSet");
        else
            System.out.println("Failed test 6.5: difference method SortedSet");
        
        //test 7.1
        s2.add("A");
        s2.add("D");
        s1.add("X");
        s1.add("A");
        s1.add("D");
        if( s1.equals(s2) && !s1.equals(s3))
            System.out.println("Passed test 7.1: equals method UnsortedSet");
        else
            System.out.println("Failed test 7.1: equals method UnsortedSet");
        
        
        //test 7.2
        s3.add("A");
        s3.add("D");
        s4.clear();
        if( !s2.equals(s1) && s2.equals(s3) && !s2.equals(s4))
            System.out.println("Passed test 7.2: equals method SortedSet");
        else
            System.out.println("Failed test 7.2: equals method SortedSet");
        
        //test 8.1
        s3 = s1.intersection(s2);
        s4.add("X");
        ISet<String> s5 = new UnsortedSet<String>();
        s5 = s1.intersection(s4);
        if( s3.equals(s1) && s5.equals(s4))
            System.out.println("Passed test 8.1: intersection method UnsortedSet");
        else
            System.out.println("Failed test 8.1: intersection method UnsortedSet");
        
        //test 8.2
        s3 = s2.intersection(s1);
        s5 = s2.intersection(s4);
        if( s3.equals(s2) && s5.equals(s4))
            System.out.println("Passed test 8.2: intersection method SortedSet");
        else
            System.out.println("Failed test 8.2: intersection method SortedSet");
        
        //test 8.3
        s2.clear();
        s3 = s2.intersection(s1);
        s4.clear();
        if(s3.equals(s4))
            System.out.println("Passed test 8.3: intersection method SortedSet");
        else
            System.out.println("Failed test 8.3: intersection method SortedSet");
        
        //test 9.1
        Iterator<String> it = s1.iterator();
        it.next();
        Expected = it.next();
        Actual = "A";
        if( Expected.equals(Actual))
            System.out.println("Passed test 9.1: iterator method UnsortedSet");
        else
            System.out.println("Failed test 9.1: iterator method UnsortedSet");
        
        //test 9.2
        it = s2.iterator();
        Expected = it.hasNext();
        Actual = false;
        if( Expected.equals(Actual))
            System.out.println("Passed test 9.2: iterator method SortedSet");
        else
            System.out.println("Failed test 9.2: iterator method SortedSet");
        
        
        //test 10.1
        Expected = s1.remove("W");
        Actual = false;
        s1.remove("A");
        if( Expected.equals(Actual) && s1.size() == 2)
            System.out.println("Passed test 10.1: remove method UnsortedSet");
        else
            System.out.println("Failed test 10.1: remove method UnsortedSet");
        
        
        //test 10.2
        Expected = s2.remove("W");
        Actual = false;
        s2.add("X");
        s2.add("G");
        s2.add("C");
        s2.remove("A");
        s2.remove("G");
        if( Expected.equals(Actual) && s2.size() == 2)
            System.out.println("Passed test 10.2: remove method SortedSet");
        else
            System.out.println("Failed test 10.2: remove method SortedSet");
        
        //test 11.1
        s1.add("a");
        s1.add("e");
        s1.add("a");
        if( s1.size() == 4)
            System.out.println("Passed test 11.1: size method UnsortedSet");
        else
            System.out.println("Failed test 11.1: size method UnsortedSet");
        
        //test 11.2
        s2.add("a");
        s2.add("e");
        s2.add("a");
        if( s1.size() == 4)
            System.out.println("Passed test 11.2: size method SortedSet");
        else
            System.out.println("Failed test 11.2: size method SortedSet");

        //test 12.1
        s3 = s1.union(s4);
        s5 = s1.union(s2);
        s2.add("D");
        if( s1.equals(s3) && s5.equals(s2))
            System.out.println("Passed test 12.1: union method UnsortedSet");
        else
            System.out.println("Failed test 12.1: union method UnsortedSet");
        
        //test 12.2
        s1.clear();
        s5 = s1.union(s3);
        if( s5.equals(s3))
            System.out.println("Passed test 12.2: union method UnsortedSet");
        else
            System.out.println("Failed test 12.2: union method UnsortedSet");
        
        //test 12.3
        s5 = s2.union(s1);
        s1.add("C");
        s1.add("O");
        s4 = s2.union(s1);
        System.out.println(s2);
        s3 = new SortedSet<String>(s2);
        s3.add("O");
        if( s5.equals(s2) && s4.equals(s3))
            System.out.println("Passed test 12.3: union method SortedSet");
        else
            System.out.println("Failed test 12.3: union method SortedSet");
        
        //test 12.4
        s2.clear();
        s3 = s2.union(s4);
        if(s4.equals(s3))
            System.out.println("Passed test 12.4: union method SortedSet");
        else
            System.out.println("Failed test 12.4: union method SortedSet");
        
        
        //test 13.1
        s2.add("S");
        Expected = "S";
        Actual = s2.min();
        if(Expected.equals(Actual))
            System.out.println("Passed test 13.1: min method SortedSet");
        else
            System.out.println("Failed test 13.1: min method SortedSet");
        
        //test 13.2
        s2.add("S");
        s2.add("R");
        s2.add("D");
        s2.add("A");
        Expected = "A";
        Actual = s2.min();
        if(Expected.equals(Actual))
            System.out.println("Passed test 13.2: min method SortedSet");
        else
            System.out.println("Failed test 13.2: min method SortedSet");
        
        //test 14.1
        Expected = "S";
        Actual = s2.max();
        if(Expected.equals(Actual))
            System.out.println("Passed test 14.1: max method SortedSet");
        else
            System.out.println("Failed test 14.1: max method SortedSet");
        
        //test 14.2
        s2.remove("A");
        s2.remove("S");
        s2.remove("R");
        Expected = "D";
        Actual = s2.max();
        if(Expected.equals(Actual))
            System.out.println("Passed test 14.2: max method SortedSet");
        else
            System.out.println("Failed test 14.2: max method SortedSet");
        
            



    }

}