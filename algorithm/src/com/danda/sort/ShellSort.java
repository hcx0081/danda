package com.danda.sort;

import java.util.Arrays;

/**
 * {@code @description:}
 */
public class ShellSort {
    static int[] shellSort(int[] arr) {
        for (int step = arr.length / 2; step >= 1; step = step / 2) {
            for (int i = step; i < arr.length; i++) {
                for (int j = i; j > 0; j -= step) {
                    if (j < step) {
                        continue;
                    }
                    if (arr[j] < arr[j - step]) {
                        int temp = arr[j - step];
                        arr[j - step] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shellSort(new int[]{9, 1, 2, 5, 7, 4, 8, 6, 3, 5})));
    }
}