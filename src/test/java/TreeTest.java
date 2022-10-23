import Tree.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class TreeTest {

    public static void InitialTest(BinarySearchTree<Integer> tree) {

        Integer[] toInsert = {5,4,3,2,1,9,8,7,6};
        for (Integer integer : toInsert)
            tree.add(integer);

        PrintStream std = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.printPreOrder();
        System.out.println();
        tree.printInOrder();
        System.out.println();
        tree.printPostOrder();

        System.setOut(std);
        String[] output = outContent.toString().split("\n");

        System.out.println("Arbre " + tree.type());
        System.out.print("\tParcours préordre : ");
        System.out.println(output[0]);

        System.out.print("\tParcours en ordre : ");
        System.out.println(output[1]);

        System.out.print("\tParcours par post ordre : ");
        System.out.println(output[2]);

        System.out.println("\tElement minimal : " + tree.findMin(tree.get_root()).value);
        assert(tree.findMin(tree.get_root()).value.equals(1));

        System.out.println("\tAppartenance du 6 : " + tree.contains(6));
        assert(tree.contains(6));
    }

    public static void InsertOrderTest(BinarySearchTree<Integer> tree, int n) {

        Integer[] toInsert = new Integer[n];
        Arrays.setAll(toInsert, i -> i + 1);

        for (Integer integer : toInsert)
            tree.add(integer);

        PrintStream std = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.printPreOrder();
        System.out.println();
        tree.printInOrder();
        System.out.println();
        tree.printPostOrder();

        System.setOut(std);
        String[] output = outContent.toString().split("\n");

        System.out.println("Arbre " + tree.type());
        System.out.print("\tParcours préordre : ");
        System.out.println(output[0]);

        System.out.print("\tParcours en ordre : ");
        System.out.println(output[1]);

        System.out.print("\tParcours par post ordre : ");
        System.out.println(output[2]);
    }


    public static void RemoveOrderTest(BinarySearchTree<Integer> tree, int n) {

        System.out.println("Arbre " + tree.type());

        Integer[] toInsert = new Integer[n];
        Arrays.setAll(toInsert, i -> i + 1);

        System.out.print("\tInsertion des élements : ");
        for (Integer integer : toInsert)
            tree.add(integer);

        for (Integer integer : toInsert)
            assert(tree.contains(integer));
        System.out.println("OK");

        System.out.print("\tRetrait des élements : ");
        for (Integer integer : toInsert)
            tree.remove(integer);

        for (Integer integer : toInsert)
            assert(!tree.contains(integer));
        System.out.println("OK");
    }
}
