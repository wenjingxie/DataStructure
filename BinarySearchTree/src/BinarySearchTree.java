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
import java.util.List;
/**
 * Shell for a binary search tree class.
 * @author scottm
 *
 */

public class BinarySearchTree<E extends Comparable<E>> {

    private BSTNode<E> root;
    private int size;
    
    //constructor
    public BinarySearchTree() {
    	root = null;
    	size = 0;
    }

    /**
     *  Add the specified item to this Binary Search Tree if it is not already present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Add value to this tree if not already present. Return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to add to the tree
     *  @return false if an item equivalent to value is already present
     *  in the tree, return true if value is added to the tree and size() = old size() + 1
     */
    //code from lecture
    public boolean add(E value) {
    	//check precondition
    	if (value == null) {
    		throw new IllegalArgumentException("The value to be added could not be null!");
    	}
    	int oldSize = size;
    	root = addHelper(root, value);
        return oldSize != size;
    }
    
    //addHelper
    private BSTNode<E> addHelper(BSTNode<E> node, E value) {
    	if (node == null) {
    		size++;
    		return new BSTNode<E>(null, value, null);
    	}
    	int dir = value.compareTo(node.getData());
    	if (dir < 0) {
    		node.setLeft(addHelper(node.getLeft(), value));
    	}
    	else if (dir > 0) {
    		node.setRight(addHelper(node.getRight(), value));
    	}
    	return node;
    }

    /**
     *  Remove a specified item from this Binary Search Tree if it is present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Remove value from the tree if present, return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to remove from the tree if present
     *  @return false if value was not present
     *  returns true if value was present and size() = old size() - 1
     */
    //code from lecture
    public boolean remove(E value) {
    	if (value == null) {
    		throw new IllegalArgumentException("The value to be removed could not be null!");
    	}
    	int oldSize = size;
    	root = removeHelper(root, value);
        return size != oldSize;
    }
    
    //remove helper
    private BSTNode<E> removeHelper(BSTNode<E> node, E value) {
    	if (node == null) {
    		return null;
    	}
    	int dir = value.compareTo(node.getData());
    	if (dir < 0) {
    		node.setLeft(removeHelper(node.getLeft(), value));
    	}
    	else if (dir > 0) {
    		node.setRight(removeHelper(node.getRight(), value));
    	}
    	else {
    		size--;
    		if (node.getLeft() == null && node.getRight() == null) {
    			node = null;
    		}
    		else if (node.getRight() == null) {
    			node = node.getLeft();
    		}
    		else if (node.getLeft() ==  null) {
    			node = node.getRight();
    		}
    		else {
    			E maxLeft = getMax(node.getLeft());
    			node.setData(maxLeft);
    			size++;
    			node.setLeft(removeHelper(node.getLeft(), maxLeft));
    		}

    	}
    	return node;
    	
    }

    private E getMax(BSTNode<E> node) {
    	while (node.getRight() != null) {
    		node = node.getRight();
    	}
    	return node.getData();
    }

    /**
     *  Check to see if the specified element is in this Binary Search Tree.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: return true if value is present in tree, false otherwise
     *  @param value the value to look for in the tree
     *  @returns true if value is present in this tree, false otherwise
     */
    public boolean isPresent(E value) {
    	if (value == null) {
    		throw new IllegalArgumentException("The value to be searched could be null!");
    	}
    	
    	
        return isPresentHelper(root, value);
    }
    
    private boolean isPresentHelper(BSTNode<E> node, E value) {
    	if (node == null) {
    		return false;
    	}
    	int dir = value.compareTo(node.getData());
    	if (dir == 0) {
    		return true;
    	}
    	else if(dir < 0) {
    		return isPresentHelper(node.getLeft(), value);
    	}
    	else {
    		return isPresentHelper(node.getRight(), value);
    	}
    }


    /**
     *  Return how many elements are in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the number of items in this tree
     *  @returns the number of items in this Binary Search Tree
     */
    public int size() {
        return size;
    }

    /**
     *  return the height of this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the height of this tree.
     *  If the tree is empty return -1, otherwise return the
     *  height of the tree
     *  @returns the height of this tree or -1 if the tree is empty
     */
    public int height() {
        return heightHelper(root);
    }
    
