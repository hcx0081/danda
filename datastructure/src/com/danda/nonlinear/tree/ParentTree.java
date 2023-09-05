package com.danda.nonlinear.tree;

/**
 * {@code @description:} 双亲表示法
 */
public class ParentTree<T> {
    Node<T>[] nodeArr;
    int len;
    
    public ParentTree(int capacity) {
        this.nodeArr = new Node[capacity];
        this.len = 0;
    }
    
    class Node<T> {
        T data;
        // 存储双亲结点的索引位置
        int parent;
    }
}