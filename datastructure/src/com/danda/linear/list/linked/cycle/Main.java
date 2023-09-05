package com.danda.linear.list.linked.cycle;

/**
 * {@code @description:}
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CircularLinkedListTail<Integer> list1 = new CircularLinkedListTail<>();
        CircularLinkedListTail<Integer> list2 = new CircularLinkedListTail<>();
        // CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list1.add(1);
        list1.add(2);
        list2.add(3);
        list2.add(4);
        CircularLinkedListTail<Integer> merge = Merge.merge(list1, list2);
        for (Integer integer : merge) {
            System.out.println(integer);
            
            Thread.sleep(1000);
        }
    }
}