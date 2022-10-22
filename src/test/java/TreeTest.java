import Tree.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TreeTest {

    public static void InitialTest(BinarySearchTree<Integer> tree) {

        Integer[] toInsert = {5,4,3,2,1,9,8,7,6};
        for(int i = 0; i < toInsert.length; i++) {
            tree.add(toInsert[i]);
        }

        PrintStream std = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree.printPreOrder();
        System.out.println("");
        tree.printInOrder();
        System.out.println("");
        tree.printPostOrder();

        System.setOut(std);
        String[] output = outContent.toString().split("\n");

        System.out.print("Parcours préordre de " + tree.type() + ": ");
        System.out.println(output[0].toString());
        //assert(output[0].toString().equals("5 -> 1 -> 2 -> 3 -> 4 -> 6 -> 7 -> 8 -> 9 -> END"));

        System.out.print("Parcours en ordre de " + tree.type() + ": ");
        System.out.println(output[1].toString());
        //assert(output[1].equals("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> END"));

        System.out.print("Parcours par post ordre " + tree.type() + ": ");
        System.out.println(output[2].toString());
        assert(output[2].equals("1 -> 2 -> 3 -> 4 -> 6 -> 7 -> 8 -> 9 -> 5 -> END"));

        System.out.println("Element minimal : " + tree.findMin(tree.get_root()).value);
        assert(tree.findMin(tree.get_root()).value.equals(1));

        System.out.println("Appartenance du 6 : " + tree.contains(6));
        assert(tree.contains(6));

    }
}
