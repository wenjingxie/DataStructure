/*  Student information for assignment:
 *
 *  On <MY> honor, Wenjing Xie, this programming assignment is <MY> own work
 *  and <I> have not provided this code to any other student.
 *
 *  Number of slip days used:0
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


//imports

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Graphics;
import java.awt.Color;

public class Recursive {

    /**
     * Problem 1: convert a base 10 int to binary recursively.<br> 
     *   pre: n >= 0<br>
     *   post: Returns a String that represents N in binary.
     *   All chars in returned String are '1's or '0's. Most significant digit is at position 0
     *   @param n the base 10 int to covnert to base 2
     */
    public String getBinary(int n) {
        if( n < 0) 
            throw new IllegalArgumentException("Failed precondition: getBinary. n must be >= 0. n: " + n);
        
        int quotient = n / 2;
        int remainder = n % 2;
        
        //base case
        if (quotient == 0) {
        	return "" + remainder;
        }
        
        //general steps
        return getBinary(quotient) + remainder;
    }


    /**
     * Problem 2: reverse a String recursively.<br>
     *   pre: stringToRev != null<br>
     *   post: returns a String that is the reverse of stringToRev
     *   @param stringToRev the String to reverse.
     */
    public String revString(String stringToRev) {
        if( stringToRev == null)
            throw new IllegalArgumentException("Failed precondition: revString. parameter may not be null.");
        
        int n = stringToRev.length();
        //base case
        if (n <= 1) {
        	return stringToRev;
        }
        
        //general steps        
        return stringToRev.charAt(n - 1) + revString(stringToRev.substring(0, n - 1));
    }


    /**
     * Problem 3: Returns the number of elements in data 
     * that are followed directly by value that is
     * double that element. 
     * pre: data != null
     * post: return the number of elements in data that are followed immediately by double the value
     */
    public int nextIsDouble(int[] data) {
    	if( data == null)
            throw new IllegalArgumentException("Failed precondition: nextIsDouble. parameter may not be null.");
        return nextIsDoubleHelper(data, 0); 
    }


    // CS314 students, add your nextIsDouble helper method here
    private int nextIsDoubleHelper(int[] data, int currentIndex) {
    	//base case
    	if (currentIndex == data.length - 1 || data.length == 0) {
    		return 0;
    	}
    	
    	//general steps
    	if (data[currentIndex] * 2 == data[currentIndex + 1]) {
    		return 1 + nextIsDoubleHelper(data, currentIndex + 1);
    	}
    	else {
    		return nextIsDoubleHelper(data, currentIndex + 1);
    	}
    }

    /**  Problem 4: Find all combinations of mnemonics for the given number.<br>
     *   pre: number != null, all characters in number are digits<br>
     *   post: see tips section of assignment handout
     *   @param number The number to find mnemonics for
     */
    public ArrayList<String> listMnemonics(String number) {
        if( number == null ||  !allDigits(number))
            throw new IllegalArgumentException("Failed precondition: listMnemonics");

        ArrayList<String> result = new ArrayList<String>();
        recursiveMnemonics(result, "", number);
        return result;
    }


    /*
     * Helper method for listMnemonics
     * mnemonics stores completed mnemonics
     * mneominicSoFar is a partial (possibly complete) mnemonic
     * digitsLeft are the digits that have not been used from the original number
     */
    private void recursiveMnemonics(ArrayList<String> mnemonics, 
            String mnemonicSoFar, String digitsLeft) {

        // CS314 students, complete this method
    	if (digitsLeft.length() == 0) {
    		mnemonics.add(mnemonicSoFar);
    	}
    	
    	else {
    		String digitLetterToCom = digitLetters(digitsLeft.charAt(0));
    		digitsLeft = digitsLeft.substring(1);
    		int length = digitLetterToCom.length();
    		for (int i = 0; i < length; i++) {
    			String newMnemonicSoFar = mnemonicSoFar + digitLetterToCom.charAt(i);
    			recursiveMnemonics(mnemonics, newMnemonicSoFar, digitsLeft);
    		}
    	}
    }

    
    // used by method digitLetters
    private static final String[] letters = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};


    /* helper method for recursiveMnemonics
     * pre: ch is a digit '0' through '9'
     * post: return the characters associated with this digit on a phone keypad
     */
    private String digitLetters(char ch) {
        assert ('0' <= ch) && (ch <= '9') : "Failed precondition: digitLetters";
        int index = ch - '0';
        return letters[index];
    }


    /* helper method for listMnemonics
     * pre: s != null
     * post: return true if every character in s is a digit ('0' through '9')
     * */
    private boolean allDigits(String s) {
        assert s != null : "Failed precondition: allDigits";
        boolean allDigits = true;
        int i = 0;
        while(i < s.length() && allDigits){
            allDigits = s.charAt(i) >= '0' && s.charAt(i) <= '9';
            i++;
        }
        return allDigits;
    }


    /**
     * Problem 5: Create a DrawingPanel and place Sierpinski triangles in it. 
     * The lower left corner shall be 20 pixels 
     * from the left edge of the window
     * and 20 pixels from the bottom of the window.
     * @param windowSize > 20
     * @param minSideLength > 4
     * @param startingSideLength > minSideLength
     */
    public void drawTriangles(int windowSize, 
            int minSideLength, int startingSideLength){

        DrawingPanel p = new DrawingPanel(windowSize, windowSize);
        Graphics g = p.getGraphics();
        g.setColor(Color.BLUE);
        drawTriangles(minSideLength, startingSideLength, 20, windowSize - 20, g);
    }

    // helper method for drawTriangles
    private void drawTriangles(int minSideLength, double currentSideLength, 
            double x1, double y1, Graphics g) {
    	//base case
		
    	if ((int) currentSideLength <= minSideLength) {
    		int[] x = new int[3];
    		int[] y = new int[3];
    		x[0] = (int) x1;
    		x[1] = (int) (x1 + 0.5 * currentSideLength);
    		x[2] = (int) (x1 + currentSideLength);
    		y[0] = (int) y1;
    		y[1] = (int) (y1 - 0.5 * Math.sqrt(3) * currentSideLength);
    		y[2] = (int) y1;
    		g.fillPolygon(x, y, 3);
    	}

    	//general steps
    	else {
    		double x2 = x1 + 0.25 * currentSideLength;
    		double x3 = x1 + 0.5 * currentSideLength;
    		double y2 = y1 - 0.25 * Math.sqrt(3) * currentSideLength;
    		double y3 = y1;
    		drawTriangles(minSideLength, currentSideLength/2, x1, y1, g);
    		drawTriangles(minSideLength, currentSideLength/2, x2, y2, g);
    		drawTriangles(minSideLength, currentSideLength/2, x3, y3, g);
    	}
    }


    /**
     * Problem 6: Draw a Sierpinski Carpet.
     * @param size the size in pixels of the window
     * @param limit the smallest size of a sqauer in the carpet.
     */
    public void drawCarpet(int size, int limit) {
        DrawingPanel p = new DrawingPanel(size, size);
        Graphics g = p.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,size,size);
        g.setColor(Color.WHITE);
        drawSquares(g, size, limit, 0, 0);
    }


    /* Helper method for drawCarpet
     * Draw the individual squares of the carpet.
     * @param g The Graphics object to use to fill rectangles
     * @param size the size of the current square
     * @param limit the smallest allowable size of squares
     * @param x the x coordinate of the upper left corner of the current square
     * @param y the y coordinate of the upper left corner of the current square
     */
    private static void drawSquares(Graphics g, int size, int limit, double x, double y) {
    	if (size > limit) {
    		double x1 = x + size / 3;
    		double x2 = x + 2 * size / 3;
    		double y1 = y + size / 3;
    		double y2 = y + 2 * size / 3;
    		g.fillRect((int)x1, (int)y1, size/3, size/3);
    		drawSquares(g, size/3, limit, x, y);
    		drawSquares(g, size/3, limit, x, y1);
    		drawSquares(g, size/3, limit, x, y2);
    		drawSquares(g, size/3, limit, x1, y);
    		drawSquares(g, size/3, limit, x1, y2);
    		drawSquares(g, size/3, limit, x2, y);
    		drawSquares(g, size/3, limit, x2, y1);
    		drawSquares(g, size/3, limit, x2, y2);
    	}

    }

    // size of Sudoko board
    /**
     * The size of the Sudoko board. Value will be a perfect square greater than 0.
     */
    public static final int BOARD_SIZE = 9; // must be perfect square
    
    /**
     * The size of a mini marix on the Sudoko board.
     */
    public static final int MINI_SIZE = (int)(Math.sqrt(BOARD_SIZE));


    /** 
     * Problem 7: Find a solution to a Sudoko puzzle. 
     * <br>pre: board != null, board is 9 by 9. 
     * <br>post: return a board that is the solved puzzle 
     * or a copy of the original board if there is no solution
     * @param startBoard The starting board. 
     * Empty values = 0, given values = 1 through 9 may not be changed
     */
    public int[][] getSudokoSolution(int[][] startBoard) {
        if(startBoard == null || startBoard.length != BOARD_SIZE || startBoard[0].length != BOARD_SIZE)
            throw new IllegalArgumentException("Violation of precondition in getSudo");

        // store solution in board so we don't change startBoard
        int[][] board = copyBoard(startBoard); 

        // CS314 students. Call your recursive method here!
        int[] index = findNextZero(board);
        
        boolean solved = canSolveSudoko(board, index[0], index[1]);
        //System.out.println(solved);
        if (solved) {
        	return board;
        }
        else {
        	return startBoard;
        }
    }


    // CS314 students, add your recursive sudoko solver method here
    private boolean canSolveSudoko(int[][] board, int row, int col) {
    	if (row == BOARD_SIZE) {
    		return true;
    	}
    	boolean solved = false;
    	for (int i = 1; i < 10 && !solved; i++) {
    		board[row][col] = i;
    		if (digitsOkay(board, row, col)) {
    			int[] index = findNextZero(board);
    			solved = canSolveSudoko(board, index[0], index[1]);
    		}
    	}
    	if (!solved) {
    		board[row][col] = 0;
    	}
        return solved; 
    }

    private int[] findNextZero(int[][] board) {
    	int index[] = new int[2];
    	for (int row = 0; row < BOARD_SIZE; row++) {
    		for (int col = 0; col < BOARD_SIZE; col++) {
    			if (board[row][col] == 0) {
    				index[0] = row;
    				index[1] = col;
    				return index;
    			}
    		}
    	}
    	index[0] = BOARD_SIZE;
    	index[1] = 0;
    	return index;
    }
    // helper method to make a copy of a sudoko.
    // CS314 students, you DO NOT need to call this method.
    private static int[][] copyBoard(int[][] startBoard) {
        int[][] result = new int[startBoard.length][];
        for(int r = 0; r < result.length; r++)
            result[r] = Arrays.copyOf(startBoard[r], startBoard[r].length);
        return result;
    }



    // Helper method check to ensure no digit other than zero
    // is repeated in a given row, column, or mini matrix.
    private static boolean digitsOkay(int[][] board, int row, int col) {
        return portionOkay(row, 0, 0, 1, board) &&
        portionOkay(0, col, 1, 0, board) &&
        miniMatrixOkay(row, col, board);

    }



    // helper method to see if no repeat digits (other than 0) in a row or column
    // CS314 students, you don't need to call this method directly
    private static boolean portionOkay(int rowStart, int colStart, int rowChange, int colChange, int[][] board) {
        // check digits in row or column. 
        // for all non zero digits update array of booleans. if digit appears twice then
        // used[digit] is set to true first time and we return false second time
        boolean[] used = new boolean[BOARD_SIZE + 1]; // don't use zero element in array

        // pretty GACKY, change to while loop?
        for(int i = 0, row = rowStart, col = colStart; i < BOARD_SIZE; i++, row += rowChange, col += colChange) {
            int digit = board[row][col];
            if(digit != 0){
                if(used[digit])
                    return false; // duplicate!!
                used[digit] = true; // mark as used
            }
        }
        return true; // no repeats found!
    }

    // helper to check that no digits other than 0 are
    // repeated in the mini matrix cell row, col
    // is a part of.
    // CS314 students, you don't need to call this method directly
    private static boolean miniMatrixOkay(int row, 
            int col, int[][] board) {

        boolean[] used = new boolean[BOARD_SIZE + 1];

        // figure out upper left indices for mini matrix
        // we need to check

        // row 0,1,2 -> 0, row 3, 4, 5 -> 3, row 6, 7, 8 -> 6 
        // same logic for column
        row = (row / MINI_SIZE) * MINI_SIZE;
        col = (col / MINI_SIZE) * MINI_SIZE;

        for(int r = 0; r < 3; r++)
            for(int c = 0; c < 3; c++)  {
                int digit = board[row + r][col + c];
                if(digit != 0){
                    if(used[digit])
                        return false; // duplicate!!
                    used[digit] = true; // mark as used
                }
            }
        return true;
    }    


    /**
     * Problem 8: Determine if water at a given point 
     * on a map can flow off the map.
     * <br>pre: map != null, map.length > 0, 
     * map is a rectangular matrix, 0 <= row < map.length, 0 <= col < map[0].length
     * <br>post: return true if a drop of water starting at the location 
     * specified by row, column can reach the edge of the map, false otherwise.
     * @param map The elevations of a section of a map.
     * @param row The starting row of a drop of water.
     * @param col The starting column of a drop of water.
     */
    public boolean canFlowOffMap(int[][] map, int row, int col) {
        if( map == null || map.length == 0 || !isRectangular(map) || !inbounds(row, col, map))
            throw new IllegalArgumentException("Failed precondition: canFlowOffMap");
        
        //base case
        if (row == 0 || row == map.length - 1 || col == 0 || col == map[0].length - 1) {
        	return true;
        }
        
        boolean solved = false;
        if (map[row - 1][col] < map[row][col]) {
        	solved = canFlowOffMap(map, row - 1, col);
        }
        
        if (!solved) {
        	if (map[row + 1][col] < map[row][col]) {
            	solved = canFlowOffMap(map, row + 1, col);
            }
        }

        if (!solved) {
        	if (map[row][col - 1] < map[row][col]) {
            	solved = canFlowOffMap(map, row, col - 1);
            }
        }
        
        if (!solved) {
        	if (map[row][col + 1] < map[row][col]) {
            	solved = canFlowOffMap(map, row, col + 1);
            }
        }       
        return solved; 
    }

    /* helper method for canFlowOfMap - CS314 students you should not have to 
     * call this method,
     * pre: mat != null, 
     */
    private boolean inbounds(int r, int c, int[][] mat) {
        assert mat != null : "Failed precondition: inbounds";
        return r >= 0 && r < mat.length && mat[r] != null && c >= 0 && c < mat[r].length;
    }

    /* 
     * helper method for canFlowOfMap - CS314 students you should not have to 
     * call this method,
     * pre: mat != null, mat.length > 0
     * post: return true if mat is rectangular
     */
    private static boolean isRectangular(int[][] mat) {
        assert (mat != null) && (mat.length > 0) : "Violation of precondition: isRectangular";

        boolean correct = true;
        final int numCols = mat[0].length;
        int row = 0;
        while( correct && row < mat.length) {
            correct = (mat[row] != null) && (mat[row].length == numCols);
            row++;
        }
        return correct;
    }


    /**
     * Problem 9: Find the minimum difference possible between teams
     * based on ability scores. The number of teams may be greater than 2.
     * The goal is to minimize the difference between the team with the 
     * maximum total ability and the team with the minimum total ability.
     * <br> pre: numTeams >= 2, abilities != null, abilities.length >= numTeams
     * <br> post: return the minimum possible difference between the team
     * with the maximum total ability and the team with the minimum total
     * ability. 
     * @param numTeams the number of teams to form. 
     * Every team must have at least one member
     * @param abilities the ability scores of the people to distribute
     * The return value will be greater than or equal to 0.
     */
    public int minDifference(int numTeams, int[] abilities) {
    	if (numTeams > abilities.length) {
    		return -1;
    	}
    	int minDiff = Integer.MAX_VALUE;
    	int[] numPersonPerTeam = new int[numTeams];
    	int[] abilitiesPerTeam = new int[numTeams];
    	return recursiveMinDifference(minDiff, numPersonPerTeam, abilitiesPerTeam, abilities, 0);
    }
    
    private int recursiveMinDifference(int minDiff, int[] numPersonPerTeam, int[] abilitiesPerTeam, int[] abilities, int indexOfAbilities) {
    	if (numTeamsWithoutPerson(numPersonPerTeam) == abilities.length - indexOfAbilities) {
    		int[] copyAbilitiesPer = new int[abilitiesPerTeam.length];
    		int copyIndex = indexOfAbilities;
     		for (int i = 0; i < numPersonPerTeam.length; i++) {
    			copyAbilitiesPer[i] = abilitiesPerTeam[i];
    			if (numPersonPerTeam[i] == 0) {
    				copyAbilitiesPer[i] = abilities[copyIndex];
    				copyIndex++;
    			}
    		}
    		Arrays.sort(copyAbilitiesPer);
    		int diff = copyAbilitiesPer[abilitiesPerTeam.length - 1] - copyAbilitiesPer[0];
    		if (diff < minDiff) {
    			minDiff = diff;
    		}
    		return minDiff;
    	}
    	
    	else {
    		for (int i = 0; i < abilitiesPerTeam.length; i++) {
    			//System.out.println(indexOfAbilities);
    			numPersonPerTeam[i] += 1;
    			abilitiesPerTeam[i] += abilities[indexOfAbilities];
    			minDiff = recursiveMinDifference(minDiff, numPersonPerTeam, abilitiesPerTeam, abilities, indexOfAbilities + 1);
    			numPersonPerTeam[i] -= 1;
    			abilitiesPerTeam[i] -= abilities[indexOfAbilities];

    		}
    	}
    	return minDiff;
    }
    
    private int numTeamsWithoutPerson(int[] numPersonPerTeam) {
    	int count = 0;
    	for (int num : numPersonPerTeam) {
    		if (num == 0) {
    			count++;
    		}
    	}
    	return count;
    	
    }
}