import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    @org.junit.jupiter.api.Test
    void add() {
        BST<Integer> tree = new BST<>();
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(5);
        tree.printInorder();
        assertEquals(true, tree.contains(1));
    }

    @org.junit.jupiter.api.Test
    void contains() {
    }

    @org.junit.jupiter.api.Test
    void countNodes() {
    }

    @org.junit.jupiter.api.Test
    void countLeafNodes() {
    }

    @org.junit.jupiter.api.Test
    void printInorder() {
    }

    @org.junit.jupiter.api.Test
    void printPreorder() {
    }

    @org.junit.jupiter.api.Test
    void printPostorder() {
    }

    @org.junit.jupiter.api.Test
    void getHeight() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }
}