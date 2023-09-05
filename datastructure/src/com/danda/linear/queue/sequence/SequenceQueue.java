package com.danda.linear.queue.sequence;

import java.util.Iterator;

/**
 * {@code @description:} 顺序队列
 */
public class SequenceQueue<T> implements Iterable<T> {
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
    public SequenceQueue(int capacity) {
        this.eleArr = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
    }
    
    // 判空
    public boolean isEmpty() {
        return this.rear == 0;
    }
    
    public int size() {
        return this.rear;
    }
    
    // 入队
    public void enQueue(T item) {
        if (this.rear >= this.eleArr.length) {
            return;
        }
        this.eleArr[this.rear] = item;
        this.rear++;
    }
    
    // 出队
    public T deQueue() {
        if (isEmpty()) {
            return null;
        }
        T curr = this.eleArr[this.front];
        // 其余所有元素往前移动
        for (int i = 0; i < this.rear; i++) {
            if (i + 1 >= this.eleArr.length) {
                eleArr[i] = null;
            } else {
                eleArr[i] = eleArr[i + 1];
            }
        }
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