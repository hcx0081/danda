package com.danda.linear.list.linked.twoway;

import java.util.Iterator;

/**
 * {@code @description:} 双向链表
 */
public class TwoWayLinkedList<T> implements Iterable<T> {
    // 头指针
    Node<T> head;
    int len;
    
    public TwoWayLinkedList() {
        // 头指针指向头结点
        this.head = new Node<>(null, null, null);
        this.len = 0;
    }
    
    // 清空
    public void clear() {
        this.head.next = null;
        this.len = 0;
    }
    
    // 判空
    public boolean isEmpty() {
        return this.len == 0;
    }
    
    // 获取长度
    public int length() {
        return this.len;
    }
    
    // 插入元素到最后
    public void add(T item) {
        Node<T> prev = this.head;
        while (prev.next != null) {
            prev = prev.next;
        }
        // 创建一个新结点
        Node<T> newNode = new Node<>(item, null, null);
        newNode.prior = prev;
        prev.next = newNode;
        // /* 如果链表为空 */
        // if (isEmpty()) {
        //     // 创建一个新结点
        //     Node<T> newNode = new Node<>(item, null, null);
        //     // 前一个结点的后一个结点指向新结点
        //     this.head.next = newNode;
        //     // 新结点的前一个结点指向前一个结点
        //     newNode.prior = head;
        //     // 新结点成为尾结点
        //     this.tail = newNode;
        // }
        // /* 如果链表不为空 */
        // else {
        //     // 创建一个新结点，前一个结点指向尾结点
        //     Node<T> newNode = new Node<>(item, tail, null);
        //     // 原来的尾结点的后一个结点指向新结点
        //     this.tail.next = newNode;
        //     // 新结点成为尾结点
        //     this.tail = newNode;
        // }
        this.len++;
    }
    
    // 在指定索引位置插入元素
    public void add(int i, T item) {
        Node<T> prev = this.head;
        for (int index = 0; index < i; index++) {
            prev = prev.next;
        }
        Node<T> next = prev.next;
        // 创建一个新结点，前一个结点指向prev，后一个结点指向next
        Node<T> newNode = new Node<>(item, prev, next);
        prev.next = newNode;
        next.prior = newNode;
        
        this.len++;
    }
    
    // 删除指定索引位置的元素
    public T remove(int i) {
        Node<T> prev = this.head;
        // 找到指定索引位置的结点的前一个结点
        for (int index = 0; index < i; index++) {
            prev = prev.next;
        }
        // 要删除的结点
        Node<T> curr = prev.next;
        // 要删除的结点的后一个结点
        Node<T> next = curr.next;
        prev.next = next;
        next.prior = prev;
        this.len--;
        return curr.data;
    }
    
    // 获取第一个元素
    public T getFirst() {
        return isEmpty() ? null : this.head.next.data;
    }
    
    // 获取指定索引位置的结点
    public T get(int i) {
        Node<T> prev = this.head.next;
        for (int index = 0; index < i; index++) {
            prev = prev.next;
        }
        return prev.data;
    }
    
    // 查找指定元素第一次出现的索引位置
    public int indexOf(T item) {
        Node<T> curr = this.head;
        int index = 0;
        while (curr.next != null) {
            curr = curr.next;
            if (curr.data.equals(item)) {
                return index;
            }
            index++;
        }
        return -1;
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
        Node<T> prior;
        Node<T> next;
        
        public Node(T data, Node<T> prior, Node<T> next) {
            this.data = data;
            this.prior = prior;
            this.next = next;
        }
    }
}