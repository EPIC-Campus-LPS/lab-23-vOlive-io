import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;

    /**
     * Creates a new Binary Search Tree object
     */
    public BST() {
        root = new TreeNode (null, null, null);
    }

    /**
     * Add a new node to the tree
     * @param value the value in the node to be added to the tree
     */
    public void add(E value) {
        TreeNode<E> temp = root;
        boolean cont = true;
        while(cont) {
            if(temp.getValue() == null) {
                temp.setValue(value);
                cont = false;
            } else {
                if(temp.getValue().compareTo(value) >= 0) {
                    if (temp.getLeftChild() != null) {
                        temp = temp.getLeftChild();
                    } else {
                        temp.setLeftChild(new TreeNode(value, null, null));
                        cont = false;
                    }
                } else {
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

    /**
     * Adds a node to the tree
     * @param node the node to add
     */
    public void add(TreeNode node) {
        TreeNode<E> temp = root;
        boolean cont = true;
        while(cont) {
            if(temp.getValue() == null) {
                temp.setValue((E) node.getValue());
                temp.setLeftChild(node.getLeftChild());
                temp.setRightChild(node.getRightChild());
                cont = false;
            } else {
                if(temp.getValue().compareTo((E) node.getValue()) >= 0) {
                    if (temp.getLeftChild() != null) {
                        temp = temp.getLeftChild();
                    } else {
                        temp.setLeftChild(new TreeNode(node.getValue(), node.getLeftChild(), node.getRightChild()));
                        cont = false;
                    }
                } else {
                    if(temp.getRightChild() != null) {
                        temp = temp.getRightChild();
                    } else {
                        temp.setLeftChild(new TreeNode(node.getValue(), node.getLeftChild(), node.getRightChild()));
                        cont = false;
                    }
                }
            }
        }
    }

    /**
     * Searches the tree to see if a value is contained
     * @param value The value to search for
     * @return true if value is found, false otherwise
     */
    public boolean contains(E value) {
        TreeNode<E> temp = root;
        while(true) {
            if (temp.getValue() == null) {
                System.out.print("null");
                return false;
            } else {
                if (temp.getValue().compareTo(value) == 0) {
                    return true;
                } else if (temp.getValue().compareTo(value) > 0) {
                    if (temp.getLeftChild() == null) {
                        System.out.print("left child null");
                        return false;
                    } else {
                        temp = temp.getLeftChild();
                    }
                } else {
                    if (temp.getRightChild() == null) {
                        System.out.print("right child null");
                        return false;
                    } else {
                        temp = temp.getRightChild();
                    }
                }
            }
        }
    }

    /**
     * Counts the total nodes in the tree
     * @return the number of nodes in the tree
     */
    public int countNodes() {
        return countNodes(root);
    }

    /**
     * Recursively counts the total nodes in the tree
     * @param node the node to count from, recursively
     * @return recursively the number of nodes in the tree
     */
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
        return 1 + countNodes(node.getLeftChild()) + countNodes(node.getRightChild());
    }

    /**
     * Counts the number of leaf nodes on the tree
     * @return the number of leaf nodes
     */
    public int countLeafNodes() {
        return countLeafNodes(root);
    }

    /**
     * Recursively counts the number of leaf nodes on the tree
     * @param node the node to count down from, recursively
     * @return recursively the number of leaf node
     */
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
        return countLeafNodes(node.getLeftChild()) + countLeafNodes(node.getRightChild());
    }

    /**
     * Prints the Binary Search Tree Inorder
     */
    public void printInorder() {
        if(root.getLeftChild() != null) {
            printInorder(root.getLeftChild());
        }
        System.out.print(root.getValue());
        if(root.getRightChild() != null) {
            printInorder(root.getRightChild());
        }
    }

    /**
     * Recursively prints the Binary Search Tree Inorder
     * @param node The node to print out from, recursively
     */
    private void printInorder(TreeNode node) {
        if(node.getLeftChild() != null) {
            printInorder(node.getLeftChild());
        }
        System.out.print(node.getValue());
        if(node.getRightChild() != null) {
            printInorder(node.getRightChild());
        }
    }

    /**
     * Prints the Binary Search Tree Preorder
     */
    public void printPreorder() {
        System.out.print(root.getValue());
        if(root.getLeftChild() != null) {
            printPreorder(root.getLeftChild());
        }
        if(root.getRightChild() != null) {
            printPreorder(root.getRightChild());
        }
    }

    /**
     * Recursively prints the Binary Search Tree Preorder
     * @param node The node to print out from, recursively
     */
    private void printPreorder(TreeNode node) {
        System.out.print(node.getValue());
        if(node.getLeftChild() != null) {
            printPreorder(node.getLeftChild());
        }
        if(node.getRightChild() != null) {
            printPreorder(node.getRightChild());
        }
    }

    /**
     * Recursively finds the Binary Search Tree Preorder
     * @param node The node to search/gather out from, recursively
     */
    public String getPreorder(TreeNode node, String pre) {
        if((node == null) && (pre == null)) {
            node = root;
            pre = "";
        }
        pre += "" + node.getValue() + " ";
        if(node.getLeftChild() != null) {
            pre = getPreorder(node.getLeftChild(), pre);
        }
        if(node.getRightChild() != null) {
            pre = getPreorder(node.getRightChild(), pre);
        }
        return pre;
    }

    /**
     * Prints the Binary Search Tree Postorder
     */
    public void printPostorder() {
        if(root.getLeftChild() != null) {
            printPostorder(root.getLeftChild());
        }
        if(root.getRightChild() != null) {
            printPostorder(root.getRightChild());
        }
        System.out.print(root.getValue());

    }

    /**
     * Recursively prints the Binary Search Tree Postorder
     * @param node The node to print out from, recursively
     */
    private void printPostorder(TreeNode node) {
        if(node.getLeftChild() != null) {
            printPostorder(node.getLeftChild());
        }
        if(node.getRightChild() != null) {
            printPostorder(node.getRightChild());
        }
        System.out.print(node.getValue());
    }

    /**
     * Deletes the specified node
     * * @param value the value of the node to remove
     * @return the removed node
     */
    public E delete(E value) {
        TreeNode<E> temp = root;
        TreeNode<E> saved = root;
        while(true) {
            E v = temp.getValue();
            if (v == null) {
                return null;
            } else {
                if(v.compareTo(value) > 0) {
                    saved = temp.getLeftChild();
                    if(saved == null) {
                        return null;
                    }
                    if (saved.getValue().compareTo(value) == 0) {
                        int c = getNodes(saved);
                        if (c == 0) {
                            v = saved.getValue();
                            temp.setLeftChild(null);
                            return v;
                        } else if (c == 1) {
                            v = saved.getValue();
                            if (saved.getLeftChild() != null) {
                                temp.setLeftChild(saved.getLeftChild());
                            } else {
                                temp.setLeftChild(saved.getRightChild());
                            }
                            return v;
                        } else if (c == 2) {
                            v = saved.getValue();
                            temp.setLeftChild(saved.getLeftChild());
                            add(saved.getRightChild());
                            return v;
                        } else {
                            return null;
                        }
                    } else {
                        temp = temp.getLeftChild();
                    }
                } else if(v.compareTo(value) < 0) {
                    saved = temp.getRightChild();
                    if(saved == null) {
                        return null;
                    }
                    if (saved.getValue().compareTo(value) == 0) {
                        int c = getNodes(saved);
                        if (c == 0) {
                            v = saved.getValue();
                            temp.setRightChild(null);
                            return v;
                        } else if (c == 1) {
                            v = saved.getValue();
                            if (saved.getLeftChild() != null) {
                                temp.setRightChild(saved.getLeftChild());
                            } else {
                                temp.setRightChild(saved.getRightChild());
                            }
                            return v;
                        } else if (c == 2) {
                            v = saved.getValue();
                            temp.setRightChild(saved.getLeftChild());
                            add(saved.getRightChild());
                            return v;
                        } else {
                            return null;
                        }
                    } else {
                        temp = temp.getRightChild();
                    }
                }
            }
        }
    }

    /**
     * Gets the number of children
     * @param temp the node to check
     * @return number of children nodes
     */
    private int getNodes(TreeNode temp) {
        if ((temp.getLeftChild() == null) && (temp.getRightChild() == null)) {
            return 0;
        }
        if(!((temp.getLeftChild() == null) && (temp.getRightChild() == null)) && (temp.getLeftChild() == null) || (temp.getRightChild() == null)) {
            return 1;
        }
        if((temp.getLeftChild() != null) && (temp.getRightChild() != null)) {
            return 2;
        }
        return -1;
    }

    /**
     * Gets the largest value in the tree of the tree
     * @return The largest value of the tree
     */
    public E findMax() {
        TreeNode<E> temp = root;
        while(true) {
            if(temp.getValue() == null) {
                return null;
            }
            if(temp.getRightChild() == null) {
                return temp.getValue();
            }
            temp = temp.getRightChild();
        }
    }

    /**
     * Gets the smallest value in the tree of the tree
     * @return The smallest value of the tree
     */
    public E findMin() {
        TreeNode<E> temp = root;
        while(true) {
            if(temp.getValue() == null) {
                return null;
            }
            if(temp.getLeftChild() == null) {
                return temp.getValue();
            }
            temp = temp.getLeftChild();
        }
    }

    /**
     * Saves the BST's preorder to a file, so it can be recreated
     * @param fileName the name of the file to create/edit
     * @return the file object
     */
    public File saveToFile(String fileName) {
        File file = new File(fileName);
        try {
            FileWriter savedContent = new FileWriter(file);
            String content = getPreorder(root, "");
            savedContent.write(content);
            savedContent.close();
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a tree based off of the file provided
     * @param f the file to provide
     * @throws FileNotFoundException if the file is nto valid
     */
    public void getFromFile(File f) throws FileNotFoundException {
        Scanner scan = new Scanner(f);
        String contents = scan.nextLine();
        String[] newTree = contents.split(" ");
        root = new TreeNode(null, null, null);
        for(String s : newTree) {
            Integer value = Integer.parseInt(s);
            add((E) value);
        }
    }

    /**
     * Gets the height of the tree by finding the highest depth value
     * @return The height of the tree
     */
    public int getHeight() {
        return getHeight(root);
    }

    /**
     * Recursively finds the height of the tree
     * @param node The node to traverse down from
     * @return The height of the tree
     */
    private int getHeight(TreeNode<E> node) {
        if(node == null) return 0;
        return 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
    }

    /**
     * Checks to see if the tree is balanced
     * @return if the tree is balanced
     */
    public boolean isBalanced() {
        return isBalanced(true, root);
    }

    /**
     * The recursive carryout of isBalanced
     * @param balance if the tree is balanced
     * @param node node to check
     * @return if the tree is balanced
     */
    private boolean isBalanced(boolean balance, TreeNode node) {
        if((node == null) || (node.getValue() == null)) return balance;
        balance = balance && (isBalanced(balance, node.getLeftChild()));
        balance = balance && (isBalanced(balance, node.getRightChild()));
        balance = balance && (getBalanceFactor(node));
        return balance;
    }

    /**
     * Check the balance factor of a node
     * @param node the node to check
     * @return the balance factor of the node
     */
    private boolean getBalanceFactor(TreeNode node) {
        int ba = (getHeight(node.getLeftChild()) - getHeight(node.getRightChild()));
        System.out.println(node.getValue() + " : " + ba + " : " + ((ba >= -1) && (ba <= 1)));
        return ((ba >= -1) && (ba <= 1));
    }
}