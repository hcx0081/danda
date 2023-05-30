package com.danda.linear.list.sequence;

import java.util.Iterator;

/**
 * {@code @Description:}
 */
public class SequenceList<T> implements Iterable<T> {
    // 存储元素的数组
    public T[] eleArr;
    // 元素个数
    int len;
    
    /**
     * 初始化
     *
     * @param capacity 初始化容量
     */
    public SequenceList(int capacity) {
        this.eleArr = (T[]) new Object[capacity];
        this.len = 0;
    }
    
    // 清空
    public void clear() {
        this.eleArr = (T[]) new Object[eleArr.length];
        this.len = 0;
    }
    
    // 判空
    public boolean inEmpty() {
        return this.len == 0;
    }
    
    // 获取长度
    public int length() {
        return this.len;
    }
    
    // 插入元素到最后
    public void add(T ele) {
        // 扩大容量
        if (this.len >= this.eleArr.length) {
            resize(this.eleArr.length * 2);
        }
        
        this.eleArr[len++] = ele;
    }
    
    // 在指定索引位置插入元素
    public void add(int i, T ele) {
        // 扩大容量
        if (this.len >= this.eleArr.length) {
            resize(this.eleArr.length * 2);
        }
        
        // 指定索引位置开始的元素向后移动
        for (int index = this.len; index > i; index--) {
            this.eleArr[index] = this.eleArr[index - 1];
        }
        this.eleArr[i] = ele;
        this.len++;
    }
    
    // 删除指定索引位置的元素
    public T remove(int i) {
        // 缩小容量
        if (this.len <= this.eleArr.length / 4) {
            resize(this.eleArr.length / 2);
        }
        
        T el = this.eleArr[i];
        // 指定索引位置开始的元素向前移动
        for (int index = i; index < this.len; index++) {
            this.eleArr[index] = this.eleArr[index + 1];
        }
        this.len--;
        return el;
    }
    
    // 获取指定索引位置的元素
    public T get(int i) {
        return this.eleArr[i];
    }
    
    // 查找指定元素第一次出现的索引位置
    public int indexOf(T ele) {
        for (int i = 0; i < this.len; i++) {
            if (this.eleArr[i] == ele) {
                return i;
            }
        }
        return -1;
    }
    
    // 改变容量
    public void resize(int newCapacity) {
        // 创建一个缓存数组
        T[] temp = this.eleArr;
        // 创建一个新数组
        this.eleArr = (T[]) new Object[newCapacity];
        for (int i = 0; i < this.len; i++) {
            this.eleArr[i] = temp[i];
        }
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor = 0;
            
            @Override
            public boolean hasNext() {
                return this.cursor < len;
            }
            
            @Override
            public T next() {
                return eleArr[cursor++];
            }
        };
    }
}