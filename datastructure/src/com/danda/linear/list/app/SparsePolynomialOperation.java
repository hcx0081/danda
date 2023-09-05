package com.danda.linear.list.app;

import java.util.Iterator;

/**
 * {@code @description:} 一元稀疏多项式运算：实现两个多项式加、减、乘运算
 * 稀疏多项式具有很多系数为0的项，此时如果使用顺序表存储，存储空间分配不太灵活，并且运算的空间复杂度高，所以建议使用链表存储
 * P_n(x) = p_0x^e0 + p_1x^e1 + p_2x^e2 + ... + p_nx^en
 * 线性表：P=((p_0, e1), (p_1, e2), (p_2, e3)...(p_n, en))存储每一项的系数和其指数
 * 换句话说：链表存储每一项的系数和其指数
 */
public class SparsePolynomialOperation {
    /*
     * 假设：
     * P_a(x) = 7 + 3x + 9x^8 + 5x^17
     * P_b(x) = 8x + 22x^7 - 9x^8
     *  */
    
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.add(7, 0);
        l1.add(3, 1);
        l1.add(9, 8);
        l1.add(5, 17);
        LinkedList l2 = new LinkedList();
        l2.add(8, 1);
        l2.add(22, 7);
        l2.add(-9, 8);
        
        LinkedList list = l1.add(l2);
        for (String s : list) {
            System.out.println(s);
        }
    }
    
    
    static class LinkedList implements Iterable<String> {
        // 头指针
        Node head;
        int len;
        
        public LinkedList() {
            // 创建头结点，头指针指向头结点
            this.head = new Node(null, null, null);
            this.len = 0;
        }
        
        public Integer length() {
            return this.len;
        }
        
        public void add(Integer coe, Integer index) {
            Node prev = this.head;
            while (prev.next != null) {
                prev = prev.next;
            }
            // 创建一个新结点
            Node newNode = new Node(coe, index, null);
            prev.next = newNode;
            this.len++;
        }
        
        public void add(int i, Integer coe, Integer index) {
            Node prev = this.head;
            for (int in = 0; in < i; in++) {
                prev = prev.next;
            }
            // 创建一个新结点
            Node newNode = new Node(coe, index, null);
            // 新结点指向后一个结点
            newNode.next = prev.next;
            // 前一个结点指向新节点
            prev.next = newNode;
            this.len++;
        }
        
        public LinkedList add(LinkedList l2) {
            LinkedList list = new LinkedList();
            Node curr1 = this.head.next;
            Node curr2 = l2.head.next;
            
            while (curr2 != null) {
                // 如果指数相同
                if (curr2.index == curr1.index) {
                    // 系数相加
                    int sum = curr1.coe + curr2.coe;
                    if (sum != 0) {
                        list.add(curr1.coe + curr2.coe, curr2.index);
                    }
                    curr1 = curr1.next;
                    curr2 = curr2.next;
                    continue;
                }
                if (curr2.index < curr1.index) {
                    list.add(curr2.coe, curr2.index);
                    curr2 = curr2.next;
                    continue;
                }
                if (curr2.index > curr1.index) {
                    list.add(curr1.coe, curr1.index);
                    curr1 = curr1.next;
                    continue;
                }
            }
            while (curr1 != null) {
                list.add(curr1.coe, curr1.index);
                curr1 = curr1.next;
            }
            return list;
        }
        
        @Override
        public Iterator<String> iterator() {
            return new Iterator<String>() {
                Node node = head;
                
                @Override
                public boolean hasNext() {
                    return node.next != null;
                }
                
                @Override
                public String next() {
                    node = node.next;
                    return "系数：" + node.coe + "\t指数：" + node.index;
                }
            };
        }
        
        class Node {
            // 系数
            Integer coe;
            // 指数
            Integer index;
            Node next;
            
            public Node(Integer coe, Integer index, Node next) {
                this.coe = coe;
                this.index = index;
                this.next = next;
            }
        }
    }
}