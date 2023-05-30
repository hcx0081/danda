package com.danda.sort;

import java.util.Arrays;

/**
 * {@code @Description:}
 */
public class SelectionSort {
    static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            
            int count = i + 1;
            System.out.println("第" + count + "次排序：" + Arrays.toString(arr));
        }
        return arr;
    }
    
    public static void main(String[] args) {
        selectionSort(new int[]{4, 3, 2, 1});
    }
}