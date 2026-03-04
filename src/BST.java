public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;

    public BST() {
        root = new TreeNode (null, null, null)
    }

    public void add(E value) {
        TreeNode<E> temp = root;
        boolean cont = true;
        while(cont) {
            if(temp.getValue() == null) {
                temp.setValue(value);
                cont = false;
            } else {
                if(temp.getValue().compareTo(value) <= 0) {
                    if (temp.getLeftChild() != null) {
                        temp = temp.getLeftChild();
                    } else {
                        temp.setLeftChild(new TreeNode(value, null, null));
                        cont = false;
                    }
                } else{
                    if(temp.getRightChild() != null) {
                        temp = temp.getRightChild();
                    } else {
                        temp.setRightChild(new TreeNode(value, null, null));
                        cont = false;
                    }
                }
            }
        }
    }

    boolean contains(E value) {
        TreeNode<E> temp = root;
        while(true) {
            if (temp.getValue() == null) {
                return false;
            } else {
                if (temp.getValue().compareTo(value) == 0) {
                    return true;
                } else if (temp.getValue().compareTo(value) < 0) {
                    if (temp.getLeftChild() != null) {
                        return false;
                    } else {
                        temp = temp.getLeftChild();
                    }
                } else {
                    if (temp.getRightChild() != null) {
                        return false;
                    } else {
                        temp = temp.getRightChild();
                    }
                }
            }
        }
    }

    int countNodes() //returns the number of nodes in the tree
    int countLeafNodes() //returns the number of leaf nodes in tree
    int getHeight() //returns the longest path from the root to a leaf node
    void printInorder()
    void printPreorder()
    void printPostorder()
    E delete(E value) //returns the deleted node

}
