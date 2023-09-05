package com.danda.linear.list.linked.twoway;

/**
 * {@code @description:}
 */
public class Main {
    public static void main(String[] args) {
        TwoWayLinkedList<Integer> list = new TwoWayLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.indexOf(2));
        // for (Integer integer : list) {
        //     System.out.println(integer);
        // }
    }
}