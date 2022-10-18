public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T>{
    @Override
    public void add(T value) {
        this.root = add(value, this.root);
    }

    protected BinaryNode<T> add(T value, BinaryNode<T> curNode) {
        //TODO
        if( curNode == null)
            return new AvlNode<T>( value, null, null);
        int compareResult = value.compareTo( curNode.value);
        if( compareResult< 0 )
        {
            curNode.left= insert( value, curNode.left);
            if( height( curNode.left) -height( curNode.right) == 2 )
                if( value.compareTo( curNode.left.value) < 0 )
                    curNode = rotateWithLeftChild( curNode ); // premier cas de figure
                else
                    curNode = doubleWithLeftChild( curNode ); // second cas de figure
        }
        elseif( compareResult> 0 )
        {
            curNode.right= insert( value, curNode.right);
            if( height( curNode.right) -height( curNode.left) == 2 )
                if( value.compareTo( curNode.right.value) > 0 )
                    curNode = rotateWithRightChild( curNode ); // premier cas de figure
                else
                    curNode = doubleWithRightChild( curNode ); // second cas de figure
        }
        else
        ; // Pas de doublons
// Mettre à jour les hauteurs en remontant
        curNode.height= Math.max( height( curNode.left), height( curNode.right) ) + 1;
        return curNode;

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
}
