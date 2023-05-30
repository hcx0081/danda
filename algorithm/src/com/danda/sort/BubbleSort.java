package com.danda.sort;

import java.util.Arrays;

/**
 * {@code @Description:}
 */
public class BubbleSort {
    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            int count = i + 1;
            System.out.println("第" + count + "次排序：" + Arrays.toString(arr));
        }
        return arr;
    }
    
    public static void main(String[] args) {
        bubbleSort(new int[]{4, 3, 2, 1});
        // 第1次排序：[3, 2, 1, 4]
        // 第2次排序：[2, 1, 3, 4]
        // 第3次排序：[1, 2, 3, 4]
    }
}