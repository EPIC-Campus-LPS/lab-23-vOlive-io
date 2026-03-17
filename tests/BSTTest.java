import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    @org.junit.jupiter.api.Test
    void add() {
        BST<Integer> tree = new BST<>();
        tree.add(1);
        assertEquals(true, tree.contains(1));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        BST<Integer> tree = new BST<>();
        tree.add(5);
        tree.add(2);
        tree.add(9);
        tree.add(4);
        tree.add(3);
        tree.add(1);
        tree.add(8);
        tree.add(6);
        tree.add(10);
        tree.add(7);
        assertEquals(false, tree.contains(0));
        assertEquals(true, tree.contains(1));
        assertEquals(true, tree.contains(5));
        assertEquals(true, tree.contains(10));
        assertEquals(false, tree.contains(15));

    }

    @org.junit.jupiter.api.Test
    void countNodes() {
        BST<Integer> tree = new BST<>();
        tree.add(5);
        tree.add(2);
        tree.add(9);
        tree.add(4);
        tree.add(3);
        tree.add(1);
        tree.add(8);
        tree.add(6);
        tree.add(10);
        tree.add(7);
        assertEquals(10, tree.countNodes());
    }

    @org.junit.jupiter.api.Test
    void countLeafNodes() {
        BST<Integer> tree = new BST<>();
        tree.add(5);
        tree.add(2);
        tree.add(9);
        tree.add(4);
        tree.add(3);
        tree.add(1);
        tree.add(8);
        tree.add(6);
        tree.add(10);
        tree.add(7);
        assertEquals(4, tree.countLeafNodes());

    }

    @org.junit.jupiter.api.Test
    void getHeight() {
        BST<Integer> tree = new BST<>();
        tree.add(5);
        tree.add(2);
        tree.add(9);
        tree.add(4);
        tree.add(3);
        tree.add(1);
        tree.add(8);
        tree.add(6);
        tree.add(10);
        tree.add(7);
        System.out.println("");
        tree.printPreorder();
        System.out.println("");
        assertEquals(4, tree.getHeight());
    }

    @org.junit.jupiter.api.Test
    void delete() {
        BST<Integer> tree = new BST<>();
        tree.add(5);
        tree.add(2);
        tree.add(9);
        tree.add(4);
        tree.add(3);
        tree.add(1);
        tree.add(8);
        tree.add(6);
        tree.add(10);
        tree.add(7);
        assertEquals(10, tree.delete(10));
        assertEquals(9, tree.countNodes());
    }

    @org.junit.jupiter.api.Test
    void findMin() {
        BST<Integer> tree = new BST<>();
        tree.add(5);
        tree.add(2);
        tree.add(9);
        tree.add(4);
        tree.add(3);
        tree.add(1);
        tree.add(8);
        tree.add(6);
        tree.add(10);
        tree.add(7);
        assertEquals(1, tree.findMin());
    }

    @org.junit.jupiter.api.Test
    void findMax() {
        BST<Integer> tree = new BST<>();
        tree.add(5);
        tree.add(2);
        tree.add(9);
        tree.add(4);
        tree.add(3);
        tree.add(1);
        tree.add(8);
        tree.add(6);
        tree.add(10);
        tree.add(7);
        assertEquals(10, tree.findMax());
    }

    @org.junit.jupiter.api.Test
    void saveToFile() {
        BST<Integer> tree = new BST<>();
        tree.add(5);
        tree.add(2);
        tree.add(9);
        tree.add(4);
        tree.add(3);
        tree.add(1);
        tree.add(8);
        tree.add(6);
        tree.add(10);
        tree.add(7);
        tree.saveToFile("treeTest");
        File f = new File("treeTest");
        assertEquals(true, f.isFile());
    }
    @org.junit.jupiter.api.Test
    void getFromFile() throws FileNotFoundException {
        BST<Integer> tree = new BST<>();
        File f = new File("treeTest");
        tree.getFromFile(f);
        assertEquals("5 2 1 4 3 9 8 6 7 10 ", tree.getPreorder(null, null));
    }
}