
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


public class Compressor {
	
	private int[] myCounts;
	private String[] codes;
	private int headerFormat;
	private HuffmanTree myTree;
	private HuffViewer myViewer;
	
	
	public Compressor(InputStream in, int headerFormat, HuffViewer myViewer) throws IOException {
		this.myViewer = myViewer;
		//count chunk frequency
		BitInputStream bits = new BitInputStream(in);
		myCounts = new int[IHuffConstants.ALPH_SIZE];
		int inBits;
		while ((inBits = bits.readBits(IHuffConstants.BITS_PER_WORD)) != -1) {
			myCounts[inBits]++;
		}
		bits.close();
		
		//create codes map
		myTree = new HuffmanTree(myCounts);
		codes = myTree.chunkCoding();
		
		this.headerFormat = headerFormat;
	}
	
	public int bitsOriginal() {
		int result = 0;
		for (int count :myCounts) {
			result += count;
		}
		return result * IHuffConstants.BITS_PER_WORD;
	}
	
	public int bitsWritten() throws IOException {
		//magic number + header constant
		int result = 2 * IHuffConstants.BITS_PER_INT;
		if (headerFormat == IHuffConstants.STORE_COUNTS) {
			// STORE_COUNTS header
			result += IHuffConstants.ALPH_SIZE * IHuffConstants.BITS_PER_INT;
		}
		else if (headerFormat == IHuffConstants.STORE_TREE) {
			result += IHuffConstants.BITS_PER_INT;//indicating how many bits are in the tree representation
			result += myTree.size();
			for (int count : myCounts) {
				if (count != 0) {
					result += IHuffConstants.BITS_PER_WORD + 1;
				}
			}
			result += IHuffConstants.BITS_PER_WORD + 1;//Pseudo Character
			
		}
		
		else if (headerFormat == IHuffConstants.STORE_CUSTOM) {
			throw new IOException("STORE_CUSTOM not implemented");
		}
		
		else {
			myViewer.showError("Error compressing file. \n" +
    	            "It is not the valid headerFormat.");
		}

		//actual data
		for (int i = 0; i < IHuffConstants.ALPH_SIZE; i++) {
			if (myCounts[i] != 0) {
				result += myCounts[i] * codes[i].length();
			}

		}
		//pseudo character
		result += codes[IHuffConstants.ALPH_SIZE].length();
		return result;
	}

	
	
	public void writeOut(InputStream in, OutputStream out) throws IOException {
		BitOutputStream outBits = new BitOutputStream(out); 
		//write Magic Number
		outBits.writeBits(IHuffConstants.BITS_PER_INT, IHuffConstants.MAGIC_NUMBER);
		//write header Format
		outBits.writeBits(IHuffConstants.BITS_PER_INT, headerFormat);
		//write header
		if (headerFormat == IHuffConstants.STORE_COUNTS) {
			for (int i = 0; i < IHuffConstants.ALPH_SIZE; i++) {
				outBits.writeBits(IHuffConstants.BITS_PER_INT, myCounts[i]);
			}
		}
		else if (headerFormat == IHuffConstants.STORE_TREE) {
			int treeHeaderSize = myTree.size();
			for (int count : myCounts) {
				if (count != 0) {
					treeHeaderSize += IHuffConstants.BITS_PER_WORD + 1; 
				}
			}
			treeHeaderSize += IHuffConstants.BITS_PER_WORD + 1;
			outBits.writeBits(IHuffConstants.BITS_PER_INT, treeHeaderSize);
			writeTreeHeader(myTree.getRoot(), outBits);
		}
		//write data
		StringBuilder sb = new StringBuilder();
		BitInputStream bits = new BitInputStream(in);
		int inBits;
		while ((inBits = bits.readBits(IHuffConstants.BITS_PER_WORD)) != -1) {
			sb.append(codes[inBits]);
		}
		bits.close();
		//write Pseudo Character
		sb.append(codes[IHuffConstants.ALPH_SIZE]);

		
		int index = 0;
		while (sb.length() - index > IHuffConstants.BITS_PER_INT - 1) {
			String val = sb.substring(index, index + IHuffConstants.BITS_PER_INT - 1);
			outBits.writeBits(IHuffConstants.BITS_PER_INT - 1, Integer.valueOf(val, 2));
			index += IHuffConstants.BITS_PER_INT - 1;
		}
		
		String val = sb.substring(index);
		outBits.writeBits(sb.length() - index, Integer.valueOf(val, 2));
		outBits.close();
		
	}
	
	
	
	private void writeTreeHeader(TreeNode node, BitOutputStream bitsOut) {
		if (node != null) {
			if (node.getLeft() == null && node.getRight() == null) {
				bitsOut.writeBits(1, 1);
				bitsOut.writeBits(IHuffConstants.BITS_PER_WORD + 1, node.getValue());
				
			}
			else {
				bitsOut.writeBits(1, 0);
				writeTreeHeader(node.getLeft(), bitsOut);
				writeTreeHeader(node.getRight(), bitsOut);
			}
		}
	}

}
