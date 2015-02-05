

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversals {
    
    public static void main(String[] args) {
        
        /*
         * TREE =
         *     12
         *    /  \
         *   5   37
         *  / \    \
         * 42  0    7
         *    /
         *   13
         */
        BinaryNode<Integer> r = new BinaryNode<Integer>(null, 12, null);
        r.setLeft(new BinaryNode<Integer>(null, 5, null));
        r.setRight(new BinaryNode<Integer>(null, 37, null));
        r.getLeft().setLeft(new BinaryNode<Integer>(null, 42, null));
        r.getLeft().setRight(new BinaryNode<Integer>(null, 0, null));
        r.getLeft().getRight().setLeft(new BinaryNode<Integer>(null, 13, null));
        r.getRight().setRight(new BinaryNode<Integer>(null, 7, null));
        
        printPreorder(r);
        System.out.println();
        printInorder(r);
        System.out.println();
        printLevelOrder(r);
        System.out.println();
        printPostorder(r);
        
        delete(r);
        printPreorder(r);
    }

    // pre: none
    // post: print out a pre order traversal for the given tree
    public static<E> void printPreorder(BinaryNode<E> root) {
        if(root != null) {
            System.out.print(root.getData() + " ");
            printPreorder(root.getLeft());
            printPreorder(root.getRight());
        }
        // else empty tree, do nothing, base cases
    }
    
    // pre: none
    // post: print out a in order traversal for the given tree
    public static<E> void printInorder(BinaryNode<E> root) {
        if(root != null) {
            
            printInorder(root.getLeft());
            System.out.print(root.getData() + " ");
            printInorder(root.getRight());
        }
        // else empty tree, do nothing, base cases
    }


    public static <E> void printLevelOrder(BinaryNode<E> root) {
        if(root != null) {
            Queue<BinaryNode<E>> q = new LinkedList<BinaryNode<E>>();
            q.add(root);
            while(!q.isEmpty()) {
                BinaryNode<E> currentNode = q.remove();
                assert currentNode != null : "I was wrong.";
                System.out.print(currentNode.getData() + " ");
                if(currentNode.getLeft() != null)
                    q.add(currentNode.getLeft());
                if(currentNode.getRight() != null)
                    q.add(currentNode.getRight());
            }
        }
    }
    
    
    public static<E> void printPostorder(BinaryNode<E> root) {
        if(root != null) {
            
            printPostorder(root.getLeft());

            printPostorder(root.getRight());
            System.out.print(root.getData() + " ");
        }
        // else empty tree, do nothing, base cases
    }

    public static<E> void delete (BinaryNode<E> root) {
        if(root != null) {
        	if (root.getLeft() == null && root.getRight() == null) {
        		root = null;
        	}
        	else{
        		delete(root.getLeft());
        		delete(root.getRight());
        	}
        	
          
        }
        // else empty tree, do nothing, base cases
    }





}
