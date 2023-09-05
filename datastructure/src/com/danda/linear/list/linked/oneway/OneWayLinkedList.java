package com.danda.linear.list.linked.oneway;

import java.util.Iterator;

/**
 * {@code @description:} 单向链表
 */
public class OneWayLinkedList<T> implements Iterable<T> {
    // 头指针
    Node<T> head;
    int len;
    
    public OneWayLinkedList() {
        // 头指针指向头结点
        this.head = new Node<>(null, null);
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
    
    // 插入元素到最后（尾插法）
    public void add(T item) {
        Node<T> curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        // 创建一个新结点
        Node<T> newNode = new Node<>(item, null);
        // 前一个结点指向新节点
        curr.next = newNode;
        this.len++;
    }
    
    // 插入元素到最前（头插法）
    public void reAdd(T item) {
        // 创建一个新结点
        Node<T> newNode = new Node<>(item, null);
        // 新结点指向头结点的后一个结点
        newNode.next = this.head.next;
        // 头结点指向新结点
        this.head.next = newNode;
        this.len++;
    }
    
    // 在指定索引位置插入元素
    public void add(int i, T item) {
        Node<T> prev = head;
        // 找到指定索引位置的结点的前一个结点
        for (int index = 0; index < i; index++) {
            prev = prev.next;
        }
        // 创建一个新结点
        Node<T> newNode = new Node<>(item, null);
        // 新结点指向后一个结点
        newNode.next = prev.next;
        // 前一个结点指向新节点
        prev.next = newNode;
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
        // 前一个结点的后一个结点直接指向要删除的结点的后一个结点
        prev.next = curr.next;
        this.len--;
        return curr.data;
    }
    
    // 获取指定索引位置的元素
    public T get(int i) {
        Node<T> prev = this.head.next;
        for (int index = 0; index < i; index++) {
            prev = prev.next;
        }
        return prev.data;
    }
    
    // 查找指定元素第一次出现的索引位置
    public int indexOf(T item) {
        Node<T> prev = this.head.next;
        int index = 0;
        while (prev != null) {
            if (prev.data.equals(item)) {
                return index;
            }
            prev = prev.next;
            index++;
        }
        return -1;
    }
    
    // 反转链表
    public OneWayLinkedList<T> reverse() {
        OneWayLinkedList<T> newList = new OneWayLinkedList<>();
        
        Node<T> prev = this.head.next;
        while (prev != null) {
            // 头插法
            newList.reAdd(prev.data);
            
            prev = prev.next;
        }
        return newList;
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
        // 数据域
        T data;
        // 指针域
        Node<T> next;
        
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}