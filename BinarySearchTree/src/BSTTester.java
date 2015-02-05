/*  Student information for assignment:
 *
 *  UTEID: wx674
 *  email address: wenjing.xie@utexs.edu
 *  Grader name: Eric
 *  Number of slip days I am using: 0
 */


/*
 * Place results of experiments here:
 * 
========BST Insertion Experiment========
1000:    time: 9.35E-4s height: 20 size: 1000       minPossibleHeight:10
2000     time: 4.86E-4s height: 23 size: 2000       minPossibleHeight:11 
4000:    time: 2.03E-3s height: 26 size: 4000       minPossibleHeight:12
8000:    time: 2.52E-3s height: 29 size: 8000       minPossibleHeight:13
16000:   time: 5.07E-3s height: 32 size: 15999      minPossibleHeight:14
32000:   time: 9.19E-3s height: 37 size: 31999      minPossibleHeight:15
64000:   time: 0.0225s  height: 36 size: 63999      minPossibleHeight:16
128000:  time: 0.0534s  height: 40 size: 127997     minPossibleHeight:17
256000:  time: 0.127s   height: 42 size: 255992     minPossibleHeight:18
512000:  time: 0.342s   height: 46 size: 511967     minPossibleHeight:19
1024000: time: 0.855s   height: 49 size: 1023882    minPossibleHeight:20
For each value of N what is the minimum possible tree height, assuming N unique values are inserted into the tree?
A: log(N); 

========TreeSet Insertion Experiment======
1000:    time: 8.38E-4s
2000:    time: 1.07E-3s
4000:    time: 1.14E-3s
8000:    time: 1.45E-3s
16000:   time: 3.31E-3s
32000:   time: 7.40E-3s
64000:   time: 0.0199s
128000:  time: 0.0507s
256000:  time: 0.139s
512000:  time: 0.363s
1024000: time: 0.879s

Compare the TreeSet and the BST, the time need to do insertion are quite close.


=======BST Sorted Insertion Experiment=======
1000:  time: 0.00442s height: 999   size: 1000
2000:  time: 0.0178s  height: 1999  size: 2000
4000:  time: 0.0789s  height: 3999  size: 4000
8000:  time: 0.339s   height: 7999  size: 8000
16000: time: 1.45s    height: 15999 size: 16000
32000: StackOverflowError
64000: StackOverflowError


========TreeSet Sorted Insertion Experiment======
1000:  time: 9.57E-4s
2000:  time: 7.85E-4s
4000:  time: 9.80E-4s
8000:  time: 0.00125s
16000: time: 0.00261s
32000: time: 0.00525s
64000: time: 0.0119s

When inserting sorted list, the TreeSet add is much faster.
 * 
 */

