public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T>{
    @Override
    public void add(T value) {
        this.root = add(value, this.root);
    }

    @Override
    public void remove(T value) {
        this.root = remove(value, this.root);
    }

    protected BinaryNode<T> remove(T value, BinaryNode<T> curNode) {
        //TODO
        return null;
    }

   //TODO Ajouter les méthodes manquantes
    protected BinaryNode<T> add(T x, BinaryNode<T> t)
    {
        if (t == null)
            return new BinaryNode<T>(x);

        int compareResult = x.compareTo(t.value);

        if ( compareResult < 0)
            t.left = add( x, t.left);
        else if ( compareResult > 0)
            t.right = add( x, t.right);

        return balance(t);
    }

    private BinaryNode balance( BinaryNode<T> t)
    {
        if (t == null)
            return t;

        if ( t.left.height() - t.right.height() > 1)
        {
            if ( t.left.left.height() - t.left.right.height() >= 0)
                t = rotateWithLeftChild(t);
            else
                t = doubleWithLeftChild(t);
        }
        else if ( t.left.height() - t.right.height() < -1)
        {
            if ( t.left.left.height() - t.left.right.height() <= 0)
                t = rotateWithRightChild(t);
            else
                t = doubleWithRightChild(t);
        }

        t.height = Math.max( t.left.height(), t.right.height()) + 1;
        return t;
    }

    private BinaryNode<T> rotateWithLeftChild( BinaryNode<T> k2)
    {
        BinaryNode<T> k1 = k2.left;

        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max( k2.left.height(), k2.right.height()) + 1;
        k1.height = Math.max( k1.left.height(), k2.height()) + 1;

        return k1;
    }

    private BinaryNode<T> doubleWithLeftChild( BinaryNode<T> k3)
    {
        k3.left = rotateWithLeftChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private BinaryNode<T> rotateWithRightChild( BinaryNode<T> k2)
    {
        BinaryNode<T> k1 = k2.right;

        k2.right = k1.left;
        k1.left = k2;


        k1.height = Math.max( k2.right.height(), k1.height()) + 1;
        k2.height = Math.max( k1.left.height(), k1.right.height()) + 1;

        return k1;
    }

    private BinaryNode<T> doubleWithRightChild( BinaryNode<T> k1)
    {
        k1.left = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }





}
