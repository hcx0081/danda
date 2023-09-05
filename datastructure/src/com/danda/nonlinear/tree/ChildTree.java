package com.danda.nonlinear.tree;

/**
 * {@code @description:} 孩子表示法
 */
public class ChildTree<T> {
    ParentNode<T>[] parentNodeArr;
    int len;
    
    public ChildTree(int capacity) {
        this.parentNodeArr = new ParentNode[capacity];
        this.len = 0;
    }
    
    class ParentNode<T> {
        T data;
        // 存储第一个孩子结点的存储位置
        ChildNode<T> firstchild;
        // 存储双亲结点的索引位置
        int parent;
    }
    
    class ChildNode<T> {
        // 存储当前孩子结点的索引位置
        int child;
        // 存储下一个兄弟结点的存储位置
        ChildNode<T> next;
    }
}