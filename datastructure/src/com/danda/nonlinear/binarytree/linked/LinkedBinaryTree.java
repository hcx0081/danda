package com.danda.nonlinear.binarytree.linked;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * {@code @Description:}
 */
public class LinkedBinaryTree<T> {
    // 根结点
    Node<T> root;
    
    public LinkedBinaryTree() {
        this.root = null;
    }
    
    // 前序遍历
    public void preErgodic() {
        preErgodic(this.root);
    }
    
    public void preErgodic(Node<T> node) {
        if (node == null) {
            return;
        }
        // 访问根结点
        System.out.println(node.data);
        preErgodic(node.left);
        preErgodic(node.right);
    }
    
    // 中序遍历
    public void midErgodic() {
        midErgodic(this.root);
    }
    
    private void midErgodic(Node<T> node) {
        if (node == null) {
            return;
        }
        midErgodic(node.left);
        // 访问根结点
        System.out.println(node.data);
        midErgodic(node.right);
    }
    
    // 后序遍历
    public void postErgodic() {
        postErgodic(this.root);
    }
    
    private void postErgodic(Node<T> node) {
        if (node == null) {
            return;
        }
        postErgodic(node.left);
        postErgodic(node.right);
        // 访问根结点
        System.out.println(node.data);
    }
    
    // 前序遍历
    public void preErgodicByStack() {
        Stack<Node<T>> stack = new Stack<>();
        preErgodicByStack(this.root, stack);
    }
    
    private void preErgodicByStack(Node<T> node, Stack<Node<T>> stack) {
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                // 访问根结点
                System.out.println(node.data);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }
    
    // 中序遍历
    public void midErgodicByStack() {
        Stack<Node<T>> stack = new Stack<>();
        midErgodicByStack(this.root, stack);
    }
    
    private void midErgodicByStack(Node<T> node, Stack<Node<T>> stack) {
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                // 访问根结点
                System.out.println(node.data);
                node = node.right;
            }
        }
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
    
    // 复制
    public LinkedBinaryTree<T> copy() {
        if (this.root == null) {
            return null;
        }
        // 创建根结点
        LinkedBinaryTree<T> tree = new LinkedBinaryTree<>();
        tree.root = new Node<>(this.root.data, null, null);
        
        // 复制左子树
        tree.root.left = copy(this.root.left);
        // 复制右子树
        tree.root.right = copy(this.root.right);
        
        return tree;
    }
    
    private Node<T> copy(Node<T> node) {
        if (node == null) {
            return null;
        }
        Node<T> newNode = new Node<>(node.data, null, null);
        // 复制左结点
        newNode.left = copy(node.left);
        // 复制右结点
        newNode.right = copy(node.right);
        return newNode;
    }
    
    // 计算最大深度
    public int maxDepth() {
        return maxDepth(this.root);
    }
    
    private int maxDepth(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int max;
        int maxL = 0;
        int maxR = 0;
        
        if (node.left != null) {
            maxL = maxDepth(node.left);
        }
        if (node.right != null) {
            maxR = maxDepth(node.right);
        }
        max = maxL > maxR ? maxL + 1 : maxR + 1;// 加1是为了加上根结点
        return max;
    }
    
    // 计算结点数
    public int nodeCount() {
        return nodeCount(this.root);
    }
    
    private int nodeCount(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int countL;
        int countR;
        
        countL = nodeCount(node.left);
        countR = nodeCount(node.right);
        return countL + countR + 1;// 加1是为了加上根结点
    }
    
    // 计算叶子结点数
    public int leavesNodeCount() {
        return leavesNodeCount(this.root);
    }
    
    private int leavesNodeCount(Node<T> node) {
        if (node == null) {
            return 0;
        }
        int countL;
        int countR;
        if (node.left == null && node.right == null) {
            return 1;
        }
        countL = leavesNodeCount(node.left);
        countR = leavesNodeCount(node.right);
        return countL + countR;
    }
    
    static class Node<T> {
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