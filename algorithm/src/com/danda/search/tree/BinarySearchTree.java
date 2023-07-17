package com.danda.search.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * {@code @Description:} 二叉查找树
 */
public class BinarySearchTree<T extends Comparable<T>> {
    // 根结点
    Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(T... keys) {
        this.root = new Node<>(keys[0], null, null);

        for (int i = 1; i < keys.length; i++) {
            insert(keys[i]);
        }
    }

    // 查找
    public void search(T key) {
        search(this.root, key);
    }

    private void search(Node<T> node, T key) {
        if (node == null) {
            System.out.println("未找到目标元素");
            return;
        }
        if (key.compareTo(node.data) == 0) {
            System.out.println(node.data);
        }
        // 如果目标元素大于根结点的值
        else if (key.compareTo(node.data) > 0) {
            search(node.right, key);
        }
        // 如果目标元素小于根结点的值
        else {
            search(node.left, key);
        }
    }

    // 插入
    public void insert(T key) {
        if (this.root == null) {
            this.root = new Node<>(key, null, null);
        } else {
            insert(this.root, key);
        }
    }

    private Node<T> insert(Node<T> node, T key) {
        if (node == null) {
            return new Node<>(key, null, null);
        }
        if (key.compareTo(node.data) == 0) {
            System.out.println("目标元素已经存在");
        }
        // 如果目标元素大于根结点的值
        else if (key.compareTo(node.data) > 0) {
            node.right = insert(node.right, key);
        }
        // 如果目标元素小于根结点的值
        else {
            node.left = insert(node.left, key);
        }
        return node;
    }

    // 层序遍历
    public void layerErgodic() {
        // 创建队列
        LinkedList<Node<T>> queue = new LinkedList<>();
        layerErgodic(this.root, queue);
    }

    private void layerErgodic(Node<T> root, Queue<Node<T>> queue) {
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            System.out.println(node.data);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    static class Node<T extends Comparable<T>> {
        T data;
        // 左结点
        Node<T> left;
        // 右结点
        Node<T> right;

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}