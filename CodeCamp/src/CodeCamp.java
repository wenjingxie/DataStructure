//  CodeCamp.java - CS314 Assignment 1

/*  Student information for assignment:
 * 
 * replace <NAME> with your name.
 *
 *  On my honor, Wenjing Xie, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Wenjing Xie
 *  email address: wenjing.xie@utexas.edu
 *  UTEID: wx674
 *  Section 5 digit ID: 90130
 *  Grader name: John
 *  Number of slip days used on this assignment: 0
 */

import java.util.Random;

public class CodeCamp {
  
    /**
     * Determine the Hamming distance between two arrays of ints. 
     * Neither the parameter <tt>aList</tt> or
     * <tt>bList</tt> are altered as a result of this method.<br>
     * @param aList != null, aList.length == bList.length
     * @param bList != null, bList.length == aList.length
     * @return the Hamming Distance between the two arrays of ints.
     */    
    public static int hammingDistance(int[] aList, int[] bList) {
        // check preconditions
        if (aList == null || bList == null || aList.length != bList.length) 
            throw new IllegalArgumentException("Violation of precondition: " +
            		"hammingDistance. neither parameter may equal null, arrays" +
            		" must be equal length.");
        
        /*CS314 STUDENTS: INSERT YOUR CODE HERE*/
        int n = aList.length;
        int count = 0;
        for (int i=0; i < n; i++) {
        	if (aList[i] != bList[i])
        		count++;
        }   
        
        return count; 
    }
    
    
    /**
     * Determine if one array of ints is a permutation of another.
     * Neither the parameter <tt>listA</tt> or 
     * the parameter <tt>listB</tt> are altered as a result of this method.<br>
     * @param listA != null
     * @param listB != null
     * @return <tt>true</tt> if listB is a permutation of listA, 
     * <tt>false</tt> otherwise
     * 
    */
    public static int[] SortList(int[] list) {
    	int passValue = 0;
    	int[] copyList = new int[list.length];
    	for (int m=0; m < list.length; m++)
    		copyList[m] = list[m];
    	for (int i=0; i < copyList.length-1; i++) {
    		for (int j=0; j+1 < copyList.length-i; j++) {
    			if (copyList[j] < copyList[j+1]) {
    				passValue = copyList[j];
    				copyList[j] = copyList[j+1];
    				copyList[j+1] = passValue;
    			}
    		}
    	}
    	return copyList;
    }
    public static boolean isPermutation(int[] listA, int[] listB) {
        // check preconditions
        if (listA == null || listB == null) 
            throw new IllegalArgumentException("Violation of precondition: " +
            		"isPermutation. neither parameter may equal null.");
        /*CS314 STUDENTS: INSERT YOUR CODE HERE*/
        if (listA.length != listB.length)
        	return false;      
        else if (hammingDistance(SortList(listA),SortList(listB)) == 0) //After sorting, the permutation should be the same
        	return true;      	
        else
        	return false;      	
    }
    
    
    /**
     * Determine the index of the String that 
     * has the largest number of vowels. 
     * Vowels are defined as <tt>'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 
     * 'U', and 'u'</tt>.
     * The parameter <tt>list</tt> is not altered as a result of this method.
     * <p>pre: <tt>list != null</tt>, <tt>list.length > 0</tt>, there is an least 1 non null element in list
     * <p>post: return the index of the non-null element in list that has the 
     * largest number of characters that are vowels.
     * If there is a tie return the index closest to zero. 
     * The empty String, "", has zero vowels.
     * It is possible for the maximum number of vowels to be 0.<br>
     * @param list the array to check
     * @return the index of the non-null element in list that has 
     * the largest number of vowels.
     */
    public static int mostVowels(String[] list) {
        // check preconditions
        if (list == null || list.length == 0 || !atLeastOneNonNull(list))  
            throw new IllegalArgumentException("Violation of precondition: " +
            		"mostVowels. parameter may not equal null and must contain " +
            		"at least one none null value.");
       

        // CS314 STUDENTS: ADD YOUR CODE HERE
        //  You can use all methods from the String class and native arrays.
        // find the count of vowels in every element of string list
        String[] vowels = new String[] {"A", "a", "E", "e", "I", "i", "O","o"};
        int[] count = new int[list.length]; // create count array for every element of string list
        for (int i=0; i < list.length; i++) {
        	count[i] = -1; //initialize the count of vowels of every element of string list as -1
        	if (list[i] != null) {
        		count[i] = 0; // except null, set count as 0
        			for (int j=0; j < list[i].length(); j++) {
                    	for (String item : vowels) {
                    		if (list[i].substring(j,j+1).contains(item)) //compare every character of string with every vowel
                    			count[i]++; 
                 		}
        			}
        	}
        }
        // find the index of mostvowels 
        int index = 0;
        int maxCount = count[index];
        for (int i=0; i < list.length; i++) {
        	if (count[i] > maxCount) {
        		index = i;
        		maxCount = count[i];
        	}
        }

        return index; 
    }
    


