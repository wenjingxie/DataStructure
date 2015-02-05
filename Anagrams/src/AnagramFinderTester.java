

/* CS 314 STUDENTS: FILL IN THIS HEADER AND THEN COPY AND PASTE IT TO YOUR
 * LetterInventory.java AND AnagramSolver.java CLASSES.
 *
 * Student information for assignment:
 *
 *  On my honor, Wenjing Xie, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: wx674
 *  email address: wenjing.xie@utexas.edu
 *  Grader name: Eric
 *  Number of slip days I am using: 0
 */

public class AnagramFinderTester {

    

    public static void main(String[] args) {

       
        // CS314 Students, delete the above tests when you turn in your assignment
        // CS314 Students add your LetterInventory tests here. 
       
        
        //test 1.1 constructor
        System.out.println("\nTest 1.1: constructor");
        LetterInventory lets1 = new LetterInventory("===---=");
        Object expected = 0;
        Object actual = lets1.size();
        Object expected1 = "";
        Object actual1 = lets1.toString();
        if(actual.equals(expected) && actual1.equals(expected1) && lets1.isEmpty())
            System.out.println("Passed test 1.1");
        else
            System.out.println("Failed test 1.1");
        
      //test 1.2 constructor
        System.out.println("\nTest 1.2: constructor");
        lets1 = new LetterInventory("ASsade#@#$@0098Ousntc");
        expected = 12;
        actual = lets1.size();
        expected1 = "aacdenossstu";
        actual1 = lets1.toString();
        if(actual.equals(expected) && actual1.equals(expected1) && !lets1.isEmpty())
            System.out.println("Passed test 1.2");
        else
            System.out.println("Failed test 1.2");
        
        
        //test 2.1 get
        System.out.println("\nTest 2.1: get method");
        expected = 2;
        actual = lets1.get('A');
        expected1 = 0;
        actual1 = lets1.get('b');
        if(actual.equals(expected) && actual1.equals(expected1))
            System.out.println("Passed test 2.1");
        else
            System.out.println("Failed test 2.1");
        
      //test 2.2 get
        System.out.println("\nTest 2.2: get method");
        lets1 = new LetterInventory("");
        expected = 0;
        actual = lets1.get('a');
        expected1 = 0;
        actual1 = lets1.get('U');
        if(actual.equals(expected) && actual1.equals(expected1))
            System.out.println("Passed test 2.2");
        else
            System.out.println("Failed test 2.2");
        
        
        
        //test 3.1 size
        System.out.println("\nTest 3.1: size method");
        expected = 0;
        actual = lets1.size();
        if(actual.equals(expected))
            System.out.println("Passed test 3.1");
        else
            System.out.println("Failed test 3.1");
        
        //test 3.2 size
        System.out.println("\nTest 3.2: size method");
        lets1 = new LetterInventory("<>=-0asjbu2311");
        expected = 5;
        actual = lets1.size();
        if(actual.equals(expected))
            System.out.println("Passed test 3.2");
        else
            System.out.println("Failed test 3.2");
        
        
        //test 4.1 isEmpty
        System.out.println("\nTest 4.1: isEmpty method");
        expected = false;
        actual = lets1.isEmpty();
        if(actual.equals(expected))
            System.out.println("Passed test 4.1");
        else
            System.out.println("Failed test 4.1");
        
        //test 4.2 isEmpty
        System.out.println("\nTest 4.2: isEmpty method");
        lets1 = new LetterInventory("][';!@#=-");
        expected = true;
        actual = lets1.isEmpty();
        if(actual.equals(expected))
            System.out.println("Passed test 4.2");
        else
            System.out.println("Failed test 4.2");
        
        //test 5.1 toString
        System.out.println("\nTest 5.1: toString method");
        expected = "";
        actual = lets1.toString();
        if(actual.equals(expected))
            System.out.println("Passed test 5.1");
        else
            System.out.println("Failed test 5.1");
        
        //test 5.2 toString
        System.out.println("\nTest 5.2: toString method");
        lets1 = new LetterInventory("LKSdeafernwics");
        expected = "acdeefiklnrssw";
        actual = lets1.toString();
        if(actual.equals(expected))
            System.out.println("Passed test 5.2");
        else
            System.out.println("Failed test 5.2");
        
        //test 6.1 add
        System.out.println("\nTest 6.1: add method");
        LetterInventory lets2 = new LetterInventory("234");
        expected = lets1;
        actual = lets1.add(lets2);
        actual1 = lets2.add(lets1);
        if(actual.equals(expected) && actual1.equals(expected))
            System.out.println("Passed test 6.1");
        else
            System.out.println("Failed test 6.1");
        
        
        //test 6.2 add
        System.out.println("\nTest 6.2: add method");
        lets2 = new LetterInventory("abce");
        expected = new LetterInventory("aabccdeeefiklnrssw");
        actual = lets1.add(lets2);
        actual1 = lets2.add(lets1);
        if(actual.equals(expected) && actual1.equals(expected))
            System.out.println("Passed test 6.2");
        else
            System.out.println("Failed test 6.2");
        
        
        //test 7.1 subtract
        System.out.println("\nTest 7.1: subtract method");
        lets2 = new LetterInventory("abce");
        actual = lets1.subtract(lets2);
        actual1 = lets2.subtract(lets1);
        if(actual == null && actual1 == null)
            System.out.println("Passed test 7.1");
        else
            System.out.println("Failed test 7.1");
        
        //test 7.2 subtract
        System.out.println("\nTest 7.2: subtract method");
        lets2 = new LetterInventory("ace");
        expected = new LetterInventory("defiklnrssw");
        actual = lets1.subtract(lets2);
        actual1 = lets2.subtract(lets1);
        if(actual.equals(expected) && actual1 == null)
            System.out.println("Passed test 7.2");
        else
            System.out.println("Failed test 7.2");
        
        
        //test 8.1 equals
        System.out.println("\nTest 8.1: equals method");
        lets1 = new LetterInventory("2342AE43&%cb");
        lets2 = new LetterInventory("abce");
        if(lets1.equals(lets2))
            System.out.println("Passed test 8.1");
        else
            System.out.println("Failed test 8.1");
        
        //test 8.2 equals
        System.out.println("\nTest 8.2: equals method");
        lets1 = new LetterInventory("2342AE43&%cbdfgh");
        lets2 = new LetterInventory("abce");
        if(!lets1.equals(lets2))
            System.out.println("Passed test 8.2");
        else
            System.out.println("Failed test 8.2");
    }
    
}
