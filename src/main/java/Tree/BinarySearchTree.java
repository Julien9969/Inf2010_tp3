package Tree;

import Node.BinaryNode;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T> {

    protected Counter count = new Counter();

    public void reset(){
        count.reset();
        super.root = null;
    }

    public void add(T data) {
        this.root = add(data, root);
    }

    protected BinaryNode<T> add(T value, BinaryNode<T> curNode) {

        this.count.increments(Counter.op.INSERT);

        if (curNode == null)
            return new BinaryNode<>(value, 0);
        int compareResult = value.compareTo(curNode.value);

        if (compareResult < 0) {
            curNode.left = add(value, curNode.left);
        } else if ( compareResult > 0) {
            curNode.right = add(value, curNode.right);
        }

        return curNode;
    }

    public boolean contains(T value) {
        return contains(value, root);
    }

    private boolean contains(T value, BinaryNode<T> curNode) {

        while (curNode != null){
            count.increments(Counter.op.SEARCH);
            if (curNode.value == value){
                return true;
            } else {
                if (value.compareTo(curNode.value) < 0)
                    curNode = curNode.left;
                else
                    curNode = curNode.right;
            }
        }
        return false;
    }


    public void remove(T value) {
        this.root = remove(value, root);
    }

    protected BinaryNode<T> remove(T value, BinaryNode<T> curNode) {

        if ( curNode == null)
            return null;

        int compareResult = value.compareTo( curNode.value );

        if ( compareResult < 0)
            curNode.left = remove( value, curNode.left );
        else if ( compareResult > 0)
            curNode.right = remove( value, curNode.right );

        else if ( curNode.left != null && curNode.right != null ) // Cas deux enfants
        {
            curNode.value = findMin( curNode.right ).value;
            curNode.right = remove( curNode.value, curNode.right );
        }
        else
            curNode = ( curNode.left != null ) ? curNode.left : curNode.right;

        return curNode;
    }

    public BinaryNode<T> findMin(BinaryNode<T> curNode){

        if ( curNode == null)
            return null;
        else if ( curNode.left == null)
            return curNode;

        return findMin( curNode.left );
    }

    public int getCounter(Counter.op type) {
        return count.getCountSearch(type);
    }


    public String type() { return "BST"; }
}
