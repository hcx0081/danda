package com.danda.nonlinear.tree;

/**
 * {@code @Description:} 孩子兄弟法
 */
public class ChildSiblingTree<T> {
    Node<T> node;
    int len;
    
    public ChildSiblingTree() {
        this.node = null;
        this.len = 0;
    }
    
    class Node<T> {
        T data;
        // 存储第一个孩子结点的存储位置
        Node<T> firstchild;
        // 存储下一个兄弟结点的存储位置
        Node<T> nextsibing;
    }
}