
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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SimpleHuffProcessor implements IHuffProcessor {
    
    private HuffViewer myViewer;
    private Compressor myCompressor;
    private int originalBits;
    private int writeBits;
    private UnCompressor myUnCompressor;
    
    public int compress(InputStream in, OutputStream out, boolean force) throws IOException {
        if (force == true || (force == false && originalBits - writeBits > 0)) {
        	showString("Start Compressing");
        	myCompressor.writeOut(in, out);
        	return writeBits;
        }
        
        
        else {
        	showString("It's does not save space to compress this file. \n"
        			+ "If you want to compress this file, choose Force compression");
        	return -1;
        }
    }

    public int preprocessCompress(InputStream in, int headerFormat) throws IOException {
        //showString("Start preCompressing");
        
        myCompressor = new Compressor(in, headerFormat, myViewer);
        originalBits = myCompressor.bitsOriginal();
        writeBits = myCompressor.bitsWritten();
        //myViewer.update("The bits could be saved: " + (originalBits - writeBits) + " bits");
        return originalBits - writeBits;
    }

    public void setViewer(HuffViewer viewer) {
        myViewer = viewer;
    }

    public int uncompress(InputStream in, OutputStream out) throws IOException {
    	BitInputStream bits = new BitInputStream(in);
    	int magic = bits.readBits(BITS_PER_INT); 
    	if (magic != MAGIC_NUMBER) {
    	    myViewer.showError("Error reading compressed file. \n" +
    	            "File did not start with the huff magic number.");
    	    bits.close();
    	    return -1;
    	}
    	//showString("Start UnCompressing");
    	myUnCompressor = new UnCompressor(bits, myViewer);
    	int result = myUnCompressor.deCoding(bits, out);
    	// myViewer.update("The bits of UnCompressed file: " + result + " bits");
        return result;
    }
    
    private void showString(String s){
        if(myViewer != null)
            myViewer.update(s);
    }

}
