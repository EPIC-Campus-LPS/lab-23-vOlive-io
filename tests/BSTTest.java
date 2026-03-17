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
        tree.printPreorder();
        System.out.println("");
        tree.printPostorder();
        assertEquals(10, tree.delete(10));
        assertEquals(9, tree.countNodes());
    }
}