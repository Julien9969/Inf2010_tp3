package Tree;

public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    @Override
    protected BinaryNode<T> add(T x, BinaryNode<T> t)
    {
        if (t == null)
            return new BinaryNode<>(x);

        int comparRes = x.compareTo(t.value);

        if ( comparRes < 0)
            t.left = add(x, t.left);
        else if ( comparRes > 0)
            t.right = add(x, t.right);

        return balance(t);
    }

    @Override
    protected BinaryNode<T> remove( T x, BinaryNode<T> t)
    {
        if (t == null)
            return null;

        int comparRes = x.compareTo(t.value);

        if( comparRes < 0)
            t.left = remove(x, t.left);
        else if ( comparRes > 0)
            t.right = remove(x, t.left);
        else if( t.left != null && t.right != null){
            t.value = findMin(t.right).value;
            t.right = remove(t.value, t.right);
        }
        else
            t = (t.left != null)? t.left: t.right;

        return balance(t);
    }

    private int balanceNode( BinaryNode<T> t) {
        return t.height(t.left) - t.height(t.right);
    }

    private BinaryNode<T> balance( BinaryNode<T> t)
    {
        if (t == null)
            return null;

        if (balanceNode(t) > 1)
            t = (balanceNode(t.left) >= 0)? rotateWithLeftChild(t): doubleWithLeftChild(t);
        else if (balanceNode(t) < -1)
            t = (balanceNode(t.right) <= 0)? rotateWithRightChild(t): doubleWithRightChild(t);

        t.height = Math.max( t.height(t.left), t.height(t.right)) + 1;
        return t;
    }

    private BinaryNode<T> rotateWithLeftChild( BinaryNode<T> k2)
    {
        BinaryNode<T> k1 = k2.left;

        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max( k2.height(k2.left), k2.height(k2.right)) + 1;
        k1.height = Math.max( k1.height(k1.left), k2.height) + 1;

        return k1;
    }

    private BinaryNode<T> doubleWithLeftChild( BinaryNode<T> k3)
    {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private BinaryNode<T> rotateWithRightChild( BinaryNode<T> k1)
    {
        BinaryNode<T> k2 = k1.right;

        k1.right = k2.left;
        k2.left = k1;

        k1.height = Math.max(k1.height(k1.left), k1.height(k1.right)) + 1;
        k2.height = Math.max(k2.height(k2.right), k1.height) + 1;

        return k2;
    }

    private BinaryNode<T> doubleWithRightChild(BinaryNode<T> k1)
    {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    @Override
    public String type() { return "AVL"; }

}