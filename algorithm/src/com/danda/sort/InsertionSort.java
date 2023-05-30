package com.danda.sort;

import java.util.Arrays;

/**
 * {@code @Description:}
 */
public class InsertionSort {
    static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{4, 3, 2, 1})));
    }
}