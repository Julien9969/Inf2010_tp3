package Tree;

public class BinaryTree<T> {
    protected BinaryNode<T> root = null;

    public BinaryNode<T> get_root() { return this.root; }

    public void printPostOrder() {

        printPostOrder(root);
        System.out.print("END");
    }

    private void printPostOrder(BinaryNode<T> node) {

        if (node != null)
        {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.value);
            System.out.print(" -> ");
        }
    }

    public void printPreOrder() {

        printPreOrder(root);
        System.out.print("END");
    }

    private void printPreOrder(BinaryNode<T> node) {

        if (node != null)
        {
            System.out.print(node.value);
            System.out.print(" -> ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public void printInOrder() {

        printInOrder(root);
        System.out.print("END");
    }

    private void printInOrder(BinaryNode<T> node) {

        if (node != null)
        {
            printInOrder(node.left);
            System.out.print(node.value);
            System.out.print(" -> ");
            printInOrder(node.right);
        }
    }
}

