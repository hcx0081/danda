package com.danda.sort;

import java.util.Arrays;

/**
 * {@code @description:}
 */
public class MergingSort {
    // 定义辅助数组
    static int[] ass;
    
    // 第一次分解
    static void mergingSort(int[] arr) {
        int lowIndex = 0;
        int highIndex = arr.length - 1;
        
        sort(arr, lowIndex, highIndex);
    }
    
    static void sort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex == highIndex) {
            return;
        }
        int midIndex = (lowIndex + highIndex) / 2;
        
        sort(arr, lowIndex, midIndex);
        sort(arr, midIndex + 1, highIndex);
        
        // System.out.println(lowIndex + "-" + highIndex);
        merge(arr, lowIndex, midIndex, highIndex);
    }
    
    static void merge(int[] arr, int lowIndex, int midIndex, int highIndex) {
        // 定义三个指针
        int p1 = lowIndex;
        int p2 = midIndex + 1;
        int t = lowIndex;
        
        while (p1 <= midIndex && p2 <= highIndex) {
            if (arr[p1] < arr[p2]) {
                ass[t++] = arr[p1++];
            } else {
                ass[t++] = arr[p2++];
            }
        }
        while (p1 <= midIndex) {
            ass[t++] = arr[p1++];
        }
        while (p2 <= highIndex) {
            ass[t++] = arr[p2++];
        }
        
        
        // 拷贝到原数组
        for (int i = lowIndex; i <= highIndex; i++) {
            arr[i] = ass[i];
        }
        System.out.println(Arrays.toString(ass) + "-" + highIndex);
        
    }
    
    public static void main(String[] args) {
        int[] arr = {7, 5, 2, 4, 1, 6, 3, 0};
        ass = new int[arr.length];
        mergingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}