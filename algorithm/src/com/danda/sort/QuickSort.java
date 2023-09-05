package com.danda.sort;

import java.util.Arrays;

/**
 * {@code @description:}
 */
public class QuickSort {
    static void quickSort(int[] arr) {
        int lowIndex = 0;
        int highIndex = arr.length - 1;
        
        sort(arr, lowIndex, highIndex);
    }
    
    static void sort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex > highIndex) {
            return;
        }
        
        int index = group(arr, lowIndex, highIndex);
        
        // 排序左子序列
        sort(arr, lowIndex, index - 1);
        // 排序右子序列
        sort(arr, index + 1, highIndex);
    }
    
    
    static int group(int[] arr, int lowIndex, int highIndex) {
        // 定义分界元素的索引
        int elIndex = lowIndex;
        int el = arr[lowIndex];
        
        int left = lowIndex - 1;
        int right = highIndex + 1;
        
        while (left < right) {
            while (true) {
                if (left >= right || right <= lowIndex) {
                    break;
                }
                if (arr[--right] < el) {
                    arr[elIndex] = arr[right];
                    arr[right] = el;
                    elIndex = right;
                    break;
                }
            }
            
            
            while (true) {
                if (left >= right || left >= highIndex) {
                    break;
                }
                if (arr[++left] > el) {
                    
                    arr[elIndex] = arr[left];
                    arr[left] = el;
                    elIndex = left;
                    break;
                }
            }
        }
        
        System.out.println(right);
        System.out.println(Arrays.toString(arr));
        
        return right;
    }
    
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 3, 4, 5, 8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}