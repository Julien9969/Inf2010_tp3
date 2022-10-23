package Tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T> {

    public void add(T data) {
        this.root = add(data, root);
    }

    protected BinaryNode<T> add(T value, BinaryNode<T> curNode) {

        if (curNode == null)
            return new BinaryNode<>(value, 0);
        int compareResult = value.compareTo(curNode.value);

        if (compareResult < 0) {
            curNode.left = add(value, curNode.left);
        } else if ( compareResult > 0) {
            curNode.right = add(value, curNode.right);
        }

        curNode.height = Math.max(curNode.height(curNode.left), curNode.height(curNode.right)) + 1;
        return curNode;
    }

    public boolean contains(T value) {
        return contains(value, root);
    }

    private boolean contains(T value, BinaryNode<T> curNode) {

        while (curNode != null){
            if (curNode.value == value){
                return true;
            }
            else {
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

    public String type() { return "BST"; }
}
