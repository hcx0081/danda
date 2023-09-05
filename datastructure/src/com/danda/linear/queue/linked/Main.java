package com.danda.linear.queue.linked;

/**
 * {@code @description:}
 */
public class Main {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        
        // for (Integer integer : queue) {
        //     System.out.println(integer);
        // }
    }
}