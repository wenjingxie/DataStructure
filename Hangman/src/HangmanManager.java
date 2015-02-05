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

// add imports as necessary

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class HangmanManager {
    // instance variables
	private int maxGuesses;
	private ArrayList<String> dictionary = new ArrayList<String> ();
	private int difficulty;
	private boolean debug;
	private int numWrongGuesses;
	private int numGuessed;
	private ArrayList<String> activeList;
	private StringBuilder getPattern;
	private ArrayList<Character> charGuessed;
	   
    // pre: words != null, words.size() > 0
    // if debugOn = true, debuggin output is added
    public HangmanManager(List<String> words, boolean debugOn) {
     	this(words);
    	debug = debugOn;
    }
    
    // pre: words != null, words.size() > 0
    // debuggin output is not added
    public HangmanManager(List<String> words) {
    	//check precondition
    	if(words == null || words.size() == 0)
            throw new IllegalArgumentException("List of words may not be null or empty.");
    	dictionary.addAll(words);
    	debug = false;
    }
    
    
    // pre: none
    // post: return the number of words in the original Dictionary with the given length
    public int numWords(int length) {
    	int num = 0;
    	for (String word : dictionary) {
    		if (word.length() == length) {
    			num++;
    		}
    	}
        return num;
    }


    // pre: numWords(wordLen) > 0, numGuesses >= 1, diff = HangmanMain.EASY, HangmanMain.MEDIUM, or HangmanMain.HARD
    public void prepForRound(int wordLen, int numGuesses, int diff) {
    	//check precondition
    	if(wordLen <= 0 || numGuesses < 1 ||
    			(diff != HangmanMain.EASY && diff != HangmanMain.MEDIUM && diff != HangmanMain.HARD))
            throw new IllegalArgumentException("Illegal of precondition: numWords(wordLen) > 0, "
            		+ "numGuesses >= 1, diff = HangmanMain.EASY, HangmanMain.MEDIUM, or HangmanMain.HARD");
    	maxGuesses = numGuesses;
    	difficulty = diff;
    	charGuessed = new ArrayList<Character> ();
    	activeList = new ArrayList<String> ();
    	for (String word : dictionary) {
    		if (word.length() == wordLen) {
    			activeList.add(word);
    		}
    	}
    	numWrongGuesses = 0;
    	numGuessed = 0;
    	getPattern = new StringBuilder();
    	for (int i = 0; i < wordLen; i++) {
    		getPattern.append('-');
    	}
    }
    
    
    // pre: none
    // return the number of words that are still possibilities
    public int numWordsCurrent() {	
        return activeList.size();
    }
    
    
    // pre: none
    // return number of wrong guesses left in this game
    public int getGuessesLeft() {
        return maxGuesses - numWrongGuesses;
    }
    
    
    // pre: none
    // post: return a String version of the guesses made so far
    public String getGuessesMade() {
        return charGuessed.toString();
    }
    
    
    // pre: none
    // post: return true if guess has already been used, false otherwise
    public boolean alreadyGuessed(char guess) {
    	if (charGuessed.contains(guess)){
    		return true;
    	}
        return false;
    }
       
    // get the current pattern. (In other words the revealed characters and '-'s
    // for characters not yet revealed.
    public String getPattern() {
        return getPattern.toString();
    }
      
    // pre: !alreadyGuessed(ch)
    // post: return a tree map with the resulting patterns and the number of
    // words in each of the new patterns.
    // the return value is for testing and debugging purposes
    public TreeMap<String, Integer> makeGuess(char guess) {
    	//check precondition
    	if(alreadyGuessed(guess))
            throw new IllegalArgumentException("This letter has already been guessed, pick a new letter please.");
    	   	
    	TreeMap<String, ArrayList<String>> patterns = newPatterns(guess);//generate new patterns with their word lists
    	//generate map for debug
    	TreeMap<String, Integer> debugPatterns = new TreeMap<String, Integer> ();
    	for (String key : patterns.keySet()) {
    		int count = patterns.get(key).size();
    		debugPatterns.put(key, count);
    	}
    	
    	//according to difficulty to return pattern
    	numGuessed++;
    	boolean isHardest = true;
    	StringBuilder newPattern = new StringBuilder(hardestGuess(debugPatterns));
    	if (difficulty == HangmanMain.EASY) {
    		if ((numGuessed) % 2 == 0) {
    			newPattern = new StringBuilder(secondHardestGuess(debugPatterns));
    			isHardest = false;
    		}		
    	}
    	else if (difficulty == HangmanMain.MEDIUM) {
    		if ((numGuessed) % 4 == 0) {
    			newPattern = new StringBuilder(secondHardestGuess(debugPatterns));
    			isHardest = false;
    		}
    	}

    	//according to pattern to set other parameters
    	//PATTERN does not change, this guess is wrong， numWrongGuesses++
    	if ((newPattern.toString()).equals(getPattern.toString())) {
    		numWrongGuesses++;
    	}
    	//else, this guess is right
    	else {
    		getPattern = newPattern;
    	}
		activeList = patterns.get(getPattern.toString());
    	charGuessed.add(guess);
    	Collections.sort(charGuessed);
    	
    	//If debugging, give some output
    	if (debug) {
    		if(isHardest) {
    			System.out.println();
    			System.out.println("DEBUGGING: Picking hardest list.");
    		}
    			System.out.println("DEBUGGING: New pattern is: " + getPattern.toString() +". New family has " +  numWordsCurrent() + " words.");
    			System.out.println();
    	}
    	//return the map for debug using
        return debugPatterns;
    }
  
        
    //pre: !alreadyGuessed(char)
    //post: return the map, key: new patterns, value: the word list match the pattern 
    private TreeMap<String, ArrayList<String>> newPatterns (char guess) { 
    	//check precondition
    	if(alreadyGuessed(guess))
            throw new IllegalArgumentException("This letter has already been guessed, pick a new letter please.");
    	
    	TreeMap<String, ArrayList<String>> patterns = new TreeMap<String, ArrayList<String>> ();  
    	//go through all the current words to find if the word contains the new "guess"
    	//and change the "-" to be the new "guess" to create the new pattern
    	//put the <new pattern, arrayList of words> into map
        for(String activeWord : activeList) {
        	StringBuilder pattern = new StringBuilder(getPattern);
        	int index = activeWord.indexOf(guess);
        	while (index != -1) {
        		pattern.setCharAt(index, guess);
        		index = activeWord.indexOf(guess, index + 1);	
        	}
        	if (patterns.containsKey(pattern.toString())) {
				patterns.get(pattern.toString()).add(activeWord);//ArrayList is mutable
			}
			else {
				ArrayList<String> words = new ArrayList<String> ();
				words.add(activeWord);
				patterns.put(pattern.toString(), words);
			}       	        	
        }	
        return patterns;    	
    }
    
    //pre: the map returned for debug could not be empty
    //post: return the hardest pattern
    private String hardestGuess (TreeMap<String, Integer> debugPatterns) {
	 //check precondition
   	    if(debugPatterns.isEmpty())
            throw new IllegalArgumentException("Illegal of precondition: Map debugPatterns could not be empty.");
	   
   	    //get the patterns which have most words 
   	    int maxValue = Collections.max(debugPatterns.values());
	    ArrayList<String> keys = new ArrayList<String> ();
	    for (String key : debugPatterns.keySet()) {
		    if (debugPatterns.get(key) == maxValue) {
			   keys.add(key);
		    }
	    }
	    
	    String hardestPattern = keys.get(0);
	    //check if there are more than one pattern have the same most words
	    //if yes, compare the number of "-"
	    //as the keys of map are stored in ASCIIbetical order, just find the one close to index(0) 
	    if (keys.size() > 1) {
	    	int maxWildcardCount = 0;
			for (String key : keys) {
				//find the number of '-' for every key
				int wildcardCount = 0;
				for (int i = 0; i < key.length(); i++) {
					if (key.charAt(i) == '-') {
						wildcardCount ++;   
				    } 
				}
				//compare the number of '-' to maxCount
				if (wildcardCount > maxWildcardCount) {
					maxWildcardCount = wildcardCount;
					hardestPattern = key;
			    }			
	        }
	    }	
	    return hardestPattern;  
    }
    
    
    //pre: the map returned for debug could not be empty
    //post: return the hardest pattern
    private String secondHardestGuess (TreeMap<String, Integer> debugPatterns) {
    	//check precondition
   	    if(debugPatterns.isEmpty())
            throw new IllegalArgumentException("Illegal of precondition: Map debugPatterns could not be empty.");
   	   	    
   	    String hardestPattern = hardestGuess(debugPatterns);
 	    String secondHardestPattern;
 	    //special case, if there is only one pattern, the hardest one should be same as second hardest one.
 	    if (debugPatterns.size() == 1) {
 		    secondHardestPattern = hardestPattern;
 		    if (debug) {
 		    	System.out.println();
 		    	System.out.println("DEBUGGING: Should pick second hardest pattern this turn, but only one pattern available.");
 		    	System.out.println();
 		    	System.out.println("DEBUGGING: Picking hardest list.");
 		    }		    
 	    }
 	    else {
 	    	//general case, create a new map which contains the same entries as debugPatterns,
 	    	//but delete the hardest one, and then find the hardest one in the left list,
 	    	//namely the second hardest one.
 		    TreeMap<String, Integer> secondHardest = new TreeMap<String, Integer> ();
         	secondHardest.putAll(debugPatterns);
        	secondHardest.remove(hardestPattern);
     	    secondHardestPattern = hardestGuess(secondHardest);
     	    if (debug) {
     	    	System.out.println();
     	    	System.out.println("DEBUGGING: Difficulty second hardest pattern and list.");
     	    	System.out.println();
     	    }
 	    }  
   	    return secondHardestPattern;
    }
    
    // pre: numWordsCurrent() > 0
    // return the secret word the manager picked 
    // if there is more than one word left, pick one at random
    public String getSecretWord() {
    	//check precondition
    	if(numWordsCurrent() == 0)
            throw new IllegalArgumentException("Illegal of precondition: the numWordsCurrent could not be 0.");
    	
    	if (activeList.size() == 1) {
    		return activeList.get(0);
    	}
    	else {
    		Random randomGen = new Random ();
    		int index = randomGen.nextInt(activeList.size());
    		return activeList.get(index);
    	}
    }
}

