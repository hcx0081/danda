package com.danda.nonlinear.binarytree.linked;

/**
 * {@code @Description:}
 */
public class Main {
    public static void main(String[] args) {
        // LinkedBinaryTree<Integer, String> tree = new LinkedBinaryTree<>();
        // tree.put(2, "zs");
        // tree.put(1, "ls");
        // tree.put(3, "ls");
        // tree.put(6, "ls");
        // tree.put(4, "ls");
        // // System.out.println(tree.size());
        // // System.out.println(tree.get(1));
        // // System.out.println(tree.min());
        // // System.out.println(tree.max());
        //
        //
        // // CircularSequenceQueue<Integer> queue = tree.layerErgodic();
        // // for (Integer integer : queue) {
        // //     System.out.println(integer);
        // // }
        //
        //
        // System.out.println(tree.maxDepth());
        
        LinkedBinaryTree.Node<Integer> root = new LinkedBinaryTree.Node<>(1, null, null);
        LinkedBinaryTree.Node<Integer> n1 = new LinkedBinaryTree.Node<>(2, null, null);
        LinkedBinaryTree.Node<Integer> n2 = new LinkedBinaryTree.Node<>(3, null, null);
        LinkedBinaryTree.Node<Integer> n3 = new LinkedBinaryTree.Node<>(4, null, null);
        LinkedBinaryTree.Node<Integer> n4 = new LinkedBinaryTree.Node<>(5, null, null);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        tree.root = root;
        
        System.out.println(tree.leavesNodeCount());
    }
}