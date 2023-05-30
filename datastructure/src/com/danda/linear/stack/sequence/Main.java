package com.danda.linear.stack.sequence;

/**
 * {@code @Description:}
 */
public class Main {
    public static void main(String[] args) {
        SequenceStack<Integer> stack = new SequenceStack<>(1);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}