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

    public boolean contains(E value) {
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

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(TreeNode node) {
        if((node.getLeftChild() == null) && (node.getRightChild() == null)) {
            return 1;
        }
        else if(node.getLeftChild() == null) {
            return 1 + countNodes(node.getRightChild());
        }
        else if(node.getRightChild() == null) {
            return 1 + countNodes(node.getLeftChild());
        }
        return 1 + countNodes(node.getLeftChild()) + countNodes(node.getLeftChild());
    }

    int countLeafNodes() {
        return countLeafNodes(root);
    }

    private int countLeafNodes(TreeNode node) {
        if((node.getLeftChild() == null) && (node.getRightChild() == null)) {
            return 1;
        }
        else if(node.getLeftChild() == null) {
            return countLeafNodes(node.getRightChild());
        }
        else if(node.getRightChild() == null) {
            return countLeafNodes(node.getLeftChild());
        }
        return countLeafNodes(node.getLeftChild()) + countLeafNodes(node.getLeftChild());
    }

    public void printInorder() {
        if(root.getLeftChild() != null) {
            printInorder(root.getLeftChild());
        }
        System.out.print(root.getValue());
        if(root.getRightChild() != null) {
            printInorder(root.getRightChild());
        }
    }
    private void printInorder(TreeNode node) {
        if(node.getLeftChild() != null) {
            printInorder(node.getLeftChild());
        }
        System.out.print(node.getValue());
        if(node.getRightChild() != null) {
            printInorder(node.getRightChild());
        }
    }

    public void printPreorder() {
        System.out.print(root.getValue());
        if(root.getLeftChild() != null) {
            printPreorder(root.getLeftChild());
        }
        if(root.getRightChild() != null) {
            printPreorder(root.getRightChild());
        }
    }
    private void printPreorder(TreeNode node) {
        System.out.print(node.getValue());
        if(node.getLeftChild() != null) {
            printPreorder(node.getLeftChild());
        }
        if(node.getRightChild() != null) {
            printPreorder(node.getRightChild());
        }
    }

    public void printPostorder() {
        if(root.getLeftChild() != null) {
            printPostorder(root.getLeftChild());
        }
        if(root.getRightChild() != null) {
            printPostorder(root.getRightChild());
        }
        System.out.print(root.getValue());

    }
    private void printPostorder(TreeNode node) {
        if(node.getLeftChild() != null) {
            printPostorder(node.getLeftChild());
        }
        if(node.getRightChild() != null) {
            printPostorder(node.getRightChild());
        }
        System.out.print(node.getValue());
    }


    //UNFINISHED

    int getHeight() //returns the longest path from the root to a leaf node

    E delete(E value) //returns the deleted node

}
