package com.danda.linear.list.linked.cycle;

/**
 * {@code @description:}
 */
public class Merge {
    static <T> CircularLinkedListTail<T> merge(CircularLinkedListTail<T> l1, CircularLinkedListTail<T> l2) {
        // 删除l2的头结点
        l2.head = l2.head.next;
        // l1连接l2
        l1.tail.next = l2.head;
        // l2连接l1
        l2.tail.next = l1.head;
        // 修改尾指针
        l1.tail = l2.tail;
        return l1;
    }
}