	/**
     * Perform an experiment simulating the birthday problem.
     * Pick random birthdays for the given number of people. 
     * Return the number of pairs of people that share the
     * same birthday.<br>
     * @param numPeople The number of people in the experiment.
     * This value must be > 0
     * @param numDaysInYear The number of days in the year for this experiement.
     * This value must be > 0
     * @return The number of pairs of people that share a birthday 
     * after running the simulation.
     */
    public static int sharedBirthdays(int numPeople, int numDaysInYear) {
        // check preconditions
        if (numPeople <= 0 || numDaysInYear <= 0)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"sharedBirthdays. both parameters must be greater than 0. " +
                    "numPeople: " + numPeople + 
                    ", numDaysInYear: " + numDaysInYear);
        
        //CS314 STUDENTS: ADD YOUR CODE HERE
        // generate random birthdays
        int[] birthdays = new int[numPeople];
        for (int i=0; i < numPeople; i++)
        	birthdays[i] = (int) (Math.random()*numDaysInYear);
        // find the pairs of people that share same birthday
        int count = 0;
        for (int i=0; i < numPeople-1; i++) {
        	for (int j=i+1; j < numPeople; j++) {
        		if (birthdays[i] == birthdays[j])
        			count++;
        		
        	}
        }
        return count;
    }
    
    
    /**
     * Determine if the chess board represented by board is a safe set up.
     * <p>pre: board != null, board.length > 0, board is a square matrix.
     * (In other words all rows in board have board.length columns.),
     * all elements of board == 'q' or '.'. 'q's represent queens, '.'s
     * represent open spaces.<br>
     * <p>post: return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
     * the parameter <tt>board</tt> is not altered as a result of 
     * this method.<br>
     * @param board the chessboard
     * @return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
    */
    public static boolean queensAreSafe(char[][] board) {
        char[] validChars = {'q', '.'};
        // check preconditions
        if (board == null || board.length == 0 || !isSquare(board) 
                || !onlyContains(board, validChars))
            throw new IllegalArgumentException("Violation of precondition: " +
            		"queensAreSafe. The board may not be null, must be square, " +
            		"and may only contain 'q's and '.'s");        
                
      //CS314 STUDENTS: ADD YOUR CODE HERE
        for (int i=0; i < board.length; i++) {
        	for (int j=0; j < board.length; j++) {
        		if (board[i][j] == 'q') {
        			// check same row
    				for (int k=j+1; k < board.length; k++) {
    					if (board[i][k] == 'q')
    						return false;
    				}
        			//check same column
        			for (int m=0; m < board.length; m++){
            				if (board[m][j] == 'q' & m != i)
            					return false;	

        			}
        			 //check diagonals
        			for (int n=1; i+n < board.length & j+n < board.length; n++) {
    					if (board[i+n][j+n] == 'q')
    						return false;
        		    }
        			
        			for (int h=1; i-h >= 0 & j-h >= 0; h++) {
    					if (board[i-h][j-h] == 'q')
    						return false;
        		    }
        			for (int l=1; i+l < board.length & j-l >= 0; l++) {
    					if (board[i+l][j-l] == 'q')
    						return false;
        		    }
        			for (int g=1; i-g >= 0 & j+g < board.length; g++) {
    					if (board[i-g][j+g] == 'q')
    						return false;
        		    }
 
        	    }
            }
        }
      return true; 
    }
    
    
    /**
     * Given a 2D array of ints return the value of the
     * most valuable contiguous sub rectangle in the 2D array.
     * The sub rectangle must be at least 1 by 1. 
     * <p>pre: <tt>mat != null, mat.length > 0, mat[0].length > 0,
     * mat</tt> is a rectangular matrix.
     * <p>post: return the value of the most valuable contigous sub rectangle
     * in <tt>city</tt>.<br>
     * @param city The 2D array of ints representing the value of
     * each block in a portion of a city.
     * @return return the value of the most valuable contigous sub rectangle
     * in <tt>city</tt>.
     */
    public static int getValueOfMostValuablePlot(int[][] city) {
        // check preconditions
        if (city == null || city.length == 0 || city[0].length == 0 
                || !isRectangular(city) )
            throw new IllegalArgumentException("Violation of precondition: " +
            		"getValueOfMostValuablePlot. The parameter may not be null," +
            		" must value at least one row and at least" +
                    " one column, and must be rectangular."); 
        

        //CS314 STUDENTS: ADD YOUR CODE HERE
        int totalmax = city[0][0];
		int max = city[0][0]; // max value of all sub rectangular consisting with city[i][j]
		int before = 0;
		int current = 0;
		int compare = 0;
        for (int i=0; i < city.length; i++) {
        	for (int j=0; j < city[0].length; j++) {
        		//generate add_row_city from element city[i][j]
        		//add_row_city[i][j] = city[i][0] + city[i][1] + ... + city[i][j], 
        		//those elements in add_row_city represent the sub rectangular consisting of city[i][j],
        		//and for the sub rectangular: the length of rows is always 1, the length of column is varying from 1 to city[0].length - j
        		//find the max value in add_row_city
        		int[][] add_row_city = new int[city.length - i][city[0].length - j];
        		max = city[i][j];
        		for (int m=i; m < city.length; m++) {
            		before = 0;
            		current = 0;
        			for (int n=j; n < city[0].length; n++) {
        				current = before + city[m][n];
        				add_row_city[m - i][n - j] = current;
        				before = current;
        				if (current > max)
        					max = current;
        			}
        		}
        		//beside the sub rectangular above, generating left sub rectangular consisting of city[i][j]
        		//we could get those sub rectangular with length of column changing from 1 to add_row_city.length 
        		//find max from those sub_rectangular 
        		for (int h=0; h < add_row_city[0].length; h++) {
            		compare = add_row_city[0][h];
        			for (int k = 1; k < add_row_city.length; k++) {
        				compare += add_row_city[k][h];
        				if (compare > max)
        					max = compare;
        			}
        		}
        		if (max > totalmax) 
        			totalmax = max;
        	}
        }

        return totalmax; 
    }
    
    
    // !!!!! ***** !!!!! ***** !!!!! ****** !!!!! ****** !!!!! ****** !!!!!!
    // CS314 STUDENTS: Put your birthday problem experiment code here:
    // calculate average number of pairs of people with shared birthdays
    public static int birthdayExperiment1(int numExperiment, int numPeople, int numDaysInYear) {
    	int numPairs = 0;
    	int averageNumPairs = 0;
    	for (int i=0; i < numExperiment; i++) {
    		numPairs += sharedBirthdays(numPeople, numDaysInYear);
    	}
        averageNumPairs = numPairs/numExperiment;
    	return averageNumPairs;
    }
    
    //determine the percentage of experiments where at least one pair of people shared a birthday
    public static int birthdayExperiment2(int numExperiment, int numPeople, int numDaysInYear) {
    	int numAtLeastOnePair = 0;
    	for (int i=0; i < numExperiment; i++) {
    		if (sharedBirthdays(numPeople, numDaysInYear) >= 1)
    			numAtLeastOnePair ++;
    	}
    	return numAtLeastOnePair;
    }
    
    // pre: list != null
    // post: return true if at least one element in list is null
    // otherwise return false.
    private static boolean atLeastOneNonNull(String[] list) {
        // check precondition
        if(list == null)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"atLeastOneNonNull. parameter may not equal null.");
        
        boolean foundNonNull = false;
        int i = 0;
        while( !foundNonNull && i < list.length ){
            foundNonNull = list[i] != null;
            i++;
        }
        return foundNonNull;
    }
    
    
    /* pre: mat != null
    post: return true if mat is a square matrix, false otherwise
     */
    private static boolean isSquare(char[][] mat) {
        if(mat == null)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"isSquare. paremeter may not be null.");

        final int numRows = mat.length;
        int row = 0;
        boolean isSquare = true;
        while( isSquare && row < numRows ) {
            isSquare = ( mat[row] != null) && (mat[row].length == numRows);
            row++;
        }
        return isSquare;
    }
    
    
    /* pre: mat != null, valid != null
    post: return true if all elements in mat are one of the characters in valid
     */
    private static boolean onlyContains(char[][] mat, char[] valid) {
        // check preconditions
        if(mat == null || valid == null)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"onlyContains. paremeters may not be null.");
        
        int row = 0;
        boolean correct = true;
        while( correct && row < mat.length) {
            int col = 0;
            while(correct && col < mat[row].length) {
                correct = contains(valid, mat[row][col]);
                col++;
            }
            row++;
        }
        return correct;
    }
    
    
    /*  pre: list != null
        post: return true if c is in list
     */
    private static boolean contains(char[] list, char tgtChar) {
        // check preconditions
        if(list == null)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"contains. paremeter may not be null.");

        boolean found = false;
        int index = 0;
        while( !found && index < list.length) {
            found = list[index] == tgtChar;
            index++;
        }
        return found;
    }
   
    
     // pre: mat != null, mat.length > 0
     // post: return true if mat is rectangular
    private static boolean isRectangular(int[][] mat) {
        // check preconditions
        if(mat == null || mat.length == 0)
            throw new IllegalArgumentException("Violation of precondition: " +
            		"isRectangular. paremeter may not be null and must contain" +
            		" at least one row.");

        boolean correct = mat[0] != null;
        int row = 0;
        while(correct && row < mat.length) {
            correct = (mat[row] != null) && (mat[row].length == mat[0].length);
            row++;
        }
        return correct;
    }
    
    // make constructor pirvate so no instances of CodeCamp can be created
    private CodeCamp() {
        
    }
}