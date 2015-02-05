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




import java.util.Arrays;


public class LetterInventory {
	//instance variables
	private static final char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private static final int lenAlphabet = 26;
	private int[] numEveryLetter = new int[lenAlphabet];
	private int countLetters;
	
	//constructor no more than O(N + M)
	//pre: phrase could not be null
	public LetterInventory(String phrase) {
        //check precondition
		if (phrase == null) {
			throw new IllegalArgumentException("The input phrase could not be null!");
		}
		
		countLetters = 0;
		int size = phrase.length();
		for (int i = 0; i < size; i++) {
			Character ch = Character.toLowerCase(phrase.charAt(i));
			int compare = ch.compareTo('a');
			if (compare >= 0 && compare <= 25) {
				numEveryLetter[compare] += 1;
				countLetters += 1;
			}
		}
	}
	
	//get  O(1)
	//pre: letter to be an English Letter
	public int get(char letter) {
		//check precondition		
		Character ch = Character.toLowerCase(letter);
		int index = ch.compareTo('a');
		if (index < 0 || index > 25) {
			throw new IllegalArgumentException("The input letter must be an English Letter!");
		}
		
		return numEveryLetter[index];
	}
	
	
	//size O(1)
	public int size() {
		
		return countLetters;
	}
	
	//isEmpty O(1)
	public boolean isEmpty() {
		if (countLetters == 0) {
			return true;
		}
		return false;
	}
	
	//toString 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lenAlphabet; i++) {
			for (int j = 0; j < numEveryLetter[i]; j++) {
				sb.append(alphabet[i]);
			}
		}
		return sb.toString();
	}
	
	//add O(M)
	//pre: other could not be null
	//post: calling object and other could not be altered
	public LetterInventory add(LetterInventory other) {
		//check precondition
		if (other == null) {
			throw new IllegalArgumentException("The input LetterInventory could not be null!");
		}
		
		LetterInventory result = new LetterInventory("");
		for (int i = 0; i < lenAlphabet; i++) {
			result.numEveryLetter[i] = this.numEveryLetter[i] + other.numEveryLetter[i];
		}
		result.countLetters = this.countLetters + other.countLetters;
	    return result;
	}

	
	//subtract O(M)
	//pre: other could not be null
	//post: calling object and other could not be altered
	public LetterInventory subtract(LetterInventory other) {
		//check precondition
		if (other == null) {
			throw new IllegalArgumentException("The input LetterInventory could not be null!");
		}
		
		if (this.size() < other.size()) {
			return null;
			
		}
		else {
			LetterInventory result = new LetterInventory("");
			for (int i = 0; i < lenAlphabet; i++) {
				result.numEveryLetter[i] = this.numEveryLetter[i] - other.numEveryLetter[i];
				if (result.numEveryLetter[i] < 0) {
					return null;
				}
			}
			result.countLetters = this.countLetters - other.countLetters;
		    return result;
		}
		
	}
	
	//equals
	public boolean equals(Object other) {
		if (other == null || this.getClass() != other.getClass()) {
			return false;
			
		}
		LetterInventory otherInventory = (LetterInventory) other;
		if (this.countLetters == otherInventory.countLetters && Arrays.equals(this.numEveryLetter, otherInventory.numEveryLetter)) {
			return true;
			
		}
		return false;
	}
}
