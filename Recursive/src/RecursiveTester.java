/*  Student information for assignment:
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


import java.util.ArrayList;
import java.util.Collections;

public class RecursiveTester {
    public static void main(String[] args) {
        Recursive r = new Recursive();
        studentTests(r);

    }

    // pre: r != null
    // post: run student test
    private static void studentTests(Recursive r) {
        // CS314 students put your tests here
    	String actualBinary = r.getBinary(1024);
        String expectedBinary = "10000000000";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 1.1 passed. get binary.");
        else
            System.out.println( "Test 1.1 failed. get binary.");
        
        actualBinary = r.getBinary(2);
        expectedBinary = "10";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 1.2 passed. get binary.");
        else
            System.out.println( "Test 1.2 failed. get binary.");
        
        actualBinary = r.getBinary(2);
        expectedBinary = "10";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 1.2 passed. get binary.");
        else
            System.out.println( "Test 1.2 failed. get binary.");
        
        actualBinary = r.getBinary(1002256);
        expectedBinary = "11110100101100010000";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 1.3 passed. get binary.");
        else
            System.out.println( "Test 1.3 failed. get binary.");
        
        
        String actualRev = r.revString("");
        String expectedRev = "";
        if( actualRev.equals(expectedRev) )
            System.out.println( "Test 2.1 passed. reverse string.");
        else
            System.out.println( "Test 2.1 failed. reverse string.");
        
        actualRev = r.revString("AsSa");
        expectedRev = "aSsA";
        if( actualRev.equals(expectedRev) )
            System.out.println( "Test 2.2 passed. reverse string.");
        else
            System.out.println( "Test 2.2 failed. reverse string.");
        
        actualRev = r.revString("University of Texas !@#@!$");
        expectedRev = "$!@#@! saxeT fo ytisrevinU";
        if( actualRev.equals(expectedRev) )
            System.out.println( "Test 2.3 passed. reverse string.");
        else
            System.out.println( "Test 2.3 failed. reverse string.");
        
        int[] numsForDouble = {1, 0, 4, 0, 16, 0, 64, 0, 256};
        int actualDouble = r.nextIsDouble(numsForDouble);
        int expectedDouble = 0;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 3.1 passed. next is double.");
        else
            System.out.println( "Test 3.1 failed. next is double.");

        
        numsForDouble = new int[] {0, 0, 0, 0, 1, 2, -4, 0, 256};
        actualDouble = r.nextIsDouble(numsForDouble);
        expectedDouble = 4;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 3.2 passed. next is double.");
        else
            System.out.println( "Test 3.2 failed. next is double.");
        
        numsForDouble = new int[] {0};
        actualDouble = r.nextIsDouble(numsForDouble);
        expectedDouble = 0;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 3.3 passed. next is double.");
        else
            System.out.println( "Test 3.3 failed. next is double.");
        
        ArrayList<String> mnemonics = r.listMnemonics("51");
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("J1");
        expected.add("K1");
        expected.add("L1");
        if( mnemonics.equals(expected))
            System.out.println( "Test 4.1 passed. Phone mnemonics.");
        else
            System.out.println( "Test 4.1 failed. Phone mnemonics.");

        mnemonics = r.listMnemonics("340");
        Collections.sort(mnemonics);
        expected.clear();
        expected.add("DG0");
        expected.add("DH0");
        expected.add("DI0");
        expected.add("EG0");
        expected.add("EH0");
        expected.add("EI0");
        expected.add("FG0");
        expected.add("FH0");
        expected.add("FI0");
        Collections.sort(expected);
        if( mnemonics.equals(expected))
            System.out.println( "Test 4.2 passed. Phone mnemonics.");
        else
            System.out.println( "Test 4.2 failed. Phone mnemonics.");
        
        
        mnemonics = r.listMnemonics("9108");
        Collections.sort(mnemonics);
        expected.clear();
        expected.add("W10T");
        expected.add("W10U");
        expected.add("W10V");
        expected.add("X10T");
        expected.add("X10U");
        expected.add("X10V");
        expected.add("Y10T");
        expected.add("Y10U");
        expected.add("Y10V");
        expected.add("Z10T");
        expected.add("Z10U");
        expected.add("Z10V");
        Collections.sort(expected);
        if( mnemonics.equals(expected))
            System.out.println( "Test 4.3 passed. Phone mnemonics.");
        else
            System.out.println( "Test 4.3 failed. Phone mnemonics.");
        
        String puzzle1 = "406107000050900200830006700904860032180370054500010978200090016307052480695401327";
        int[][] board = stringToBoard(puzzle1);
        int[][] result = r.getSudokoSolution(board);
        String actualBoard = boardToString(result);
        String expectedBoard = "426137895751948263839526741974865132182379654563214978248793516317652489695481327";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 7.1 passed. sudoko solver.");
        else {
            System.out.println("Test 7.1 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            printBoard(result);
        }
        
        
        String puzzle2 = "000610004009008012000004080600290300750000800200000460007580000020006000086007005";
        board = stringToBoard(puzzle2);
        result = r.getSudokoSolution(board);
        actualBoard = boardToString(result);
        expectedBoard = "872619534469358712135724986648291357751463829293875461917582643524936178386147295";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 7.2 passed. sudoko solver.");
        else {
            System.out.println("Test 7.2 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            printBoard(result);
        }
        
        String puzzle3 = "000610004009008012000004080600290300750000800200000460007580000020006000086007003";
        assert puzzle3.length() == 81;
        board = stringToBoard(puzzle3);
        result = r.getSudokoSolution(board);
        actualBoard = boardToString(result);
        expectedBoard = "000610004009008012000004080600290300750000800200000460007580000020006000086007003";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 7.3 passed. sudoko solver.");
        else {
            System.out.println("Test 7.3 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            printBoard(result);
        }
        
        
        int[][] world = {{0,1,5,125,90,5,78,100},
                {1,3,20,25,80,70,120,140},
                {4,10,70,30,40,50,180,160},
                {7,20,120,90,200,130,150,30},
                {5,90,130,120,110,120,110,20},
                {3,70,170,80,80,99,78,76},
                {2,20,180,70,90,80,79,199},
                {9,8,6,90,70,50,100,200},
                {200,200,180,78,29,56,81,120}};

        if( r.canFlowOffMap(world,8,7))
            System.out.println( "Test 8.1 passed. can flow off map.");
        else
            System.out.println( "Test 8.1 failed. can flow off map.");

        if( !r.canFlowOffMap(world,4,4))
            System.out.println( "Test 8.2 passed. can flow off map.");
        else
            System.out.println( "Test 8.2 failed. can flow off map.");

        if( r.canFlowOffMap(world,4,3))
            System.out.println( "Test 8.3 passed. can flow off map.");
        else
            System.out.println( "Test 8.3 failed. can flow off map.");

        if( r.canFlowOffMap(world,6,6))
            System.out.println( "Test 8.4 passed. can flow off map.");
        else
            System.out.println( "Test 8.4 failed. can flow off map.");
        
        
        int[] abilities = {-1, 2, 3, 4, -5, 6, 7};
        if(r.minDifference(4, abilities) == 2)
            System.out.println( "Test 9.1 passed. min difference.");
        else
            System.out.println( "Test 9.1 failed. min difference.");

        if(r.minDifference(2, abilities) == 0)
            System.out.println( "Test 9.2 passed. min difference.");
        else
            System.out.println( "Test 9.2 failed. min difference.");

        abilities = new int[] {8, 2, 3, 4, 8, 6, 7};
        if(r.minDifference(5, abilities) == 1)
            System.out.println( "Test 9.4 passed. min difference.");
        else
            System.out.println( "Test 9.4 failed. min difference.");


    }

    private static String boardToString(int[][] board) {
        StringBuilder result = new StringBuilder(81);
        for(int r = 0; r < board.length; r++)
            for(int c = 0; c < board[r].length; c++)
                result.append(board[r][c]);
        return result.toString();
    }

    private static int[][] stringToBoard(String puzzle) {
        int[][] result = new int[Recursive.BOARD_SIZE][Recursive.BOARD_SIZE];
        int index = 0;
        for(int r = 0; r < result.length; r++)
            for(int c = 0; c < result.length; c++, index++)
                result[r][c] = puzzle.charAt(index) - '0';
        return result;
    }

    private static void printBoard(int[][] board) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                System.out.print(board[r][c]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}