package com.danda.linear.list.linked.cycle;

import java.util.Iterator;

/**
 * {@code @description:}
 */
public class CircularLinkedList<T> implements Iterable<T> {
    // 头指针
    Node<T> head;
    int len;
    
    public CircularLinkedList() {
        // 头指针指向头结点
        this.head = new Node<>(null, this.head);
        this.len = 0;
    }
    
    // 插入元素
    public void add(T item) {
        Node<T> prev = this.head;
        while (prev.next != null) {
            prev = prev.next;
            // 如果当前结点是尾结点（尾结点的后一个结点是头结点）
            if (prev.next == this.head) {
                break;
            }
        }
        // 创建一个新结点
        Node<T> newNode = new Node<>(item, this.head);
        // 前一个结点指向新结点
        prev.next = newNode;
        len++;
    }
    
    // 删除指定索引位置的元素
    public Node<T> remove(int i) {
        Node<T> prev = this.head;
        for (int index = 0; index < i; index++) {
            prev = prev.next;
        }
        Node<T> curr = prev.next;
        prev.next = curr.next;
        // 如果当前结点是尾结点（尾结点的后一个结点是头结点）
        if (curr.next == this.head) {
            this.head = prev;
        }
        this.len--;
        return curr;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;
            
            @Override
            public boolean hasNext() {
                return node.next != null;
            }
            
            @Override
            public T next() {
                node = node.next;
                return node.data;
            }
        };
    }
    
    class Node<T> {
        T data;
        Node<T> next;
        
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}