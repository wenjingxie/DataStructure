import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;


public class tester {

	public static void main(String[] args) throws IOException {
//		 InputStream myInput = new BufferedInputStream(new FileInputStream("1.txt.hf"));
//		 BitInputStream bits = new BitInputStream(myInput);
//		 int magic = bits.readBits(IHuffConstants.BITS_PER_INT);
//		 if (magic == IHuffConstants.MAGIC_NUMBER) {
//			 System.out.println("magic!");
//		 }
//		 if (bits.readBits(IHuffConstants.BITS_PER_INT) == IHuffConstants.STORE_TREE) {
//			 System.out.println("TreeHeader!");
//		 }
//		 int size = bits.readBits(IHuffConstants.BITS_PER_INT);
//		 HuffmanTree tree = new HuffmanTree(bits, size);
//		 System.out.println(tree.size());
//
//		 String[] codes = tree.chunkCoding();
//		 int i = 0;
//		 for (String code : codes) {
//		 System.out.println(i + "   " + code);
//		 i++;
		
		System.out.println(Integer.valueOf("1111110110100001001110001110111", 2));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		int x = 50;
		System.out.println(Integer.toBinaryString(x));
	 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
//		 Compressor myCompress = new Compressor(myInput, 23);
//		 int[] counts = myCompress.myCounts;
//		 int i =0;
////		 for (int count : counts) {
////			 System.out.println(i + "   " + count);
////			 i++;
////		 }
//		 HuffmanTree tree = new HuffmanTree(counts);
//		 String[] codes = tree.chunkCoding();
//		 for (String code : codes) {
//		 System.out.println(i + "   " + code);
//		 i++;
//	 }
	

}
