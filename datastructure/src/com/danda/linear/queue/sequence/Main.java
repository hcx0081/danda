package com.danda.linear.queue.sequence;

/**
 * {@code @description:}
 */
public class Main {
    public static void main(String[] args) {
        // SequenceQueue<Integer> queue = new SequenceQueue<>(1);
        // queue.enQueue(1);
        // queue.enQueue(1);
        // queue.enQueue(1);
        // System.out.println(queue.deQueue());
        // System.out.println(queue.deQueue());
        
        
        CircularSequenceQueue<Integer> queue = new CircularSequenceQueue<>(3);
        queue.enQueue(1);
        queue.enQueue(1);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(1);
        queue.enQueue(1);
        System.out.println(queue.size());
    }
}