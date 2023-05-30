package com.danda.linear.list.linked.oneway;

/**
 * {@code @Description:}
 */
public class Main {
    public static void main(String[] args) {
        OneWayLinkedList<Integer> list = new OneWayLinkedList<>();
        list.add(1);
        list.add(2);
        list.remove(0);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}