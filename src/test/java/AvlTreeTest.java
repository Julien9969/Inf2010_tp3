import Tree.AvlTree;
import Tree.BinarySearchTree;

class AVLTreeTester {
    public static void main(String[] args) {

        TreeTest.InitialTest(new AvlTree<Integer>());
        System.out.println();
        TreeTest.InitialTest(new BinarySearchTree<Integer>());
        System.out.println();

        TreeTest.InsertOrderTest(new AvlTree<Integer>(), 100);
        System.out.println();
        TreeTest.InsertOrderTest(new BinarySearchTree<Integer>(), 100);
        System.out.println();


        TreeTest.RemoveOrderTest(new AvlTree<Integer>(), 100);
        System.out.println();
        TreeTest.RemoveOrderTest(new BinarySearchTree<Integer>(), 100);
        System.out.println();

    }
}
