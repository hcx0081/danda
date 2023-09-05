package com.danda.recursion;

/**
 * {@code {@code @description:}} 计算阶乘
 */
public class Factorial {
    public static void main(String[] args) {
        int result = factorial(3);
        System.out.println(result);
    }
    
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}