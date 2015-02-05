

public class BinaryNode<E> {

    private E data;
    private BinaryNode<E> left;
    private BinaryNode<E> right;
    
    public BinaryNode() {
        this(null, null, null);
    }
    
    public BinaryNode(BinaryNode<E> l,
            E d, BinaryNode<E> r) {
        left = l;
        data = d;
        right = r;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BinaryNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<E> left) {
        this.left = left;
    }

    public BinaryNode<E> getRight() {
        return right;
    }

    public void setRight(BinaryNode<E> right) {
        this.right = right;
    }
}