/**
 * Test class for binary search tree
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class BSTTester {

    public static void main(String[] args) {
        BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
        t.add(100);
        t.add(60);
        t.add(90);
        t.add(120);

        //test 1, add
        System.out.println("Test 1: add method");
        showTestResults( (t.add(120) == false && t.size() == 4 ), 1 );
        
        //test 2, add
        System.out.println("Test 2: add method");
        t.add(70);
        t.add(30);
        showTestResults( (t.height() == 3), 2 );

        //test 3, remove
        System.out.println("Test 3: remove method");
        t.add(80);
        t.add(50);
        t.add(110);
        t.add(20);
        t.add(95);
        t.add(82);
        t.add(92);
        showTestResults( (t.remove(100) == true && t.height() == 5), 3 );
        
        //test 4, remove
        System.out.println("Test 4: remove method");
        showTestResults( (t.remove(100) == false && t.height() == 5), 4 );
        
        
        //test 5, isPresent
        System.out.println("Test 5: isPresent method");
        showTestResults( t.isPresent(100) == false, 5 );
        
        //test 6, isPresent
        System.out.println("Test 6: isPresent method");
        showTestResults( t.isPresent(20) == true, 6 );
        
        //test 7, size
        System.out.println("Test 7: size method");
        showTestResults( t.size() == 12, 7 );
        
        //test 8, size
        System.out.println("Test 8: size method");
        t.add(32);
        t.remove(60);
        showTestResults( t.size() == 12, 8 );
        
        
        //test 9, height
        System.out.println("Test 9: height method");
        showTestResults( t.height() == 5, 9 );
        
        //test 10, height
        System.out.println("Test 10: height method");
        t.add(130);
        showTestResults( t.height() == 5, 10 );
        
        //test 11, getAll
        System.out.println("Test 11: getAll method");
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(20);
        expected.add(30);
        expected.add(32);
        expected.add(50);
        expected.add(70);
        expected.add(80);
        expected.add(82);
        expected.add(90);
        expected.add(92);
        expected.add(95);
        expected.add(110);
        expected.add(120);
        expected.add(130);       
        showTestResults( expected.equals(t.getAll()), 11 );
        
        //test 12, getAll
        System.out.println("Test 12: getAll method");
        t = new BinarySearchTree<Integer>();
        expected = new ArrayList<Integer>();
        showTestResults( expected.equals(t.getAll()), 12 );
        
        //test 13, max
        System.out.println("Test 13: max method");
        t.add(90);
        t.add(120);
        t.add(110);
        t.add(30);
        t.add(50);
        showTestResults( t.max() == 120, 13 );
        
        //test 14, max
        System.out.println("Test 14: max method");
        t.remove(120);
        showTestResults( t.max() == 110, 14 );
        
        //test 15, min
        System.out.println("Test 15: min method");
        showTestResults( t.min() == 30, 15 );
        
        //test 16, min
        System.out.println("Test 16: min method");
        t.add(2);
        t.add(20);
        showTestResults( t.min() == 2, 16 );
        
        //test 17, iterativeAdd
        System.out.println("Test 17: iterativeAdd method");
        t.iterativeAdd(3);
        showTestResults( t.iterativeAdd(3) == false, 17 );
        
        //test 18, iterativeAdd
        System.out.println("Test 18: iterativeAdd method");
        t.iterativeAdd(3);
        showTestResults( t.iterativeAdd(3) == false, 18 );
        
        //test 19, get
        System.out.println("Test 19: get method");
        showTestResults( t.get(0) == t.min(), 19 );
        
        //test 20, get
        System.out.println("Test 20: get method");
        showTestResults( t.get(4) == 50, 20 );
        
        
        //test 21, getAllLessThan
        System.out.println("Test 21: getAllLessThan method");
        expected.add(2);
        expected.add(3);
        expected.add(20);
        expected.add(30);
        showTestResults( expected.equals(t.getAllLessThan(50)), 21 );
        
        //test 22, getAllLessThan
        System.out.println("Test 22: getAllLessThan method");
        expected.clear();
        showTestResults( expected.equals(t.getAllLessThan(2)), 22 );
                
        //test 23, getAllGreaterThan
        System.out.println("Test 23: getAllGreaterThan method");
        showTestResults( expected.equals(t.getAllGreaterThan(110)), 23 );
        
        //test 24, getAllGreaterThan
        System.out.println("Test 24: getAllGreaterThan method");
        expected.add(50);
        expected.add(90);
        expected.add(110);
        showTestResults( expected.equals(t.getAllGreaterThan(30)), 24 );
               
        //test 25, numNodesAtDepth
        System.out.println("Test 25: numNodesAtDepth method");
        showTestResults( t.numNodesAtDepth(0) == 1, 25 );
        
        //test 26, numNodesAtDepth
        System.out.println("Test 26: numNodesAtDepth method");
        showTestResults( t.numNodesAtDepth(4) == 1, 26 );
        
        
        //BSTInsertExperiment();
        //TSInsertExperiment();
        //BSTSortedInsertExperiment();
        //TSSortedInsertExperiment();
               
        
    }
    private static void showTestResults(boolean passed, int testNum) {
        if( passed )
            System.out.println( "test " + testNum + " passed.");
        else
            System.out.println( "test " + testNum + " failed.");
    }
    
    //Experiment Code
    public static void BSTInsertExperiment() {
    	System.out.println("BST Insertion Experiment");
    	for (int n = 1000; n <= 1024000; n *= 2) {
        	Random r;
        	BinarySearchTree<Integer> b;
        	double time = 0;
        	int height = 0;
        	int size = 0;
        	for (int m = 0; m < 10; m++) {
        		r = new Random();
        		b = new BinarySearchTree<Integer>();
        		Stopwatch st = new Stopwatch();
            	st.start();
            	for(int i = 0; i < n; i++) {
            	    b.add( new Integer( r.nextInt() ) );
            	}
            	st.stop();	
            	time += st.time();
            	height += b.height();
            	size += b.size();
        	}
        	System.out.println("" + n +": " +"time: " + time/10 + "s height: " + height/10 + " size: " + size/10);       	
    	}   	
    }
    
    public static void TSInsertExperiment() {
    	System.out.println("TreeSet Insertion Experiment");
    	for (int n = 1000; n <= 1024000; n *= 2) {
        	Random r;
        	TreeSet<Integer> b;
        	double time = 0;
        	for (int m = 0; m < 10; m++) {
        		r = new Random();
        		b = new TreeSet<Integer>();
        		Stopwatch st = new Stopwatch();
            	st.start();
            	for(int i = 0; i < n; i++) {
            	    b.add( new Integer( r.nextInt() ) );
            	}
            	st.stop();	
            	time += st.time();
        	}
        	System.out.println("" + n +": " +"time: " + time/10 +"s" ); 
        	
    	}   	   	
    }
    
    public static void BSTSortedInsertExperiment() {
    	System.out.println("BST Sorted Insertion Experiment");
    	for (int n = 1000; n <= 64000; n *= 2) {
        	BinarySearchTree<Integer> b;
        	double time = 0;
        	int height = 0;
        	int size = 0;
        	for (int m = 0; m < 10; m++) {
        		b = new BinarySearchTree<Integer>();
        		Stopwatch st = new Stopwatch();
            	st.start();
            	for(int i = 0; i < n; i++) {
            	    b.add(i);
            	}
            	st.stop();	
            	time += st.time();
            	height += b.height();
            	size += b.size();
        	}
        	System.out.println("" + n +": " +"time: " + time/10 + "s height: " + height/10 + " size: " + size/10);      	
    	}
    }
    
    public static void TSSortedInsertExperiment() {
    	System.out.println("TreeSet Sorted Insertion Experiment");
    	for (int n = 1000; n <= 64000; n *= 2) {
        	TreeSet<Integer> b;
        	double time = 0;
        	for (int m = 0; m < 10; m++) {
        		b = new TreeSet<Integer>();
        		Stopwatch st = new Stopwatch();
            	st.start();
            	for(int i = 0; i < n; i++) {
            	    b.add(i);
            	}
            	st.stop();	
            	time += st.time();
        	}
        	System.out.println("" + n +": " +"time: " + time/10 + "s");      	
    	}
    }
}