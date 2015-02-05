

/* Student information for assignment:
 *
 *  On my honor, Wenjing Xie, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Wenjing Xie
 *  UTEID: wx674
 *  email address: wenjing.xie@utexas.edu
 *  Section 5 digit ID: 90130
 *  Grader name: Eric
 *  Number of slip days I am using: 0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class AnagramSolver {
	//instance variables
	private HashMap<String, LetterInventory> dictionary;

	
	//constructor
	public AnagramSolver(List<String> words) {
		dictionary = new HashMap<String, LetterInventory>();
		int size = words.size();
		for (int i = 0; i < size; i++) {
			String word = words.get(i);
			LetterInventory li = new LetterInventory(word); 
			dictionary.put(word, li);
		}
	}
	
	
	//getAnagrams
	//pre: phrase has at least one English letter, and could not be null
	//maxNumWords >= 0
	public List<List<String>> getAnagrams(String phrase, int maxNumWords) {
		//check precondition
		if (phrase == null || maxNumWords < 0) {
			throw new IllegalArgumentException("The input phrase could not be null or the maxNumWords could not be less than 0!");
		}
		LetterInventory li = new LetterInventory(phrase);
		if (li.isEmpty()) {
			throw new IllegalArgumentException("The input phrase must has at least one English Letter!");
		}
		
		ArrayList<String> choices = possibleWords(li);
		ArrayList<List<String>> result = new ArrayList<List<String>>();
		ArrayList<String> anagramList = new ArrayList<String>();
		recursiveGetAnagram(result, choices, anagramList, li, maxNumWords, 0);
	    Comparator<List<String>> com = new AnagramComparator();
		Collections.sort(result, com);
		return result;
		
	}
	
	

	
	//recursiveGetAnagram
	private void recursiveGetAnagram(ArrayList<List<String>> result, ArrayList<String> choices, 
		ArrayList<String> anagramList, LetterInventory li, int maxNumWords, int index) {
         	
		//base case
		if (li.isEmpty()) {
				ArrayList<String> newAnagram = new ArrayList<String> (anagramList);
				Collections.sort(newAnagram);		
				result.add(newAnagram);
			}

		
		
		//general steps
		else if (maxNumWords == 0 || maxNumWords - anagramList.size() > 0 ) {
			
			for (int i = index; i < choices.size(); i++) {
				String word = choices.get(i);
				LetterInventory newLi = li.subtract(dictionary.get(word));
				
				if (newLi != null) {
					anagramList.add(word);	
					recursiveGetAnagram(result, choices, anagramList, newLi, maxNumWords, i);
					anagramList.remove(word);
				}
				
			}
		}
		
	}
	
	
	
	//possibleWords
	private ArrayList<String> possibleWords(LetterInventory li) {
		ArrayList<String> result = new ArrayList<String>();
		for (String word : dictionary.keySet()) {
			LetterInventory liOther = dictionary.get(word);
			if (li.subtract(liOther) != null) {
				result.add(word);
			}
		}
		StringLenComparator com = new StringLenComparator();
		Collections.sort(result, com);
		return result;
	}
	

	//AnagramComparator
	private static class AnagramComparator implements Comparator<List<String>> {

		@Override
		public int compare(List<String> o1, List<String> o2) {
			if (o1.size() != o2.size()) {
				return o1.size() - o2.size();
			}

			else {
				for (int i = 0; i < o1.size(); i++) {
					int compare = o1.get(i).compareTo(o2.get(i));
					if (compare != 0) {
						return compare;
					}
				}
				return 0;	
			}
		}
		
	}
	
	//String length Comparator
	private static class StringLenComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o2.length() - o1.length();
		}
		
	}

}

