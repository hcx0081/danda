package com.danda.linear.stack.linked;

import java.util.Iterator;

/**
 * {@code @Description:} 链栈
 */
public class LinkedStack<T> implements Iterable<T> {
    // 栈顶指针
    Node<T> top;
    int len;
    
    public LinkedStack() {
        this.top = null;
        this.len = 0;
    }
    
    // 判空
    boolean isEmpty() {
        return this.len == 0;
    }
    
    int size() {
        return this.len;
    }
    
    void push(T item) {
        // 创建一个新结点
        Node<T> newNode = new Node<>(item, null);
        newNode.next = this.top;
        this.top = newNode;
        this.len++;
    }
    
    T pop() {
        if (isEmpty()) {
            return null;
        }
        Node<T> curr = this.top;
        this.top = curr.next;
        this.len--;
        return curr.data;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = top;
            
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
    
    private class Node<T> {
        T data;
        Node<T> next;
        
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}