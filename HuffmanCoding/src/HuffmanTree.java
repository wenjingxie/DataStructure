
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


public class HuffmanTree {
	private TreeNode root;
	private int size;
	
	public HuffmanTree(int[] counts) {
		MyPriorityQueue<TreeNode> huffQueue = new MyPriorityQueue<TreeNode>();
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] != 0) {
				huffQueue.enqueue(new TreeNode(i, counts[i]));
			}

		}
		huffQueue.enqueue(new TreeNode(IHuffConstants.PSEUDO_EOF, 1));
		size = huffQueue.size();
		while (huffQueue.size() > 1) {
			TreeNode leftChild = huffQueue.dequeue();
			TreeNode rightChild = huffQueue.dequeue();
			TreeNode newNode = new TreeNode(-1, leftChild.getWeight() + rightChild.getWeight(), leftChild, rightChild);
			huffQueue.enqueue(newNode);
			size++;
		}
		root = huffQueue.dequeue();
	}
	
	public HuffmanTree(BitInputStream bits, int headerSize) throws IOException {
		int[] numBitsLeft = new int[1];
		numBitsLeft[0] = headerSize;
		root = STFRebuildTree(bits, numBitsLeft);
	}
	
	private TreeNode STFRebuildTree(BitInputStream bits,int[] numBitsLeft) throws IOException{
		while (numBitsLeft[0] > 0) {
			int nodeType = bits.readBits(1);
			numBitsLeft[0]--;
			size++;
			if (nodeType == 1) {
				numBitsLeft[0] -= IHuffConstants.BITS_PER_WORD + 1;
				return new TreeNode(bits.readBits(IHuffConstants.BITS_PER_WORD + 1), -1);
			}
			else {
				TreeNode node = new TreeNode(-1, -1);
				node.setLeft(STFRebuildTree(bits, numBitsLeft));
				node.setRight(STFRebuildTree(bits, numBitsLeft));
				return node;
			}
		}
		return null;
	}
	
	public String[] chunkCoding() {
		String[] codings = new String[IHuffConstants.ALPH_SIZE + 1];
		StringBuilder sb = new StringBuilder();
		chunkCodingHelper(codings, root, sb);
		return codings;
	}
	
	private void chunkCodingHelper(String[] codings, TreeNode node, StringBuilder sb) {
		if (node != null) {
			if (node.getLeft() == null && node.getRight() == null) {
				codings[node.getValue()] = sb.toString();
			}
			else {
				//from the node go to the left child
				sb.append("0");
				chunkCodingHelper(codings, node.getLeft(), sb);
				sb.deleteCharAt(sb.length() - 1);
				
				//from the node go to the right child
				sb.append("1");
				chunkCodingHelper(codings, node.getRight(), sb);
				sb.deleteCharAt(sb.length() - 1);
				
			}
		}

		
	}
	

	
	public TreeNode getRoot() {
		return root;
	}
	
	public int size(){
		return size;
	}

}
