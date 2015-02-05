/*  Student information for assignment:
 *
 *  On my honor, Wenjing Xie, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: wx674	
 *  email address: wenjing.xie@utexas.edu
 *  Grader name: Eric
 *  Number of slip days I am using: 0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class NameSurfer {

	// constants for menu choices
	public static final int SEARCH = 1;
	public static final int ONE_NAME = 2;
	public static final int APPEAR_ONCE = 3;
	public static final int APPEAR_ALWAYS = 4;
	public static final int MORE_POPULAR = 5;
	public static final int LESS_POPULAR = 6;
	public static final int TOP_TEN_INCREASE = 7;
	public static final int QUIT = 8;
	
	// CS314 students, explain your menu option 7 here:
	/*this option returns top ten names which have increased most between two consecutive decades.
	 * The first column of result is name, second is the decade in which rank increases most from last decade,
	 * third is the detailed value the rank has increased.
	 */
	
	// CS314 students, Explain your interesting search / trend here:
	/* I searched the names of main roles in the novel <Gone With The Wind>. 
	 * As this novel and film were very famous and successful during 1940s, I try to find
	 * if this novel could affect the choices for baby names during that time.
	 * From the data below, we could find Ashley and Melanie really started rank out of 1000
	 * to in top 1000 during 1940s. I am not sure if it is a coincidence. However, Scarlett, 
	 * the heroine, has never ranked in top 1000 before 1990s. Rhett, the hero, 
	 * also has never ranked in top 1000 before 1960s. But I have to say that Melanie is really
	 * more thoughtful than Scarlett. Thus, maybe more people love Melanie than Scarlett. I tend
	 * to believe that the popular novels and movies could affect the choices for baby names.
	 * 
	 * Scarlett         Rhett               Ashley            Melanie
       1900: 0          1900: 0             1900: 903         1900: 0 
       1910: 0          1910: 0             1910: 0           1910: 0
       1920: 0          1920: 0             1920: 0           1920: 0
       1930: 0          1930: 0             1930: 0           1930: 0
       1940: 0          1940: 0             1940: 887         1940: 348
       1950: 0          1950: 0             1950: 810         1950: 172
       1960: 0          1960: 801           1960: 662         1960: 114
       1970: 0          1970: 807           1970: 142         1970: 56
       1980: 0          1980: 786           1980: 4           1980: 83
       1990: 889        1990: 708           1990: 1           1990: 109
       2000: 952        2000: 677           2000: 4           2000: 111

	 */
	
	// CS314 students, add test code for NameRecord class here:
	public static void nameRecordTester() {
		//test 1 - 2, getRank method
        int baseDecade = 1900;
        String name = "Jake";
        Integer[] ranks = new Integer[] {2, 312, 323, 479, 1001, 630, 751, 453, 225, 1001, 97};
        NameRecord jakeRecord =  new NameRecord(name, baseDecade, ranks);
        int expected1 = 312;
        int expected2 = 0;
        int actual1 = jakeRecord.getRank(1910);
        int actual2 = jakeRecord.getRank(1940);
        if(expected1 == actual1)
            System.out.println("passed test 1, getRank method.");
        else
            System.out.println("FAILED test 1, getRank method."); 
        if(expected2 == actual2)
            System.out.println("passed test 2, getRank method.");
        else
            System.out.println("FAILED test 2, getRank method."); 
        
        
        //test 3 - 4, bestDecade method
        expected1 = 1900;
        actual1 = jakeRecord.bestDecade();
        if(expected1 == actual1)
            System.out.println("passed test 3, bestDecade method.");
        else
            System.out.println("FAILED test 3, bestDecade method."); 
        
        ranks[8] = 2;
        jakeRecord = new NameRecord(name, baseDecade, ranks);
        expected2 = 1980;
        actual2 = jakeRecord.bestDecade();
        if(expected1 == actual1)
            System.out.println("passed test 4, bestDecade method.");
        else
            System.out.println("FAILED test 4, bestDecade method."); 

        
        //test 5, numDecadesTop method
        expected1 = 9;
        actual1 = jakeRecord.numDecadesTop();
        if(expected1 == actual1)
            System.out.println("passed test 5, numDecadesTop method.");
        else
            System.out.println("FAILED test 5, numDecadesTop method.");
        
        //test 6 - 7, topEveryDecade method
        boolean expected3 = false;
        boolean actual3 = jakeRecord.topEveryDecade();
        if(expected3 == actual3)
            System.out.println("passed test 6, topEveryDecade method.");
        else
            System.out.println("FAILED test 6, topEveryDecade method."); 
        
        ranks[4] = 389;
        ranks[9] = 678;
        jakeRecord = new NameRecord(name, baseDecade, ranks);
        expected3 = true;
        actual3 = jakeRecord.topEveryDecade();
        if(expected3 == actual3)
            System.out.println("passed test 7, topEveryDecade method.");
        else
            System.out.println("FAILED test 7, topEveryDecade method."); 
        
        
        //test 8 - 10, topOnlyDecade method
        expected3 = false;
        actual3 = jakeRecord.topOnlyDecade();
        if(expected3 == actual3)
            System.out.println("passed test 8, topOnlyDecade method.");
        else
            System.out.println("FAILED test 8, topOnlyDecade method."); 
        
        ranks = new Integer[] {1001, 1001, 1001, 479, 1001, 1001, 1001, 1001, 1001, 1001, 1001};
        jakeRecord = new NameRecord(name, baseDecade, ranks);
        expected3 = true;
        actual3 = jakeRecord.topOnlyDecade();
        if(expected3 == actual3)
            System.out.println("passed test 9, topOnlyDecade method.");
        else
            System.out.println("FAILED test 9, topOnlyDecade method."); 
        
        ranks = new Integer[] {1001, 1001, 1001, 1001, 1001, 1001, 1001, 1001, 1001, 1001, 1001};
        jakeRecord = new NameRecord(name, baseDecade, ranks);
        expected3 = false;
        actual3 = jakeRecord.topOnlyDecade();
        if(expected3 == actual3)
            System.out.println("passed test 10, topOnlyDecade method.");
        else
            System.out.println("FAILED test 10, topOnlyDecade method."); 
        
        //test 11 - 13, morePoplular method
        expected3 = false;
        actual3 = jakeRecord.morePopular();
        if(expected3 == actual3)
            System.out.println("passed test 11, morePopular method.");
        else
            System.out.println("FAILED test 11, morePopular method."); 
        
        ranks = new Integer[] {1001, 1000, 800, 400, 345, 344, 233, 100, 98, 76, 10};
        jakeRecord = new NameRecord(name, baseDecade, ranks);
        expected3= true;
        actual3 = jakeRecord.morePopular();
        if(expected3 == actual3)
            System.out.println("passed test 12, morePopular method.");
        else
            System.out.println("FAILED test 12, morePopular method."); 
        
        ranks = new Integer[] {1001, 1000, 800, 400, 345, 345, 233, 100, 98, 76, 10};
        jakeRecord = new NameRecord(name, baseDecade, ranks);
        expected3 = false;
        actual3 = jakeRecord.morePopular();
        if(expected3 == actual3)
            System.out.println("passed test 13, morePopular method.");
        else
            System.out.println("FAILED test 13, morePopular method."); 
        
        //test 14 - 16, lessPopular method
        expected3 = false;
        actual3= jakeRecord.lessPopular();
        if(expected3 == actual3)
            System.out.println("passed test 14, lessPopular method.");
        else
            System.out.println("FAILED test 14, lessPopular method."); 
        
        ranks = new Integer[] {10, 100, 200, 300, 345, 345, 400, 401, 498, 756, 810};
        jakeRecord = new NameRecord(name, baseDecade, ranks);
        expected3 = false;
        actual3 = jakeRecord.lessPopular();
        if(expected3 == actual3)
            System.out.println("passed test 15, lessPopular method.");
        else
            System.out.println("FAILED test 15, lessPopular method."); 
        
        ranks = new Integer[] {10, 100, 200, 300, 345, 346, 400, 401, 498, 756, 810};
        jakeRecord = new NameRecord(name, baseDecade, ranks);
        expected3 = true;
        actual3 = jakeRecord.lessPopular();
        if(expected3 == actual3)
            System.out.println("passed test 16, lessPopular method.");
        else
            System.out.println("FAILED test 16, lessPopular method."); 
        
        //test 17 - 18, increaseMostDecade method
        int[] expected4 = new int[] {0, 0};
        int[] actual4 = jakeRecord.increaseMostData();
        if(expected4[0] == actual4[0] && expected4[1] == actual4[1])
            System.out.println("passed test 17, increaseMostData method.");
        else
            System.out.println("FAILED test 17, increaseMostData method."); 		

        ranks = new Integer[] {1001, 1000, 800, 400, 345, 345, 233, 100, 98, 76, 10};
        jakeRecord = new NameRecord(name, baseDecade, ranks);
        expected4 = new int[] {1930, 400};
        actual4 = jakeRecord.increaseMostData();
        if(expected1 == actual1)
            System.out.println("passed test 18, increaseMostDecade method.");
        else
            System.out.println("FAILED test 18, increaseMostDecade method."); 
	}
	
    // simple test for toString
    public static void simpleToStringTest() {
        // raw data for Jake. Alter as necessary for your NameRecord
        //String jakeRawData = "Jake 262 312 323 479 484 630 751 453 225 117 97";
        int baseDecade = 1900;
        String name = "Jake";
        Integer[] ranks = new Integer[] {262, 312, 323, 479, 484, 630, 751, 453, 225, 117, 97};
        NameRecord jakeRecord =  new NameRecord(name, baseDecade, ranks);
        String expected = "Jake\n1900: 262\n1910: 312\n1920: 323\n1930: 479\n1940: 484\n1950: 630\n1960: 751\n1970: 453\n1980: 225\n1990: 117\n2000: 97\n";
        String actual = jakeRecord.toString();
        System.out.println("expected string:\n" + expected);
        System.out.println("actual string:\n" + actual);
        if(expected.equals(actual))
            System.out.println("passed Jake toString test1.");
        else
            System.out.println("FAILED Jake toString test1.");  
        
        //test2
        ranks[1] = 1001;
        ranks[8] = 1001;
        jakeRecord = new NameRecord(name, baseDecade, ranks);
        expected = "Jake\n1900: 262\n1910: 0\n1920: 323\n1930: 479\n1940: 484\n1950: 630\n1960: 751\n1970: 453\n1980: 0\n1990: 117\n2000: 97\n";
        actual = jakeRecord.toString();
        System.out.println("expected string:\n" + expected);
        System.out.println("actual string:\n" + actual);
        if(expected.equals(actual))
            System.out.println("passed Jake toString test2.");
        else
            System.out.println("FAILED Jake toString test2."); 
    }
    
	
	// main method. Driver for the whole program
	public static void main(String[] args) {
		//simpleToStringTest();
		//nameRecordTester();
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
		    System.out.println("Unable to set look at feel to local settings. " +
		    		"Continuing with default Java look and feel.");
		}
	    try {
		    
	        // uncomment the next two lines if you want to let user obtain file via GUI
	        //System.out.println("Opening GUI to choose file with names data...");
	        //Scanner fileScanner = new Scanner(getFile());
	        
		    
		    // uncomment next line to hard code name file
		    Scanner fileScanner = new Scanner(new File("names.txt"));
			Names n = new Names(fileScanner);
			fileScanner.close();
			int choice;
			Scanner keyboard = new Scanner(System.in);
			do {
				showMenu();
				choice = getChoice(keyboard);
				if( choice == SEARCH)
					search(n, keyboard);
				else if( choice == ONE_NAME )
					oneName(n, keyboard);
				else if( choice == APPEAR_ONCE )
					appearOnce(n);
				else if( choice == APPEAR_ALWAYS )
					appearAlways(n);
				// CS314 students, complete this section
				else if( choice == MORE_POPULAR )
					morePopular(n);
				else if( choice == LESS_POPULAR)
					lessPopular(n);
				else if( choice == TOP_TEN_INCREASE)
					topTenIncrease(n);
				else
					System.out.println("\n\nGoodbye.");

			} while( choice != QUIT);
		}
		catch(FileNotFoundException e) {
			System.out.println("Problem reading the data file. Exiting the program." + e);
		}
	}
	
	// method that shows top ten names that the rank increases most between two consecutive decades
    // pre: n != null
	// post: print out top ten names that the rank increases most between two consecutive decades
	private static void topTenIncrease(Names n) {
		ArrayList<NameRecord> topTenRecord = n.topTenIncrease();
		for (NameRecord record : topTenRecord) {
			int[] data = record.increaseMostData();
			System.out.println(record.getName() + " " + data[0] + " " + data[1]);
		}
	}
    
	
	// method that shows names that becomes less and less popular during these decades
    // pre: n != null
	// post: print out names that becomes less and less popular during these decades
	private static void lessPopular(Names n) {
		ArrayList<String> result = n.alwaysLessPopular();
		StringBuilder sb = new StringBuilder("");
		sb.append(result.size() + " names are less popular in every decade.");
		for (String name : result) {
			sb.append("\n" + name);
		}
		System.out.println(sb);
	}
	
	
	// method that shows names that becomes more and more popular during these decades
    // pre: n != null
	// post: print out names that becomes more and more popular during these decades
	private static void morePopular(Names n) {
		ArrayList<String> result = n.alwaysMorePopular();
		StringBuilder sb = new StringBuilder("");
		sb.append(result.size() + " names are more popular in every decade.");
		for (String name : result) {
			sb.append("\n" + name);
		}
		System.out.println(sb);
	}
	// method that shows names that have appeared in ever decade
	// pre: n != null
	// post: print out names that have appeared in ever decade
	private static void appearAlways(Names n) {	
		ArrayList<String> result = n.rankedEveryDecade();
		StringBuilder sb = new StringBuilder("");
		sb.append(result.size() + " names appear in every decade. The names are:");
		for (String name : result) {
			sb.append("\n" + name);
		}
		System.out.println(sb);

	}

	// method that shows names that have appeared in only one decade
	// pre: n != null
	// post: print out names that have appeared in only one decade
	private static void appearOnce(Names n) {			
		ArrayList<String> result = n.rankedOnlyOneDecade();
		StringBuilder sb = new StringBuilder("");
	    sb.append(result.size() + " names appear in exactly one decade. The names are:");
		for (String name : result) {
			sb.append("\n" + name);
		}
		System.out.println(sb);
	}

	// method that shows data for one name, or states that name has never been ranked
	// pre: n != null, keyboard != null and is connected to System.in
	// post: print out the data for n or a message that n has never been in the top 1000 for any decade
	private static void oneName(Names n, Scanner keyboard) {
		System.out.print("Enter a name: ");
		while (!keyboard.hasNext()) {
			System.out.println("\nThis is not a valid input");
			System.out.print("Enter a name: ");
		}
		String name = keyboard.next();
		keyboard.nextLine();
	    NameRecord result = n.getEquals(name);
	    if (result == null) {
	    	System.out.println("\n" + name + " does not appear in any decade.");
	    }
	    else {
	    	System.out.println(result.toString());
	    }
	}

	// method that shows all names that contain a substring from the user
	// and the decade they were most popular in
	// pre: n != null, keyboard != null and is connected to System.in
	// post: show the correct data		
	private static void search(Names n, Scanner keyboard) {
		System.out.print("Enter a partial name: ");
		while (!keyboard.hasNext()) {
			System.out.println("\nThis is not a valid input");
			System.out.print("Enter a partial name: ");
		}
		String partialName = keyboard.next();
		keyboard.nextLine();
		ArrayList<NameRecord> matchNames = n.getMatches(partialName);
		int num = matchNames.size();
		System.out.println("\nThere are " + num + " matches for " + partialName + ".");
		if (num != 0) {
		
		    System.out.println("\nThe matches with their highest ranking decade are:");
		
			for (NameRecord record : matchNames) {
				System.out.println(record.getName() + " " + record.bestDecade());
			}
		}
		
		

	}

	// get choice from the user
	// keyboard != null and is connected to System.in
	// return an int that is >= SEARCH and <= QUIT
	private static int getChoice(Scanner keyboard) {
		int choice = getInt(keyboard, "Enter choice: ");
		keyboard.nextLine();
		while( choice < SEARCH || choice > QUIT){
			System.out.println("\n" + choice + " is not a valid choice");
			choice = getInt(keyboard, "Enter choice: ");
			keyboard.nextLine();
		}
		return choice;
	}
	
	// ensure an int is entered from the keyboard
	// pre: s != null and is connected to System.in
    private static int getInt(Scanner s, String prompt) {
        System.out.print(prompt);
        while( !s.hasNextInt() ){
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }

    // show the user the menu
	private static void showMenu() {
		System.out.println("\nOptions:");
		System.out.println("Enter " + SEARCH + " to search for names.");
		System.out.println("Enter " + ONE_NAME + " to display data for one name.");
		System.out.println("Enter " + APPEAR_ONCE+ " to display all names that appear in only one decade.");
		System.out.println("Enter " + APPEAR_ALWAYS + " to display all names that appear in all decades.");
		// CS314 students fill in other options
		System.out.println("Enter " + MORE_POPULAR + " to display all names that are more popular in every decade.");
		System.out.println("Enter " + LESS_POPULAR + " to display all names that are less popular in every decade.");
		System.out.println("Enter " + TOP_TEN_INCREASE + " to display top 10 names that have increased most between two decades.");
		System.out.println("Enter " + QUIT + " to quit.\n");
	}

	/** Method to choose a file using a traditional window.
     * @return the file chosen by the user. Returns null if no file picked.
     */ 
    public static File getFile() {
        // create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Select File With Baby Names Data.");
        int retval = chooser.showOpenDialog(null);
        File f =null;
        chooser.grabFocus();
        if (retval == JFileChooser.APPROVE_OPTION)
           f = chooser.getSelectedFile();
        return f;
    }

}
