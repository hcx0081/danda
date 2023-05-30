package com.danda.linear.stack.sequence;

import java.util.Iterator;

/**
 * {@code @Description:} 顺序栈
 */
public class SequenceStack<T> implements Iterable<T> {
    // 存储元素的数组
    public T[] eleArr;
    // 栈顶指针
    int top;
    
    /**
     * 初始化
     *
     * @param capacity 初始化容量
     */
    public SequenceStack(int capacity) {
        this.eleArr = (T[]) new Object[capacity];
        this.top = 0;
    }
    
    // 清空
    public void clear() {
        this.eleArr = (T[]) new Object[this.eleArr.length];
        this.top = 0;
    }
    
    // 判空
    boolean isEmpty() {
        return this.top == 0;
    }
    
    // 判满
    boolean isFull() {
        return this.top == this.eleArr.length;
    }
    
    int size() {
        return this.top;
    }
    
    void push(T item) {
        if (isFull()) {
            return;
        }
        this.eleArr[this.top] = item;
        this.top++;
    }
    
    T pop() {
        if (isEmpty()) {
            return null;
        }
        T pop = this.eleArr[this.top - 1];
        this.eleArr[this.top - 1] = null;
        this.top--;
        return pop;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor = 0;
            
            @Override
            public boolean hasNext() {
                return this.cursor < top;
            }
            
            @Override
            public T next() {
                return eleArr[cursor++];
            }
        };
    }
}