package com.danda.linear.list.linked.cycle;

import java.util.Iterator;

/**
 * {@code @Description:}
 */
public class CircularLinkedListTail<T> implements Iterable<T> {
    // 头指针
    Node<T> head;
    // 尾指针：指向尾结点
    Node<T> tail;
    int len;
    
    public CircularLinkedListTail() {
        // 头指针指向头结点
        this.head = new Node<>(null, this.head);
        // 尾指针指向头结点
        this.tail = head;
        this.len = 0;
    }
    
    // 插入元素
    public void add(T item) {
        // 创建一个新结点
        Node<T> newNode = new Node<>(item, null);
        newNode.next = this.head;
        this.tail.next = newNode;
        this.tail = newNode;
        this.len++;
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
            Node<T> node = tail.next;
            
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