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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A collection of NameRecords. 
 * Stores NameRecord objects and provides methods to select
 * NameRecords based on various criteria.
 */
public class Names {
	//instance variables
	private ArrayList<NameRecord> names = new ArrayList<NameRecord>();
	
	
	//constructor
	public Names(Scanner fileScanner) {
		//read the first two lines of the name.txt
		int baseDecade = Integer.parseInt(fileScanner.nextLine());
		int numRanks = Integer.parseInt(fileScanner.nextLine());
		
		String name;
		Integer[] ranks = new Integer[numRanks];
		String line;
		String[] parseLine;
		Integer element;
		//scan every line to generate the NameRecord
		while (fileScanner.hasNextLine()) {
			line = fileScanner.nextLine();
			//System.out.println(line);
			parseLine = line.split("\\s+");
			if (parseLine.length == numRanks + 1) {
				name = parseLine[0];
				//convert the String[] to Integer[]
				for (int i = 1; i < parseLine.length; i++) {
					element = Integer.parseInt(parseLine[i]);
					if (element == 0) {
						ranks[i - 1] = 1001;
					}
					else {
						ranks[i - 1] = element;
					}
				}
				NameRecord record = new NameRecord(name, baseDecade, ranks);
				//System.out.println(record.toString());
				names.add(record);
			}
		}
		//sort all the nameRecords to ascending
		Collections.sort(names);
	}
	
	public ArrayList<NameRecord> getNames() {
		return names;
	}
	
	
	/**
	 * Display the data for a given name.
	 * @param name， String type.
	 * @return the NameRecord for the given name.
	 */
	public NameRecord getEquals(String name) {
		for (NameRecord record : getNames()) {
			if ((record.getName()).equalsIgnoreCase(name)) {
				return record;
			}
		}
		return null;
	}

    /**
     * Returns an ArrayList of NameRecord objects that contain a 
     * given substring, ignoring case.  The names must be in sorted order based 
     * on name.
     * @param partialName != null, partialName.length() > 0
     * @return an ArrayList of NameRecords whose names contains
     * partialName. If there are no NameRecords that meet this
     * criteria returns an empty list. 
     */
    
    public ArrayList<NameRecord> getMatches(String partialName) {
    	//check precondition
    	if ( (partialName == null) || (partialName.length() == 0) )
    		throw new IllegalArgumentException("Violation of precondition: " + 
    	           "partialName != null, partialName.length() > 0");
    	
    	ArrayList<NameRecord> match = new ArrayList<NameRecord> ();
    	for (NameRecord record : getNames()) {
    		if ( ((record.getName()).toLowerCase()).contains(partialName.toLowerCase())) {
    			match.add(record);
    		}
    	}
    	return match;
        
    }

    /**
     * Returns an ArrayList of Strings of names that have been ranked in the
     * top 1000 or better for every decade. The Strings  must be in sorted 
     * order based on name. 
     * @return A list of the names that have been ranked in the top
     * 1000 or better in every decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list.
     */
    
    public ArrayList<String> rankedEveryDecade() {
    	ArrayList<String> topNames = new ArrayList<String> ();
    	for (NameRecord record : getNames()) {
    		if (record.topEveryDecade()) {
    			topNames.add(record.getName());
    		}
    	}
        return topNames;
    }

    /**
     * Returns an ArrayList of Strings of names that have been ranked in the 
     * top 1000 or better in exactly one decade. The Strings must be in sorted 
     * order based on name. 
     * @return A list of the names that have been ranked in the top
     * 1000 or better in exactly one decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list.
     */
    public ArrayList<String> rankedOnlyOneDecade() {
    	ArrayList<String> topOnlyOneNames = new ArrayList<String> ();
    	for (NameRecord record : getNames()) {
    		if (record.topOnlyDecade()) {
    			topOnlyOneNames.add(record.getName());
    		}
    	}
        return topOnlyOneNames;
    }

    /**
     * Returns an ArrayList of Strings of names that have been getting more
     * popular every decade. The Strings  must be in sorted order based on name.
     * @return A list of the names that have been getting more popular in
     * every decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list. 
     */
    public ArrayList<String> alwaysMorePopular() {
    	ArrayList<String> morePopularNames = new ArrayList<String> ();
    	for (NameRecord record : getNames()) {
    		if (record.morePopular()) {
    			morePopularNames.add(record.getName());
    		}
    	}
        return morePopularNames;
    }

    /**
     * Returns an ArrayList of Strings of names that have been getting less
     * popular every decade. The Strings  must be in sorted order based on name.
     * @return A list of the names that have been getting less popular in
     * every decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list. 
     */
    public ArrayList<String> alwaysLessPopular() {
    	ArrayList<String> lessPopularNames = new ArrayList<String> ();
    	for (NameRecord record : getNames()) {
    		if (record.lessPopular()) {
    			lessPopularNames.add(record.getName());
    		}
    	}
        return lessPopularNames; 
    }
    
    
    public ArrayList<NameRecord> topTenIncrease() {
    	ArrayList<NameRecord> topTenRecord = new ArrayList<NameRecord> ();
    	ArrayList<Integer> increaseData = new ArrayList<Integer> ();
        for (NameRecord record : getNames()) {
        	increaseData.add(record.increaseMostData()[1]);
        }
        while (topTenRecord.size() < 10) {
        	int max = Collections.max(increaseData);
        	int index = increaseData.indexOf(max);
        	topTenRecord.add(getNames().get(index));
        	increaseData.set(index, 0);
        }
        return topTenRecord;
    }

}