    private int heightHelper(BSTNode<E> node) {
    	if (node == null) {
    		return -1;
    	}
    	return 1 + Math.max(heightHelper(node.getLeft()), heightHelper(node.getRight()));
    }

    /**
     *  Return a list of all the elements in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return a List object with all data from the tree in ascending order. 
     *  If the tree is empty return an empty List
     *  @returns a List object with all data from the tree in sorted order
     *  if the tree is empty return an empty List
     */
    public List<E> getAll() {
    	ArrayList<E> result = new ArrayList<E>();
    	getAllHelper(root, result);
        return result;
    }
    
    private void getAllHelper(BSTNode<E> node, ArrayList<E> result) {
    	if (node != null) {
    		getAllHelper(node.getLeft(), result);
    		result.add(node.getData());
    		getAllHelper(node.getRight(), result);
    	}
    }



    /**
     * return the maximum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the largest value in this Binary Search Tree
     * @return the maximum value in this tree
     */
    public E max() {
    	if (size == 0) {
    		throw new IllegalArgumentException("The tree is empty!");
    	}
    	BSTNode<E> temp = root;
    	while (temp.getRight()!= null) {
    		temp = temp.getRight();
    	}
        return temp.getData();
    }

    /**
     * return the minimum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the smallest value in this Binary Search Tree
     * @return the minimum value in this tree
     */
    public E min() {
    	if (size == 0) {
    		throw new IllegalArgumentException("The tree is empty!");
    	}
    	BSTNode<E> temp = root;
    	while (temp.getLeft()!= null) {
    		temp = temp.getLeft();
    	}
        return temp.getData();
    }

    /**
     * An add method that implements the add algorithm iteratively instead of recursively.
     * <br>pre: data != null
     * <br>post: if data is not present add it to the tree, otherwise do nothing.
     * @param data the item to be added to this tree
     * @return true if data was not present before this call to add, false otherwise.
     */
    public boolean iterativeAdd(E data) {
    	if (data == null) {
    		throw new IllegalArgumentException("The data to be added could not be null!");
    	}

    	if (root == null) {
    		root = new BSTNode<E>(null, data, null);
    		size++;
    		return true;
    	}
    	int oldSize = size;
    	int dir = data.compareTo(root.getData());
    	BSTNode<E> temp = root;
    	while ((dir < 0 && temp.getLeft() != null) || (dir > 0 && temp.getRight() != null)) {
    		if (dir < 0) {
    			temp = temp.getLeft();
    		}
    		if (dir > 0) {
    			temp = temp.getRight();
    		}
			dir = data.compareTo(temp.getData());
    	}
    	if (dir < 0) {
    		temp.setLeft(new BSTNode<E>(null, data, null));
    		size++;
    	}
    	if (dir > 0) {
    		temp.setRight(new BSTNode<E>(null, data, null));
    		size++;
    	}
        return size != oldSize;
    }


    /**
     * Return the "kth" element in this Binary Search Tree. If kth = 0 the 
     * smallest value (minimum) is returned. If kth = 1 the second smallest value is
     * returned, and so forth.
     * <br>pre: 0 <= kth < size()
     * @param kth indicates the rank of the element to get
     * @return the kth value in this Binary Search Tree
     */
    public E get(int kth) {
    	if (kth < 0 || kth >= size()) {
    		throw new IllegalArgumentException("The rank is out of bounds!");
    	}
    	ArrayList<E> result = new ArrayList<E>();
    	int[] counter = new int[1];
    	counter[0] = 0;
    	getHelper(result, counter, root, kth);
        return result.get(0);
    }
    
    private void getHelper(ArrayList<E> result, int[] counter, BSTNode<E> node, int kth) {
    	if (node != null && counter[0] <= kth) {
    		getHelper(result, counter, node.getLeft(), kth);
    		if (counter[0] == kth) {
    			result.add(node.getData());
    		}
    		counter[0]++;
    		getHelper(result, counter, node.getRight(), kth);
    	}
    	
    	
    	
    }


    /**
     * Return a List with all values in this Binary Search Tree that are less than
     * the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are less than the parameter value. If there are
     * no values in this tree less than value return an empty list. The elements of the list are in ascending order.
     */
    public List<E> getAllLessThan(E value) {
    	if (value == null) {
    		throw new IllegalArgumentException("The value could not be null!");
    	}
    	
    	ArrayList<E> result = new ArrayList<E>();
    	getAllLessThanHelper(result, value, root);
        return result;
    }
    
