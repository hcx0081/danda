package com.danda.search.tree;

/**
 * {@code @Description:}
 */
public class Main {
    public static void main(String[] args) {
        // BinarySearchTree.Node<Integer> n1 = new BinarySearchTree.Node<>(2, null, null);
        // BinarySearchTree.Node<Integer> n2 = new BinarySearchTree.Node<>(1, null, null);
        // BinarySearchTree.Node<Integer> n3 = new BinarySearchTree.Node<>(3, null, null);
        //
        // n1.left = n2;
        // n1.right = n3;
        //
        // BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        // tree.root = n1;

        BinarySearchTree<Integer> tree = new BinarySearchTree<>(2, 1, 3, 5);

        tree.layerErgodic();
    }
}