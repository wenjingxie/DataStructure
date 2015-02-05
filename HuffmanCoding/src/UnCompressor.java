
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
import java.io.OutputStream;


public class UnCompressor {
	private HuffmanTree myTree;
	private HuffViewer myViewer;
	
	public UnCompressor(BitInputStream bits, HuffViewer myViewer) throws IOException {
		this.myViewer = myViewer;
		int headerFormat = bits.readBits(IHuffConstants.BITS_PER_INT);
		if (headerFormat == IHuffConstants.STORE_COUNTS) {
			int[] myCounts = new int[IHuffConstants.ALPH_SIZE];
			for (int i = 0; i < IHuffConstants.ALPH_SIZE; i++) {
				myCounts[i] = bits.readBits(IHuffConstants.BITS_PER_INT);
			}
			myTree = new HuffmanTree(myCounts);
		}
		else if (headerFormat == IHuffConstants.STORE_TREE) {
			
			int headerSize = bits.readBits(IHuffConstants.BITS_PER_INT);
			myTree = new HuffmanTree(bits, headerSize);
		}
		else if (headerFormat == IHuffConstants.STORE_CUSTOM) {
			throw new IOException("STORE_CUSTOM not implemented");
		}
		else {
			myViewer.showError("Error reading compressed file. \n" +
    	            "File did not contain the valid headerFormat.");
		}
	}
	
	
	public int deCoding(BitInputStream bits, OutputStream out) throws IOException {
		BitOutputStream outBits = new BitOutputStream(out);
		int val;
		int countBits =0;
		StringBuilder sb = new StringBuilder();
		while ((val = getVal(bits, myTree.getRoot())) != IHuffConstants.PSEUDO_EOF) {
			sb.append(getWordString(val));
			countBits += IHuffConstants.BITS_PER_WORD;
		}
		int index = 0;
		while (sb.length() - index > IHuffConstants.BITS_PER_INT - 1) {
			String s = sb.substring(index, index + IHuffConstants.BITS_PER_INT - 1);
			outBits.writeBits(IHuffConstants.BITS_PER_INT - 1, Integer.valueOf(s, 2));
			index += IHuffConstants.BITS_PER_INT - 1;
		}
		String s = sb.substring(index);
		outBits.writeBits(sb.length() - index, Integer.valueOf(s, 2));
		bits.close();
		outBits.close();
		return countBits;
		
	}
	
	private StringBuilder getWordString(int val) {
		StringBuilder sb = new StringBuilder();
		String s = Integer.toBinaryString(val);
		if (s.length() < IHuffConstants.BITS_PER_WORD) {
			for (int i = 0; i < IHuffConstants.BITS_PER_WORD - s.length(); i++) {
				sb.append('0');
			}
		}
		sb.append(s);
		return sb; 
	}
	
	private int getVal(BitInputStream bits, TreeNode node) throws IOException {
		if (node.getLeft() == null && node.getRight() == null) {
			return node.getValue();
		}
		else {
			int read;
			if ((read = bits.readBits(1)) == -1) {
				myViewer.showError("Error reading compressed file. \n" +
    	            "Unexpected end of input. No PSEUDO_EOF character.");
				return -1;
			}
			else if (read == 0) {
				return getVal(bits, node.getLeft());
			}
			else {
				return getVal(bits, node.getRight());
			}
		}
	}

}
