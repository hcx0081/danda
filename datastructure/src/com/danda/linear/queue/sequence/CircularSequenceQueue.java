package com.danda.linear.queue.sequence;

import java.util.Iterator;

/**
 * {@code @Description:} 循环顺序队列
 */
public class CircularSequenceQueue<T> implements Iterable<T> {
    // 队头指针
    int front;
    // 队尾指针
    int rear;
    T[] eleArr;
    
    /**
     * 初始化
     *
     * @param capacity 初始化容量
     */
    public CircularSequenceQueue(int capacity) {
        this.eleArr = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
    }
    
    // 判空
    public boolean isEmpty() {
        return this.front == this.rear;
    }
    
    // 判满
    boolean isFull() {
        return this.front == (this.rear + 1) % this.eleArr.length;
    }
    
    public int size() {
        return (this.rear - this.front + this.eleArr.length) % this.eleArr.length;
    }
    
    // 入队
    public void enQueue(T item) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        this.eleArr[this.rear] = item;
        this.rear = (this.rear + 1) % this.eleArr.length;
    }
    
    // 出队
    public T deQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return null;
        }
        T curr = this.eleArr[this.front];
        this.eleArr[this.front] = null;
        this.front = (this.front + 1) % this.eleArr.length;
        return curr;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor = 0;
            
            @Override
            public boolean hasNext() {
                return cursor < rear;
            }
            
            @Override
            public T next() {
                return eleArr[cursor++];
            }
        };
    }
}