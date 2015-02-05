

/*  Student information for assignment:
*
*  On MY honor, Wenjing Xie, this programming assignment is MY own work
*  and I have not provided this code to any other student.
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

/**
 * Main/launch program for Huff assignment. A better
 * comment than this is warranted.
 *
 */
public class Huff {

    public static void main(String[] args){
        HuffViewer sv = new HuffViewer("Huffman Compression");
        IHuffProcessor proc = new SimpleHuffProcessor();
        sv.setModel(proc);    
    }
}
