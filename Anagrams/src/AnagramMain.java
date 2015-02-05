// Provided by Stuart Reges
// Minor changes by Mike Sccott
// 5/9/05
//
// AnagramMain contains a main program that prompts a user for the name of a
// dictionary file and then gives the user the opportunity to find anagrams of
// various phrases.  It constructs an AnagramSolver object to do the actual
// search for anagrams that match the user's phrases.

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AnagramMain {
    
    public static void main(String[] args){
        System.out.println("Welcome to the anagram solver.");
        System.out.println();

        Scanner console = new Scanner(System.in);
        System.out.print("What is the name of the dictionary file? ");
        List<String> words = readWords(console.nextLine());

        // if successfully read in words from file, solve anagrams
        if(words != null) {
            solveAnagrams(words, console);
        }
        else
            System.out.println("Did not find dictionary file. Exiting.");
    }

    /*
     * main loop of program. Called after words are loaded from file.
     * Asks user for phrase and max number of words until phrase
     * with 0 characters entered.
     */
    private static void solveAnagrams(List<String> words, Scanner console) {
        List<String> dictionary2 = Collections.unmodifiableList(words);
        AnagramSolver solver = new AnagramSolver(dictionary2);
        Stopwatch timer = new Stopwatch();
        boolean go = true;
        do{
            System.out.println();
            System.out.print("phrase to scramble (return to quit)? ");
            String phrase = console.nextLine();
            go = phrase.length() != 0;
            if(go) {
                System.out.print("Max words to include (0 for no max)? ");
                int max = console.nextInt();
                console.nextLine();  // to skip newline after int
                timer.start();
                List<List<String>> anagrams = solver.getAnagrams(phrase, max);
                timer.stop();
                System.out.println("Time to find and print anagrams: " + timer);
                showAnagrams(anagrams, max, phrase);
            }
        } while(go); 
    }

    /*
     * Display the resulting anagrams from a given phrase.
     * pre: anagrams != null
     */
    private static void showAnagrams(List<List<String>> anagrams, int max,
            String phrase) {
        assert anagrams != null : "violation of precondition";
        System.out.print("Found " + anagrams.size() + " anagram(s) " +
        		"for " + phrase);
        if( max != 0 )
            System.out.println(" with a " + "limit of no more than " + max + " words.");
        else
            System.out.println(" with no limit on the number of words.");
        for(List<String> anagram : anagrams)
            System.out.println(anagram);
    }

    /*
     * Ask for a file name and read words from that file.
     */
    public static List<String> readWords(String dictionaryFileName) {
        List<String> result = null;
        try{
            Scanner input = new Scanner(new File(dictionaryFileName));
            
            // read dictionary into an ArrayList
            result = new ArrayList<String>();
            while (input.hasNextLine()) {
                String st = input.nextLine().trim();
                if(st.length() > 0)
                    result.add(st);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problems reading from file: " + e);
            System.out.println("Returing null;");
            result = null;
        }
        return result;
    }
}
