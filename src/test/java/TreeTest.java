import Tree.*;
import Tree.Counter.op;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

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

    public static void InsertOrderTest(BinarySearchTree<Integer> tree, int size) {

        Integer[] toInsert = new Integer[size];
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

        System.out.println("InsertOrderTest : Arbre " + tree.type());
        System.out.print("\tParcours préordre : ");
        System.out.println(output[0]);

        System.out.print("\tParcours en ordre : ");
        System.out.println(output[1]);

        System.out.print("\tParcours par post ordre : ");
        System.out.println(output[2]);
    }

    public static void RemoveOrderTest(BinarySearchTree<Integer> tree, int size) {

        System.out.println("RemoveOrderTest : Arbre " + tree.type());

        Integer[] toInsert = new Integer[size];

        // Insertion de tous les élements dans un ordre croissant
        Arrays.setAll(toInsert, i -> i + 1);
        System.out.print("\tInsertion des élements : ");
        for (Integer integer : toInsert)
            tree.add(integer);

        for (Integer integer : toInsert)
            assert(tree.contains(integer));
        System.out.println("OK");

        // Retrait des élements dans l'ordre inverse de l'insertion
        System.out.print("\tRetrait des élements : ");
        for (Integer integer : toInsert)
            tree.remove(integer);

        for (Integer integer : toInsert)
            assert(!tree.contains(integer));
        System.out.println("OK");
    }

    public static void CounterTest(BinarySearchTree<Integer> tree, int size) {

        System.out.println("CounterTest : Arbre " + tree.type());

        Integer[] toInsert = new Integer[size];
        // Insertion de tous les élements dans un ordre croissant
        Arrays.setAll(toInsert, i -> i + 1);
        for (Integer integer : toInsert)
            tree.add(integer);

        // Retrait de tous les élements dans un ordre croissant
        for (Integer integer : toInsert)
            tree.contains(integer);

        System.out.println("\tNombre d'appels de 'Tree.add' : " + tree.getCounter(op.INSERT));
        System.out.println("\tNombre d'appels de 'Tree.contains' : " + tree.getCounter(op.SEARCH));
    }


    public static void CounterMediumCase(BinarySearchTree<Integer> tree, int size, int repeat) {

        System.out.println("CounterMediumCaseTest : Arbre " + tree.type());

        Random rd = new Random();

        int nbSearch = 0;
        int nbInsert = 0;

        for (int m=0; m < repeat; m++) {

            ArrayList<Integer> toInsert = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                toInsert.add(rd.nextInt(size));
            }

            // Insertion de tous les élements dans un ordre aléatoire
            Collections.shuffle(toInsert);
            for (Integer integer : toInsert)
                tree.add(integer);

            nbInsert += tree.getCounter(op.INSERT);

            // Retrait de tous les élements dans un ordre aléatoire
            Collections.shuffle(toInsert);
            for (Integer integer : toInsert)
                tree.contains(integer);

            nbSearch += tree.getCounter(op.SEARCH);

            tree.reset();
        }

        System.out.println("\tNombre moyen d'appels de 'Tree.add' : " + (float) nbInsert/repeat);
        System.out.println("\tNombre moyen d'appels de 'Tree.contains' : " + (float) nbSearch/repeat);

    }
}