    private void getAllLessThanHelper(ArrayList<E> result, E value, BSTNode<E> node) {
    	if (node != null) {
    		int dir = value.compareTo(node.getData());
    		if (dir < 0) {
    			getAllLessThanHelper(result, value, node.getLeft());
    		}
    		if (dir == 0) {
    			getAllHelper(node.getLeft(), result);
    		}
    		if (dir > 0) {
    			getAllHelper(node.getLeft(), result);
    			result.add(node.getData());
    			getAllLessThanHelper(result, value, node.getRight());
    		}
    	}
    }


    /**
     * Return a List with all values in this Binary Search Tree that are greater than
     * the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are greater than the parameter value. If there are
     * no values in this tree greater than value return an empty list. The elements of the list are in ascending order.
     */
    public List<E> getAllGreaterThan(E value) {
    	if (value == null) {
    		throw new IllegalArgumentException("The value could not be null!");
    	}
    	
    	ArrayList<E> result = new ArrayList<E>();
    	getAllGreaterThanHelper(result, value, root);
        return result;
    }
    
    private void getAllGreaterThanHelper(ArrayList<E> result, E value, BSTNode<E> node) {
    	if (node != null) {
    		int dir = value.compareTo(node.getData());
    		if (dir < 0) {
    			getAllGreaterThanHelper(result, value, node.getLeft());
    			result.add(node.getData());
    			getAllHelper(node.getRight(), result);
    		}
    		if (dir == 0) {
    			getAllHelper(node.getRight(), result);
    		}
    		if (dir > 0) {
    			getAllGreaterThanHelper(result, value, node.getRight());
    		}
    	}
    }



    /**
     * Find the number of nodes in this tree at the specified depth.
     * <br>pre: none
     * @param d The target depth.
     * @return The number of nodes in this tree at a depth equal to
     * the parameter d.
     */
    public int numNodesAtDepth(int d) {
    	
        return nodesAtDepth(d).size();
    }
    
    private ArrayList<BSTNode<E>> nodesAtDepth(int d) {
    	ArrayList<BSTNode<E>> nodes = new ArrayList<BSTNode<E>>();
    	if (root != null) {
    		if (d == 0) {
        		nodes.add(root);
        		return nodes;
        	}
        	for (BSTNode<E> node : nodesAtDepth(d - 1)) {
        		if (node.getLeft() != null) {
        			nodes.add(node.getLeft());
        		}
        		if (node.getRight() != null) {
        			nodes.add(node.getRight());
        		}
        	}
    	}
    	
    	return nodes;
    }

    /**
     * Prints a vertical representation of this tree.
     * The tree has been rotated counter clockwise 90
     * degrees. The root is on the left. Each node is printed
     * out on its own row. A node's children will not necessarily
     * be at the rows directly above and below a row. They will
     * be indented three spaces from the parent. Nodes indented the
     * same amount are at the same depth.
     * pre: none
     */
    public void printTree() {
        printTree(root, "");
    }

    private void printTree(BSTNode<E> n, String spaces) {
        if(n != null){
            printTree(n.getRight(), spaces + "  ");
            System.out.println(spaces + n.getData());
            printTree(n.getLeft(), spaces + "  ");
        }
    }

    private static class BSTNode<E extends Comparable<E>> {
        private E data;
        private BSTNode<E> left;
        private BSTNode<E> right;

        public BSTNode() {
            this(null);
        }

        public BSTNode(E initValue) {
            this(null, initValue, null); 
        }

        public BSTNode(BSTNode<E> initLeft,
                E initValue,        
                BSTNode<E> initRight) {
            data = initValue; 
            left = initLeft; 
            right = initRight; 
        }

        public E getData() { 
            return data; 
        }

        public BSTNode<E> getLeft() { 
            return left;
        }

        public BSTNode<E> getRight() { 
            return right; 
        }

        public void setData(E theNewValue) { 
            data = theNewValue; 
        }

        public void setLeft(BSTNode<E> theNewLeft) { 
            left = theNewLeft; 
        }

        public void setRight(BSTNode<E> theNewRight) { 
            right = theNewRight; 
        }    
    }
}
