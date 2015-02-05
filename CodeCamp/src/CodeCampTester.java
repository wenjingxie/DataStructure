import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//  CodeCamp.java - CS314 Assignment 1 - Tester class

/*  Student information for assignment:
 *
 *  Name: Wenjing Xie
 *  email address: wenjing.xie@utexas.edu
 *  UTEID: wx674
 *  Section 5 digit ID: 90130
 *  Grader name: John
 *  Number of slip days used on this assignment: 0
 */


/* CS314 Students: place results of shared birthdays experiments in this comment.
 * Perform 1,000,000 experiments with 365 days per year and 182 people per experiment. 
 * What is the average number of pairs of people with shared birthdays?  45
*******************************

It seems when there are 23 people, the percentage first exceeds 50%. 
So at least 23 people it requires to have a 50% chance of there being at least 1 shared birthday, given a 365 day year.

Num people: 2, number of experiments with one or more shared birthday: 137.0, percentage: 0.274
Num people: 3, number of experiments with one or more shared birthday: 427.0, percentage: 0.854
Num people: 4, number of experiments with one or more shared birthday: 814.0, percentage: 1.628
Num people: 5, number of experiments with one or more shared birthday: 1385.0, percentage: 2.77
Num people: 6, number of experiments with one or more shared birthday: 1982.0, percentage: 3.964
Num people: 7, number of experiments with one or more shared birthday: 2824.0, percentage: 5.648
Num people: 8, number of experiments with one or more shared birthday: 3738.0, percentage: 7.476
Num people: 9, number of experiments with one or more shared birthday: 4715.0, percentage: 9.43
Num people: 10, number of experiments with one or more shared birthday: 5776.0, percentage: 11.552
Num people: 11, number of experiments with one or more shared birthday: 7201.0, percentage: 14.402
Num people: 12, number of experiments with one or more shared birthday: 8259.0, percentage: 16.518
Num people: 13, number of experiments with one or more shared birthday: 9831.0, percentage: 19.662
Num people: 14, number of experiments with one or more shared birthday: 11183.0, percentage: 22.366
Num people: 15, number of experiments with one or more shared birthday: 12687.0, percentage: 25.374
Num people: 16, number of experiments with one or more shared birthday: 13900.0, percentage: 27.8
Num people: 17, number of experiments with one or more shared birthday: 15692.0, percentage: 31.384
Num people: 18, number of experiments with one or more shared birthday: 17252.0, percentage: 34.504
Num people: 19, number of experiments with one or more shared birthday: 18895.0, percentage: 37.79
Num people: 20, number of experiments with one or more shared birthday: 20513.0, percentage: 41.026
Num people: 21, number of experiments with one or more shared birthday: 22139.0, percentage: 44.278
Num people: 22, number of experiments with one or more shared birthday: 23649.0, percentage: 47.298
Num people: 23, number of experiments with one or more shared birthday: 25163.0, percentage: 50.326
Num people: 24, number of experiments with one or more shared birthday: 27040.0, percentage: 54.08
Num people: 25, number of experiments with one or more shared birthday: 28455.0, percentage: 56.91
Num people: 26, number of experiments with one or more shared birthday: 29997.0, percentage: 59.994
Num people: 27, number of experiments with one or more shared birthday: 31396.0, percentage: 62.792
Num people: 28, number of experiments with one or more shared birthday: 32704.0, percentage: 65.408
Num people: 29, number of experiments with one or more shared birthday: 34144.0, percentage: 68.288
Num people: 30, number of experiments with one or more shared birthday: 35400.0, percentage: 70.8
Num people: 31, number of experiments with one or more shared birthday: 36575.0, percentage: 73.15
Num people: 32, number of experiments with one or more shared birthday: 37552.0, percentage: 75.104
Num people: 33, number of experiments with one or more shared birthday: 38769.0, percentage: 77.538
Num people: 34, number of experiments with one or more shared birthday: 39682.0, percentage: 79.364
Num people: 35, number of experiments with one or more shared birthday: 40788.0, percentage: 81.576
Num people: 36, number of experiments with one or more shared birthday: 41642.0, percentage: 83.284
Num people: 37, number of experiments with one or more shared birthday: 42401.0, percentage: 84.802
Num people: 38, number of experiments with one or more shared birthday: 43171.0, percentage: 86.342
Num people: 39, number of experiments with one or more shared birthday: 43953.0, percentage: 87.906
Num people: 40, number of experiments with one or more shared birthday: 44572.0, percentage: 89.144
Num people: 41, number of experiments with one or more shared birthday: 45185.0, percentage: 90.37
Num people: 42, number of experiments with one or more shared birthday: 45654.0, percentage: 91.308
Num people: 43, number of experiments with one or more shared birthday: 46147.0, percentage: 92.294
Num people: 44, number of experiments with one or more shared birthday: 46635.0, percentage: 93.27
Num people: 45, number of experiments with one or more shared birthday: 47012.0, percentage: 94.024
Num people: 46, number of experiments with one or more shared birthday: 47381.0, percentage: 94.762
Num people: 47, number of experiments with one or more shared birthday: 47772.0, percentage: 95.544
Num people: 48, number of experiments with one or more shared birthday: 48008.0, percentage: 96.016
Num people: 49, number of experiments with one or more shared birthday: 48358.0, percentage: 96.716
Num people: 50, number of experiments with one or more shared birthday: 48500.0, percentage: 97.0
Num people: 51, number of experiments with one or more shared birthday: 48671.0, percentage: 97.342
Num people: 52, number of experiments with one or more shared birthday: 48923.0, percentage: 97.846
Num people: 53, number of experiments with one or more shared birthday: 49076.0, percentage: 98.152
Num people: 54, number of experiments with one or more shared birthday: 49223.0, percentage: 98.446
Num people: 55, number of experiments with one or more shared birthday: 49282.0, percentage: 98.564
Num people: 56, number of experiments with one or more shared birthday: 49402.0, percentage: 98.804
Num people: 57, number of experiments with one or more shared birthday: 49514.0, percentage: 99.028
Num people: 58, number of experiments with one or more shared birthday: 49566.0, percentage: 99.132
Num people: 59, number of experiments with one or more shared birthday: 49652.0, percentage: 99.304
Num people: 60, number of experiments with one or more shared birthday: 49727.0, percentage: 99.454
Num people: 61, number of experiments with one or more shared birthday: 49745.0, percentage: 99.49
Num people: 62, number of experiments with one or more shared birthday: 49805.0, percentage: 99.61
Num people: 63, number of experiments with one or more shared birthday: 49829.0, percentage: 99.658
Num people: 64, number of experiments with one or more shared birthday: 49859.0, percentage: 99.718
Num people: 65, number of experiments with one or more shared birthday: 49883.0, percentage: 99.766
Num people: 66, number of experiments with one or more shared birthday: 49902.0, percentage: 99.804
Num people: 67, number of experiments with one or more shared birthday: 49922.0, percentage: 99.844
Num people: 68, number of experiments with one or more shared birthday: 49935.0, percentage: 99.87
Num people: 69, number of experiments with one or more shared birthday: 49959.0, percentage: 99.918
Num people: 70, number of experiments with one or more shared birthday: 49957.0, percentage: 99.914
Num people: 71, number of experiments with one or more shared birthday: 49964.0, percentage: 99.928
Num people: 72, number of experiments with one or more shared birthday: 49970.0, percentage: 99.94
Num people: 73, number of experiments with one or more shared birthday: 49973.0, percentage: 99.946
Num people: 74, number of experiments with one or more shared birthday: 49985.0, percentage: 99.97
Num people: 75, number of experiments with one or more shared birthday: 49982.0, percentage: 99.964
Num people: 76, number of experiments with one or more shared birthday: 49990.0, percentage: 99.98
Num people: 77, number of experiments with one or more shared birthday: 49991.0, percentage: 99.982
Num people: 78, number of experiments with one or more shared birthday: 49993.0, percentage: 99.986
Num people: 79, number of experiments with one or more shared birthday: 49994.0, percentage: 99.988
Num people: 80, number of experiments with one or more shared birthday: 49997.0, percentage: 99.994
Num people: 81, number of experiments with one or more shared birthday: 49997.0, percentage: 99.994
Num people: 82, number of experiments with one or more shared birthday: 49995.0, percentage: 99.99
Num people: 83, number of experiments with one or more shared birthday: 49998.0, percentage: 99.996
Num people: 84, number of experiments with one or more shared birthday: 49998.0, percentage: 99.996
Num people: 85, number of experiments with one or more shared birthday: 49998.0, percentage: 99.996
Num people: 86, number of experiments with one or more shared birthday: 49998.0, percentage: 99.996
Num people: 87, number of experiments with one or more shared birthday: 49999.0, percentage: 99.998
Num people: 88, number of experiments with one or more shared birthday: 50000.0, percentage: 100.0
Num people: 89, number of experiments with one or more shared birthday: 49997.0, percentage: 99.994
Num people: 90, number of experiments with one or more shared birthday: 50000.0, percentage: 100.0
Num people: 91, number of experiments with one or more shared birthday: 50000.0, percentage: 100.0
Num people: 92, number of experiments with one or more shared birthday: 50000.0, percentage: 100.0
Num people: 93, number of experiments with one or more shared birthday: 50000.0, percentage: 100.0
Num people: 94, number of experiments with one or more shared birthday: 50000.0, percentage: 100.0
Num people: 95, number of experiments with one or more shared birthday: 50000.0, percentage: 100.0
Num people: 96, number of experiments with one or more shared birthday: 50000.0, percentage: 100.0
Num people: 97, number of experiments with one or more shared birthday: 50000.0, percentage: 100.0
Num people: 98, number of experiments with one or more shared birthday: 50000.0, percentage: 100.0
Num people: 99, number of experiments with one or more shared birthday: 50000.0, percentage: 100.0
Num people: 100, number of experiments with one or more shared birthday: 50000.0, percentage: 100.0


*/

 
public class CodeCampTester {

