package com.danda.linear.queue.linked;

import java.util.Iterator;

/**
 * {@code @description:} 链队列
 */
public class LinkedQueue<T> implements Iterable<T> {
    // 队头指针
    Node<T> front;
    // 队尾指针
    Node<T> rear;
    int len;
    
    public LinkedQueue() {
        // 创建一个头结点
        this.front = new Node<>(null, null);
        this.rear = this.front;
        this.len = 0;
    }
    
    // 清空
    public void clear() {
        this.front = null;
        this.rear = this.front;
    }
    
    // 判空
    public boolean isEmpty() {
        return this.len == 0;
    }
    
    public int size() {
        return this.len;
    }
    
    // 入队
    public void enQueue(T item) {
        // 创建一个新结点
        Node<T> newNode = new Node<>(item, null);
        this.rear.next = newNode;
        this.rear = newNode;
        this.len++;
    }
    
    // 出队
    public T deQueue() {
        if (isEmpty()) {
            return null;
        }
        Node<T> curr = this.front.next;
        this.front.next = curr.next;
        this.len--;
        return curr.data;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = front;
            
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