package com.danda.linear.list.sequence;

import java.util.Arrays;

/**
 * {@code @Description:}
 */
public class Main {
    public static void main(String[] args) {
        SequenceList<Integer> list = new SequenceList<>(16);
        list.add(1);
        list.add(2);
        System.out.println(list.get(0));
        System.out.println(Arrays.toString(list.eleArr));
    }
}