package mutils;

import java.util.ArrayList;

public class BinarySearchTree {

    // instance variable
    public Node root;

    // constructor for initialise the root to null BYDEFAULT
    public BinarySearchTree() {
        this.root = null;
    }

    // method to get size
    public int size(Node root) {
        if (root == null) return 0;
        return size(root.left) + size(root.right) + 1;
    }

    // method to get key
    public int get(Node root, String key) {
        if (root == null) return -1;

        if (root.data.compareTo(key) > 0) {
            // if current root data is greater than the new data then now process the left sub-tree
            return get(root.left, key);
        } else if (root.data.compareTo(key) < 0) {
            // if current root data is less than the new data then now process the right sub-tree
            return get(root.right, key);
        } else return root.freq;
    }

    // insert method to insert the new node
    public void insert(Node new_node) {
        this.root = insert(root, new_node);
    }

    public Node insert(Node root, Node new_node) {
        // Base Case: root is null or not
        if (root == null) {
            // Insert the new data, if root is null.
            root = new_node;
            // return the current root to his sub tree
            return root;
        }
        // Here checking for root data is greater or equal to newData or not
        else if (root.compareTo(new_node) > 0) {
            // if current root data is greater than the new data then now process the left sub-tree
            root.left = insert(root.left, new_node);
        } else if (root.compareTo(new_node) < 0) {
            // if current root data is less than the new data then now process the right sub-tree
            root.right = insert(root.right, new_node);
        } else {
            new_node.left = root.left;
            new_node.right = root.right;
            root = new_node;
        }
        return root;
    }

    //Traversal
    public void getKeysInorder(ArrayList<String> list) {
        getKeysInorder(list, root);
    }

    public ArrayList<String> getKeysInorder(ArrayList<String> list, Node root) {
        if (root == null) {
            return list;
        }
        getKeysInorder(list, root.left);
        list.add(root.data);
        getKeysInorder(list, root.right);
        return list;
    }

    /*
    public static void main(String[] args) {
        // Creating the object of BinarySearchTree class
        BinarySearchTree bst = new BinarySearchTree();
        // call the method insert
        bst.insert(new Node("abef", 1));
        bst.insert(new Node("abd", 1));
        bst.insert(new Node("abee", 1));
        bst.insert(new Node("f", 1));
        bst.insert(new Node("a", 1));
        bst.insert(new Node("bce", 1));
        bst.inorder();
    }*/
}