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


/**
 * Each NameRecord object stores the data for an individual name,
 * including the name itself (a String), the base decade (decade of the first rank),
 * and the rank of the name for each decade.
 */

public class NameRecord implements Comparable<NameRecord>{
	
	/*
	 * instance variable
	 * the value of every element <= 1000 in ranks mean the rank for this decade is in top 1000;
	 * while value 1001 mean the rank for this decade is not in top 1000.
	 */
	private String name;
	private int baseDecade;
	private ArrayList<Integer> ranks = new ArrayList<Integer> ();
	
	/**
	 * constructor
	 * @param babyName, the name of this NameRecord.
	 * @param baseDecade, the first decade of this NameRecord.
	 * @param ranks, the array of the rank for each decade.
	 */
	public NameRecord(String babyName, int baseDecade, Integer[] ranks) {
		this.name = babyName;
		this.baseDecade = baseDecade;
		Collections.addAll(this.ranks, ranks);
		
	}
    
	
	//implements method compareTo from comparable interface
	public int compareTo(NameRecord other) {
		return (this.getName()).compareTo(other.getName());
	}
	
	/**
	 * get the name for this NameRecord.
	 * @return a String, the name of this NameRecord.
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * get the base decade for this NameRecord.
	 * @return the base decade.
	 */
	public int getBaseDecade() {
		return baseDecade;
	}

	
	/**
	 * returns this NameRecords rank for a given decade.
	 * @param decade, given decade to find the rank.
	 * @return the rank according to the given decade.
	 */
	public int getRank(int decade) {
		int index = (decade - baseDecade)/10;
		if (ranks.get(index) == 1001) {
			return 0;
		}
		return ranks.get(index);
	}

	
	/**
	 * returns the best decade for this NameRecord.
	 * @return the most recent decade for the highest rank for this name;
	 * the smallest value of rank means the highest rank.
	 */
	public int bestDecade() {
		int highRank = Collections.min(ranks);
		int index = ranks.lastIndexOf(highRank);
		int bestDecade = baseDecade + index * 10;
		return bestDecade;
	}

	
	/**
	 * returns the number of decades this name has been ranked in the top 1000.
	 * @return the number of ranks != 1001, meaning rank is in top 1000.
	 */
	public int numDecadesTop() {
		int num = 0;
		for (Integer rank : ranks) {
			if (rank != 1001)
				num ++;
		}
		return num;
	}
	
	
	/**
	 * Decide if this name has been ranked in the top 1000 in every decade.
	 * @return true if every decade has the rank in the top 1000.
	 */
	public boolean topEveryDecade() {
		boolean isTopEveryDecade = true;
		if (ranks.indexOf(1001) != -1)
			isTopEveryDecade = false;
		return isTopEveryDecade;
	}
	
	
	/**
	 * 
	 * Decide if this name has been ranked in the top 1000 in only one decade.
	 * @return true if the numDecadesTop equals 1.
	 */
	public boolean topOnlyDecade() {
		boolean isTopOnlyDecade = false;
		if (numDecadesTop() == 1)
			isTopOnlyDecade = true;
		return isTopOnlyDecade;
	}
	
	
	/**
	 * Decide if the rank of this name is becoming more popular
	 * @return true if this name has been getting more popular every decade in the time period covered.
	 * This will be true if every decades rank is better (closer to 1) than the previous decade.
	 * The rank must improve every decade, it cannot be equal to the previous decade.
	 */
	public boolean morePopular() {
		boolean isMorePopular = true;		
		for (int i = 0; (i < ranks.size() - 1) && isMorePopular; i++) {
			if (ranks.get(i + 1) >= ranks.get(i))
				isMorePopular = false;
		}
		return isMorePopular;
	}
	
	
	/**
	 * Decide if the rank of this name is becoming less popular 
	 * @return true if this name has been getting less popular every decade in the time period covered.
	 * This will be true if every decades rank is worse than the previous decade. 
	 * The rank must get worse, it cannot be equal to the previous decade. 
	 */
	public boolean lessPopular() {
		boolean isLessPopular = true;
		for (int i = 0; (i < ranks.size() - 1) && isLessPopular; i++) {
			if (ranks.get(i + 1) <= ranks.get(i))
				isLessPopular = false;
		}
		return isLessPopular;
	}
	
	/**
	 * override toString method from Object
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(name + "\n");
		int decade = baseDecade;
		for (int i = 0; i < ranks.size(); i++) {
			decade = baseDecade + i * 10;
			if ( (ranks.get(i)).equals(1001) ) {
				sb.append("" + decade + ": 0\n");
			}
			else {
				sb.append("" + decade + ": " + ranks.get(i) + "\n");
			}
		}
		return sb.toString();		
	}
	
	/**
	 * find the decade in which the increase of rank from last decade is largest.
	 * @return an int[]. 
	 * the first element returns the decade in which the rank increases most from last decade;
	 * the second element returns the value for the increase of rank.
	 * If the rank of this name is always decreasing, then return [0, 0].
	 */
	public int[] increaseMostData() {
		int max = 0;
		int index = 0;
		int[] result = new int[2];
		for(int i = 0; i < ranks.size() - 1; i++) {
			if ( (ranks.get(i) - ranks.get(i + 1)) >= max ) {
				max = (ranks.get(i) - ranks.get(i + 1));
				index = i + 1;
			}
		}
		if (max != 0) {
			result[0] = getBaseDecade() + index * 10;
			result[1] = max;	
		}
		return result;

	}
	
}