    public static void main(String[] args){
        final String newline = System.getProperty("line.separator");
        
        
        // CS314 Students: add tests here.     
        
        
        //test 1, hamming distance
        int[] h1 = {};
        int[] h2 = {};
        int expected = 0;
        int actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println("Test 1 hamming distance: expected value: " + 
                expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 1, hamming distance");
        else
            System.out.println(" ***** FAILED ***** test 1, hamming distance");
        
        // test 2, hamming distance
        h1 = new int[] {2, 2, -2, 5, 6, 17, 8, 49, 1000};
        h2 = new int[] {-1, 2, -6, 98, -3, 2, 8, -6, -67};
        expected = 7;
        actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println(newline + "Test 2 hamming distance: expected value: " 
                + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 2, hamming distance");
        else
            System.out.println(" ***** FAILED ***** test 2, hamming distance");
        
        
        //test 3, isPermutation
        int[] a = {};
        int[] b = {};
        boolean expectedBool = true;
        boolean actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 3 isPermutation: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 3, isPermutation");
        else
            System.out.println(" ***** FAILED ***** test 3, isPermutation");

        //test 4, is Permutation
        b = new int[]{2, 1, 3, 3};
        expectedBool = false;
        actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 4 isPermutation: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 4, isPermutation");
        else
            System.out.println(" ***** FAILED ***** test 4, isPermutation");
        
        
        // test 5, mostVowels
        String[] sList = {"", "", ""};
        int expectedResult = 0;
        int actualResult = CodeCamp.mostVowels(sList);
        System.out.println(newline + "Test 5 mostVowels: expected result: " 
                + expectedResult + ", actual result: " + actualResult);
        if( actualResult == expectedResult )
            System.out.println("passed test 5, mostVowels");
        else
            System.out.println("***** FAILED ***** test 5, mostVowels");

        
        // test 6, mostVowels
        sList = new String[] {null, "", "obvious", "ART+MAth+Old=war+a", "!poll"};
        expectedResult = 3;
        actualResult = CodeCamp.mostVowels(sList);
        System.out.println(newline + "Test 6 mostVowels: expected result: " 
                + expectedResult + ", actual result: " + actualResult);
        if( actualResult == expectedResult )
            System.out.println("passed test 6, mostVowels");
        else
            System.out.println("***** FAILED ***** test 6, mostVowels");
         
        
        //test 7, sharedBirthdays, simple test
        int pairs = CodeCamp.sharedBirthdays(1, 1);
        System.out.println(newline + "Test 7 shared birthdays: expected: 0, actual: " + pairs);
        int expectedShared = 0;
        if( pairs == expectedShared )
            System.out.println("passed test 7, shared birthdays");
        else
            System.out.println("***** FAILED ***** test 7, shared birthdays");
        
        //test 8, sharedBirthdays, simple test
        pairs = CodeCamp.sharedBirthdays(4, 3);
        System.out.println(newline + "Test 8 shared birthdays: expected: " +
                "a value of 1 or more, actual: " + pairs);
        if( pairs > 0 )
            System.out.println("passed test 8, shared birthdays");
        else
            System.out.println("***** FAILED ***** test 8, shared birthdays");        
        
        //test 9, queensAreASafe
        char[][] board = { {'.', '.', '.'},
                          {'.', '.', '.'},
                          {'.', '.', '.'}};
        
        expectedBool = true;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 9 queensAreSafe: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 9, queensAreSafe");
        else
            System.out.println(" ***** FAILED ***** test 9, queensAreSafe");

        //test 10, queensAreASafe
        board = new char[][]{{'.', '.', '.', '.','.','q'},
                             {'.', '.', '.', '.','.','.'},
                             {'.', '.', '.', '.','.','.'},
                             {'.', '.', '.', '.','.','.'},
                             {'.', 'q', '.', '.','.','.'},
                             {'.', '.', '.', '.','.','.'}};
        expectedBool = false;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 10 queensAreSafe: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 10, queensAreSafe");
        else
            System.out.println(" ***** FAILED ***** test 10, queensAreSafe"); 
        
      
        // test 11, getValueOfMostValuablePlot
        int[][] city = {{0,-2, -5, 8,0},
                          {-1, 2, -6, -2, 0},
                          {-2, -1, 4, -1, 0},
                          {-1, -8, 0, 2, -1}};
        
        expected = 8;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 11 getValueOfMostValuablePlot: expected value: " 
                + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 11, getValueOfMostValuablePlot");
        else
            System.out.println(" ***** FAILED ***** test 11, getValueOfMostValuablePlot");

        
        // test 12, getValueOfMostValuablePlot
        city = new int[][] {{1},{-1},{3}};
        expected = 3;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println("\nTest 12 getValueOfMostValuablePlot: expected value: " 
                + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 12, getValueOfMostValuablePlot");
        else
            System.out.println(" ***** FAILED ***** test 12, getValueOfMostValuablePlot");
        
        //test 33, queensAreASafe
        board = new char[][] {{'q', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                             {'.', '.', '.', '.', 'q', '.', '.', '.', '.', '.'},
                             {'.', 'q', '.', '.', '.', '.', '.', '.', '.', '.'},
                             {'.', '.', '.', '.', '.', 'q', '.', '.', '.', '.'},
                             {'.', '.', 'q', '.', '.', '.', '.', '.', '.', '.'},
                             {'.', '.', '.', '.', '.', '.', 'q', '.', '.', '.'},
                             {'.', '.', '.', 'q', '.', '.', '.', '.', '.', '.'},
                             {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                             {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                             {'.', '.', '.', '.', '.', '.', '.', '.', 'q', '.'},};
        expectedBool = false;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 33 queensAreSafe: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 33, queensAreSafe");
        else
            System.out.println(" ***** FAILED ***** test 33, queensAreSafe");  
      //test 30, queensAreASafe
        board = new char[][]{ {'.', '.', '.'},
                          {'q', '.', '.'},
                          {'.', '.', 'q'}};
        
        expectedBool = true;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 30 queensAreSafe: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 30, queensAreSafe");
        else
            System.out.println(" ***** FAILED ***** test 30, queensAreSafe");

        //test 31, queensAreASafe
        board = new char[][]{{'.', '.', '.', 'q'},
                             {'.', '.', '.', '.'},
                             {'.', '.', '.', '.'},
                             {'q', '.', '.', '.'}};
        expectedBool = false;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 31 queensAreSafe: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 31, queensAreSafe");
        else
            System.out.println(" ***** FAILED ***** test 31, queensAreSafe");
        
        
        //test 32, queensAreASafe
        board = new char[][] {{'q', '.', '.', '.', '.', '.', '.'},
                             {'.', '.', '.', '.', 'q', '.', '.'},
                             {'.', 'q', '.', '.', '.', '.', '.'},
                             {'.', '.', '.', '.', '.', 'q', '.'},
                             {'.', '.', 'q', '.', '.', '.', '.'},
                             {'.', '.', '.', '.', '.', '.', 'q'},
                             {'.', '.', '.', 'q', '.', '.', '.'}};
        expectedBool = true;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 32 queensAreSafe: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 32, queensAreSafe");
        else
            System.out.println(" ***** FAILED ***** test 32, queensAreSafe");
  

        
    } // end of main method
    
    // pre: list != null
    private static int[] intListToArray(List<Integer> list) {
        if(list == null)
            throw new IllegalArgumentException("list parameter may not be null.");
        int[] result = new int[list.size()];
        int arrayIndex = 0;
        for(int x : list) {
            result[arrayIndex++] = x;
        }
        return result;
    }
}
